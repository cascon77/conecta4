package com.cascon77.conecta4.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private GridBagLayout gblContentPane;
	private JPanel panelTopLeft;
	private GridBagConstraints gbcPanelTopLeft;
	private JLabel lblRed;
	private JLabel lblRedCount;
	private JPanel panelTopCenter;
	private JLabel lblTurn;
	private JPanel panelTopRight;
	private GridBagConstraints gbcPanelTopCenter;
	private GridBagConstraints gbcPanelTopRight;
	private JLabel lblYellow;
	private JLabel lblYellowCount;
	private JPanel panelBoard;
	private GridBagConstraints gbcPanelBoard;
	private int pointsRed;
	private int pointsYellow;
	
	private Font font;
	
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		gblContentPane = new GridBagLayout();
		gblContentPane.columnWidths = new int[]{0, 0, 0, 0};
		gblContentPane.rowHeights = new int[]{0, 0, 0};
		gblContentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gblContentPane.rowWeights = new double[]{1.0, 9.0, Double.MIN_VALUE};
		contentPane.setLayout(gblContentPane);
		
		panelTopLeft = new JPanel();
		gbcPanelTopLeft = new GridBagConstraints();
		gbcPanelTopLeft.insets = new Insets(0, 0, 5, 5);
		gbcPanelTopLeft.fill = GridBagConstraints.BOTH;
		gbcPanelTopLeft.gridx = 0;
		gbcPanelTopLeft.gridy = 0;
		contentPane.add(panelTopLeft, gbcPanelTopLeft);
		panelTopLeft.setLayout(new BorderLayout(0, 0));
		
		font = new Font("Consolas", Font.BOLD, 20);
		
		lblRed = new JLabel("Rojo:");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		lblRed.setFont(font);
		panelTopLeft.add(lblRed, BorderLayout.NORTH);
		
		pointsRed = 0;
		lblRedCount = new JLabel(Integer.toString(pointsRed));
		lblRedCount.setFont(font);
		lblRedCount.setHorizontalAlignment(SwingConstants.CENTER);
		panelTopLeft.add(lblRedCount, BorderLayout.CENTER);
		
		panelTopCenter = new JPanel();
		gbcPanelTopCenter = new GridBagConstraints();
		gbcPanelTopCenter.insets = new Insets(0, 0, 5, 5);
		gbcPanelTopCenter.fill = GridBagConstraints.BOTH;
		gbcPanelTopCenter.gridx = 1;
		gbcPanelTopCenter.gridy = 0;
		contentPane.add(panelTopCenter, gbcPanelTopCenter);
		
		lblTurn = new JLabel("Empieza");
		lblTurn.setFont(font);
		panelTopCenter.add(lblTurn);
		
		panelTopRight = new JPanel();
		gbcPanelTopRight = new GridBagConstraints();
		gbcPanelTopRight.insets = new Insets(0, 0, 5, 0);
		gbcPanelTopRight.fill = GridBagConstraints.BOTH;
		gbcPanelTopRight.gridx = 2;
		gbcPanelTopRight.gridy = 0;
		contentPane.add(panelTopRight, gbcPanelTopRight);
		panelTopRight.setLayout(new BorderLayout(0, 0));
		
		lblYellow = new JLabel("Amarillo:");
		lblYellow.setHorizontalAlignment(SwingConstants.CENTER);
		lblYellow.setFont(font);
		panelTopRight.add(lblYellow, BorderLayout.NORTH);
		
		pointsYellow = 0;		
		lblYellowCount = new JLabel(Integer.toString(pointsYellow));
		lblYellowCount.setFont(font);
		lblYellowCount.setHorizontalAlignment(SwingConstants.CENTER);
		panelTopRight.add(lblYellowCount, BorderLayout.CENTER);
		
		panelBoard = new JPanel();
		gbcPanelBoard = new GridBagConstraints();
		gbcPanelBoard.gridwidth = 3;
		gbcPanelBoard.fill = GridBagConstraints.BOTH;
		gbcPanelBoard.gridx = 0;
		gbcPanelBoard.gridy = 1;
		contentPane.add(panelBoard, gbcPanelBoard);
	}
	
}
