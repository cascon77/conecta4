package com.cascon77.conecta4.model;

import com.cascon77.conecta4.view.Table;

public class TableModel {
	
	public Table init() {
		Table table = new Table();
		table.setVisible(true);
		return table;
	}
	
	public int addWin(int i) {
		return ++i;
	}
	
}
