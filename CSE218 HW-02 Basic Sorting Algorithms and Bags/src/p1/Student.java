package p1;

public class Student {

	private String name;
	private String id;
	private double gpa;

	public Student(String name, String id, double gpa) {
		super();
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}
	
	public Student(Student student) {
		this.name = student.getName();
		this.id = student.getId();
		this.gpa = student.getGpa();
	}
	
	public Student deepCopy() {
		Student copy = new Student(this.getName(), this.getId(), this.getGpa());
		return copy;
	}
	
	public Student shallowCopy() {
		Student copy = this;
		return copy;
	}
	
	public boolean equals(Student s2) {
		if(this.getName().equals(s2.getName())&& this.getId().equals(s2.getId())&& this.getGpa() == s2.getGpa()){
			return true;
		}else {
			return false;
		}
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", gpa=" + gpa + "]";
	}

}
