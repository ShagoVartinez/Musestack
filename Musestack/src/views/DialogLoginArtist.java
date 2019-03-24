package views;

import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class DialogLoginArtist extends JDialog{
	private static final long serialVersionUID = 1L;
	private PanelLoginArtist panelLoginArtist;

	public DialogLoginArtist(ActionListener actionListener) {
		setModal(true);
		setResizable(false);
		setSize(300, 480);
		setLocationRelativeTo(null);
		setTitle("Login artist");
		
		panelLoginArtist = new PanelLoginArtist(actionListener);
		add(panelLoginArtist);		
	}
}