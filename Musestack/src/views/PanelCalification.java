package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.Actions;

public class PanelCalification extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image img;
	private JPanel panelHeader;
	private RoundedButton userPhoto;
	private JLabel nameUser;
	private JButton buttonBack;
	private JPanel panelQualify;
	private JPanel panelStars;
	private JButton starOne;
	private JButton starTwo;
	private JButton starThree;
	private JButton starFour;
	private JButton starFive;
	private JPanel panelReview;
	private JTextArea review;
	private JScrollPane jspReview;
	private JPanel panelTextArea;
	private JButton buttonAcept;
	private JPanel panelButton;

	public PanelCalification(ActionListener actionListener) {
		img = new ImageIcon(getClass().getResource("/img/userWallpaper.png")).getImage();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		headerUserWindow(actionListener);
		panelCalification(actionListener);
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
	
	public void panelCalification(ActionListener actionListener) {
		panelQualify = new JPanel();
		panelQualify.setOpaque(false);
		panelQualify.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("El grito", SwingConstants.CENTER);
		title.setFont(new Font("Helvetica", Font.BOLD, 17));
		title.setForeground(Color.decode("#FFFFFF"));
		title.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		panelQualify.add(title, BorderLayout.PAGE_START);
		
		panelStars = new JPanel();
		panelStars.setOpaque(false);
		panelStars.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		panelStars.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
			
		starOne = new JButton();
		starOne.setText("1");
		buttonPreferences(starOne);
		panelStars.add(starOne);
		
		starTwo = new JButton();
		starTwo.setText("2");
		buttonPreferences(starTwo);
		panelStars.add(starTwo);
		
		starThree = new JButton();
		starThree.setText("3");
		buttonPreferences(starThree);
		panelStars.add(starThree);
		
		starFour = new JButton();
		starFour.setText("4");
		buttonPreferences(starFour);
		panelStars.add(starFour);
		
		starFive = new JButton();
		starFive.setText("5");
		buttonPreferences(starFive);
		panelStars.add(starFive);
		
		panelQualify.add(panelStars, BorderLayout.CENTER);
		
		
		panelReview = new JPanel();
		panelReview.setOpaque(false);
		panelReview.setLayout(new BorderLayout());
		
		JLabel text = new JLabel("<html><center>Tu opinion es muy importante.<br></br>Si tienes alguna critica sobre esta obra<br></br>redactala</center></html>", SwingConstants.CENTER);
		text.setFont(new Font("Helvetica", Font.BOLD, 15));
		text.setForeground(Color.decode("#000000"));
		panelReview.add(text,BorderLayout.PAGE_START);
		
		panelTextArea = new JPanel();
		panelTextArea.setOpaque(false);
		panelTextArea.setLayout(new BoxLayout(panelTextArea, BoxLayout.Y_AXIS));
		panelTextArea.setBorder(BorderFactory.createEmptyBorder(5, 20, 50, 20));
		
		review = new JTextArea();
		review.setBackground(Color.decode("#FFF34C"));
		review.setFont(new Font("Helvetica", Font.PLAIN, 17));
		review.setForeground(Color.decode("#000000"));
		jspReview = new JScrollPane();
		jspReview.setBackground(new Color(0, 0, 0, 0));
		jspReview.getViewport().setOpaque(false);
		jspReview.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 3));
		jspReview.setViewportView(review);
		jspReview.setPreferredSize(new Dimension(0, 100));
		panelTextArea.add(jspReview);
		
		panelButton = new JPanel();
		panelButton.setOpaque(false);
		panelButton.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		buttonAcept = new RoundedButton(40);
		buttonAcept.setText("Aceptar");
		buttonAcept.setFocusable(false);
		buttonAcept.setBorderPainted(false);
		buttonAcept.setPreferredSize(new Dimension(100, 40));
		buttonAcept.setBackground(Color.decode("#000000"));
		buttonAcept.setForeground(Color.decode("#FFF34C"));
		buttonAcept.setFont(new Font("Helvetica", Font.BOLD, 17));
		buttonAcept.addActionListener(actionListener);
		buttonAcept.setActionCommand(Actions.PANEL_USER_PICTURES.toString());
		panelButton.add(buttonAcept);
		
		panelTextArea.add(panelButton);
		
		panelReview.add(panelTextArea, BorderLayout.CENTER);
		
		panelQualify.add(panelReview, BorderLayout.PAGE_END);
		
		add(panelQualify);
	}
	
	public void buttonPreferences(JButton button) {
		button.setIcon(new ImageIcon(getClass().getResource("/img/starB.png")));
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setForeground(new Color(0, 0, 0, 0));
		button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, -10));
		starOne.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {	
			}
			@Override
			public void mouseExited(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int valueButton = Integer.parseInt(button.getText());
				for (int i = 1; i < valueButton; i++) {
					
				}
//				button.setIcon(new ImageIcon(getClass().getResource("/img/starA.png")));
//				starTwo.setIcon(new ImageIcon(getClass().getResource("/img/star 24.png")));
//				starThree.setIcon(new ImageIcon(getClass().getResource("/img/star 24.png")));
//				starFour.setIcon(new ImageIcon(getClass().getResource("/img/star 24.png")));
//				starFive.setIcon(new ImageIcon(getClass().getResource("/img/star 24.png")));
			}
		});
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMinimumSize(getParent().getSize());
		g.drawImage(img, 0, 0, this);
		repaint();
	}
}