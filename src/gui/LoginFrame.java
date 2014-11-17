package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;


public class LoginFrame extends JFrame{

	private LoginToolbar loginToolBar;
	
	
	public LoginFrame(){
		
		super("Welcome ! Choose your login option");
		
		loginToolBar = new LoginToolbar(this);
		
		add(loginToolBar,BorderLayout.CENTER);
		setLayout(new GridBagLayout());
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
