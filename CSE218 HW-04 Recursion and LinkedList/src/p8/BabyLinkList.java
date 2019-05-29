package p8;

public class BabyLinkList {
	
	private BabyLink first;
	private int nLinks;
	
	
	public BabyLinkList() {
		super();
		this.first = null;
		this.nLinks = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertBabyLink(String lyric) {
		BabyLink newLink = new BabyLink(lyric);
		newLink.setNextLink(first);
		first = newLink;
		nLinks++;
	}
	
	public void displayBabyLinkList() {
		
		BabyLink current = first;
		while (current != null) {
			current.displayBabyLink();
			current = current.getNextLink();
		}
		System.out.println();
	}

	public BabyLink getFirst() {
		return first;
	}

	public void setFirst(BabyLink first) {
		this.first = first;
	}

	public int getnLinks() {
		return nLinks;
	}

	public void setnLinks(int nLinks) {
		this.nLinks = nLinks;
	}

}

