package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import models.ArtistDao;
import persistence.FileManager;
import views.MusestackFrame;

public class MainController implements ActionListener{

	private FileManager fMng;
	private ArtistDao artistDao;//Dao manage on controller, arrays' creation
	private MusestackFrame frame;
	
	public MainController() {
		fMng = new FileManager();
		artistDao = new ArtistDao();
		frame = new MusestackFrame(this);
		init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(Event.valueOf(e.getActionCommand())) {
		case TEST:
			System.out.println("xd");
			break;
		default:
			break;
		}
		
	}

	private void init() {
//		refreshArtistData();
	}

//	private void refreshArtistData() {
//		try {
//			fMng.readArtists();
//		} catch (SAXException | IOException | ParserConfigurationException e) {
//			e.printStackTrace();
//		}
//	}
}
