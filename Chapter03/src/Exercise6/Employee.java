package Exercise6;

class Employee extends Person
{
	int employeeID;
	String jobTitle;
	int salary;
	
	Employee(String name, int age, char gender, int employeeID, String jobTitle, int salary)
	{
		super(name, age, gender);
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
	
	void displayInfo()
	{
		System.out.println("Name: " + name + ", age: " + age + ", Gender: " + gender + ", EmployeeID: " + employeeID + ", Job Title: "+ jobTitle + ", Salary: " + salary);
	}
}
