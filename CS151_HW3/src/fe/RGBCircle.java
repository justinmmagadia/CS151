package fe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RGBCircle extends JPanel
{
	private class BlueButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			theCircle.setColor(Color.blue);
			repaint();
		}
	}

	private class GreenButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			theCircle.setColor(Color.green);
			repaint();
		}
	}

private class RedButtonListener implements ActionListener 
{
	public void actionPerformed(ActionEvent event)
	{
		theCircle.setColor(Color.red);
		repaint();
	}
}

private JLabel changeColor;
private JButton red, green, blue;
private Circle theCircle;

public RGBCircle()
{
	theCircle = new Circle(150, Color.red, 150, 150);
	;
	changeColor = new JLabel("Change color to: ");
	red = new JButton("Red");
	red.addActionListener(new RedButtonListener());
	green = new JButton("Green");
	green.addActionListener(new GreenButtonListener());
	blue = new JButton("Blue");
	blue.addActionListener(new BlueButtonListener());
	
	add(changeColor);
	add(red);
	add(green);
	add(blue);
	
	setPreferredSize(new Dimension(500,500));
	setBackground(Color.white);
	
}

public void paintComponent(Graphics page)
{	super.paintComponent(page);
	page.setColor(Color.white);
	page.fillRect(500, 500, 500, 500);
	theCircle.draw(page);
}

public static void main(String[] args)
{
	JFrame frame = new JFrame("RGBCircle");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	RGBCircle circle = new RGBCircle();
	frame.getContentPane().add(circle);
	frame.pack();
	frame.setVisible(true);
}







//public void paintComponent(Graphics page)
//{
//	super.paintComponent(page);
//	page.setColor(Color.black);
	
//}


	
}

