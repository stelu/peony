package ulive.util;

public class UliveUtil {

	public String generateRandomSuffix(int length) {

		double randomNum = Math.random();

		int randomInt = (int) (randomNum * Math.pow(10.0D, length));

		String randomString = randomInt + "";

		return randomString;
	}

	public String generateRandomCharacters(int length) {

		StringBuffer randomCharacters = new StringBuffer("");

		for (int i = 0; i < length; ++i) {
			randomCharacters
					.append((char) (int) (Math.random() * 26.0D + 97.0D));
		}

		return randomCharacters.toString();
	}
}
