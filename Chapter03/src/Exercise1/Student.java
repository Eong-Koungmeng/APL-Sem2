package Exercise1;

class Student extends Person
{
	private String classStatus;
	Student(String classStatus)
	{
		this.classStatus = classStatus;
	}
	
	public String toString()
	{	
		return "Class name = Student" + ", Person's name = " + name;
	}
	
}
