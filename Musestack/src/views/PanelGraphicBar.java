package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PanelGraphicBar extends JPanel{
	private static final long serialVersionUID = 1L;
	private static String[] xValues = {};
	private static double[] yValues = {};
	private static String xAxisName = "ESTRATO";
	private static String yAxisName = "PROMEDIO";
	private static int maxDivisions = 20;
	private static int xInitialXaxix, xFinalXaxix, yInitialXaxix, yFinalXaxix, xInitialYaxix, xFinalYaxix, yInitialYaxix,
	yFinalYaxix;

	public PanelGraphicBar(String[] xAxis, double[] yAxis) {
		xValues = xAxis;
		yValues = yAxis;
	}
	
	public PanelGraphicBar(ActionListener actionListener) {
	}
	
	public double maxValueYValues() {
		double maxValue = yValues[0];
		for (int i = 0; i < yValues.length; i++) {
			if (yValues[i] > maxValue) {
				maxValue = yValues[i];
			}
		}
		return maxValue;
	}
	
	public void updateValues() {
		xInitialXaxix = (int)((getWidth()/100)*10);
		xFinalXaxix = (int)((getWidth()/100)*90);
		yInitialXaxix = (int)((getHeight()/100)*90);
		yFinalXaxix = (int)((getHeight()/100)*90);
		
		xInitialYaxix = (int)((getWidth()/100)*10);
		xFinalYaxix = (int)((getWidth()/100)*10);
		yInitialYaxix = (int)((getHeight()/100)*10);
		yFinalYaxix = (int)((getHeight()/100)*90);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setStroke(new BasicStroke(2f));
		updateValues();
		drawGuideLines(graphics2d);
		drawXGuideLines(graphics2d);
		drawYGuideLines(graphics2d);
		drawFunction(graphics2d);
		drawXAxisName(graphics2d);
		drawYAxisName(graphics2d);
	}

	public void drawGuideLines(Graphics2D g) {
		g.setColor(Color.decode("#F8F8F8"));
		int xValuesPoligon[] = {xInitialXaxix, xFinalXaxix, xFinalXaxix, xInitialXaxix};
		int yValuesPoligon[] = {yInitialYaxix, yInitialYaxix, yFinalYaxix, yFinalYaxix};
		g.fillPolygon(xValuesPoligon, yValuesPoligon, 4);
		
		g.setColor(Color.decode("#EA4335"));
		g.drawLine(xInitialYaxix, yInitialYaxix, xFinalYaxix, yFinalYaxix);//y line
		g.drawLine(xInitialXaxix, yInitialXaxix, xFinalXaxix, yFinalXaxix);//x line
	}
	
	public void drawYAxisName(Graphics2D g) {
		g.setColor(Color.decode("#403F43"));
		g.drawString(yAxisName, xInitialYaxix-100, (int)((yFinalYaxix-yInitialYaxix)/2));
	}
	
	public void drawXAxisName(Graphics2D g) {
		g.setColor(Color.decode("#403F43"));
		g.drawString(xAxisName, (int)((xFinalXaxix-xInitialXaxix)/2)+50, yFinalXaxix+50);
	}

	public void drawXGuideLines(Graphics2D g) {
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setStroke(new BasicStroke(1f));
		
		for (int i = 1; i < xValues.length+1; i++) {
			g.setColor(Color.decode("#403F43"));
			int distance = (int)((xFinalXaxix-xInitialXaxix)/((xValues.length)+1));
			int xValue = (xInitialXaxix)+i*distance;
			g.drawLine(xValue, yInitialXaxix, xValue, yInitialXaxix+5);
			int size = (xValues[i-1].length())*3;
			g.drawString(""+(xValues[i-1]), xValue-size, yInitialXaxix+20);
			g.setColor(Color.decode("#CDCDCD"));
			g.drawLine(xValue, yInitialYaxix, xValue, yInitialXaxix);
		}
	}
	
	public void drawYGuideLines(Graphics g) {
		for (int i = 1; i < maxDivisions+1; i++) {
			g.setColor(Color.decode("#403F43"));
			int distance = (int)((yFinalYaxix-yInitialYaxix)/(maxDivisions));
			int yValue = yFinalYaxix-i*distance;
			g.drawLine(xInitialYaxix-5, yValue, xInitialYaxix, yValue);
			Double drawDoubleValue = i*(maxValueYValues()/maxDivisions);
			String sizeDraw = ""+drawDoubleValue.floatValue();
			int size = (sizeDraw.length())*8;
			g.drawString(""+drawDoubleValue.floatValue(), xInitialYaxix-size, yValue+5);

			g.setColor(Color.decode("#CDCDCD"));
			g.drawLine(xInitialYaxix, yValue, xFinalXaxix, yValue);
		}
	}
	
	public void drawFunction(Graphics2D g) {
		for (int i = 1; i < xValues.length; i++) {
			for (int j = 0; j < yValues.length; j++) {
				int distanceInX = (int)((xFinalXaxix-xInitialXaxix)/((xValues.length)+1));
				int pointInitialInX = xInitialXaxix+((i++)*distanceInX);
				double distanceInY = (yFinalYaxix-yInitialYaxix)/(maxValueYValues());
				int pointInitialInY = (int)(yFinalYaxix-(yValues[j]*distanceInY));					
				g.setColor(Color.decode("#31B8D6"));
				int pointsXPoligon[] = {pointInitialInX-5, pointInitialInX+5, pointInitialInX+5, pointInitialInX-5};
				int pointsYPoligon[] = {pointInitialInY, pointInitialInY, yFinalYaxix, yFinalYaxix};
				g.fillPolygon(pointsXPoligon, pointsYPoligon, 4);
			}
		}
	}
}