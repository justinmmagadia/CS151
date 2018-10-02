package fe;


public class BankAccount implements Comparable<BankAccount> {

	private int accountNumber;
	private double balance;
	
	public BankAccount(int AnaccountNumber)
	{
		accountNumber = AnaccountNumber;
		balance=0;
	}
	
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public double getBalance() 
	{
		return balance;
	}
	
	public void deposit(double amount)
	{
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	public void withdraw(double amount)
	{
		double newBalance = balance - amount;
		balance = newBalance;
	}
	public int compareTo(BankAccount b)
	{
		if(balance>b.getBalance()) return 1;
		else if(balance<b.getBalance()) return -1;
		else return 0;
		
	}

	

	
	
}
