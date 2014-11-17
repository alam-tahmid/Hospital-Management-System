package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Paitient;

public class TablePanel extends JPanel {

	private JTable table;
	private PaitientTableModel PTModel;
	private JPopupMenu popup;
	private PaitientTableListener ptl;

	public TablePanel(){


		PTModel = new PaitientTableModel();
		table = new JTable(PTModel);
		popup = new JPopupMenu();

		JMenuItem removeItem = new JMenuItem("Delete");
		popup.add(removeItem);

		table.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent e) {

				int row = table.rowAtPoint(e.getPoint());

				table.getSelectionModel().setSelectionInterval(row, row);

				if(e.getButton()==MouseEvent.BUTTON3){

					popup.show(table,e.getX(),e.getY());
				}
			}
		});

		removeItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();

				if(ptl != null){

					ptl.rowDeleted(row);
					PTModel.fireTableRowsDeleted(row, row);
				}
			}
		});
		setLayout(new BorderLayout());

		add(new JScrollPane(table),BorderLayout.CENTER);
	}

	public void setTable(List<Paitient> db){

		PTModel.setData(db);
	}

	public void refresh(){

		PTModel.fireTableDataChanged();
	}

	public void addPaitientTableListener(PaitientTableListener ptl){

		this.ptl = ptl;
	} 
}
