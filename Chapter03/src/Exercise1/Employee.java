package Exercise1;

class MyDate
{
	int day;
	int month;
	int year;
	
	MyDate(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
}

class Employee extends Person
{
	String office;
	float salary;
	MyDate dateHired;
	
	public String toString()
	{	
		return "Class name = Employee" + ", Person's name = " + name;
	}
}
