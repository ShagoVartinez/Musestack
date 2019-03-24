package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MusestackUserWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelActual;
	private PanelLoginUser panelLoginUser;
	private PanelInitialUser panelInitialUser;
	private PanelUserRegister panelUserRegister;
	private PanelUserEvents panelUserEvents;
	private PanelUserArtists panelUserArtists;
	private PanelUserPictures panelUserPictures;
	private PanelUserArtistPictures panelUserArtistPictures;
	private PanelCalification panelCalification;
	private PanelUserInfo panelUserInfo;
	private PanelTopCalifications panelTopCalifications;

	public MusestackUserWindow(ActionListener actionListener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(300, 480));
		this.setLocationRelativeTo(null);
		setTitle("Musestack");
		setIconImage(new ImageIcon(getClass().getResource("/img/MusestackIcon.png")).getImage());
		
		initComponents(actionListener);
		
		
		setVisible(false);
	}
	
	public void initComponents(ActionListener actionListener) {
		panelLoginUser = new PanelLoginUser(actionListener);
		panelInitialUser = new PanelInitialUser(actionListener);
		panelUserRegister = new PanelUserRegister(actionListener);
		panelUserEvents = new PanelUserEvents(actionListener);
		panelUserArtists = new PanelUserArtists(actionListener);
		panelUserPictures = new PanelUserPictures(actionListener);
		panelUserArtistPictures = new PanelUserArtistPictures(actionListener, "Osama Bin Laden");
		panelCalification = new PanelCalification(actionListener);
		panelUserInfo = new PanelUserInfo(actionListener);
		panelTopCalifications = new PanelTopCalifications(actionListener);
		add(panelLoginUser, BorderLayout.CENTER);
		
		panelActual = panelLoginUser;
	}
		
	public void changePanel(JPanel panel) {
		getContentPane().remove(panelActual);
		panelActual = panel;
		add(panelActual, BorderLayout.CENTER);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
	public void changeToPanelLoginUser() {
		changePanel(panelLoginUser);
	}
	
	public void changeToPanelInitialUser() {
		changePanel(panelInitialUser);
	}
	
	public void changeToPanelUserRegister() {
		changePanel(panelUserRegister);
	}
	
	public void changeToPanelUserEvents() {
		changePanel(panelUserEvents);
	}
	
	public void changeToPanelUserArtist() {
		changePanel(panelUserArtists);
	}
	
	public void changeToPanelUserPictures() {
		changePanel(panelUserPictures);
	}
	
	public void changeToPanelUserInfo() {
		changePanel(panelUserInfo);
	}
	
	public void changeToPanelUserArtistPictures() {
		changePanel(panelUserArtistPictures);
	}
	
	public void changeToPanelCalification() {
		changePanel(panelCalification);
	}
	
	public void changeToPanelTopCalifications() {
		changePanel(panelTopCalifications);
	}
}