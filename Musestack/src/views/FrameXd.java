package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FrameXd extends JFrame{
	
	public FrameXd() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		String[] genres = {
				"Abstraccionismo",
				"Cubismo",
				"Expresionismo"
		};
		
		double[] num = {1,2,3};
		System.out.println(num.length);

		System.out.println(genres.length);
		PanelGraphicBar graphic = new PanelGraphicBar(genres, num);
		add(graphic, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameXd();
	}
}