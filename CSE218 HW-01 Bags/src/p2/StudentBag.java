package p2;

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

}

