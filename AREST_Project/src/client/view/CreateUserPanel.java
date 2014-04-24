package client.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import client.controller.Controller;
import client.controller.CreateUserController;
import client.model.UserContainer;

import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class CreateUserPanel extends JPanel {
	private JTextField txtFirstName;
	private JLabel lblFirstName;
	private JTextField txtLastName;
	private JLabel lblLastName;
	private JTextField txtUserName;
	private JLabel lblNewUserName;
	private JPasswordField txtPassword_1;
	private JLabel lblPassword_1;
	private JPasswordField txtPassword_2;
	private JLabel lblPassword_2;
	private JTextField txtEmailAddress;
	private JLabel lblEmailAddress;
	private JCheckBox isSupervisor;
	private JButton btnSubmit;
	private CreateUserController controller;
	private String firstName, lastName, username;
	private String password_1, password_2, email;
	private boolean passwordsEqual;
	private boolean supervisor;
	
	private UserContainer currentUser;
	private JFrame currentFrame;
	
	public CreateUserPanel(final UserContainer _currentUser, final JFrame _currentFrame) {
		currentUser = _currentUser;
		currentFrame = _currentFrame;
		
		//First Name
		lblFirstName = new JLabel("First Name:");
		txtFirstName = new JTextField();
		//Last Name
		lblLastName = new JLabel("Last Name:");
		txtLastName = new JTextField();		
		//Username
		lblNewUserName = new JLabel("Username:");
		txtUserName = new JTextField();
		//Password Field 1
		lblPassword_1 = new JLabel("Password:");
		txtPassword_1 = new JPasswordField();
		//Password Field 2
		lblPassword_2 = new JLabel("Re-Type Password:");
		txtPassword_2 = new JPasswordField();
		//E-Mail Address
		lblEmailAddress = new JLabel("E-Mail Address:");
		txtEmailAddress = new JTextField();
		//Supervisor
		isSupervisor = new JCheckBox("Check if Supervisor");
		//Submit Button
		btnSubmit = new JButton("Submit");
		controller = new CreateUserController();
		
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
		
		setupPanel();		
	}		
		
	private void setupPanel() {
		setLayout(null);
		
		//Firstname Label
		lblFirstName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFirstName.setBounds(27, 32, 77, 16);
		this.add(lblFirstName);
		//First Name
		txtFirstName.setBounds(182, 26,  179, 28);
		txtFirstName.setColumns(10);
		this.add(txtFirstName);
		
		//Last Name Label
		lblLastName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblLastName.setBounds(27, 64, 77, 16);
		this.add(lblLastName);
		//Last Name
		txtLastName.setBounds(182, 58,  179, 28);
		txtLastName.setColumns(10);
		this.add(txtLastName);		
		
		//Username Label
		lblNewUserName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewUserName.setBounds(27, 96, 77, 16);
		this.add(lblNewUserName);
		//Username
		txtUserName.setBounds(182, 90, 179, 28);
		txtUserName.setColumns(10);
		this.add(txtUserName);
		
		//Password 1 Label
		lblPassword_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPassword_1.setBounds(27, 128, 77, 16);
		this.add(lblPassword_1);
		//Password 1
		txtPassword_1.setBounds(182, 122, 179, 28);
		this.add(txtPassword_1);
		
		//Password 2 Label
		lblPassword_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPassword_2.setBounds(27, 160, 149, 16);
		this.add(lblPassword_2);
		//Password 2
		txtPassword_2.setBounds(182, 154, 179, 28);
		this.add(txtPassword_2);
		
		//E-Mail Address
		lblEmailAddress.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblEmailAddress.setBounds(27, 192, 126, 16);
		this.add(lblEmailAddress);
		//E-Mail		
		txtEmailAddress.setBounds(182, 186, 179, 28);
		txtEmailAddress.setColumns(10);
		this.add(txtEmailAddress);
		
		//Supervisor Check Box
		isSupervisor.setBounds(115, 227, 163, 23);
		this.add(isSupervisor);
		
		//Submit Button		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstName = txtFirstName.getText();
				lastName = txtLastName.getText();
				username = txtUserName.getText();
				password_1 = new String(txtPassword_1.getPassword());
				password_2 = new String(txtPassword_2.getPassword());
				email = txtEmailAddress.getText();
				supervisor = isSupervisor.isSelected();
				System.out.println(supervisor);
				//Add a check that all values are complete
				passwordsEqual = controller.checkPasswords(password_1, password_2);				
				if (passwordsEqual) {
					try {
						currentFrame.dispose();
						controller.createUser(firstName, lastName, username, password_1, email, supervisor, currentUser);
					} catch (JsonGenerationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JsonMappingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}				
			}
		});
		btnSubmit.setBounds(136, 262, 117, 29);
		this.add(btnSubmit);		
		
	}
}
