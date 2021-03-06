package client.abuse_report.views.logon;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import client.controller.LogonController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogonPanel extends JPanel {
	private JTextField userNameField;	
	private JLabel lblUsername;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnSubmit;
	private LogonController controller;
	
	
	public LogonPanel() {
		//Username
		lblUsername = new JLabel("Username:");
		userNameField = new JTextField();
		
		//Password
		passwordField = new JPasswordField();
		lblPassword = new JLabel("Password:");
		
		//Submit button
		btnSubmit = new JButton("Logon");
		//Button Handle
		controller = new LogonController();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.login(userNameField.getText(), passwordField.getPassword());
			}
		});

		//Panel setup
		setupPanel();
		
	}
	
	private void setupPanel(){
		//setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		//Username Label
		lblUsername.setBounds(30, 36, 72, 16);
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblUsername);
		//Username		
		userNameField.setBounds(107, 30, 149, 28);
		userNameField.setColumns(10);
		userNameField.setText("Enter Username");
		this.add(userNameField);		
		
		//Password Label
		lblPassword.setBounds(30, 69, 72, 16);
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblPassword);
		//Password		
		passwordField.setBounds(107, 63, 149, 28);
		add(passwordField);
		
		//Button		
		btnSubmit.setBounds(107, 114, 88, 29);
		add(btnSubmit);				
	}
}
