package views;

import java.awt.Graphics;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private int size;
	
    public RoundedPanel(int size) {
    	super();
    	this.size = size;
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), size, size);
        super.paintComponent(g);
    }
}