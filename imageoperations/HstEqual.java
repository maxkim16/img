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
    
    public BufferedImage getGrayscaleImage(BufferedImage src) {
        BufferedImage gImg = new BufferedImage(src.getWidth(), src.getHeight(),
        BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = src.getRaster();
        WritableRaster gr = gImg.getRaster();
        for (int i = 0; i < wr.getWidth(); i++) {
            for (int j = 0; j < wr.getHeight(); j++) {
                gr.setSample(i, j, 0, wr.getSample(i, j, 0));
            }
        }
        gImg.setData(gr);
        return gImg;
    }
    
    public BufferedImage hstEqualizationGray(BufferedImage srcImg) {
        BufferedImage newGrayImg = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = srcImg.getRaster();
        WritableRaster wrNewImg = newGrayImg.getRaster();
        int numOfPixels = wr.getWidth() * wr.getHeight();
        int[] histogram = new int[256];
        int[] cumulativeHist = new int[256];
        int[] newIntensity = new int[256];

        // make histogram 
        makeHist(histogram, wr);

        // make cumulative histogram
        makeCumulativeHist(histogram, cumulativeHist, wr);

        // amp each intensity to their corresponding new intensity
        makeNewIntensity(newIntensity, histogram, cumulativeHist, numOfPixels);

        // assign new intensites
        assignNewValues(wr, wrNewImg, newIntensity, numOfPixels);

        // assign the new image
        newGrayImg.setData(wrNewImg);

        return newGrayImg;
    }


    
    
    public void makeNewIntensity(int[] newIntensity, int[] histogram, int[] cumulativeHist, int numOfPixels) {
        for (int i = 0; i < 256; i++) {
            newIntensity[i] = (int)((cumulativeHist[i] / (float)numOfPixels) * 255.0);
        }
    }

    public void assignNewValues(WritableRaster wr, WritableRaster wrNewImg, int[] ni, int numOfPixels) {
        for (int i = 0; i < wr.getWidth(); i++) {
            for( int j = 0; j < wr.getHeight(); j++) {
                wrNewImg.setSample(i, j, 0, ni[wr.getSample(i, j, 0)]);
            }
        }
    }

    public void makeHist(int[] hist, WritableRaster wr) {
        // histogram = nk, the distribution of the grayscale intensities 
        // ex) if the image has 3 77 intensities, histogram[77] = 3
        for (int i = 0; i < wr.getWidth(); i++) {
            for (int j = 0; j < wr.getHeight(); j++) {
                hist[wr.getSample(i, j, 0)]++;
            }
        }
    }
    
    public void makeCumulativeHist(int[] hs, int[] ch, WritableRaster wr) {
        // make the cumulative histogram
        ch[0] = hs[0];
        for (int i = 1; i < 256; i++) {
            ch[i] = ch[i - 1] + hs[i];
        }
    }
    
        public BufferedImage equalize(BufferedImage src) {
        BufferedImage nImg = new BufferedImage(src.getWidth(), src.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = src.getRaster();
        WritableRaster er = nImg.getRaster();
        int totpix = wr.getWidth() * wr.getHeight();
        int[] histogram = new int[256];

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                histogram[wr.getSample(x, y, 0)]++;
            }
        }

        int[] chistogram = new int[256];
        chistogram[0] = histogram[0];
        for (int i = 1; i < 256; i++) {
            chistogram[i] = chistogram[i - 1] + histogram[i];
        }

        float[] arr = new float[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = (float) ((chistogram[i] * 255.0) / (float) totpix);
        }

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                int nVal = (int) arr[wr.getSample(x, y, 0)];
                er.setSample(x, y, 0, nVal);
            }
        }
        nImg.setData(er);
        return nImg;
    }
    
    
    public static void main(String[] args) throws Exception {
        String oriFile = "2.gif";
        String newFile = "new222223.gif";
        HstEqual hstEqu = new HstEqual();
        ImageOperations io = new ImageOperations();
        BufferedImage srcImg, newImg;
        srcImg = io.loadImage(oriFile);
        
        newImg = hstEqu.hstEqualizationGray(srcImg);   
        //newImg = hstEqu.equalize(srcImg);     
        
        io.writeFile(newImg, newFile);
        io.displayLeft(oriFile);
        io.display(newFile);
    }
    
}



