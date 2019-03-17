package models;

import java.util.ArrayList;

public class ArtistManager {
	private ArrayList<Artist> artistList;
	
	public ArtistManager() {
		artistList = new ArrayList<>();
	}
	
	public Artist createArtist(long id, String photo, String firstName, String lastName, 
			long phone, String city, String address, String email, String password){
		return new Artist(id, photo, firstName, lastName, phone, city, address, email, password);
	}
	
	public void addArtist(Artist artist) {
		artistList.add(artist);
	}
	
	public ArrayList<Artist> getArtistList() {
		return artistList;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < artistList.size(); i++) {
			objectList.add(new Object[] {artistList.get(i).getId(), 
					artistList.get(i).getPhoto(), 
					artistList.get(i).getFirstName(),
					artistList.get(i).getLastName(), 
					artistList.get(i).getPhone(),
					artistList.get(i).getCity(),
					artistList.get(i).getAddress(),
					artistList.get(i).getEmail(),
					artistList.get(i).getPassword()});
		}
		return objectList;
	}
}