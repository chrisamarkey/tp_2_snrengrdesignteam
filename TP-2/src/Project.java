import java.util.LinkedList;

public class Project 
{

	public String project;
	public LinkedList<String> projectName;
//	Isn't requiredMembers actually the required students with particular degrees?
	public LinkedList<String> requiredMembers;
//	Isn't this the required degrees per project?	
	public LinkedList<String> actualMembers;

	public Project() {
		this.project = "project";
		this.requiredMembers = new LinkedList<>();
		this.actualMembers = new LinkedList<>();
	}

	public Project(String project, LinkedList<String> requiredMembers, LinkedList<String> actualMembers) {
		this.project = project;
		this.requiredMembers = requiredMembers;
		this.actualMembers = actualMembers;
	}

	public void addProject (String project, LinkedList<String> projectName) {
		projectName.add(project);
	}

	public void removeProject(String project) {
		for (int i = 0; i < projectName.size(); i++) {
			if (project == projectName.get(i)) {
				projectName.remove(i);
				break;
			}
		}
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
		
		
		LinkedList<String> studentGroup1 = new LinkedList<String>();
		studentGroup1.add("Craig");
		studentGroup1.add("Andy");
		studentGroup1.add("Chris");
		LinkedList<String> studentGroup2 = new LinkedList<String>();
		studentGroup2.add("Peter");
		studentGroup2.add("Paul");
		studentGroup2.add("Mary");
		LinkedList<String> studentGroup3 = new LinkedList<String>();
		studentGroup3.add("AC");
		studentGroup3.add("DC");
		
		Project project1 = new Project(seniorProject1, project1Degrees, studentGroup1);
//		Project project2 = new Project(seniorProject2, project2Degrees, studentGroup2);
//		Project project3 = new Project(seniorProject3, project3Degrees, studentGroup3);
		
//		project1.addProject (seniorProject1, project1Degrees);
//		project2.addProject (seniorProject2, project2Degrees);
//		project3.addProject (seniorProject3, project3Degrees);
		
		System.out.println(project1);
		System.out.println(seniorProject1);
		System.out.println(project1Degrees);
		System.out.println(seniorProject2);
		System.out.println(project2Degrees);
		System.out.println(seniorProject3);
		System.out.println(project3Degrees);
	}
}

