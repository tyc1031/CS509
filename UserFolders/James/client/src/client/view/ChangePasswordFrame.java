package client.view;

import javax.swing.JFrame;

public class ChangePasswordFrame extends JFrame {
	
	private ChangePasswordPanel currentPanel;
	
	public ChangePasswordFrame(){		
		currentPanel = new ChangePasswordPanel();
		setTitle("Change User Password");
		
		setupFrame();
	}
	
	private void setupFrame(){
		setResizable(false);
		this.setContentPane(currentPanel);
		
	}
	
	public void start(){
		this.setSize(400,350);
		this.setVisible(true);
	}

}