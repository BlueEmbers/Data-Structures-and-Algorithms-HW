package factories;

import java.util.Scanner;

import people.Name;
import people.Student;
import warehouse.NameWarehouse;

public class StudentFactory {

	NameWarehouse nameWare;
	Name[] names;
	Student[] students;
	int nElems;

	public StudentFactory() {
		nameWare = new NameWarehouse();
		this.names = nameWare.getNames();
		this.students = new Student[names.length];
		nElems = 0;
		createStudentsArray();
	}

	public StudentFactory(Name[] names) {
		this.names = names;
		this.students = new Student[names.length];
		nElems = 0;
		createStudentsArray();
	}

	public void createStudentsArray() {
		for(int i = 0; i < students.length; i++) {
		students[nElems] = createStudentFromNames(names[nElems]);
		}
	}

	public void createStudentsUntilEnd() {
		int endVal = 1;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter 1 to create a student \nEnter 0 to exit");
			endVal = userInputSwitch(input.next());
		} while (endVal != 0);
		input.close();
	}

	private Student createStudentFromNames(Name name) {
		return new Student(name.getFirstName(), name.getLastName(), name.getGender(), generateId(), randomGPA());
	}

	private Student createStudent() {
		String gender = getGenderFromUser();
		Name name = getNameFromGender(gender);
		return new Student(name.getFirstName(), name.getLastName(), name.getGender(), generateId(), randomGPA());
	}

	private String getGenderFromUser() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int endValue = 1;
		String boyOrGirl;
		do {
			System.out.print("Enter a gender (BOY or GIRL): ");
			boyOrGirl = input.next().toUpperCase();
			if (boyOrGirl.equals("BOY") || boyOrGirl.equals("GIRL")) {
				endValue = 0;
				return boyOrGirl;
			} else {
				System.out.println("Invalid format. Make sure gender is spelt correctly");
			}
		} while (endValue != 0);
		return "Fail";
	}

	private Name getNameFromGender(String gender) {
		int endValue = 1;
		do {
			Name name = names[(int) (Math.random() * names.length + 1)];
			if (name.getGender().equals(gender)) {
				endValue = 0;
				return name;
			}
		} while (endValue != 0);
		return null;
	}

	private int userInputSwitch(String string) {
		switch (string.charAt(0)) {
		case '1':
			Student student = createStudent();
			System.out.println(student.toString());
			return 1;
		case '0':
			return 0;
		default:
			System.out.println("Incorrect input, try again.");
			return 1;
		}
	}

	private double randomGPA() {
		return Math.round((Math.random() * 4.0) * 100.0) / 100.0;
	}

	private String generateId() {
		//Also increments nElems because they get number w/ ID
		return String.valueOf(nElems++ + 1);
	}

	public void displayStudentArray() {
		for(Student student: students) {
			System.out.println(student.toString());
		}
	}
	public Student[] getStudents() {
		return students;
	}
	
}