package models;

import people.Student;

public class QueueModel {
	private int maxSize;
	private Student[] students;
	private int front;
	private int rear;
	private int nElems;
	
	public QueueModel() {
		this.maxSize = 20;
		students = new Student[maxSize];
		front = 0;
		rear = -1;
		nElems = 0;
	}
	public Student peakFront() {
		return students[front];
	}
	public boolean isEmpty() {
		return nElems == 0;
	}
	public boolean isFull() {
		return nElems == maxSize;
	}

	public int size() {
		return nElems;
	}
	public Student insert(Student student) {
		if (rear == maxSize - 1)
		{
			rear = -1;
		}
		if(!isFull()) {
		students[++rear] = student;
		students[rear].setId(++nElems);
		return student;
		}
		return null;
	}
	public Student remove() {
		if(!isEmpty()) {
		Student temp = students[front++];
		if (front == maxSize) {
			front = 0;
		}
		nElems--;
		return temp;
		}
		return null;
	}
}
