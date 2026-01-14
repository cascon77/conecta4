package com.cascon77.conecta4.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.cascon77.conecta4.controller.GameController;
import com.cascon77.conecta4.model.Team;

public class Table extends JFrame {

    private static final long serialVersionUID = 1L;

    private GameController controller;

    /* ===== UI ===== */
    private JPanel contentPane;
    private JPanel panelBoard;
    private MyButton[][] boardButtons;

    private JLabel lblTeam;
    private JLabel lblRedCount;
    private JLabel lblYellowCount;

    private JButton btnReset;

    private Font font;

    public Table() {
        initFrame();
        initMenu();
        initLayout();
        initBoard();
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    private void initFrame() {
        setTitle("Conecta 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setModalExclusionType(ModalExclusionType.NO_EXCLUDE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        font = new Font("Consolas", Font.BOLD, 20);
    }

    /* ===== MENU ===== */
    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        btnReset = new JButton("Full reset");
        btnReset.addActionListener(e -> {
            if (controller != null) {
                controller.fullReset();
            }
        });
        menuBar.add(btnReset);
    }

    /* ===== LAYOUT SUPERIOR ===== */
    private void initLayout() {
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[] { 1, 1, 1 };
        gbl.rowHeights = new int[] { 1, 9 };
        gbl.columnWeights = new double[] { 1.0, 1.0, 1.0 };
        gbl.rowWeights = new double[] { 1.0, 9.0 };
        contentPane.setLayout(gbl);

        JPanel left = new JPanel(new BorderLayout());
        JLabel lblRed = new JLabel("Rojo", SwingConstants.CENTER);
        lblRed.setFont(font);
        lblRedCount = new JLabel("0", SwingConstants.CENTER);
        lblRedCount.setFont(font);

        left.add(lblRed, BorderLayout.NORTH);
        left.add(lblRedCount, BorderLayout.CENTER);

        addToGrid(left, 0, 0);

        JPanel center = new JPanel(new BorderLayout());
        JLabel lblTurn = new JLabel("Turno de", SwingConstants.CENTER);
        lblTurn.setFont(font);
        lblTeam = new JLabel("Rojas", SwingConstants.CENTER);
        lblTeam.setFont(font);

        center.add(lblTurn, BorderLayout.NORTH);
        center.add(lblTeam, BorderLayout.CENTER);

        addToGrid(center, 1, 0);

        JPanel right = new JPanel(new BorderLayout());
        JLabel lblYellow = new JLabel("Amarillo", SwingConstants.CENTER);
        lblYellow.setFont(font);
        lblYellowCount = new JLabel("0", SwingConstants.CENTER);
        lblYellowCount.setFont(font);

        right.add(lblYellow, BorderLayout.NORTH);
        right.add(lblYellowCount, BorderLayout.CENTER);

        addToGrid(right, 2, 0);
    }

    /* ===== TABLERO ===== */
    private void initBoard() {
        panelBoard = new JPanel();
        panelBoard.setBorder(new LineBorder(Color.BLACK));
        panelBoard.setBackground(Color.BLUE);
        panelBoard.setLayout(new GridLayout(6, 7, 5, 5));

        boardButtons = new MyButton[6][7];

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                final int col = c;
                MyButton btn = new MyButton();
                btn.setBackground(Color.WHITE);
                btn.addActionListener(e -> {
                    if (controller != null) {
                        controller.columnClicked(col);
                    }
                });
                boardButtons[r][c] = btn;
                panelBoard.add(btn);
            }
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        contentPane.add(panelBoard, gbc);
    }

    public void updateCell(int row, int col, Team team) {
        if (team == Team.RED) {
            boardButtons[row][col].setBackground(Color.RED);
        } else if (team == Team.YELLOW) {
            boardButtons[row][col].setBackground(Color.YELLOW);
        }
    }

    public void resetBoard() {
        for (int r = 0; r < boardButtons.length; r++) {
            for (int c = 0; c < boardButtons[r].length; c++) {
                boardButtons[r][c].setBackground(Color.WHITE);
            }
        }
    }

    public void updateTurn(Team team) {
        lblTeam.setText(team == Team.RED ? "Rojas" : "Amarillas");
    }

    public void updateScore(int red, int yellow) {
        lblRedCount.setText(String.valueOf(red));
        lblYellowCount.setText(String.valueOf(yellow));
    }

    private void addToGrid(JPanel panel, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        contentPane.add(panel, gbc);
    }
}
