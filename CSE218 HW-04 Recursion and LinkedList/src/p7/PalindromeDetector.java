package p7;

public class PalindromeDetector {

	public static void main(String[] args) {
		
		String one = "AMANAPLANACANALPANAMA";
		String two = "Racecar";
		String three = "1000100000010001";
		System.out.println(palindromeDetector(one, 0));
		System.out.println(palindromeDetector(two, 0));
		System.out.println(palindromeDetector(three, 0));

	}
	public static boolean palindromeDetector(String string, int index) {
		if(index == string.length()/2) {
			return true;
		}
		if(string.charAt(index) != string.charAt(string.length()-1 -index)) {
			return false;
		}
			return palindromeDetector(string, ++index);
	}
}
