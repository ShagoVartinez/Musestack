package views;

import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class DialogLoginAdministrator extends JDialog{
	private static final long serialVersionUID = 1L;
	private PanelLoginAdministrator panelLoginAdministrator;

	public DialogLoginAdministrator(ActionListener actionListener) {
		setModal(true);
		setResizable(false);
		setSize(300, 320);
		setLocationRelativeTo(null);
		setTitle("Login artist");
		
		panelLoginAdministrator = new PanelLoginAdministrator(actionListener);
		add(panelLoginAdministrator);		
	}
}