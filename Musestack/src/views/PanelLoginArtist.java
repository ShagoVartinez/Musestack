package views;

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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Actions;

public class PanelLoginArtist extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelLogin;
	private JPanel panelRegister;
	private JTextField ingressMail;
	private JPasswordField ingressPassword;
	private JButton buttonIngress;
	private JButton buttonRegister;

	public PanelLoginArtist(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/loginArtist.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		panelLogin = new JPanel();
		panelLogin.setOpaque(false);
		panelLogin.setPreferredSize(new Dimension(0, 180));

		JLabel title = new JLabel("Login", SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(200, 70));
		title.setFont(MusestackFonts.USER_WINDOW_TITLE_LABELS_FONT);
		title.setForeground(Color.decode("#FFFFFF"));
		panelLogin.add(title);

		ingressMail = new JTextField();
		ingressMail.setText("");
		ingressMail.setPreferredSize(new Dimension(210, 55));
		ingressMail.setBackground(Color.decode("#000000"));
		ingressMail.setForeground(Color.decode("#FFFFFF"));
		ingressMail.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 9, 7, 9),
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#595959")),
						"Correo electronico", TitledBorder.LEFT, TitledBorder.TOP, MusestackFonts.FOOTER_LABELS_FONT, MusestackColors.BORDER_TITLED_FOREGROUND_COLOR)));
		panelLogin.add(ingressMail);

		ingressPassword = new JPasswordField("*********");
		ingressPassword.setPreferredSize(new Dimension(210, 55));
		ingressPassword.setBackground(Color.decode("#000000"));
		ingressPassword.setForeground(Color.decode("#595959"));
		ingressPassword.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 9, 7, 9),
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#595959")),
						"Contraseña", TitledBorder.LEFT, TitledBorder.TOP, MusestackFonts.FOOTER_LABELS_FONT, MusestackColors.BORDER_TITLED_FOREGROUND_COLOR)));
		panelLogin.add(ingressPassword);

		buttonIngress = new RoundedButton(50);
		ButtonPreferences(buttonIngress, "Ingresar", 100, 50, new Color(255, 66, 116, 210), Color.decode("#000000"));
		buttonIngress.addActionListener(actionListener);
		buttonIngress.setActionCommand(Actions.PANEL_INITIAL_ARTIST.toString());
		panelLogin.add(buttonIngress);

		add(panelLogin);

		panelRegister = new JPanel();
		panelRegister.setOpaque(false);

		JLabel text = new JLabel("¿No estas registrado?", SwingConstants.CENTER);
		text.setPreferredSize(new Dimension(200, 50));
		text.setFont(MusestackFonts.USER_WINDOW_TEXT_LABELS_FONT);
		text.setForeground(Color.decode("#000000"));
		panelRegister.add(text);

		buttonRegister = new RoundedButton(50);
		ButtonPreferences(buttonRegister, "Registrarse", 120, 50, new Color(0, 0, 0, 210), Color.decode("#FF4274"));
		buttonRegister.addActionListener(actionListener);
		buttonRegister.setActionCommand(Actions.PANEL_USER_REGISTER.toString());
		panelRegister.add(buttonRegister);
		
		JSeparator js = new JSeparator(SwingConstants.HORIZONTAL);
		js.setPreferredSize(new Dimension(220, 0));
		panelRegister.add(js);
		
		add(panelRegister);
	}
	
	public void ButtonPreferences(JButton button, String text, int width, int height, Color background, Color foreground) {
		button.setText(text);
		button.setFocusable(false);
		button.setBorderPainted(false);
		button.setPreferredSize(new Dimension(width, height));
		button.setBackground(background);
		button.setForeground(foreground);
		button.setFont(new Font("Helvetica", Font.BOLD, 15));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}