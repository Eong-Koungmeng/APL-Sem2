import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManageDepartment implements Program
{
	ArrayList<Department> departmentList = new ArrayList<>();
	ManageFaculty mf = new ManageFaculty();
	String fileName = "department.txt";
	boolean running = true;
	
	ManageDepartment() throws IOException
	{
		loadDepartmentData();
	}
	
	//For loading data
	void loadDepartmentData() throws IOException
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
				Department de = new Department();
				de.DeptID= wordsArray[0];
				de.DeptName = wordsArray[1];
				de.HeadName = wordsArray[2];
				de.OfficeNo = wordsArray[3];
				de.FacultyID = wordsArray[4];
				
				departmentList.add(de);
			}
		}
		reader.close();
	}
		
	void addNewDepartment() throws IOException
	{
		//read input
		Department de = new Department();
		System.out.print("Enter department ID: ");
		de.DeptID = Main.input.nextLine();
		System.out.print("Enter department name: ");
		de.DeptName = Main.input.nextLine();
		System.out.print("Enter head name: ");
		de.HeadName = Main.input.nextLine();
		System.out.print("Enter office no: ");
		de.OfficeNo = Main.input.nextLine();
		System.out.print("Enter faculty no: ");
		de.FacultyID = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(de.DeptID + ',' + de.DeptName + ',' + de.HeadName+ ',' + de.OfficeNo +','+de.FacultyID+'\n');
		writer.close();
		
		//store new de
		departmentList.add(de);
		System.out.println("Added a department");
	}
	
	int searchDepartment()
	{
		System.out.print("Enter department id to find: ");
		String idToFind = Main.input.nextLine();
		
		for(int i = 0; i<departmentList.size();i++)
		{
			// if found
			if(departmentList.get(i).DeptID.equals(idToFind))
			{
				// print it
				System.out.println("-----------------------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", "DeptID", "DeptName", "HeadName", "OfficeNo", "FacultyID");
				System.out.println("-----------------------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", departmentList.get(i).DeptID, departmentList.get(i).DeptName, departmentList.get(i).HeadName, departmentList.get(i).OfficeNo, departmentList.get(i).FacultyID);
				System.out.println("-----------------------------------------------------------------------");
				return i;
			}
		}
		
		System.out.println("Search Not Found");
		return -1;
	}
	
	void updateDepartment() throws IOException
	{
		System.out.print("Enter id to update: ");
		String idToUpdate = Main.input.nextLine();
		
		for(int i = 0; i<departmentList.size();i++)
		{
			// if found
			if(departmentList.get(i).DeptID.equals(idToUpdate))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				Department de = new Department();
				
				
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToUpdate))
					{
						de.DeptID = idToUpdate;
						System.out.print("Enter department name: ");
						de.DeptName = Main.input.nextLine();
						System.out.print("Enter head name: ");
						de.HeadName = Main.input.nextLine();
						System.out.print("Enter office no: ");
						de.OfficeNo = Main.input.nextLine();
						System.out.print("Enter faculty no: ");
						de.FacultyID = Main.input.nextLine();
						line = de.DeptID + ',' + de.DeptName + ',' + de.HeadName+ ',' + de.OfficeNo +','+de.FacultyID;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				departmentList.set(i, de);
				
				System.out.println("Updated a department");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void deleteDepartment() throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = Main.input.nextLine();
		
		for(int i = 0; i<departmentList.size();i++)
		{
			// if found
			if(departmentList.get(i).DeptID.equals(idToDelete))
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
				
				departmentList.remove(i);
				
				System.out.println("Deleted a department");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayDepartment()
	{
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", "DeptID", "DeptName", "HeadName", "OfficeNo", "FacultyID");
		System.out.println("-----------------------------------------------------------------------");
		
		for(int i = 0; i <departmentList.size();i++)
		{
			System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", departmentList.get(i).DeptID, departmentList.get(i).DeptName, departmentList.get(i).HeadName, departmentList.get(i).OfficeNo, departmentList.get(i).FacultyID);
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	void displayDepartmentInFaculty()
	{
		System.out.print("Enter faculty id to display its departments: ");
		String idToDisplay = Main.input.nextLine();
		String facultyName = "";
		
		
		ArrayList<Faculty> facultyList = mf.facultyList;
		for(int i = 0; i < facultyList.size();i++)
		{
			if(facultyList.get(i).FacultyID.equals(idToDisplay))
			{
				facultyName = facultyList.get(i).FacultyName;
			}
		}
		
		if(facultyName.equals(""))
		{
			System.out.println("Incorrect faculty ID");
			return;
		}
		System.out.println("Departments in " + facultyName + " faculty");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", "DeptID", "DeptName", "HeadName", "OfficeNo", "FacultyID");
		System.out.println("-----------------------------------------------------------------------");
		for(int i = 0; i<departmentList.size();i++)
		{
			if(departmentList.get(i).FacultyID.equals(idToDisplay))
			{
				// print it
				
				System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", departmentList.get(i).DeptID, departmentList.get(i).DeptName, departmentList.get(i).HeadName, departmentList.get(i).OfficeNo, departmentList.get(i).FacultyID);
			}
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Add a new department");
			System.out.println("b. Search department by id");
			System.out.println("c. Update a department");
			System.out.println("d. Delete a department by id");
			System.out.println("e. Display all department");
			System.out.println("f. Display all department belong to a faculty");
			System.out.println("g. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewDepartment();
				break;
			case 'b':
				searchDepartment();
				break;
			case 'c':
				updateDepartment();
				break;
			case 'd':
				deleteDepartment();
				break;
			case 'e':
				displayDepartment();
				break;
			case 'f':
				displayDepartmentInFaculty();
				break;
			case 'g':
				running = false;
				break;
			}
	
			
		}
	}
	
}
