package com.test.maven.htest;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.event.*;

public class tracker extends JFrame 
implements ActionListener{

	 

	public JFrame button = null;
	private JPanel contentPane;
	private JTextField searchBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					tracker frame = new tracker();
					frame.setVisible(true);
					frame.setSize(1000, 750);
					frame.setTitle("HearthStone Helper");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				     
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public tracker() {
		//base 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//reset default icon
		ImageIcon logoicon = new ImageIcon("unnamed.png");
		Image logo = logoicon.getImage();
		setIconImage(logo);
		setResizable(false);
		
		setContentPane(contentPane);
		getContentPane().setBackground(Color.black);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][grow][][][grow][][grow]", "[][][][][grow][grow]"));
		Component horizontalStrut = Box.createHorizontalStrut(20);
		contentPane.add(horizontalStrut, "cell 0 0 12 2");
		
		searchBox = new JTextField();
		contentPane.add(searchBox, "cell 12 1,alignx center");
		searchBox.setColumns(10);
		Beeper b= new Beeper();
		getContentPane().add(b);
	
	}
	  
		  
	  

	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
		
	}
	  

}

 
