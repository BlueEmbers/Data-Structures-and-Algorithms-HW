package models;

import controller.Controller4;
import objects.CoordObject4;

public class StackModel4 {
	private CoordObject4[] stackArray;
	private int maxSize;
	private int top;

	public StackModel4(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new CoordObject4[maxSize];
		top = -1;
	}

	public CoordObject4 push(int x, int y) {
		CoordObject4 current = Controller4.getCurrent();
		CoordObject4 test = new CoordObject4(x, y);
		if (isFull() || isSame(current, test)) {
			return current;
		}
		if (checkAdjacent(test, current)) {
			return stackArray[++top] = test;
		}
		return null;
	}

	private boolean isSame(CoordObject4 current, CoordObject4 test) {
		if (current.getX() == test.getX() && current.getY() == test.getY())
			return true;
		return false;
	}

	private boolean checkAdjacent(CoordObject4 test, CoordObject4 current) {
		return (checkLeftRight(test, current) || checkUpDown(test, current));
	}

	private boolean checkUpDown(CoordObject4 test, CoordObject4 current) {
		if (current.getX() == test.getX() && current.getY() - test.getY() <= 1 && current.getY() - test.getY() >= -1) {
			return true;
		}
		return false;
	}

	private boolean checkLeftRight(CoordObject4 test, CoordObject4 current) {
		if (current.getX() - test.getX() <= 1 && current.getX() - test.getX() >= -1 && current.getY() == test.getY()) {
			return true;
		}
		return false;
	}

	public CoordObject4 pop() {
		if (top > 0) {
			return stackArray[--top];
		}
		return Controller4.getCurrent();
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
