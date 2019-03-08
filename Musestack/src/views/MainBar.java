package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.Event;
import controllers.MainController;

public class MainBar extends JMenuBar{

	public MainBar(MainController controller) {
		
		JMenu file = new JMenu("file");
		
		JMenuItem readtest = new JMenuItem();
		readtest.addActionListener(controller);
		readtest.setActionCommand(Event.TEST.toString());
		file.add(readtest);
		
		add(file);
	}

	private static final long serialVersionUID = 1L;

}
