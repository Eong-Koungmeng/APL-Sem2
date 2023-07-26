/*Group 17 Eong Koungmeng*/

import java.util.Scanner;

public class Exercise01
{
	public static void main(String[] args)
	{
		String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] dom = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter integer between 1 and 12: ");
		
		//Handling exceptions
		try
		{
			int inputNum = input.nextInt();
			System.out.println("The month is: " + months[inputNum-1] + ", number of days: " + dom[inputNum-1]);
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("wrong number");
		}
		finally
		{
			input.close();
		}
	}
}
