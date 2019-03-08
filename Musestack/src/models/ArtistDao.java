package models;

import java.util.ArrayList;

public class ArtistDao {
	
	private ArrayList<Artist> artistsList;
	
	public ArtistDao() {
		artistsList = new ArrayList<>();
	}
	
	public Artist createArtist(int id, String name, String email, String country, String city, Genre genre) {
		return new Artist(id, name, email, country, city, genre);		
	}
	
	public void addArtist(Artist artist) {
		artistsList.add(artist);
	}
	
	public ArrayList<Artist> getArtistsList(){
		return artistsList;
	}

}
