package p5;

public class StringReverser {

	public static void main(String[] args) {
		
		String string = "Say something backwards!";
		
		String reverse = "";
		
		System.out.println(stringReverser(string, reverse, 0));
		

	}
	
	
	public static String stringReverser(String string, String reverse, int marker) {
		reverse = reverse + string.charAt((string.length()- 1) - marker++);
		if(marker == string.length()) {
			return reverse;
		}else {
			return stringReverser(string, reverse, marker);
		}
	}
}
