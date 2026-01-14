package com.cascon77.conecta4;

import com.cascon77.conecta4.controller.GameController;
import com.cascon77.conecta4.model.GameModel;
import com.cascon77.conecta4.view.Table;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        Table view = new Table();
        new GameController(model, view);
        view.setVisible(true);
    }
}
