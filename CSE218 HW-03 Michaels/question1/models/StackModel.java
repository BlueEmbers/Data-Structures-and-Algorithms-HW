package models;

import people.Student;

public class StackModel {
	private Student[] students;
	private int top;
	private int maxSize;
	public StackModel() {
		top = -1;
		maxSize = 20;
		this.students = new Student[maxSize];
	}
	public Student push(Student student) {
		if(!isFull()) {
		students[++top] = student;
		students[top].setId(top + 1);
		}
		else {
			return student = null;
		}
		return student;
	}
	public Student pop() {
		if(!isEmpty()) {
			return students[top--];
		}
		return null;
	}
	public Student peek() {
		return students[top];
	}
	public boolean isFull() {
		return top == maxSize - 1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
}
