package Exercise2;

class PhdStudent extends Student
{
	PhdStudent(String name, String department, float GPA)
	{
		super(name,department,GPA);
	}
	
	@Override
	void takeExam()
	{
		System.out.println("Giving final defense presentation");
	}
}
