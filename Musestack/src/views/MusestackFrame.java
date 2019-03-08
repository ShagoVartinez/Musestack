package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controllers.MainController;

public class MusestackFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MusestackFrame(MainController controller) {
		setTitle("Muse'stack");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
//		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setJMenuBar(new MainBar(controller));
		
		JPanel mainPnl = new JPanel();
		mainPnl.setLayout(new BorderLayout());
		mainPnl.setBackground(Color.decode("#3367d6"));		
		add(mainPnl);
		
		setVisible(true);
	}

}
