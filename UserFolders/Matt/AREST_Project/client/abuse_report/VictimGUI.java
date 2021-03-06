package client.abuse_report;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import common.DocumentSizeFilter;

// FIXME MOrsini: Add in warnings after fixing the reporter warnings

public class VictimGUI extends JPanel implements CreateReportInterface {
	
	private DocumentSizeFilter filter;
	
	private JTextField monthText;
	private JTextField dayText;
	private JTextField maritalStatusText;
	private JTextArea  addressTextArea;
	private JFormattedTextField disabilityOtherTextField;
	
	private JCheckBox chckbxMentalRetardation;
	private JCheckBox chckbxMobility;	
	private JCheckBox chckbxVisual;
	private JCheckBox chckbxCerebralPalsy;
	private JCheckBox chckbxSeizures;
	private JCheckBox chckbxMentalIllness;
	private JCheckBox chckbxHeadInjury;
	private JCheckBox chckbxDeafHard;
	private JCheckBox chckbxMultipleSclerosis;
	private JCheckBox chckbxOtherspecify;
	
	private JLabel allegedVictimLabel;
	private JLabel firstNameLabel;
	private JLabel addressLabel;
	private JLabel sexLabel;
	private JLabel dobLabel;
	private JLabel ageLabel;
	private JLabel maritalStatusLabel;
	private JLabel disabilityLabel;
	private JLabel ethnicityLabel;
	private JLabel lastNameLabel;
	private JLabel lblTelephone;
	private JLabel communicationNeedsLabel;
	
	private JTextPane firstNameNotSetWarning;
	private JTextPane addrNotSetWarning;
	private JTextPane dobNotSetWarning;
	private JTextPane sexNotSetWarning;
	private JTextPane ageNotSetWarning;
	private JTextPane maritalStatusNotSetWarning;
	private JTextPane disabilityNotSetWarning;
	private JTextPane ethnicityNotSetWarning;
	private JTextField yearText;
	private JTextField ageText;
	private JFormattedTextField firstNameText;
	private JFormattedTextField lastNameText;
	private JFormattedTextField phoneAreaCode;
	private JFormattedTextField phoneFirstThree;
	private JFormattedTextField phoneLastFour;
	private JTextPane lastNameNotSetWarning;
	private JTextPane comNotSetWarning;
	private JFormattedTextField otherEthnicityTextField;
	private JTextPane phoneHyphon;
	private JTextPane phoneNotSetWarning;
	private JTextField otherComNeedsTextField;
	
	
	private JPanel DisabilityPanel;
	private JPanel VictimPanel;
	private JPanel ethnicityPanel;
	private JPanel ComNeedsPanel;
	private JPanel comNeedsCbPanel;
	private JPanel ethnicityCbPanel;
	private JPanel disabilityCbPanel;
	
	private JComboBox sexCombo;
	
