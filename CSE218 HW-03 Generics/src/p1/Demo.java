package p1;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		GStack stack = new GStack(20);
		
		stack.push(1);
		stack.push(2.5);
		stack.push("one");
		
		String [] array = {"one", "two", "three", "four", "five"};
		
		stack.pushAll(array);
		
		System.out.println(stack.pop());
		System.out.println(Arrays.toString(stack.popAll()));

	}

}

