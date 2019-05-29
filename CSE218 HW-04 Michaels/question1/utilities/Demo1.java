package utilities;

public class Demo1 {

	public static void main(String[] args) {
		Character[] chars = { 'A', 'B', 'C', 'D', 'E', 'F' };
		Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
		System.out.println(genBinarySearch(chars, 0, chars.length, 'D'));
		System.out.println(genBinarySearch(doubles, 0, doubles.length, 2.2));
	}

	private static <E extends Comparable<E>> int genBinarySearch(E[] array, int first, int last, E key) {
		int middle;
		if (first > last) {
			return -1;
		}
		middle = (first + last) / 2;
		if (array[middle].compareTo(key) == 0) {
			return middle;
		} else if (array[middle].compareTo(key) < 0) {
			return genBinarySearch(array, middle + 1, last, key);
		} else {
			return genBinarySearch(array, first, middle - 1, key);
		}
	}
	
}
