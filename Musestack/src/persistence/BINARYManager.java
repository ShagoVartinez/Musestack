package persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BINARYManager {

	public static ArrayList<Object[]> readAdministratorBinary(String fileName) {
		ArrayList<Object[]> objectList = new ArrayList<>();
		FileInputStream fileIS = null;
		DataInputStream dataIS = null;
		try {
			fileIS = new FileInputStream(fileName);
			dataIS = new DataInputStream(fileIS);
			while (dataIS.available() > 0) {
				long id = dataIS.readInt();
				String photo = dataIS.readUTF();
				String firstName = dataIS.readUTF();
				String lastName = dataIS.readUTF();
				long phone = dataIS.readLong();
				String city = dataIS.readUTF();
				String email = dataIS.readUTF();
				String password = dataIS.readUTF();
				objectList.add(new Object[]{id, photo, firstName, lastName, phone, city, email, password});
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (EOFException e) {
			System.out.println("Fin de fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fileIS != null) {
					fileIS.close();
				} 
				if (dataIS != null) {
					dataIS.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return objectList;
	}
	
	public static void writeBinary(ArrayList<Object[]> objectList) throws IOException {
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;
		
		try {
			File file = new File("./resources/AdministratorList.bin");
			file.delete();
			fileOutputStream = new FileOutputStream(file, true);
			dataOutputStream = new DataOutputStream(fileOutputStream);
						
			for (int i = 0; i < objectList.size(); i++) {
				Object[] line = objectList.get(i);
				dataOutputStream.writeLong((long) line[0]);
				dataOutputStream.writeUTF((String)line[1]);
				dataOutputStream.writeUTF((String)line[2]);
				dataOutputStream.writeUTF((String)line[3]);
				dataOutputStream.writeLong((long)line[4]);
				dataOutputStream.writeUTF((String)line[5]);
				dataOutputStream.writeUTF((String)line[6]);
				dataOutputStream.writeUTF((String)line[7]);	
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (dataOutputStream != null) {
					dataOutputStream.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
