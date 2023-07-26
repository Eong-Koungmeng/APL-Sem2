/*Group 17 Eong Koungmeng*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Score
{
	int math_score;
	int phy_score;
	int chem_score;
	
	Score()
	{
		
	}
	
	Score(int math, int phy, int chem)
	{
		math_score = math;
		phy_score = phy;
		chem_score = chem;
	}
	
	int getTotal()
	{
		return math_score + phy_score + chem_score;
	}
}

class Student
{
	int id;
	String name;
	Score score;
	
	Student()
	{
		score = new Score();
	}
	
	Student(int id, String name, Score score)
	{
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	void readStudent(Scanner input)
	{
		System.out.print("Enter id: ");
		id = input.nextInt();
		input.nextLine();
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter math, physics, and chemistry scores seperated by a space: ");
		score.math_score = Integer.parseInt(input.next());
		score.phy_score = Integer.parseInt(input.next());
		score.chem_score = Integer.parseInt(input.next());
		input.nextLine();
	
	}
}

public class Exercise4
{
	public static void main(String[] args)
	{
		HashMap<Integer, Student> students = new HashMap<>();
		students.put(1, new Student(1,"Lucy", new Score(50,30,70)));
		students.put(2, new Student(2,"John", new Score(60,40,80)));
		students.put(3, new Student(3,"Alex", new Score(70,50,90)));
		
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		while(!exit)
		{
			System.out.println("\n**************************");
			System.out.println("a. Add a new student");
			System.out.println("b. Delete student by id");
			System.out.println("c. Search student by id");
			System.out.println("d. Display all students");
			System.out.println("e. Exit the program");
			System.out.println("**************************");
			System.out.print("Select a feature: ");
			
			char inputChar = input.nextLine().charAt(0);
			System.out.println();
			switch(inputChar)
			{
			case 'a':
				addNewStudent(students,input);
				break;
			case 'b':
				deleteStudentByID(students,input);
				break;
			case 'c':
				searchStudentByID(students,input);
				break;
			case 'd':
				displayAllStudents(students);
				break;
			case 'e':
				exit = true;
				break;
			}
		}
		input.close();
		System.out.println("Thank you!");
	}

	private static void displayAllStudents(HashMap<Integer, Student> students)
	{
		System.out.println("---------------------------------------------------------------------");
		System.out.printf("%-5s %-15s %-13s %-13s %-13s %-13s\n", "ID", "Name", "Math", "Physics", "Chemistry", "Total");
		System.out.println("---------------------------------------------------------------------");
		
		ArrayList<Integer> keys = new ArrayList<>(students.keySet());
		Collections.sort(keys);
		
		for(int i: keys)
		{
			String name = students.get(i).name;
			String math = students.get(i).score.math_score+"";
			String physics = students.get(i).score.phy_score+"";
			String chemistry = students.get(i).score.chem_score+"";
			String total = students.get(i).score.getTotal()+"";
			System.out.printf("%-5s %-15s %-13s %-13s %-13s %-13s\n", i+"", name, math, physics, chemistry, total);
		}
		System.out.println("---------------------------------------------------------------------");
		
	}

	private static void searchStudentByID(HashMap<Integer, Student> students, Scanner input)
	{
		int ID;
		
		System.out.print("Enter student ID to search: ");
		ID = input.nextInt();
		input.nextLine();
		if (students.containsKey(ID)) 
		{
			String name = students.get(ID).name;
			String math = students.get(ID).score.math_score+"";
			String physics = students.get(ID).score.phy_score+"";
			String chemistry = students.get(ID).score.chem_score+"";
			String total = students.get(ID).score.getTotal()+"";
			System.out.println("---------------------------------------------------------------------");
			System.out.printf("%-5s %-15s %-13s %-13s %-13s %-13s\n", "ID", "Name", "Math", "Physics", "Chemistry", "Total");
			System.out.println("---------------------------------------------------------------------");
			System.out.printf("%-5s %-15s %-13s %-13s %-13s %-13s\n", ID+"", name, math, physics, chemistry, total);
			
		}
		else
		{
			System.out.println("Search Not Found");
		}
		
	}

	private static void deleteStudentByID(HashMap<Integer, Student> students, Scanner input)
	{
		int ID;
		while(true)
		{
			System.out.print("Enter student ID to delete: ");
			ID = input.nextInt();
			input.nextLine();
			if(students.containsKey(ID))
			{
				students.remove(ID);
				System.out.println("Deleted a student");
				break;
			}
			System.out.println("Invalid ID");
		}
	}

	private static void addNewStudent(HashMap<Integer, Student> students, Scanner input)
	{
		Student newStudent = new Student();
		newStudent.readStudent(input);
		
		students.put(newStudent.id, newStudent);
		System.out.println("Added a new student");
	}
}
