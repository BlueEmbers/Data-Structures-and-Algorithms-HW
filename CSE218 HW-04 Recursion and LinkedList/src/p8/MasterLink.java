package p8;

public class MasterLink {
	
	private String lyric;
	private MasterLink next;
	private MasterLink previous;
	private BabyLinkList babyList;
	
	
	public MasterLink(String lyric) {
		super();
		this.lyric = lyric;
		this.next = null;
		this.previous = null;
		this.babyList = new BabyLinkList();
	}
	


	public MasterLink getPrevious() {
		return previous;
	}



	public void setPrevious(MasterLink previous) {
		this.previous = previous;
	}



	public String getLyric() {
		return lyric;
	}


	public void setLyric(String lyric) {
		this.lyric = lyric;
	}


	public MasterLink getNext() {
		return next;
	}


	public void setNext(MasterLink next) {
		this.next = next;
	}


	public BabyLinkList getBabyList() {
		return babyList;
	}


	public void setBabyList(BabyLinkList babyList) {
		this.babyList = babyList;
	}
	
	public void displayMasterLink() {
		System.out.print(this.lyric + ": ");
		this.babyList.displayBabyLinkList();
	}
	

}

