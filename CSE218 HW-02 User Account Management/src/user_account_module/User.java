package user_account_module;

import utilities.GenUserAndPass;

public class User {
	public String firstName;
	public String lastName;
	public String id;
	private static int idInc = 0;
	public String gender;
	public String username;
	public String password;
	public double gpa;
	
	public User(String firstName, String lastName, String gender, String username, String password, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.gpa = gpa;
		this.id = Integer.toString(idInc++);
	}
	
	public User(String firstName, String lastName, String gender, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.id = Integer.toString(idInc++);
		this.gpa = gpa;
		
		this.username = "";
		this.password = "";// GenUserAndPass.genPass();
	}
	
	public String toString() {
		return String.format("%s | %s %s | sex: %s gpa: %.1f password: %s", username, firstName,lastName,gender,gpa,password);
	}
}
