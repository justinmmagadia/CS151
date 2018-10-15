package graph;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BarFrame extends JFrame implements ChangeListener, MouseListener
{
	private ArrayList<Double> a;
	private DataModel theModel;
	
	private static final int ICON_WIDTH = 300;
	private static final int ICON_HEIGHT = 300;
	
	public BarFrame(DataModel dataModel)
	   {
	      theModel = dataModel;
	      a = theModel.getData();

	      setLocation(0,200);
	      setLayout(new BorderLayout());

	      addMouseListener(this); // adds the mouse listener in to the bar frame

	      Icon barIcon = new Icon()

	      {
	         public int getIconWidth() { return ICON_WIDTH; }
	         public int getIconHeight() { return ICON_HEIGHT; }

	         public void paintIcon(Component c, Graphics g, int x, int y)
	         {
	            Graphics2D g2 = (Graphics2D) g;

	            g2.setColor(Color.blue);

	            double max =  (a.get(0)).doubleValue();

	            for (Double v : a)
	            {
	               double val = v.doubleValue();
	               if (val > max)
	                  max = val;
	            }
	            double barHeight = getIconHeight() / a.size();

	            int i = 0;
	            for (Double v : a)
	            {
	               double value = v.doubleValue();

	               double barLength = getIconWidth() * value / max;
	               Rectangle2D.Double rectangle = new Rectangle2D.Double
	                  (0, barHeight * i, barLength, barHeight);
	               i++;
	               g2.fill(rectangle);
	            }
	         }
	      };

	      add(new JLabel(barIcon));

	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setVisible(true);
	   }

	   /**
	      Called when the data in the model is changed.
	      @param e the event representing the change
	   */
	   public void stateChanged(ChangeEvent e)
	   {
	      a = theModel.getData();
//	      for(Double d: a){
//	        System.out.println(d);
//	      }
	      repaint();
	   }


	@Override
	public void mouseClicked(MouseEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	    // TODO Auto-generated method stub

	    double max = (double) Collections.max(theModel.getData());
	    double value =  (double)e.getX() / (double)getWidth()* max;

	    if( 30 <= e.getY() && e.getY() < 80 ){
	        //first bar
	        theModel.update(0, value);
	    }

	    if( 80 <= e.getY() && e.getY() < 130 ){
	        //second bar
	        theModel.update(1, value);
	    }

	    if( 130 <= e.getY() && e.getY() < 180 ){
	        //third bar
	        theModel.update(2, value);
	    }

	    if( 180 <= e.getY() && e.getY() < 230 ){
	        //fourth bar
	        theModel.update(3, value);
	    }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
	    // TODO Auto-generated method stub

	}

	}