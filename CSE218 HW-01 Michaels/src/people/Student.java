package people;

public class Student {

	String firstName;
	String lastName;
	String gender;
	String id;
	double gpa;
	
	public Student(String firstName, String lastName, String gender, String id, double gpa) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.id = id;
		this.gpa = gpa;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	//1 if they are the same, 0 if not
	public int studentIdcompareTo(Student student) {
		 if(this.getId().compareTo(student.getId()) == 0) {
			 return 1;
		 }
		return 0;
	}
	@Override
	public String toString() {
		return "[FirstName]: " + firstName + " [LastName]: " + lastName + " [Gender]: " + gender + " [ID]: " + id
				+ " [GPA]: " + gpa;
	}
	public String toStringForText() {
		return firstName + " " + lastName + " " + gender + "  " + id + " " + gpa;
	}

	
}