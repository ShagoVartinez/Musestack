package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;



public class EventManager {
	
	private ArrayList<Event> eventList;
	
	public EventManager() {
		eventList = new ArrayList<>();
	}
	
	public Event createEvent(String name, Genre genre, Gallery exhibitionPlace, LocalDate initialDate, 
			LocalDate finalDate, ArrayList<Artist > participatingArtistList, ArrayList<Picture> exhibitedPictureList){
		Event createdEvent = null;
		//DATE VALIDATION
		if(isAtTime(localDateToCalendar(initialDate), localDateToCalendar(finalDate))) {
			createdEvent = new Event(name, genre, exhibitionPlace, initialDate, finalDate, participatingArtistList, exhibitedPictureList);
		}else {
		System.err.println("La fecha INICIAL debe ser MAYOR A LA ACTUAL\ny la fecha FINAL debe ser MAYOR A LA INICIAL");
		}
		
		//GALLERY VALIDATION
		if(exhibitionPlace.isAvailable()) {
			createdEvent = new Event(name, genre, exhibitionPlace, initialDate, finalDate, participatingArtistList, exhibitedPictureList);
		}else {
		System.err.println("la galleria " + exhibitionPlace.getName() + " no se encuentra disponible");
		}
		
		return createdEvent;
	}
	
	public void addEvent(Event event) {
		eventList.add(event);
	}
	
	public ArrayList<Event> getEventList() {
		return eventList;
	}
	
	public Calendar localDateToCalendar(LocalDate localDate) {
	      Calendar toCalendar = Calendar.getInstance();
	      toCalendar.clear();
	      toCalendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
	      return toCalendar;
	  }
	
	public boolean isAtTime(Calendar initialDate, Calendar finalDate) {
		boolean isInTime = true;
		Calendar today = Calendar.getInstance(); 
		//the dates are INCORRECT IF initialDate is before today or final date is before initialDate
		if(initialDate.before(today) || finalDate.before(initialDate)) {	
			isInTime = false;
		}
		return isInTime;
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
	
//	DATES & Gallery TEST
//	public static void main(String[]arg) {
//		import java.time.format.DateTimeFormatter;
//		EventManager em = new EventManager();
//		String iDate = "05/04/2019";
//		String fDate = "06/04/2019";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//	    LocalDate iLocalDate = LocalDate.parse(iDate,
//	            formatter);
//	    LocalDate fLocalDate = LocalDate.parse(fDate,
//                formatter);
//	    em.createEvent("xd", Genre.ABSTRACCIONISMO, GalleryManager.createGallery(null, null, null, 0, true), iLocalDate, fLocalDate, new ArrayList<Artist>(), new ArrayList<Picture>());
//	}

}