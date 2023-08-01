import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageFaculty implements Program
{
	String fileName = "faculty.txt";
	ArrayList<Faculty> facultyList = new ArrayList<>();
	boolean running = true;
	
	ManageFaculty() throws IOException
	{
		loadFacultyData();
	}
	
	//For loading data
	void loadFacultyData() throws IOException
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
				Faculty fa = new Faculty();
				fa.FacultyID = wordsArray[0];
				fa.FacultyName = wordsArray[1];
				fa.DeanName = wordsArray[2];
				fa.OfficeNo = wordsArray[3];
				
				facultyList.add(fa);
			}
		}
		reader.close();
	}
		
	void addNewFaculty() throws IOException
	{
		//read input
		Faculty fa = new Faculty();
		System.out.print("Enter faculty ID: ");
		fa.FacultyID = Main.input.nextLine();
		System.out.print("Enter faculty name: ");
		fa.FacultyName = Main.input.nextLine();
		System.out.print("Enter dean name: ");
		fa.DeanName = Main.input.nextLine();
		System.out.print("Enter office no: ");
		fa.OfficeNo = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(fa.FacultyID + ',' + fa.FacultyName + ',' + fa.DeanName+ ',' + fa.OfficeNo+'\n');
		writer.close();
		
		//store new fa
		facultyList.add(fa);
		System.out.println("Added a faculty");
	}
	
	int searchFaculty()
	{
		System.out.print("Enter faculty id to find: ");
		String idToFind = Main.input.nextLine();
		
		for(int i = 0; i<facultyList.size();i++)
		{
			// if found
			if(facultyList.get(i).FacultyID.equals(idToFind))
			{
				// print it
				System.out.println("---------------------------------------------------------");
				System.out.printf("%-12s %-18s %-15s %-13s\n", "FacultyID", "FacultyName", "DeanName", "OfficeNo");
				System.out.println("---------------------------------------------------------");
				System.out.printf("%-12s %-18s %-15s %-13s\n", facultyList.get(i).FacultyID, facultyList.get(i).FacultyName, facultyList.get(i).DeanName, facultyList.get(i).OfficeNo);
				System.out.println("---------------------------------------------------------");
				return i;
			}
		}
		
		System.out.println("Search Not Found");
		return -1;
	}
	
	void updateFaculty() throws IOException
	{
		System.out.print("Enter id to update: ");
		String idToUpdate = Main.input.nextLine();
		
		for(int i = 0; i<facultyList.size();i++)
		{
			// if found
			if(facultyList.get(i).FacultyID.equals(idToUpdate))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				Faculty fa = new Faculty();
				
				
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToUpdate))
					{
						fa.FacultyID = idToUpdate;
						System.out.print("Enter faculty name: ");
						fa.FacultyName = Main.input.nextLine();
						System.out.print("Enter dean name: ");
						fa.DeanName = Main.input.nextLine();
						System.out.print("Enter office no: ");
						fa.OfficeNo = Main.input.nextLine();
						line = fa.FacultyID + ',' + fa.FacultyName + ',' + fa.DeanName+ ',' + fa.OfficeNo;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				facultyList.set(i, fa);
				
				System.out.println("Updated a faculty");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void deleteFaculty() throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = Main.input.nextLine();
		
		for(int i = 0; i<facultyList.size();i++)
		{
			// if found
			if(facultyList.get(i).FacultyID.equals(idToDelete))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore faculty
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
				
				facultyList.remove(i);
				
				System.out.println("Deleted a faculty");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayFaculty()
	{
		System.out.println("---------------------------------------------------------");
		System.out.printf("%-12s %-18s %-15s %-13s\n", "FacultyID", "FacultyName", "DeanName", "OfficeNo");
		System.out.println("---------------------------------------------------------");
		
		for(int i = 0; i <facultyList.size();i++)
		{
			System.out.printf("%-12s %-18s %-15s %-13s\n", facultyList.get(i).FacultyID, facultyList.get(i).FacultyName, facultyList.get(i).DeanName, facultyList.get(i).OfficeNo);
		}
		System.out.println("---------------------------------------------------------");
	}
	
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Add a new faculty");
			System.out.println("b. Search faculty by id");
			System.out.println("c. Update a faculty");
			System.out.println("d. Delete a faculty by id");
			System.out.println("e. Display all faculties");
			System.out.println("f. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewFaculty();
				break;
			case 'b':
				searchFaculty();
				break;
			case 'c':
				updateFaculty();
				break;
			case 'd':
				deleteFaculty();
				break;
			case 'e':
				displayFaculty();
				break;
			case 'f':
				running = false;
				break;
			}
	
			
		}
	}
}
