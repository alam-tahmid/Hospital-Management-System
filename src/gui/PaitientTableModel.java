package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Paitient;



public class PaitientTableModel extends AbstractTableModel {

	private List<Paitient>db;
	private String [] columnName={"Id","Name of the Paitient","Age","Gender","Occupation","Address","e-mail","Phone"};

	public void setData(List<Paitient> db){

		this.db = db;
	}
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}



	@Override
	public int getColumnCount() {

		return 8;
	}

	@Override
	public int getRowCount() {

		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Paitient paitient = db.get(row);

		switch(col){

		case 0:
			return paitient.getId();
		case 1:
			return paitient.getFirstName()+" "+paitient.getLastName();
		case 2:
			return paitient.getAge();
		case 3:
			return paitient.getGender();
		case 4:
			return paitient.getOccupation();
		case 5: 
			return paitient.getAddress();
		case 6:
			return paitient.getEmail();
		case 7:
			return paitient.getPhone();
		}
		
		return null;
	}

}
