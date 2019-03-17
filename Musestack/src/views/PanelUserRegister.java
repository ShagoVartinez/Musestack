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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Actions;

public class PanelUserRegister extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private JPanel panelRegisterSpaces;
	private JTextField ingressId;
	private JPanel panelSelectPhoto;
	private JButton selectPhoto;
	private JTextField ingressfirstName;
	private JTextField ingresslastName;
	private JTextField ingressPhone;
	private JTextField ingressCity;
	private JTextField ingressEmail;
	private JPasswordField ingressPassword;
	private RoundedButton buttonRegister;
	private JButton buttonBack;
	
	public PanelUserRegister(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserRegister(actionListener);
		panelRegisterSpaces(actionListener);
	}
	
	public void headerUserRegister(ActionListener actionListener) {
		panelHeader = new JPanel();
		panelHeader.setOpaque(false);
		panelHeader.setLayout(new BorderLayout());
		panelHeader.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 9));
		
		JLabel title = new JLabel("Crear usuario", SwingConstants.CENTER);
		title.setFont(MusestackFonts.USER_WINDOW_TITLE_LABELS_FONT);
		title.setForeground(Color.decode("#FFFFFF"));
		panelHeader.add(title, BorderLayout.CENTER);
		
		buttonBack = new JButton();
		buttonBack.setIcon(new ImageIcon(getClass().getResource("/img/back.png")));;
		buttonBack.setFocusable(false);
		buttonBack.setContentAreaFilled(false);
		buttonBack.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		buttonBack.addActionListener(actionListener);
		buttonBack.setActionCommand(Actions.PANEL_LOGIN_USER.toString());
		panelHeader.add(buttonBack, BorderLayout.LINE_END);
		
		add(panelHeader);
	}
	
	public void panelRegisterSpaces(ActionListener actionListener){
		panelRegisterSpaces = new JPanel();
		panelRegisterSpaces.setOpaque(false);
		panelRegisterSpaces.setPreferredSize(new Dimension(0, 400));
		
		ingressId = new JTextField();
		preferencesTextField(ingressId, "No. Identificacion");
		panelRegisterSpaces.add(ingressId);
		
		panelSelectPhoto = new JPanel();
		panelSelectPhoto.setOpaque(false);
		panelSelectPhoto.setBorder(BorderFactory.createEmptyBorder(-5, 50, -5, 50));
		
		selectPhoto = new JButton("Foto", new ImageIcon(getClass().getResource("/imgUsers/user.png")));
		selectPhoto.setFocusable(false);
		selectPhoto.setBackground(Color.decode("#FFF34C"));
		selectPhoto.setFont(new Font("Helvetiva", Font.PLAIN, 15));
		selectPhoto.setForeground(Color.decode("#000000"));
		selectPhoto.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 3),
				BorderFactory.createEmptyBorder(3, 3, 0, 3)));
		selectPhoto.setHorizontalTextPosition(SwingConstants.CENTER);
		selectPhoto.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSelectPhoto.add(selectPhoto);
		
		panelRegisterSpaces.add(panelSelectPhoto);
		
		ingressfirstName = new JTextField();
		preferencesTextField(ingressfirstName, "Nombre");
		panelRegisterSpaces.add(ingressfirstName);
		
		ingresslastName = new JTextField();
		preferencesTextField(ingresslastName, "Apellido");
		panelRegisterSpaces.add(ingresslastName);
		
		ingressPhone = new JTextField();
		preferencesTextField(ingressPhone, "Telefono");
		panelRegisterSpaces.add(ingressPhone);
		
		ingressCity = new JTextField();
		preferencesTextField(ingressCity, "Ciudad");
		panelRegisterSpaces.add(ingressCity);
		
		ingressEmail = new JTextField();
		preferencesTextField(ingressEmail, "Email");
		panelRegisterSpaces.add(ingressEmail);
		
		ingressPassword = new JPasswordField("*********");
		ingressPassword.setPreferredSize(new Dimension(210, 45));
		ingressPassword.setBackground(Color.decode("#000000"));
		ingressPassword.setForeground(Color.decode("#595959"));
		ingressPassword.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3),
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#595959")),
						"Contraseña", TitledBorder.LEFT, TitledBorder.TOP, MusestackFonts.FOOTER_LABELS_FONT, MusestackColors.BORDER_TITLED_FOREGROUND_COLOR)));
		panelRegisterSpaces.add(ingressPassword);
		
		buttonRegister = new RoundedButton(45);
		buttonRegister.setText("Crear");
		buttonRegister.setFocusable(false);
		buttonRegister.setBorderPainted(false);
		buttonRegister.setPreferredSize(new Dimension(100, 45));
		buttonRegister.setBackground(Color.decode("#FFF34C"));
		buttonRegister.setForeground(Color.decode("#000000"));
		buttonRegister.setFont(new Font("Helvetica", Font.BOLD, 15));
//		buttonIngress.addActionListener(actionListener);
//		buttonIngress.setActionCommand(Actions.PANEL_INITIAL_USER.toString());
		panelRegisterSpaces.add(buttonRegister);
		
		add(panelRegisterSpaces);
	}
	
	public void preferencesTextField(JTextField textField, String text) {
		textField.setText(text);
		textField.setPreferredSize(new Dimension(210, 30));
		textField.setBackground(Color.decode("#000000"));
		textField.setForeground(Color.decode("#595959"));
		textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5),
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#595959")),
						BorderFactory.createEmptyBorder(5, 5, 5, 2))));
		textField.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
	}
}