package p4;

public class MasterLinkList {
	
	private MasterLink first;
	private MasterLink last;
	private int nLinks;
	
	public MasterLinkList() {
		nLinks = 0;
	}
	
	public boolean isEmpty() {
		return last == null;
		
	}
	
	public void insertMasterLink(String lyric) {
		MasterLink newLink = new MasterLink(lyric);
		if(this.isEmpty()) {
			last = newLink;
		}else {
			last.setNext(newLink);
			newLink.setPrevious(last);
			last = newLink;
		}
		nLinks++;
		
	}
	
	public MasterLink searchMasterLinkList(String lyric) {
		MasterLink current = last;
		while (current != null) {
			if(current.getLyric().equals(lyric)) {
				return current;
			}else {
				current = current.getPrevious();
			}
				
		}
		return null;
		
	}
	
	public void displayMasterList() {
		MasterLink link = last;
		while(link != null) {
			link.displayMasterLink();
			link = link.getPrevious();
		}
		
	}
	

	public MasterLink getLast() {
		return last;
	}

	public void setLast(MasterLink last) {
		this.last = last;
	}

	public int getnLinks() {
		return nLinks;
	}

	public void setnLinks(int nLinks) {
		this.nLinks = nLinks;
	}

}
