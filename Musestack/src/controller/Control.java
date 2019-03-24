package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Vector;

import models.Genre;
import models.MainDao;
import views.DialogLoginAdministrator;
import views.DialogLoginArtist;
import views.MusestackUserWindow;
import views.MusestackWindow;
import views.PanelGraphicBar;

public class Control implements ActionListener{
	private MainDao mainDao;
	private MusestackWindow musestackWindow;
	private MusestackUserWindow musestackUserWindow;
	private DialogLoginArtist dialogLoginArtist;
	private DialogLoginAdministrator dialogLoginAdministrator;
	
	public Control() {
		mainDao = new MainDao();
		musestackWindow = new MusestackWindow(this);
		musestackUserWindow = new MusestackUserWindow(this);
		dialogLoginArtist = new DialogLoginArtist(this);
		dialogLoginAdministrator = new DialogLoginAdministrator(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case MUSESTACK_WINDOW:
			musestackUserWindow.setVisible(false);
			musestackWindow.setVisible(true);
			break;
		case PLATFORM_ARTIST:	
			break;
		case PLATFORM_USER:
			musestackWindow.setVisible(false);
			musestackUserWindow.setVisible(true);
			break;
		case PLATFORM_ADMINISTRATOR:
			break;
		case PANEL_LOGIN_USER:
			musestackUserWindow.changeToPanelLoginUser();
			break;
		case PANEL_INITIAL_USER:
			initUser();
			break;
		case PANEL_INITIAL_ARTIST:
			musestackWindow.changeToPanelInitialArtist();
			dialogLoginArtist.setVisible(false);
			break;
		case PANEL_INITIAL_ADMIN:
			musestackWindow.changeToPanelInitialAdmin();
			dialogLoginAdministrator.setVisible(false);
		case PANEL_USER_REGISTER:
			musestackUserWindow.changeToPanelUserRegister();
			break;
		case PANEL_USER_EVENTS:
			musestackUserWindow.changeToPanelUserEvents();
			break;
		case PANEL_USER_ARTISTS:
			musestackUserWindow.changeToPanelUserArtist();
			break;
		case PANEL_USER_PICTURES:
			musestackUserWindow.changeToPanelUserPictures();
			break;
		case PANEL_USER_ARTIST_PICTURE:
			musestackUserWindow.changeToPanelUserArtistPictures();
		case PANEL_CALIFICATION:
			musestackUserWindow.changeToPanelCalification();
			break;
		case PANEL_USER_INFO:
			musestackUserWindow.changeToPanelUserInfo();
			break;
		case PANEL_TOP_CALIFICATIONS:
			musestackUserWindow.changeToPanelTopCalifications();
			break;
		case LOGIN_ARTIST:
			dialogLoginArtist.setVisible(true);
			break;
		case LOGIN_ADMIN:
			dialogLoginAdministrator.setVisible(true);
			break;
		case READFILE:			
			break;
		case WRITE_BINARY_FILE:
			break;
		case OPEN_FACEBOOK:
			openFacebook();
			break;
		case OPEN_TWITER:
			openTwitter();
			break;
		case OPEN_INSTAGRAM:
			openInstagram();
			break;
		case GRAPH_ARTIST_BY_GENRE:
			barsNumArtistByGenre();
			break;
		default:
			break;
		}
	}
	
	private void barsNumArtistByGenre() {
		double[] artistsByGenre = mainDao.getArtMng().getArtistsByAllGenres();
		
		for (int i = 0; i < artistsByGenre.length; i++) {
			System.out.println(artistsByGenre[i]);
		}
		
		String[] stringGenres = new String[Genre.values().length];
		
		for (int i = 0; i < Genre.values().length; i++) {
			stringGenres[i] = Genre.values()[i].toString();
		}
		
		PanelGraphicBar graphic = new PanelGraphicBar(stringGenres , artistsByGenre);
		
		musestackWindow.changeToGraphic(graphic);
		musestackUserWindow.setVisible(false);
		musestackWindow.setVisible(true);
		
	}

	private void initUser() {
		//validate username and password
//		if(mainDao.getUserMng().getUser) {
//		musestackUserWindow.changeToPanelInitialUser();
//		}
	}

	private void openFacebook() {
		URI uri;
		try {
			uri = new URI("https://facebook.com");
			Desktop.getDesktop().browse(uri);				
		} catch (URISyntaxException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void openTwitter() {
		URI uri;
		try {
			uri = new URI("https://twitter.com/");
			Desktop.getDesktop().browse(uri);				
		} catch (URISyntaxException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void openInstagram() {
			URI uri;
		try {
			uri = new URI("https://www.instagram.com/");
			Desktop.getDesktop().browse(uri);				
		} catch (URISyntaxException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}