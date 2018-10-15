package INVOICE;

import java.util.*;

/**
   A bundle of line items that is again a line item.
*/
public class Bundle implements LineItem
{
   /**
      Constructs a bundle with no items.
   */
   public Bundle() { items = new ArrayList<>(); }

   /**
      Adds an item to the bundle.
      @param item the item to add
   */
   public void add(LineItem item) 
   { 
	   if(items.contains(item))
	   {
		   item.addQuantity();
		   System.out.println(item.getQuantity());
	  }
	   else
	   item.addQuantity();
	   System.out.println(item.getQuantity());
	   items.add(item); 
	   getPrice();
	   
   }

   public double getPrice()
   {
      double price = 0;

      for (LineItem item : items)
         price += item.getPrice();
      return price;
   }

   public String toString()
   {
      String description = "Bundle: ";
      for (int i = 0; i < items.size(); i++)
      {
         if (i > 0) description += ", ";
         description += items.get(i).toString();
      }
      return description;
   }

   private ArrayList<LineItem> items;
   private int counter;
//@Override
public void addQuantity() {
	counter++;
	
}

//@Override
public int getQuantity() {
	// TODO Auto-generated method stub
	return counter;
}
}
