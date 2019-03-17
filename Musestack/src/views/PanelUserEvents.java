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

public class PanelUserEvents extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelContainEvents;
	private JScrollPane jspEvents;
	private JPanel panelEvents;
	
	public PanelUserEvents(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
		panelEvents();
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
	
	public void panelEvents() {
		panelContainEvents = new JPanel();
		panelContainEvents.setOpaque(false);
		panelContainEvents.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Eventos", SwingConstants.CENTER);
		title.setFont(MusestackFonts.USER_WINDOW_TITLE_LABELS_FONT);
		title.setForeground(Color.decode("#FFFFFF"));
		title.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		panelContainEvents.add(title, BorderLayout.PAGE_START);
		
		panelEvents = new JPanel();
		panelEvents.setOpaque(false);
		int maxEvents = 10;
		panelEvents.setLayout(new GridLayout(maxEvents, 1, 30, 30));
		panelEvents.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		
		for (int i = 0; i < maxEvents; i++) {
			CardEvents ce = new CardEvents("Evento X", "X", "Calle X No. X", "X", "xx/xx/xxxx", "xx/xx/xxxx");
			ce.setOpaque(false);
			panelEvents.add(ce);
		}
		
		panelContainEvents.add(panelEvents);
		
		
		jspEvents = new JScrollPane();
		jspEvents.setBackground(new Color(0, 0, 0, 0));
		jspEvents.getViewport().setOpaque(false);
		jspEvents.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jspEvents.setViewportView(panelContainEvents);
		add(jspEvents, BorderLayout.CENTER);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
		repaint();
	}
}