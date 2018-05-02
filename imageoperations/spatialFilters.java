/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageoperations;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author maxkim
 */
public class spatialFilters {
    ImageOperations io;
    private int maskSize;
    private int srcImgWidth, srcImgHeight;
    // neighborPixels will store the intensities of neighbors
    private int[] neighborImg;
    // filterImg will store the pixels filtered, and is still 0-padded
    // paddedImg stores 0-padded pixels of the original image
    private int[][] paddedImg, filteredImgPadding;
    private int[][] filteredImgNoPadding;
    
    public spatialFilters() {
        io = new ImageOperations();
    }
    
    public BufferedImage applyLocalHistogram(BufferedImage bi, int maskSize, String newFileName) throws IOException {
        this.maskSize = maskSize;
        BufferedImage biGray, modifiedBi = null;
        int[][] biGrayArr = null;
        SampleModel sampleModel;
        Raster raster = null;

        // get the gray scale version of Lena image
        biGray = io.convertToGrayScale(bi);

        // get the pixels of the image by getting the raster of the image
        biGrayArr = io.imgTo2DArrPixel(biGray);

        // make zero-padded source image and the filtered image
        paddedImg = new int[biGrayArr.length + (maskSize - 1)][biGrayArr[0].length + (maskSize-1)];  
        filteredImgPadding = new int[biGrayArr.length + (maskSize - 1) ][biGrayArr[0].length + (maskSize - 1)];  
        
        neighborImg = new int[maskSize * maskSize];
        
        // raster coordinate is differnt from image coordinate!! width -> height
        filteredImgNoPadding = new int[biGrayArr.length][biGrayArr[0].length];
        

        // apply the 0-padding and save the pixels of the original image into paddedImg
        loadPixels(biGrayArr);        
        
        // apply the local histogram and save the filtered pixels into filteredImgPadding
        localHistogram(biGrayArr.length, biGrayArr[0].length);
        
        // fill the pixels without the padding into filterdImgNoPadding
        setFilteredImgNoPadding();
        
        modifiedBi = new BufferedImage(biGrayArr.length, biGrayArr[0].length, BufferedImage.TYPE_BYTE_GRAY);

        raster = modifiedBi.getData();
        sampleModel = raster.getSampleModel();

        // convert the pixel values of the filteredImgNoPadding into a bufferedImage
        modifiedBi = io.convertPixelToBufImg(filteredImgNoPadding, sampleModel);

        // write the bufferedImage into a file and save it
        io.writeFile(modifiedBi, newFileName);
        return null;
    }
    
    public BufferedImage applyAverageFilter2(BufferedImage bi, int maskSize, String newFileName) throws IOException {
        this.maskSize = maskSize;
        BufferedImage biGray, modifiedBi = null;
        int[][] biGrayArr = null;
        SampleModel sampleModel;
        Raster raster = null;

        // get the gray scale version of Lena image
        biGray = io.convertToGrayScale(bi);

        // get the pixels of the image by getting the raster of the image
        biGrayArr = io.imgTo2DArrPixel(biGray);

        // make zero-padded source image and the filtered image
        paddedImg = new int[biGrayArr.length + (maskSize - 1)][biGrayArr[0].length + (maskSize-1)];  
        filteredImgPadding = new int[biGrayArr.length + (maskSize - 1) ][biGrayArr[0].length + (maskSize - 1)];  
        
        neighborImg = new int[maskSize * maskSize];
        
        // raster coordinate is differnt from image coordinate!! width -> height
        filteredImgNoPadding = new int[biGrayArr.length][biGrayArr[0].length];
        

        // apply the 0-padding and save the pixels of the original image into paddedImg
        loadPixels(biGrayArr);        
        
        // apply the average filter and save the filtered pixels into filteredImgPadding
        averageFilter(biGrayArr.length, biGrayArr[0].length);
        
        // fill the pixels without the padding into filterdImgNoPadding
        setFilteredImgNoPadding();
        
        modifiedBi = new BufferedImage(biGrayArr.length, biGrayArr[0].length, BufferedImage.TYPE_BYTE_GRAY);

        raster = modifiedBi.getData();
        sampleModel = raster.getSampleModel();

        // convert the pixel values of the filteredImgNoPadding into a bufferedImage
        modifiedBi = io.convertPixelToBufImg(filteredImgNoPadding, sampleModel);

        // write the bufferedImage into a file and save it
        io.writeFile(modifiedBi, newFileName);
        return null;
    }
    
