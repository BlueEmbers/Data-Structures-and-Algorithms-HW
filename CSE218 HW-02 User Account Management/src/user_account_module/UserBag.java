package user_account_module;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilities.GenUserAndPass;

public class UserBag {
	public User[] userArray;
	private int nElems;
	
	public UserBag(int maxSize) {
		userArray = new User[maxSize];
		nElems = 0;
	}
	
	public void insert(User User) {
		userArray[nElems++] = User;
	}
	
	public void delete(String firstName, String lastName) {
		for(int i = 0; i < nElems; i++) {
			if(userArray[i].firstName.equals(firstName) && userArray[i].lastName.equals(lastName)) {
				System.out.println(userArray[i].firstName + " " + userArray[i].lastName + " was deleted.");
				for(int j = i; j < nElems; j++) {
					userArray[j] = userArray[j+1];
				}
				break;
			}
		}
	}
	
	public void importUsers() throws IOException {
		String[] BoyUsersArray = importBoyUsers();
		String[] GirlUsersArray = importGirlUsers();
		String[] lastNamesArray = importlastNames();
		
		if(userArray.length < 1200) {
			userArray = new User[1200];
		}
		for(int i = 0; i < 1200; i++) {
			int gender = (int)(Math.random()*2);
			double firstNameIndex = (Math.random()*600);
			double lastNameIndex = (Math.random()*2000);
			double gpa = Math.random()*4.1;
			String firstName;
			String lastName = lastNamesArray[(int)lastNameIndex];
			if(gender==0) {
				firstName = GirlUsersArray[(int)firstNameIndex];
				insert(new User(firstName, lastName, "girl", gpa));
			} else {
				firstName = BoyUsersArray[(int)firstNameIndex];
				insert(new User(firstName, lastName, "boy", gpa));
			}
			userArray[i].username = GenUserAndPass.genUser(userArray[i].firstName, userArray[i].lastName, userArray[i].id);
			
		}
		
		sort();
	}
	
	private String[] importBoyUsers() throws IOException {
		File file = new File("C:\\Users\\Kurama\\Eclipse-Workspace\\CSE218 HW-02 User Account Management\\src\\boys_names.txt");
		RandomAccessFile randomFile = new RandomAccessFile(file,"r");
		
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
	
	private String[] importGirlUsers() throws IOException {
		File file = new File("C:\\Users\\Kurama\\Eclipse-Workspace\\CSE218 HW-02 User Account Management\\src\\girls_names.txt");

		RandomAccessFile randomFile = new RandomAccessFile(file,"r");
		String[] array = randomFile.readLine().split("[\\s\t]");
		
		randomFile.close();
		
		return array;
	}
	
	private String[] importlastNames() throws IOException {
		File file = new File("C:\\Users\\Kurama\\Eclipse-Workspace\\CSE218 HW-02 User Account Management\\src\\Last_Names.txt");
		RandomAccessFile randomFile = new RandomAccessFile(file,"r");
		
		String[] array = new String[2000];
		
		for(int i = 0; i < 2000; i++) {
			array[i] = randomFile.readLine();
		}
		
		randomFile.close();
		
		return array;
	}
	
	public User search(String username, String password) {
		int low = 0;
		int high = nElems - 1;
		while (high >= low) {
			int mid = (low + high) / 2;

			if (username.compareTo(userArray[mid].username) < 0) {
				high = mid - 1;
			} else if (username.compareTo(userArray[mid].username) == 0) {
				if(password.equals(userArray[mid].password)){
					return userArray[mid];
				} else {
					return null;
				}
			} else {
				low = mid + 1;
			}
		}
		return null;
	}
	
	public void sort() { // selection sort
		int out;
		int in;
		int min = 0;
		for(out = 0; out < nElems-1; out++) {
			min = out;
			for(in = out+1; in < nElems;in++) {
				if(userArray[in].lastName.compareTo(userArray[min].lastName) < 0) {
					min = in;
				} else if(userArray[in].lastName.compareTo(userArray[min].lastName) == 0) {
					if(userArray[in].firstName.compareTo(userArray[min].firstName) < 0) {
						min = in;
					}
				}
			}
			swap(out,min);
		}
	}
	
	private void swap(int x, int y) {
		User temp = userArray[x];
		userArray[x] = userArray[y];
		userArray[y] = temp;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(userArray[i]);
		}
	}
}

