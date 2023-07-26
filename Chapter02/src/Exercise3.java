/*Group 17 Eong Koungmeng*/
import java.util.Scanner;

class Account
{
	int account_no;
	String name;
	float balance;
	String password;
}
public class Exercise3 
{
	public static void main(String[] args)
	{
		// Create and initialize accounts
		Account[] accounts = new Account[5];
		for(int i = 0; i<accounts.length;i++)
		{
			accounts[i] = new Account();
		}
		
		accounts[0].account_no = 0;
		accounts[0].name = "Preap Sovath";
		accounts[0].balance = 150;
		accounts[0].password = "00001111";
		
		accounts[1].account_no = 1;
		accounts[1].name = "Kana Hanazawa";
		accounts[1].balance = 250;
		accounts[1].password = "hana1234";
		
		accounts[2].account_no = 2;
		accounts[2].name = "Jonathan Joestar";
		accounts[2].balance = 1000;
		accounts[2].password = "erina";
		
		accounts[3].account_no = 3;
		accounts[3].name = "Zhuge Liang";
		accounts[3].balance = 2500;
		accounts[3].password = "Kongming";
		
		accounts[4].account_no = 4;
		accounts[4].name = "Tanjiro Kamado";
		accounts[4].balance = 400;
		accounts[4].password = "nezuko";
		
		Scanner input = new Scanner(System.in);
		while(true)
		{
			
			int loginID = 0;
			String loginPassword;
			// login
			boolean loginFailed = true;
			while (loginFailed) 
			{
				System.out.print("Enter account number: ");
				loginID = Integer.parseInt(input.nextLine());
				System.out.print("Enter account password: ");
				loginPassword = input.nextLine();

				if (loginID < 0 || loginID >= accounts.length) 
				{
					System.out.println("Account number not found");
				} else if (!accounts[loginID].password.equals(loginPassword)) 
				{
					System.out.println("Incorrect password");
				} else 
				{
					System.out.println("Login successfully");
					loginFailed = false;
				}
			}

			System.out.println("Welcome " + accounts[loginID].name);
			boolean exit = false;
			while (!exit) 
			{
				// show menu
				System.out.println("\nMenu:");
				System.out.println("a. Balance");
				System.out.println("b. Withdraw");
				System.out.println("c. Deposit");
				System.out.println("d. Transfer");
				System.out.println("e. Exit the program");
				System.out.print("Select a mode: ");

				char inputChar = input.nextLine().charAt(0);
				System.out.println();
				switch (inputChar)
				{
				case 'a':
					balanceMode(loginID, accounts, input);
					break;
				case 'b':
					withdrawMode(loginID, accounts, input);
					break;
				case 'c':
					depositMode(loginID, accounts, input);
					break;
				case 'd':
					transferMode(loginID, accounts, input);
					break;
				case 'e':
					exit = true;
				}
			}
		}
		
	}

	private static void transferMode(int loginID, Account[] accounts, Scanner input)
	{
		float balance = accounts[loginID].balance;
		System.out.print("Enter account number to transfer: ");
		int transferAccount = Integer.parseInt(input.nextLine());
		
		if(transferAccount < 0 | transferAccount >= accounts.length)
		{
			System.out.println("Transfer unsuccessful. Account number doesn't exit");
			return;
		}
		
		System.out.print("Enter amount to transfer: ");
		float transferAmount = input.nextFloat();
		input.nextLine();
		
		if(balance < transferAmount)
		{
			System.out.println("Transfer unsuccessful. Not enough balance");
			return;
		}
		
		System.out.print("Enter password: ");
		String password = input.nextLine();
		
		if(!accounts[loginID].password.equals(password))
		{
			System.out.println("Transfer unsuccessful. Incorrect password");
			return;
		}
		
		balance -= transferAmount;
		float transferAccountBalance = accounts[transferAccount].balance +transferAmount;
		//update balance
		accounts[loginID].balance = balance;
		accounts[transferAccount].balance = transferAccountBalance;
		System.out.println("Transfer sucessfully");
		
	}

	private static void depositMode(int loginID, Account[] accounts, Scanner input)
	{

		float balance = accounts[loginID].balance;
		System.out.print("Enter amount to deposit: ");
		float depositAmount = input.nextFloat();
		input.nextLine();
		
		balance += depositAmount;
		
		//update balance
		accounts[loginID].balance = balance;
		
		System.out.println("Deposit sucessfully");
		
	}

	private static void withdrawMode(int loginID, Account[] accounts, Scanner input)
	{
		float balance = accounts[loginID].balance;
		System.out.print("Enter amount to withdraw: ");
		float withdrawAmount = input.nextFloat();
		input.nextLine();
		
		while(withdrawAmount > balance)
		{
			System.out.println("Balance is not enough");
			System.out.print("Enter amount to withdraw: ");
			withdrawAmount = input.nextFloat();
			input.nextLine();
		}
		
		balance -= withdrawAmount;
		
		//update balance
		accounts[loginID].balance = balance;
		
		System.out.println("Withdraw sucessfully");
		
	}

	private static void balanceMode(int loginID, Account[] accounts, Scanner input)
	{
		System.out.println("Your balance is " + accounts[loginID].balance + " $");
		
	}
}
