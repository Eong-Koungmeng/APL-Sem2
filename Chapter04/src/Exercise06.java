/*Group 17 Eong Koungmeng*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Employee
{
	String id;
	String name;
	char gender;
	float salary;
	
	void readEmployee(Scanner input)
	{
		System.out.print("Enter id: ");
		id = input.nextLine();
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter gender: ");
		gender = input.nextLine().charAt(0);
		System.out.print("Enter salary: ");
		salary = input.nextFloat();
		input.nextLine();
	}
	
	void addEmployee() throws IOException
	{
		FileWriter writer = new FileWriter("Employee.txt",true);
		writer.write(id + '\t' + name + '\t' + gender+ '\t' + salary+'\n');
		writer.close();
	}
	
	void deleteEmployee() throws IOException
	{
		String fileContent = "";
		String line;
		//String employeeStr = id + '\t' + name + '\t' + gender+ '\t' + salary;
		BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"));
		
		//ignore employee
		while((line=reader.readLine())!=null)
		{
			if(line.split("\t")[0].equals(id))
			{
				continue;
			}
			
			fileContent+=line+'\n';
		}
		reader.close();
		
		//write back to file
		FileWriter writer = new FileWriter("Employee.txt");
		writer.write(fileContent);
		writer.close();
	}
	
}

public class Exercise06
{
	
	static void loadEmployeeData(ArrayList<Employee> employeeList) throws IOException
	{
		// if cant find file then create empty file
		File file = new File("Employee.txt");
		if(!file.exists())
		{
			file.createNewFile();			
		}

		BufferedReader reader = new BufferedReader(new FileReader("Employee.txt"));
		String line;
		String[] wordsArray;

		while((line=reader.readLine())!=null)
		{
			if(!line.equals("\n"))
			{
				wordsArray = line.split("\t");
				Employee em = new Employee();
				em.id = wordsArray[0];
				em.name = wordsArray[1];
				em.gender = wordsArray[2].charAt(0);
				em.salary = Float.parseFloat(wordsArray[3]);
				
				employeeList.add(em);
			}
		}
		reader.close();
	}
	
	static void addNewEmployee(ArrayList<Employee> employeeList, Scanner input) throws IOException
	{
		Employee newEmployee = new Employee();
		newEmployee.readEmployee(input);
		newEmployee.addEmployee();
		employeeList.add(newEmployee);
		System.out.println("Added an employee");
	}
	
	
	static void deleteEmployeeByID(ArrayList<Employee> employeeList, Scanner input) throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = input.nextLine();
		
		for(int i = 0; i<employeeList.size();i++)
		{
			// if found
			if(employeeList.get(i).id.equals(idToDelete))
			{
				// delete it
				employeeList.get(i).deleteEmployee();
				employeeList.remove(i);
				
				System.out.println("Deleted an employee");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	
	static void searchEmployeeByID(ArrayList<Employee> employeeList, Scanner input)
	{
		
		System.out.print("Enter id to find: ");
		String idToFind = input.nextLine();
		
		for(int i = 0; i<employeeList.size();i++)
		{
			// if found
			if(employeeList.get(i).id.equals(idToFind))
			{
				// print it
				System.out.println("----------------------------------------------");
				System.out.printf("%-8s %-17s %-10s %-13s\n", "ID", "Name", "Gender", "Salary");
				System.out.println("----------------------------------------------");
				System.out.printf("%-8s %-17s %-10s %-13s\n", employeeList.get(i).id, employeeList.get(i).name, employeeList.get(i).gender, employeeList.get(i).salary+"");
				System.out.println("----------------------------------------------");
				
				return;
			}
		}
		
		System.out.println("Search Not Found");
	}
	
	static void displayAllEmployee(ArrayList<Employee> employeeList)
	{
		System.out.println("----------------------------------------------");
		System.out.printf("%-8s %-17s %-10s %-13s\n", "ID", "Name", "Gender", "Salary");
		System.out.println("----------------------------------------------");
		
		for(int i = 0; i <employeeList.size();i++)
		{
			String id = employeeList.get(i).id;
			String name = employeeList.get(i).name;
			char gender = employeeList.get(i).gender;
			float salary = employeeList.get(i).salary;
			System.out.printf("%-8s %-17s %-10s %-13s\n", id, name, gender, salary+"");
		}
		System.out.println("----------------------------------------------");
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		loadEmployeeData(employeeList);
		
		boolean running = true;
		
		
		while(running)
		{
			System.out.println("\na. Add a new employee");
			System.out.println("b. Delete employee by id");
			System.out.println("c. Search employee by id");
			System.out.println("d. Display all employee");
			System.out.println("e. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewEmployee(employeeList,input);
				break;
			case 'b':
				deleteEmployeeByID(employeeList,input);
				break;
			case 'c':
				searchEmployeeByID(employeeList,input);
				break;
			case 'd':
				displayAllEmployee(employeeList);
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
