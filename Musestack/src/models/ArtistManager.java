package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArtistManager {
	private ArrayList<Artist> artistList;
	private ArrayList<Genre> genresList;
	private double[] countByGenres;
	
	public ArtistManager() {
		artistList = new ArrayList<Artist>();
		genresList = new ArrayList<Genre>();
		countByGenres = new double[Genre.values().length];
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
	
	public ArrayList<Artist> getArtistsByGenres(Genre genre) {
		ArrayList<Artist> ArtistsByGenre = new ArrayList<Artist>();
		
		for (Artist artist : artistList) {
			for (Genre artistGenre : artist.getGenres()) {
				if(genre == artistGenre) {
					ArtistsByGenre.add(artist);
				}
			}
		}
		return ArtistsByGenre;
	}
	
	public double[] getArtistsByAllGenres() {
		
		for (int i = 0; i < Genre.values().length; i++) {
			countByGenres[i] = (double) getArtistsByGenres(Genre.values()[i]).size();
		}
		
		return countByGenres;
	}
	
	//artist's genres have to be setted once an artist's picture is created
	//(if the genre is already in the list don't add)
	public void setArtistGenre(Genre genre){
		genresList.add(genre);
	}
	
	public ArrayList<Artist> filterArtistsByName(String name, String lastName){
		ArrayList<Artist> foundArtist = new ArrayList<>();
		//check if user searchs by lastName, if not search just by name
		for(Artist artist : artistList) {
			if(artist.getFirstName().toLowerCase().equals(name.toLowerCase())
					&& artist.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
						foundArtist.add(artist);
			}
		}
		
		return foundArtist;
	}
	


	public ArrayList<Artist> sortByScore(){
		ArrayList<Artist> orderedArtists = new ArrayList<Artist>();
		
		Collections.sort(artistList, new Comparator<Artist>() {
			public int compare(Artist a1, Artist a2) {
				return new Double(a1.getScore()).compareTo(a2.getScore());
			}
		});
		//Collections sorts from smaller to greater by default, so gotta reverse the arrayList
		Collections.reverse(artistList);
		
		return orderedArtists;		
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
					artistList.get(i).getPassword()}
			);
		}
		return objectList;
	}
}