package bags;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import users.UserAccount;
import utilities.GenerateUserUtil;
import utilities.PasswordUtil;

public class UserAccountBag {
	private UserAccount[] users;
	private int nElems;
	final int MAX_SIZE = 5000;

	public UserAccountBag() {
		users = new UserAccount[MAX_SIZE];
		nElems = 0;
		fillBagDefault();
	}

	public UserAccountBag(UserAccount[] users, int nElems) {
		this.users = users;
		this.nElems = nElems;
	}

	public void insert(String firstName, String lastName, String gender, String iD, double gpa, String userName,
			String password) {
		iD = GenerateUserUtil.formatId(iD);
		users[nElems++] = new UserAccount(firstName, lastName, gender, iD, gpa, userName, password);
	}

	public void insert(String firstName, String lastName, String gender, String iD, double gpa) {
		iD = GenerateUserUtil.formatId(iD);
		users[nElems++] = new UserAccount(firstName, lastName, gender, iD, gpa,
				GenerateUserUtil.generateUserName(lastName, firstName, iD), PasswordUtil.generatePassword());
	}

	public void insert(UserAccount user) {
		users[nElems++] = new UserAccount(user);
	}

	public boolean remove(UserAccount user) {
		for (int i = 0; i < nElems; i++) {
			if (users[i].equals(user)) {
				for (int j = i; j < nElems - 1; j++) {
					users[j] = users[j + 1];
				}
				users[nElems - 1] = null;
				nElems--;
				return true;
			}
		}
		return false;
	}

	private void fillBagDefault() {
		try {
			addNamesDefault();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	private void addNamesDefault() throws FileNotFoundException {
		Scanner scanNames = new Scanner(new FileReader("3000_students.txt"));
		while (scanNames.hasNext()) {
			String firstName = scanNames.next();
			String lastName = scanNames.next();
			String gender = scanNames.next();
			String iD = scanNames.next();
			iD = GenerateUserUtil.formatId(iD);
			double gpa = scanNames.nextDouble();
			users[nElems++] = new UserAccount(firstName, lastName, gender, iD, gpa,
					GenerateUserUtil.generateUserName(lastName, firstName, iD), PasswordUtil.generatePassword());
		}
		scanNames.close();
	}

	public void displayBag() {
		try {
			for (UserAccount user : users) {
				System.out.println(user.toString());
			}
		} catch (NullPointerException n) {
			System.out.println("Next element is null");
		}
	}

	public int getnElems() {
		return nElems;
	}

	public UserAccount[] getUsers() {
		return users;
	}

}
