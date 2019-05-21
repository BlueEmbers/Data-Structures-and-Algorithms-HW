package utilities;

import java.util.Random;

public class PasswordUtil {
	final static int MINIMUM_PASSWORD_LENGTH = 8;
	static Random rand;
	private PasswordUtil() {	
	}
	public static String generatePassword() {
		String password;
		rand = new Random();
		String charsString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "1234567890"
				+ " !#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		do {
			password = "";
			for (int i = 0; i < MINIMUM_PASSWORD_LENGTH; i++) {
				password += charsString.charAt(rand.nextInt(94));
			}
		} while (!correctFormat(password));
		return password;
	}

	private static boolean correctFormat(String password) {
		return hasACaptial(password)
				&& hasALowerCase(password)
				&& containsSymbol(password)
				&& isMinimumLength(password);
	}

	private static boolean hasACaptial(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasALowerCase(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean containsSymbol(String password) {
		String compareSymbols = " !#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		for (int i = 0; i < compareSymbols.length(); i++) {
			String compareString = String.valueOf(compareSymbols.charAt(i));
			if (password.contains(compareString)) {
				return true;
			}
		}
		return false;
	}
	private static boolean isMinimumLength(String password) {
		return password.length() >= MINIMUM_PASSWORD_LENGTH;
	}
}
