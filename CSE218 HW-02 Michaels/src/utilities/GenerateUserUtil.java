package utilities;

public class GenerateUserUtil {
	private GenerateUserUtil(){
	}
	public static String generateUserName(String lastName, String firstName, String iD) {
		return testLastName(lastName) + firstName.charAt(0) + iD.charAt(iD.length() - 1);
	}
	public static String formatId(String iD) {
		String newID = String.valueOf(iD);
		for(int i = 8 - newID.length(); i > 0; i--) {
			newID = "0" + newID;
		}
		return newID;
	}
	
	private static String testLastName(String lastName) {
		String newString = "";
		for (int i = 0; i < lastName.length(); i++) {
			if (Character.isAlphabetic(lastName.charAt(i))) {
				newString += lastName.charAt(i);
			}
		}
		if (newString.length() < 4) {
			return newString;
		}
		return newString.substring(0, 4);
	}
}
