package application;

import java.util.*;
import java.util.Map.Entry;

public class TeamBuilder {
	
	LinkedList<Project> projectList;
	LinkedList<Student> studentList;
	
	enum TeamBuildingState
	{
		eInit,
		eHighPriorityDecisions,
		eFillByPreference,
		eSimpleVersion,
		eFixProblems,
		eCleanUp
	}
	
	TeamBuildingState teamBuildingState;
	
	public TeamBuilder(LinkedList<Project> projects, LinkedList<Student> students)
	{
		projectList = projects;
		studentList = students;
		teamBuildingState = TeamBuildingState.eInit;
	}
	
	public void buildTeams()
	{
		while (true)
		{
			switch (teamBuildingState)
			{
				default:
				case eInit:
				{
					// initialize things
					
					for (Project project : projectList)
					{
						project.setNumInterested(0);
						int tempCount = 0;
						
						for (Student student : studentList)
						{
							for (String string : student.getPreferredProjects())
							{
								if (string.equals(project.getName()))
								{
									tempCount++;
								}
							}
						}
						
						project.setNumInterested(tempCount);
					}
					
//					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eHighPriorityDecisions;
					break;
				}
				
				case eHighPriorityDecisions:
				{
					// do the important things
//					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eFillByPreference;
					break;
				}
				
				case eFillByPreference:	// takes popularity of projects and student project preference into account
				{
					// re-sort the projects by reverse popularity
					Collections.sort(projectList, new Comparator<Project>() {
					    @Override
					    public int compare(Project o1, Project o2) {
					        return o2.getNumInterested() - o1.getNumInterested();
					    }
					});
					
					Collections.reverse(projectList);
					
					teamBuildAlgorithm(studentList, projectList, true);
					
					teamBuildingState = TeamBuildingState.eSimpleVersion;
					break;
				}
				
				case eSimpleVersion:	// sorts remaining students & projects that weren't done during any previous step
				{
					teamBuildAlgorithm(studentList, projectList, false);
//					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eFixProblems;
					break;
				}
				
				case eFixProblems:
				{
					// try and fix teams that aren't following the rules
//					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eCleanUp;
					break;
				}
				
				case eCleanUp:
				{
					for (Project project : projectList)
					{
						System.out.println(project.getName());
						System.out.println(project.getActualMembers());
					}
					return;
				}
			}
		}
	}
	
	private void teamBuildAlgorithm(LinkedList<Student> stuList, LinkedList<Project> projList, boolean preferenceRestriction)
	{
		for (Project project : projectList)	// iterate through project list
		{
			LinkedList<Integer> currentEnemies = new LinkedList<>(); // enemies of current project's students
			
			for (Entry<String, Integer> entry : project.getRequiredMembers().entrySet())	// iterate through individual project's required member list
			{
				int currentCount = 0;
				
				for (Student student : project.getActualMembers())	// first check for existing students in this project's major
				{
					if (student.getMajor().equals(entry.getKey()))
					{
						currentCount++;
					}
				}
				
				
			    for (int i = 0; i < entry.getValue() - currentCount; i++)	// fill in required count of student type
			    {
			    	for (Student student : studentList) // search for an available student
					{
						if (
							(student.getAssignedProject().contentEquals("")) &&	   	// if available
							((preferenceRestriction == false) || (checkStudentProjectPreferenceMatch(student, project) == true)) &&	   		// and student prefers this project
							(checkForEnemies(student, project) == false) &&	   		// and no enemies
							(student.getMajor().equals(entry.getKey()))			   	// and correct major
						   )
						{
							for (Integer integer : student.getEnemyIDs())	// add this student's enemies to the project's list of enemies
							{
								currentEnemies.add(integer);
							}
							project.addActualMembers(student);				// add student to project
							student.setAssignedProject(project.getName());	// assign project to student
							break;
						}
					}
			    }
			}
		}
	}
		
