package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.Paitient;

public class TablePanel extends JPanel {

	private JTable table;
	private PaitientTableModel PTModel;
	
	public TablePanel(){
		
		
		PTModel = new PaitientTableModel();
		table = new JTable(PTModel);
		
		setLayout(new BorderLayout());
		
		add(table,BorderLayout.CENTER);
	}
	
	public void setTable(List<Paitient> db){
		
	
		PTModel.setData(db);
	}
}
