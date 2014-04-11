package client.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import us.monoid.web.AbstractResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import client.model.UserContainer;

public class ChangePasswordController {
	String json;
	ObjectMapper mapper = new ObjectMapper();
	Resty sendLogon = new Resty();
	AbstractResource changePasswordResponse;	
	
	public void changePassword( UserContainer user) throws IOException{
		//Map java object to json object
		json = mapper.writeValueAsString(user);
		System.out.println(json);	
		//Check Passwords
		sendLogon.alwaysSend("Content-Type", "application/json");
		changePasswordResponse = sendLogon.json("http://cs509-arest.herokuapp.com/user/edit", content(json));
		try{
			changePasswordResponse = sendLogon.json("http://cs509-arest.herokuapp.com/user/edit", content(json));
			//If the change password was successful
			if ( changePasswordResponse.status(200) == true ){
				//Go to home screen View
				System.out.println("Changed Password");			
			}
		} catch( IOException e1 ){
			JOptionPane.showMessageDialog(null, "Something went wrong.\n"
					+ "Please try again.", "Change Password Error!", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public boolean checkPasswords(String pw_1, String pw_2) {
		if (pw_1.equals(pw_2) == true) {
			System.out.println("Passwords equal");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Passwords must be the same.", "Password Error!", JOptionPane.ERROR_MESSAGE);
		return false;
	}

}