        public BufferedImage applyMedianFilter(BufferedImage bi, int maskSize, String newFileName) throws IOException {
        this.maskSize = maskSize;
        BufferedImage biGray, modifiedBi = null;
        int[][] biGrayArr = null;
        SampleModel sampleModel;
        Raster raster = null;

        // get the gray scale version of Lena image
        biGray = io.convertToGrayScale(bi);

        // get the pixels of the image by getting the raster of the image
        biGrayArr = io.imgTo2DArrPixel(biGray);

        // make zero-padded source image and the filtered image
        paddedImg = new int[biGrayArr.length + (maskSize - 1)][biGrayArr[0].length + (maskSize-1)];  
        filteredImgPadding = new int[biGrayArr.length + (maskSize - 1) ][biGrayArr[0].length + (maskSize - 1)];  
        
        neighborImg = new int[maskSize * maskSize];
        
        // raster coordinate is differnt from image coordinate!! width -> height
        filteredImgNoPadding = new int[biGrayArr.length][biGrayArr[0].length];
        

        // apply the 0-padding and save the pixels of the original image into paddedImg
        loadPixels(biGrayArr);        
        
        // apply the median filter and save the filtered pixels into filteredImgPadding
        medianFilter(biGrayArr.length, biGrayArr[0].length);
        
        // fill the pixels without the padding into filterdImgNoPadding
        setFilteredImgNoPadding();
        
        modifiedBi = new BufferedImage(biGrayArr.length, biGrayArr[0].length, BufferedImage.TYPE_BYTE_GRAY);

        raster = modifiedBi.getData();
        sampleModel = raster.getSampleModel();

        // convert the pixel values of the filteredImgNoPadding into a bufferedImage
        modifiedBi = io.convertPixelToBufImg(filteredImgNoPadding, sampleModel);

        // write the bufferedImage into a file and save it
        io.writeFile(modifiedBi, newFileName);
        return null;
    }
    
    /*
    public BufferedImage applyAverageFilter(BufferedImage srcImg, int maskSize) {
        // get the grayscale image of the source image
        BufferedImage newGrayImg = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        
        // get the pixels of the original image
        WritableRaster wr = srcImg.getRaster();
        
        // wrNewImg will have the filtered pixels
        WritableRaster wrNewImg = newGrayImg.getRaster();
        
        // get the source image size
        int numOfPixels = wr.getWidth() * wr.getHeight();
        
        // get the width and height!!
        srcImgWidth = wr.getWidth();
        srcImgHeight = wr.getHeight();
        
        // get the user-defined mask size
        this.maskSize = maskSize;
        
        // make zero-padded source image and the filtered image
        paddedImg = new int[srcImgHeight + (maskSize - 1)][srcImgWidth + (maskSize-1)];  
        filteredImgPadding = new int[srcImgHeight + (maskSize - 1) ][srcImgWidth + (maskSize - 1)];  
        
        // raster coordinate is differnt from image coordinate!! width -> height
        filteredImgNoPadding = new int[wr.getHeight()][wr.getWidth()];
        
        // load the pixels of the source image into paddedImg
        loadPixels(wr);
        
        // apply the average filter and save the filtered pixels into filteredImgPadding
        averageFilter();
        
        // fill the pixels without the padding into filterdImgNoPadding
        setFilteredImgNoPadding();
        
        // assign filtered pixels
        assignNewValues(wrNewImg);

        // assign the new image
        newGrayImg.setData(wrNewImg);

        return newGrayImg;
    }
*/
    // apply the 0-padding and save the pixels of the original image into paddedImg
    public void loadPixels(int[][] srcPixels) {
        //!! for (int i = 0; i < srcImgHeight + 1; i++) {
        for (int i = 0; i < srcPixels.length; i++) {
            // for (int i = 0; i < srcImgHeight + 1; i++) {
            for (int j = 0; j < srcPixels[0].length; j++) {
                // raster coordinate is different!!
                paddedImg[(maskSize/2)+i][(maskSize/2)+j] = srcPixels[i][j];
                //paddedImg[(maskSize/2)+i][(maskSize/2)+j] = wr.getSample(i, j, 0);
            }
        }
    }
    /*
    // apply the 0-padding and save the pixels of the original image
    public void loadPixels(WritableRaster wr) {
        //!! for (int i = 0; i < srcImgHeight + 1; i++) {
        for (int i = 0; i < srcImgWidth; i++) {
            // for (int i = 0; i < srcImgHeight + 1; i++) {
            for (int j = 0; j < srcImgHeight; j++) {
                // raster coordinate is different!!
                paddedImg[(maskSize/2)+i][(maskSize/2)+j] = wr.getSample(j, i, 0);
                //paddedImg[(maskSize/2)+i][(maskSize/2)+j] = wr.getSample(i, j, 0);
            }
        }
    }
*/
    
