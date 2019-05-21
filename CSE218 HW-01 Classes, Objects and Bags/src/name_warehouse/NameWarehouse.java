package name_warehouse;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameWarehouse {
	public Name[] nameArray;
	private int nElems;
	
	public NameWarehouse(int maxSize) {
		nameArray = new Name[maxSize];
		nElems = 0;
	}
	
	public void insert(Name name) {
		nameArray[nElems++] = name;
	}
	
	public void delete(Name name) {
		for(int i = 0; i < nElems; i++) {
			if(nameArray[i].firstName.equals(name.firstName) && nameArray[i].lastName.equals(name.lastName)) {
				System.out.println(nameArray[i].firstName + " " + nameArray[i].lastName + " was deleted.");
				for(int j = i; j < nElems; j++) {
					nameArray[j] = nameArray[j+1];
				}
				break;
			}
		}
	}
	
	public void importNames() throws IOException {
		String[] BoyNamesArray = importBoyNames();
		String[] GirlNamesArray = importGirlNames();
		String[] LastNamesArray = importLastNames();
		
		if(nameArray.length < 1200) {
			nameArray = new Name[1200];
		}
		for(int i = 0; i < 1200; i++) {
			int gender = (int)(Math.random()*2);
			double firstNameIndex = (Math.random()*600);
			double lastNameIndex = (Math.random()*2000);
			if(gender==0) {
				insert(new Name(GirlNamesArray[(int)firstNameIndex], 
						LastNamesArray[(int)lastNameIndex], 
						"girl"));
			} else {
				insert(new Name(BoyNamesArray[(int)firstNameIndex], 
						LastNamesArray[(int)lastNameIndex], 
						"boy"));
			}
		}
		
		sort();
	}
	
	private String[] importBoyNames() throws IOException {
//		FileInputStream fisBoys = new FileInputStream("boys_names.txt");
//		DataInputStream disBoys = new DataInputStream(fisBoys); ONLY FOR PRIMITIVE TYPES LIKE BYTES OR INTS
		
		RandomAccessFile randomFile = new RandomAccessFile("boys_names.txt","r");
		
		String[] split1 = randomFile.readLine().split("[\\W]");
		String[] split2 = new String[600];
		
		int j = 0;
		for(int i = 0; i < split1.length; i++) {
			String[] array = split1[i].split("\\d");
			try {
				Pattern p = Pattern.compile("\\w");
				Matcher m = p.matcher(array[0]);
				if(m.find()) {
					split2[j++] = array[0];
				} else {
					continue;
				}
			} catch (Exception e) {
				continue;
			}
		}
		randomFile.close();
		
		return split2;
	}
	
	private String[] importGirlNames() throws IOException {
		RandomAccessFile randomFile = new RandomAccessFile("girls_names.txt","r");
		String[] array = randomFile.readLine().split("[\\s\t]");
		
		randomFile.close();
		
		return array;
	}
	
	private String[] importLastNames() throws IOException {
		RandomAccessFile randomFile = new RandomAccessFile("Last_Names.txt","r");
		
		String[] array = new String[2000];
		
		for(int i = 0; i < 2000; i++) {
			array[i] = randomFile.readLine();
		}
		
		randomFile.close();
		
		return array;
	}
	
//	public void search(Name name) {
//		
//	}
	
	public void sort() { // selection sort
		int out;
		int in;
		int min = 0;
		for(out = 0; out < nElems-1; out++) {
			min = out;
			for(in = out+1; in < nElems;in++) {
				if(nameArray[in].lastName.compareTo(nameArray[min].lastName) < 0) {
					min = in;
				} else if(nameArray[in].lastName.compareTo(nameArray[min].lastName) == 0) {
					if(nameArray[in].firstName.compareTo(nameArray[min].firstName) < 0) {
						min = in;
					}
				}
			}
			swap(out,min);
		}
	}
	
	private void swap(int x, int y) {
		Name temp = nameArray[x];
		nameArray[x] = nameArray[y];
		nameArray[y] = temp;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(nameArray[i]);
		}
	}
}
