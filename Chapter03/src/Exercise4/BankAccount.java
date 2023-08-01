package Exercise4;

class BankAccount
{
	private String accountNumber;
	private	float balance;
	private String accountHoldersName;
	
	BankAccount()
	{
		accountNumber = "";
		balance = 0;
		accountHoldersName = "";
	}
	
	BankAccount(String accountNumber, float balance, String accountHoldersName)
	{
		createAccount(accountNumber, balance, accountHoldersName);
	}
	
	void createAccount(String accountNumber, float balance,String accountHoldersName)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountHoldersName = accountHoldersName;
	}
	
	void deposit(float amount)
	{
		if(amount > 0)
		{
			balance += amount;
		}
	}
	
	void withDraw(float amount)
	{
		if(amount < balance)
		{
			balance -= amount;
		}
	}
	
	void transfer(BankAccount transferAccount, float amount)
	{
		if(amount > balance)
		{
			System.out.println("Insufficient Balance");
			return;
		}
		
		balance -= amount;
		transferAccount.deposit(amount);
		System.out.println("Transfered " + amount + " from account" + accountNumber + " to account" + transferAccount.accountNumber);
	}
	
	void generateReport()
	{
		System.out.println("Account: " + accountNumber + ", Balance: " + balance + ", Account Holder's Name: " + accountHoldersName);
	}
	
	float checkBalance()
	{
		return balance;
	}
}
