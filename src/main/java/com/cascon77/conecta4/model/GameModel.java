package com.cascon77.conecta4.model;

public class GameModel {

    public static final int ROWS = 6;
    public static final int COLS = 7;

    private final Team[][] board;
    private Team currentTurn;
    private int redPoints;
    private int yellowPoints;

    public GameModel() {
        board = new Team[ROWS][COLS];
        resetBoard();
        currentTurn = Team.RED;
    }

    public Team getCurrentTurn() {
        return currentTurn;
    }

    public Team[][] getBoard() {
        return board;
    }

    public int getRedPoints() {
        return redPoints;
    }

    public int getYellowPoints() {
        return yellowPoints;
    }

    public int dropPiece(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == null) {
                board[row][col] = currentTurn;
                return row;
            }
        }
        return -1;
    }

    public boolean checkWin(int row, int col) {
        Team t = board[row][col];
        return checkDirection(row, col, 0, 1, t) ||   // horizontal
               checkDirection(row, col, 1, 0, t) ||   // vertical
               checkDirection(row, col, 1, 1, t) ||   // diagonal izq a der
               checkDirection(row, col, 1, -1, t);    // diagonal der a izq
    }

    private boolean checkDirection(int r, int c, int dr, int dc, Team t) {
        int count = 1;
        count += countOneSide(r, c, dr, dc, t);
        count += countOneSide(r, c, -dr, -dc, t);
        return count >= 4;
    }

    private int countOneSide(int r, int c, int dr, int dc, Team t) {
        int cnt = 0;
        r += dr;
        c += dc;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c] == t) {
            cnt++;
            r += dr;
            c += dc;
        }
        return cnt;
    }

    public void nextTurn() {
        currentTurn = (currentTurn == Team.RED) ? Team.YELLOW : Team.RED;
    }

    public void addPoint() {
        if (currentTurn == Team.RED) redPoints++;
        else yellowPoints++;
    }

    public void resetBoard() {
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                board[r][c] = null;
    }

    public void fullReset() {
        resetBoard();
        redPoints = 0;
        yellowPoints = 0;
        currentTurn = Team.RED;
    }
}
