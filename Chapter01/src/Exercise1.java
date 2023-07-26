/*Group 17 Eong Koungmeng*/
import java.util.HashMap;
import java.util.Scanner;

public class Exercise1
{
	public static void main(String[] args)
	{
		int correctCount = 0;
		Scanner input = new Scanner(System.in);
		
		// hashmap number and country name
		HashMap<Integer, String> numToCountry = new HashMap<>() {{
			put(0, "Cambodia");
			put(1, "Philippines");
			put(2, "Vietnam");
			put(3, "Thailand");
			put(4, "Japan");
			put(5, "China");
			put(6, "Australia");
			put(7, "England");
			put(8, "Malaysia");
			put(9, "Singapore");
		}};
		
		//hashmap country name to city name
		HashMap<String, String> countryToCity = new HashMap<>() {{
			put("Cambodia","Phnom Penh");
			put("Philippines","Manila");
			put("Vietnam","Hanoi");
			put("Thailand","Bangkok");
			put("Japan","Tokyo");
			put("China","Beijing");
			put("Australia","Canberra");
			put("England","London");
			put("Malaysia","Kuala Lampur");
			put("Singapore","Singapore");
		}};
		
		for(int count = 0; count < 10; count++)
		{
			int rand = (int)(Math.random()*(10-count));
			String country = numToCountry.get(rand);
			String city = countryToCity.get(country);
			System.out.print("What is the capital of " + country + "? ");
			
			String cityInput = input.nextLine();
			
			// if user guess correctly or not
			if(cityInput.compareToIgnoreCase(city) == 0)
			{
				System.out.println("Your answer is correct");
				correctCount++;
			}
			else
			{
				System.out.println("The correct answer should be " + city);
			}
			
			//remove the country from the hashmap after finish with question
			countryToCity.remove(country);
			
			//shift the number back to maintain ordinality 
			while(numToCountry.containsKey(rand+1))
			{
				numToCountry.replace(rand, numToCountry.get(rand+1));
				rand++;
			}
			numToCountry.remove(rand);
		}
		input.close();
		System.out.println("The correct count is " + correctCount);
	}
}
