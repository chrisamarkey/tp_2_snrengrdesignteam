//Craig Gabel, Chris Markey
package application;
import java.util.*;

public class Student {

	public String name;
	public int id;
	public double gpa;
	public String major;
	public LinkedList<Integer> enemyIDs;
	public LinkedList<Student> studentMakeUp;
	public LinkedList<String> studentConfig;

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

	public String getStudentName(Student studentList) {
		this.name = studentList.name;
		return this.name;
	}

	public Integer getStudentID(Student studentList) {
		this.id = studentList.id;
		return this.id;
	}

	public String getStudentMajor(Student studentList) {
		this.major = studentList.major;
		return this.major;
	}

	public LinkedList<Integer> getStudentEnemyIDs(Student studentList) {
		this.enemyIDs = studentList.enemyIDs;
		return this.enemyIDs;
	}

//	Planning to remove this code section:
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
