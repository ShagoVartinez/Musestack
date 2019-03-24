package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.Actions;

public class PanelUserArtistPictures extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelContainArtists;
	private JPanel panelPictures;
	private JScrollPane jspArtists;
	
	public PanelUserArtistPictures(ActionListener actionListener, String author) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener, author);
	}
	
	public void initComponents(ActionListener actionListener, String author) {
		headerUserWindow(actionListener);
		panelArtists(actionListener, author);
	}
	
	public void headerUserWindow(ActionListener actionListener) {
		panelHeader = new JPanel();
		panelHeader.setLayout(new BorderLayout());
		panelHeader.setBackground(Color.decode("#000000"));
		panelHeader.setBorder(BorderFactory.createEmptyBorder(7, 9, 7, 9));
		
		userPhoto = new RoundedButton(45);
		userPhoto.setAlignmentX(SwingConstants.LEFT);
		userPhoto.setFocusable(false);
		userPhoto.setBorderPainted(false);
		userPhoto.setPreferredSize(new Dimension(45, 45));
		userPhoto.setIcon(new ImageIcon(getClass().getResource("/imgUsers/user1.png")));
		userPhoto.setBackground(Color.decode("#FFF34C"));
		panelHeader.add(userPhoto, BorderLayout.LINE_START);
		
		nameUser = new JLabel("user1");
		nameUser.setForeground(Color.decode("#FFFFFF"));
		nameUser.setFont(new Font("Helvetica", Font.PLAIN, 15));
		nameUser.setBorder(BorderFactory.createEmptyBorder(3, 7, 3, 3));
		panelHeader.add(nameUser, BorderLayout.CENTER);
		
		buttonBack = new JButton();
		buttonBack.setIcon(new ImageIcon(getClass().getResource("/img/back.png")));;
		buttonBack.setFocusable(false);
		buttonBack.setContentAreaFilled(false);
		buttonBack.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		buttonBack.addActionListener(actionListener);
		buttonBack.setActionCommand(Actions.PANEL_LOGIN_USER.toString());
		panelHeader.add(buttonBack, BorderLayout.LINE_END);
		
		add(panelHeader);
	}
	
	public void panelArtists(ActionListener actionListener, String author) {
		panelContainArtists = new JPanel();
		panelContainArtists.setOpaque(false);
		panelContainArtists.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Obras de "+author, SwingConstants.CENTER);
		title.setFont(new Font("Helvetica", Font.BOLD, 17));
		title.setForeground(Color.decode("#FFFFFF"));
		title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		panelContainArtists.add(title, BorderLayout.PAGE_START);
		
		panelPictures = new JPanel();
		panelPictures.setOpaque(false);
		int maxArtists = 0;
		if (maxArtists > 0) {
			panelPictures.setLayout(new GridLayout(maxArtists, 1, 0, 50));
			panelPictures.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			for (int i = 0; i < maxArtists; i++) {
				CardPicture cp = new CardPicture(actionListener, "paisaje.png", "9-11", "Osama bin laden", "100 x 100 cm", "2011", "Terrorismo", "Vendido");
				cp.setOpaque(false);
				panelPictures.add(cp);
			}
		} else {
			panelPictures.setLayout(new GridLayout(3, 1, 0, 50));
			panelPictures.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			JLabel message = new JLabel("<html><center>El artista seleccionado<br></br>no tiene obras</center><html>", SwingConstants.CENTER);
			message.setFont(new Font("Helvetica", Font.BOLD, 17));
			message.setForeground(Color.decode("#000000"));
			panelPictures.add(message);
		}
		
		panelContainArtists.add(panelPictures, BorderLayout.CENTER);
		
		
		jspArtists = new JScrollPane();
		jspArtists.setBackground(new Color(0, 0, 0, 0));
		jspArtists.getViewport().setOpaque(false);
		jspArtists.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jspArtists.setViewportView(panelContainArtists);
		jspArtists.setPreferredSize(new Dimension(0, 400));
		add(jspArtists);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
		repaint();
	}
}