package persistence;

import java.util.ArrayList;

public interface Persitence {

	//general methods for entity's data reading, saving and update
	public void readData();
	
	public void writeData();
	
	public ArrayList<Object> getObjectsList();
	
}
