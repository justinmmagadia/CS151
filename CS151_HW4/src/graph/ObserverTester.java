package graph;

import java.util.ArrayList;

public class ObserverTester {

	public static void main(String[] args)
	{
		ArrayList ArrayListarraylist = new ArrayList();
		ArrayListarraylist.add(new Double(40.0));
		ArrayListarraylist.add(new Double(30.0));
		ArrayListarraylist.add(new Double(20.0));
		ArrayListarraylist.add(new Double(10.0));
		DataModel datamodel = new DataModel(ArrayListarraylist);
		TextFrame textframe= new TextFrame(datamodel);
		BarFrame barframe = new BarFrame(datamodel);
		datamodel.attach(barframe);
	}
}
