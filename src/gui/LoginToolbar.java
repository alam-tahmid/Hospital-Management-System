package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class LoginToolbar extends JDialog implements ActionListener  {

	private JButton administrator;
	private JButton staff;
	private JButton doctor;

	public LoginToolbar(JFrame parent){

		super(parent,"Login Panel",false);
		setSize(400,300);
		setLocationRelativeTo(parent);

		setLayout(new GridBagLayout());

		administrator = new JButton("Administrator");
		staff = new JButton("Staff");
		doctor = new JButton("Doctor");

		administrator.addActionListener(this);
		staff.addActionListener(this);
		doctor.addActionListener(this);

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy=0;
		gc.weightx=1;
		gc.weighty =1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx=0;

		add(staff,gc);

		gc.gridy++;
		gc.weightx=1;
		gc.weighty =1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx=0;

		add(doctor,gc);

		gc.gridy++;
		gc.weightx=1;
		gc.weighty =1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx=0;

		add(administrator,gc);


		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		JButton clicked = (JButton)e.getSource();

		if(clicked == administrator){

			new AdministratorPanel();
			dispose();
		}
		else if(clicked == staff){

			new StaffPanel();
			dispose();
		}
		else if(clicked == doctor){

			new DoctorPanel();
			dispose();
		}

	}

}
