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
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import controller.Actions;

public class PanelTopCalifications extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelTopCalifications;
	private JScrollPane jspTopCalifications;
	private JPanel panelTopArtists;
	private JPanel panelTopPictures;
	private JPanel panelArtists;
	private JPanel panelArtistTop;
	private JPanel panelPicturesTop;
	private JPanel panelPictures;
	private JPanel panelTitleTP;
	private JPanel panelTitleTA;
	
	public PanelTopCalifications(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
		panelTopCalifications();
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
	
	public void panelTopCalifications() {
		panelTopCalifications = new JPanel();
		panelTopCalifications.setOpaque(false);
		panelTopCalifications.setBorder(BorderFactory.createEmptyBorder(0, 0, 186, 0));
		panelTopCalifications.setLayout(new BorderLayout(0, 50));
		
		panelTopArtists = new JPanel();
		panelTopArtists.setOpaque(false);
		panelTopArtists.setLayout(new BoxLayout(panelTopArtists, BoxLayout.Y_AXIS));
		
		panelTitleTA = new JPanel();
		panelTitleTA.setOpaque(false);
		
		JLabel titleTA = new JLabel("Top 5 Artistas mejor calificados", SwingConstants.CENTER);
		titleTA.setForeground(Color.decode("#FFFFFF"));
		titleTA.setFont(new Font("Helvetica", Font.BOLD, 17));
		panelTitleTA.add(titleTA);
		
		panelTopArtists.add(panelTitleTA);
		
		panelArtists = new JPanel();
		panelArtists.setOpaque(false);
		int maxArtists = 5;
		if (maxArtists > 0) {
			panelArtists.setLayout(new GridLayout(maxArtists, 1, 0, 10));
			panelArtists.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			for (int i = 0; i < maxArtists; i++) {
				panelArtistTop = new JPanel();
				panelArtistTop.setBackground(Color.decode("#000000"));
				panelArtistTop.setLayout(new BoxLayout(panelArtistTop, BoxLayout.Y_AXIS));
				panelArtistTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
				
				JLabel numberArtist = new JLabel("#"+(i+1));
				numberArtist.setForeground(Color.decode("#FFFFFF"));
				numberArtist.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelArtistTop.add(numberArtist);
				
				JLabel nameArtist = new JLabel("Nombre: "+"Edvard Munch");
				nameArtist.setForeground(Color.decode("#FFFFFF"));
				nameArtist.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelArtistTop.add(nameArtist);
				
				JLabel cityArtist = new JLabel("Ciudad: "+"Tunja");
				cityArtist.setForeground(Color.decode("#FFFFFF"));
				cityArtist.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelArtistTop.add(cityArtist);
				
				JLabel calificationArtist = new JLabel("Calificacion: "+(70-(i*10))+"%");
				calificationArtist.setForeground(Color.decode("#FFFFFF"));
				calificationArtist.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelArtistTop.add(calificationArtist);
				
				JProgressBar qualify = new JProgressBar();
				qualify.setBackground(Color.decode("#595959"));
				qualify.setForeground(Color.decode("#FFF34C"));
				qualify.setMaximum(100);
				qualify.setValue(70-(i*10));
				qualify.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF")));
				panelArtistTop.add(qualify);
				
				panelArtists.add(panelArtistTop);
			}
		} else {
			panelArtists.setLayout(new GridLayout(1, 1, 30, 30));
			panelArtists.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			JLabel message = new JLabel("<html><center>No hay artistas calificados<br></br</center><html>", SwingConstants.CENTER);
			message.setFont(new Font("Helvetica", Font.BOLD, 17));
			message.setForeground(Color.decode("#000000"));
			panelArtists.add(message);
		}
		panelTopArtists.add(panelArtists);
		
		panelTopCalifications.add(panelTopArtists, BorderLayout.PAGE_START);
		
		panelTopPictures = new JPanel();
		panelTopPictures.setOpaque(false);
		panelTopPictures.setLayout(new BoxLayout(panelTopPictures, BoxLayout.Y_AXIS));
		
		panelTitleTP = new JPanel();
		panelTitleTP.setOpaque(false);
		
		JLabel titleTP = new JLabel("Top 5 Pinturas mejor calificadas", SwingConstants.CENTER);
		titleTP.setForeground(Color.decode("#FFFFFF"));
		titleTP.setFont(new Font("Helvetica", Font.BOLD, 17));
		panelTitleTP.add(titleTP);
		
		panelTopPictures.add(panelTitleTP);
		
		panelPictures = new JPanel();
		panelPictures.setOpaque(false);
		int maxPictures = 5;
		if (maxPictures > 0) {
			panelPictures.setLayout(new GridLayout(maxPictures, 1, 0, 10));
			panelPictures.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			for (int i = 0; i < maxPictures; i++) {
				panelPicturesTop = new JPanel();
				panelPicturesTop.setBackground(Color.decode("#000000"));
				panelPicturesTop.setLayout(new BoxLayout(panelPicturesTop, BoxLayout.Y_AXIS));
				panelPicturesTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
				
				JLabel numberPicture = new JLabel("#"+(i+1));
				numberPicture.setForeground(Color.decode("#FFFFFF"));
				numberPicture.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelPicturesTop.add(numberPicture);
				
				JLabel namePicture = new JLabel("Nombre: "+"El grito");
				namePicture.setForeground(Color.decode("#FFFFFF"));
				namePicture.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelPicturesTop.add(namePicture);
				
				JLabel authorPicture = new JLabel("Autor: "+"Edvard Munch");
				authorPicture.setForeground(Color.decode("#FFFFFF"));
				authorPicture.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelPicturesTop.add(authorPicture);
				
				JLabel calificationPicture = new JLabel("Calificacion: "+(80-(i*10))+"%");
				calificationPicture.setForeground(Color.decode("#FFFFFF"));
				calificationPicture.setFont(new Font("Helvetica", Font.PLAIN, 15));
				panelPicturesTop.add(calificationPicture);
				
				JProgressBar qualify = new JProgressBar();
				qualify.setBackground(Color.decode("#595959"));
				qualify.setForeground(Color.decode("#FFF34C"));
				qualify.setMaximum(100);
				qualify.setValue(80-(i*10));
				qualify.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF")));
				panelPicturesTop.add(qualify);
				
				panelPictures.add(panelPicturesTop);
			}
		} else {
			panelPictures.setLayout(new GridLayout(1, 1, 30, 30));
			panelPictures.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			JLabel message = new JLabel("<html><center>No hay pinturas calificadas<br></br><html>", SwingConstants.CENTER);
			message.setFont(new Font("Helvetica", Font.BOLD, 17));
			message.setForeground(Color.decode("#000000"));
			panelPictures.add(message);
		}
		panelTopPictures.add(panelPictures);
		
		panelTopCalifications.add(panelTopPictures, BorderLayout.CENTER);
		
		jspTopCalifications = new JScrollPane();
		jspTopCalifications.setBackground(new Color(0, 0, 0, 0));
		jspTopCalifications.getViewport().setOpaque(false);
		jspTopCalifications.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jspTopCalifications.setViewportView(panelTopCalifications);
		add(jspTopCalifications);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
		repaint();
	}
}