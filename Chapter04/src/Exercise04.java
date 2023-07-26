/*Group 17 Eong Koungmeng*/


import java.io.FileReader;

public class Exercise04
{
	public static void main(String[] args)
	{
		String fileName = "file.txt";
		
		int charactersCount = 0;
		int wordsCount = 0;
		int linesCount = 1;
		
		try 
		{
			FileReader reader = new FileReader(fileName);
			int i;
			while((i = reader.read())!=-1)
			{
				if(!Character.isWhitespace((char)i))
				{
					charactersCount++;
				}
				
				if(Character.isWhitespace((char)i))
				{
					wordsCount++;
				}
				
				if((char)i == '\n')
				{
					linesCount++;
				}
				
			}
			
			reader.close();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Number of characters: "+charactersCount);
		System.out.println("Number of words: " + wordsCount);
		System.out.println("Number of lines: " + linesCount);
	}
}
