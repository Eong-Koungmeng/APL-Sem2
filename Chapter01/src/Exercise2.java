/*Group 17 Eong Koungmeng*/
import java.util.HashMap;

public class Exercise2
{
	public static void main(String[] args)
	{
		// initialize hashmaps and data entry
		HashMap<String, Integer> employee0 = new HashMap<>();
		employee0.put("Su", 2);
		employee0.put("M", 4);
		employee0.put("T", 3);
		employee0.put("W", 4);
		employee0.put("Th", 5);
		employee0.put("F", 8);
		employee0.put("Sa", 8);

		HashMap<String, Integer> employee1 = new HashMap<>();
		employee1.put("Su", 7);
		employee1.put("M", 3);
		employee1.put("T", 4);
		employee1.put("W", 3);
		employee1.put("Th", 3);
		employee1.put("F", 4);
		employee1.put("Sa", 4);

		HashMap<String, Integer> employee2 = new HashMap<>();
		employee2.put("Su", 3);
		employee2.put("M", 3);
		employee2.put("T", 4);
		employee2.put("W", 3);
		employee2.put("Th", 3);
		employee2.put("F", 2);
		employee2.put("Sa", 2);

		HashMap<String, Integer> employee3 = new HashMap<>();
		employee3.put("Su", 9);
		employee3.put("M", 3);
		employee3.put("T", 4);
		employee3.put("W", 7);
		employee3.put("Th", 3);
		employee3.put("F", 4);
		employee3.put("Sa", 1);

		HashMap<String, Integer> employee4 = new HashMap<>();
		employee4.put("Su", 3);
		employee4.put("M", 5);
		employee4.put("T", 4);
		employee4.put("W", 3);
		employee4.put("Th", 6);
		employee4.put("F", 3);
		employee4.put("Sa", 8);

		HashMap<String, Integer> employee5 = new HashMap<>();
		employee5.put("Su", 3);
		employee5.put("M", 4);
		employee5.put("T", 4);
		employee5.put("W", 6);
		employee5.put("Th", 3);
		employee5.put("F", 4);
		employee5.put("Sa", 4);

		HashMap<String, Integer> employee6 = new HashMap<>();
		employee6.put("Su", 3);
		employee6.put("M", 7);
		employee6.put("T", 4);
		employee6.put("W", 8);
		employee6.put("Th", 3);
		employee6.put("F", 8);
		employee6.put("Sa", 4);

		HashMap<String, Integer> employee7 = new HashMap<>();
		employee7.put("Su", 6);
		employee7.put("M", 3);
		employee7.put("T", 5);
		employee7.put("W", 9);
		employee7.put("Th", 2);
		employee7.put("F", 7);
		employee7.put("Sa", 9);

		HashMap<String, HashMap<String, Integer>> employees = new HashMap<>();
		employees.put("employee0", employee0);
		employees.put("employee1", employee1);
		employees.put("employee2", employee2);
		employees.put("employee3", employee3);
		employees.put("employee4", employee4);
		employees.put("employee5", employee5);
		employees.put("employee6", employee6);
		employees.put("employee7", employee7);

		// Calculate total hours
		HashMap<String, Integer> employeeTotalHours = new HashMap<>();
		for (int i = 0; i <= 7; i++) 
		{
			int sum = 0;
			for (int hour : employees.get("employee" + i).values()) 
			{
				sum += hour;
			}
			employeeTotalHours.put("employee" + i, sum);
		}

		String employeeID;
		int max;

		while (!employeeTotalHours.isEmpty()) 
		{

			//get first element of a set
			employeeID = employeeTotalHours.keySet().iterator().next();
			max = employeeTotalHours.get(employeeID);
			for (String employee : employeeTotalHours.keySet()) 
			{
				if(employeeTotalHours.get(employee)>max)
				{
					employeeID = employee;
					max = employeeTotalHours.get(employee);
				}
			}
			
			employeeTotalHours.remove(employeeID);
			System.out.println(employeeID + ": " + max + " total work hours.");
		}

	}
}
