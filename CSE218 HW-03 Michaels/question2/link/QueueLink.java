package link;

import people.Student;

public class QueueLink {
	private Student student;
	private QueueLink next;
	
	public QueueLink(Student student) {
		this.student = student;
		next = null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public QueueLink getNext() {
		return next;
	}

	public void setNext(QueueLink next) {
		this.next = next;
	}

	public void displayLink() {
		System.out.println(student.toString());
	}
	
}
