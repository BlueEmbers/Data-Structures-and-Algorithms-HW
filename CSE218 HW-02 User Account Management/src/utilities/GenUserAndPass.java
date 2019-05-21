package utilities;

import java.util.Random;

public class GenUserAndPass {
	public static String genUser(String firstName, String lastName, String id) {
		char[] firstNameChar = firstName.toCharArray();
		String firstNameUser;
		try {
			firstNameUser = String.valueOf(firstNameChar,0,1);
		} catch (StringIndexOutOfBoundsException e) {
			firstNameUser = "";
		}
		
		
		String lastNameUser;
		if(lastName.length()<4) {
			lastNameUser = lastName;
		} else {
			char[] lastNameChar = lastName.toCharArray();
			lastNameUser = String.copyValueOf(lastNameChar, 0, 4);
		}
		
		char[] idChar = id.toCharArray();
		String idUser = String.copyValueOf(idChar, 0, 1);
		
		return firstNameUser + lastNameUser + idUser;
	}
	
	public static String genPass() {
		String rawContent = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
							"abcdefghijklmnopqrstuvwxyz" + 
							"0123456789" +
							" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		Random random = new Random();
		
		String password = "";
		do {
			password.concat(String.valueOf(rawContent.charAt(random.nextInt(26+26+10+32))));
		} while (!isCapablePassword(password));
		return password;
	}
	
	private static boolean isCapablePassword(String password) {
		if(hasUpperCaseLetter(password) 
				&& hasLowerCaseLetter(password) 
				&& hasSymbols(password) 
				&& hasMinimumLength(password, 8)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean hasUpperCaseLetter(String password) {
		boolean upperFlag = false;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				upperFlag = true;
			}
		}
		return upperFlag;
	}
	
	private static boolean hasLowerCaseLetter(String password) {
		boolean lowerFlag = false;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				lowerFlag = true;
			}
		}
		return lowerFlag;
	}
	
	private static boolean hasSymbols(String password) {
		boolean symbolFlag = false;
		String symbols = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		for(int i = 0; i < password.length(); i++) {
			String str = String.valueOf(symbols.charAt(i));
			if (password.contains(str)) {
				symbolFlag = true;
			}
		}
		return symbolFlag;
	}
	
	private static boolean hasMinimumLength(String password, int length) {
		if(password.length() >= length) {
			return true;
		} else {
			return false;
		}
	}
}

