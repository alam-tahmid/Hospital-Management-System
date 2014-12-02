package gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class PrescriptionFrame extends JFrame {

	private ToolBar toolbar;
	private PrescriptionInfo prescriptionInfo;
	private TextPanel textPanel;
	private JFileChooser fileChooser;
	private Controller controller;


	public PrescriptionFrame() {

		super("Hospital Management System");

		toolbar = new ToolBar();
		prescriptionInfo = new PrescriptionInfo();
		textPanel = new TextPanel();


		controller = new Controller();



		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PaitientFileFilter());

		setJMenuBar(createMenuBar());


		setLayout(new BorderLayout());
		setSize(600, 600);

		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(prescriptionInfo, BorderLayout.WEST);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void connect(){

		try {

			controller.connect();
		} catch (Exception e) {

			JOptionPane.showMessageDialog(PrescriptionFrame.this,
					"Could Not Connect", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private JMenuBar createMenuBar() {

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu window = new JMenu("Window");

		JMenuItem exportData = new JMenuItem("Export");
		JMenuItem importData = new JMenuItem("Import");
		JMenuItem createTable = new JMenuItem("Create Table");
		JMenuItem saveData = new JMenuItem("Save");
		JMenuItem printData = new JMenuItem("Print");
		JMenuItem Exit = new JMenuItem("Exit");

		file.add(exportData);
		file.add(importData);
		file.addSeparator();
		file.add(createTable);
		file.add(saveData);
		file.add(printData);
		file.addSeparator();
		file.add(Exit);

		menuBar.add(file);
		menuBar.add(window);

		file.setMnemonic(KeyEvent.VK_ALT);
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = JOptionPane.showConfirmDialog(PrescriptionFrame.this,
						"Are you sure you want to exit?", "Confirm Exit",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.OK_OPTION) {

					System.exit(0);
				}

			}
		});

		exportData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		exportData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {// // Have to fill up
				// the
				// actionlistener
				// for exporting
				// data.

				if (fileChooser.showSaveDialog(PrescriptionFrame.this) == JFileChooser.APPROVE_OPTION) {

					try {

						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e) {

						JOptionPane.showMessageDialog(PrescriptionFrame.this,
								"Could Not Save File", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});


		saveData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		printData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				ActionEvent.CTRL_MASK));
		printData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = JOptionPane.showConfirmDialog(PrescriptionFrame.this,
						"Do you want to print", "Printing Confirmation",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.OK_OPTION) {

					JOptionPane
					.showMessageDialog(PrescriptionFrame.this, "Printing...");
				}

			}

		});

		createTable.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {


				try {
					controller.createTable();
				} catch (Exception e) {

					JOptionPane.showMessageDialog(PrescriptionFrame.this,
							"Table aready created!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}


		});

		return menuBar;
	}
}

