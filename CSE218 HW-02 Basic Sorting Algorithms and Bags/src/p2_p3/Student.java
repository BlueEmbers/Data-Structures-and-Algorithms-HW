package p2_p3;

import java.text.DecimalFormat;
import java.util.Random;

public class Student {

	private String firstName;
	private String lastName;
	private String id;
	private static int idNumber = 0000000;
	private double gpa;
	DecimalFormat df2 = new DecimalFormat("00000000");

	

	public Student(String firstName, String lastName, double gpa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = df2.format(++idNumber);
		this.gpa = gpa;
	}
	
	public Student(Student student) {
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.id = student.getId();
		this.gpa = student.getGpa();
	}
	
	public Student() {
		this.firstName = getRandomFirstName();
		this.lastName = getRandomLastName();
		this.id = df2.format(++idNumber);
		this.gpa = getRandomGpa();
		
	}
	
	public Student deepCopy() {
		Student copy = new Student(this.getFirstName(), this.getLastName(), this.getGpa());
		return copy;
	}
	
	public Student shallowCopy() {
		Student copy = this;
		return copy;
	}
	
	public boolean equals(Student s2) {
		if(this.getFirstName().equals(s2.getFirstName())&& this.getLastName().equals(s2.getLastName()) && 
				this.getId().equals(s2.getId())&& this.getGpa() == s2.getGpa()){
			return true;
		}else {
			return false;
		}
	}
	
	public String getRandomFirstName() {
		String[] firstNames = {"Alan", "Betty", "Thomas", "Clyde", "Mohammed", "Pierre", 
				"Jerome", "Ed", "Fred", "Ned", "Susan", "Sally", "Inga", "April", 
				"Alice", "Samantha", "Darnell", "LaToya", "Maria", "Danny"};
			
		String randomName = firstNames[new Random().nextInt(firstNames.length)];
		return randomName;

	}
	
	public String getRandomLastName() {
		String[] lastNames = {"Smith", "Michaels", "Johnson", "Xu", "Garcia", "Jefferson",
				"Lee", "Friedmont", "Finn", "Zoolander", "Skywalker", "Johnsen", "Thomas",
				"DeNiro", "Pacino", "Roberts", "Clooney", "Obama", "Trump", "Cuomo"};
			
		String randomName = lastNames[new Random().nextInt(lastNames.length)];
		return randomName;

	}
	
	public double getRandomGpa() {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(Math.random() * 4.0));
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName +  "  ID:" + id + " GPA: " + gpa ;
	}
}
