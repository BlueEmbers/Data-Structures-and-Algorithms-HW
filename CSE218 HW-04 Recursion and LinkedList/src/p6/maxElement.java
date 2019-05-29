package p6;

public class maxElement {

	public static void main(String[] args) {

		double[] array = { -21, 234, 7650, 12, -15, 77, 2121 };
		int index = 0;
		double max = 0;
		System.out.println(maxElement(array, index, max));

	}

	public static double maxElement(double[] array, int index, double max) {
		if (index == 0) {
			max = array[index];
		}

		if (max < array[index++]) {
			max = array[index - 1];
		}

		if (index == array.length) {
			return max;
		} else {
			return maxElement(array, index, max);
		}
	}
}
