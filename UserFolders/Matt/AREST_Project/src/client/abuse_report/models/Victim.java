package client.abuse_report.models;





/**
 * A victim is an Individual who has been allegedly abused by an Abuser.
 * @author Matt Orsini
 *
 */
public class Victim extends Individual {

	private static final int MAX_NUM_COMMUNICATION_NEEDS = 3;
	private static final int MAX_NUM_DISABILITIES        = 20;
	private static final int MAX_NUM_CURR_SERVED_BY      = 10;
		
	private boolean male;
	private boolean female;
	private String dateOfBirth;
	private String age;
	private String maritalStatus; 
	
	private String[] disabilities = new String[MAX_NUM_DISABILITIES];
	private String ethnicity;
	private String[] comNeeds = new String [MAX_NUM_COMMUNICATION_NEEDS];
	private String[] currServedBy = new String[MAX_NUM_CURR_SERVED_BY];
	private boolean awareOfReport;
	private String typeOfService;
	private String[] typesOfAbuse;
	private String freqOfAbuse;
	private String dateOfLastIncident;

	/**
	 * Constructor for Victim. Superclass is an Individual.
	 */
	public Victim(){
		// FIXME: Empty constructor.
	}

	/**
	 * Returns if the Victim is a male.
	 * @return male
	 */
	public boolean isMale() {
		return male;
	}
	/**
	 * Sets the Victim to male. Victims cannot be male and female, so female will be cleared.
	 * @param male
	 */
	public void setMale(boolean male) {
		if(male) {
			this.male = male;
			setFemale(false);
		}
	}

	/**
	 * Returns if the Victim is a female.
	 * @return female
	 */
	public boolean isFemale() {
		return female;
	}
	/**
	 * Sets the Victim is a female. Victims cannot be male and female, so male will be cleared.
	 * @param female
	 */
	public void setFemale(boolean female) {
		if(female){
			this.female = female;
			setMale(false);
		}
	}

	/**
	 * Returns the date of birth for the Victim.
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * Set the date of birth for the Victim.
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Returns the age of the Victim.
	 * @return age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * Set the age of the Victim.
	 * @param string
	 */
	public void setAge(String string) {
		this.age = string;
	}

	/**
	 * Returns the marital status of the Victim.
	 * @return
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * Sets the marital status of the Victim. 
	 * 	@param maritalStatus
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	/**
	 * Sets the disabilities for this client.
	 * @param disability  - the disability
	 * @param n           - the index
	 */
	public void setDisabilities(String disability, int n){
		this.disabilities[n] = disability;
	}
	
	/**
	 * Gets all disabilities for this client.
	 * @return disabilities - the disability array.
	 */
	public String[] getDisabilities(){
		return disabilities;
	}
	
	/**
	 * Gets the disability at the specified index.
	 * @return disabilities[n] - the disability at the position n.
	 */
	public String getDisabilityAt(int n) {
		return disabilities[n];
	}

	/**
	 * Get the ethnicity for this client.
	 * @return ethnicity - the ethnicity of the client.
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * Set the ethnicity for this client.
	 * @param ethnicity - the ethnicity of the client.
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
	/**
	 * Set the communication needs for thsi client.
	 * @param comNeeds
	 */
	public void setComNeeds(String comNeeds, int n){
		this.comNeeds[n] = comNeeds;
	}
	
	/**
	 * Get the communication needs for this client.
	 */
	public String[] getComNeeds() {
		return comNeeds;
	}

	
	/**
	 * @return if the client is aware of this abuse report.
	 */
	public boolean isAwareOfReport() {
		return awareOfReport;
	}
	
	/**
	 * @param awareOfReport is the client's awareness of this abuse report.
	 */
	public void setAwareOfReport(boolean awareOfReport) {
		this.awareOfReport = awareOfReport;
	}

	/**
	 * Get the type of service.
	 * @return the type of service.
	 */
	public String getTypeOfService() {
		return typeOfService;
	}

	/**
	 * Set the type of service
	 * @param typeOfService - the typeOfService
	 */
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	/**
	 * Get all types of abuse.
	 * @return the typesOfAbuse
	 */
	public String[] getTypesOfAbuse() {
		return typesOfAbuse;
	}
	
	/**
	 * Set all types of abuse.
	 * @param typesOfAbuse - the types of abuse.
	 */
	public void setTypesOfAbuse(String[] typesOfAbuse) {
		this.typesOfAbuse = typesOfAbuse;
	}
	
	/**
	 * Get the type of abuse at the specified index.
	 * @param n - the index to get the abuse from.
	 * @return the type of abuse
	 */
	public String getTypeOfAbuseAt(int n) {
		return typesOfAbuse[n];
	}

	/**
	 * Set the types of abuse;
	 * @param typesOfAbuse
	 */
	public void setTypeOfAbuseAt(String typeOfAbuse, int n) {
		this.typesOfAbuse[n] = typeOfAbuse;
	}

	/**
	 * Gets the frequency of abuse.
	 * @return the freqOfAbuse
	 */
	public String getFreqOfAbuse() {
		return freqOfAbuse;
	}

	/**
	 * Set the frequency of abuse.
	 * @param freqOfAbuse the freqOfAbuse to set
	 */
	public void setFreqOfAbuse(String freqOfAbuse) {
		this.freqOfAbuse = freqOfAbuse;
	}

	/**
	 * Get the date of the last incident.
	 * @return the dateOfLastIncident
	 */
	public String getDateOfLastIncident() {
		return dateOfLastIncident;
	}

	/**
	 * Set the date of the last incident.
	 * @param dateOfLastIncident the dateOfLastIncident to set
	 */
	public void setDateOfLastIncident(String dateOfLastIncident) {
		this.dateOfLastIncident = dateOfLastIncident;
	}

	/**
	 * Returns the services provided to this victim.
	 * @return the services provided to this victim.
	 */
	public String[] getCurrServedBy() {
		return currServedBy;
	}
	
	/**
	 * Returns the service provided at the specified index.
	 * @param i - the index of the service provided.
	 * @return the service provided.
	 */
	public String getCurrServedByAt(int i){
		return currServedBy[i];
	}

	/**
	 * Sets the service provided at the specified index.
	 * @param currServedBy - the service provided
	 * @param i - the position in the array to put this service.
	 */
	public void setCurrServedByAt(String currServedBy, int i) {
		this.currServedBy[i] = currServedBy;
	}
	
	/**
	 * Set the services provided to this victim.
	 * @param currServedBy - the services provided to this victim.
	 */
	public void setCurrServedBy(String[] currServedBy) {
		this.currServedBy = currServedBy;
	}
	
	
}