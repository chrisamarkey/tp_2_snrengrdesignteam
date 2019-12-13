package application;

import java.util.*;
import java.util.Map.Entry;

public class TeamBuilder {
	
	private LinkedList<Project> projectList;
	private LinkedList<Student> studentList;
	private double gpaLow;
	private double gpaHigh;
	private boolean gpaLeveling;
	
	enum TeamBuildingState
	{
		eInit,
		eFillByWeightedFavProj,
		eFillByPreference,
		eEveryoneElse,
		eGPAleveling,
		eCleanUp
	}
	
	TeamBuildingState teamBuildingState;
	
	public TeamBuilder(LinkedList<Project> projects, LinkedList<Student> students, double gpaLow, double gpaHigh, boolean gpaLeveling, boolean teamRandomization)
	{
		projectList = projects;
		studentList = students;
		if (teamRandomization == true)
		{
			Collections.shuffle(studentList); // this line removes determinism from the making of teams, it is pseudo-randomized here
		}
		this.gpaLow = gpaLow;
		this.gpaHigh = gpaHigh;
		this.gpaLeveling = gpaLeveling;
		teamBuildingState = TeamBuildingState.eInit;
	}
	
	public LinkedList<Student> getStudents()
	{
		return studentList;
	}
	
	public LinkedList<Project> getProjects()
	{
		return projectList;
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
					teamBuildingState = TeamBuildingState.eFillByWeightedFavProj;
					break;
				}
				
				case eFillByWeightedFavProj:
				{
					// do the stuff
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
					
					teamBuildingState = TeamBuildingState.eEveryoneElse;
					break;
				}
				
				case eEveryoneElse:	// sorts remaining students & projects that weren't done during any previous step
				{
					// re-sort the projects by popularity
					Collections.sort(projectList, new Comparator<Project>() {
					    @Override
					    public int compare(Project o1, Project o2) {
					        return o2.getNumInterested() - o1.getNumInterested();
					    }
					});
					
					teamBuildAlgorithm(studentList, projectList, false);
//					System.out.println(teamBuildingState);
					teamBuildingState = TeamBuildingState.eGPAleveling;
					break;
				}
				
				case eGPAleveling:
				{
					teamBuildingState = TeamBuildingState.eCleanUp;
					
					if (gpaLeveling == false)
					{
						break;
					}
					
					// this says that we will pass through the projects 10 times trying to level the gpas
					// during each pass, 1 student might change from each team out of gpa range
					// currently only looking at teams with too low gpa
					// a MAJOR problem with this is that students might be traded who now lost project preferences
					// the loop count is arbitrary, it's just X attempts at leveling teams (max 1 student per team per attempt)
					// there is no guarantee that all teams fit within the range, even if it is possible to do so
					for (int cycleCount = 0; cycleCount < 10; cycleCount++)
					{
						boolean aProjectIsOutOfGPArange = false;
						
						for (Project project : projectList)
						{
							if (project.getTeamGPA() < gpaLow)
							{
								aProjectIsOutOfGPArange = true;
							}
						}
						
						if (aProjectIsOutOfGPArange == false)	// we're done if no teams are out of range
						{
							break;
						}
						
						// re-sort the projects by reverse gpa, cuz the low gpa teams are the ones we really wanna fix
						Collections.sort(projectList, new Comparator<Project>() {
						    @Override
						    public int compare(Project o1, Project o2) {
						        return (int)((o2.getTeamGPA() * 100) - (o1.getTeamGPA() * 100));
						    }
						});
						
						Collections.reverse(projectList);
						
						// we only look at 1/2 the teams...we pick one low gpa team and one high gpa team to swap students
						for (int i = 0; i < projectList.size() / 2; i++)
						{
							if (projectList.get(i).getTeamGPA() < gpaLow)
							{
								int mirroredIndex = projectList.size() - i - 1;  // this represents a high gpa team we will trade students with
								
								// re-sort the actual members by reverse gpa of this low gpa team
								Collections.sort(projectList.get(i).getActualMembers(), new Comparator<Student>() {
								    @Override
								    public int compare(Student o1, Student o2) {
								        return (int)((o2.getGPA() * 100) - (o1.getGPA() * 100));
								    }
								});
								
								Collections.reverse(projectList.get(i).getActualMembers());
								
								// re-sort the actual members by gpa of this high gpa team
								Collections.sort(projectList.get(mirroredIndex).getActualMembers(), new Comparator<Student>() {
								    @Override
								    public int compare(Student o1, Student o2) {
								        return (int)((o2.getGPA() * 100) - (o1.getGPA() * 100));
								    }
								});
								
								for (int j = 0; j < projectList.get(i).getActualMembers().size(); j++)
								{
									boolean tradeWasMade = false;
									
									// trade the highest/lowest gpa from team A/B, make sure majors match
									
									Student tempStudent = projectList.get(i).getActualMembers().get(j); // this is the lowest gpa student from the low gpa team
									
									if (tempStudent.getWeight() != 0) // we will not trade high priority students
									{
										continue;
									}
									
									for (Student student : projectList.get(mirroredIndex).getActualMembers()) // start looking for a matching high gpa student from the high gpa team
									{
										if (
												(student.getWeight() == 0) &&							// if this is not a high priority student
												(student.getMajor().equals(tempStudent.getMajor())) &&	// if their majors match
												(checkForEnemies(student, projectList.get(i)) == false) &&		// and there are no enemy problems
												(checkForEnemies(tempStudent, projectList.get(mirroredIndex)) == false)	// then swap them
										   )
										{
											projectList.get(i).addActualMembers(student);
											projectList.get(i).removeActualMembers(tempStudent);
											projectList.get(mirroredIndex).addActualMembers(tempStudent);
											projectList.get(mirroredIndex).removeActualMembers(student);
											tradeWasMade = true;
											break;
										}
									}
									
									if (tradeWasMade == true) // we only trade 1 pair of students
									{
										break;
									}
								}
								
							}
						}
					}
//					System.out.println(teamBuildingState);
					break;
				}
				
