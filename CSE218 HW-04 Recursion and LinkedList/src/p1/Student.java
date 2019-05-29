package p1;

import java.text.DecimalFormat;

public class Student {
	private String name;
	private String id;
	private static int idNumber = 00000000;
	private double gpa;
	
	public Student(String name, double gpa) {
		super();
		this.name = name;
		DecimalFormat df = new DecimalFormat("00000000");
		this.id = df.format(++idNumber);
		this.gpa = gpa;
	}
	
	public Student(Student student) {
		this.name = student.name;
		this.id = student.id;
		this.gpa = student.gpa;
	}

	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static int getIdNumber() {
		return idNumber;
	}

	public static void setIdNumber(int idNumber) {
		Student.idNumber = idNumber;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", ID: " + id + ", GPA:" + gpa;
	}
}
