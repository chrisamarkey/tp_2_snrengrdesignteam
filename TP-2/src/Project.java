//Chris Markey

import java.util.LinkedList;

public class Project 
{

	public String projectName;
	public LinkedList<String> newProject;
	public LinkedList<String> requiredMembers;
	public LinkedList<Student> actualMembers;

	public Project() {
		this.projectName = "projectName";
		this.requiredMembers = new LinkedList<>();
		this.actualMembers = new LinkedList<>();
	}

	public Project(String project, LinkedList<String> requiredMembers, LinkedList<Student> actualMembers) {
		this.projectName = project;
		this.requiredMembers = requiredMembers;
		this.actualMembers = actualMembers;
	}

	public static void main(String[] args) {
		String seniorProject1 = "Design a autonomous vehicle";
		String seniorProject2 = "Design a new drill bit to drill through the Bakken shale formation";
		String seniorProject3 = "Design a robot to act as a seeing eye dog";
		
		LinkedList<String> project1Degrees = new LinkedList<String>();
		project1Degrees.add("ME");
		project1Degrees.add("EE");
		project1Degrees.add("CE");
		LinkedList<String> project2Degrees = new LinkedList<String>();
		project2Degrees.add("PE");
		project2Degrees.add("SE");
		project2Degrees.add("CHE");
		LinkedList<String> project3Degrees = new LinkedList<String>();
		project3Degrees.add("MatlE");
		project3Degrees.add("CompE");
		project3Degrees.add("CompSci");
		
		LinkedList<Integer> student1Enemies = new LinkedList<Integer>();
		student1Enemies.add(222);
		student1Enemies.add(333);
		student1Enemies.add(444);
		Student student1 = new Student("Craig", 111, 4.0, "EE", student1Enemies);
//		Object[] array = student1.toArray();
//		System.out.println(student1); // Possibly a toString method would allow this information to be printed out.
		LinkedList<Integer> student2Enemies = new LinkedList<Integer>();
		student2Enemies.add(555);
		student2Enemies.add(666);
		student2Enemies.add(777);
		Student student2 = new Student("Andy", 111, 4.0, "CompE", student2Enemies);
		LinkedList<Integer> student3Enemies = new LinkedList<Integer>();
		student3Enemies.add(888);
		student3Enemies.add(999);
		student3Enemies.add(000);
		Student student3 = new Student("Chris", 111, 4.0, "ME", student3Enemies);
		
		LinkedList<Student> studentGroup1 = new LinkedList<Student>();
		studentGroup1.add(student1);
		studentGroup1.add(student2);
		studentGroup1.add(student3);
		
//		LinkedList<String> studentGroup1 = new LinkedList<String>();
//		studentGroup1.add("Craig");
//		studentGroup1.add("Andy");
//		studentGroup1.add("Chris");
		
		Project project1 = new Project(seniorProject1, project1Degrees, studentGroup1);
		
		System.out.println("Student1 name = " + student1.getStudentName(student1));
		System.out.println("Student1 id = " + student1.getStudentID(student1));
		System.out.println("Student1 major = " + student1.getStudentMajor(student1));
		System.out.println("Student1 enemy IDs = " + student1.getStudentEnemyIDs(student1));
		System.out.println("Student Group1" + studentGroup1);
		System.out.println("project1 = " + project1);
		System.out.println("seniorProject1 = " + seniorProject1);
		System.out.println("project1Degrees = " + project1Degrees);
		System.out.println("seniorProject2 = " + seniorProject2);
		System.out.println("projecct2Degrees = " + project2Degrees);
		System.out.println("seniorProject3 = " + seniorProject3);
		System.out.println("project3Degrees = " + project3Degrees);
	}
}

