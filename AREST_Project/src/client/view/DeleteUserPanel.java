package client.view;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import client.controller.Controller;
import client.controller.CreateUserController;
import client.controller.DeleteUserController;
import client.controller.LogonController;
import client.model.UserContainer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class DeleteUserPanel extends JPanel {
	private UserContainer currentUser;
	
	private JTextField userNameField;	
	private JLabel lblUsername;	
	private JButton btnSubmit;
	private DeleteUserController controller;
	private String username;
	
	public DeleteUserPanel(final UserContainer _currentUser, final JFrame _currentFrame) {
		currentUser = _currentUser;
		
		//Username
		lblUsername = new JLabel("Username:");
		userNameField = new JTextField();
		//Submit Button
		btnSubmit = new JButton("Delete");
		//Controller
		controller = new DeleteUserController();

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = userNameField.getText();
				try {
					_currentFrame.dispose();
					controller.deleteUser(username, currentUser);
					if(username.equals(currentUser.userName)) {
						JOptionPane.showMessageDialog(_currentFrame, "Congrats! You've successfully deleted yourself! Bye!");
						System.exit(1);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		_currentFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				Controller homeScreen = new Controller(_currentUser);
				_currentFrame.dispose();
				homeScreen.showFrame();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
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
		
		//Button		
		btnSubmit.setBounds(107, 83, 88, 29);
		add(btnSubmit);				
	}
}

