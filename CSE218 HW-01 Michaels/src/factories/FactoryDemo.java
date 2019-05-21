package factories;

public class FactoryDemo {

	public static void main(String[] args) {
		StudentFactory student = new StudentFactory();
		student.displayStudentArray();
		student.createStudentsUntilEnd();
	}

}
