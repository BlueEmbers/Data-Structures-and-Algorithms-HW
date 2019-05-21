package name_factory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameFactory {
	public Name[] nameArray;
	private int nElems;
	
	public NameFactory(int maxSize) {
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
	
	public void search(char key, String gender) {
		String[] nameToStringArray = new String[nElems];
		int j = 0;
		for(int i = 0; i < nameArray.length;i++) {
			if(nameArray[i].gender.equals(gender)) {
				char[] firstName = nameArray[i].firstName.toCharArray();
				if(firstName[0] == key) {
					System.out.println(nameArray[i]);
					nameToStringArray[j++] = nameArray[i].toString();
				}
			}
		}
		writeToFile(nameToStringArray);
		System.out.println();
	}
	
	private void writeToFile(String[] nameToStringArray) {
		int fileNumber=0;
		String fileSeparator = System.getProperty("file.separator");
		
		String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"xutro"+fileSeparator
				+"Documents"+fileSeparator+"workspace"+fileSeparator+"CSE218"+fileSeparator
				+"Xu CSE218 HW01"+fileSeparator+"src"+fileSeparator+"name_factory"+fileSeparator
				+"search"+fileNumber+".txt";
		File file = new File(absoluteFilePath);
		
		try {
			while(!file.createNewFile()) {
				fileNumber++;
				absoluteFilePath = fileSeparator+"Users"+fileSeparator+"xutro"+fileSeparator
						+"Documents"+fileSeparator+"workspace"+fileSeparator+"CSE218"+fileSeparator
						+"Xu CSE218 HW01"+fileSeparator+"src"+fileSeparator+"name_factory"+fileSeparator
						+"search"+fileNumber+".txt";
				file = new File(absoluteFilePath);
			}
			System.out.println(file.toString() + " has been created.");
			RandomAccessFile randomFile = new RandomAccessFile(absoluteFilePath, "rw");
			int i = 0;
			while(nameToStringArray[i] != null && i < nameToStringArray.length) {
				randomFile.writeUTF(nameToStringArray[i] + "\n");
				i++;
			};
			randomFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
