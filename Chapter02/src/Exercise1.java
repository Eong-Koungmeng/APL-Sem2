/*Group 17 Eong Koungmeng*/
class Rectangle
{
	float width=1, height=2;
	Rectangle()
	{
		
	}
	
	Rectangle(float width, float height)
	{
		this.width = width;
		this.height = height;
	}
	
	float getArea()
	{
		return width*height;
	}
	
	float getPerimeter()
	{
		return (width+height)*2;
	}
}


public class Exercise1
{
	public static void main(String[] args)
	{
		Rectangle rect1 = new Rectangle(4,40);
		Rectangle rect2 = new Rectangle(3.5f,35.7f);
		
		System.out.printf("Rectangle1: Width = %.2f, Height = %.2f, Area = %.2f, Perimeter = %.2f",rect1.width,rect1.height,rect1.getArea(),rect1.getPerimeter());
		System.out.println();
		System.out.printf("Rectangle2: Width = %.2f, Height = %.2f, Area = %.2f, Perimeter = %.2f",rect2.width,rect2.height,rect2.getArea(),rect2.getPerimeter());
		
	}
	
}
