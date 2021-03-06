package client.view.viewAllUsers;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import client.controller.Controller;
import client.model.UserContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.JTableHeader;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.*;

import javax.swing.JScrollPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.web.AbstractContent;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;


// The controller class is the Home Screen
public class ViewAllUsersFrame extends JFrame{

	private static final String CREATE_REPORT = "CREATE_REPORT";
	
	private JFrame mframe;
	private UserContainer currentUser;
	
	private Controller controller;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	
	private ObjectMapper mapper = new ObjectMapper();
	private Resty getUser = new Resty();
	private JSONResource getUserResponse;
	private JSONArray getUserResponseArray;
	List<UserContainer> listOfUsers;


	/**
	 * Create the application.
	 */
	public ViewAllUsersFrame(UserContainer _currentUser) {
		currentUser = _currentUser;
		initialize();
	}

	/**
	 * Some components will need to create their own frames, which will set this invisible.
	 * @param visibility
	 */
	/*public void setMainFrameVisibility(boolean visibility){
		mframe.setVisible(visibility);
	}*/
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mframe = new JFrame("View All Users");
		mframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// Table of All Reports in the system
		// Need to access the server
		// Who is making the connection manager?
		
		String[] columnNames = {"First Name", "Last Name", "Username"};
		// Need to get table contents from connection manager
		Object[][] tableContents = new Object[100][3];
		
		// Grabe Users from the Server
		getUser.alwaysSend("Content-Type", "application/json");
		try {
			getUserResponse = getUser.json("http://cs509-arest.herokuapp.com/user/getAll");
			getUserResponseArray = getUserResponse.array();
			String print = Integer.toString(getUserResponseArray.length());
			System.out.println("length of array = " + print);
			
			// Get the user container(s) from the JSONArray
			for(int i = 0; i < getUserResponseArray.length(); i ++)
			{
				UserContainer user = mapper.readValue(getUserResponseArray.getString(i), UserContainer.class);
				System.out.println("First name: " + user.firstName);
				System.out.println("Last name: " + user.lastName);
				System.out.println("Username: " + user.userName);
				tableContents[i][0] = user.firstName;
				tableContents[i][1] = user.lastName;
				tableContents[i][2] = user.userName;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		// Button to go back to the HomeScreen
		JButton backToHomeScreenButton = new JButton("Back to Main Menu");
		backToHomeScreenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					controller = new Controller(currentUser);
					mframe.dispose();
				}
			}
		});
		
		// This panel is to hold the scrollable table
		panel = new JPanel();
		
		
		GroupLayout groupLayout = new GroupLayout(mframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(backToHomeScreenButton)
							.addGap(200))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(backToHomeScreenButton)
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(tableContents, columnNames);
		scrollPane.setViewportView(table);
		mframe.setSize(500, 500);
		mframe.getContentPane().setLayout(groupLayout);
		mframe.pack();
	}
	
	public void fillTableContents(Object o) throws Exception
	{
		
	}
	
	private AbstractContent content(List<String> json2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void showFrame() {
		mframe.setVisible(true);
	}
	
	public void loadTable () {
	}
}
