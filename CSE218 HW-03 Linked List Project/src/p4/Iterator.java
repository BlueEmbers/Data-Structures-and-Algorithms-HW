package p4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javafx.stage.FileChooser;

public class Iterator {

	private MasterLinkList masterList;

	public Iterator(MasterLinkList list) {
		this.masterList = list;
	}

	public void insertLinks(String firstLyric, String secondLyric) {
		if (this.masterList.searchMasterLinkList(firstLyric) == null) {
			masterList.insertMasterLink(firstLyric);
		}
		this.masterList.searchMasterLinkList(firstLyric).getBabyList().insertBabyLink(secondLyric);
	}
	
	public String generateNonsense(String start, int numberOfWords) {
		String nonsense = start;
		String nextWord = start;
		
		for(int i = 0; i <numberOfWords - 1; i++) {
			nextWord = (getRandomNextWord(nextWord));
			nonsense = nonsense + " " + nextWord;
		}
		
		return nonsense;
	}

	public String getRandomNextWord(String masterWord) {
		int numberOfBabyLinks = this.masterList.searchMasterLinkList(masterWord).getBabyList().getnLinks();
		String[] array = new String[numberOfBabyLinks];
		BabyLink current = this.masterList.searchMasterLinkList(masterWord).getBabyList().getFirst();
		for(int i = 0; i< numberOfBabyLinks; i++) {
			array[i] = current.getLyric();
			current = current.getNextLink();
		}
		
		return array[(new Random().nextInt(numberOfBabyLinks))];
	}
	
	public void parseLyrics(String song) {
		String[] lyrics = song.split("\\s+");
		int i = 0;
		while (i +1 < lyrics.length) {
			if(this.masterList.searchMasterLinkList(lyrics[lyrics.length -1]) == null) {
				this.masterList.insertMasterLink(lyrics[lyrics.length -1]);
			}
			insertLinks(lyrics[i], lyrics[i+1]);
			i++;
		}
		
	}
		
	public String importData(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		String data = "";
		while (in.hasNextLine()) {
			data = in.nextLine();
		}
		return data;
	}
	
	public void exportData(String string) {
		PrintWriter pr = null;
		try {
			pr = new PrintWriter("output/output.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 pr.println(string);
		pr.close();
	}
		
}
