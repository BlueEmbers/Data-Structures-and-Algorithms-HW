package controllers;

import bags.GenBag;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.BagView;

public class Controller {

	static BagView view;
	@SuppressWarnings("rawtypes")
	static GenBag gBag;
	static String bagType;
	static int bagSize = 25;

	public static void setBagString(Window window) {
		gBag = new GenBag<String>(bagSize);
		bagType = "Strings";
		view = new BagView(bagType);
		switchScene(window);
	}

	public static void setBagInteger(Window window) {
		gBag = new GenBag<Integer>(bagSize);
		bagType = "Integers";
		view = new BagView(bagType);
		switchScene(window);
	}

	public static void setBagDouble(Window window) {
		gBag = new GenBag<Double>(bagSize);
		bagType = "Doubles";
		view = new BagView(bagType);
		switchScene(window);
	}

	public static String handleInput(String userInput) {
		try {
			if (!userInput.equals("")) {
				return updateTextAdd(switchType(userInput), userInput);
			} 
		} catch (Exception e) {
			return updateTextAdd(false, userInput);
		}
		return updateTextAdd(false, userInput);
	}

	@SuppressWarnings("unchecked")
	private static boolean switchType(String input) {
		switch (bagType) {
		case "Strings":
			return gBag.add(input);
		case "Integers":
			return gBag.add(Integer.parseInt(input));
		case "Doubles":
			return gBag.add(Double.parseDouble(input));
		}
		return false;
	}

	public static String updateTextAdd(Boolean created, String userInput) {
		if (created) {
			return userInput + " added";
		} else {
			return " Could not add " + userInput;
		}
	}

	private static void switchScene(Window window) {
		Stage old = (Stage) window;
		old.setTitle("Bag Viewer");
		old.setScene(view.getScene());
	}

	public static String handleDisplay() {
		if (!gBag.isEmpty()) {
			return gBag.displayString();
		}
		return "Bag is Empty \n";
	}

	public static String handleFindMax() {
		try {
			return "Max Element " + gBag.findMax().toString() + "\n";
		} catch (Exception e) {
			return "Could not find max element \n";
		}
	}

	public static String handleFindMin() {
		try {
			return "Min Element " + gBag.findMin().toString() + "\n";
		} catch (Exception e) {
			return "Could not find Min element \n";
		}
	}

	public static String handleDeleteMax() {
		try {
			return gBag.deleteMax().toString() + " has been deleted \n";
		} catch (Exception e) {
			return "Could not delete max element \n";
		}
	}

	public static String handleDeleteMin() {
		try {
			return gBag.deleteMin().toString() + " has been deleted \n";
		} catch (Exception e) {
			return "Could not delete min element \n";
		}
	}

	public static String handleInsertionSort() {
		if (!gBag.isEmpty()) {
			gBag.insertionSort();
			return "Sorted \n";
		} else {
			return "Bag is Empty\n";
		}
	}

}
