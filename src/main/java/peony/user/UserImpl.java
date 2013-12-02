package peony.user;

public class UserImpl implements User {

	protected String emailAddress = null;
	protected String firstName = null;
	protected String lastName = null;
	protected String homeAddress = null;
	protected String homeCity = null;
	protected String homeState = null;
	protected String homeZip = null;
	protected String homePhoneNumber = null;
	protected String birthYear = null;

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress1) {
		this.homeAddress = homeAddress;
	}

	public String getHomeCity() {
		return this.homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeState() {
		return this.homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomeZip() {
		return this.homeZip;
	}

	public void setHomeZip(String homeZip) {
		this.homeZip = homeZip;
	}

	public String getHomePhoneNumber() {
		return this.homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}
	
	public String getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String toString() {
		return "User: {emailAddress: " + this.emailAddress + " firstName: "
				+ this.firstName + " lastName: " + this.lastName + "}";
	}
}
