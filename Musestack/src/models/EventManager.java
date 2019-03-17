package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventManager {
	
	private ArrayList<Event> eventList;
	
	public EventManager() {
		eventList = new ArrayList<>();
	}
	
	public Event createEvent(String name, Genre genre, Gallery exhibitionPlace, LocalDate initialDate, 
			LocalDate finalDate, ArrayList<Artist > participatingArtistList, ArrayList<Picture> exhibitedPictureList){
		return new Event(name, genre, exhibitionPlace, initialDate, finalDate, participatingArtistList, exhibitedPictureList);
	}
	
	public void addEvent(Event event) {
		eventList.add(event);
	}
	
	public ArrayList<Event> getEventList() {
		return eventList;
	}
	
	public ArrayList<Object[]> createObjectForTable() {
		ArrayList<Object[]> objectList = new ArrayList<>();
		for (int i = 0; i < eventList.size(); i++) {
			objectList.add(new Object[] {eventList.get(i).getName(), 
					eventList.get(i).getGenre(), 
					eventList.get(i).getExhibitionPlace(),
					eventList.get(i).getInitialDate(), 
					eventList.get(i).getFinalDate(),
					eventList.get(i).getParticipatingArtistList(),
					eventList.get(i).getExhibitedPictureList()});
		}
		return objectList;
	}

}