package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args)
	{
//<<<<<<< HEAD
		//makeNameWarehouse(1200, "textData/outputData/names_Warehouse");
		String data = "1. Naqi	2. Ana	3.Mom";
		String[] boyNames = data.split("[\\d.]");
		for(String e : boyNames) {
			System.out.println(e.trim());
		}
//=======
		makeNameWarehouse(1200, "textData/outputData/names_Warehouse");
//>>>>>>> refs/remotes/origin/master
	}

	public static String emitBoyName() {
		final String BOY_NAME_FILE = "textData/inputData/boys_names.txt";
		Scanner sc = openFileSc(BOY_NAME_FILE);
		String data = sc.nextLine();
		String[] boyNames = data.split("[0-9]+[.][\\s]+");
		// boyNames = Arrays.copyOfRange(boyNames, 1, boyNames.length);
		return boyNames[new Random().nextInt(boyNames.length)].trim();
	}

	public static String emitGirlName() {
		final String GIRL_NAME_FILE = "textData/inputData/girls_names.txt";
		Scanner sc = openFileSc(GIRL_NAME_FILE);
		String data = sc.nextLine();
		String[] girlNames = data.split("\\s");
		return girlNames[new Random().nextInt(girlNames.length)];
	}

	public static String emitLastName() {
		final String LAST_NAME_FILE = "textData/inputData/Last_Names.txt";
		Scanner sc = openFileSc(LAST_NAME_FILE);
		Random random = new Random();
		String[] lastNames = new String[countLines(LAST_NAME_FILE)];
		int i = 0;
		while (sc.hasNextLine()) {
			lastNames[i] = sc.nextLine();
			i++;
		}
		sc.close();
		return lastNames[new Random().nextInt(countLines(LAST_NAME_FILE))];
	}

	public static String[] insert(String[] array, String lastName) {
		for (int i = 0; i < array.length; i++) {
			array[i] = lastName;
		}
		return array;
	}

	public static void makeNameWarehouse(int noOfItems, String outputFileName) {
		boolean isMale = true;
		NameBag nameBag = new NameBag(noOfItems);
		PrintWriter pw = openFilePw(outputFileName);
		for (int i = 0; i < noOfItems; i++) {
			if (!nameBag.isFull(noOfItems)) {
				Name boyName = new Name(emitBoyName(), emitLastName(), isMale);
				nameBag.insert(boyName);
			} else
				break;
			if (!nameBag.isFull(noOfItems)) {
				Name girlName = new Name(emitGirlName(), emitLastName(), !isMale);
				nameBag.insert(girlName);
			} else
				break;
		}
		for (int i = 0; i < nameBag.getNElems(); i++) {
			pw.println(nameBag.getElemAt(i));
		}
		pw.close();
	}

	public static PrintWriter openFilePw(String fileName) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);
			return pw;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Scanner openFileSc(String fileName) {
		File file = new File(fileName);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sc;
	}

	public static int countLines(String fileName) {
		Scanner sc = openFileSc(fileName);
		int lineCounter = 0;
		while (sc.hasNextLine()) {
			sc.nextLine();
			lineCounter++;
		}

		sc.close();
		return lineCounter;
	}

}
