package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ImportFileUtil {
	private ImportFileUtil() {	
	}
	private static File createBoysFile() {
		return new File("boy_names.txt");
	}
	private static File createGirlsFile() {
		return new File("girls_names.txt");
	}
	private static File createLastsFile() {
		return new File("last_names.txt");
	}
	public static Scanner createBoysScanner()  {
		try {
			return new Scanner(new FileReader(createBoysFile()));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		return null;
	}
	public static Scanner createGirlsScanner() {
		try {
			return new Scanner(new FileReader(createGirlsFile()));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		return null;
	}
	public static Scanner createLastsScanner(){
		try {
			return new Scanner(new FileReader(createLastsFile()));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		return null;
	}
	public static int countNamesBoys() {
		int nNames = 0;
		Scanner scan = createBoysScanner();
		while(scan.hasNext()) {
			if(Character.isLetter(scan.next().charAt(0))) {
				nNames++;
			}
		}
		return nNames;
	}
	public static int countNamesGirls() {
		int nNames = 0;
		Scanner scan = createGirlsScanner();
		while(scan.hasNext()) {
			if(Character.isLetter(scan.next().charAt(0))) {
				nNames++;
			}
		}
		return nNames;
	}
	public static int countNamesLasts() {
		int nNames = 0;
		Scanner scan = createLastsScanner();
		while(scan.hasNext()) {
			if(Character.isLetter(scan.next().charAt(0))) {
				nNames++;
			}
		}
		return nNames;
	}
	
}
