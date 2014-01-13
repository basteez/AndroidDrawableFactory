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
		initLaF();
		Main mainWindow = new Main();
		mainWindow.pack();
		mainWindow.setTitle("Android Drawable Factory");
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}
	
	private static void initLaF()
	{
		UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
		try
		{
			boolean hasGTK = false;
			for(UIManager.LookAndFeelInfo info : lafs)
			{
				if(info.getName().equals("GTK+"))
				{
					hasGTK = true;
					break;
				}
			}
			if(hasGTK)
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			}
			else
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e){e.printStackTrace();}
	}
}
