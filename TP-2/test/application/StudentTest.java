package application;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest
{
	private Student student;

	@Before
	public void setUp() throws Exception
	{
		student = new Student();
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void test2ndConstructor() {
		Student tempStudent = new Student("test0", 0, 1.0, "test1", "test2", 2, "test3", new LinkedList<String>(), new LinkedList<String>());
		
		assertEquals("Constructor error", "test0", tempStudent.getName());
		assertEquals("Constructor error", 0, tempStudent.getID());
		assertEquals("Constructor error", (Double)1.0, (Double)tempStudent.getGPA());
		assertEquals("Constructor error", "test1", tempStudent.getMajor());
		assertEquals("Constructor error", "test2", tempStudent.getFavProject());
		assertEquals("Constructor error", 2, tempStudent.getWeight());
		assertEquals("Constructor error", "test3", tempStudent.getAssignedProject());
		assertEquals("Constructor error", true, tempStudent.getEnemyNames().isEmpty());
		assertEquals("Constructor error", true, tempStudent.getPreferredProjects().isEmpty());
	}

	@Test
	public void testGetName()
	{
		student.setName("test");
		assertEquals("name error", "test", student.getName());
	}

	@Test
	public void testSetName()
	{
		student.setName("test");
		assertEquals("name error", "test", student.getName());
	}

	@Test
	public void testGetID()
	{
		student.setID(1234);
		assertEquals("id error", 1234, student.getID());
	}

	@Test
	public void testSetID()
	{
		student.setID(1234);
		assertEquals("id error", 1234, student.getID());
	}

	@Test
	public void testGetGPA()
	{
		student.setGPA(3.5);
		assertEquals("gpa error", (Double)3.5, (Double)student.getGPA());
	}

	@Test
	public void testSetGPA()
	{
		student.setGPA(3.5);
		assertEquals("gpa error", (Double)3.5, (Double)student.getGPA());
	}

	@Test
	public void testGetMajor()
	{
		student.setMajor("test");
		assertEquals("major error", "test", student.getMajor());
	}

	@Test
	public void testSetMajor()
	{
		student.setMajor("test");
		assertEquals("major error", "test", student.getMajor());
	}

	@Test
	public void testGetFavProject()
	{
		student.setFavProject("test");
		assertEquals("major error", "test", student.getFavProject());
	}

	@Test
	public void testSetFavProject()
	{
		student.setFavProject("test");
		assertEquals("major error", "test", student.getFavProject());
	}

	@Test
	public void testGetWeight()
	{
		student.setWeight(12);
		assertEquals("weight error", 12, student.getWeight());
	}

	@Test
	public void testSetWeight()
	{
		student.setWeight(12);
		assertEquals("weight error", 12, student.getWeight());
	}

	@Test
	public void testGetAssignedProject()
	{
		student.setAssignedProject("test");
		assertEquals("assigned project error", "test", student.getAssignedProject());
	}

	@Test
	public void testSetAssignedProject()
	{
		student.setAssignedProject("test");
		assertEquals("assigned project error", "test", student.getAssignedProject());
	}

	@Test
	public void testGetEnemyNames()
	{
		student.addEnemyNames("test0");
		student.addEnemyNames("test1");
		assertEquals("enemy error", 2, student.getEnemyNames().size());
		assertEquals("enemy error", "test0", student.getEnemyNames().get(0));
		assertEquals("enemy error", "test1", student.getEnemyNames().get(1));
	}

	@Test
	public void testAddEnemyNames()
	{
		student.addEnemyNames("test0");
		student.addEnemyNames("test1");
		assertEquals("enemy error", 2, student.getEnemyNames().size());
		assertEquals("enemy error", "test0", student.getEnemyNames().get(0));
		assertEquals("enemy error", "test1", student.getEnemyNames().get(1));
	}

	@Test
	public void testRemoveEnemyNames()
	{
		student.addEnemyNames("test0");
		student.addEnemyNames("test1");
		student.removeEnemyNames("test1");
		assertEquals("enemy error", 1, student.getEnemyNames().size());
		assertEquals("enemy error", "test0", student.getEnemyNames().get(0));
	}

	@Test
	public void testGetPreferredProjects()
	{
		student.addPreferredProjects("test0");
		student.addPreferredProjects("test1");
		assertEquals("preferred projects error", 2, student.getPreferredProjects().size());
		assertEquals("preferred projects error", "test0", student.getPreferredProjects().get(0));
		assertEquals("preferred projects error", "test1", student.getPreferredProjects().get(1));
	}

	@Test
	public void testAddPreferredProjects()
	{
		student.addPreferredProjects("test0");
		student.addPreferredProjects("test1");
		assertEquals("preferred projects error", 2, student.getPreferredProjects().size());
		assertEquals("preferred projects error", "test0", student.getPreferredProjects().get(0));
		assertEquals("preferred projects error", "test1", student.getPreferredProjects().get(1));
	}

	@Test
	public void testRemovePreferredProjects()
	{
		student.addPreferredProjects("test0");
		student.addPreferredProjects("test1");
		student.removePreferredProjects("test1");
		assertEquals("preferred projects error", 1, student.getPreferredProjects().size());
		assertEquals("preferred projects error", "test0", student.getPreferredProjects().get(0));
	}

	@Test
	public void testToString()
	{
		student.setName("test");
		assertEquals("to string error", "test", student.toString());
	}

}
