//Craig Gabel, Chris Markey

package application;

import java.util.*;

public class Student {

	private String name;
	private int id;
	private double gpa;
	private String major;
	private String favProject;
	private String assignedProj;
	private LinkedList<Integer> enemyIDs;
	private LinkedList<String> preferredProjects;

	public Student() {
		name = "";
		id = 0;
		gpa = 0.0;
		major = "";
		favProject = "";
		assignedProj = "";
		enemyIDs = new LinkedList<>();
		preferredProjects = new LinkedList<>();
	}

	public Student(String name,
				   int id,
				   double gpa, 
				   String major, 
				   String favProject,
				   String assignedProject,
				   LinkedList<Integer> enemyIDs,
				   LinkedList<String> preferredProjects 
				   ) { // 12/4/19 added assignedProject
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.major = major;
		this.favProject = favProject; // Added 11/25/19
		this.assignedProj = assignedProject; // 12/4/19 addition
		this.enemyIDs = enemyIDs;	
		this.preferredProjects = preferredProjects; // Added 11/25/19
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public Double getGPA() {
		return this.gpa;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public String getFavProject() { // Added 11/25/19		
		return this.favProject;
	}
	
	public void setFavProject(String input)
	{
		this.favProject = input;
	}	

	public void setAssignedProject(String assignedProject) { // Added 12/4/19
		this.assignedProj = assignedProject;
	}
	
	public String getAssignedProject() { // Added 12/4/19
		return this.assignedProj;
	}
		
	public LinkedList<Integer> getEnemyIDs() {
		return this.enemyIDs;
	}
	
	public void addEnemyIDs(Integer ID) {
		this.enemyIDs.add(ID);
	}
	
	public void removeEnemyIDs(Integer ID) {
		for (int i = 0; i < enemyIDs.size(); i++)
		{
			if (enemyIDs.get(i) == ID)
			{
				enemyIDs.remove(i);
				break;
			}
		}
	}

	public LinkedList<String> getPreferredProjects() { // Added 11/25/19
		return this.preferredProjects;
	}

	public void addPreferredProjects(String preferredProj) { // Added 11/25/19
		preferredProjects.add(preferredProj);
	}

	public void removePreferredProjects(String preferredProj) { // Added 11/25/19
		for (int i = 0; i < preferredProjects.size(); i++) {
			if (preferredProj == preferredProjects.get(i)) {
				preferredProjects.remove(i);
				break;
			}
		}
	}
	
	@Override
	public String toString()
	{
		return name;
	}

	public static void main(String[] args) {
		
		Student paper = new Student("paper", 1111, 4.0, "covering rocks", "playing rps", "playing rps",
				new LinkedList<Integer>(), new LinkedList<String>());
		Student rock = new Student("rock", 2222, 3.0, "smashing scissors", "playing rps", "playing rps",
				new LinkedList<Integer>(), new LinkedList<String>());
		Student scissors = new Student("scissors", 3333, 2.0, "cutting paper", "playing rps", "playing rps",
				new LinkedList<Integer>(), new LinkedList<String>());
		
		paper.addEnemyIDs(scissors.getID());
		paper.addEnemyIDs(rock.getID());
		rock.addEnemyIDs(paper.getID());
		rock.addEnemyIDs(scissors.getID());
		scissors.addEnemyIDs(rock.getID());
		scissors.addEnemyIDs(paper.getID());
		System.out.println(paper.enemyIDs);
		System.out.println(rock.enemyIDs);
		System.out.println(scissors.enemyIDs);

		paper.addPreferredProjects("Kite"); // Added 11/25/19
		paper.addPreferredProjects("Surf");
		rock.addPreferredProjects("Bike");
		rock.addPreferredProjects("Race");
		scissors.addPreferredProjects("Car");
		scissors.addPreferredProjects("Pool");
		System.out.println(paper.preferredProjects);
		System.out.println(rock.preferredProjects);
		System.out.println(scissors.preferredProjects);
	}
}