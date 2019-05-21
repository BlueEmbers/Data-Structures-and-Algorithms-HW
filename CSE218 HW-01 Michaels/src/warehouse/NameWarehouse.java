package warehouse;

import java.util.Scanner;
import people.Name;
import utilities.ImportFileUtil;

public class NameWarehouse {
	private final int NAMES_MAX_SIZE;
	private Scanner scanBoys;
	private Scanner scanGirls;
	private Scanner scanLasts;
	private String[] boysNamesArray;
	private String[] girlsNamesArray;
	private String[] lastNamesArray;
	private int nElems;
	private Name[] names;

	public NameWarehouse() {
		importScanners();
		createLists();
		NAMES_MAX_SIZE = addTotalNames();
		names = new Name[NAMES_MAX_SIZE];
		createArraysFromText();
		fillNameArray();
	}

	private void importScanners() {
		scanBoys = ImportFileUtil.createBoysScanner();
		scanGirls = ImportFileUtil.createGirlsScanner();
		scanLasts = ImportFileUtil.createLastsScanner();
	}

	private void createLists() {
		boysNamesArray = new String[ImportFileUtil.countNamesBoys()];
		girlsNamesArray = new String[ImportFileUtil.countNamesGirls()];
		lastNamesArray = new String[ImportFileUtil.countNamesLasts()];
	}

	private int addTotalNames() {
		return boysNamesArray.length + girlsNamesArray.length;
	}

	private void createArraysFromText() {
		textIntoArrayBoys();
		textIntoArrayGirls();
		textIntoArrayLasts();
	}

	private void textIntoArrayBoys() {
			while (scanBoys.hasNext()) {
				String name = scanBoys.next();
				if (Character.isLetter(name.charAt(0))) {
					boysNamesArray[nElems++] = name;
				}
			}
			nElems= 0;
	}
	private void textIntoArrayGirls() {
			while (scanGirls.hasNext()) {
				String name = scanGirls.next();
				if (Character.isLetter(name.charAt(0))) {
					girlsNamesArray[nElems++] = name;
				}
			}
			nElems = 0;
	}

	private void textIntoArrayLasts() {
			while (scanLasts.hasNext()) {
				String name = scanLasts.next();
				if (Character.isLetter(name.charAt(0))) {
					lastNamesArray[nElems++] = name;
				}
		}
			nElems = 0;
	}

	private void fillNameArray() {
		addToNameArrayBoys();
		addToNameArrayGirls();
	}

	private void addToNameArrayBoys() {
		for (int i = 0; i < boysNamesArray.length; i++) {
			names[i] = new Name(boysNamesArray[i], lastNamesArray[(int) (Math.random() * lastNamesArray.length)],
					"BOY");
		}
	}

	private void addToNameArrayGirls() {
		for (int i = 0, j = boysNamesArray.length; i < girlsNamesArray.length; i++, j++) {
			names[j] = new Name(girlsNamesArray[i], lastNamesArray[(int) (Math.random() * lastNamesArray.length)],
					"GIRL");
		}
	}

	public void displayNames() {
		for (Name name : names) {
			System.out.println(name.toString());
		}
	}

	public Name[] getNames() {
		return names;
	}

}