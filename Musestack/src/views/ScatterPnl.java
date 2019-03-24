package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class ScatterPnl extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1950958586083430465L;

	int hlx1,hlx2,hly1,vlx1,vly2,vly1;
	
	int[] xPoints;
	
	int[] yPoints;
	
	String[] xVector, yVector, indicatorsVector;
	
	String string = "", title = "";
	
	boolean stringIndicators, barsBoolean = false;
	
	int xLineDivision, yLineDivision, divisionsNumberY, sectionsNumberY, sectionsNumberX, divisionsNumberX;
	
	public ScatterPnl (String[] xVector, String[] yVector, int divisionsNumberY, int divisionsNumberX, String title, boolean bool) {
		setSize(800,600);
		setBackground(Color.WHITE);
		setUpPoints();
		this.title = title;
		barsBoolean = bool;
		if(isStringVector(xVector)) {
			fillXpointsStringVector(xVector);
			this.divisionsNumberX = xVector.length;
			stringIndicators= true;
		}
		else {
		xPoints = xPixelPointsVector(xVector);
		this.divisionsNumberX = divisionsNumberX*biggestValueVector(xVector);
		}
		this.xVector = xVector;
		sectionsNumberX = divisionsNumberX;
		this.divisionsNumberY = divisionsNumberY*biggestValueVector(yVector);
		sectionsNumberY = divisionsNumberY;
		yPoints = yPixelPointsVector(yVector);
		this.yVector = yVector;
	}
	

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		setUpPoints();
		paintLines(g2);
		xLineDivision = calculateXLineDivision();
		yLineDivision = calculateYLineDivision();
		if(xPoints.length > 0 && yPoints.length > 0 ) {
			g2.setColor(Color.decode("#6F3E3E"));
			g2.setStroke(new BasicStroke(1));
			paintIndicatorLines(g2);
			paintSquareBackground(g2);
			paintIndicatorString(g2);
			paintTitle(g2);
				paintFunction(g2);
		}
	}
	
	public void paintTitle(Graphics2D g2) {
		int widthText = g2.getFontMetrics().stringWidth(title);
		g2.drawString(title, ((this.getWidth())/2) - widthText/2, vly2 - this.getHeight()/16);
	}
	
	public void paintIndicatorLines(Graphics2D g2) {
		for (int i = 0; i < divisionsNumberY; i++) {
			g2.drawLine(vlx1, vly1 - yLineDivision*(i+1), vlx1 - this.getHeight()/100, vly1 - yLineDivision*(i+1));
		}
		for (int j = 0; j < xPoints.length; j++) {
			g2.drawLine(hlx1 + xLineDivision*(j+1), hly1, hlx1 + xLineDivision*(j+1), hly1 + this.getHeight()/100);
		}
		
	}
	public void paintLines(Graphics2D g) {
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.RED);
		g.drawLine(hlx1, hly1, hlx2, hly1);
		g.drawLine(vlx1, vly1, vlx1, vly2);
		int[] xTrianglePointsX = {hlx2 + this.getHeight()/80,hlx2 + this.getHeight()/80,hlx2 + 2*(this.getHeight()/80)};
		int[] xTrianglePointsY = {hly1 - this.getHeight()/80, hly1 + this.getHeight()/80, hly1};
		int[] yTrianglePointsX = {vlx1 - this.getHeight()/80, vlx1 + this.getHeight()/80, vlx1};
		int[] yTrianglePointsY = {vly2 - this.getHeight()/80 , vly2 - this.getHeight()/80, vly2 - 2*this.getHeight()/80};
		g.drawLine(hlx2, hly1, hlx2 + this.getHeight()/80, hly1);
		g.drawLine(vlx1,vly2,vlx1,vly2 - this.getHeight()/80);
		g.fillPolygon(yTrianglePointsX, yTrianglePointsY, xTrianglePointsX.length);
		g.fillPolygon(xTrianglePointsX, xTrianglePointsY, yTrianglePointsX.length);
	}
	
	public void paintSquareBackground(Graphics2D g) {
		g.setStroke(new BasicStroke((float)0.001));
		g.setColor(Color.gray);
		for (int i = 0; i < divisionsNumberY; i++) {
			g.drawLine(vlx1, vly1 - yLineDivision*(i+1), hlx2, vly1 - yLineDivision*(i+1));
		}
		for (int j = 0; j < divisionsNumberX; j++) {			
			g.drawLine(hlx1 + xLineDivision*(j+1), hly1, hlx1 + xLineDivision*(j+1), vly2);
		}
	}

	public void paintIndicatorString(Graphics2D g2) {
		int textWidth =  0, textHeight = 0;
		generateIndicatorsVector(yVector);
		g2.setColor(Color.BLACK);
		double numberY = (double)(biggestValueVector(yVector))/(double)(divisionsNumberY);
		g2.setFont(new Font("Times New Roman", Font.ITALIC, this.getWidth()/100));
		for (int i = 0; i < divisionsNumberY; i++) {
			textWidth = g2.getFontMetrics().stringWidth(String.valueOf(numberY*(i+1)));
			g2.drawString(String.valueOf(numberY*(i+1)), vlx1 - textWidth - this.getHeight()/80, vly1 - yLineDivision*(i+1));
		}
		if(stringIndicators) {
			for (int i = 0; i < divisionsNumberX; i++) {
				textHeight = g2.getFontMetrics().getHeight();
				g2.drawString(xVector[i], hlx1 + xLineDivision*(i+1), hly1 + this.getHeight()/80 + textHeight);
			}
		}
		else {
			double numberX = (double)(biggestValueVector(xVector))/(double)(divisionsNumberX);
			for (int j = 0; j < divisionsNumberX; j++) {
				textHeight = g2.getFontMetrics().getHeight();
				g2.drawString(String.valueOf(numberX*(j+1)), hlx1 + xLineDivision*(j+1), hly1 + (int)numberX + this.getHeight()/80 + textHeight);
			}
		}
	}
	
	public void paintFunction(Graphics2D g2) {
		g2.setColor(Color.decode("#D01212"));
		g2.setStroke(new BasicStroke((float)2));
		if(stringIndicators) {
			xPoints = xPixelPointsVectorString(xVector);
		}
		else {
			xPoints = xPixelPointsVector(xVector);
		}
		yPoints = yPixelPointsVector(yVector);
		for (int i = 0; i < xPoints.length; i++) {
			g2.drawPolyline(xPoints, yPoints, xPoints.length);
		}
	}
	
	public void paintPoints(Graphics2D g2) {
		g2.setColor(Color.green);
		for (int i = 0; i < xPoints.length; i++) {
			g2.fillOval(getXCoordinatePoint(xPoints[i]) - this.getHeight()/160, getYCoordinatePoint(yPoints[i]) - this.getHeight()/160, this.getHeight()/80, this.getHeight()/80);
		}
	}
	

	

	
	public void fillXpointsStringVector(String[] xVector) {
		xPoints = new int[xVector.length];
		for (int i = 0; i < xVector.length; i++) {
			xPoints[i] = i;
		}
	}
	
	public boolean isStringVector(String[] vector) {
		boolean bool = false;
		for (int i = 0; i < vector.length; i++) {
			if(invalidStringNumber(vector[i]))
				bool = true;
		}
		return bool;
	}
	
	public int[] xPixelPointsVector(String[] valuesVector) {
		int[] xPixelVector = new int[valuesVector.length];
		for (int i = 0; i < valuesVector.length; i++) {
			if(dataIsFloat(valuesVector[i])) {
				xPixelVector[i] = hlx1 + sectionsNumberX*beforeComaNumber(valuesVector[i])*xLineDivision + (int)(sectionsNumberX*xLineDivision*(afterComaNumber(valuesVector[i])));
			}
			else {
				xPixelVector[i] = hlx1 + Integer.valueOf(valuesVector[i])*sectionsNumberX*xLineDivision;
			}
		}
		return xPixelVector;
	}
	
	public int[] xPixelPointsVectorString(String[] valuesVector) {
		int[] xPixelVector = new int[valuesVector.length];
		for (int i = 0; i < valuesVector.length; i++) {
			xPixelVector[i] = hlx1 + (i+1)*xLineDivision;
		}
		return xPixelVector;
	}
	
	public int[] yPixelPointsVector(String[] valuesVector) {
		int[] yPixelVector = new int[valuesVector.length];
		for (int i = 0; i < valuesVector.length; i++) {
			if(dataIsFloat(valuesVector[i])) {
				yPixelVector[i] = vly1 - sectionsNumberY*beforeComaNumber(valuesVector[i])*yLineDivision - (int)(sectionsNumberY*yLineDivision*(afterComaNumber(valuesVector[i])));
			}
			else {
				yPixelVector[i] = vly1 - Integer.valueOf(valuesVector[i])*sectionsNumberY*yLineDivision;
			}
		}
		return yPixelVector;
	}
	
	public int biggestValueVector(String[] vector) {
		float value = 0;
		for (int i = 0; i < vector.length; i++) {
			if(Float.valueOf(vector[i]) > value)
				value = Float.valueOf(vector[i]);
		}
		if(dataIsFloat(String.valueOf(value))) {
			value = (int)value++;
		}
		return (int)value;
	}
	
	public double afterComaNumber(String string) {
		int comaPosition = 0;
		String stringNumber = "0.";
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == 46)
				comaPosition = i+1;
		}
		for (int i = comaPosition; i < string.length(); i++) {
			stringNumber += string.charAt(i);
		}
		return Double.valueOf(stringNumber);
	}
	
	public int beforeComaNumber(String string) {
		String stringNumber = "";
		int i = 0;
		while(string.charAt(i) != 46) {
			stringNumber += string.charAt(i);
			i++;
		}
		return Integer.valueOf(stringNumber);
	}
	
	public boolean dataIsFloat(String string) { 
		boolean bool = false;
		for (int i = 0; i < string.length() && !bool; i++) {
			if(string.charAt(i) == 46)
				bool = true;
		}
		return bool;
	}
	
	public boolean invalidStringNumber(String string) {
		boolean bool = false;
		int comaCounter = 0, alienCharCounter = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == 46)
				comaCounter++;
			if((string.charAt(i) < 48 || string.charAt(i) > 57) && string.charAt(i) != 46)
				alienCharCounter++;
		}
		if((comaCounter > 1 && string.charAt(string.length()-1) != 46) || alienCharCounter > 0)
			bool = true;
		return bool;
	} 
	
	public void setUpPoints() {
		hlx1 = this.getWidth() - 7*(this.getWidth()/8);
		hlx2 = this.getWidth() - this.getWidth()/8;
		hly1 = this.getHeight() - this.getHeight()/6;
		vlx1 = hlx1;
		vly1 = hly1;
		vly2 = this.getHeight() - 7*(this.getHeight()/8);
	}
	
	public int getXCoordinatePoint(int x) {
		return hlx1 + x*xLineDivision;
	}
	
	public int getYCoordinatePoint(int y) {
		return vly1 - y*yLineDivision;
	}
	
	public int calculateXLineDivision() {
		return (hlx2-hlx1)/divisionsNumberX;
	}
	
	public int calculateYLineDivision() {
		return (vly1-vly2)/divisionsNumberY;
	}
	
	
	public String[] insertionSortString(String[] vector) {
		String number1 = "";
		int counter = 0;
		for (int i = 0; i < vector.length-1; i++) {
			counter = i;
			for (int k = i+1; k > 0; k--) {
				if(Double.valueOf(vector[k]) < Double.valueOf(vector[counter])) {
					number1 = vector[counter];
					vector[counter] = vector[k];
					vector[k] = number1;
					counter--;
				}
				else
					k = 0;
			}
		}
		return vector;
	}
	
	public void generateIndicatorsVector(String[] vector) {
		indicatorsVector = new String[vector.length];
		for (int i = 0; i < vector.length; i++) {
			indicatorsVector[i] = vector[i];
		}
	}
}
