package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controller.Actions;

public class PanelUserArtists extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelContainArtists;
	private JPanel panelArtists;
	private JScrollPane jspArtists;
	private JPanel panelFilter;
	private JTextField searchSpace;
	private JButton buttonSearch;
	private JPanel panelText;
	private JPanel panelSearchSpace;
	private JPanel panel;
	
	public PanelUserArtists(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
		panelArtists(actionListener);
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
		buttonBack.setActionCommand(Actions.PANEL_INITIAL_USER.toString());
		panelHeader.add(buttonBack, BorderLayout.LINE_END);
		
		add(panelHeader);
	}
	
	public void panelArtists(ActionListener actionListener) {
		panelContainArtists = new JPanel();
		panelContainArtists.setOpaque(false);
		panelContainArtists.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Artistas", SwingConstants.CENTER);
		title.setFont(MusestackFonts.USER_WINDOW_TITLE_LABELS_FONT);
		title.setForeground(Color.decode("#FFFFFF"));
		title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		panelContainArtists.add(title, BorderLayout.PAGE_START);
		
		
		panelFilter = new JPanel();
		panelFilter.setOpaque(false);
		panelFilter.setBackground(Color.decode("#FFFFFF"));
		panelFilter.setLayout(new BoxLayout(panelFilter, BoxLayout.Y_AXIS));
		
		
		panelText = new JPanel();
		panelText.setOpaque(false);
		
		JLabel text = new JLabel("Filtrar por nombre", SwingConstants.CENTER);
		text.setForeground(Color.decode("#000000"));
		text.setFont(new Font("Helvetica", Font.BOLD, 15));
		panelText.add(text);
		
		panelFilter.add(panelText);
		
		panelSearchSpace = new JPanel();
		panelSearchSpace.setOpaque(false);
		panelSearchSpace.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		panel = new RoundedPanel(40, Color.decode("#595959"));
		panel.setPreferredSize(new Dimension(220, 45));
		panel.setBackground(Color.decode("#000000"));
		
		searchSpace = new JTextField("Nombre");
		searchSpace.setBackground(Color.decode("#000000"));
		searchSpace.setBorder(BorderFactory.createEmptyBorder());
		searchSpace.setForeground(Color.decode("#595959"));
		searchSpace.setPreferredSize(new Dimension(150, 30));
		searchSpace.setFont(new Font("Nunito Sans", Font.PLAIN, 16));
		searchSpace.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		panel.add(searchSpace);
		
		buttonSearch = new JButton(new ImageIcon(getClass().getResource("/img/search.png")));
		buttonSearch.setFocusable(false);
		buttonSearch.setBackground(Color.decode("#000001"));
		buttonSearch.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(buttonSearch);
		
		panelSearchSpace.add(panel);
		
		panelFilter.add(panelSearchSpace);
		
		panelContainArtists.add(panelFilter, BorderLayout.CENTER);
		
		panelArtists = new JPanel();
		panelArtists.setOpaque(false);
		int maxArtists = 5;
		if (maxArtists > 0) {
			panelArtists.setLayout(new GridLayout(maxArtists, 1, 0, 10));
			panelArtists.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			for (int i = 0; i < maxArtists; i++) {
				CardArtists ca = new CardArtists("man3.png", "Adolfo Hitler", "Berlin", "3214556666", "adolf.hitler@mymail.com");
				ca.setOpaque(false);
				ca.addActionListener(actionListener);
				ca.setActionCommand(Actions.PANEL_USER_ARTIST_PICTURE.toString());
				panelArtists.add(ca);
			}
		} else {
			panelArtists.setLayout(new GridLayout(3, 1, 30, 30));
			panelArtists.setBorder(BorderFactory.createEmptyBorder(20, 15, 0, 10));
			
			JLabel message = new JLabel("<html><center>No hay artistas que coincidan<br></br>con su busqueda</center><html>", SwingConstants.CENTER);
			message.setFont(new Font("Helvetica", Font.BOLD, 17));
			message.setForeground(Color.decode("#000000"));
			panelArtists.add(message);
		}
		
		panelContainArtists.add(panelArtists, BorderLayout.PAGE_END);
		
		
		jspArtists = new JScrollPane();
		jspArtists.setBackground(new Color(0, 0, 0, 0));
		jspArtists.getViewport().setOpaque(false);
		jspArtists.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jspArtists.setViewportView(panelContainArtists);
		jspArtists.setPreferredSize(new Dimension(0, 500));
		add(jspArtists);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
		repaint();
	}
}