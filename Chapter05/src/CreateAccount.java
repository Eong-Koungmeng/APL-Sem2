import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateAccount implements Program
{
	String fileName = "account.txt";
	ArrayList<Account> accountList = new ArrayList<>();
	ManageStudent ms = new ManageStudent();
	ManageTeacher mt = new ManageTeacher();
	
	boolean running = true;
	
	CreateAccount() throws IOException
	{
		loadAccountData();
	}
	
	//For loading data
	void loadAccountData() throws IOException
	{
		File file = new File(fileName);
		if(!file.exists())
		{
			file.createNewFile();			
		}

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		String[] wordsArray;

		//Read and split each line by comma
		while((line=reader.readLine())!=null)
		{
			if(!line.equals("\n"))
			{
				wordsArray = line.split(",");
				Account acc = new Account();
				acc.AccountID = wordsArray[0];
				acc.Username = wordsArray[1];
				acc.Password = wordsArray[2];
				acc.PhoneNo = wordsArray[3];
				
				accountList.add(acc);
			}
		}
		reader.close();
	}
		
	void addNewAccount() throws IOException
	{
		//read input
		Account acc = new Account();
		System.out.print("Enter account ID: ");
		acc.AccountID = Main.input.nextLine();
		System.out.print("Enter account username: ");
		acc.Username = Main.input.nextLine();
		System.out.print("Enter password: ");
		acc.Password = Main.input.nextLine();
		System.out.print("Enter phone no: ");
		acc.PhoneNo = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(acc.AccountID + ',' + acc.Username + ',' + acc.Password+ ',' + acc.PhoneNo+'\n');
		writer.close();
		
		//store new acc
		accountList.add(acc);
		System.out.println("Added an account");
	}
	
	
	void deleteAccount() throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = Main.input.nextLine();
		
		for(int i = 0; i<accountList.size();i++)
		{
			// if found
			if(accountList.get(i).AccountID.equals(idToDelete))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore account
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToDelete))
					{
						continue;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				accountList.remove(i);
				
				System.out.println("Deleted a account");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayAccount()
	{
		System.out.println("----------------------------------------------------------------");
		System.out.printf("%-12s %-18s %-20s %-13s\n", "AccountID", "Username", "Password", "PhoneNumber");
		System.out.println("----------------------------------------------------------------");
		
		for(int i = 0; i <accountList.size();i++)
		{
			System.out.printf("%-12s %-18s %-20s %-13s\n", accountList.get(i).AccountID, accountList.get(i).Username, accountList.get(i).Password, accountList.get(i).PhoneNo);
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	void displayStudentTeacher()
	{
		System.out.println("Student table");
		ms.displayStudent();
		System.out.println("Teacher table");
		mt.displayTeacher();
	}
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Add a new account");
			System.out.println("b. Delete an account by id");
			System.out.println("c. Display accounts");
			System.out.println("d. Diplay Student and Teacher tables");
			System.out.println("e. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewAccount();
				break;
			case 'b':
				deleteAccount();
				break;
			case 'c':
				displayAccount();
				break;
			case 'd':
				displayStudentTeacher();
				break;
			case 'e':
				running = false;
				break;
			}
	
			
		}
	}
}
