package persistence;

import java.io.IOException;
import java.util.ArrayList;

public interface Persitence {

	//general methods for entity's data reading, saving and update
	public  ArrayList<Object[]> readData(String fileName);
	
	public  void writeData(ArrayList<Object[]> objectList) throws IOException;
	
	public ArrayList<Object> getObjectsList();
	
}
