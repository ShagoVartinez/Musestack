package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardArtists extends JButton{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelArtist;
	private JLabel photoArtist;
	private JLabel nameArtist;
	private JLabel cityArtist;
	private JLabel phoneArtist;
	private JLabel emailArtist;
	private JPanel panelMainInfo;
	private JPanel panelPhoto;
	private JPanel panelInfo;
	private JPanel panelEmail;

	public CardArtists(String photo, String name, String city, String phone, String email) {
		img = new ImageIcon(getClass().getResource("/img/idCard.png")).getImage();
		this.setPreferredSize(new Dimension(0, 163));
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		
		panelArtist = new JPanel();
		panelArtist.setOpaque(false);
		panelArtist.setLayout(new BoxLayout(panelArtist, BoxLayout.Y_AXIS));
		panelArtist.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		panelMainInfo = new JPanel();
		panelMainInfo.setOpaque(false);
		panelMainInfo.setBorder(BorderFactory.createEmptyBorder(0, 0, -20, 0));
		
		panelPhoto = new JPanel();
		panelPhoto.setOpaque(false);
		panelPhoto.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		photoArtist = new JLabel();
		photoArtist.setIcon(new ImageIcon(getClass().getResource("/imgArtist/"+photo+"")));
		photoArtist.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		panelPhoto.add(photoArtist);
		
		panelMainInfo.add(panelPhoto);
		
		panelInfo = new JPanel();
		panelInfo.setOpaque(false);
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		panelInfo.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
		
		nameArtist = new JLabel();
		nameArtist.setText(name);
		panelInfo.add(nameArtist);
		
		cityArtist = new JLabel();
		cityArtist.setText(city);
		panelInfo.add(cityArtist);
		
		phoneArtist = new JLabel();
		phoneArtist.setText(phone);
		panelInfo.add(phoneArtist);
		
		panelMainInfo.add(panelInfo);
		
		panelArtist.add(panelMainInfo);
		
		panelEmail = new JPanel();
		panelEmail.setOpaque(false);
		panelEmail.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		emailArtist = new JLabel();
		emailArtist.setText(email);
		panelEmail.add(emailArtist);
		
		panelArtist.add(panelEmail);
		
		add(panelArtist);		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}
