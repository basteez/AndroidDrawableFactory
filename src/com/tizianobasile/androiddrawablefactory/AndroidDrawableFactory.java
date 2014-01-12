package com.tizianobasile.androiddrawablefactory;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.tizianobasile.androiddrawablefactory.gui.Main;

public class AndroidDrawableFactory {
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
