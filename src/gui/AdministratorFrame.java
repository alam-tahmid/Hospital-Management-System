package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class AdministratorFrame extends JFrame {


	private AdministratorPage administratorPage;
	private ToolBar toolbar;
	private FormPanel formPanel;
	private TextPanel textPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel table;

	public AdministratorFrame() {

		super("Hospital Management System");

		toolbar = new ToolBar();
		administratorPage = new AdministratorPage();
		textPanel = new TextPanel();
		table = new TablePanel();

		controller = new Controller();

		/*table.setTable(controller.getPaitient());

		table.addPaitientTableListener(new PaitientTableListener(){

			public void rowDeleted(int row){

				controller.removePatient(row);
			}
		});*/

		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PaitientFileFilter());

		setJMenuBar(createMenuBar());

		toolbar.stringSetter(new StringListener() {

			@Override
			public void textGetter(String text) {// ///for getting text from the
				// text panel

				textPanel.appendText(text);
			}
		});

		administratorPage.setFormListener(new FormListener() {

			public void FormEventOccured(FormEvent e) {

				//controller.addPaitient(e);
				table.refresh();
			}
		});

		setLayout(new BorderLayout());
		setSize(600, 600);

		// add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(administratorPage, BorderLayout.WEST);
		add(table, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu window = new JMenu("Window");

		JMenuItem exportData = new JMenuItem("Export");
		JMenuItem importData = new JMenuItem("Import");
		JMenuItem saveData = new JMenuItem("Save");
		JMenuItem printData = new JMenuItem("Print");
		JMenuItem Exit = new JMenuItem("Exit");

		file.add(exportData);
		file.add(importData);
		file.addSeparator();
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

				int i = JOptionPane.showConfirmDialog(AdministratorFrame.this,
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

				if (fileChooser.showSaveDialog(AdministratorFrame.this) == JFileChooser.APPROVE_OPTION) {

					try {

						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e) {

						JOptionPane.showMessageDialog(AdministratorFrame.this,
								"Could Not Save File", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		importData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				ActionEvent.CTRL_MASK));
		importData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {// //Have to fill up
				// the
				// actionlistener
				// for importing
				// data.

				if (fileChooser.showOpenDialog(AdministratorFrame.this) == JFileChooser.APPROVE_OPTION) {

					try {

						controller.LoadFromFile(fileChooser.getSelectedFile());
						table.refresh();
					} catch (IOException e) {

						JOptionPane.showMessageDialog(AdministratorFrame.this,
								"Could Not load Data From File", "Error",
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

				int i = JOptionPane.showConfirmDialog(AdministratorFrame.this,
						"Do you want to print", "Printing Confirmation",
						JOptionPane.OK_CANCEL_OPTION);

				if (i == JOptionPane.OK_OPTION) {

					JOptionPane
					.showMessageDialog(AdministratorFrame.this, "Printing...");
				}

			}

		});

		return menuBar;
	}
}


