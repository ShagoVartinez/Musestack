package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Actions;

public class PanelUserInfo extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelInfo;
	private JLabel textInfo;

	public PanelUserInfo(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
		panelInfo();
	}
	
	public void headerUserWindow(ActionListener actionListener) {
		panelHeader = new JPanel();
		panelHeader.setLayout(new BorderLayout());
		panelHeader.setBackground(Color.decode("#000000"));
		panelHeader.setBorder(BorderFactory.createEmptyBorder(7, 9, 7, 9));
		
		userPhoto = new RoundedButton(45);
		userPhoto.setAlignmentX(SwingConstants.LEFT);
		userPhoto.setFocusable(false);
		userPhoto.setBorderPainted(false);
		userPhoto.setPreferredSize(new Dimension(45, 45));
		userPhoto.setIcon(new ImageIcon(getClass().getResource("/imgUsers/user1.png")));
		userPhoto.setBackground(Color.decode("#FFF34C"));
		panelHeader.add(userPhoto, BorderLayout.LINE_START);
		
		nameUser = new JLabel("user1");
		nameUser.setForeground(Color.decode("#FFFFFF"));
		nameUser.setFont(new Font("Helvetica", Font.PLAIN, 15));
		nameUser.setBorder(BorderFactory.createEmptyBorder(3, 7, 3, 3));
		panelHeader.add(nameUser, BorderLayout.CENTER);
		
		buttonBack = new JButton();
		buttonBack.setIcon(new ImageIcon(getClass().getResource("/img/back.png")));;
		buttonBack.setFocusable(false);
		buttonBack.setContentAreaFilled(false);
		buttonBack.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		buttonBack.addActionListener(actionListener);
		buttonBack.setActionCommand(Actions.PANEL_INITIAL_USER.toString());
		panelHeader.add(buttonBack, BorderLayout.LINE_END);
		
		add(panelHeader);
	}
	
	public void panelInfo() {
		panelInfo = new JPanel();
		panelInfo.setOpaque(false);
//		panelInfo.setBorder(BorderFactory.createEmptyBorder(3, 5, 0, 0));;
		
		textInfo = new JLabel();
		textInfo.setText("<html>Musestack fue creada con el proposito<br></br>"
				+ "de promover el  talento de los artistas<br></br>"
				+ "del departamento X. En esta  aplicación<br></br>"
				+ "podra ver los eventos que se realizaran<br></br>"
				+ "en  las  proximas  fechas,  la lista de<br></br>"
				+ "artistas del  departamneto registrados,<br></br>"
				+ "asi como  sus respectivas obras, ademas<br></br>"
				+ " usted podra calificar  cada una de las<br></br>"
				+ "obras y dar una critica a estas, ya que<br></br>"
				+ "su  opinion es de  importancia para  el<br></br>"
				+ "artista.<br></br><br></br>"
				+ "Nos puede encontrar en redes sociales<br></br>"
				+ "Facebook: Musestack oficial<br></br>"
				+ "Twitter: @Musestack<br></br>"
				+ "Instagram: @Musestack<br></br>"
				+ "Whatsapp: 3228823147<br></br>"
				+ "MyMail: musestack@mymail.com</html>");
		textInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
		textInfo.setForeground(Color.decode("#000000"));
		panelInfo.add(textInfo);
		
		add(panelInfo);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
		repaint();
	}
}