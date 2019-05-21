package p2;

public class StackLinkList {

	private Link first;
	
	public StackLinkList() {
		first = null;
	}
	
	public void insertFirst(Student student) {
		Link newLink = new Link(student);
		newLink.setNext(first);
		first = newLink;
	}
	
	public Student deleteFirst() {
		Student temp = first.getStudent();
		first = first.getNext();
		return temp;
	}
	public boolean isEmpty() {
		return first == null;
	}
}
