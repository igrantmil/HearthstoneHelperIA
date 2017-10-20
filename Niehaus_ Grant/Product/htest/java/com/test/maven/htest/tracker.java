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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		contentPane.setMaximumSize(new Dimension(10, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//reset default icon
		ImageIcon logoicon = new ImageIcon("unnamed.png");
		Image logo = logoicon.getImage();
		setIconImage(logo);
		setResizable(false);
		
		setContentPane(contentPane);
		getContentPane().setBackground(Color.black);
		Searching c= new Searching();
		Beeper b= new Beeper();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(c, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
					.addGap(85))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(b, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(104))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(c, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(79))))
		);
		contentPane.setLayout(gl_contentPane);
		JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200, 20));

	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
}
	  



 
