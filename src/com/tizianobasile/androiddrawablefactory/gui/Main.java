package com.tizianobasile.androiddrawablefactory.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

public class Main extends JFrame{

	//constants
	public static final String[] DENSITIES = {"ldpi", "mdpi", "hdpi", "xhdpi", "xxhdpi", "xxxhdpi"};
	public static final double[] DENSITY_MULTIPLIERS = {.75, 1, 1.5, 2, 3, 4};
	
	//Instance parameters
	JLabel imageCanvas; //canvas that store the image to modify
	JFileChooser imageChooser, projectPathChooser; //JFileChooser for the source image and project path
	JTextField projectPathField, sourceSizeTextField; //fields to store projectPath and source image size
	JButton projectPathButton, createButton; //Buttons to open the path chooser and to start drawables conversion
	JLabel sourceDensityLabel, sourceSizeLabel; //labels for source density and source size fields
	JComboBox sourceDensityComboBox; //list of available densities
	JCheckBox[] densitiesCheckBox; //array that stores the available density checkboxes
	JPanel mainPanel, densitiesPanel; //panel containing checkboxes
	
	
	public Main()
	{
		super("Main Window");
		initUI(); //initialize ui elements
		initListeners(); //initialize ui event listeners
	}
	
	private void initUI()
	{
		//create components
		imageCanvas = new JLabel(); //image to be used
		imageCanvas.setIcon(new ImageIcon(getClass().getResource("placeholder.png")));
		imageCanvas.setBackground(Color.decode("#33B5E5"));
		imageCanvas.setBorder(BorderFactory.createLineBorder(Color.black));
		projectPathChooser = new JFileChooser(); //Launch directory selection
		projectPathField = new JTextField(); //Retains  the path selected with JFileChooser
		projectPathField.setText("project path");
		projectPathButton = new JButton("Browse"); //Button that launch JFileChooser
		sourceDensityLabel = new JLabel("Source Density"); //Label for the source density field
		sourceDensityComboBox = new JComboBox(DENSITIES); //selector for the source density
		sourceSizeLabel = new JLabel("Source Size"); //Label for source image's size
		sourceSizeTextField = new JTextField("48"); //Field for source image's size
		densitiesCheckBox = new JCheckBox[DENSITIES.length]; //checkbox array with densities
		createButton = new JButton("make"); //button to begin drawable conversion
		densitiesPanel = new JPanel();
		//initialize checkboxes
		for(int i = 0; i < DENSITIES.length; i++)
		{
			densitiesCheckBox[i] = new JCheckBox(DENSITIES[i]);
			densitiesCheckBox[i].setSelected(true);
			densitiesPanel.add(densitiesCheckBox[i]);
		}
		densitiesPanel.add(createButton);
		
		//create and set LayoutManager
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		mainPanel = new JPanel();
		GroupLayout gp = new GroupLayout(mainPanel);
		gp.setAutoCreateContainerGaps(true);
		gp.setAutoCreateGaps(true);
		mainPanel.setLayout(gp);
		//set alignment criteria
		GroupLayout.Alignment hAlign = GroupLayout.Alignment.TRAILING;
		GroupLayout.Alignment vAlign = GroupLayout.Alignment.BASELINE;

		//add component into layout
		//set horizontal group
		gp.setHorizontalGroup(gp.createSequentialGroup()
				.addGroup(gp.createParallelGroup(hAlign)
						.addComponent(imageCanvas, 80, 80, 80))
				.addGroup(gp.createParallelGroup(hAlign)
						.addComponent(projectPathField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
						//.addComponent(projectPathField)
						.addComponent(sourceDensityLabel, Alignment.LEADING)
						.addComponent(sourceSizeLabel, Alignment.LEADING))
				.addGroup(gp.createParallelGroup(hAlign)
						.addComponent(projectPathButton)
						.addComponent(sourceDensityComboBox,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sourceSizeTextField,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 50))
						);
		
		//set vertical group
		gp.setVerticalGroup(gp.createSequentialGroup()
				.addGroup(gp.createParallelGroup(vAlign)
						.addComponent(imageCanvas, 80, 80, 80)
				.addGroup(gp.createSequentialGroup()
						.addGroup(gp.createParallelGroup(vAlign)
								.addComponent(projectPathField)
								.addComponent(projectPathButton))
						.addGroup(gp.createParallelGroup(vAlign)
								.addComponent(sourceDensityLabel)
								.addComponent(sourceDensityComboBox))
						.addGroup(gp.createParallelGroup(vAlign)
								.addComponent(sourceSizeLabel)
								.addComponent(sourceSizeTextField)))
						)
				);
		this.add(mainPanel);
		this.add(densitiesPanel);
	}

	private void initListeners()
	{
		imageCanvas.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event)
			{
				imageChooser = new JFileChooser();
				imageChooser.setDialogTitle("Select an image");
				imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				imageChooser.setFileFilter(new FileFilter(){

					@Override
					public boolean accept(File file) {
						if(file.getName().endsWith(".jpg") ||
								file.getName().endsWith(".png") || file.isDirectory())
						{
							return true;
						}
						else return false;
					}

					@Override
					public String getDescription() {
						return "Images (.jpg;.png)";
					}
					
				});
				imageChooser.setAcceptAllFileFilterUsed(false);
				switch(imageChooser.showOpenDialog(imageCanvas))
				{
					case(JFileChooser.APPROVE_OPTION):
						
						System.out.println(imageChooser.getSelectedFile());
						break;
					case(JFileChooser.CANCEL_OPTION):
						
						break;
					case(JFileChooser.ERROR_OPTION):
						break;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
}
