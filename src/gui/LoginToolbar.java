package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class LoginToolbar extends JPanel implements ActionListener  {

	private JButton administrator;
	private JButton staff;
	private JButton doctor;

	public LoginToolbar(){

		Dimension dim = getPreferredSize();
		dim.width = 600;
		setPreferredSize(dim);
		
		administrator = new JButton("Administrator");
		staff = new JButton("Staff");
		doctor = new JButton("Doctor");

		

		administrator.addActionListener(this);
		staff.addActionListener(this);
		doctor.addActionListener(this);
		
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(administrator, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(doctor, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(staff, gc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		JButton clicked = (JButton)e.getSource();
		
		if(clicked == administrator){
			
			System.out.println("Administrator button is clicked");
		}
		else if(clicked == staff){
			
			System.out.println("Staff button is clicked");
		}
		else if(clicked == doctor){
			
			System.out.println("Doctor button is clicked");
		}

	}

}
