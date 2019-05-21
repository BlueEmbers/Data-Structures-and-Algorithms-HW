package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import factories.StudentFactory;
import people.Student;

public class Create3000StudentsUtil {
	private static Student[] students;
	private static Student[] studentsFromFactory;
	private static StudentFactory factory;
	private static int nElems;
	private static int MAX_ELEMS = 3000;
	private static File studentsFile;

	private Create3000StudentsUtil() {
	}

	public static void createFile() {
		students = new Student[MAX_ELEMS];
		factory = new StudentFactory();
		studentsFromFactory = factory.getStudents();
		fillStudentArray();
		createNewFile();
		printArrayToFile();
		displayStudentArray();
	}

	private static void fillStudentArray() {
		do {
			for (int i = 0; i < studentsFromFactory.length; i++) {
				if (!(nElems == students.length)) {
					students[nElems] = createNewStudent(studentsFromFactory[i]);
				}
			}
		} while (nElems != students.length);
	}
	private static Student createNewStudent(Student student) {
		return new Student(student.getFirstName(), student.getLastName(), student.getGender(), String.valueOf(++nElems), student.getGpa());
	}

	private static void createNewFile() {
		studentsFile = new File("3000_students.txt");
		try {
			studentsFile.createNewFile();
		} catch (IOException e) {
			System.out.println("File failed to create");
		}
	}

	private static void printArrayToFile() {
		PrintWriter print = null;
		try {
			print = new PrintWriter(studentsFile);
			for (Student student : students) {
				print.println(student.toStringForText());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} finally {
			print.close();
		}
	}

	private static void displayStudentArray() {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}
