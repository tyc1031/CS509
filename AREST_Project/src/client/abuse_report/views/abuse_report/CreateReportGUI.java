package client.abuse_report.views.abuse_report;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import client.abuse_report.models.Abuser;
import client.abuse_report.models.Guardian;
import client.abuse_report.models.ReportContainer;
import client.abuse_report.models.Reporter;
import client.abuse_report.models.Victim;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Controls the flow of Abuse Report creation. This class also commits changes
 * to the report container.
 * @author Matt Orsini
 *
 */
public class CreateReportGUI extends JFrame {

	final private static boolean DEBUG_REPORTER = false;
	final private static boolean DEBUG_VICTIM = false;
	final private static boolean DEBUG_VICTIM_ADD = false;
	final private static boolean DEBUG_GUARDIAN = false;
	final private static boolean DEBUG_DESCR = true;
	
	final private static String REPORTER_PANEL         = "Reporter Panel";
	final private static String VICTIM_PANEL           = "Victim Panel";
	final private static String VICTIM_ADD_INFO_PANEL  = "VICTIM_ADD_PANEL";
	final private static String GUARDIAN_PANEL         = "Guardian Panel";
	final private static String DESCRIPTION_PANEL      = "Description Panel";
	
	private JFrame mFrame;
	private JPanel containerPanel;
	private JPanel mCards;
	private JButton previousButton;
	private JButton cancelButton;
	private JButton nextButton;
	private CardLayout clContainer;
	
	private static ReportContainer reportContainer;
	private static ReporterGUI reporterGUI;
	private static VictimGUI   victimGUI;
	private static VictimAdditionalInfoGUI victimAddGUI;
	private static GuardianGUI guardianGUI;
	private static DescriptionGUI descriptionGUI;
	
	private Reporter reporter;
	private Abuser abuser;
	private Victim victim;
	private Guardian guardian;
	
	private static int componentIndex = 0;
	/**
	 * Create the panel.
	 */
	public CreateReportGUI() {
		reportContainer = new ReportContainer();
		reporter = new Reporter();
		victim = new Victim();
		abuser = new Abuser();
		guardian = new Guardian();
		
		initialize();	
	}

	/**
	 * Increment the index of the component (ID) only if it's less than the total number
	 * of cards in the layout.
	 */
	private void incrComponentIndex(){
		if(componentIndex == mCards.getComponents().length){
			componentIndex = 1;
		} else {
			componentIndex++;
		}
	}
	
	/**
	 * Initialize components in this Panel
	 */
	public void initialize() {
		mFrame = new JFrame();
		
		containerPanel = new JPanel();
		mFrame.getContentPane().add(containerPanel);
		GridBagLayout gbl_containerPanel = new GridBagLayout();
		gbl_containerPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_containerPanel.rowWeights = new double[]{0.0, 0.0};
		containerPanel.setLayout(gbl_containerPanel);
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// Create all the cards in this panel.
		reporterGUI = new ReporterGUI();
		reporterGUI.setName(REPORTER_PANEL);
		victimGUI   = new VictimGUI();
		victimGUI.setName(VICTIM_PANEL);
		victimAddGUI = new VictimAdditionalInfoGUI();
		victimAddGUI.setName(VICTIM_ADD_INFO_PANEL);
		guardianGUI = new GuardianGUI();
		guardianGUI.setName(GUARDIAN_PANEL);
		descriptionGUI = new DescriptionGUI();
		descriptionGUI.setName(DESCRIPTION_PANEL);
		
		// Create the CardLayout and add the cards
		CardLayout cl_mCards = new CardLayout();
		mCards = new JPanel(cl_mCards);
		mCards.add(reporterGUI, REPORTER_PANEL);
		mCards.add(victimGUI,   VICTIM_PANEL);
		mCards.add(victimAddGUI, VICTIM_ADD_INFO_PANEL);
		mCards.add(guardianGUI, GUARDIAN_PANEL);
		mCards.add(descriptionGUI, DESCRIPTION_PANEL);
		
		clContainer = (CardLayout) mCards.getLayout();
		GridBagConstraints gbc_mCards = new GridBagConstraints();
		gbc_mCards.anchor = GridBagConstraints.NORTHWEST;
		gbc_mCards.insets = new Insets(0, 5, 5, 0);
		gbc_mCards.gridwidth = 3;
		gbc_mCards.gridx = 0;
		gbc_mCards.gridy = 0;
		containerPanel.add(mCards, gbc_mCards);
		
		GridBagConstraints gbc_previousButton = new GridBagConstraints();
		gbc_previousButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_previousButton.insets = new Insets(0, 5, 0, 0);
		gbc_previousButton.gridx = 0;
		gbc_previousButton.gridy = 1;
		gbc_previousButton.weightx = 0.5;
		containerPanel.add(previousButton, gbc_previousButton);
		
		nextButton = new JButton("Next");
		nextButton.setVerticalAlignment(SwingConstants.BOTTOM);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					boolean validInfo = false;
					if(mCards.getComponent(componentIndex).getName() ==  REPORTER_PANEL) {
						// Check and commit changes to this panel and the model
						if(!DEBUG_REPORTER) validInfo = true;
						else {
							validInfo = reporterGUI.isValidInfo();
							if(validInfo){
								// Commit changes to the model.
								reporter = reporterGUI.commitReporter(reporter);
								abuser =  reporterGUI.commitAbuser(abuser);
							}
						}
					} else if (mCards.getComponent(componentIndex).getName() == VICTIM_PANEL) {
						if(!DEBUG_VICTIM) validInfo = true;
						else { 
							validInfo = victimGUI.isValidInfo();
							if(validInfo) {
								victim = victimGUI.commitVictim(victim);
							}
						}
						
					} else if (mCards.getComponent(componentIndex).getName() == VICTIM_ADD_INFO_PANEL) {
						if(!DEBUG_VICTIM_ADD) validInfo = true;
						else {
							validInfo = victimAddGUI.isValidInfo();
							if(validInfo) {
								victim = victimAddGUI.commitVictim(victim);
							}
						}
					} else if(mCards.getComponent(componentIndex).getName() == GUARDIAN_PANEL) {
						if(!DEBUG_GUARDIAN) validInfo = true;
						else { 
							validInfo = guardianGUI.isValidInfo();
							if(validInfo) {
								guardian = guardianGUI.commitGuardian(guardian);
								reportContainer = guardianGUI.getReportContainerInfo(reportContainer);
							}
						}
					} else if(mCards.getComponent(componentIndex).getName() == DESCRIPTION_PANEL) {
						if(!DEBUG_DESCR) validInfo = true;
						else {
							validInfo = descriptionGUI.isValidInfo();
							if(validInfo) {
								reportContainer = descriptionGUI.getReportContainerInfo(reportContainer);
							}
						}
					}
					// Only proceed if the information is valid
					
					if(validInfo){
						clContainer.next(mCards);
						if(componentIndex != mCards.getComponents().length) {
							componentIndex++;
						} else {
							componentIndex = 0;
						}
					}
				}
			}
		});
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_nextButton.insets = new Insets(0, 5, 0, 5);
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 1;
		gbc_nextButton.weightx = 0.5;
		gbc_nextButton.weighty = 1;
		containerPanel.add(nextButton, gbc_nextButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 1;
		gbc_cancelButton.weightx = 0.5;
		gbc_cancelButton.insets = new Insets(0, 5, 0, 0);
		containerPanel.add(cancelButton, gbc_cancelButton);

		mFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mFrame.pack();
		mFrame.setResizable(false);
		mFrame.setVisible(true);
	}
	
}