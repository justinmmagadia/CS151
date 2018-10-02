package fe;

import javax.swing.*;

public class RGBCircleTester {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("RGBCircle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RGBCircle circle = new RGBCircle();
		
		frame.getContentPane().add(circle);
		frame.pack();
		frame.setVisible(true);
	}
}
