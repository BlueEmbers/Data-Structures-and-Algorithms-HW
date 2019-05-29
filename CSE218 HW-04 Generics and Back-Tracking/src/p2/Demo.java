package p2;

public class Demo 
{

	public static void main(String[] args) {
		GenericBag <Integer> intArray = new GenericBag<Integer>(5);
		intArray.insert(4);
		intArray.insert(3);
		intArray.insert(8);
		intArray.insert(8);
		intArray.display();
		
		System.out.println("--------------------------------");
		
		intArray.delMin();
		intArray.display();
		//System.out.println("nElems:" + intArray.getnElems());
		System.out.println("done");
		
	}

}
