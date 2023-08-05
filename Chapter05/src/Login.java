import java.io.IOException;
import java.util.ArrayList;

public class Login implements Program
{
	ArrayList<Account> accountList;
	ArrayList<Teacher> teacherList;
	ArrayList<Student> studentList;
	String accountID;
	
	Login() throws IOException
	{
		accountList = new CreateAccount().accountList;
		teacherList = new ManageTeacher().teacherList;
		studentList = new ManageStudent().studentList;
		accountID = "";
	}
		
	
	boolean loginSuccess(String username, String password)
	{
		for(int i = 0; i<accountList.size(); i++)
		{
			if(accountList.get(i).Username.equals(username) && accountList.get(i).Password.equals(password))
			{
				System.out.println("Login success");
				accountID = accountList.get(i).AccountID;
				return true;
			}
		}
		
		return false;
	}
	
	void displayTitle()
	{
		//check all teachers
		for(int i = 0; i <teacherList.size();i++)
		{
			if(teacherList.get(i).AccountID.equals(accountID))
			{
				System.out.println("Hi Teacher: " + teacherList.get(i).TeacherName);
			}
			
		}
		
		//check all students
		for(int i = 0; i<studentList.size(); i++)
		{
			if(studentList.get(i).AccountID.equals(accountID))
			{
				System.out.println("Hi Student: " + studentList.get(i).StudentName);
				return;
			}
		}
		
	}
	
	public void Update() throws IOException
	{
		System.out.print("Enter username: ");
		String username = Main.input.nextLine();
		System.out.print("Enter password: ");
		String password = Main.input.nextLine();
		
		if(loginSuccess(username,password))
		{
			displayTitle();
		}
		else
		{
			System.out.println("Incorrect username or password");
		}
		System.out.print("Enter to exit: ");
		Main.input.nextLine();
		
	}
	
}
