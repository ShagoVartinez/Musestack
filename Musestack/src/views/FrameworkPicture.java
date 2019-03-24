package views;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FrameworkPicture extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JLabel pictureLabel;

	public FrameworkPicture(String picture) {
		img = new ImageIcon(getClass().getResource("/img/marco.png")).getImage();
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		
		pictureLabel = new JLabel(new ImageIcon(getClass().getResource("/imgPictures/"+picture+"")), SwingConstants.CENTER);
		pictureLabel.setBorder(BorderFactory.createEmptyBorder(9, 0, 0, 0));
		add(pictureLabel);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 35, 0, this);
	}
}