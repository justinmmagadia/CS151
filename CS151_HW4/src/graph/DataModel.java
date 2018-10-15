package graph;

import java.util.ArrayList;
import javax.swing.event.*;
public class DataModel 
{
	
	ArrayList theData;
	ArrayList theListeners;
	
	public DataModel(ArrayList arrayListData)
	{
		theData=arrayListData;
		theListeners = new ArrayList();
	}
	
	public ArrayList getData()
	{
		return (ArrayList)(theData.clone());
	}
	
	public void attach(ChangeListener c)
	{
		theListeners.add(c);
	}
	public void update(int location, double value)
	{
		theData.set(location, value);
		for(int i = 0; i < theListeners.size(); i++)
		{
			ChangeListener cl = (ChangeListener)theListeners.get(i);
			cl.stateChanged(new ChangeEvent(this));
			System.out.println("1" + theListeners.get(i));
		}
	}
	

}
