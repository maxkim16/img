/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageoperations;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author maxkim
 */
public class HstEqual {
    
    public BufferedImage hstEqualizationGray(BufferedImage srcImg) {
        BufferedImage newGrayImg = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = srcImg.getRaster();
        WritableRaster wrNewImg = newGrayImg.getRaster();
        int numOfPixels = wr.getWidth() * wr.getHeight();
        int[] histogram = new int[256];
        int[] cumulativeHist = new int[256];
        int[] newIntensity = new int[256];

        // make histogram (nk)
        makeHist(histogram, wr);

        // make cumulative histogram (probability)
        makeCumulativeHist(histogram, cumulativeHist, wr);

        // amp each intensity to their corresponding new intensity
        makeNewIntensity(newIntensity, histogram, cumulativeHist, numOfPixels);

        // assign new intensites
        assignNewValues(wr, wrNewImg, newIntensity, numOfPixels);

        // assign the new image
        newGrayImg.setData(wrNewImg);

        return newGrayImg;
    }
    
    // make new intensity values
    public void makeNewIntensity(int[] newIntensity, int[] histogram, int[] cumulativeHist, int numOfPixels) {
        for (int i = 0; i < 256; i++) {
            newIntensity[i] = (int)((cumulativeHist[i] / (float)numOfPixels) * 255.0);
        }
    }

    // map the original intensities to the new intensities
    public void assignNewValues(WritableRaster wr, WritableRaster wrNewImg, int[] ni, int numOfPixels) {
        for (int i = 0; i < wr.getWidth(); i++) {
            for( int j = 0; j < wr.getHeight(); j++) {
                wrNewImg.setSample(i, j, 0, ni[wr.getSample(i, j, 0)]);
            }
        }
    }

    // make histogram
    public void makeHist(int[] hist, WritableRaster wr) {
        // histogram = nk, the distribution of the grayscale intensities 
        // ex) if the image has 3 77 intensities, histogram[77] = 3
        for (int i = 0; i < wr.getWidth(); i++) {
            for (int j = 0; j < wr.getHeight(); j++) {
                hist[wr.getSample(i, j, 0)]++;
            }
        }
    }
    
    // make cumulative histogram based on the histogram, calculating the probability
    public void makeCumulativeHist(int[] hs, int[] ch, WritableRaster wr) {
        // make the cumulative histogram
        ch[0] = hs[0];
        for (int i = 1; i < 256; i++) {
            ch[i] = ch[i - 1] + hs[i];
        }
    }
    
        
    
    public static void main(String[] args) throws Exception {
        String oriFile = "2.gif";
        String newFile = "new222223.gif";
        HstEqual hstEqu = new HstEqual();
        ImageOperations io = new ImageOperations();
        BufferedImage srcImg, newImg;
        srcImg = io.loadImage(oriFile);
        
        newImg = hstEqu.hstEqualizationGray(srcImg);   
        
        io.writeFile(newImg, newFile);
        io.displayLeft(oriFile);
        io.display(newFile);
    }
    
}



