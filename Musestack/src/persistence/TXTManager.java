package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TXTManager {
	
	public static ArrayList<String> readUserTextFile(String filePath) throws IOException {
		ArrayList<String> bookList = new ArrayList<>();
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			bookList.add(line);
		}
		bufferedReader.close();
		return bookList;
	}
	
	public static void writeUserTextFile(ArrayList<String> userList) throws IOException {
		FileWriter writer = new FileWriter(new File("./resource/userList.txt"), true);
		writer.write(""+userList);
		writer.close();
	}
}
