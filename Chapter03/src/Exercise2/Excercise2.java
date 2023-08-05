/*Group 17 Eong Koungmeng*/
package Exercise2;

public class Excercise2
{
	public static void main(String[] args)
	{
		PhdStudent phdStudent = new PhdStudent("Tola", "ITE", 2.5f);
		GradStudent gradStudent = new GradStudent("Sokha", "TEE", 4.0f);
		
		System.out.print("PhdStudent taking exam: ");
		phdStudent.takeExam();
		
		System.out.print("GradStudent taking exam: ");
		gradStudent.takeExam();
	}
}
