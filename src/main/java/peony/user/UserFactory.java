package peony.user;


public class UserFactory {

	private static String userEmailAddress;
	private static String userFirstName;
	private static String userLastName;
	private static String userHomeAddress;
	private static String userHomePhoneNumber;
	private static String userBirthYear;

	public static User createUser() {

		userEmailAddress = "userEmail" + generateRandomSuffix(3)+ "@sni.com";
		userFirstName = "Bobby" + generateRandomCharacters(2);
		userLastName = "Flay" + generateRandomCharacters(2);
		userHomeAddress = generateRandomSuffix(3) + " " + "Mission Street";
		userHomePhoneNumber = "415-645-" + generateRandomSuffix(4);
		userBirthYear = "19" + generateRandomSuffix(2);
		
		return createUser(userEmailAddress, userFirstName, userLastName,
				userHomeAddress, "San Francisco", "CA", "94105",
				userHomePhoneNumber, userBirthYear);
	}

	public static User createUser(String emailAddress) {

		userFirstName = "Bobby" + generateRandomCharacters(2);
		userLastName = "Flay" + generateRandomCharacters(2);
		userHomeAddress = generateRandomSuffix(3) + " " + "Mission Street";
		userHomePhoneNumber = "415-645-" + generateRandomSuffix(4);
		userBirthYear = "19" + generateRandomSuffix(2);
		
		return createUser(emailAddress, userFirstName, userLastName,
				userHomeAddress, "San Francisco", "CA", "94105",
				userHomePhoneNumber, userBirthYear);
	}
	
	public static User createUser(String emailAddress, String fName, String lName) {
		
		userHomeAddress = generateRandomSuffix(3) + " " + "Mission Street";
		userHomePhoneNumber = "415-645-" + generateRandomSuffix(4);
		userBirthYear = "19" + generateRandomSuffix(2);
		
		return createUser(emailAddress, fName, lName,
				userHomeAddress, "San Francisco", "CA", "94105",
				userHomePhoneNumber, userBirthYear);
	}
	
	public static User createUser(String emailAddress, String firstName,
			String lastName, String homeAddress, String homeCity,
			String homeState, String homeZip, String homePhoneNumber,
			String birthYear) {

		UserImpl user = new UserImpl();

		user.setEmailAddress(emailAddress);

		user.setFirstName(firstName);

		user.setLastName(lastName);

		user.setHomeAddress(homeAddress);

		user.setHomeCity(homeCity);

		user.setHomeState(homeState);

		user.setHomeZip(homeZip);

		user.setHomePhoneNumber(homePhoneNumber);

		user.setBirthYear(birthYear);

		return user;
	}

	private static String generateRandomSuffix(int length) {

		double randomNum = Math.random();

		int randomInt = (int) (randomNum * Math.pow(10.0D, length));

		String randomString = randomInt + "";

		return randomString;
	}

	private static String generateRandomCharacters(int length) {

		StringBuffer randomCharacters = new StringBuffer("");

		for (int i = 0; i < length; ++i) {
			randomCharacters
					.append((char) (int) (Math.random() * 26.0D + 97.0D));
		}

		return randomCharacters.toString();
	}

}
