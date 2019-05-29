package models;

import controller.Controller;
import objects.CoordObject;

public class StackModel {
	private CoordObject[] stackArray;
	private int maxSize;
	private int top;

	public StackModel(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new CoordObject[maxSize];
		top = -1;
	}

	public CoordObject push(int x, int y) {
		if(isFull()) {
			return Controller.getCurrent();
		}
		return stackArray[++top] = new CoordObject(x, y);
	}

	public CoordObject pop() {
		if (top > 0) {
			return stackArray[--top];
		}
		return Controller.getCurrent();
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public void display() {
		for (int i = 0; i < stackArray.length; i++) {
			if (!(stackArray[i] == null)) {
				System.out.println(stackArray[i].toString());
			}
		}
		System.out.println();
	}
}
