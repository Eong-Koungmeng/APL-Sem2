/*Group 17 Eong Koungmeng*/


public class Exercise03
{
	public static boolean isHex(String str)
	{
		str = str.toLowerCase().trim();

		char c;
		int dotPosition = str.indexOf('.');
		for (int i = 0; i < str.length(); i++)
		{
			c = str.charAt(i);

			if (i == dotPosition)
			{
				continue;
			}

			if (!(c >= 'a' && c <= 'f' || Character.isDigit(c)))
			{
				return false;
			}

		}
		return true;
	}
	
	
	public static String hex2Binary(String hexString) throws NumberFormatException
	{
		hexString = hexString.trim().toUpperCase();
		
		if(!isHex(hexString))
		{
			throw new NumberFormatException("hexString must be a hexidecimal number");
		}
		
		String bin = "";
		String[] hexToBin = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
				"1011", "1100", "1101", "1110", "1111" };

		if (hexString.equals("0"))
		{
			return "0";
		}

		// convert each digit of hex to binary then append them together
		for (int i = 0; i < hexString.length(); i++)
		{
			char c = hexString.charAt(i);

			if (Character.isDigit(c))
			{
				bin += hexToBin[Character.getNumericValue(c)];
			}
			else if (c == '.')
			{
				bin += c;
			}
			else
			{
				bin += hexToBin[(int) (c - 'A' + 10)];
			}
		}

		// remove leading 0
		for (int i = 0; i < 3; i++)
		{
			if (bin.charAt(0) == '0')
			{
				bin = bin.substring(1);
			}
		}

		if (bin.indexOf(".") >= 0)
		{
			// remove leading trailing 0
			for (int i = 0; i < 3; i++)
			{
				if (bin.charAt(bin.length() - 1) == '0')
				{
					bin = bin.substring(0, bin.length() - 1);
				}
			}
		}
		
		return bin;
	}
	
	public static void main(String[] args)
	{
		String hex = "34eaf.281.a";
		try
		{
			System.out.println("Binary: "+hex2Binary(hex));			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
