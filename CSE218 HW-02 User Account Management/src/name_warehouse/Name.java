package name_warehouse;

public class Name {
	public String firstName;
	public String lastName;
	public String gender;
	
	public Name(String firstName, String lastName, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}	
	
	@Override
	public String toString() {
		return firstName + " " + lastName + ": " + gender;
	}
}
