import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManageTeacher implements Program
{
	String fileName = "teacher.txt";
	ArrayList<Teacher> teacherList = new ArrayList<>();
	boolean running = true;
	
	ManageTeacher() throws IOException
	{
		loadTeacherData();
	}
	
	//For loading data
	void loadTeacherData() throws IOException
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
				Teacher teac = new Teacher();
				teac.TeacherID = wordsArray[0];
				teac.TeacherName = wordsArray[1];
				teac.Gender = wordsArray[2];
				teac.DOB = wordsArray[3];
				teac.PhoneNo = wordsArray[4];
				teac.Address = wordsArray[5];
				teac.AccountID = wordsArray[6];
				
				teacherList.add(teac);
			}
		}
		reader.close();
	}
		
	void addNewTeacher() throws IOException
	{
		//read input
		Teacher teac = new Teacher();
		System.out.print("Enter teacher ID: ");
		teac.TeacherID = Main.input.nextLine();
		System.out.print("Enter teacher name: ");
		teac.TeacherName = Main.input.nextLine();
		System.out.print("Enter gender: ");
		teac.Gender = Main.input.nextLine();
		System.out.print("Enter DOB: ");
		teac.DOB = Main.input.nextLine();
		System.out.print("Enter phone no: ");
		teac.PhoneNo = Main.input.nextLine();
		System.out.print("Enter address: ");
		teac.Address = Main.input.nextLine();
		System.out.print("Enter accountID: ");
		teac.AccountID = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(teac.TeacherID + ',' + teac.TeacherName + ',' + teac.Gender+ ',' +teac.DOB+','+ teac.PhoneNo+ ','
				+teac.Address+ ','+teac.AccountID+'\n');
		writer.close();
		
		//store new teac
		teacherList.add(teac);
		System.out.println("Added a teacher");
	}
	
	int searchTeacher()
	{
		System.out.print("Enter teacher id to find: ");
		String idToFind = Main.input.nextLine();
		
		for(int i = 0; i<teacherList.size();i++)
		{
			// if found
			if(teacherList.get(i).TeacherID.equals(idToFind))
			{
				// print it
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
						"TeacherID", "TeacherName", "Gender", "DOB", "PhoneNo", "Address",  "AccountID");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
						teacherList.get(i).TeacherID, teacherList.get(i).TeacherName, teacherList.get(i).Gender, teacherList.get(i).DOB, teacherList.get(i).PhoneNo, teacherList.get(i).Address,teacherList.get(i).AccountID);
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				return i;
			}
		}
		
		System.out.println("Search Not Found");
		return -1;
	}
	
	void updateTeacher() throws IOException
	{
		System.out.print("Enter id to update: ");
		String idToUpdate = Main.input.nextLine();
		
		for(int i = 0; i<teacherList.size();i++)
		{
			// if found
			if(teacherList.get(i).TeacherID.equals(idToUpdate))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				Teacher teac = new Teacher();
				
				
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToUpdate))
					{
						teac.TeacherID = idToUpdate;
						System.out.print("Enter teacher name: ");
						teac.TeacherName = Main.input.nextLine();
						System.out.print("Enter gender: ");
						teac.Gender = Main.input.nextLine();
						System.out.print("Enter DOB: ");
						teac.DOB = Main.input.nextLine();
						System.out.print("Enter phone no: ");
						teac.PhoneNo = Main.input.nextLine();
						System.out.print("Enter address: ");
						teac.Address = Main.input.nextLine();
						System.out.print("Enter accountID: ");
						teac.AccountID = Main.input.nextLine();
						line = teac.TeacherID + ',' + teac.TeacherName + ',' + teac.Gender+ ',' + teac.DOB+','+teac.PhoneNo + ','+
								teac.Address+','+teac.AccountID;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				teacherList.set(i, teac);
				
				System.out.println("Updated a teacher");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void deleteTeacher() throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = Main.input.nextLine();
		
		for(int i = 0; i<teacherList.size();i++)
		{
			// if found
			if(teacherList.get(i).TeacherID.equals(idToDelete))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore teacher
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
				
				teacherList.remove(i);
				
				System.out.println("Deleted a teacher");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayTeacher()
	{
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
				"TeacherID", "TeacherName", "Gender", "DOB", "PhoneNo", "Address",  "AccountID");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i <teacherList.size();i++)
		{
			System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
					teacherList.get(i).TeacherID, teacherList.get(i).TeacherName, teacherList.get(i).Gender, teacherList.get(i).DOB, teacherList.get(i).PhoneNo, teacherList.get(i).Address,teacherList.get(i).AccountID);
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Add a new teacher");
			System.out.println("b. Search teacher by id");
			System.out.println("c. Update a teacher");
			System.out.println("d. Delete a teacher by id");
			System.out.println("e. Display all teachers");
			System.out.println("f. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewTeacher();
				break;
			case 'b':
				searchTeacher();
				break;
			case 'c':
				updateTeacher();
				break;
			case 'd':
				deleteTeacher();
				break;
			case 'e':
				displayTeacher();
				break;
			case 'f':
				running = false;
				break;
			}
	
			
		}
	}
}
