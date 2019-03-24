package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Actions;

public class PanelInitialUser extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelMenu;
	private JButton buttonEvents;
	private JButton buttonArtists;
	private JButton buttonPictures;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelFooter;
	private JButton buttonInfo;
	private JButton buttonTopCalifications;
	
	public PanelInitialUser(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
		panelMenu(actionListener);
		panelFooter(actionListener);
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
	
	public void panelMenu(ActionListener actionListener) {
		panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		panelMenu.setPreferredSize(new Dimension(0, 480));
		panelMenu.setLayout(new FlowLayout(FlowLayout.LEADING, 60, 20));
		panelMenu.setBorder(BorderFactory.createEmptyBorder(0, -20, 0, 0));
		
		buttonEvents = new JButton();
		preferncesButtons(buttonEvents, "Eventos");
		buttonEvents.addActionListener(actionListener);
		buttonEvents.setActionCommand(Actions.PANEL_USER_EVENTS.toString());
		panelMenu.add(buttonEvents);
		
		buttonArtists = new JButton();
		preferncesButtons(buttonArtists, "Artistas");
		buttonArtists.addActionListener(actionListener);
		buttonArtists.setActionCommand(Actions.PANEL_USER_ARTISTS.toString());
		panelMenu.add(buttonArtists);
		
		buttonPictures = new JButton();
		preferncesButtons(buttonPictures, "Obras");
		buttonPictures.addActionListener(actionListener);
		buttonPictures.setActionCommand(Actions.PANEL_USER_PICTURES.toString());
		panelMenu.add(buttonPictures);
		
		buttonTopCalifications = new JButton();
		preferncesButtons(buttonTopCalifications, "Top calificaciones");
		buttonTopCalifications.addActionListener(actionListener);
		buttonTopCalifications.setActionCommand(Actions.PANEL_TOP_CALIFICATIONS.toString());
		panelMenu.add(buttonTopCalifications);
		
		add(panelMenu);
	}
	
	public void panelFooter(ActionListener actionListener) {
		panelFooter = new JPanel();
		panelFooter.setLayout(new BorderLayout());
		panelFooter.setBackground(Color.decode("#000000"));
		panelFooter.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 7));
		
		JLabel copyRyght = new JLabel("© Musestack 2019");
		panelFooter.add(copyRyght, BorderLayout.LINE_START);
		
		buttonInfo = new JButton();
		buttonInfo.setText("Información");
		buttonInfo.setFocusable(false);
		buttonInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#595959")),
				BorderFactory.createEmptyBorder(3, 5, 3, 5)));
		buttonInfo.setBackground(Color.decode("#000000"));
		buttonInfo.addActionListener(actionListener);
		buttonInfo.setActionCommand(Actions.PANEL_USER_INFO.toString());
		panelFooter.add(buttonInfo, BorderLayout.LINE_END);
		
		
		add(panelFooter);
	}
	
	public void preferncesButtons(JButton button, String text) {
		button.setText(text);
		button.setIcon(new ImageIcon(getClass().getResource("/img/vineta.png")));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setVerticalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.decode("#FFFFFF"));
		button.setFont(new Font("Helvetica", Font.PLAIN, 20));
		button.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}