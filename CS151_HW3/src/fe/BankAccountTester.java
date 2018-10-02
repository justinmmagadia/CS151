package fe;

import java.util.ArrayList;
import java.util.Collections;

public class BankAccountTester {

	
	
	public static void main(String[] args)
	{
		ArrayList<BankAccount> banks = new ArrayList<BankAccount>();
		BankAccount b1 = new BankAccount(200);
		BankAccount b2 = new BankAccount(500);
		BankAccount b3 = new BankAccount(300);
		BankAccount b4 = new BankAccount(100);
		BankAccount b5 = new BankAccount(400);
		
		banks.add(b1);
		banks.add(b2);
		banks.add(b3);
		banks.add(b4);
		banks.add(b5);
		
		b1.deposit(1500);
		b2.deposit(1000);
		b3.deposit(500);
		b4.deposit(2200);
		b5.deposit(2800);
		
		Collections.shuffle(banks);
		Collections.sort(banks);
		
		for(int i= 0; i< banks.size(); i++)
		{
			BankAccount b = banks.get(i);
			System.out.println("Account Number " + b.getAccountNumber() +" has $" + b.getBalance());
		}
	}
	
	
	
}
