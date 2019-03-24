package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainDao {
		
		private AdministratorManager adminMng;
		private ArtistManager artMng;
		private UserManager userMng;
		private PictureManager picMng;
		private GalleryManager gallMng;
		private EventManager evMng;
		private CritiqueManager critMng;
		
		public MainDao() {
			adminMng = new AdministratorManager();
			artMng = new ArtistManager();
			userMng = new UserManager();
			picMng = new PictureManager();
			gallMng = new GalleryManager();
			evMng = new EventManager();
			critMng = new CritiqueManager();
		}

		public AdministratorManager getAdminMng() {
			return adminMng;
		}

		public ArtistManager getArtMng() {
			return artMng;
		}

		public 	UserManager getUserMng() {
			return userMng;
		}

		public PictureManager getPicMng() {
			return picMng;
		}

		public GalleryManager getGallMng() {
			return gallMng;
		}
		
		public EventManager getEvMng() {
			return evMng;
		}
		
		public CritiqueManager getCritMng() {
			return critMng;
		}
		
		public Picture findRankedArtistPicture(Artist artist) {
			ArrayList<Picture> artistPicturesRanked = new ArrayList<Picture>();
			
			for (Picture picture : picMng.getPictureList()) {
				if(picture.getAuthor() == artist) {
					artistPicturesRanked.add(picture);
				}
			}
			
			Collections.sort(artistPicturesRanked, new Comparator<Picture>() {
				public int compare(Picture p1, Picture p2) {
					return new Double(p1.getPromScore()).compareTo(p2.getPromScore());
				}
			});
			
			Picture mostRankedPicture = artistPicturesRanked.get(artistPicturesRanked.size());
			
			return mostRankedPicture;
		}
		
		public ArrayList<Artist> findBestScoreArtists() {
			ArrayList<Artist> bestScoreArtists = new ArrayList<Artist>();
			
			for (Artist artist : artMng.getArtistList()) {
			double artistAverageScore = 0;
			int picturesNum = 0;
			for (Picture thisArtistPicture : picMng.findByAuthor(artist)) {
				artistAverageScore = artistAverageScore + thisArtistPicture.getPromScore();
				picturesNum ++;
			}
			artistAverageScore = artistAverageScore / (double) picturesNum;
			artist.setScore(artistAverageScore);
			}
			
			for (int i = 0 ; i < 5 ; i++) {
				bestScoreArtists.add(artMng.sortByScore().get(i));
			}
			
			return bestScoreArtists;
		}
		
		//retorna un array de eventos eventos dentro de un periodo de tiempo determinado
		public ArrayList<Event> eventsByGallery(Gallery gallery, LocalDate initDate, LocalDate endDate){//if dates are null checks all events no metter time
			ArrayList<Event> foundEvents = new ArrayList<Event>();
			
			if(initDate.isBefore(endDate) || initDate.isEqual(endDate)) {
				for (Event event : evMng.getEventList()) {
					if(event.getExhibitionPlace() == gallery) {
						foundEvents.add(event);
					}
				}
				
				for (Event event : foundEvents) {
					if(!event.getInitialDate().isAfter(initDate) && !event.getInitialDate().isBefore(endDate)) {
						foundEvents.remove(event);
					}
				}
			}else {
				System.err.println("ERROR: LA FECHA FINAL ES MENOR QUE LA INICIAL");
			}
			
			return foundEvents;
		}
		
		public ArrayList<Event> eventsByArtist(Artist artist, LocalDate initDate, LocalDate endDate) {
			ArrayList<Event> foundEvents = new ArrayList<Event>();
			
			if(initDate.isBefore(endDate) || initDate.isEqual(endDate)) {
				for (Event event : evMng.getEventList()) {
					if(event.getParticipatingArtistList().contains(artist)) {
						foundEvents.add(event);
					}
				}
				
				for (Event event : foundEvents) {
					if(!event.getInitialDate().isAfter(initDate) && !event.getInitialDate().isBefore(endDate)) {
						foundEvents.remove(event);
					}
				}
			}else {
				System.err.println("ERROR: LA FECHA FINAL ES MENOR QUE LA INICIAL");
			}
			
			return foundEvents;
		}
		
		//agrega a cada artista una lista de generos dependiendo de los generos de pinturas de su autoria.
		public void setArtistGenres() {			
			for (Artist artist : artMng.getArtistList()) {
				ArrayList<Genre> thisArtistGenres = new ArrayList<Genre>();
				for (Picture thisArtistPicture : picMng.findByAuthor(artist)) {
					if(!thisArtistGenres.contains(thisArtistPicture.getGenre())) {
						thisArtistGenres.add(thisArtistPicture.getGenre());
					}
				}
				artist.setGenres(thisArtistGenres);
			}
		}
}