import java.util.*;

public class Student2 {

	public String name;
	public int id;
	public double gpa;
	public String major;
	LinkedList<Integer> enemyIDs = new LinkedList<Integer>();
	
	public Student2(String name, int id, double gpa, String major, LinkedList<Integer> enemyIDs)
	{
		this.name = name;
		this.id = id;
		this.gpa = gpa;
		this.major = major;
		this.enemyIDs = enemyIDs;

	}
	


// Needed to add a main method to use LinkedList<String>
	public static void main(String[] args) {

// Creating enemyIDs of class linked list 
		LinkedList<String> enemyIDs = new LinkedList<String>();

// Adding elements to the linked list 
		enemyIDs.add("Chris");
		enemyIDs.add("Craig");
		enemyIDs.addLast("Andy");
		enemyIDs.addFirst("John");
		enemyIDs.add(2, "Paul");
		enemyIDs.add("Ringo");
		enemyIDs.add("George");
System.out.println("Linked list : " + enemyIDs); 

// Removing elements from the linked list 
		enemyIDs.remove("John");
		enemyIDs.remove(3);
		enemyIDs.removeFirst();
		enemyIDs.removeLast();
System.out.println("Linked list after deletion: " + enemyIDs); 

// Finding elements in the linked list 
		boolean status = enemyIDs.contains("Chris");

if(status) 
    System.out.println("List contains the element 'Chris' "); 
else
    System.out.println("List doesn't contain the element 'Chris'"); 

// Number of elements in the linked list 
		int size = enemyIDs.size();
		System.out.println("Size of linked list = " + size);

// Get and set elements from linked list 
		System.out.println("Element returned by get() : " + enemyIDs.get(2));
		enemyIDs.set(2, "Andy");
		System.out.println("Linked list after change : " + enemyIDs);

	}
}
