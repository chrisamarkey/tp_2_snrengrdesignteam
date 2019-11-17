//Craig Gabel, Chris Markey

import java.util.*;

public class Student {

	public String name;
	public int id;
	public double gpa;
	public String major;
	public LinkedList<Integer> enemyIDs;
	public LinkedList<String> studentGroup;

	public Student() {
		this.name = "default";
		this.id = 7;
		this.gpa = 4.0;
		this.major = "software engineering";
		this.enemyIDs = new LinkedList<>();
	}

	public Student(String name, int id, double gpa, String major, LinkedList<Integer> enemyIDs) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.major = major;
		this.enemyIDs = enemyIDs;
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

//	public void removeOneEnemy(String name, int id) 
//	{
//		for (int i = 0; i < enemyIDs.size(); i++)
//		{
//			if (student.id == enemyIDs.get(i))
//			{
//				enemyIDs.remove(id);
//				break;
//			}
//		}
//	}

	public static void main(String[] args) {
		Student paper = new Student("paper", 1111, 4.0, "games", new LinkedList<Integer>());
		Student rock = new Student("rock", 2222, 4.0, "games", new LinkedList<Integer>());
		Student scissors = new Student("scissors", 3333, 4.0, "games", new LinkedList<Integer>());

		paper.addEnemy(scissors);
		rock.addEnemy(paper);
		scissors.addEnemy(rock);

		System.out.println(paper.enemyIDs);
		System.out.println(rock.enemyIDs);
		System.out.println(scissors.enemyIDs);
	}
}
