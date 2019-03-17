package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import models.AdministratorManager;
import persistence.BINARYManager;
import persistence.TXTManager;
import views.MusestackUserWindow;
import views.MusestackWindow;

public class Control implements ActionListener{
	private AdministratorManager administratorManager;
	private MusestackWindow musestackWindow;
	private MusestackUserWindow musestackUserWindow;
	
	public Control() throws IOException {
		administratorManager = new AdministratorManager();
		musestackWindow = new MusestackWindow(this);
		musestackUserWindow = new MusestackUserWindow(this);
		
//		readAdministrator();
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
			musestackUserWindow.changeToPanelInitialUser();
			break;
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
		case READFILE:
			
			break;
		case WRITE_BINARY_FILE:
			break;
		default:
			break;
		}
	}
	
//	private void load
		
	private void readAdministrator() throws IOException {
		String pathFile = "./resources/administrators.txt";
		ArrayList<String> list = TXTManager.readUserTextFile(pathFile);
		for (int i = 0; i < list.size(); i++) {
			String line = list.get(i);
			String[] dataAdmin = line.split("/");
			long id = Long.parseLong(dataAdmin[0]);
			String photo = dataAdmin[1];
			String firstName = dataAdmin[2];
			String lastName = dataAdmin[3];
			long phone = Long.parseLong(dataAdmin[4]);
			String city = dataAdmin[5];
			String email = dataAdmin[6];
			String password = dataAdmin[7];
			administratorManager.addAdministrator(administratorManager.createAdministrator(id, photo, firstName, 
					lastName, phone, city, email, password));
		}
		System.out.println(list);
		BINARYManager.writeBinary(administratorManager.createObjectForTable());
	}
	
	public static void main(String[] args) throws IOException {
		new Control();
	}

}
