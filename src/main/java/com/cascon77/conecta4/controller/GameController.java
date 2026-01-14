package com.cascon77.conecta4.controller;

import javax.swing.JOptionPane;

import com.cascon77.conecta4.model.GameModel;
import com.cascon77.conecta4.model.Team;
import com.cascon77.conecta4.view.Table;

public class GameController {

    private final GameModel model;
    private final Table view;

    public GameController(GameModel model, Table view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        syncView();
    }

    public void columnClicked(int col) {
        int row = model.dropPiece(col);
        if (row == -1) return;

        Team team = model.getCurrentTurn();
        view.updateCell(row, col, team);

        if (model.checkWin(row, col)) {
            model.addPoint();
            view.updateScore(model.getRedPoints(), model.getYellowPoints());
            JOptionPane.showMessageDialog(view,
                    (team == Team.RED ? "Rojas" : "Amarillas") + " ganan!");
            model.resetBoard();
            view.resetBoard();
            return;
        }

        model.nextTurn();
        view.updateTurn(model.getCurrentTurn());
    }

    public void fullReset() {
        model.fullReset();
        view.resetBoard();
        view.updateScore(0, 0);
        view.updateTurn(model.getCurrentTurn());
    }

    private void syncView() {
        view.updateScore(model.getRedPoints(), model.getYellowPoints());
        view.updateTurn(model.getCurrentTurn());
    }
}
