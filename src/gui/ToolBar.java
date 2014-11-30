package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;


public class ToolBar extends JPanel implements ActionListener {

	//private JButton addButton;
	private JButton saveButton;
	private JButton refresh;
	//private JButton deleteButton;
	private JButton printButton;
	private Controller controller;
	private ToolbarListener textgetter;

	public ToolBar(){

		setBorder(BorderFactory.createEtchedBorder());
		// addButton = new JButton("Add");
		saveButton = new JButton("Save");
		refresh = new JButton("Refresh");
		//deleteButton = new JButton("Delete");
		printButton = new JButton("Print");
		controller = new Controller();

		//addButton.addActionListener(this);
		saveButton.addActionListener(this);
		refresh.addActionListener(this);
		printButton.addActionListener(this);
		//deleteButton.addActionListener(this);


		setLayout(new FlowLayout(FlowLayout.RIGHT));

		//  add(addButton);
		add(saveButton);
		add(refresh);
		//add(deleteButton);
		add(printButton);

	}

	public void setToolabarListener(ToolbarListener textgetter){

		this.textgetter = textgetter;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {


		JButton clicked = (JButton)ev.getSource();

		/* if(clicked == addButton){

            System.out.println("ADD Button is clicked");
        }*/

		if(clicked == saveButton){
			
			textgetter.saveEventOccured();

		}

		else if(clicked == refresh){

		textgetter.refreshEventOccured();
		
		}

		/*else if(clicked == deleteButton){

			System.out.println("Delete Button is clicked");
		}*/
		
		else if(clicked == printButton){

			System.out.println("Print Button is clicked");
		}
	}

}
