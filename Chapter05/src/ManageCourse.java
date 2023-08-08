import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManageCourse implements Program
{
	String fileName = "course.txt";
	ArrayList<Course> courseList = new ArrayList<>();
	boolean running = true;
	
	ManageCourse() throws IOException
	{
		loadCourseData();
	}
	
	//For loading data
	void loadCourseData() throws IOException
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
				Course course = new Course();
				course.CourseID = wordsArray[0];
				course.CourseName = wordsArray[1];
				course.Credit = wordsArray[2];
				course.Type = wordsArray[3];				
				courseList.add(course);
			}
		}
		reader.close();
	}
		
	void addNewCourse() throws IOException
	{
		//read input
		Course course = new Course();
		System.out.print("Enter course ID: ");
		course.CourseID = Main.input.nextLine();
		System.out.print("Enter course name: ");
		course.CourseName = Main.input.nextLine();
		System.out.print("Enter credit: ");
		course.Credit = Main.input.nextLine();
		System.out.print("Enter type: ");
		course.Type = Main.input.nextLine();
		
		//write to file
		FileWriter writer = new FileWriter(fileName,true);
		writer.write(course.CourseID + ',' + course.CourseName + ',' + course.Credit + ',' + course.Type +'\n');
		writer.close();
		
		//store new course
		courseList.add(course);
		System.out.println("Added a course");
	}
	
	int searchCourse()
	{
		System.out.print("Enter course id to find: ");
		String idToFind = Main.input.nextLine();
		
		for(int i = 0; i<courseList.size();i++)
		{
			// if found
			if(courseList.get(i).CourseID.equals(idToFind))
			{
				// print it
				System.out.println("------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s\n", 
						"CourseID", "CourseName", "Credit", "Type");
				System.out.println("------------------------------------------------------");
				System.out.printf("%-12s %-15s %-15s %-15s\n", 
						courseList.get(i).CourseID, courseList.get(i).CourseName, courseList.get(i).Credit, courseList.get(i).Type);
				System.out.println("------------------------------------------------------");
				return i;
			}
		}
		
		System.out.println("Search Not Found");
		return -1;
	}
	
	void updateCourse() throws IOException
	{
		System.out.print("Enter id to update: ");
		String idToUpdate = Main.input.nextLine();
		
		for(int i = 0; i<courseList.size();i++)
		{
			// if found
			if(courseList.get(i).CourseID.equals(idToUpdate))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				Course course = new Course();
				
				
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToUpdate))
					{
						course.CourseID = idToUpdate;
						System.out.print("Enter course name: ");
						course.CourseName = Main.input.nextLine();
						System.out.print("Enter credit: ");
						course.Credit = Main.input.nextLine();
						System.out.print("Enter type: ");
						course.Type = Main.input.nextLine();
						line = course.CourseID + ',' + course.CourseName + ',' + course.Credit + ',' + course.Type;
					}
					
					fileContent+=line+'\n';
				}
				reader.close();
				
				//write back to file
				FileWriter writer = new FileWriter(fileName);
				writer.write(fileContent);
				writer.close();
				
				courseList.set(i, course);
				
				System.out.println("Updated a course");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void deleteCourse() throws IOException
	{
		System.out.print("Enter id to delete: ");
		String idToDelete = Main.input.nextLine();
		
		for(int i = 0; i<courseList.size();i++)
		{
			// if found
			if(courseList.get(i).CourseID.equals(idToDelete))
			{
				// store file content in variable
				String fileContent = "";
				String line;
				
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				//ignore course
				while((line=reader.readLine())!=null)
				{
					if(line.split(",")[0].equals(idToDelete))
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
				
				courseList.remove(i);
				
				System.out.println("Deleted a course");
				return;
			}
		}
		System.out.println("ID not Found");
	}
	
	void displayCourse()
	{
		System.out.println("------------------------------------------------------");
		System.out.printf("%-12s %-15s %-15s %-15s\n", 
				"CourseID", "CourseName", "Credit", "Type");
		System.out.println("------------------------------------------------------");
		
		for(int i = 0; i <courseList.size();i++)
		{
			System.out.printf("%-12s %-15s %-15s %-15s\n", 
					courseList.get(i).CourseID, courseList.get(i).CourseName, courseList.get(i).Credit, courseList.get(i).Type);
		}
		System.out.println("------------------------------------------------------");
	}
	
	
	public void Update() throws IOException
	{
		while(running)
		{
			System.out.println("\na. Add a new course");
			System.out.println("b. Search course by id");
			System.out.println("c. Update a course");
			System.out.println("d. Delete a course by id");
			System.out.println("e. Display all courses");
			System.out.println("f. Exit the program");
			System.out.print("Enter a feature: ");
			char inputChar = Main.input.nextLine().charAt(0);
			
			switch(inputChar)
			{
			case 'a':
				addNewCourse();
				break;
			case 'b':
				searchCourse();
				break;
			case 'c':
				updateCourse();
				break;
			case 'd':
				deleteCourse();
				break;
			case 'e':
				displayCourse();
				break;
			case 'f':
				running = false;
				break;
			}
	
			
		}
	}
}
