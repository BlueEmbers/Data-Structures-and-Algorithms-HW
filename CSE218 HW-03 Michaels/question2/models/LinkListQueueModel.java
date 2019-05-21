package models;

import link.QueueLink;
import people.Student;

public class LinkListQueueModel {
	private QueueLink first;
	@SuppressWarnings("unused")
	private QueueLink last;
	private int id;

	public LinkListQueueModel() {
		first = null;
		last = null;
		id = 0;
	}
	//O(1)
	public void insert(Student student) {
		QueueLink newLink = new QueueLink(student);
		newLink.getStudent().setId(++id);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.setNext(first);
		first = newLink;
	}
	//O(n)
	public Student remove() {
		QueueLink current = first;
		QueueLink previous = first;
		while (current.getNext() != null) {
			previous = current;
			current = previous.getNext();
			if(current.getNext() == null) {
				previous.setNext(null);
				return previous.getStudent();
			}
		}
		return null;
	}

	private boolean isEmpty() {
		return first == null;
	}
}
