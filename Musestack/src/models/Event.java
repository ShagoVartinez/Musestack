package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
	
	private String name;
	private Genre genre;
	private Gallery exhibitionPlace;
	private LocalDate initialDate;
	private LocalDate finalDate;
	private ArrayList<Artist> participatingArtistList;
	private ArrayList<Picture> exhibitedPictureList;
	
	public Event(String name, Genre genre, Gallery exhibitionPlace, LocalDate initialDate, LocalDate finalDate,
			ArrayList<Artist> participatingArtistList, ArrayList<Picture> exhibitedPictureList) {
		this.name = name;
		this.genre = genre;
		this.exhibitionPlace = exhibitionPlace;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.participatingArtistList = participatingArtistList;
		this.exhibitedPictureList = exhibitedPictureList;
	}

	public String getName() {
		return name;
	}

	public Genre getGenre() {
		return genre;
	}

	public Gallery getExhibitionPlace() {
		return exhibitionPlace;
	}

	public LocalDate getInitialDate() {
		return initialDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public ArrayList<Artist> getParticipatingArtistList() {
		return participatingArtistList;
	}

	public ArrayList<Picture> getExhibitedPictureList() {
		return exhibitedPictureList;
	}
}