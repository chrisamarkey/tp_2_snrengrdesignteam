//Craig Gabel, Chris Markey

package application;

import java.util.*;

public class Student {

	public String name;
	public int id;
	public double gpa;
	public String major;
	public String favProject;
	public String preferredProj;
	public String assignedProj;
	public LinkedList<Integer> enemyIDs;
	public LinkedList<Student> studentMakeUp;
	public LinkedList<String> studentConfig;
	public LinkedList<String> preferredProjects;
//	public Student toArray;

	public Student() {
		this.name = "default";
		this.id = 7;
		this.gpa = 4.0;
		this.major = "software engineering";
		this.enemyIDs = new LinkedList<>();
	}

	public Student(String name, int id, double gpa, String major, LinkedList<Integer> enemyIDs, String favProject,
			LinkedList<String> preferredProjects, String assignedProject) { // 12/4/19 added assignedProject
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.major = major;
		this.enemyIDs = enemyIDs;
		this.favProject = favProject; // Added 11/25/19
		this.preferredProjects = preferredProjects; // Added 11/25/19
		this.assignedProj = assignedProject; // 12/4/19 addition
	}

	public void setAssignedProject(String assignedProject) { // Added 12/4/19
		this.assignedProj = assignedProject;
	}
	
	public String getAssignedProject(Student student) { // Added 12/4/19
		this.assignedProj = student.assignedProj;
		return this.assignedProj;
	}

	public String getStudentName(Student student) { // 12/4/19 Changed studentList to student
		this.name = student.name;
		return this.name;
	}

	public Integer getStudentID(Student student) { // 12/4/19 Changed studentList to student
		this.id = student.id;
		return this.id;
	}

	public String getStudentMajor(Student student) { // 12/4/19 Changed studentList to student
		this.major = student.major;
		return this.major;
	}

	public LinkedList<Integer> getStudentEnemyIDs(Student studentList) {
		this.enemyIDs = studentList.enemyIDs;
		return this.enemyIDs;
	}

	public LinkedList<String> getPreferredProjects(Student studentList) { // Added 11/25/19
		this.preferredProjects = studentList.preferredProjects;
		return this.preferredProjects;
	}

	public String getFavProject(Student studentList) { // Added 11/25/19
		this.favProject = studentList.favProject;
		return this.favProject;
	}

	public void addEnemy(Student student) {
		enemyIDs.add(student.id);
	}

	public void removeEnemy(Student student) {
		for (int i = 0; i < enemyIDs.size(); i++) {
			if (student.id == enemyIDs.get(i)) {
				enemyIDs.remove(i);
				break;
			}
		}
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

	public static void main(String[] args) {
		Student paper = new Student("paper", 1111, 4.0, "games", new LinkedList<Integer>(), "Robot",
				new LinkedList<String>(), "Robot");
		Student rock = new Student("rock", 2222, 4.0, "games", new LinkedList<Integer>(), "Toy",
				new LinkedList<String>(), "games");
		Student scissors = new Student("scissors", 3333, 4.0, "games", new LinkedList<Integer>(), "Plane",
				new LinkedList<String>(), "games");

		paper.addEnemy(scissors);
		rock.addEnemy(paper);
		scissors.addEnemy(rock);
		System.out.println(paper.enemyIDs);
		System.out.println(rock.enemyIDs);
		System.out.println(scissors.enemyIDs);

		paper.addPreferredProjects("Kite"); // Added 11/25/19
		rock.addPreferredProjects("Bike");
		scissors.addPreferredProjects("Car");
		System.out.println(paper.enemyIDs);
		System.out.println(rock.enemyIDs);
		System.out.println(scissors.enemyIDs);
	}
}
