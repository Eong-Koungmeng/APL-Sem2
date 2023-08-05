/*Group 17 Eong Koungmeng*/
import java.util.Scanner;

class Calculator
{
	float num1, num2;
	char operator;
	
	float add()
	{
		return num1 + num2;
	}
	
	float subtract()
	{
		return num1 - num2;
	}
	
	float multiply()
	{
		return num1 * num2;
	}
	
	float divide()
	{
		return num1 / num2;
	}
	
	float power()
	{
		return (float) Math.pow(num1, num2);
	}
	
	float modulo()
	{
		return num1 % num2;
	}
}

public class Exercise2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Calculator calc = new Calculator();
		System.out.print("Enter number1, operator and number2 seperated by a space: ");
		calc.num1 = input.nextFloat();
		calc.operator = input.next().charAt(0);
		calc.num2 = input.nextFloat();
		
		float result = 0;
		switch(calc.operator)
		{
		case '+':
			result = calc.add();
			break;
		case '-':
			result = calc.subtract();
			break;
		case '*':
			result = calc.multiply();
			break;
		case '/':
			result = calc.divide();
			break;
		case '^':
			result = calc.power();
			break;
		case '%':
			result = calc.modulo();
			break;
		}
		
		System.out.println(calc.num1 + " " + calc.operator + " " + calc.num2 + " = " + result);
		
		input.close();
	}
}
