package factories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import people.Name;
import utilities.CreateFileUtil;
import utilities.InsertionSort;
import warehouse.NameWarehouse;

public class NameFactory {
	private int nElems;
	private char firstInitialInput;
	private String genderInput;
	private NameWarehouse nameWare;
	private Name[] names;
	private Name[] namesFromParam;
	private File namesFromParamFile;
	private File namesParamFolder;

	public NameFactory() {
		namesFromParam = new Name[1];
		nElems = 0;
		nameWare = new NameWarehouse();
		names = nameWare.getNames();
		enterInitialAndGender();
		createNamesFromParam();
		sortNamesFromParam();
		namesParamFolder = CreateFileUtil.createFolder();
		createFile();
		printNamesToFile();
	}
	public NameFactory(Name names[]) {
		namesFromParam = new Name[1];
		nElems = 0;
		this.names = names;
		enterInitialAndGender();
		createNamesFromParam();
		sortNamesFromParam();
		namesParamFolder = CreateFileUtil.createFolder();
		createFile();
		printNamesToFile();
	}

	private void enterInitialAndGender() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a first initial and gender (BOY or GIRL)");
		checkAndSetInitial(input);
		checkandSetGender(input);
	}

	private void checkAndSetInitial(Scanner input) {
		String initial;
		int endVal = 1;
		do {
			System.out.print("Enter first Initial: ");
			initial = input.next().toUpperCase();
			if (Character.isAlphabetic(initial.charAt(0))) {
				firstInitialInput = initial.charAt(0);
				endVal = 0;
			} else {
				System.out.println("Invalid format. Make sure initial is a letter");
			}
		} while (endVal != 0);
	}

	private void checkandSetGender(Scanner input) {
		String boyOrGirl;
		int endVal = 1;
		do {
			System.out.print("Enter gender: ");
			boyOrGirl = input.next().toUpperCase();
			if (boyOrGirl.equals("BOY") || boyOrGirl.equals("GIRL")) {
				genderInput = boyOrGirl;
				endVal = 0;
			} else {
				System.out.println("Invalid format. Make sure gender is spelt correctly");
			}
		} while (endVal != 0);
	}

	private void createNamesFromParam() {
		System.out.println("Names that start with " + firstInitialInput + " and are gender: " + genderInput
				+ " (Sorted by Last Name Alphabetically)");
		for (Name name : names) {
			if (name.getFirstName().charAt(0) == firstInitialInput && name.getGender().equals(genderInput)) {
				if (nElems == namesFromParam.length) {
					namesFromParam = Arrays.copyOf(namesFromParam, namesFromParam.length + 1);
				}
				namesFromParam[nElems++] = name;
			}
		}
	}

//	private void sortNamesFromParam() {
//		// Comparator in names class, checks last names, then first
//		Arrays.sort(namesFromParam, (a, b) -> a.compareTo(b));
//	}
	private void sortNamesFromParam() {
		namesFromParam = InsertionSort.sort(namesFromParam);
	}

	private void createFile() {
		namesFromParamFile = CreateFileUtil.createFile(namesParamFolder);
	}

	private void printNamesToFile() {
		PrintWriter print = null;
		try {
			print = printNames(print);
		} catch (FileNotFoundException e) {
			System.out.println("PrintWriter could not find file");
		} finally {
			print.close();
		}
	}

	private PrintWriter printNames(PrintWriter print) throws FileNotFoundException {
		print = new PrintWriter(namesFromParamFile.getAbsolutePath());
		for (int i = 0; i < namesFromParam.length; i++) {
			print.println(namesFromParam[i].toString());
		}
		return print;
	}
	public Name[] getNamesFromParam() {
		return namesFromParam;
	}
	public void display() {
		for(Name name: namesFromParam) {
			System.out.println(name.toString());
		}
	}

}