package p1;

public class Link {
	
	private String name;
	private int score;
	private Link next;
	
	public Link(String name, int score) {
		this.name = name;
		this.score = score;
		this.next = null;
	}
	
	public Link() {
		super();
	}
	
	public Link(Link link) {
		super();
		this.name = link.getName();
		this.score = link.getScore();
		this.next = link.getNext();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\t Score: " + score;
	}

}
