package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.UIManager;

import controller.Actions;

public class PanelMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelPlatforms;
	private int WIDTH, HEIGHT;
	private JButton buttonArtist;
	private JButton buttonUser;
	private JButton buttonAdministrator;
	private JPanel panelDown;
	private JPanel panelInfo;
	private JPanel panelCopyRight;
	private JLabel copyRightText;
	private JPanel panelContacts;
	private JButton buttonInfo;
	private JButton buttonFacebook;
	private JButton buttonTwitter;
	private JButton buttonInstagram;
	private JButton buttonWhatsapp;
	private JButton buttonMail;

	public PanelMainWindow(int width, int height, ActionListener actionListener) {
		this.WIDTH = width;
		this.HEIGHT = height;
		img = new ImageIcon(getClass().getResource("/img/MusestackImage.jpg")).getImage();
		setLayout(new BorderLayout());
		
		InitComponents(actionListener);
	}
	
	public void InitComponents(ActionListener actionListener) {
		JPanel panelUp = new JPanel();
		panelUp.setOpaque(false);
		panelUp.setPreferredSize(new Dimension(0, (int)(HEIGHT*20/100)));
		add(panelUp, BorderLayout.PAGE_START);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setOpaque(false);
		panelLeft.setPreferredSize(new Dimension((int)(WIDTH*20/100), 0));
		add(panelLeft, BorderLayout.LINE_START);
		
		panelPlatforms(actionListener);
		
		JPanel panelRight = new JPanel();
		panelRight.setOpaque(false);
		panelRight.setPreferredSize(new Dimension((int)(WIDTH*20/100), 0));
		add(panelRight, BorderLayout.LINE_END);
		
		panelDown = new JPanel();
		panelDown.setOpaque(false);
		panelDown.setPreferredSize(new Dimension(0, (int)(HEIGHT*30/100)));
		panelDown.setLayout(new BoxLayout(panelDown, BoxLayout.Y_AXIS));
		
		JPanel panelSpace = new JPanel();
		panelSpace.setOpaque(false);
		panelSpace.setPreferredSize(new Dimension(0, (int)(HEIGHT*20/100)));
		panelDown.add(panelSpace);
		
		footerPanel();
		
		add(panelDown, BorderLayout.PAGE_END);
	}
	
	public void panelPlatforms(ActionListener actionListener) {
		panelPlatforms = new RoundedPanel(70);
		panelPlatforms.setBackground(MusestackColors.PANEL_PLATAFORMS_COLOR);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap((int)(WIDTH*5/100));
		layout.setVgap((int)(HEIGHT*10/100));
		panelPlatforms.setLayout(layout);
		
		buttonArtist = new RoundedButton(150);
		buttonPreferences(buttonArtist, "Artista", "/img/artist.png");
		buttonArtist.addActionListener(actionListener);
		buttonArtist.setActionCommand(Actions.PLATFORM_ARTIST.toString());
		panelPlatforms.add(buttonArtist);
		
		buttonUser = new RoundedButton(150);
		buttonPreferences(buttonUser, "Usuario", "/img/user.png");
		buttonUser.addActionListener(actionListener);
		buttonUser.setActionCommand(Actions.PLATFORM_USER.toString());
		panelPlatforms.add(buttonUser);
		
		buttonAdministrator = new RoundedButton(150);
		buttonPreferences(buttonAdministrator, "Administrador", "/img/administrator.png");
		buttonAdministrator.addActionListener(actionListener);
		buttonAdministrator.setActionCommand(Actions.PLATFORM_ADMINISTRATOR.toString());
		panelPlatforms.add(buttonAdministrator);
		
		add(panelPlatforms, BorderLayout.CENTER);
	}
	
	public void footerPanel() {
		UIManager.put("ToolTip.background", Color.decode("#595959"));
		UIManager.put("ToolTip.foreground", Color.decode("#FFFFFF"));
		UIManager.put("ToolTip.border", BorderFactory.createLineBorder(Color.decode("#FFFFFF")));
		
		panelInfo = new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.X_AXIS));
		panelInfo.setBackground(MusestackColors.FOOTER_COLOR);
		panelInfo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		panelCopyRight = new JPanel();
		panelCopyRight.setOpaque(false);

		copyRightText = new JLabel("© Musestack 2019");
		copyRightText.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		copyRightText.setFont(MusestackFonts.FOOTER_LABELS_FONT);
		panelCopyRight.add(copyRightText);

		panelInfo.add(panelCopyRight);

		panelContacts = new JPanel();
		panelContacts.setOpaque(false);
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		panelContacts.setLayout(layout);

		buttonInfo = new JButton("Información");
		buttonInfo.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		preferencesFooterButtons(buttonInfo, "<html>Want to know more<br></br>about our products and<br></br>supportofferings or just<br></br>have a question?</html>");
		buttonInfo.setFont(MusestackFonts.FOOTER_BUTTONS_FONT);
		panelContacts.add(buttonInfo);
		
		buttonFacebook = new JButton(new ImageIcon(getClass().getResource("/img/facebook.png")));
		preferencesFooterButtons(buttonFacebook, "MusestackX");
		panelContacts.add(buttonFacebook);

		buttonTwitter = new JButton(new ImageIcon(getClass().getResource("/img/twitter.png")));
		preferencesFooterButtons(buttonTwitter, "@MusestackX");
		panelContacts.add(buttonTwitter);
		
		buttonInstagram = new JButton(new ImageIcon(getClass().getResource("/img/instagram.png")));
		preferencesFooterButtons(buttonInstagram, "@MusestackX");
		panelContacts.add(buttonInstagram);

		buttonWhatsapp = new JButton(new ImageIcon(getClass().getResource("/img/whatsapp.png")));
		preferencesFooterButtons(buttonWhatsapp, "3228823147");
		panelContacts.add(buttonWhatsapp);

		buttonMail = new JButton(new ImageIcon(getClass().getResource("/img/mail.png")));
		preferencesFooterButtons(buttonMail, "musestack@mymail.com");
		panelContacts.add(buttonMail);

		panelInfo.add(panelContacts);


		panelDown.add(panelInfo, BorderLayout.PAGE_END);
	}
	
	public void buttonPreferences(JButton button, String text, String icon) {
		button.setText(text);
		button.setIcon(new ImageIcon(getClass().getResource(icon)));
		button.setFocusable(false);
		button.setBackground(MusestackColors.BUTTON_PLATAFORMS_COLOR);
		button.setFont(MusestackFonts.FOOTER_BUTTONS_FONT);
		button.setForeground(MusestackColors.MAIN_WINDOW_BUTTONS_FOREGROUND_COLOR);
		button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
	}
	
	public void preferencesFooterButtons(JButton button, String text) {
		button.setFocusPainted(false);
		button.setBackground(MusestackColors.FOOTER_COLOR);
		button.setToolTipText(text);		
		button.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}