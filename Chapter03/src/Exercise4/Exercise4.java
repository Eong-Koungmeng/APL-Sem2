/*Group 17 Eong Koungmeng*/
package Exercise4;

public class Exercise4
{
	public static void main(String[] args)
	{
		BankAccount account1 = new BankAccount("1", 2500, "Koungmeng");
		BankAccount account2 = new BankAccount("2", 1000, "John");
		
		account1.generateReport();
		account2.generateReport();
		
		account1.transfer(account2, 3000);
		account1.transfer(account2, 1000);
		
		System.out.println("Account1 balance: " + account1.checkBalance() );
		System.out.println("Account2 balance: " + account2.checkBalance());
		
		account2.transfer(account1,200);
		System.out.println("Account1 balance: " + account1.checkBalance() );
		System.out.println("Account2 balance: " + account2.checkBalance());
	}
}
