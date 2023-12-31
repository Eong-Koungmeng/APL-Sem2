import java.io.IOException;
import java.util.Scanner;

public class Main
{
	static Scanner input;
	public static void main(String[] args) throws IOException
	{
		input = new Scanner(System.in);
		boolean running = true;
		
		while(running)
		{
			Program[] programList = {new ManageFaculty(), new ManageDepartment(), new ManageStudent(), new EnrollStudent(), 
					new ManageCourse(), new ManageTeacher(), new AssignCourseToTeacher(), new CreateAccount(), new Login()};
			
			System.out.println("\nMenu\n1. Manage Faculties");
			System.out.println("2. Manage Departments");
			System.out.println("3. Manage Students");
			System.out.println("4. Enroll Students into Departments");
			System.out.println("5. Manage Courses");
			System.out.println("6. Manage Teachers");
			System.out.println("7. Assign Courses to Teachers");
			System.out.println("8. Create Teacher and Student Account");
			System.out.println("9. Login");
			System.out.println("10. Exit");
			
			System.out.print("Enter a feature: ");
			int inputInt = input.nextInt()-1;
			input.nextLine();
			
			if(inputInt == 9)
			{
				running = false;
			}
			else
			{
				programList[inputInt].Update();
			}

		}
		input.close();
		System.out.println("Thank You.");
	}
}
