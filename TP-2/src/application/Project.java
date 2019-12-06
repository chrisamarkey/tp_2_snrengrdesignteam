//Chris Markey

package application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import org.apache.poi.ss.formula.functions.Countif.StringMatcher;

public class Project
{

	private String projectName;
	private int projectID;
	private int numInterested;
	private HashMap<String, Integer> requiredMembers;
	private LinkedList<Student> actualMembers;
	// get avgGPA

	public Project() {
		projectName = "";
		projectID = 0;
		numInterested = 0;
		requiredMembers = new HashMap<>();
		actualMembers = new LinkedList<>();
	}

	public Project(String name,
				   int ID,
				   int numInterested,
				   HashMap<String, Integer> required,
				   LinkedList<Student> actual) {
		this.projectName = name;
		this.projectID = ID;
		this.numInterested = numInterested; // Removed 12/5/19
		this.requiredMembers = required;
		this.actualMembers = actual;
	}
	
	
	public String getName() { // 12/4-19 Changed projectList to project
		return this.projectName;
	}

	public Integer getID() { // 12/4-19 Changed projectList to project
		return this.projectID;
	}

	public Integer getNumInterested() { // 12/4-19 Changed projectList to project
		return this.numInterested;
	}

	public void setNumInterested(Integer num) { // 12/4-19 Changed projectList to project
		this.numInterested = num;
	}
	
	public HashMap<String, Integer> getRequiredMembers() { // 12/4/19 Changed projectList to project
		return this.requiredMembers;
	}
	
	public void addRequiredMembers(String input, Integer requiredCount) { // Added 12/5/19
		Integer existingValue = requiredMembers.get(input);
		if (existingValue == null)
		{
			existingValue = 0;
		}
		
		this.requiredMembers.put(input, existingValue + requiredCount);
	}
	
	public void removeRequiredMembers(String input) { // Added 12/5/19
		this.requiredMembers.remove(input);
	}
	
	public LinkedList<Student> getActualMembers() { // 12/4/19 Changed projectList to project
		return this.actualMembers;
	}
	
	public void addActualMembers(Student student) { // Added 12/5/19
		this.actualMembers.add(student);
	}
	
	public void removeActualMembers(Student student) { // Added 12/5/19
		this.actualMembers.remove(student);
	}
	

	
	
