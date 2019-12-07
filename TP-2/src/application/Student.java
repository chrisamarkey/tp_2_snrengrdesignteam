//Craig Gabel, Chris Markey

package application;

import java.util.*;

public class Student {

	private String name;
	private int id;
	private double gpa;
	private String major;
	private String favProject;
	private int weight;
	private String assignedProj;
	private LinkedList<String> enemyNames;
	private LinkedList<String> preferredProjects;

	public Student() {
		name = "";
		id = 0;
		gpa = 0.0;
		major = "";
		favProject = "";
		weight = 0;
		assignedProj = "";
		enemyNames = new LinkedList<>();
		preferredProjects = new LinkedList<>();
	}

	public Student(String name,
				   int id,
				   double gpa, 
				   String major, 
				   String favProject,
				   Integer weight,
				   String assignedProject,
				   LinkedList<String> enemyNames,
				   LinkedList<String> preferredProjects 
				   ) { // 12/4/19 added assignedProject
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.major = major;
		this.favProject = favProject; // Added 11/25/19
		this.weight = weight;
		this.assignedProj = assignedProject; // 12/4/19 addition
		this.enemyNames = enemyNames;	
		this.preferredProjects = preferredProjects; // Added 11/25/19
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String input) {
		this.name = input;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public void setID(int input) {
		this.id = input;
	}
	
	public Double getGPA() {
		return this.gpa;
	}
	
	public void setGPA(double input) {
		this.gpa = input;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setMajor(String input) {
		this.major = input;
	}
	
	public String getFavProject() { // Added 11/25/19		
		return this.favProject;
	}
	
	public void setFavProject(String input)
	{
		this.favProject = input;
	}
	
	public Integer getWeight() {
		return this.weight;
	}
	
	public void setWeight(int input) {
		this.weight = input;
	}
	
	public String getAssignedProject() { // Added 12/4/19
		return this.assignedProj;
	}	

	public void setAssignedProject(String assignedProject) { // Added 12/4/19
		this.assignedProj = assignedProject;
	}
		
	public LinkedList<String> getEnemyNames() {
		return this.enemyNames;
	}
	
	public void addEnemyNames(String input) {
		this.enemyNames.add(input);
	}
	
	public void removeEnemyIDs(String input) {
		for (int i = 0; i < enemyNames.size(); i++)
		{
			if (enemyNames.get(i).equals(input))
			{
				enemyNames.remove(i);
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
		
		Student paper = new Student("paper", 1111, 4.0, "covering rocks", "playing rps", 0, "playing rps",
				new LinkedList<String>(), new LinkedList<String>());
		Student rock = new Student("rock", 2222, 3.0, "smashing scissors", "playing rps", 0, "playing rps",
				new LinkedList<String>(), new LinkedList<String>());
		Student scissors = new Student("scissors", 3333, 2.0, "cutting paper", "playing rps", 0, "playing rps",
				new LinkedList<String>(), new LinkedList<String>());
		
		paper.addEnemyNames(scissors.getName());
		paper.addEnemyNames(rock.getName());
		rock.addEnemyNames(paper.getName());
		rock.addEnemyNames(scissors.getName());
		scissors.addEnemyNames(rock.getName());
		scissors.addEnemyNames(paper.getName());
		System.out.println(paper.enemyNames);
		System.out.println(rock.enemyNames);
		System.out.println(scissors.enemyNames);

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