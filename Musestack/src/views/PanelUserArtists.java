package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Actions;

public class PanelUserArtists extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	
	public PanelUserArtists(ActionListener actionListener) {
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
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
}