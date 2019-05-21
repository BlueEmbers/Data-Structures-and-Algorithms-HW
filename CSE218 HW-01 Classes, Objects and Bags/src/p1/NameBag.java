package p1;

import java.io.Serializable;

public class NameBag implements Serializable {
	private Name[] array;
	private int nElems;

	public NameBag() {
	}

	public NameBag(int maxSize) {
		array = new Name[maxSize];
		nElems = 0;
	}

	public void insert(Name name) {
		array[nElems++] = name;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Name getElemAt(int index) {
		return array[index];
	}

	public int getNElems() {
		return nElems;
	}

	public boolean checkSize() {
		if (nElems == array.length)
			return true;
		else
			return false;
	}

	public void increaseBagSize() {
		if (checkSize()) {
			Name[] temp = new Name[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
	}
	
	public boolean isFull(int noOfItems) {
		if(nElems == noOfItems) 
			return true;
		else 
			return false;		
	}
}

