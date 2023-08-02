import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManageStudent implements Program
{
	String fileName = "student.txt";
	ArrayList<Student> studentList = new ArrayList<>();
	boolean running = true;
	
	ManageStudent() throws IOException
	{
		loadStudentData();
	}
	
	//For loading data
	void loadStudentData() throws IOException
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
				Student stu = new Student();
				stu.StudentID = wordsArray[0];
				stu.StudentName = wordsArray[1];
				stu.Gender = wordsArray[2];
				stu.DOB = wordsArray[3];
				stu.PhoneNo = wordsArray[4];
				stu.Address = wordsArray[5];
				stu.Year = wordsArray[6];
				stu.Generation = wordsArray[7];
				stu.Degree = wordsArray[8];
				stu.AccountID = wordsArray[9];
				
				
				studentList.add(stu);
			}
		}
		reader.close();
	}
		
	void addNewStudent() throws IOException
	{
		//read input
		Student stu = new Student();
		System.out.print("Enter student ID: ");
		stu.StudentID = Main.input.nextLine();
		System.out.print("Enter student name: ");
		stu.StudentName = Main.input.nextLine();
		System.out.print("Enter gender: ");
		stu.Gender = Main.input.nextLine();
		System.out.print("Enter DOB: ");
		stu.DOB = Main.input.nextLine();
		System.out.print("Enter phone no: ");
		stu.PhoneNo = Main.input.nextLine();
		System.out.print("Enter address: ");
		stu.Address = Main.input.nextLine();
		System.out.print("Enter year: ");
		stu.Year = Main.input.nextLine();
		System.out.print("Enter generation: ");
		stu.Generation = Main.input.nextLine();
		System.out.print("Enter degree: ");
		stu.Degree = Main.input.nextLine();
		System.out.print("Enter accountID: ");
		stu.AccountID = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(stu.StudentID + ',' + stu.StudentName + ',' + stu.Gender+ ',' +stu.DOB+','+ stu.PhoneNo+ ','
				+stu.Address+ ','+stu.Year+ ','+stu.Generation+ ','+stu.Degree+ ','+stu.AccountID+'\n');
		writer.close();
		
		//store new stu
		studentList.add(stu);
		System.out.println("Added a student");
	}
	
	int searchStudent()
	{
		System.out.print("Enter student id to find: ");
		String idToFind = Main.input.nextLine();
		
		for(int i = 0; i<studentList.size();i++)
		{
			// if found
			if(studentList.get(i).StudentID.equals(idToFind))
			{
				// print it
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
						"StudentID", "StudentName", "Gender", "DOB", "PhoneNo", "Address", "Year", "Generation", "Degree", "AccountID");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
						studentList.get(i).StudentID, studentList.get(i).StudentName, studentList.get(i).Gender, studentList.get(i).DOB, studentList.get(i).PhoneNo, studentList.get(i).Address, studentList.get(i).Year, studentList.get(i).Generation, studentList.get(i).Degree,studentList.get(i).AccountID);
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				return i;
			}
		}
		
		System.out.println("Search Not Found");
		return -1;
	}
	
	void updateStudent() throws IOException
	{
		System.out.print("Enter id to update: ");
		String idToUpdate = Main.input.nextLine();
		
		for(int i = 0; i<studentList.size();i++)
		{
			// if found
			if(studentList.get(i).StudentID.equals(idToUpdate))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				Student stu = new Student();
				
				
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToUpdate))
					{
						stu.StudentID = idToUpdate;
						System.out.print("Enter student name: ");
						stu.StudentName = Main.input.nextLine();
						System.out.print("Enter gender: ");
						stu.Gender = Main.input.nextLine();
						System.out.print("Enter DOB: ");
						stu.DOB = Main.input.nextLine();
						System.out.print("Enter phone no: ");
						stu.PhoneNo = Main.input.nextLine();
						System.out.print("Enter address: ");
						stu.Address = Main.input.nextLine();
						System.out.print("Enter year: ");
						stu.Year = Main.input.nextLine();
						System.out.print("Enter generation: ");
						stu.Generation = Main.input.nextLine();
						System.out.print("Enter degree: ");
						stu.Degree = Main.input.nextLine();
						System.out.print("Enter accountID: ");
						stu.AccountID = Main.input.nextLine();
						line = stu.StudentID + ',' + stu.StudentName + ',' + stu.Gender+ ',' + stu.DOB+','+stu.PhoneNo + ','+
								stu.Address+','+stu.Year+','+stu.Generation+','+stu.Degree+','+stu.AccountID;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				studentList.set(i, stu);
				
				System.out.println("Updated a student");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void deleteStudent() throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = Main.input.nextLine();
		
		for(int i = 0; i<studentList.size();i++)
		{
			// if found
			if(studentList.get(i).StudentID.equals(idToDelete))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore student
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
				
				studentList.remove(i);
				
				System.out.println("Deleted a student");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayStudent()
	{
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
				"StudentID", "StudentName", "Gender", "DOB", "PhoneNo", "Address", "Year", "Generation", "Degree", "AccountID");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i <studentList.size();i++)
		{
			System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
					studentList.get(i).StudentID, studentList.get(i).StudentName, studentList.get(i).Gender, studentList.get(i).DOB, studentList.get(i).PhoneNo, studentList.get(i).Address, studentList.get(i).Year, studentList.get(i).Generation, studentList.get(i).Degree,studentList.get(i).AccountID);
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Add a new student");
			System.out.println("b. Search student by id");
			System.out.println("c. Update a student");
			System.out.println("d. Delete a student by id");
			System.out.println("e. Display all students");
			System.out.println("f. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewStudent();
				break;
			case 'b':
				searchStudent();
				break;
			case 'c':
				updateStudent();
				break;
			case 'd':
				deleteStudent();
				break;
			case 'e':
				displayStudent();
				break;
			case 'f':
				running = false;
				break;
			}
	
			
		}
	}
}
