/*
Copyright (c) 2014 Tiziano Basile

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE
*/
package com.tizianobasile.androiddrawablefactory.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static double getAspectRatio(BufferedImage img, int newWidth, int newHeight)
	{
		
		int imgWidth = img.getWidth(null); 
		int imgHeight = img.getHeight(null);
		
		double xRatio = (double) newWidth / (double) imgWidth;
		double yRatio = (double) newHeight / (double) imgHeight;
		
		
		return Math.min(xRatio, yRatio);
	}
	
	public static Image resizeImage(BufferedImage bImg, int newWidth, int newHeight) throws FileNotFoundException, IOException
	{
		
		double ratio = getAspectRatio(bImg, newWidth, newHeight);
		newWidth = (int) (bImg.getWidth(null) * ratio);
		newHeight = (int) (bImg.getHeight(null) * ratio);
		
		Image resizedImage = bImg.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		
		return resizedImage;
	}
	
	public static int getMaxWidth(File img) throws FileNotFoundException, IOException
	{
		BufferedImage bImg= ImageIO.read(new FileInputStream(img));
		int width = bImg.getWidth();
		int height = bImg.getHeight();
		return Math.max(width, height);
	}
}
