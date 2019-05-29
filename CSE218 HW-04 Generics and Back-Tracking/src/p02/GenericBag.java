package p02;

import java.util.ArrayList;

public class GenericBag <E extends Comparable<E>>{
	public E[] array;
	private int nElems;
	
	public GenericBag(int maxSize) {
		array = (E[]) new Comparable[maxSize];
		nElems = 0;
	}
	
	public E add(E e) {
		array[nElems++] = e;
		return array[nElems-1];
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(array[i]);
		}
	}
	
	public E findMax() {
		E e = array[0];
		for(int i = 0; i < nElems; i++) {
			if(array[i].compareTo(e)>0) {
				e = array[i];
			}
		}
		return e;
	}
	
	public E findMin() {
		E e = array[0];
		for(int i = 0; i < nElems; i++) {
			if(array[i].compareTo(e)<0) {
				e = array[i];
			}
		}
		return e;
	}
	
	public void deleteMax() {
		E e = array[0];
		int j = 0;
		for(int i = 0; i < nElems; i++) {
			if(array[i].compareTo(e)>0) {
				e = array[i];
				j = i;
			}
		}
		
		for(int i = j; i < nElems-1; i++) {
			array[i] = array[i+1];
		}
		nElems--;
	}
	
	public void deleteMin() {
		E e = array[0];
		int j = 0;
		for(int i = 0; i < nElems; i++) {
			if(array[i].compareTo(e)<0) {
				e = array[i];
				j = i;
			}
		}
		
		for(int i = j; i < nElems-1; i++) {
			array[i] = array[i+1];
		}
		nElems--;
	}
	
	public void insertionSort() {
		int in;
		int out;
		
		for(out = 1; out < nElems; out++) {
			E temp = array[out];
			in = out;
			while(in > 0 && array[in-1].compareTo(temp)>=0) {
				array[in] =array[in-1];
				in--;
			}
			array[in] = temp;
		}
	}
	
}