	public static void main(String[] args) {
		
		LinkedList<Project> projList = new LinkedList<>();
		projList.add(new Project("project0", 0, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project1", 1, 0, new HashMap<>(), new LinkedList<Student>()));
		projList.add(new Project("project2", 2, 0, new HashMap<>(), new LinkedList<Student>()));

		projList.get(0).addRequiredMembers("Electrical Engineer", 1);
		projList.get(0).addRequiredMembers("Electrical Engineer", 1);
		projList.get(0).addRequiredMembers("Electrical Engineer", 2);
		projList.get(0).addRequiredMembers("Mechanical Engineer", 2);
		projList.get(0).addRequiredMembers("Civil Engineer", 1);

		projList.get(1).addRequiredMembers("Electrical Engineer", 2);
		projList.get(1).addRequiredMembers("Mechanical Engineer", 4);
		projList.get(1).addRequiredMembers("Civil Engineer", 3);

		projList.get(2).addRequiredMembers("Electrical Engineer", 2);
		projList.get(2).addRequiredMembers("Mechanical Engineer", 1);
		projList.get(2).addRequiredMembers("Civil Engineer", 2);
		
		LinkedList<Student> studentList = new LinkedList<>();
		
		studentList.add(new Student("EE0", 10, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		studentList.add(new Student("EE1", 11, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("EE2", 12, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("EE3", 13, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("EE4", 14, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("EE5", 15, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("EE6", 16, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("EE7", 17, 4.0, "Electrical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		
		studentList.add(new Student("ME0", 110, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("ME1", 111, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("ME2", 112, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("ME3", 113, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("ME4", 114, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("ME5", 115, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("ME6", 116, 4.0, "Mechanical Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		
		studentList.add(new Student("CE0", 1110, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("CE1", 1111, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("CE2", 1112, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("CE3", 1113, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("CE4", 1114, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));	
		studentList.add(new Student("CE5", 1115, 4.0, "Civil Engineer", "", "", new LinkedList<Integer>(), new LinkedList<String>()));
		
		for (Project project : projList)
		{
			for (Entry<String, Integer> entry : project.getRequiredMembers().entrySet()) {
			    System.out.println(entry.getKey() + " = " + entry.getValue());
			    for (int i = 0; i < entry.getValue(); i++)
			    {
			    	for (Student student : studentList)
					{
						if ((student.getAssignedProject().contentEquals("")) && (student.getMajor().equals(entry.getKey())))
						{
							System.out.println(project.getName());
							System.out.println(student.getName());
							project.addActualMembers(student);
							student.setAssignedProject(project.getName());
							break;
						}
					}
			    }
			}
		}
		
		for (Project project : projList)
		{
			System.out.println(project.getName());
			System.out.println(project.getActualMembers());
		}
//
//		LinkedList<Integer> student1Enemies = new LinkedList<Integer>();
//		student1Enemies.add(222);
//		student1Enemies.add(333);
//		student1Enemies.add(444);
//
//		LinkedList<String> s1PreferredProj = new LinkedList<String>(); //11-25-19 addition
//		s1PreferredProj.add("Design a autonomous vehicle");
//		s1PreferredProj.add("Design a new drill bit to drill through the Bakken shale formation");
//		s1PreferredProj.add("Design a robot to act as a seeing eye dog");
//		
//		// Student(String name, int id, double gpa, String major, LinkedList<Integer> enemyIDs, String favProject,
//		// LinkedList<String> preferredProjects, String assignedProject)
//		
//		Student student1 = new Student("Craig", 111, 4.0, "EE", student1Enemies, "favProject", s1PreferredProj, "");
////		Object[] array = student1.toArray()
////		System.out.println(student1); // Possibly a toString method would allow this information to be printed out.
//		LinkedList<Integer> student2Enemies = new LinkedList<Integer>();
//		student2Enemies.add(555);
//		student2Enemies.add(666);
//		student2Enemies.add(777);
//		
//		Student student2 = new Student("Andy", 111, 4.0, "CompE", student2Enemies, "favProject", s1PreferredProj, "");
//		LinkedList<Integer> student3Enemies = new LinkedList<Integer>();
//		student3Enemies.add(888);
//		student3Enemies.add(999);
//		student3Enemies.add(000);
//		Student student3 = new Student("Chris", 111, 4.0, "ME", student3Enemies, "favProject", s1PreferredProj, "");
//
//		LinkedList<Student> studentGroup1 = new LinkedList<Student>();
//		studentGroup1.add(student1);
//		studentGroup1.add(student2);
//		studentGroup1.add(student3);
//		
////		int project1_ID = 1111;
////		int numInterestedProj_1 = 5;
//		
//		// public Project(String project, LinkedList<String> requiredMembers, LinkedList<Student> actualMembers)
//		Project project1 = new Project(seniorProject1, project1Degrees, studentGroup1);
//
//		System.out.println("Student1 name = " + student1.getStudentName(student1));
//		System.out.println("Student1 id = " + student1.getStudentID(student1));
//		System.out.println("Student1 major = " + student1.getStudentMajor(student1));
//		System.out.println("Student1 enemy IDs = " + student1.getStudentEnemyIDs(student1));
//		System.out.println("Student Group1" + studentGroup1);
//		System.out.println("project1 = " + project1);
//		System.out.println("seniorProject1 = " + seniorProject1);
//		System.out.println("project1Degrees = " + project1Degrees);
//		System.out.println("seniorProject2 = " + seniorProject2);
//		System.out.println("projecct2Degrees = " + project2Degrees);
//		System.out.println("seniorProject3 = " + seniorProject3);
//		System.out.println("project3Degrees = " + project3Degrees);
	}
}