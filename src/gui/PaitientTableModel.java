package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Paitient;



public class PaitientTableModel extends AbstractTableModel {

	private List<Paitient>db;
	
	public void setData(List<Paitient> db){
		
		this.db = db;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
