package p2;

public class QueueLinkList {

	private Link first;
	private Link last; 
	
	public QueueLinkList() {
		first = null;
		last = null;
	}
	
	public Student deleteFirst() {
		Student temp = first.getStudent();
		first = first.getNext();
		return temp;
	}
	
	public void insertLast(Student student) {
		Link newLink = new Link(student);
		if(isEmpty()) {
			first = newLink;
		}else {
			last.setNext(newLink);
		}
		last = newLink;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}
