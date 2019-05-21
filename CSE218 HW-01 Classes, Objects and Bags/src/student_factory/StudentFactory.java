package student_factory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentFactory {
	public Student[] studentArray;
	private int nElems;
	
	public StudentFactory(int maxSize) {
		studentArray = new Student[maxSize];
		nElems = 0;
	}
	
	public void insert(Student Student) {
		studentArray[nElems++] = Student;
	}
	
	public void delete(Student Student) {
		for(int i = 0; i < nElems; i++) {
			if(studentArray[i].firstName.equals(Student.firstName) && studentArray[i].lastName.equals(Student.lastName)) {
				System.out.println(studentArray[i].firstName + " " + studentArray[i].lastName + " was deleted.");
				for(int j = i; j < nElems; j++) {
					studentArray[j] = studentArray[j+1];
				}
				break;
			}
		}
	}
	
	public void importStudents() throws IOException {
		String[] BoyStudentsArray = importBoyStudents();
		String[] GirlStudentsArray = importGirlStudents();
		String[] lastNamesArray = importlastNames();
		
		if(studentArray.length < 1200) {
			studentArray = new Student[1200];
		}
		for(int i = 0; i < 1200; i++) {
			int gender = (int)(Math.random()*2);
			double firstNameIndex = (Math.random()*600);
			double lastNameIndex = (Math.random()*2000);
			double gpa = Math.random()*4.1;
			if(gender==0) {
				insert(new Student(GirlStudentsArray[(int)firstNameIndex], 
						lastNamesArray[(int)lastNameIndex], 
						"girl",gpa));
			} else {
				insert(new Student(BoyStudentsArray[(int)firstNameIndex], 
						lastNamesArray[(int)lastNameIndex], 
						"boy",gpa));
			}
		}
		
		sort();
	}
	
	private String[] importBoyStudents() throws IOException {
//		FileInputStream fisBoys = new FileInputStream("boys_Students.txt");
//		DataInputStream disBoys = new DataInputStream(fisBoys); ONLY FOR PRIMITIVE TYPES LIKE BYTES OR INTS
		
		RandomAccessFile randomFile = new RandomAccessFile("boys_Students.txt","r");
		
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
	
	private String[] importGirlStudents() throws IOException {
		RandomAccessFile randomFile = new RandomAccessFile("girls_Students.txt","r");
		String[] array = randomFile.readLine().split("[\\s\t]");
		
		randomFile.close();
		
		return array;
	}
	
	private String[] importlastNames() throws IOException {
		RandomAccessFile randomFile = new RandomAccessFile("Last_Students.txt","r");
		
		String[] array = new String[2000];
		
		for(int i = 0; i < 2000; i++) {
			array[i] = randomFile.readLine();
		}
		
		randomFile.close();
		
		return array;
	}
	
	public void search(char key, String gender) {
		String[] StudentToStringArray = new String[nElems];
		int j = 0;
		for(int i = 0; i < studentArray.length;i++) {
			if(studentArray[i].gender.equals(gender)) {
				char[] firstName = studentArray[i].firstName.toCharArray();
				if(firstName[0] == key) {
					System.out.println(studentArray[i]);
					StudentToStringArray[j++] = studentArray[i].toString();
				}
			}
		}
		writeToFile(StudentToStringArray);
		System.out.println();
	}
	
	private void writeToFile(String[] StudentToStringArray) {
		int fileNumber=0;
		String fileSeparator = System.getProperty("file.separator");
		
		String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"xutro"+fileSeparator
				+"Documents"+fileSeparator+"workspace"+fileSeparator+"CSE218"+fileSeparator
				+"Xu CSE218 HW01"+fileSeparator+"src"+fileSeparator+"Student_factory"+fileSeparator
				+"search"+fileNumber+".txt";
		File file = new File(absoluteFilePath);
		
		try {
			while(!file.createNewFile()) {
				fileNumber++;
				absoluteFilePath = fileSeparator+"Users"+fileSeparator+"xutro"+fileSeparator
						+"Documents"+fileSeparator+"workspace"+fileSeparator+"CSE218"+fileSeparator
						+"Xu CSE218 HW01"+fileSeparator+"src"+fileSeparator+"Student_factory"+fileSeparator
						+"search"+fileNumber+".txt";
				file = new File(absoluteFilePath);
			}
			System.out.println(file.toString() + " has been created.");
			RandomAccessFile randomFile = new RandomAccessFile(absoluteFilePath, "rw");
			int i = 0;
			while(StudentToStringArray[i] != null && i < StudentToStringArray.length) {
				randomFile.writeUTF(StudentToStringArray[i] + "\n");
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
				if(studentArray[in].lastName.compareTo(studentArray[min].lastName) < 0) {
					min = in;
				} else if(studentArray[in].lastName.compareTo(studentArray[min].lastName) == 0) {
					if(studentArray[in].firstName.compareTo(studentArray[min].firstName) < 0) {
						min = in;
					}
				}
			}
			swap(out,min);
		}
	}
	
	private void swap(int x, int y) {
		Student temp = studentArray[x];
		studentArray[x] = studentArray[y];
		studentArray[y] = temp;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(studentArray[i]);
		}
	}
}
