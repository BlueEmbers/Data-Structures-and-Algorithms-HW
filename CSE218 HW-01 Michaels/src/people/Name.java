package people;

public class Name implements Comparable<Name> {

	private String firstName;
	private String lastName;
	private String gender;

	public Name(String firstName, String lastName, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
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

	@Override
	public String toString() {
		return "[FirstName]: " + firstName + " [LastName]: " + lastName + " [Gender]:" + gender;
	}

	@Override
	public int compareTo(Name name) {
		if (this.lastName.compareTo(name.lastName) == 0) {
			return this.firstName.compareTo(name.firstName);
		}
		return this.lastName.compareTo(name.lastName);
	}

}