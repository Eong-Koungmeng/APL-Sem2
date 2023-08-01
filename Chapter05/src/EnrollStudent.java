import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EnrollStudent implements Program
{
	ArrayList<DepartmentStudentDetail> dsdList = new ArrayList<DepartmentStudentDetail>();
	ManageStudent ms = new ManageStudent();
	ManageDepartment md = new ManageDepartment();
	
	boolean running = true;
	String fileName = "departmentStudentDetail.txt";
	
	EnrollStudent() throws IOException
	{
		loadEnrollmentData();
	}
	
	void loadEnrollmentData() throws IOException
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
				DepartmentStudentDetail dsd = new DepartmentStudentDetail();
				dsd.DeptID = wordsArray[0];
				dsd.StudentID = wordsArray[0];
				
				dsdList.add(dsd);
			}
		}
		reader.close();
	}
	
	void enrollStudent() throws IOException
	{		
		DepartmentStudentDetail dsd = new DepartmentStudentDetail();
		System.out.print("Enter student ID to enroll: ");
		dsd.StudentID = Main.input.nextLine();
		System.out.print("Enter departmet ID for student: ");
		dsd.DeptID = Main.input.nextLine();
		
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(dsd.StudentID + ',' + dsd.DeptID + '\n');
		writer.close();
		
		//store new dsd
		dsdList.add(dsd);
		System.out.println("Enrolled a student in a department");
		
	}
	
	void removeStudentFromDepartment() throws IOException
	{
		System.out.print("Enter student ID to delete: ");
		String studentID = Main.input.nextLine();
		System.out.print("Enter departmet ID for student: ");
		String deptID = Main.input.nextLine();
		
		for(int i = 0; i<dsdList.size();i++)
		{
			// if found
			if(dsdList.get(i).StudentID.equals(studentID) && dsdList.get(i).DeptID.equals(deptID))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore faculty
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(studentID) && line.split(",")[0].equals(deptID))
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
				
				dsdList.remove(i);
				
				System.out.println("Deleted a department");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayStudentGivenDepartment()
	{
		System.out.print("Enter department id to display its students: ");
		String idToFind = Main.input.nextLine();
		String departmentName = "";
	
		ArrayList<Department> departmentList = md.departmentList;
		ArrayList<Student> studentList = ms.studentList;
		for(int i = 0; i < departmentList.size();i++)
		{
			if(departmentList.get(i).DeptID.equals(idToFind))
			{
				departmentName = departmentList.get(i).DeptName;
			}
		}
		
		if(departmentName.equals(""))
		{
			System.out.println("Incorrect department ID");
			return;
		}
		
		System.out.println("Students in " + departmentName + " department");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
				"StudentID", "StudentName", "Gender", "DOB", "PhoneNo", "Address", "Year", "Generation", "Degree", "AccountID");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i<dsdList.size();i++)
		{
			if(dsdList.get(i).DeptID.equals(idToFind))
			{
				// print it
				for(int j = 0; j < ms.studentList.size();j++)
				{
					if(studentList.get(j).StudentID.equals(dsdList.get(i).StudentID))
					{
						System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", 
								studentList.get(j).StudentID, studentList.get(j).StudentName, studentList.get(j).Gender, studentList.get(j).DOB, studentList.get(j).PhoneNo, studentList.get(j).Address, studentList.get(j).Year, studentList.get(j).Generation, studentList.get(j).Degree,studentList.get(j).AccountID);
					}
				}
			}
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	void displayDepartmentByStudent()
	{
		System.out.print("Enter student id to display their department: ");
		String idToFind = Main.input.nextLine();
		String studentName = "";
	
		ArrayList<Student> studentList = ms.studentList;
		ArrayList<Department> departmentList = md.departmentList;
		for(int i = 0; i < studentList.size();i++)
		{
			if(studentList.get(i).StudentID.equals(idToFind))
			{
				studentName = studentList.get(i).StudentName;
			}
		}
		
		if(studentName.equals(""))
		{
			System.out.println("Incorrect student ID");
			return;
		}
		
		System.out.println("Students " + studentName + " enrolled in department");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", "DeptID", "DeptName", "HeadName", "OfficeNo", "FacultyID");
		System.out.println("-----------------------------------------------------------------------");
		
		for(int i = 0; i<dsdList.size();i++)
		{
			if(dsdList.get(i).StudentID.equals(idToFind))
			{
				// print it
				for(int j = 0; j < departmentList.size();j++)
				{
					if(departmentList.get(j).DeptID.equals(dsdList.get(i).DeptID))
					{
						System.out.printf("%-12s %-15s %-15s %-15s %-15s\n", departmentList.get(j).DeptID, departmentList.get(j).DeptName, departmentList.get(j).HeadName, departmentList.get(j).OfficeNo, departmentList.get(j).FacultyID);
					}
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	void diplayStudentAndDepartment()
	{
		System.out.println("Student table");
		ms.displayStudent();
		System.out.println("Department table");
		md.displayDepartment();
	}
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Enroll a student into a department");
			System.out.println("b. Remove a student from a department");
			System.out.println("c. Display all student study at given department");
			System.out.println("d. Diplay all department studied by given student");
			System.out.println("e. Diplay department and student table");
			System.out.println("f. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				enrollStudent();
				break;
			case 'b':
				removeStudentFromDepartment();
				break;
			case 'c':
				displayStudentGivenDepartment();
				break;
			case 'd':
				displayDepartmentByStudent();
				break;
			case 'e':
				diplayStudentAndDepartment();
				break;
			case 'f':
				running = false;
				break;
			}
		}

	}
}

