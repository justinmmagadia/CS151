package fe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class CarIcon extends JLabel implements Icon
{
	
	private CarShape a;
	private JLabel zoom;
	public CarIcon(CarShape a)
	{
		this.a=a;
	}
	
	public int getIconWidth()
	{
		return a.getWidth();
	}
	
	public int getIconHeight()
	{
		return a.getHeight();
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		a.draw(g2);
	}
	
	
}