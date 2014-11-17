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

public class StaffPanel extends JFrame implements ActionListener {

	private JLabel staffName;
	private JLabel password;

	private JTextField staffField;
	private JPasswordField passField;

	private JButton okButton;
	private JButton cancel;

	public StaffPanel() {

		super("Staff's Login");

		staffName = new JLabel("Staff Name :");
		password = new JLabel("Password :");

		staffField = new JTextField(10);
		passField = new JPasswordField(10);

		okButton = new JButton("OK");
		cancel = new JButton("Cancel");

		staffField.setText("staff");
		passField.setText("staff");

		
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

		add(staffName, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(staffField, gc);

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

			if(staffField.getText().equals("staff") && passField.getText().equals("staff")){
				
				new MainFrame();
				dispose();
			}else{

				JOptionPane.showMessageDialog(StaffPanel.this, "Oops! Something wrong,check again!!",  "Error", JOptionPane.ERROR_MESSAGE);
			} 
		}

		else if(clicked == cancel){

			System.exit(0);
		}
	}
}
