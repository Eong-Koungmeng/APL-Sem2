/*Group 17 Eong Koungmeng*/
package Exercise7;

public class Exercise7
{
	public static void main(String[] args)
	{
		Library library = new Library();
		library.addBook("It Starts With Us");
		library.addBook("False Love");
		library.addBook("Machida kun's World");
		library.addBook("JoJo Bizzarre Adventure");
		library.addBook("Grand Blue");
		library.addBook("Space Brothers");
		
		System.out.println();
		library.displayReports();
		
		System.out.println();
		library.checkingOut("False Love");
		library.checkingOut("Hello");
		library.checkingOut("False Love");
		
		System.out.println();
		library.displayReports();
		
		System.out.println();
		library.returnBook("False Love");
		library.returnBook("False Love");
		
		System.out.println();
		library.displayReports();
		
		System.out.println();
		library.removeBook("It Starts With Us");
		library.removeBook("Hi");
		library.removeBook("Grand Blue");
		
		System.out.println();
		library.displayReports();
		
		library.addBook("Solo Leveling");
		
		System.out.println();
		library.displayReports();
		
	}
}
