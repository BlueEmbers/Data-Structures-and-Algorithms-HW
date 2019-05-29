package p1;

public class LinkList {
	
	private Link first;
	private int nElems;

	
	public LinkList() {
		this.first = null;
		nElems = 0;
	}
	
	public void insert(String name, int score) {
		Link newLink = new Link(name, score);
		Link current;
		if(first == null) {
			first = newLink;
			nElems++;
			return;
		}else {
			if(first.getScore() < newLink.getScore()) {
				newLink.setNext(first);
				first = newLink;
				trim();
				return;
			}
		}
		current = first;
			
		while(current.getNext() != null && current.getNext().getScore() > newLink.getScore()) {
			current = current.getNext(); 
		
		}
		newLink.setNext(current.getNext());
		current.setNext(newLink);
		trim();
		
	}
	
	
	public String display() {
		Link current = first;
		String display = "";
		while(current != null) {
			display = display + "\n" + current.toString();
			current = current.getNext();
		}
		return display;
		
	}
	
	public void trim() {
		int i = 1;
		Link current = first;
		while(current.getNext() != null && i < 5) {
			current = current.getNext();
			i++;
		}
		if(i == 5) {
			current.setNext(null);
		}
	}
	
}