	private boolean checkStudentProjectPreferenceMatch(Student student, Project project)
	{
		for (String preference : student.getPreferredProjects())
		{
			if (project.getName().equals(preference))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkForEnemies(Student student, Project project)
	{
		
		for (Student existingStudent : project.getActualMembers()) // check if existing students dont like the new student
		{
			for (Integer value : existingStudent.getEnemyIDs())
			{
				if (student.getID() == value)
				{
					return true;
				}
			}
		}
		
		for (Integer value : student.getEnemyIDs()) // check if new student doesnt like the existing students
		{
			for (Student existingStudent : project.getActualMembers())
			{
				if (existingStudent.getID() == value)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{	
		TeamBuilder teamBuilder = new TeamBuilder(SampleData.getProjects(), SampleData.getStudents());
		
		teamBuilder.buildTeams();
	}

//	public LinkedList<Student> studentList;
//	public LinkedList<Project> projectList;
//	public String favProject;
//	public Student student;
//	public Project project;
//
////	1. Sequentially search StudentList for project priorities one at a time. 
////	   Assign Student to the priority project if it is available for that major as long as their enemy is not assigned to that project.
////	   Continue through StudentList until complete.
////	   Save the Student ID for the assigned Student in an array.
////	   int[] intArray = new int[20];
//
//	public TeamBuilder(LinkedList<Student> studentList, LinkedList<Project> projectList) {
//		this.studentList = studentList;
//		this.projectList = projectList;
//	}

//	public void assignFavProject(LinkedList<Student> studentList, LinkedList<Project> projectList) {
//		for (int i = 0; i < studentList.size(); i++) {
//			student = studentList.get(i);
//			favProject = student.getFavProject(student);
//
//			for (int j = 0; j < projectList.size(); j++) {
//				project = projectList.get(j);
//
//				for (int k = 0; j < project.getRequiredMembers(project).size(); k++) {
//
//					if (favProject == project.getProjectName(project)
//							& project.getToBeAssignedMembers(project).get(k) == student.getStudentMajor(student)
//							& checkForEnemies(student, project) == false) {
//						// set project for student
//						student.setAssignedProject(project.getProjectName(project)); // 12/5/19
//						// remove major from project's requiredMembers List so that no other student can
//						// be assigned to that project's role
//						project.removeToBeAssignedMembers(student); // 12/5/19
//						// set student for project
//						project.setRequiredMembers(student);
//					}
//				}
//			}
//		}
//	}
//
//	public boolean checkForEnemies(Student student, Project project) {
//		this.student = student;
//		this.project = project;
//		for (int i = 0; i < student.getStudentEnemyIDs(student).size(); i++) {
//			for (int j = 0; j < project.getActualMembers(project).size(); j++) {
//				if (student.getStudentID(student) == project.getActualMembers(project).get(i).getStudentID(student)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
////	2. Next. compile StudentList preferred projects to count # of Student who prefer particular projects.
////	   Store the Student choices per project ID. 
////	   Randomly select students and assign each student one at a time to their preferred project based on the least popular project
////	     that does not have their enemy assigned to it and has an open slot for their major.
////	   Continue through StudentList until complete.
//
////3. Calculate each projects' students' average GPA. 
////	   Calculate the average and standard deviation of all projects' students GPAs.
////  Report this data for manual adjustments.
//
////4. List the students who could not be assigned since their were no open project slots for their major. 
////	   **Non-happy path** Probably skip this step at first.
//
//	public static void main(String[] args) {
////		Student(String name, int id, double gpa, String major, LinkedList<Integer> enemyIDs, String favProject, LinkedList<String> preferredProjects, String assignedProject)
//		Student student1 = new Student("student1", 1111, 4.0, "ME", new LinkedList<Integer>(), "Shuttle", new LinkedList<String>(), "");
////		Project(String project, LinkedList<String> requiredMembers, LinkedList<Student> actualMembers)
////		Project project1 = new Project(seniorProject1, project1Degrees, studentGroup1);
//		Project project1 = new Project("Shuttle", new LinkedList<String>(), new LinkedList<Student>());
//		LinkedList<Student> studentList = new LinkedList<Student>();
//		studentList.add(student1);
//		LinkedList<Project> projectList = new LinkedList<Project>();
//		projectList.add(project1);
//
//		TeamBuilder team1 = new TeamBuilder(studentList, projectList);
//		team1.assignFavProject(studentList, projectList);
//	}
}