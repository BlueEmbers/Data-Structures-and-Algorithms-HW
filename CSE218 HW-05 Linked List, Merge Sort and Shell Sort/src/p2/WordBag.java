package p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordBag {

	private String[] words;
	private int nElems;

	public WordBag(int maxSize) {
		this.words = new String[maxSize];
		this.nElems = 0;
	}

	public void parseWords(String data) {

		String[] array = data.split("([^A-Za-z])");
		int i = 0;
		int j = 0;
		while (j < words.length && i < array.length) {
			if (!array[i].isEmpty()) {
				words[j] = array[i];
				nElems++;
				i++;
				j++;
			} else {
				i++;
			}
		}
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}

	public String importData(File file) {
		StringBuilder data = new StringBuilder();

		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					data.append(line);
					data.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return data.toString();
	}

	public void display() {
		int j = 0;
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
			j++;
			if (j == 20) {
				System.out.println();
				j = 0;
			}
		}

	}

	public long insertionSort() {
		int in;
		int out;
		long timer = 0;
		long t = System.nanoTime();
		for (out = 1; out < nElems; out++) {
			String temp = words[out];
			in = out;
			while (in > 0 && words[in - 1].compareTo(temp) > -1) {
				words[in] = words[in - 1];
				in--;
			}
			words[in] = temp;

		}
		timer = System.nanoTime() - t;
		return timer;

	}

	public long shellSort() {
		int inner;
		int outer;
		String temp;
		long time = System.nanoTime();

		int h = 1;
		while (h <= nElems / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = words[outer];
				inner = outer;

				while (inner > h - 1 && words[inner - h].compareTo(temp) > -1) {
					words[inner] = words[inner - h];
					inner -= h;
				}
				words[inner] = temp;
			}
			h = (h - 1) / 3;
		}

		return System.nanoTime() - time;
		
	}
	
	public long mergeSort() {
		
		long time = System.nanoTime();
		String [] workspace = new String[nElems];
		recMergeSort(workspace, 0, nElems - 1);
		
		return System.nanoTime() - time;
		
		
	}
	
	public void merge(String [] workspace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; 
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;

		while (lowPtr <= mid && highPtr <= upperBound) {
			if (words[lowPtr].compareTo(words[highPtr]) < 0) {
				workspace[j++] = words[lowPtr++];
			} else {
				workspace[j++] = words[highPtr++];
			}
		}

		while (lowPtr <= mid) {
			workspace[j++] = words[lowPtr++];
		}

		while (highPtr <= upperBound) { 
			workspace[j++] = words[highPtr++];
		}

		for (j = 0; j < n; j++) {
			words[lowerBound + j] = workspace[j];
		}
	}
	
	public void recMergeSort(String [] workspace, int lowerBound, int upperBound) {
		if(lowerBound == upperBound) {
			return;
			
		}else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workspace, lowerBound, mid);
			recMergeSort(workspace, mid + 1, upperBound);
			merge(workspace, lowerBound, mid +1, upperBound);
		}
	}
}
