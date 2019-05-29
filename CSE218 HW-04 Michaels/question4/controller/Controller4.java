package controller;

import models.StackModel4;
import objects.CoordObject4;
import view.AlertBox;

public class Controller4 {
	static int allowedMoves = 100;
	static StackModel4 stack = new StackModel4(allowedMoves);
	static CoordObject4 randomStart = new CoordObject4();
	static CoordObject4 current = new CoordObject4(randomStart);

	public static CoordObject4 push(int x, int y) {
		setCurrentEmpty();
		CoordObject4 test = stack.push(x, y);
		if (!(test == null)) {
			return current = test;
		} else {
			showAlert();
			return current;
		}
	}

	private static void showAlert() {
		AlertBox.display("Can not jump there!");
	}

	public static void handlePop() {
		setCurrentEmpty();
		current = stack.pop();
	}

	public static void setCurrentEmpty() {
		if (stack.isEmpty()) {
			current = stack.push(randomStart.getX(), randomStart.getY());
		}
	}

	public static int getX() {
		return current.getX();
	}

	public static int getY() {
		return current.getY();
	}

	public static CoordObject4 getCurrent() {
		return current;
	}

	public static CoordObject4 getRandomStart() {
		return randomStart;
	}

}
