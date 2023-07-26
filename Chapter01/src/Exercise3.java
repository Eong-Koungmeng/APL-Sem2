/*Group 17 Eong Koungmeng*/
import java.util.HashMap;
import java.util.Scanner;

public class Exercise3
{
	public static void displayAllEmployees(HashMap<Integer, HashMap<String,String>> employees)
	{
		System.out.println("--------------------------------------------------");
		System.out.printf("%-8s %-15s %-13s %-13s\n", "ID", "Name", "Salary", "Department");
		System.out.println("--------------------------------------------------");
		
		for(int i = 1; i<= employees.keySet().size(); i++)
		{
			String name = employees.get(i).get("Name");
			String salary = employees.get(i).get("Salary");
			String department = employees.get(i).get("Department");
			System.out.printf("%-8s %-15s %-13s %-13s\n", i+"", name, salary, department);
		}
		System.out.println("--------------------------------------------------");
	}
	
	public static void addNewEmployee(HashMap<Integer, HashMap<String,String>> employees, Scanner input)
	{
		HashMap<String, String> newEmployee = new HashMap<>();
		System.out.print("Enter new employee name: ");
		newEmployee.put("Name", input.nextLine());
		System.out.print("Enter new employee salary: ");
		newEmployee.put("Salary", input.nextLine());
		System.out.print("Enter new employee department: ");
		newEmployee.put("Department", input.nextLine());
		
		employees.put(employees.keySet().size()+1, newEmployee);
		System.out.println("Added a new employee");
	}
	
	public static void deleteEmployeeByID(HashMap<Integer, HashMap<String,String>> employees, Scanner input)
	{
		int ID;
		while(true)
		{
			System.out.print("Enter employee ID to delete: ");
			ID = input.nextInt();
			input.nextLine();
			if(employees.containsKey(ID))
			{
				for(int i = ID; i< employees.keySet().size(); i++)
				{
					employees.replace(i, employees.get(i+1));
				}
				
				employees.remove(employees.keySet().size());
				
				System.out.println("Deleted an employee");
				break;
			}
			System.out.println("Invalid ID");
		}
	}
	
	public static void updateEmployeeByID(HashMap<Integer, HashMap<String,String>> employees, Scanner input)
	{
		int ID;
		while(true)
		{
			System.out.print("Enter employee ID to update: ");
			ID = input.nextInt();
			input.nextLine();
			if(employees.containsKey(ID))
			{
				HashMap<String, String> updatedEmployee = new HashMap<>();
				System.out.print("Enter new employee name: ");
				updatedEmployee.put("Name", input.nextLine());
				System.out.print("Enter new employee salary: ");
				updatedEmployee.put("Salary", input.nextLine());
				System.out.print("Enter new employee department: ");
				updatedEmployee.put("Department", input.nextLine());
				
				employees.replace(ID, updatedEmployee);
				System.out.println("Updated an employee");
				break;
			}
			System.out.println("Invalid ID");
		}
	}
	
	public static void searchEmployeeByID(HashMap<Integer, HashMap<String,String>> employees, Scanner input)
	{
		int ID;
		
		System.out.print("Enter employee ID to search: ");
		ID = input.nextInt();
		input.nextLine();
		if (employees.containsKey(ID)) 
		{
			System.out.printf("ID: %s, Name: %s, Salary: %s, Department: %s\n", ID+"", employees.get(ID).get("Name"),employees.get(ID).get("Salary"),employees.get(ID).get("Department"));
			
		}
		else
		{
			System.out.printf("ID: %s not found\n", ID+"");
		}
		
	}
	
	public static void main(String[] args)
	{
		//create and initialize hashmaps
		HashMap<String,String> employee1 = new HashMap<>();
		employee1.put("Name","Chan Dara");
		employee1.put("Salary", "800");
		employee1.put("Department", "ITE");
		
		HashMap<String,String> employee2 = new HashMap<>();
		employee2.put("Name","Sok Sophea");
		employee2.put("Salary", "900");
		employee2.put("Department", "BioE");
		
		HashMap<String,String> employee3 = new HashMap<>();
		employee3.put("Name","Keo Tola");
		employee3.put("Salary", "500");
		employee3.put("Department", "TEE");
		
		HashMap<Integer, HashMap<String,String>> employees = new HashMap<>();
		employees.put(1, employee1);
		employees.put(2, employee2);
		employees.put(3, employee3);
		
		// ask user to input
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		while(!exit)
		{
			System.out.println("\n**************************");
			System.out.println("a. Display all employees");
			System.out.println("b. Add a new employee");
			System.out.println("c. Delete employee by id");
			System.out.println("d. Update employee by id");
			System.out.println("e. Search employee by id");
			System.out.println("f. Exit the program");
			System.out.println("**************************");
			System.out.print("Select a feature: ");
			
			char inputChar = input.nextLine().charAt(0);
			System.out.println();
			switch(inputChar)
			{
			case 'a':
				displayAllEmployees(employees);
				break;
			case 'b':
				addNewEmployee(employees, input);
				break;
			case 'c':
				deleteEmployeeByID(employees,input);
				break;
			case 'd':
				updateEmployeeByID(employees,input);
				break;
			case 'e':
				searchEmployeeByID(employees,input);
				break;
			case 'f':
				exit = true;
			}
		}
		input.close();
		System.out.println("Thank you!");
		
	}
}
