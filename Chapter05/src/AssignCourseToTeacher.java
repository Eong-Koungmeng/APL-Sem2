import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AssignCourseToTeacher implements Program
{
	ArrayList<TeacherDetail> teacherDetailList = new ArrayList<>();
	ManageTeacher mt = new ManageTeacher();
	ManageCourse mc = new ManageCourse();
	String fileName = "teacherDetail.txt";
	boolean running = true;
	
	AssignCourseToTeacher() throws IOException
	{
		loadTeacherDetailData();
	}
	
	//For loading data
	void loadTeacherDetailData() throws IOException
	{
		File file = new File(fileName);
		if(!file.exists())
		{
			file.createNewFile();			
		}

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		String[] wordsArray;

		//Read and split each line by comma
		while((line=reader.readLine())!=null)
		{
			if(!line.equals("\n"))
			{
				wordsArray = line.split(",");
				TeacherDetail teacherDetail = new TeacherDetail();
				teacherDetail.TeacherID= wordsArray[0];
				teacherDetail.CourseID = wordsArray[1];
				
				teacherDetailList.add(teacherDetail);
			}
		}
		reader.close();
	}
		
	void addNewCourseToTeacher() throws IOException
	{
		//read input
		TeacherDetail teacherDetail = new TeacherDetail();
		System.out.print("Enter teacher ID: ");
		teacherDetail.TeacherID = Main.input.nextLine();
		System.out.print("Enter course ID: ");
		teacherDetail.CourseID = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(teacherDetail.TeacherID + ',' + teacherDetail.CourseID + '\n');
		writer.close();
		
		//store new teacherDetail
		teacherDetailList.add(teacherDetail);
		System.out.println("Added a course to a teacher");
	}

	void removeCourseFromTeacher() throws IOException
	{
		System.out.print("Enter teacher ID: ");
		String idToDelete = Main.input.nextLine();
		System.out.print("Enter course ID to delete: ");
		String courseID = Main.input.nextLine();
		
		for(int i = 0; i<teacherDetailList.size();i++)
		{
			// if found
			if(teacherDetailList.get(i).TeacherID.equals(idToDelete) && teacherDetailList.get(i).CourseID.equals(courseID))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore faculty
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToDelete)&& line.split(",")[1].equals(courseID))
					{
						continue;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				teacherDetailList.remove(i);
				
				System.out.println("Removed a course from teacher");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayTeacherDetail()
	{
		System.out.println("Teacher table");
		mt.displayTeacher();
		System.out.println("Course table");
		mc.displayCourse();
	}
	
	void displayCourseByTeacher()
	{
		System.out.print("Enter teacher ID to display courses: ");
		String idToDisplay = Main.input.nextLine();
		String teacherName = "";
		
		ArrayList<Teacher> teachersList = mt.teacherList;
		ArrayList<Course> courseList = mc.courseList;

		for(int i = 0; i < teachersList.size();i++)
		{
			if(teachersList.get(i).TeacherID.equals(idToDisplay))
			{
				teacherName = teachersList.get(i).TeacherName;
			}
		}
		
		if(teacherName.equals(""))
		{
			System.out.println("Incorrect teacher ID");
			return;
		}
		
		
		System.out.println("Teacher " + teacherName + " teaches: ");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s\n", "CourseID", "CourseName", "Credit", "Type");
		System.out.println("-----------------------------------------------------------------------");
		
		for(int i = 0; i<teacherDetailList.size();i++)
		{
			if(teacherDetailList.get(i).TeacherID.equals(idToDisplay))
			{
				// print it
				for(int j = 0; j < courseList.size();j++)
				{
					if(courseList.get(j).CourseID.equals(teacherDetailList.get(i).CourseID))
					{
						System.out.printf("%-12s %-15s %-15s %-15s\n", courseList.get(j).CourseID, courseList.get(j).CourseName, courseList.get(j).Credit, courseList.get(j).Type);
					}
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	
	void displayTeacherCourseDetail()
	{
		System.out.println("----------------------");
		System.out.printf("%-12s %-18s\n", "TeacherID", "CourseID");
		System.out.println("----------------------");
		
		for(int i = 0; i <teacherDetailList.size();i++)
		{
			System.out.printf("%-12s %-18s\n", teacherDetailList.get(i).TeacherID, teacherDetailList.get(i).CourseID);
		}
		System.out.println("----------------------");
	}
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Assign teacher a course");
			System.out.println("b. Remove a course from a teacher");
			System.out.println("c. Display all courses taught by a teacher");
			System.out.println("d. Display teacher and course tables");
			System.out.println("e. Display teacher course detail");
			System.out.println("f. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewCourseToTeacher();
				break;
			case 'b':
				removeCourseFromTeacher();
				break;
			case 'c':
				displayCourseByTeacher();
				break;
			case 'd':
				displayTeacherDetail();
				break;
			case 'e':
				displayTeacherCourseDetail();
				break;
			case 'f':
				running = false;
				break;
			}
	
			
		}
	}
}
