package Exercise7;

import java.util.HashMap;

class Library
{
	private HashMap<String,String> booksStatus;
	
	Library()
	{
		booksStatus = new HashMap<>();
	}
	
	void addBook(String book)
	{
		if(booksStatus.keySet().contains(book))
		{
			System.out.println(book + " is already exist");
		}
		else
		{
			System.out.println("Adding " + book);
			booksStatus.put(book, "Available");
		}
	}
	
	void removeBook(String book)
	{
		if(booksStatus.keySet().contains(book))
		{
			System.out.println("Removing " + book);
			booksStatus.remove(book);
		}
		else
		{
			System.out.println(book + " doesn't exist");
		}
	}
	
	void checkingOut(String book)
	{
		if(booksStatus.containsKey(book))
		{
			if(booksStatus.get(book).compareTo("Available")==0)
			{
				System.out.println("Checking out " + book);
				booksStatus.replace(book, "Unavailable");
			}
			else
			{
				System.out.println(book + " unavailable");
			}
		}
		else
		{
			System.out.println(book + " doesn't exist");
		}
	}
	
	void returnBook(String book)
	{
		if(booksStatus.containsKey(book))
		{
			if(booksStatus.get(book).compareTo("Unavailable")==0)
			{
				System.out.println("returning " + book);
				booksStatus.replace(book, "Available");
			}
			else
			{
				System.out.println(book + " is already returned");
			}
		}
		else
		{
			System.out.println(book + " doesn't exist");
		}
	}
	
	void displayReports()
	{
		System.out.println("All books:");
		for(String book: booksStatus.keySet())
		{
			System.out.println(book + ": " + booksStatus.get(book));
		}
	}
}
