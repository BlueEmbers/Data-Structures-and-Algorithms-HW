package p1;

public class Demo {

	public static void main(String[] args) {
		Integer[] integers = {1, 4, 6, 7, 10};
		//System.out.println(integers[1].compareTo(integers[0]));
		String[] strings = {"Aey", "Lol", "Me", "Nina", "Panther"};
		Double[] decimals = {1.2, 1.9, 2.1, 3.2, 9.7};	
		Character[] characters = {'a', 'e', 'q', 'v', 'z'};
		
		System.out.println("index of integer: " + genericBinarySearch(integers, -1));
		System.out.println("index of strings: " + genericBinarySearch(strings, "Me"));
		System.out.println("index of decimals: " + genericBinarySearch(decimals, 1.9));
		System.out.println("index of chars: " + genericBinarySearch(characters, 'z'));	
	}

	public static <E extends Comparable <E>> int genericBinarySearch(E[] list ,E value) {
		int low = 0;
		int high = list.length - 1;	
		while (high >= low) {
			int mid = (low + high) / 2;	
			if (value.compareTo(list[mid]) == 0)
				return mid;
			else if (value.compareTo(list[mid]) > 0)
				low = mid + 1;	
			else
				high = mid - 1;
		 }	
		return -1; 			// Now high < low, key not found 
	}

}

