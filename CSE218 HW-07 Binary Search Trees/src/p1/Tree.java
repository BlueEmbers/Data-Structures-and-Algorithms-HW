package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Tree {
	private Node root;
	private boolean randomizedOrOrdered;
	private int lines = 0;

	public Tree() {
		root = null;
		this.randomizedOrOrdered = false;
	}

	public void insert(Node newNode) {
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (newNode.getDate() < current.getDate()) {
					current = current.getLeftChild();
					if (current == null) {
						parent.setLeftChild(newNode);
						return;
					}
				} else {
					current = current.getRightChild();
					if (current == null) {
						parent.setRightChild(newNode);
						return;
					}
				}

			}
		}
	}

	public Node simpleSearch(int date) {
		Node current = root;
		while (current.getDate() != date) {
			if (date < current.getDate()) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}

			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public String importData(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String data = "";
		while (in.hasNextLine()) {
			data = data + in.nextLine() + "\n";
//			this.lines++;
		}
		return data;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public void loadOrderedTree() throws FileNotFoundException {
		this.randomizedOrOrdered = true;
		String s = importData("rawData.txt");
		String[] tokens = s.split("\n");
		for(int i = 0; i< tokens.length; i++) {
			String[] subTokens = tokens[i].split("[/,]");
			int date = subTokensToInt(subTokens);
			double price = Double.parseDouble(subTokens[3]);
			insert(new Node(date, price));
		}
			
	}
	
	public void loadRandomizedTree() throws FileNotFoundException {
		this.randomizedOrOrdered = false;
		String s = importData("rawData.txt");
		String[] tokens = s.split("\n");
		Collections.shuffle(Arrays.asList(tokens));
		for(int i = 0; i< tokens.length; i++) {
			String[] subTokens = tokens[i].split("[/,]");
			int date = subTokensToInt(subTokens);
			double price = Double.parseDouble(subTokens[3]);
			insert(new Node(date, price));
		}
	}
	
	
	public int subTokensToInt(String[] subTokens) {
		int dateValue = (Integer.parseInt(subTokens[2])* 10000) + 
				(Integer.parseInt(subTokens[0])* 100) + (Integer.parseInt(subTokens[1]));

		return dateValue;
	}
	
	public void saveSearchData(String time) throws FileNotFoundException {
		String s = ""; 
		String[] array = importSearchData("searchTime.txt");
		
		PrintWriter pr = null;
		try {
			pr = new PrintWriter("searchTime.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i< array.length; i++) {
			pr.println(array[i]);
		}
			pr.println((this.randomizedOrOrdered ? "Ordered:\t" : "Randomized:\t") + time + "ns. \n");
		pr.close();
	}
	
	public String[] importSearchData(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String data = "";
		while (in.hasNextLine()) {
			data = data + in.nextLine() + " ";
//			this.lines++;
		}
		String[] array = data.split(" ");
		return array;
	}
	
	public void saveCompareData(String time) throws FileNotFoundException {
		String s = ""; 
		String[] array = importSearchData("compareTime.txt");
		
		PrintWriter pr = null;
		try {
			pr = new PrintWriter("compareTime.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i< array.length; i++) {
			pr.println(array[i]);
		}
			pr.println((this.randomizedOrOrdered ? "Ordered:\t" : "Randomized:\t") + time + "ns. \n");
		pr.close();
	}
	
	public void newSaveFiles() {
		PrintWriter pr = null;
		try {
			pr = new PrintWriter("compareTime.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		pr.close();
		
		PrintWriter pr1 = null;
		try {
			pr1 = new PrintWriter("searchTime.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		pr1.close();
	}
	
	
}
