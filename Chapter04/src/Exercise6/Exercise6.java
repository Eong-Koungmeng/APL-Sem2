package Exercise6;
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
		
		
		
		System.out.println(id + name + gender + salary);
	}
}


public class Exercise6
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		Employee e = new Employee();
		e.readEmployee(input);
		
		
		input.close();
	}
}
