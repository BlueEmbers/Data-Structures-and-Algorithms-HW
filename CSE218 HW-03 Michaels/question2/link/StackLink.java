package link;

import people.Student;

public class StackLink {
	private Student student;
	private StackLink next;
	
	public StackLink(Student student) {
		this.student = student;
		this.next = null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StackLink getNext() {
		return next;
	}

	public void setNext(StackLink next) {
		this.next = next;
	}
	public void displayLink() {
		System.out.println(student.toString());
	}
}
