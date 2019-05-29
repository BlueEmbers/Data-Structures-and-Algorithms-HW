package p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		

	}
	
	public static long sortBags(int choice, int count) {
		WordBag bag = new WordBag(count);
		
		File file = new File("document.txt");
		bag.parseWords(bag.importData(file));
		
		long timer = 0;
		
		switch(choice) {
		case 0 : timer = bag.insertionSort();
			break;
		case 1 : timer = bag.shellSort();
			break;
		case 2: timer = bag.mergeSort();
			break;
		}
		
		return timer;
		
	}

}
