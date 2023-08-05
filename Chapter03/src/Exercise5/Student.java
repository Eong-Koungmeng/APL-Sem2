package Exercise5;

import java.util.ArrayList;

class Student
{
	private String name;
	private int ID;
	private ArrayList<String> classesTaken;
	private ArrayList<Integer> grades;
	
	Student(String name, int ID)
	{
		this.name = name;
		this.ID = ID;
		classesTaken = new ArrayList<>();
		grades = new ArrayList<>();
	}
	
	void addClass(String className, int grade)
	{
		classesTaken.add(className);
		grades.add(grade);
	}
	
	void dropClass(String className)
	{
		if(classesTaken.contains(className))
		{
			int index = classesTaken.indexOf(className);
			classesTaken.remove(index);
			grades.remove(index);
		}
	}
	
	void displayInfo()
	{
		System.out.println("Name: " + name + ", ID: " + ID + ", Classes Taken: " + classesTaken + ", Grades: " + grades);
	}
	
	float getGPA()
	{
		float total = 0;
		for(int grade: grades)
		{
			total += grade;
		}
		
		return (total/grades.size())/25;
	}
}
