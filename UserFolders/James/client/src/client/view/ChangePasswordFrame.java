package client.view;

import javax.swing.JFrame;

import client.model.UserContainer;

public class ChangePasswordFrame extends JFrame {
	
	private ChangePasswordPanel currentPanel;
	
	public ChangePasswordFrame(UserContainer user){		
		currentPanel = new ChangePasswordPanel(this, user);
		setTitle("Change User Password");
		
		setupFrame();
	}
	
	private void setupFrame(){
		setResizable(false);
		this.setContentPane(currentPanel);
		
	}
	
	public void start(){
		this.setSize(400,200);
		this.setVisible(true);
	}

}