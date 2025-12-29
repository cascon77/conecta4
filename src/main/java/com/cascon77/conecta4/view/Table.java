package com.cascon77.conecta4.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.cascon77.conecta4.model.Team;

public class Table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

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
	private MyButton[][] boardButtons;
	private Team teamTurn;
	private JMenuBar menuBar;
	private JButton btnReset;

	public Table() {
		teamTurn = Team.RED;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 593);
		setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnReset = new JButton("Full reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetBoard(true);
			}
		});
		menuBar.add(btnReset);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		gblContentPane = new GridBagLayout();
		gblContentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gblContentPane.rowHeights = new int[] { 0, 0, 0 };
		gblContentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gblContentPane.rowWeights = new double[] { 1.0, 9.0, Double.MIN_VALUE };
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
		GridBagLayout gblPanelPrincipal = new GridBagLayout();
		gblPanelPrincipal.columnWidths = new int[] { 0, 0 };
		gblPanelPrincipal.rowHeights = new int[] { 0, 0 };
		gblPanelPrincipal.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gblPanelPrincipal.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelPrincipal.setLayout(gblPanelPrincipal);

		panelBoard = new JPanel();
		panelBoard.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbcPanelBoard = new GridBagConstraints();
		gbcPanelBoard.insets = new Insets(5, 10, 5, 10);
		gbcPanelBoard.fill = GridBagConstraints.BOTH;
		gbcPanelBoard.gridx = 0;
		gbcPanelBoard.gridy = 0;
		gbcPanelBoard.weightx = 1.0;
		gbcPanelBoard.weighty = 1.0;
		panelPrincipal.add(panelBoard, gbcPanelBoard);
		panelBoard.setBackground(new Color(0, 0, 255));
		panelBoard.setLayout(new GridLayout(6, 7, 5, 5));

		boardButtons = new MyButton[6][7];
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				MyButton btn = new MyButton();
				btn.addActionListener(e -> setColor(e));
				btn.setBackground(Color.WHITE);
				btn.setActionCommand(Integer.toString(col));
				boardButtons[row][col] = btn;
				panelBoard.add(btn);
			}
		}
	}

	private boolean checkWin(int row, int col, Color color) {
        int count = 0;
        for (int c = 0; c < 7; c++) {
            count = (boardButtons[row][c].getBackground() == color) ? count + 1 : 0;
            if (count == 4) return true;
        }

        count = 0;
        for (int r = 0; r < 6; r++) {
            count = (boardButtons[r][col].getBackground() == color) ? count + 1 : 0;
            if (count == 4) return true;
        }

        count = 0;
        for (int r = 0, c = col - row; r < 6; r++, c++) {
            if (c >= 0 && c < 7) {
                count = (boardButtons[r][c].getBackground() == color) ? count + 1 : 0;
                if (count == 4) return true;
            }
        }

        count = 0;
        for (int r = 0, c = col + row; r < 6; r++, c--) {
            if (c >= 0 && c < 7) {
                count = (boardButtons[r][c].getBackground() == color) ? count + 1 : 0;
                if (count == 4) return true;
            }
        }

        return false;
    }

    public void setColor(ActionEvent e) {
        String command = e.getActionCommand();
        int col = Integer.parseInt(command);

        for (int r = 5; r >= 0; r--) {
            if (boardButtons[r][col].getBackground() == Color.WHITE) {
                Color currentColor = (teamTurn == Team.RED) ? Color.RED : Color.YELLOW;
                boardButtons[r][col].setBackground(currentColor);

                if (checkWin(r, col, currentColor)) {
                    lblTeam.setText((teamTurn == Team.RED ? "Rojas" : "Amarillas") + " ganan!");
                    if (teamTurn == Team.RED) {
						pointsRed++;
						lblRedCount.setText(Integer.toString(pointsRed));
					} else {
						pointsYellow++;
						lblYellowCount.setText(Integer.toString(pointsYellow));
					}
                    JOptionPane.showMessageDialog(this, (teamTurn == Team.RED ? "Rojas" : "Amarillas") + " ganan!");
                    resetBoard(false);
                    return;
                }

                teamTurn = (teamTurn == Team.RED) ? Team.YELLOW : Team.RED;
                lblTeam.setText(teamTurn == Team.RED ? "Rojas" : "Amarillas");
                break;
            }
        }
    }

    

	public void updateCell(int row, int col, Team team) {
		if (row < 0 || row >= boardButtons.length || col < 0 || col >= boardButtons[0].length)
			return;
		if (team == Team.RED)
			boardButtons[row][col].setBackground(Color.RED);
		else if (team == Team.YELLOW)
			boardButtons[row][col].setBackground(Color.YELLOW);
		else
			boardButtons[row][col].setBackground(Color.WHITE);
	}

	public void resetBoard(boolean fullRestart) {
		for (int r = 0; r < boardButtons.length; r++) {
			for (int c = 0; c < boardButtons[r].length; c++) {
				boardButtons[r][c].setBackground(Color.WHITE);
			}
		}
		if (fullRestart) {
			redPointsReset();
			yellowPointsReset();
			teamTurn = Team.RED;
		} else {
			teamTurn = (teamTurn == Team.RED) ? Team.YELLOW : Team.RED;
		}
		lblTeam.setText(teamTurn == Team.RED ? "Rojas" : "Amarillas");
	}

	private void yellowPointsReset() {
		pointsYellow = 0;
		lblYellowCount.setText(Integer.toString(pointsYellow));
	}

	private void redPointsReset() {
		pointsRed = 0;
		lblRedCount.setText(Integer.toString(pointsRed));
	}
	
	
}