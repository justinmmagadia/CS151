package fe;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class CarIconTester extends JPanel {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		CarShape car = new CarShape(400, 400, 50);
		CarIcon icon = new CarIcon(car);
		JLabel the = new JLabel(icon);
		the.setPreferredSize(new Dimension(1000,1000));
		
		frame.add(the);
		JButton zoomIn = new JButton("Zoom In");
		JButton zoomOut = new JButton("Zoom Out");
		
		zoomIn.addActionListener(event -> car.zoomIn());
		zoomIn.addActionListener(event -> the.repaint());
		
		zoomOut.addActionListener(event -> car.zoomOut());
		zoomOut.addActionListener(event -> the.repaint());
		
		frame.add(zoomOut);
		frame.add(zoomIn);
		
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
