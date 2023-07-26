package Exercise5;

import java.util.Scanner;
import java.io.FileReader;

public class Exercise5
{
	public static void main(String[] args)
	{
		int[] eachLetterCount = new int[26];
		
		//initialize
		for(int i = 0; i < eachLetterCount.length; i++)
			eachLetterCount[i] = 0;
		
		System.out.print("Enter a filename: ");
		Scanner input = new Scanner(System.in);
		
		String fileName = input.nextLine();
		
		try
		{
			FileReader reader = new FileReader(fileName); 
			
			int i;
			// read each line and increment count if meet each letter
			while((i=reader.read())!=-1)
			{
				if(Character.isLetter((char)i))
				{
					int index = Character.toLowerCase(i)-'a';
					eachLetterCount[index]++;
				}
			}
			
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//print out the result
		for(int i = 0; i<26; i++)
		{
			System.out.println("The Number of " + (char)('A'+i)+"s" + ": " + eachLetterCount[i]);
		}
		
	}
}
