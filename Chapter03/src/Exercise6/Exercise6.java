/*Group 17 Eong Koungmeng*/
package Exercise6;

public class Exercise6
{
	public static void main(String[] args)
	{
		Employee employee = new Employee("Koungmeng",19, 'M', 1, "CEO", 30000000);
		employee.displayInfo();
		
		Customer customer = new Customer("John", 21, 'F', 4, "Phnom Penh", "012345678");
		customer.displayInfo();
	}
}
