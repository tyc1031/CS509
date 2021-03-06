package client.view.viewAllReports;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import client.controller.Controller;
import client.model.Report;
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
import java.util.List;

import javax.swing.JScrollPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

// The controller class is the Home Screen
public class ViewAllReportsFrame extends JFrame{

	private static final String CREATE_REPORT = "CREATE_REPORT";
	
	private JFrame mframe;
	private UserContainer currentUser;
	
	private Controller controller;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	
	private ObjectMapper mapper = new ObjectMapper();
	private Resty getReport = new Resty();
	private JSONResource getReportResponse;
	private JSONArray getReportResponseArray;
	List<Report> listOfReports;
	

	/**
	 * Create the application.
	 */
	public ViewAllReportsFrame(UserContainer _currentUser) {
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
		mframe = new JFrame("View All Reports");
		mframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// Table of All Reports in the system
		
		String[] columnNames = {"Report Id", "Date", "Submitter"};
		
		// Need to get table contents from connection manager
		// Make this Object[100][3]
		//Object[][] tableContents = {{new Integer(1), "01/04/14", "Jane Doe"},
		//							{new Integer(2), "02/20/14", "Cameron Diaz"},
		//							{new Integer(3), "05/16/14", "Selina Gomez"}};
		
		Object[][] tableContents = new Object[100][3];
		
		// Grab reports from server
		// Grab Users from the Server
		getReport.alwaysSend("Content-Type", "application/json");
		try {
			getReportResponse = getReport.json("http://cs509-arest.herokuapp.com/report/getAll");
			getReportResponseArray = getReportResponse.array();
			String print = Integer.toString(getReportResponseArray.length());
			System.out.println("length of array of reports = " + print);
			
			// Get the report container(s) from the JSONArray

			int index = 0;
			for(int i = 0; i < getReportResponseArray.length(); i ++)
			{
				Report report = mapper.readValue(getReportResponseArray.getString(i), Report.class);
				System.out.println("Report Id: " + report.id);
				System.out.println("Date: " + report.date);
				System.out.println("Submitter: " + report.username);
				if(currentUser.isSupervisor)
				{
					tableContents[i][0] = report.id;
					tableContents[i][1] = report.date;
					tableContents[i][2] = report.username;
				}
				else
				{
					boolean result = currentUser.userName.equals(report.username);
					if(currentUser.userName.equals(report.username) == true)
					{
						tableContents[index][0] = report.id;
						tableContents[index][1] = report.date;
						tableContents[index][2] = report.username;
						index++;
					}
				}
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
		mframe.setResizable(false);
	}
	
	public void showFrame() {
		mframe.setVisible(true);
	}
	
	public void loadTable () {
	}
}