	private JCheckBox caucasianCheckBox;
	private JCheckBox africanAmericanCheckBox;
	private JCheckBox hispanicCheckBox;
	private JCheckBox nativeAmericanCheckBox;
	private JCheckBox asianCheckBox;
	private JCheckBox otherEthnicityCheckBox;
	private JCheckBox ttyCheckBox;
	private JCheckBox signInterCheckBox;
	private JCheckBox otherComNeedsCheckBox;

	
	public VictimGUI() {
		setToolTipText("Please enter information regarding the Alleged Victim.");
		// To configure JTextComponents
		filter = new DocumentSizeFilter(10);

		
		DisabilityPanel = new JPanel();
		DisabilityPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		VictimPanel = new JPanel();
		VictimPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		ethnicityPanel = new JPanel();
		ethnicityPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		ComNeedsPanel = new JPanel();
		ComNeedsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(ComNeedsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ethnicityPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addComponent(VictimPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addComponent(DisabilityPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(VictimPanel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(DisabilityPanel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ethnicityPanel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ComNeedsPanel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		communicationNeedsLabel = new JLabel("Communication Needs:");
		communicationNeedsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		comNeedsCbPanel = new JPanel();
		
		comNotSetWarning = new JTextPane();
		comNotSetWarning.setBackground(SystemColor.menu);
		comNotSetWarning.setEditable(false);
		comNotSetWarning.setForeground(Color.RED);
		comNotSetWarning.setText("*");
		comNotSetWarning.setVisible(false);
		GroupLayout gl_ComNeedsPanel = new GroupLayout(ComNeedsPanel);
		gl_ComNeedsPanel.setHorizontalGroup(
			gl_ComNeedsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ComNeedsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ComNeedsPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comNeedsCbPanel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ComNeedsPanel.createSequentialGroup()
							.addComponent(communicationNeedsLabel)
							.addGap(18)
							.addComponent(comNotSetWarning, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_ComNeedsPanel.setVerticalGroup(
			gl_ComNeedsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ComNeedsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ComNeedsPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(communicationNeedsLabel)
						.addComponent(comNotSetWarning, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comNeedsCbPanel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GridBagLayout gbl_comNeedsCbPanel = new GridBagLayout();
		gbl_comNeedsCbPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_comNeedsCbPanel.rowHeights = new int[] {30};
		gbl_comNeedsCbPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_comNeedsCbPanel.rowWeights = new double[]{0.0};
		comNeedsCbPanel.setLayout(gbl_comNeedsCbPanel);
		
		ttyCheckBox = new JCheckBox("TTY");
		GridBagConstraints gbc_ttyCheckBox = new GridBagConstraints();
		gbc_ttyCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_ttyCheckBox.gridx = 2;
		gbc_ttyCheckBox.gridy = 0;
		comNeedsCbPanel.add(ttyCheckBox, gbc_ttyCheckBox);
		
		signInterCheckBox = new JCheckBox("Sign Interpreter");
		GridBagConstraints gbc_signInterCheckBox = new GridBagConstraints();
		gbc_signInterCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_signInterCheckBox.gridx = 5;
		gbc_signInterCheckBox.gridy = 0;
		comNeedsCbPanel.add(signInterCheckBox, gbc_signInterCheckBox);
		
		otherComNeedsCheckBox = new JCheckBox("Other (Specify):");
		GridBagConstraints gbc_otherComNeedsCheckBox = new GridBagConstraints();
		gbc_otherComNeedsCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_otherComNeedsCheckBox.gridx = 8;
		gbc_otherComNeedsCheckBox.gridy = 0;
		comNeedsCbPanel.add(otherComNeedsCheckBox, gbc_otherComNeedsCheckBox);
		
		otherComNeedsTextField = new JTextField();
		GridBagConstraints gbc_otherComNeedsTextField = new GridBagConstraints();
		gbc_otherComNeedsTextField.gridwidth = 2;
		gbc_otherComNeedsTextField.insets = new Insets(0, 0, 0, 5);
		gbc_otherComNeedsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_otherComNeedsTextField.gridx = 9;
		gbc_otherComNeedsTextField.gridy = 0;
		comNeedsCbPanel.add(otherComNeedsTextField, gbc_otherComNeedsTextField);
		otherComNeedsTextField.setColumns(10);
		filter.setupTextField(otherComNeedsTextField, DocumentSizeFilter.AL_NO, 30);
		
		ComNeedsPanel.setLayout(gl_ComNeedsPanel);
		
		ethnicityLabel = new JLabel("Client's Ethnicity");
		ethnicityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		ethnicityCbPanel = new JPanel();
		
		ethnicityNotSetWarning = new JTextPane();
		ethnicityNotSetWarning.setVisible(false);
		ethnicityNotSetWarning.setText("*");
		ethnicityNotSetWarning.setForeground(Color.RED);
		ethnicityNotSetWarning.setEditable(false);
		ethnicityNotSetWarning.setBackground(SystemColor.menu);
		GroupLayout gl_ethnicityPanel = new GroupLayout(ethnicityPanel);
		gl_ethnicityPanel.setHorizontalGroup(
			gl_ethnicityPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ethnicityPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ethnicityPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_ethnicityPanel.createSequentialGroup()
							.addComponent(ethnicityCbPanel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_ethnicityPanel.createSequentialGroup()
							.addComponent(ethnicityLabel)
							.addGap(18)
							.addComponent(ethnicityNotSetWarning, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(414))))
		);
		gl_ethnicityPanel.setVerticalGroup(
			gl_ethnicityPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ethnicityPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ethnicityPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ethnicityLabel)
						.addComponent(ethnicityNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ethnicityCbPanel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		GridBagLayout gbl_ethnicityCbPanel = new GridBagLayout();
		gbl_ethnicityCbPanel.columnWidths = new int[] {100, 100, 100, 100, 100};
		gbl_ethnicityCbPanel.rowHeights = new int[]{20, 20, 20};
		gbl_ethnicityCbPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_ethnicityCbPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		ethnicityCbPanel.setLayout(gbl_ethnicityCbPanel);
		
		caucasianCheckBox = new JCheckBox("Caucasian");
		GridBagConstraints gbc_caucasianCheckBox = new GridBagConstraints();
		gbc_caucasianCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_caucasianCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_caucasianCheckBox.gridx = 0;
		gbc_caucasianCheckBox.gridy = 0;
		ethnicityCbPanel.add(caucasianCheckBox, gbc_caucasianCheckBox);
		nativeAmericanCheckBox = new JCheckBox("Native American");
		GridBagConstraints gbc_nativeAmericanCheckBox = new GridBagConstraints();
		gbc_nativeAmericanCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_nativeAmericanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_nativeAmericanCheckBox.gridx = 2;
		gbc_nativeAmericanCheckBox.gridy = 0;
		ethnicityCbPanel.add(nativeAmericanCheckBox, gbc_nativeAmericanCheckBox);
		africanAmericanCheckBox = new JCheckBox("African American");
		GridBagConstraints gbc_africanAmericanCheckBox = new GridBagConstraints();
		gbc_africanAmericanCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_africanAmericanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_africanAmericanCheckBox.gridx = 0;
		gbc_africanAmericanCheckBox.gridy = 1;
		ethnicityCbPanel.add(africanAmericanCheckBox, gbc_africanAmericanCheckBox);
		asianCheckBox = new JCheckBox("Asian");
		GridBagConstraints gbc_asianCheckBox = new GridBagConstraints();
		gbc_asianCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_asianCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_asianCheckBox.gridx = 2;
		gbc_asianCheckBox.gridy = 1;
		ethnicityCbPanel.add(asianCheckBox, gbc_asianCheckBox);
		hispanicCheckBox = new JCheckBox("Hispanic");
		GridBagConstraints gbc_hispanicCheckBox = new GridBagConstraints();
		gbc_hispanicCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_hispanicCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_hispanicCheckBox.gridx = 0;
		gbc_hispanicCheckBox.gridy = 2;
		ethnicityCbPanel.add(hispanicCheckBox, gbc_hispanicCheckBox);
		otherEthnicityCheckBox = new JCheckBox("Other (specify)");
		GridBagConstraints gbc_otherEthnicityCheckBox = new GridBagConstraints();
		gbc_otherEthnicityCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_otherEthnicityCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_otherEthnicityCheckBox.gridx = 2;
		gbc_otherEthnicityCheckBox.gridy = 2;
		ethnicityCbPanel.add(otherEthnicityCheckBox, gbc_otherEthnicityCheckBox);
		otherEthnicityTextField = new JFormattedTextField();
		GridBagConstraints gbc_otherEthnicityTextField = new GridBagConstraints();
		gbc_otherEthnicityTextField.gridwidth = 2;
		gbc_otherEthnicityTextField.fill = GridBagConstraints.BOTH;
		gbc_otherEthnicityTextField.gridx = 3;
		gbc_otherEthnicityTextField.gridy = 2;
		ethnicityCbPanel.add(otherEthnicityTextField, gbc_otherEthnicityTextField);
		ethnicityPanel.setLayout(gl_ethnicityPanel);
		
		
		for(int i=0; i<ethnicityCbPanel.getComponents().length; i++) {
			if(ethnicityCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = new JCheckBox();
				myCb = (JCheckBox) ethnicityCbPanel.getComponent(i);
				myCb.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent event) {
						if((event.getStateChange() == ItemEvent.SELECTED) || (event.getStateChange() == ItemEvent.DESELECTED)) {
							toggleAllCheckBoxesInPanel(ethnicityCbPanel, event.getItem());
						}
						
					}
				});
			}
		}
		
		allegedVictimLabel = new JLabel("Alleged Victim");
		allegedVictimLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		firstNameLabel = new JLabel("First Name:");
		
		firstNameNotSetWarning = new JTextPane();
		firstNameNotSetWarning.setVisible(false);
		firstNameNotSetWarning.setEditable(false);
		firstNameNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameNotSetWarning.setForeground(Color.RED);
		firstNameNotSetWarning.setText("*");
		firstNameNotSetWarning.setBackground(SystemColor.menu);
		
		addressLabel = new JLabel("Address:");
		
		addrNotSetWarning = new JTextPane();
		addrNotSetWarning.setVisible(false);
		addrNotSetWarning.setEditable(false);
		addrNotSetWarning.setText("*");
		addrNotSetWarning.setForeground(Color.RED);
		addrNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addrNotSetWarning.setBackground(SystemColor.menu);
		
		dobLabel = new JLabel("DOB: ");
		
		dobNotSetWarning = new JTextPane();
		dobNotSetWarning.setVisible(false);
		dobNotSetWarning.setEditable(false);
		dobNotSetWarning.setText("*");
		dobNotSetWarning.setForeground(Color.RED);
		dobNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dobNotSetWarning.setBackground(SystemColor.menu);
		
		maritalStatusLabel = new JLabel("Marital Status:");
		
		maritalStatusNotSetWarning = new JTextPane();
		maritalStatusNotSetWarning.setEditable(false);
		maritalStatusNotSetWarning.setVisible(false);
		maritalStatusNotSetWarning.setText("*");
		maritalStatusNotSetWarning.setForeground(Color.RED);
		maritalStatusNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		maritalStatusNotSetWarning.setBackground(SystemColor.menu);
		
		maritalStatusText = new JTextField();
		maritalStatusText.setColumns(10);
		filter.setupTextField(maritalStatusText, DocumentSizeFilter.CHAR, 10);
		
		ageNotSetWarning = new JTextPane();
		ageNotSetWarning.setVisible(false);
		ageNotSetWarning.setEditable(false);
		ageNotSetWarning.setText("*");
		ageNotSetWarning.setForeground(Color.RED);
		ageNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ageNotSetWarning.setBackground(SystemColor.menu);
		
		ageLabel = new JLabel("Age:");
		
		monthText = new JTextField();
		monthText.setText("MM");
		monthText.setColumns(10);
		filter.setupTextField(monthText, DocumentSizeFilter.NO, 2);
		
		dayText = new JTextField();
		dayText.setText("DD");
		dayText.setColumns(10);
		filter.setupTextField(dayText, DocumentSizeFilter.NO, 2);
		
		sexNotSetWarning = new JTextPane();
		sexNotSetWarning.setEditable(false);
		sexNotSetWarning.setVisible(false);
		sexNotSetWarning.setText("*");
		sexNotSetWarning.setForeground(Color.RED);
		sexNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexNotSetWarning.setBackground(SystemColor.menu);
		
		sexLabel = new JLabel("Sex:");
		
		addressTextArea = new JTextArea();
		addressTextArea.setWrapStyleWord(true);
		addressTextArea.setLineWrap(true);
		
		firstNameText = new JFormattedTextField();
		filter.setupTextField(firstNameText, DocumentSizeFilter.CHAR, 20);
				
		lastNameLabel = new JLabel("Last Name:");
				
		lastNameText = new JFormattedTextField();
		filter.setupTextField(firstNameText, DocumentSizeFilter.CHAR, 20);
		
				
		sexCombo = new JComboBox();
		sexCombo.setModel(new DefaultComboBoxModel(new String[] {"<Select One>", "Male", "Female"}));
				
		yearText = new JTextField();
		yearText.setText("YYYY");
		yearText.setColumns(10);
		filter.setupTextField(yearText, DocumentSizeFilter.NO, 4);
				
		ageText = new JTextField();
		ageText.setColumns(10);
		filter.setupTextField(ageText, DocumentSizeFilter.NO, 3);
				
		lastNameNotSetWarning = new JTextPane();
		lastNameNotSetWarning.setVisible(false);
		lastNameNotSetWarning.setText("*");
		lastNameNotSetWarning.setForeground(Color.RED);
		lastNameNotSetWarning.setEditable(false);
		lastNameNotSetWarning.setBackground(SystemColor.menu);
		
		lblTelephone = new JLabel("Telephone");
		phoneAreaCode = new JFormattedTextField();
		filter.setupTextField(phoneAreaCode, DocumentSizeFilter.NO, 3);
		phoneFirstThree = new JFormattedTextField();
		filter.setupTextField(phoneFirstThree, DocumentSizeFilter.NO, 3);
		phoneLastFour = new JFormattedTextField();
		filter.setupTextField(phoneLastFour, DocumentSizeFilter.NO, 4);
		
		phoneHyphon = new JTextPane();
		phoneHyphon.setBackground(SystemColor.menu);
		phoneHyphon.setText("-");
		
		phoneNotSetWarning = new JTextPane();
		phoneNotSetWarning.setVisible(false);
		phoneNotSetWarning.setForeground(Color.RED);
		phoneNotSetWarning.setEditable(false);
		phoneNotSetWarning.setBackground(SystemColor.menu);
		phoneNotSetWarning.setText("*");
		GroupLayout gl_VictimPanel = new GroupLayout(VictimPanel);
		gl_VictimPanel.setHorizontalGroup(
			gl_VictimPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_VictimPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_VictimPanel.createSequentialGroup()
							.addComponent(maritalStatusLabel)
							.addGap(192)
							.addComponent(sexNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_VictimPanel.createSequentialGroup()
							.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addComponent(firstNameLabel)
									.addGap(13)
									.addComponent(firstNameNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addComponent(addressLabel)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(addrNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addComponent(dobLabel)
									.addGap(18)
									.addComponent(dobNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(addressTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(firstNameText, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_VictimPanel.createSequentialGroup()
												.addComponent(sexLabel)
												.addGap(63)
												.addComponent(sexCombo, 0, 195, Short.MAX_VALUE))
											.addGroup(gl_VictimPanel.createSequentialGroup()
												.addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)))
										.addGroup(gl_VictimPanel.createSequentialGroup()
											.addComponent(lblTelephone, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(phoneNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(phoneAreaCode, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(2)
											.addComponent(phoneHyphon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(phoneFirstThree, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(2)
											.addComponent(phoneLastFour, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addComponent(monthText, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dayText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(yearText, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lastNameNotSetWarning, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(ageLabel))
									.addGap(18)
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_VictimPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(ageNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(ageText, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
										.addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addComponent(maritalStatusNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(maritalStatusText, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE)))))
					.addGap(48))
				.addGroup(gl_VictimPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(allegedVictimLabel)
					.addContainerGap(460, Short.MAX_VALUE))
		);
		gl_VictimPanel.setVerticalGroup(
			gl_VictimPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_VictimPanel.createSequentialGroup()
					.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_VictimPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(allegedVictimLabel)
							.addGap(4)
							.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_VictimPanel.createSequentialGroup()
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(firstNameLabel)
										.addComponent(firstNameNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_VictimPanel.createParallelGroup(Alignment.BASELINE)
											.addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lastNameLabel)
											.addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_VictimPanel.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_VictimPanel.createSequentialGroup()
												.addGroup(gl_VictimPanel.createParallelGroup(Alignment.TRAILING)
													.addComponent(phoneHyphon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(addressLabel)
														.addComponent(addressTextArea, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_VictimPanel.createSequentialGroup()
															.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(sexLabel)
																.addComponent(sexNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addGroup(gl_VictimPanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblTelephone)
																.addComponent(phoneAreaCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(phoneLastFour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(phoneFirstThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addComponent(phoneNotSetWarning, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGap(18)
												.addGroup(gl_VictimPanel.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_VictimPanel.createParallelGroup(Alignment.BASELINE)
														.addComponent(monthText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(dayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(yearText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(ageText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(ageLabel))
													.addComponent(dobLabel)
													.addComponent(ageNotSetWarning, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addComponent(dobNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(addrNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_VictimPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(maritalStatusText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(maritalStatusNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(maritalStatusLabel)))
								.addComponent(lastNameNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_VictimPanel.createSequentialGroup()
							.addGap(72)
							.addComponent(sexCombo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		VictimPanel.setLayout(gl_VictimPanel);
		
		disabilityLabel = new JLabel("Disability: (check as apply)");
		disabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		disabilityNotSetWarning = new JTextPane();
		disabilityNotSetWarning.setVisible(false);
		disabilityNotSetWarning.setEditable(false);
		disabilityNotSetWarning.setForeground(Color.RED);
		disabilityNotSetWarning.setText("*");
		disabilityNotSetWarning.setBackground(SystemColor.menu);
		
		disabilityCbPanel = new JPanel();
		GroupLayout gl_DisabilityPanel = new GroupLayout(DisabilityPanel);
		gl_DisabilityPanel.setHorizontalGroup(
			gl_DisabilityPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DisabilityPanel.createSequentialGroup()
					.addGroup(gl_DisabilityPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_DisabilityPanel.createSequentialGroup()
							.addGap(14)
							.addComponent(disabilityLabel)
							.addGap(18)
							.addComponent(disabilityNotSetWarning, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_DisabilityPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(disabilityCbPanel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_DisabilityPanel.setVerticalGroup(
			gl_DisabilityPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DisabilityPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DisabilityPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(disabilityLabel)
						.addComponent(disabilityNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(disabilityCbPanel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GridBagLayout gbl_disabilityCbPanel = new GridBagLayout();
		gbl_disabilityCbPanel.columnWidths = new int[] {100, 100, 100, 90};
		gbl_disabilityCbPanel.rowHeights = new int[] {20, 20, 20, 20};
		gbl_disabilityCbPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_disabilityCbPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		disabilityCbPanel.setLayout(gbl_disabilityCbPanel);
		
		chckbxMentalRetardation = new JCheckBox("Mental Retardation");
		GridBagConstraints gbc_chckbxMentalRetardation = new GridBagConstraints();
		gbc_chckbxMentalRetardation.gridwidth = 2;
		gbc_chckbxMentalRetardation.anchor = GridBagConstraints.WEST;
		gbc_chckbxMentalRetardation.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMentalRetardation.gridx = 0;
		gbc_chckbxMentalRetardation.gridy = 0;
		disabilityCbPanel.add(chckbxMentalRetardation, gbc_chckbxMentalRetardation);
		
		chckbxMobility = new JCheckBox("Mobility");
		GridBagConstraints gbc_chckbxMobility = new GridBagConstraints();
		gbc_chckbxMobility.anchor = GridBagConstraints.WEST;
		gbc_chckbxMobility.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxMobility.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMobility.gridx = 2;
		gbc_chckbxMobility.gridy = 0;
		disabilityCbPanel.add(chckbxMobility, gbc_chckbxMobility);
		
		chckbxVisual = new JCheckBox("Visual");
		GridBagConstraints gbc_chckbxVisual = new GridBagConstraints();
		gbc_chckbxVisual.anchor = GridBagConstraints.WEST;
		gbc_chckbxVisual.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxVisual.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxVisual.gridx = 4;
		gbc_chckbxVisual.gridy = 0;
		disabilityCbPanel.add(chckbxVisual, gbc_chckbxVisual);
		chckbxMultipleSclerosis = new JCheckBox("Multiple Sclerosis");
		GridBagConstraints gbc_chckbxMultipleSclerosis = new GridBagConstraints();
		gbc_chckbxMultipleSclerosis.gridwidth = 2;
		gbc_chckbxMultipleSclerosis.anchor = GridBagConstraints.WEST;
		gbc_chckbxMultipleSclerosis.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMultipleSclerosis.gridx = 0;
		gbc_chckbxMultipleSclerosis.gridy = 1;
		disabilityCbPanel.add(chckbxMultipleSclerosis, gbc_chckbxMultipleSclerosis);
		chckbxMentalIllness = new JCheckBox("Mental Illness");
		GridBagConstraints gbc_chckbxMentalIllness = new GridBagConstraints();
		gbc_chckbxMentalIllness.anchor = GridBagConstraints.WEST;
		gbc_chckbxMentalIllness.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxMentalIllness.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMentalIllness.gridx = 2;
		gbc_chckbxMentalIllness.gridy = 1;
		disabilityCbPanel.add(chckbxMentalIllness, gbc_chckbxMentalIllness);
		chckbxDeafHard = new JCheckBox("Deaf / Hard of Hearing");
		GridBagConstraints gbc_chckbxDeafHard = new GridBagConstraints();
		gbc_chckbxDeafHard.anchor = GridBagConstraints.WEST;
		gbc_chckbxDeafHard.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxDeafHard.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxDeafHard.gridx = 4;
		gbc_chckbxDeafHard.gridy = 1;
		disabilityCbPanel.add(chckbxDeafHard, gbc_chckbxDeafHard);
		chckbxCerebralPalsy = new JCheckBox("Cerebral Palsy");
		GridBagConstraints gbc_chckbxCerebralPalsy = new GridBagConstraints();
		gbc_chckbxCerebralPalsy.gridwidth = 2;
		gbc_chckbxCerebralPalsy.anchor = GridBagConstraints.WEST;
		gbc_chckbxCerebralPalsy.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCerebralPalsy.gridx = 0;
		gbc_chckbxCerebralPalsy.gridy = 2;
		disabilityCbPanel.add(chckbxCerebralPalsy, gbc_chckbxCerebralPalsy);
		chckbxHeadInjury = new JCheckBox("Head Injury");
		GridBagConstraints gbc_chckbxHeadInjury = new GridBagConstraints();
		gbc_chckbxHeadInjury.anchor = GridBagConstraints.WEST;
		gbc_chckbxHeadInjury.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxHeadInjury.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHeadInjury.gridx = 2;
		gbc_chckbxHeadInjury.gridy = 2;
		disabilityCbPanel.add(chckbxHeadInjury, gbc_chckbxHeadInjury);
		chckbxSeizures = new JCheckBox("Seizures");
		GridBagConstraints gbc_chckbxSeizures = new GridBagConstraints();
		gbc_chckbxSeizures.gridwidth = 2;
		gbc_chckbxSeizures.anchor = GridBagConstraints.WEST;
		gbc_chckbxSeizures.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxSeizures.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSeizures.gridx = 0;
		gbc_chckbxSeizures.gridy = 3;
		disabilityCbPanel.add(chckbxSeizures, gbc_chckbxSeizures);
		chckbxOtherspecify = new JCheckBox("Other (specify)");
		GridBagConstraints gbc_chckbxOtherspecify = new GridBagConstraints();
		gbc_chckbxOtherspecify.anchor = GridBagConstraints.WEST;
		gbc_chckbxOtherspecify.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxOtherspecify.gridx = 2;
		gbc_chckbxOtherspecify.gridy = 3;
		disabilityCbPanel.add(chckbxOtherspecify, gbc_chckbxOtherspecify);
		
		disabilityOtherTextField = new JFormattedTextField();
		filter.setupTextField(disabilityOtherTextField, DocumentSizeFilter.ANY, 30);
		GridBagConstraints gbc_disabilityOtherTextField = new GridBagConstraints();
		gbc_disabilityOtherTextField.gridwidth = 2;
		gbc_disabilityOtherTextField.fill = GridBagConstraints.BOTH;
		gbc_disabilityOtherTextField.gridx = 3;
		gbc_disabilityOtherTextField.gridy = 3;
		disabilityCbPanel.add(disabilityOtherTextField, gbc_disabilityOtherTextField);
		
		DisabilityPanel.setLayout(gl_DisabilityPanel);
		
		setLayout(groupLayout);
	}

	/**
	 * Determines if the information entered at this stage (alleged victim input) is indeed
	 * valid and necessary information for the abuse report is not missing.
	 */
	@Override
	public boolean isValidInfo() {
		boolean disabilitySelected = false;
		boolean ethnicitySelected = false;
		boolean comNeedsSelected = false;
		boolean validInfo = true;
		

		int disabilityIndex = 0; // Need to get a sequential spot in the string.
		
		if(firstNameText.getText().equals("")){
			firstNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			firstNameNotSetWarning.setVisible(false);
		}
		if(lastNameText.getText().equals("")){
			lastNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			lastNameNotSetWarning.setVisible(false);
		}
		if(addressTextArea.getText().equals("")){
			addrNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			addrNotSetWarning.setVisible(false);
		}
		if(phoneAreaCode.getDocument().getLength() != 3 || phoneFirstThree.getDocument().getLength() != 3 || phoneLastFour.getDocument().getLength() != 4){
			phoneNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			phoneNotSetWarning.setVisible(false);
		}
		if(monthText.getText().equals("") || dayText.getText().equals("") || yearText.getText().equals("")){
			dobNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			dobNotSetWarning.setVisible(false);
		}
		if(sexCombo.getSelectedItem().equals(sexCombo.getItemAt(0))){
			sexNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			sexNotSetWarning.setVisible(false);
		}
		if(maritalStatusText.getText().equals("")){
			maritalStatusNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			maritalStatusNotSetWarning.setVisible(false);
		}
		if(ageText.getText().equals("")) {
			ageNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			ageNotSetWarning.setVisible(false);
		}
		
		// Confirm that a single disability is selected....
		for(int i=0; i<disabilityCbPanel.getComponentCount(); i++){
			if(disabilityCbPanel.getComponent(i) instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) disabilityCbPanel.getComponent(i);
				if(cb.isSelected()) {
					disabilitySelected = true;
				}
			}
		}
		if(!disabilitySelected){
			disabilityNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			disabilityNotSetWarning.setVisible(false);
		}
			
		// Confirm that a single ethnicity is selected...
		for(int i=0; i<ethnicityCbPanel.getComponentCount(); i++){
			if(ethnicityCbPanel.getComponent(i) instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) ethnicityCbPanel.getComponent(i);
				if(cb.isSelected()) {
					ethnicitySelected = true;
				}
			}
		}
		if(!ethnicitySelected) {
			ethnicityNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			ethnicityNotSetWarning.setVisible(false);
		}
		
		// Iterate through comneeds panel to determine if something was set.
		// FIXME: How do we handle the textfield in "other?" Same goes for similar
		//        scenarios above.
		for(int i=0; i<comNeedsCbPanel.getComponentCount(); i++) {
			if(comNeedsCbPanel.getComponent(i) instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) comNeedsCbPanel.getComponent(i);
				if(cb.isSelected()) {
					comNeedsSelected = true;
				}
			}
		}
		if(!comNeedsSelected){
			comNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			comNotSetWarning.setVisible(false);
		}
		
		return validInfo;
	}

	/**
	 * Communicate with the report object to commit alleged victim changes.
	 */
	@Override
	public Object commitInfo() {
		int disabilityIndex  = 0; 
		int comNeedsIndex    = 0;   
		
		Object obj;
		Victim victim = new Victim();
		
		victim.setFirstName(firstNameText.getText());
		victim.setLastName(lastNameText.getText());
		victim.setAddress(addressTextArea.getText());
		victim.setTelephone(phoneAreaCode.getText().concat(phoneFirstThree.getText().concat(phoneLastFour.getText())));
		victim.setFemale(sexCombo.getSelectedItem() == "Female");
		victim.setMale(sexCombo.getSelectedItem() == "Male");
		victim.setDateOfBirth(dayText.getText().concat("/").concat(monthText.getText().concat("/").concat(yearText.getText())));
		victim.setAge(ageText.getText());
		victim.setMaritalStatus(maritalStatusText.getText());
		
		// Get the names of each checkbox to determine the disability to add to string.
		for(int i=0; i<disabilityCbPanel.getComponentCount(); i++){
			if(disabilityCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = (JCheckBox) disabilityCbPanel.getComponent(i);
				if(myCb.isSelected()) {
					// Special case for the "other" option.
					if(!myCb.equals(chckbxOtherspecify)) {
						victim.setDisabilities(myCb.getText(), disabilityIndex++);
					} else {
						// Instead of grabbing text from the checkbox, grab it from the text field
						// when "other" is selected.
						victim.setDisabilities(disabilityOtherTextField.getText(), disabilityIndex++);
					}
				}
			}
		}
		
		// Disability and ethnicity are similar. If other is set, must take the other text field.
		for(int i=0; i<ethnicityCbPanel.getComponentCount(); i++){
			if(ethnicityCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = (JCheckBox) ethnicityCbPanel.getComponent(i);
				if(myCb.isSelected()) {
					// Special case for the "other" option.
					if(!myCb.equals(otherEthnicityCheckBox)) {
						victim.setEthnicity(myCb.getText());
					} else {
						// Instead of grabbing text from the checkbox, grab it from the text field
						// when "other" is selected.
						victim.setEthnicity(otherEthnicityTextField.getText());
					}
				}
			}
		}
		
		for(int i=0; i<comNeedsCbPanel.getComponentCount(); i++) {
			if(comNeedsCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox cb = (JCheckBox) comNeedsCbPanel.getComponent(i);
				if(cb.isSelected()) {
					// Special case for "other" option.
					if(!cb.equals(otherComNeedsCheckBox)) {
						victim.setComNeeds(cb.getText(), comNeedsIndex++);
					} else {
						victim.setComNeeds(otherComNeedsTextField.getText(), comNeedsIndex++);
					}
				}
			}
		}
		
		obj = victim;
		return victim;
	}

	
	/**
	 * Disables the checkboxes in this panel. First, a search is performed to determine if the textfield
	 * in this JPanel should be saved. If not, then all components are disabled. This forces
	 * the user to only select one checkbox per panel.
	 * @param container  - the panel to search for checkboxes.
	 * @param cb         - the checkbox to leave enabled.
	 */
	public void toggleAllCheckBoxesInPanel(Container container, Object cb){
		boolean enableText = false;
		if(cb.equals((JCheckBox) otherEthnicityCheckBox)){
			System.out.println("Do not disable corresponding text field");
			enableText = true;
		}
		for(int i=0; i<container.getComponents().length; i++){	
			// Disable all components in this panel.
			if(!container.getComponent(i).equals(cb)) {
				container.getComponent(i).setEnabled(!container.getComponent(i).isEnabled());
				// Check to see if the textfield should be saved and not disabled. This is only true 
				// when "other (please specify)" is selected.
				if((container.getComponent(i) instanceof JTextComponent) && enableText){
					container.getComponent(i).setEnabled(true);
				}
			}
		}
	}
}
