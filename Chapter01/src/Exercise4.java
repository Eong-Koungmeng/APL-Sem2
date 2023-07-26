/*Group 17 Eong Koungmeng*/
import java.util.HashMap;
import java.util.Scanner;

public class Exercise4
{
	public static void balanceMode(String loginID,HashMap<String, HashMap<String,String>> accounts, Scanner input)
	{
		System.out.println("Your balance is " + accounts.get(loginID).get("Balance") + " $");
	}
	
	public static void withdrawMode(String loginID, HashMap<String,HashMap<String,String>> accounts, Scanner input)
	{
		float balance = Float.parseFloat(accounts.get(loginID).get("Balance"));
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
		accounts.get(loginID).replace("Balance", String.format("%.2f", balance));
		
		System.out.println("Withdraw sucessfully");
	}
	
	public static void depositMode(String loginID, HashMap<String,HashMap<String,String>> accounts, Scanner input)
	{
		float balance = Float.parseFloat(accounts.get(loginID).get("Balance"));
		System.out.print("Enter amount to deposit: ");
		float depositAmount = input.nextFloat();
		input.nextLine();
		
		balance += depositAmount;
		
		//update balance
		accounts.get(loginID).replace("Balance", String.format("%.2f", balance));
		
		System.out.println("Deposit sucessfully");
	}
	
	public static void transferMode(String loginID, HashMap<String,HashMap<String,String>> accounts, Scanner input)
	{
		float balance = Float.parseFloat(accounts.get(loginID).get("Balance"));
		System.out.print("Enter account number to transfer: ");
		String transferAccount = input.nextLine();
		
		if(!accounts.containsKey(transferAccount))
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
		
		if(!accounts.get(loginID).get("Password").equals(password))
		{
			System.out.println("Transfer unsuccessful. Incorrect password");
			return;
		}
		
		balance -= transferAmount;
		float transferAccountBalance = Float.parseFloat(accounts.get(transferAccount).get("Balance"))+transferAmount;
		//update balance
		accounts.get(loginID).replace("Balance", String.format("%.2f", balance));
		accounts.get(transferAccount).replace("Balance", String.format("%.2f", transferAccountBalance));
		System.out.println("Transfer sucessfully");
	}
	
	public static void main(String[] args)
	{
		//create and initialize hashmaps
		HashMap<String,String> account001 = new HashMap<>();
		account001.put("Name", "Preap Sovath");
		account001.put("Balance", "12300993");
		account001.put("Password", "11112222");
		
		HashMap<String,String> account002 = new HashMap<>();
		account002.put("Name", "Raku");
		account002.put("Balance", "50000");
		account002.put("Password", "raku1234");
		
		HashMap<String,String> account003 = new HashMap<>();
		account003.put("Name", "Kosaki");
		account003.put("Balance", "4800");
		account003.put("Password", "2357");
		
		HashMap<String,String> account004 = new HashMap<>();
		account004.put("Name", "Hoshino Ai");
		account004.put("Balance", "23900");
		account004.put("Password", "02468");
		
		HashMap<String,String> account005 = new HashMap<>();
		account005.put("Name", "Kujo Jotaro");
		account005.put("Balance", "62500");
		account005.put("Password", "STAR PLATINUM");
		
		HashMap<String, HashMap<String,String>> accounts = new HashMap<>();
		accounts.put("001", account001);
		accounts.put("002", account002);
		accounts.put("003", account003);
		accounts.put("004", account004);
		accounts.put("005", account005);
		
		Scanner input = new Scanner(System.in);
		while(true)
		{
			
			String loginID = "";
			String loginPassword;
			// login
			boolean loginFailed = true;
			while (loginFailed) 
			{
				System.out.print("Enter account number: ");
				loginID = input.nextLine();
				System.out.print("Enter account password: ");
				loginPassword = input.nextLine();

				if (!accounts.containsKey(loginID)) 
				{
					System.out.println("Account number not found");
				} else if (!accounts.get(loginID).get("Password").equals(loginPassword)) 
				{
					System.out.println("Incorrect password");
				} else 
				{
					System.out.println("Login successfully");
					loginFailed = false;
				}
			}

			System.out.println("Welcome " + accounts.get(loginID).get("Name"));
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
}
