package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;


public class PrescriptionInfo extends JPanel {

	private JLabel id;
	private JLabel firstName;
	private JLabel lastName;
	private JLabel occupation;
	private JLabel age;
	private JLabel address;
	private JLabel phone;
	private JLabel email;
	private JLabel gender;
	private FormListener formlistener;

	private JTextField idField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField occupationField;
	private JTextField ageField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField genderField;

	private Controller controller;


	private JButton searchButton;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private ButtonGroup buttonGroup;


	public PrescriptionInfo() {

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		controller = new Controller();


		id = new JLabel("ID");
		firstName = new JLabel("First Name: ");
		lastName = new JLabel("Last Name: ");
		gender = new JLabel("Gender");
		occupation = new JLabel("Occupation: ");
		age = new JLabel("Age: ");
		address = new JLabel("Address: ");
		phone = new JLabel("Phone NO: ");
		email = new JLabel("e-mail: ");
		searchButton = new JButton("Search");

		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		buttonGroup = new ButtonGroup();
		maleButton.setSelected(true);

		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);
		maleButton.setActionCommand("Male");
		femaleButton.setActionCommand("Female");

		idField = new JTextField(10);
		firstNameField = new JTextField(10);
		lastNameField = new JTextField(10);
		genderField = new JTextField(10);
		occupationField = new JTextField(10);
		ageField = new JTextField(10);
		addressField = new JTextField(10);
		phoneField = new JTextField(10);
		emailField = new JTextField(10);

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(idField.getText());
			
				try {
					controller.search(id);

					firstNameField.setText(controller.fname);
					lastNameField.setText(controller.lname);
					occupationField.setText(controller.occupation);
					genderField.setText(controller.gender);
					ageField.setText(controller.age);
					addressField.setText(controller.adr);
					phoneField.setText(controller.phone);
					emailField.setText(controller.email);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Paitient Detail");
		Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		label_field();
	}

	public void label_field() {

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		////////////// Adding labels and text fields///////////////////


		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(id, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(idField, gc);

		/////// first row first name label and text field/////////////
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(firstName, gc);

		///////// Adding first name text field/////////////
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(firstNameField, gc);

		///////// Adding second name label/////////////
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(lastName, gc);

		///////// Adding second name text field/////////////
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(lastNameField, gc);

		///////// Adding button label/////////////
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 0);

		add(gender, gc);

		///////// Adding male button /////////////

		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 0.05;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(genderField, gc);

		///////// Adding occupation label/////////////
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(occupation, gc);

		///////// Adding occupation text field/////////////
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(occupationField, gc);

		///////// Adding age label/////////////
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(age, gc);

		///////// Adding age text field/////////////
		gc.gridx = 1;
		gc.gridy = 6;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(ageField, gc);

		///////// Adding address label/////////////
		gc.gridx = 0;
		gc.gridy = 7;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(address, gc);

		///////// Adding address text field/////////////
		gc.gridx = 1;
		gc.gridy = 7;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(addressField, gc);

		///////// Adding phone label/////////////
		gc.gridx = 0;
		gc.gridy = 8;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(phone, gc);

		///////// Adding phone text field/////////////
		gc.gridx = 1;
		gc.gridy = 8;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(phoneField, gc);

		///////// Adding email label/////////////
		gc.gridx = 0;
		gc.gridy = 9;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(email, gc);

		///////// Adding email text field/////////////
		gc.gridx = 1;
		gc.gridy = 9;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(emailField, gc);

		///////// Adding ok button/////////////
		gc.gridx = 0;
		gc.gridy = 10;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(searchButton, gc);
	}

	public void setFormListener(FormListener formlistener){

		this.formlistener = formlistener;

	}

}
