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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class tracker extends JFrame  {
	public JList list = new JList();
	public JFrame button = null;
	private JPanel contentPane;
	private JTextField searchBox;
	private final Action action = new SwingAction();

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
		// base
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 449);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(10, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// reset default icon
		ImageIcon logoicon = new ImageIcon("unnamed.png");
		Image logo = logoicon.getImage();
		setIconImage(logo);
		setResizable(false);

		setContentPane(contentPane);
		getContentPane().setBackground(Color.black);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 531, 420);
		Searching deckCreator = new Searching();
		deckCreator.searchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel clm = Searching.selection();

				list.setModel(clm);
			}
		});
		deckCreator.searchBox.setBounds(262, 11, 264, 62);
		tabbedPane.addTab("New tab", null, deckCreator, null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("DANK");
			}
		});
		btnNewButton.setBounds(10, 7, 89, 36);
		deckCreator.add(deckCreator.searchBox);
		deckCreator.setLayout(null);
		deckCreator.add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("dank\r\ndakgfsdg");
		comboBox.setEditable(true);
		comboBox.setBounds(262, 102, 264, 108);
		deckCreator.add(comboBox);
		list.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				System.out.println("kek");
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println("dankeeeeeeekkkkkkkkk");
			}
		});
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("dankeeeeeee");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("instnace");
			}
		});
		list.setValueIsAdjusting(true);
		// searchBox.addActionListener(com.test.maven.htest.Searching[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]);
		deckCreator.add(list);

		list.setBounds(10, 110, 230, 47);

		contentPane.add(tabbedPane);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
