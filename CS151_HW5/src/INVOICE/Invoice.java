package INVOICE;
import java.util.*;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice
{
   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<>();
      listeners = new ArrayList<>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item)
   {
	   ChangeEvent event = new ChangeEvent(this);
	  if(items.contains(item))
	  {
		  
		  counter = 0;
		  items.add(item);
		 //tem.addQuantity();
		 //tem.getQuantity();
		  for(int i = 0; i < items.size(); i++)
		  {
			  if(items.get(i).equals(item))
			  {
			  counter++;
			  }
		  }
		  for (ChangeListener listener : listeners)
		         listener.stateChanged(event);
		  System.out.print("\r Quantity of " + item.toString() + ": "+ counter);
		  
	  }
	  else
	  {
		  counter = 1;
	// item.addQuantity();
	// item.getQuantity();
		  items.add(item);
	// System.out.println(item.getQuantity());
		  for (ChangeListener listener : listeners)
		        listener.stateChanged(event);
	      	
	      	System.out.print("\n Quantity of " + item.toString() + ": "+ counter);
	   
		 
	  }
		
      
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener)
   {
      listeners.add(listener);
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext()
            {
               return current < items.size();
            }

            public LineItem next()
            {
               return items.get(current++);
            }

            public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
      String r = formatter.formatHeader();
      Iterator<LineItem> iter = getItems();
      while (iter.hasNext())
      {
    	  r += "\n" + formatter.formatLineItem(iter.next());//\n" + formatter.formatQuantity();
      }
                  return r + formatter.formatFooter();
   }

   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;
   private int counter;
   private int counter2;
}