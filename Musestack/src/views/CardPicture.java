package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Actions;

public class CardPicture extends JPanel{
	private static final long serialVersionUID = -113374222813622412L;
	private FrameworkPicture frameworkPicture;
	private JPanel panelInfo;
	private JLabel namePicture;
	private JLabel authorPicture;
	private JLabel sizePicture;
	private JLabel yearPicture;
	private JLabel statePicture;
	private JLabel genrePicture;
	private JButton buttonQualify;
	private JPanel panelButton;

	public CardPicture(ActionListener actionListener, String picture, String name, String author, String size, String year, String genre, String state) {
		this.setLayout(new BorderLayout());
		initComponents(actionListener, picture, name, author, size, year, genre, state);
	}
	
	public void initComponents(ActionListener actionListener, String picture, String name, String author, String size, String year, String genre, String state) {
		frameworkPicture = new FrameworkPicture(picture);
		add(frameworkPicture, BorderLayout.PAGE_START);
		
		panelInfo = new JPanel();
		panelInfo.setBackground(Color.decode("#000000"));
		panelInfo.setLayout(new GridLayout(6, 1, 0, 5));
		
		namePicture = new JLabel(name, SwingConstants.CENTER);
		labelPreferences(namePicture);
		panelInfo.add(namePicture);
		
		authorPicture = new JLabel("Autor: "+author, SwingConstants.CENTER);
		labelPreferences(authorPicture);
		panelInfo.add(authorPicture);
		
		sizePicture = new JLabel("Tamaño: "+size, SwingConstants.CENTER);
		labelPreferences(sizePicture);
		panelInfo.add(sizePicture);
		
		yearPicture = new JLabel("Año: "+year, SwingConstants.CENTER);
		labelPreferences(yearPicture);
		panelInfo.add(yearPicture);
		
		genrePicture = new JLabel("Genero: "+genre, SwingConstants.CENTER);
		labelPreferences(genrePicture);
		panelInfo.add(genrePicture);
		
		statePicture = new JLabel("Estado: "+state, SwingConstants.CENTER);
		labelPreferences(statePicture);
		panelInfo.add(statePicture);
		
		add(panelInfo, BorderLayout.CENTER);
		
		panelButton = new JPanel();
		panelButton.setBackground(Color.decode("#000000"));
		
		buttonQualify = new RoundedButton(30);
		buttonQualify.setFocusable(false);
		buttonQualify.setBorderPainted(false);
		buttonQualify.setPreferredSize(new Dimension(100, 30));
		buttonQualify.setText("Calificar");
		buttonQualify.setBackground(Color.decode("#FFF34C"));
		buttonQualify.setForeground(Color.decode("#000000"));
		buttonQualify.setFont(new Font("Helvetica", Font.BOLD, 17));
		buttonQualify.addActionListener(actionListener);
		buttonQualify.setActionCommand(Actions.PANEL_CALIFICATION.toString());
		panelButton.add(buttonQualify);
		
		add(panelButton, BorderLayout.PAGE_END);
	}
	
	public void labelPreferences(JLabel label) {
		label.setForeground(Color.decode("#FFF34C"));
		label.setFont(new Font("Helvetica", Font.PLAIN, 15));
	}
}