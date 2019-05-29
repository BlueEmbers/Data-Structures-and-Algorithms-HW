package p2;

public class Link {

	private Student student;
	private Link next;
	
	Link(Student student){
		this.student = student;
		this.next = null;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
	
	public void displayLink() {
		System.out.print(student + " ");
	}
}
