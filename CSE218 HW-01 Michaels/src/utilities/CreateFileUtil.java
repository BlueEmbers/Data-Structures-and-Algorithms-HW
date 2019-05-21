package utilities;

import java.io.File;
import java.io.IOException;

public class CreateFileUtil {
	
	private CreateFileUtil() {	
	}
	public static File createFile(File folder) {
		File file = new File(folder.getAbsolutePath() + "\\Names1.txt");
		file = checkFileName(file, folder);
		try {
			file.createNewFile();
			return file;
		} catch (IOException e) {
			System.out.println("File failed to create");
		}
		return null;
	}
	public static File createFolder() {
		File folder = new File("namesFromParams");
		folder.mkdirs();
		return folder;
	}
	private static File checkFileName(File file, File folder) {
		int count = 1;
		while (file.exists()) {
			count++;
			file = new File(folder.getAbsolutePath() + "\\Names" + count + ".txt");
		}
		if (!file.exists()) {
			return file;
		}
		return null;
	}
}
