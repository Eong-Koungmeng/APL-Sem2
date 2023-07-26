/*Group 17 Eong Koungmeng*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Account
{
	String accountNo;
	String name;
	float balance;
	String password;
	
	boolean login(String accountNo, String password)
	{
		if(this.accountNo.equals(accountNo) && this.password.equals(password))
			return true;
		return false;
	}
	
	void displayBalance()
	{
		System.out.println("Balance: " + balance);
	}
	
	void withdraw(Scanner input) throws IOException
	{
		System.out.print("Enter amount to withdraw: ");
		
		float withDrawAmount = input.nextFloat();
		input.nextLine();
		
		if(withDrawAmount > balance)
		{
			System.out.println("Insufficient balance");
			return;
		}
		
		balance -= withDrawAmount;
		
		String fileContent = "";
		String line;

		BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
		

		while((line=reader.readLine())!=null)
		{
			if(line.split("\t")[0].equals(accountNo))
			{
				line = accountNo + '\t' + name + '\t' + balance + '\t' + password;
			}
			
			fileContent+=line+'\n';
		}
		reader.close();
		
		//write back to file
		FileWriter writer = new FileWriter("Account.txt");
		writer.write(fileContent);
		writer.close();
	}
	
	void deposit(Scanner input) throws IOException
	{
		System.out.print("Enter amount to deposit: ");
		
		float depositAmount = input.nextFloat();
		input.nextLine();
		
		balance += depositAmount;
		
		String fileContent = "";
		String line;

		BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
		

		while((line=reader.readLine())!=null)
		{
			if(line.split("\t")[0].equals(accountNo))
			{
				line = accountNo + '\t' + name + '\t' + balance + '\t' + password;
			}
			
			fileContent+=line+'\n';
		}
		reader.close();
		
		//write back to file
		FileWriter writer = new FileWriter("Account.txt");
		writer.write(fileContent);
		writer.close();
	}
	
	void transfer(Account targetAccount, float amount) throws IOException
	{
		if(amount > balance)
		{
			System.out.println("Insufficient balance");
			return;
		}
		
		balance -= amount;
		targetAccount.balance+=amount;
		
		String fileContent = "";
		String line;

		BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
		
		while((line=reader.readLine())!=null)
		{
			if(line.split("\t")[0].equals(accountNo))
			{
				line = accountNo + '\t' + name + '\t' + balance + '\t' + password;
			}
			
			if(line.split("\t")[0].equals(targetAccount.accountNo))
			{
				line = targetAccount.accountNo + '\t' + targetAccount.name + '\t' + targetAccount.balance + '\t' + targetAccount.password;
			}
			
			fileContent+=line+'\n';
		}
		reader.close();
		
		//write back to file
		FileWriter writer = new FileWriter("Account.txt");
		writer.write(fileContent);
		writer.close();
		
	}
}

public class Exercise07
{
	static boolean loadAccountData(ArrayList<Account> accountList) throws IOException
	{
		// if cant find file then create empty file
		File file = new File("Account.txt");
		if(!file.exists())
		{
			return false;			
		}

		BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
		String line;
		String[] wordsArray;

		while((line=reader.readLine())!=null)
		{
			wordsArray = line.split("\t");
			Account acc = new Account();
			acc.accountNo = wordsArray[0];
			acc.name = wordsArray[1];
			acc.balance = Float.parseFloat(wordsArray[2]);
			acc.password = wordsArray[3];
			
			accountList.add(acc);
		}
		reader.close();
		return true;
		
	}
	
	static Account login(ArrayList<Account> accountList, Account currentAccount, Scanner input)
	{
		System.out.print("Enter account number: ");
		String accountNo = input.nextLine();
		System.out.print("Enter password: ");
		String password = input.nextLine();
		
		for(int i = 0; i<accountList.size();i++)
		{
			if(accountList.get(i).accountNo.equals(accountNo))
			{
				//if login success
				if(accountList.get(i).login(accountNo, password))
				{
					currentAccount = accountList.get(i);
					System.out.println("Login successfully");
					return currentAccount;
				}
			}
		}
		return null;
		
	}
	
	static void transfer(ArrayList<Account> accountList,Account currentAcc, Scanner input) throws IOException
	{
		System.out.print("Enter account to recieve: ");
		String transferAccNo = input.nextLine();
		Account transferAcc;
		
		for(int i = 0; i<accountList.size();i++)
		{
			if(accountList.get(i).accountNo.equals(transferAccNo))
			{
				transferAcc = accountList.get(i);
				System.out.print("Enter amount to transfer: ");
				float amount = input.nextFloat();
				input.nextLine();
				
				currentAcc.transfer(transferAcc, amount);
				return;
			}
		}
		
		System.out.println("Invalid account ID");
		
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Account> accountList = new ArrayList<>();
		Account currentAccount = null;
		
		if(!loadAccountData(accountList))
		{
			System.out.println("Can't load file");
			return;
		}
		
		boolean running = true;
		currentAccount = login(accountList, currentAccount,input);
		if(currentAccount==null)
		{
			System.out.println("Login failed");
			running = false;
		}
		
		while(running)
		{

			System.out.println("\na. Balance");
			System.out.println("b. Withdraw");
			System.out.println("c. Deposit");
			System.out.println("d. Transfer");
			System.out.println("e. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				currentAccount.displayBalance();
				break;
			case 'b':
				currentAccount.withdraw(input);;
				break;
			case 'c':
				currentAccount.deposit(input);;
				break;
			case 'd':
				transfer(accountList,currentAccount, input);
				break;
			case 'e':
				running = false;
				break;
			}
		}
		
		input.close();
		System.out.println("Thank You.");
	}

	
}
