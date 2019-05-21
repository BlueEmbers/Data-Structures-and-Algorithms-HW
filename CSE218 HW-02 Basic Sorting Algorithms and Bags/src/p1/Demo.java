package p1;

public class Demo {

	public static void main(String[] args) {
		
		Student s1 = new Student("Mark Hamill", "0000001", 3.9);
		Student s2 = new Student(s1);
		
		Student s3 = s1.deepCopy();
		
		Student s4 = s1.shallowCopy();
		
		s1.setName("Carrie Fisher");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.equals(s4));
		

	}

}
