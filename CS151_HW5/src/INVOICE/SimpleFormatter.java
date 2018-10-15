package INVOICE;

/**
A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
public String formatHeader()
{
   total = 0;
   return "     I N V O I C E\n\n\n" + "Q U A N T I T Y";
}

public String formatLineItem(LineItem item)
{
	items = item;
   total += item.getPrice();
   return (String.format(
         "%s: $%.2f\n",item.toString(),item.getPrice()));
}

public String formatFooter()
{
   return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
}

public String formatQuantity()
{
	String s = "Quantity: " ;
	if(items.equals("Hammer"))
	{
		quantity++;
	 s += Integer.toString(quantity);
	}
	else
	{
		quantity2++;
		s+= Integer.toString(quantity2);
	}
	return s;
}
private LineItem items;
private double total;
private int quantity;
private int quantity2;

}
