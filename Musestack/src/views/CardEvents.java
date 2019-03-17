package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardEvents extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JLabel nameEvent;
	private JLabel exhibithionPlace;
	private JLabel genre;
	private JLabel initialDate;
	private JLabel finalDate;
	private JLabel addressPlace;

	public CardEvents(String event, String gallery, String address, String genreEvent, String initialDateEvent, String finalDateEvent) {
		img = new ImageIcon(getClass().getResource("/img/fondoEvento.png")).getImage();
		this.setPreferredSize(new Dimension(200, 150));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(30, 3, 0, 0));
		
		nameEvent = new JLabel(event, SwingConstants.CENTER);
		nameEvent.setFont(new Font("Helvetiva", Font.BOLD, 15));
		add(nameEvent);
		
		exhibithionPlace = new JLabel("Galeria:  "+gallery, SwingConstants.LEFT);
		add(exhibithionPlace);
		
		addressPlace = new JLabel("Dirección:  "+address, SwingConstants.LEFT);
		add(addressPlace);
		
		genre = new JLabel("Genero:  "+genreEvent, SwingConstants.LEFT);
		add(genre);
		
		initialDate = new JLabel("Fecha de inicio:  "+initialDateEvent, SwingConstants.LEFT);
		add(initialDate);
		
		finalDate = new JLabel("Fecha de cierre:  "+finalDateEvent, SwingConstants.LEFT);
		add(finalDate);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}
