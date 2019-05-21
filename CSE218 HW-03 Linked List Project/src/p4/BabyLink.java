package p4;

public class BabyLink {
	
	private String lyric;
	private BabyLink nextLink;
	
	
	public BabyLink(String lyric) {
		super();
		this.lyric = lyric;
		this.nextLink = null;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public BabyLink getNextLink() {
		return nextLink;
	}

	public void setNextLink(BabyLink nextLink) {
		this.nextLink = nextLink;
	}
	
	public void displayBabyLink() {
		System.out.print(lyric + " ");
	}

}
