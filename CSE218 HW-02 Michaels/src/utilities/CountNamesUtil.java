package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class CountNamesUtil {
	
	private CountNamesUtil() {
	}
		public static int getUserAmount() {
			try {
				return countUserAmount();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		private static int countUserAmount() throws FileNotFoundException {
			int userCount = 0;
			Scanner scan = new Scanner(new FileReader("3000_students.txt"));
			while(scan.hasNext()) {
				if(scan.next().contains(".")) {
					userCount++;
				}
			}
			scan.close();
			return userCount;
		}
}
