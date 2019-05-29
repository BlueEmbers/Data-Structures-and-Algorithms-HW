package p4;

public class RecursiveAdditionDemo {

	public static void main(String[] args) {
		
		Number[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90};

		System.out.println(add(array, 0, 0));
		
	}

	public static <E extends Number> double add(E[] array, int index, double value){
		value = value + array[index++].doubleValue();
		if(index == array.length) {
			return value;
		}
		return add(array, index, value);
	}
	
}
