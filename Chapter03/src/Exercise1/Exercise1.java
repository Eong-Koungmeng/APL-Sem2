/*Group 17 Eong Koungmeng*/
package Exercise1;

public class Exercise1 
{
	public static void main(String[] args)
	{
		Person person = new Person();
		person.name = "Meng";
		person.address = "Phnom Penh";
		person.emailAddress = "koungmeng@gmail.com";
		person.phoneNumber = "012345678";
		
		Student student = new Student("sophomore");
		student.name = "Stu Meng";
		student.address = "Siem Reap";
		student.emailAddress = "koung@gmail.com";
		student.phoneNumber = "012345678";
		
		Employee employee = new Employee();
		employee.name = "Emp Meng";
		employee.phoneNumber = "012345678";
		employee.address = "Kandal";
		employee.emailAddress = "empmeng@gmail.com";
		employee.dateHired = new MyDate(29,6,2023);
		employee.salary = 50000f;
		employee.office = "STEM 306";
		
		FacultyMember faculty = new FacultyMember();
		faculty.name = "Fa Meng";
		faculty.address = "Prey Veng";
		faculty.phoneNumber = "012345678";
		faculty.emailAddress = "fameng@gmail.com";
		faculty.officeHours = 40;
		faculty.position = "CEO";
		
		Staff staff = new Staff();
		staff.name = "St Meng";
		staff.address = "SR";
		staff.phoneNumber = "012345678";
		staff.emailAddress = "stmeng@gmail.com";
		staff.title = "DR.";
		
		System.out.println(person);
		System.out.println(student);
		System.out.println(employee);
		System.out.println(faculty);
		System.out.println(staff);
		
	}
}
