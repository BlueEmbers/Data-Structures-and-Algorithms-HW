package p01;

public class GenericBinarySearch {
	
	public static <E extends Comparable<E>> int binarySearch(E[] array, E value) {
		int low = 0;
		int high = array.length-1;
		int position = -1;
		
		while(high>=low) {
			int mid = (low + high) / 2;
			
			if(array[mid].compareTo(value) > 0) {
				high = mid - 1;
			} else if (array[mid].compareTo(value) == 0) {
				position = mid;
				return position;
			} else {
				low = mid + 1;
			}
			
		}
		return position;
	}
}
