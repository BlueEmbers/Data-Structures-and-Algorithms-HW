package p2;

import java.util.Arrays;

public class GenericBag<T extends Comparable<T>> {
	private Object[] array;
	private int nElems;

	public GenericBag(int maxSize) {
		// array = new T[maxSize] Cannot create an array of generic types
		array = new Object[maxSize]; // Have to create an array of object type and cast it to Generic type
		nElems = 0;
	}

	//good
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println((T) array[i]);
		}
		System.out.println();
	}
	//good
	public T getElemAt(int index) {
		return (T) array[index];
	}
	
	//good
	public void insert(T element) {
		array[nElems++] = element;
		insertionSort();
	}

	@SuppressWarnings("unchecked")
	public void insertionSort() {
		int in, out;
		for (out = 1; out < nElems; out++) { // out is dividing line
			T temp = (T) array[out];
			in = out;
			while (in > 0 && ((Comparable<T>) array[in - 1]).compareTo(temp) > 0) {
				array[in] = (T) array[in - 1];
				--in;
			}
			array[in] = temp;
		} 
	}

	public void delMax() {
		//insertionSort();
		getArrayWithoutMax();
		nElems--;
	}

	public void delMin() {
		//insertionSort();
		getArrayWithoutMin();
		nElems--;
	}

	public T findMax() {
		//insertionSort();
		return (T) array[nElems - 1];
	}

	public T findMin() {
		//insertionSort();
		return (T) array[0];
	}
	
	
	private void getArrayWithoutMin() {
		Object[] tempArray = new Object[nElems - 1];
		for (int i = 0, j = 1; j < nElems; i++, j++) {
			tempArray[i] = array[j];	    
		}
		array = tempArray;
	}
	
	private void getArrayWithoutMax() {
		Object[] tempArray = new Object[nElems - 1];
		for (int i = 0; i < nElems - 1; i++) {
			tempArray[i] = array[i];	    
		}
		array = tempArray;
	}

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}

}

