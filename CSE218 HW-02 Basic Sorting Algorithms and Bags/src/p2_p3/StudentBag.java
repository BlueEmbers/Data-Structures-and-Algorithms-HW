package p2_p3;

import java.text.DecimalFormat;

public class StudentBag {
	private Student[] students;
	private int nElems;

	public StudentBag(int maxSize) {
		students = new Student[maxSize];
		nElems = 0;
	}

	public void add(Student student) {
		students[nElems++] = student;
	}

	public boolean search(String id) {
		for (int i = 0; i < nElems; i++) {
			if (students[i].getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(String id) {
		for (int i = 0; i < nElems; i++) {
			if (students[i].getId().equals(id)) {
				for (int j = i; j < nElems; j++) {
					students[j] = students[j + 1];
				}
				nElems--;
				return true;
			}
		}
		return false;
	}

	public double findMin() {
		double min = students[0].getGpa();
		for (int i = 0; i < nElems; i++) {
			if (students[i].getGpa() < min) {
				min = students[i].getGpa();
			}
		}
		return min;
	}

	public double findMax() {
		double max = students[0].getGpa();
		for (int i = 0; i < nElems; i++) {
			if (students[i].getGpa() > max) {
				max = students[i].getGpa();
			}
		}
		return max;
	}

	public double findMean() {
		double total = 0;
		for (int i = 0; i < nElems; i++) {
			total = total + students[i].getGpa();
		}
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(total / (double) nElems));
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(students[i]);
		}
		System.out.println();
	}

	public long selectionSort() {
		Student temp;
		int out;
		int in;
		int min;
		long timer = 0;
		long t = System.currentTimeMillis();

		for (out = 0; out < nElems - 1; out++) {
			min = out;
			for (in = out + 1; in < nElems; in++) {
				int one = Integer.parseInt(students[in].getId());
				int two = Integer.parseInt(students[min].getId());
				if (one < two) {
					min = in;
				}
			}
			swap(out, min);
		}
		timer = System.currentTimeMillis() - t;
		return timer;
	}



	public long insertionSort() {

		Student temp;
		int marker;
		int in;
		long timer = 0;
		long t = System.currentTimeMillis();
		
		for (marker = 1; marker < nElems; marker++) {
			temp = students[marker];
			in = marker;
			while (in > 0 && students[in - 1].getGpa() >= temp.getGpa()) {
				students[in] = students[in - 1];
				in--;
			}
			students[in] = temp;
		}
		timer = System.currentTimeMillis() - t;
		return timer;
	}

	private void swap(int out, int min) {
		Student temp = students[out];
		students[out] = students[min];
		students[min] = temp;
	}

	public long bubbleSort() {
		Student temp;
		int i;
		int j;
		long timer = 0;
		long t = System.currentTimeMillis();
		
		for (j = nElems - 1; j > 0; j--) {
			for (i = 0; i < j; i++) {
				String one = (students[i].getLastName() + students[i].getFirstName());
				String two = (students[i + 1].getLastName() + students[i + 1].getFirstName());
				if (one.compareTo(two) > 0) {
					temp = students[i + 1];
					students[i + 1] = students[i];
					students[i] = temp;
				}
			}
		}
		timer = System.currentTimeMillis() - t;
		return timer;

	}

}
