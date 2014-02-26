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
		catch(UnsupportedLookAndFeelException e){e.printStackTrace();}
                catch(ClassNotFoundException e){e.printStackTrace();}
                catch(InstantiationException e){e.printStackTrace();}
                catch(IllegalAccessException e){e.printStackTrace();}
	}
}
