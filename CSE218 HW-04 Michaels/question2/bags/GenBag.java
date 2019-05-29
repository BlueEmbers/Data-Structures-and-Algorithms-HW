package bags;

import java.util.Arrays;

public class GenBag<T extends Comparable<T>> {
	private T[] array;
	private int maxSize;
	private int nElems;

	@SuppressWarnings("unchecked")
	public GenBag(int maxSize) {
		nElems = 0;
		this.maxSize = maxSize;
		array = (T[]) new Comparable[maxSize];
	}

	public boolean add(T obj) {
		if (!isFull()) {
			array[nElems++] = obj;
			return true;
		}
		return false;
	}

	public T findMax() {
		return array[nElems - 1];
	}

	public T findMin() {
		return array[0];
	}

	public T deleteMax() {
		T temp = array[nElems - 1];
		//array = Arrays.copyOfRange(array, 0, --nElems);
		array[nElems - 1] = null;
		nElems--;
		return temp;
	}

	public T deleteMin() {
		T temp = array[0];
		//array = Arrays.copyOfRange(array, 1, nElems--);
		array = Arrays.copyOfRange(array, 1, maxSize + 1);
		nElems--;
		return temp;
	}

	public void insertionSort() {
		int in;
		int out;
		for (out = 0; out < nElems; out++) {
			T temp = array[out];
			in = out;
			while (in > 0 && array[in - 1].compareTo(temp) >= 0) {
				array[in] = array[in - 1];
				in--;
			}
			array[in] = temp;
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(array[i].toString());
		}
	}

	public String displayString() {
		String display = "Displaying Bag \n";
		for (int i = 0; i < nElems; i++) {
			display += array[i].toString() + ", ";
			if(i == 10) {
				display += "\n";
			}
		}
		return display + "\n";
	}

	public boolean isFull() {
		return nElems == maxSize;
	}

	public T[] getArray() {
		return array;
	}

	public boolean isEmpty() {
		return nElems == 0;
	}

}
