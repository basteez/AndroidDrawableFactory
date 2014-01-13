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
