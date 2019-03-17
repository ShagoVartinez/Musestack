package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MusestackWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelActual;
	private PanelMainWindow panelMainWindow;
	
	public MusestackWindow(ActionListener actionListener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(1300, 700));
//		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_MUSESTACK_WINDOW));
		setTitle("Musestack");
		setIconImage(new ImageIcon(getClass().getResource("/img/MusestackIcon.png")).getImage());
		
		initComponents(actionListener);
		
		setVisible(true);
	}
	
	public void initComponents(ActionListener actionListener) {
		panelMainWindow = new PanelMainWindow(getWidth(), getHeight(), actionListener);
		add(panelMainWindow, BorderLayout.CENTER);
		panelActual = panelMainWindow;
	}
	
	public void changePanel(JPanel panel) {
		getContentPane().remove(panelActual);
		panelActual = panel;
		add(panelActual, BorderLayout.CENTER);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
	public void changeToInitialPanel() {
		changePanel(panelMainWindow);
	}
}