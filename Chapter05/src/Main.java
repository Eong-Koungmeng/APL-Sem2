import java.io.IOException;
import java.util.Scanner;

public class Main
{
	static Scanner input;
	public static void main(String[] args) throws IOException
	{
		Program[] programList = {new ManageFaculty()};
		input = new Scanner(System.in);
		boolean running = true;
		
		while(running)
		{
			System.out.println("\nMenu\n1. Manage Faculty");
			System.out.println("10. Exit");
			
			System.out.print("Enter a feature: ");
			int inputInt = input.nextInt()-1;
			input.nextLine();
			
			if(inputInt == 9)
			{
				running = false;
			}
			else
			{
				programList[inputInt].Update();
			}

		}
		input.close();
		System.out.println("Thank You.");
	}
}