    // fill the new raster with filtered pixels
    public void assignNewValues(WritableRaster wr) {
        for (int i = 0; i < wr.getWidth(); i++) {
            for (int j = 0; j < wr.getHeight(); j++) {
                wr.setSample(i, j, 0, filteredImgNoPadding[i][j]);
            }
        }
    }

    // get the filtered image without the padding
    public void setFilteredImgNoPadding() {
        int row = filteredImgNoPadding.length;
        int col = filteredImgNoPadding[0].length;
        // fill the filtered pixels with the padding
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                filteredImgNoPadding[i][j] = filteredImgPadding[(maskSize/2) + i][(maskSize/2) + j];
            }
        }
    }
    
    // load the neighbor pixels into the neighborImg array
    public void loadNeighbors(int row, int col) {
        int index = 0;
        // get the neighbor pixels
        for (int i = -(maskSize / 2); i <= (maskSize / 2); i++) {  
            for (int j = -(maskSize / 2); j <= (maskSize / 2); j++) {  
                neighborImg[index++] = paddedImg[row + i][col + j];
            }
        }
    }
    
    // return the average grayscale pixel within the mask
    public int getAverage() {
        int sum = 0;
        for (int i = 0; i < neighborImg.length; i++) {
            sum += neighborImg[i];
        }
        return sum / neighborImg.length;
    }

    // return the median grayscale pixel within the mask
    public int getMedian() {
        int median = 0;
        // sort the array to get the median
        Arrays.sort(neighborImg);
        // get the median
        if (neighborImg.length % 2 == 0) {
            median = (neighborImg[neighborImg.length / 2] + neighborImg[neighborImg.length / 2 - 1]) / 2;
        } else {
            median = neighborImg[neighborImg.length / 2];
        }
        return median;
    }
    
    // return the local histogram value
    public int getLocalHistogram() {
        int localEqualized = 0;
        int[] histogram = new int[256];
        int[] cumulativeHist = new int[256];
        int[] newIntensity = new int[256];
        
        // make histogram
        for(int i = 0; i < neighborImg.length; i++){
                histogram[neighborImg[i]]++;
        }
        
        // make cumulative histogram
        cumulativeHist[0] = histogram[0];
        for (int i = 1; i < 256; i++) {
            cumulativeHist[i] = cumulativeHist[i - 1] + histogram [i];
        }
        
        // make new intensities
        for (int i = 0; i < 256; i++) {
            newIntensity[i] = (int)((cumulativeHist[i] / (float)(maskSize*maskSize)) * 255.0);
        }
        
        // return the local histogram equalized value
        return newIntensity[neighborImg[neighborImg.length/2]];
        
    }
    
    // apply the average filter on the image
    public void averageFilter(int row, int col) {
        for (int i = (maskSize / 2); i < (maskSize/2) + row; i++) {
            for (int j = (maskSize / 2); j < (maskSize/2) + col; j++) {
                // load the grayscale intensities of the neighbor pixels
                loadNeighbors(i, j);
                // save the filtered pixels
                filteredImgPadding[i][j] = getAverage();
            }
        }
    }

    // apply the median filter on the image
    public void medianFilter(int row, int col) {
        for (int i = (maskSize / 2); i < (maskSize/2) + row; i++) {
            for (int j = (maskSize / 2); j < (maskSize/2) + col; j++) {
                // load the grayscale intensities of the neighbor pixels
                loadNeighbors(i, j);
                // save the filtered pixels
                filteredImgPadding[i][j] = getMedian();
            }
        }
    }
    
    // apply local histogram on the image
        public void localHistogram(int row, int col) {
        for (int i = (maskSize / 2); i < (maskSize/2) + row; i++) {
            for (int j = (maskSize / 2); j < (maskSize/2) + col; j++) {
                // load the grayscale intensities of the neighbor pixels
                loadNeighbors(i, j);
                // save the filtered pixels
                filteredImgPadding[i][j] = getLocalHistogram();
            }
        }
    }
    
    // set the user-defined mask size
    public void setMaskSize(int maskSize) {
        this.maskSize = maskSize;
    }

    public void writeFile(BufferedImage bi, String name) {
        try {
            // wrtie it in the currnet directory
            File outputfile = new File(name);
            ImageIO.write(bi, "gif", outputfile);

            // write it in the src file 
            // File outputfile2 = new File(name);
            //ImageIO.write(bi, "gif", outputfile2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
