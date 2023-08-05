package Exercise2;

class GradStudent extends Student
{

	GradStudent(String name, String department, float GPA)
	{
		super(name, department, GPA);
	}

	@Override
	void takeExam()
	{
		System.out.println("Giving written papers");
		
	}

}
