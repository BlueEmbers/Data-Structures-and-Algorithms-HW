package p1;

public class Demo {

	public static void main(String[] args) {
		
		IntBag bag = new IntBag(20);
		bag.add(145);
		bag.add(14);
		bag.add(41);
		bag.add(15);
		bag.add(17);
		bag.add(18);
		bag.add(81);
		bag.add(91);
		bag.add(651);
		bag.add(561);
		bag.add(20);
		bag.display();

		System.out.println(bag.findMax());
		System.out.println(bag.findMin());
		System.out.println(bag.findMean());
		System.out.println(bag.search(13));
		System.out.println(bag.remove(13));
		System.out.println(bag.search(17));
		System.out.println(bag.remove(17));

		bag.display();

	}

}

