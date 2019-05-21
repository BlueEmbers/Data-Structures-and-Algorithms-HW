package models;

import link.StackLink;
import people.Student;

public class LinkListStackModel {
	private StackLink first;
	private int id;

	public LinkListStackModel() {
		first = null;
		id = 0;
	}
	public void push(Student student) {
		StackLink newLink = new StackLink(student);
		newLink.getStudent().setId(++id);
		newLink.setNext(first);
		first = newLink;
	}
	public Student pop() {
		StackLink temp = first;
		if(!isEmpty()) {
			first = first.getNext();
			return temp.getStudent();
		}
		return null;
	}
	private boolean isEmpty() {
		return first == null;
	}
}
