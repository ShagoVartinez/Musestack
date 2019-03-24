package models;

import java.io.IOException;
import java.util.ArrayList;

import persistence.TXTManager;

public class AdministratorManager {
	
	private ArrayList<Administrator> administratorList;
	
	public AdministratorManager() {
		administratorList = new ArrayList<>();
	}
	
	public Administrator createAdministrator(long id, String photo, String firstName, String lastName, 
			long phone, String city, String email, String password){
		return new Administrator(id, photo, firstName, lastName, phone, city, email, password);
	}
	
	public void addAdministrator(Administrator administrator) {
		administratorList.add(administrator);
	}
	
	public ArrayList<Administrator> getAdministratorList() {
		return administratorList;
	}
	
	public void readAdministrator() throws IOException {
		String pathFile = "./resources/administrators.txt";
		ArrayList<String> list = TXTManager.readUserTextFile(pathFile);
		AdministratorManager aMng = new AdministratorManager();
		for (int i = 0; i < list.size(); i++) {
			String line = list.get(i);
			String[] dataAdmin = line.split("/");
			long id = Long.parseLong(dataAdmin[0]);
			String photo = dataAdmin[1];
			String firstName = dataAdmin[2];
			String lastName = dataAdmin[3];
			long phone = Long.parseLong(dataAdmin[4]);
			String city = dataAdmin[5];
			String email = dataAdmin[6];
			String password = dataAdmin[7];
			aMng.addAdministrator(aMng.createAdministrator(id, photo, firstName, 
					lastName, phone, city, email, password));
		}
		System.out.println(list);
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < administratorList.size(); i++) {
			objectList.add(new Object[] {administratorList.get(i).getId(), 
					administratorList.get(i).getPhoto(), 
					administratorList.get(i).getFirstName(),
					administratorList.get(i).getLastName(), 
					administratorList.get(i).getPhone(),
					administratorList.get(i).getCity(),
					administratorList.get(i).getEmail(),
					administratorList.get(i).getPassword()});
		}
		return objectList;
	}
}