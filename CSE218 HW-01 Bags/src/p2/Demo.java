package p2;

public class Demo {

	public static void main(String[] args) {

		Student s1 = new Student("Luke Skywalker", "000001", 3.8);
		Student s2 = new Student("Han Solo", "000002", 2.8);
		Student s3 = new Student("Darth Vader", "000003", 3.2);
		Student s4 = new Student("Jabba Hutt", "000004", 1.8);
		Student s5 = new Student("Lando Calrissian", "000005", 3.9);
		Student s6 = new Student("See Threepio", "000006", 2.0);

		StudentBag bag = new StudentBag(20);
		bag.add(s1);
		bag.add(s2);
		bag.add(s3);
		bag.add(s4);
		bag.add(s5);
		bag.add(s6);
		bag.display();
		
		System.out.println(bag.search("000008"));
		System.out.println(bag.remove("000008"));
		
		System.out.println(bag.search("000001"));
		System.out.println(bag.remove("000001"));
		
		bag.display();
		
		System.out.println(bag.findMin());
		System.out.println(bag.findMax());
		System.out.println(bag.findMean());
	}

}
