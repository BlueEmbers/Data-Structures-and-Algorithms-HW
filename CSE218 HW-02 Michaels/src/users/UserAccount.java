package users;

public class UserAccount implements Comparable<UserAccount>{
	private String firstName;
	private String lastName;
	private String gender;
	private String iD;
	private double gpa;
	private String userName;
	private String password;

	public UserAccount(String firstName, String lastName, String gender, String iD, double gpa, String userName,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.iD = iD;
		this.userName = userName;
		this.password = password;
		this.gpa = gpa;
	}

	public UserAccount(String firstName, String lastName, String gender, String iD, double gpa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.iD = iD;
		this.gpa = gpa;
	}

	public UserAccount(UserAccount user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.gender = user.getGender();
		this.iD = user.getiD();
		this.gpa = user.getGpa();
		this.userName = user.getUserName();
		this.password = user.getPassword();
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

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "[FirstName]: " + firstName + " [LastName]: " + lastName + " [Gender]: " + gender + " [ID]: " + iD
				+ " [GPA]: " + gpa + " [UserName]: " + userName + " [Password]: " + password;
	}

	public int compareTo(UserAccount user) {
		String s1 = this.userName.replaceAll("[']" , "");
		String s2 = user.getUserName().replaceAll("[']", "");
		return s1.compareTo(s2);
	}

}