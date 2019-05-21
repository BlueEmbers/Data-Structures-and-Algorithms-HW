package student_factory;

public class Student {
	public String firstName;
	public String lastName;
	public String gender;
	public String id;
	public double gpa;
	private static int idInc = 0;
	
	public Student(String firstName, String lastName, String gender, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.gpa = gpa;
		id = Integer.toString(idInc++);
	}

	public String toString() {
		return String.format("%s %s: %s | %.1f gpa", firstName,lastName,gender,gpa);
	}
	
	
	
	
}
