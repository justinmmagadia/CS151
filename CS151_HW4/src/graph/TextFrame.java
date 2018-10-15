package graph;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;
public class TextFrame extends JFrame implements ChangeListener 
{

	DataModel theModel;
	JTextField[] theList;
	private ArrayList<Double> a;
	
	/*
	 * Constructs JFram that contains textframe in model
	 */
	public TextFrame(DataModel d)
	{
		theModel = d;
		
		final Container contentPane = this.getContentPane();
		setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		ArrayList<Double> a = theModel.getData();
		theList = new JTextField[a.size()];
		
		  ActionListener l = new ActionListener()
	      {
	         public void actionPerformed(ActionEvent e)
	         {
	            // Figure out which field generated the event
	            JTextField c = (JTextField) e.getSource();
	            int i = 0;
	            int count = theList.length;
	            while (i < count && theList[i] != c)
	               i++;

	            String text = c.getText().trim();

	            try
	            {
	               double value = Double.parseDouble(text);
	               theModel.update(i, value);
	            }
	            catch (Exception exc)
	            {
	               c.setText("Error.  No update");
	            }
	         }
	      };
		
		final int FIELD_WIDTH = 11;
		for (int i = 0; i < a.size(); i++)
	      {
	         JTextField textField = new JTextField(a.get(i).toString(),FIELD_WIDTH);
	         textField.addActionListener(l);
	         add(textField);
	         theList[i] = textField;
	      }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		a = theModel.getData();
		 for(int i = 0; i < a.size(); i++){
		       theList[i].setText(Double.toString(Math.round(a.get(i) * 10) / 10.0)); // to get 1 decimal place accuracy
		   }
	}
	
}
