package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AdministratorPage extends JPanel {



	private JLabel id;
	private JLabel name;
	private JLabel Specialization;
	private JLabel age;
	private JLabel address;
	private JLabel phone;
	private JLabel email;
	private FormListener formlistener;

	private JTextField idField;
	private JTextField nameField;
	private JTextField specField;
	private JTextField ageField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;

	private JButton okButton;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private ButtonGroup buttonGroup;

	private Random r;

	public AdministratorPage() {

		/*Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);*/

		r = new Random();

		id = new JLabel("ID");
		name = new JLabel("First Name: ");
		Specialization = new JLabel("Specialization: ");
		age = new JLabel("Age: ");
		address = new JLabel("Address: ");
		phone = new JLabel("Phone NO: ");
		email = new JLabel("e-mail: ");
		okButton = new JButton("OKAY");

		maleButton = new JRadioButton("Male");
		femaleButton = new JRadioButton("Female");
		buttonGroup = new ButtonGroup();
		maleButton.setSelected(true);

		buttonGroup.add(maleButton);
		buttonGroup.add(femaleButton);
		maleButton.setActionCommand("Male");
		femaleButton.setActionCommand("Female");

		idField = new JTextField(10);
		nameField = new JTextField(10);
		specField = new JTextField(10);
		ageField = new JTextField(10);
		addressField = new JTextField(10);
		phoneField = new JTextField(10);
		emailField = new JTextField(10);

		idField.setText(""+r.nextInt(Integer.max(0, Integer.MAX_VALUE)));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = idField.getText();
				String first = nameField.getText();
				String spec = specField.getText();
				String ageGet = ageField.getText();
				String addressGet = addressField.getText();
				String phoneGet = phoneField.getText();
				String emailGet = emailField.getText();
				String genderSelection = (String)buttonGroup.getSelection().getActionCommand();

				FormEvent ev = new FormEvent(this, id,first, spec, ageGet, addressGet, phoneGet, emailGet,genderSelection);

				if(formlistener != null){

					idField.setText(""+r.nextInt(Integer.max(0, Integer.MAX_VALUE)));
					formlistener.FormEventOccured(ev);
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Doctor's Detail");
		Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		label_field();
		setVisible(true);
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

		add(name, gc);

		///////// Adding first name text field/////////////
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(nameField, gc);


		///////// Adding button label/////////////
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 0);

		add(new JLabel("Gender:"), gc);



		///////// Adding male button /////////////

		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 0.05;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(maleButton, gc);


		///////// Adding female button /////////////

		gc.gridx = 1;
		gc.gridy = 4;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(femaleButton, gc);

		///////// Adding occupation label/////////////
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);

		add(Specialization, gc);

		///////// Adding occupation text field/////////////
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.fill = GridBagConstraints.NONE;

		add(specField, gc);

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

		add(okButton, gc);
	}

	public void setFormListener(FormListener formlistener){

		this.formlistener = formlistener;

	}
}
