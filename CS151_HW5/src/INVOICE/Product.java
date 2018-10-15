package INVOICE;

/**
A product with a price and description.
*/
public class Product implements LineItem
{
/**
   Constructs a product.
   @param description the description
   @param price the price
*/
public Product(String description, double price)
{
   this.description = description;
   this.price = price;
}
public double getPrice() { return price; }
public String toString() { return description; }
public void addQuantity() 
{
	if(description.equals("Hammer"))
	{
		quantity++;
	}
	else
		quantity2++;
}

public int getQuantity()
{
	if(description.equals("Hammer"))
{
	return quantity;
}
	else
		return quantity2;
}
private String description;
private double price;
private int quantity;
private int quantity2;
}
