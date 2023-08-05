package Exercise2;

abstract class Student
{
	String name;
	String department;
	float GPA;
	
	Student(String name, String department, float GPA)
	{
		this.name = name;
		this.department = department;
		this.GPA = GPA;
	}
	
	abstract void takeExam();
	
	
	void printInfo()
	{
		System.out.println("Name: " + name + ", department: " + department + ", GPA: " + GPA);
	}
	
	boolean isPass()
	{
		if(GPA>=2.0f)
			return true;
		return false;
	}
	
	void changeGPA(float gpa)
	{
		if(gpa >= 0 && gpa <= 4.0f)
		{
			GPA = gpa;
		}
	}
}