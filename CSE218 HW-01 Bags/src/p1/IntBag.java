package p1;

public class IntBag {

	private int[] intArray;
	private int nElems;

	public IntBag(int maxSize) {
		intArray = new int[maxSize];
		nElems = 0;
	}

	public void add(int value) {
		intArray[nElems++] = value;
	}

	public boolean search(int value) {
		for (int i = 0; i < nElems; i++) {
			if (intArray[i] == value) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(int value) {
		for (int i = 0; i < nElems; i++) {
			if (intArray[i] == value) {
				for (int j = i; j <= nElems; j++) {
					intArray[j] = intArray[j + 1];
				}
				nElems--;
				return true;
			}
		}
		return false;
	}

	public int findMin() {
		int min = intArray[0];
		for (int i = 0; i < nElems; i++) {
			if (intArray[i] < min) {
				min = intArray[i];
			}
		}
		return min;
	}

	public int findMax() {
		int max = intArray[0];
		for (int i = 0; i < nElems; i++) {
			if (intArray[i] > max) {
				max = intArray[i];
			}
		}
		return max;
	}

	public double findMean() {
		double total = 0;
		for (int i = 0; i < nElems; i++) {
			total = total + intArray[i];
		}
		return total / (double) nElems;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}
}

