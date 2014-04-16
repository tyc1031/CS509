package client.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import us.monoid.json.JSONException;
import us.monoid.web.AbstractResource;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import client.model.UserContainer;
import client.view.ChangePasswordFrame;

public class LogonController {
	String json, userJson;
	public UserContainer user = new UserContainer();
	ObjectMapper mapper = new ObjectMapper();
	Resty sendLogon = new Resty();
	Resty getUser = new Resty();
	AbstractResource logonResponse;
	JSONResource getUserResponse;	
	
	public void login(UserContainer userToLogin ) throws Exception{
		//Map java object to json object
		json = mapper.writeValueAsString(userToLogin);
		//Check User Password
		sendLogon.alwaysSend("Content-Type", "application/json");		
		try{
			logonResponse = sendLogon.json("http://cs509-arest.herokuapp.com/user/password", content(json));
			//If the logon was successful
			if ( logonResponse.status(200) == true ){
				//Get User information
				getUser.alwaysSend("Content-Type", "application/json");
				getUserResponse = getUser.json("http://cs509-arest.herokuapp.com/user/get", content(json));
				UserContainer user = mapper.readValue(getUserResponse.object().toString(), UserContainer.class);
				//If this is the first time a user logs on, go to change password
				if (user.firstLogon == true){
					user.firstLogon = false;
					JOptionPane.showMessageDialog(null, "Successful logon!\n"
							+ "Change your password before continuing.", "Password Change", JOptionPane.INFORMATION_MESSAGE);
					//Launch change password frame
					ChangePasswordFrame changeFrame = new ChangePasswordFrame(user);
					changeFrame.start();
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Successful logon!\n"
							+ "Continuing to Home Screen", "Success!", JOptionPane.INFORMATION_MESSAGE);
					//To Home Screen
				}
				//Go to home screen View and pass user information
				System.out.println("Successfully logged on");			
			}
		} catch( IOException e1 ){
			JOptionPane.showMessageDialog(null, "Unsuccessful logon.\n"
					+ "Please try again.", "Logon Error!", JOptionPane.ERROR_MESSAGE);
			
		}
	}

}
