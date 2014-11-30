package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdministratorPanel extends JFrame implements ActionListener {

	private JLabel administratorName;
	private JLabel password;

	private JTextField administratorField;
	private JPasswordField passField;

	private JButton okButton;
	private JButton cancel;

	public AdministratorPanel(){

		super("Administrator Login");

		administratorName = new JLabel("Administrator's Name :");
		password = new JLabel("Password :");

		administratorField = new JTextField(10);
		passField = new JPasswordField(10);

		okButton = new JButton("OK");
		cancel = new JButton("Cancel");

		administratorField.setText("administrator");
		passField.setText("administrator");


		okButton.addActionListener(this);
		cancel.addActionListener(this);

		setLayout(new GridBagLayout());
		setSize(400, 300);
		setResizable(false);

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(administratorName, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(administratorField, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(password, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(passField, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(okButton, gc);

		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(cancel, gc);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	@Override
	public void actionPerformed(ActionEvent ev) {

		JButton clicked =(JButton)ev.getSource();

		if(clicked==okButton){

			if(administratorField.getText().equals("administrator") && passField.getText().equals("administrator")){

				System.out.println("clicked");
				new AdministratorFrame();
				dispose();
			}else{

				JOptionPane.showMessageDialog(AdministratorPanel.this, "Oops! Something wrong,check again!!",  "Error", JOptionPane.ERROR_MESSAGE);
			} 
		}

		else if(clicked == cancel){

			System.exit(0);
		}
	}

}

