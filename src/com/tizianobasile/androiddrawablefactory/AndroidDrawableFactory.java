package com.tizianobasile.androiddrawablefactory;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.tizianobasile.androiddrawablefactory.gui.Main;

public class AndroidDrawableFactory {
	//constants
	public static final String[] DENSITIES = {"ldpi", "mdpi", "hdpi", "xhdpi", "xxhdpi", "xxxhdpi"};
	public static final double[] DENSITY_MULTIPLIERS = {.75, 1, 1.5, 2, 3, 4};
	public static void main(String... args)
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		}
		catch(UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e){e.printStackTrace();}
		Main mainWindow = new Main();
		mainWindow.pack();
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}
}
