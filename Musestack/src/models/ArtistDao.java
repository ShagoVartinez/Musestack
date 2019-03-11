package models;

import java.util.ArrayList;

public class ArtistDao {
	
	private ArrayList<Artist> artistsList;
	
	public ArtistDao() {
		artistsList = new ArrayList<>();
	}
	
	public Artist createArtist(int id, String name, String email, int phone, String password, Genre genre) {
		return new Artist(id, name, email, phone, password, genre);		
	}
	
	public void addArtist(Artist artist) {
		artistsList.add(artist);
	}
	
	public ArrayList<Artist> getArtistsList(){
		return artistsList;
	}
	
	//add artists reports

}
