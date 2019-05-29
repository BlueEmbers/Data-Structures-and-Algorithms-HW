package p02;

public class Demo {

	public static void main(String[] args) {
		GenericBag<Integer> bag = new GenericBag<Integer>(5);
		bag.add(5);
		bag.add(4);
		bag.add(20);
		bag.add(13);
		bag.add(1);
		bag.display();
		bag.deleteMin();
		System.out.println();
		bag.display();
		System.out.println();
		bag.insertionSort();
		System.out.println();
		bag.display();
	}

}