				case eCleanUp:
				{
					double studentBodyGPA = 0;
					
					for (Student student : studentList)
					{
						studentBodyGPA += student.getGPA();
					}
					
					studentBodyGPA /= studentList.size();
					
					System.out.println("student body gpa = " + studentBodyGPA + " (" + gpaHigh + " : " + gpaLow + ")");
					
					// re-sort the projects by gpa					
					Collections.sort(projectList, new Comparator<Project>() {
					    @Override
					    public int compare(Project o1, Project o2) {
					        return (int)((o2.getTeamGPA() * 100) - (o1.getTeamGPA() * 100));
					    }
					});
					
					for (Project project : projectList)
					{
						// re-sort the actual members by name
						Collections.sort(project.getActualMembers(), new Comparator<Student>() {
						    @Override
						    public int compare(Student o1, Student o2) {
						        return o1.getName().compareTo(o2.getName());
						    }
						});
					}
										
					for (Project project : projectList)
					{
						System.out.println(project.getName() + " = " + project.getActualMembers() + ": " + project.getTeamGPA());
					}
					System.out.println();
					return;
				}
			}
		}
	}
	
	private void teamBuildAlgorithm(LinkedList<Student> stuList, LinkedList<Project> projList, boolean preferenceRestriction)
	{
		for (Project project : projList)	// iterate through project list
		{
			for (Entry<String, Integer> entry : project.getRequiredMembers().entrySet())	// iterate through individual project's required member list
			{
				int currentCount = 0;
				
				for (Student student : project.getActualMembers())	// first count existing students in this project's major
				{
					if (student.getMajor().equals(entry.getKey()))
					{
						currentCount++;
					}
				}
				
			    for (int i = 0; i < entry.getValue() - currentCount; i++)	// fill in required count of student type
			    {
			    	for (Student student : stuList) // search for an available student
					{
						if (
							(student.getAssignedProject().contentEquals("")) &&	   	// if available
							(student.getMajor().equals(entry.getKey()))	&&		   	// and correct major
							((preferenceRestriction == false) || (checkStudentProjectPreferenceMatch(student, project) == true)) &&	   		// and student prefers this project
							(checkForEnemies(student, project) == false)	   		// and no enemies
						   )
						{
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
			for (String value : existingStudent.getEnemyNames())
			{
				if (student.getName().equals(value))
				{
//					System.out.println("student = " + student.getID());
//					System.out.println("existing student = " + existingStudent.getID());
					return true;
				}
			}
		}
		
		for (String value : student.getEnemyNames()) // check if new student doesnt like the existing students
		{
			for (Student existingStudent : project.getActualMembers())
			{
				if (existingStudent.getName().equals(value))
				{
//					System.out.println("existing student = " + existingStudent.getName());
//					System.out.println("student = " + student.getName());
					return true;
				}
			}
		}
		
		return false;
	}
	
//	public static void main(String[] args)
//	{
//		LinkedList<Student> myStudents = SampleData.getStudents();
//		double studentBodyGPA = 0;
//		double gpaRange = 0.2;
//		
//		for (Student student : myStudents)
//		{
//			studentBodyGPA += student.getGPA();
//		}
//		
//		studentBodyGPA /= myStudents.size();
//		
//		TeamBuilder teamBuilder = new TeamBuilder(SampleData.getProjects(), SampleData.getStudents(), studentBodyGPA - gpaRange, studentBodyGPA + gpaRange, true, true);
//		
//		teamBuilder.buildTeams();
//	}
}