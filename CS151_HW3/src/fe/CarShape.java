package fe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;


public class CarShape {

	private int x;
	private int y;
	private int width;
	

	public CarShape(int x2, int y2, int width2) 
	{
		x = x2;
		y = y2;
		width = width2;
	}



	



	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return width/2;
	}
	public void draw(Graphics2D g2)
	{
		Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3, width / 6, width / 6);
        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
        g2.fill(frontTire);
        g2.fill(rearTire);
        g2.setColor(Color.green);
        g2.fill(body);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
	}
	
	public void zoomIn()
	{
		width = width + 20;
	}
	public void zoomOut()
	{
		width = width - 20;
	}
}
