package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelInitialArtist extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;

	public PanelInitialArtist(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/artistWallPaper.png")).getImage();
		
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}