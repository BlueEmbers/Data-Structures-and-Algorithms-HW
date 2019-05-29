package controller;

import models.StackModel;
import objects.CoordObject;

public class Controller {
	static int allowedMoves = 100;
	static StackModel stack = new StackModel(allowedMoves);
	static CoordObject current;
	static CoordObject randomStart = new CoordObject();

	public static CoordObject push(int x, int y) {
		setCurrentEmpty();
		return current = stack.push(x, y);
	}

	public static void handlePop() {
		setCurrentEmpty();
		current = stack.pop();
	}

	public static void setCurrentEmpty() {
		if (stack.isEmpty()) {
			current = stack.push(randomStart.getX(),randomStart.getY());
		}
	}

	public static int getX() {
		return current.getX();
	}

	public static int getY() {
		return current.getY();
	}

	public static CoordObject getCurrent() {
		return current;
	}

	public static CoordObject getRandomStart() {
		return randomStart;
	}
	

}
