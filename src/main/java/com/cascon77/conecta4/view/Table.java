package com.cascon77.conecta4.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

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
	private JLabel lblTeam;
	private JPanel panelTopRight;
	private GridBagConstraints gbcPanelTopCenter;
	private GridBagConstraints gbcPanelTopRight;
	private JLabel lblYellow;
	private JLabel lblYellowCount;
	private JPanel panelPrincipal;
	private GridBagConstraints gbc_panelPrincipal;
	private int pointsRed;
	private int pointsYellow;
	
	private Font font;
	private JLabel lblTurn;
	private JPanel panelBoard;
	private MyButton btnNewButton;
	private MyButton[][] boardButtons; // matriz 6x7 para los botones del tablero
	
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
		panelTopCenter.setLayout(new BorderLayout(0, 0));
		
		lblTeam = new JLabel("Rojas");
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam.setFont(font);
		panelTopCenter.add(lblTeam);
		
		lblTurn = new JLabel("Turno de");
		lblTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurn.setFont(new Font("Consolas", Font.BOLD, 20));
		panelTopCenter.add(lblTurn, BorderLayout.NORTH);
		
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
		
		panelPrincipal = new JPanel();
		gbc_panelPrincipal = new GridBagConstraints();
		gbc_panelPrincipal.gridwidth = 3;
		gbc_panelPrincipal.fill = GridBagConstraints.BOTH;
		gbc_panelPrincipal.gridx = 0;
		gbc_panelPrincipal.gridy = 1;
		contentPane.add(panelPrincipal, gbc_panelPrincipal);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		panelBoard = new JPanel();
		panelBoard.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelBoard = new GridBagConstraints();
		gbc_panelBoard.insets = new Insets(5, 10, 5, 10);
		gbc_panelBoard.fill = GridBagConstraints.BOTH;
		gbc_panelBoard.gridx = 0;
		gbc_panelBoard.gridy = 0;
		gbc_panelBoard.weightx = 1.0;
		gbc_panelBoard.weighty = 1.0;
		panelPrincipal.add(panelBoard, gbc_panelBoard);
		panelBoard.setBackground(new Color(0, 0, 255));
		panelBoard.setLayout(new GridLayout(6, 7, 5, 5));
		
		boardButtons = new MyButton[6][7];
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				MyButton btn = new MyButton();
				btn.setActionCommand(row + "," + col);
				boardButtons[row][col] = btn;
				panelBoard.add(btn);
			}
		}
	}
	
}