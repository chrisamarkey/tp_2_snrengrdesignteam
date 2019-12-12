package application;

import static org.junit.Assert.*;
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
		assertEquals("ID error", 1234, student.getID());
	}

	@Test
	public void testSetID()
	{
		student.setID(1234);
		assertEquals("ID error", 1234, student.getID());
	}

	@Test
	public void testGetGPA()
	{
		student.setGPA(3.5);
		assertEquals("GPA error", (Double)3.5, (Double)student.getGPA());
	}

	@Test
	public void testSetGPA()
	{
		student.setGPA(3.5);
		assertEquals("GPA error", (Double)3.5, (Double)student.getGPA());
	}

	@Test
	public void testGetMajor()
	{
		student.setMajor("test");
		assertEquals("Major error", "test", student.getMajor());
	}

	@Test
	public void testSetMajor()
	{
		student.setMajor("test");
		assertEquals("Major error", "test", student.getMajor());
	}

	@Test
	public void testGetFavProject()
	{
		student.setFavProject("test");
		assertEquals("Major error", "test", student.getFavProject());
	}

	@Test
	public void testSetFavProject()
	{
		student.setFavProject("test");
		assertEquals("Major error", "test", student.getFavProject());
	}

	@Test
	public void testGetWeight()
	{
		student.setWeight(12);
		assertEquals("Weight error", 12, student.getWeight());
	}

	@Test
	public void testSetWeight()
	{
		student.setWeight(12);
		assertEquals("Weight error", 12, student.getWeight());
	}

	@Test
	public void testGetAssignedProject()
	{
		student.setAssignedProject("test");
		assertEquals("Assigned Project error", "test", student.getAssignedProject());
	}

	@Test
	public void testSetAssignedProject()
	{
		student.setAssignedProject("test");
		assertEquals("Assigned Project error", "test", student.getAssignedProject());
	}

	@Test
	public void testGetEnemyNames()
	{
		student.addEnemyNames("test0");
		student.addEnemyNames("test1");
		assertEquals("Enemy Size error", 2, student.getEnemyNames().size());
		assertEquals("Enemy error", "test0", student.getEnemyNames().get(0));
		assertEquals("Enemy error", "test1", student.getEnemyNames().get(1));
	}

	@Test
	public void testAddEnemyNames()
	{
		student.addEnemyNames("test0");
		student.addEnemyNames("test1");
		assertEquals("Enemy Size error", 2, student.getEnemyNames().size());
		assertEquals("Enemy error", "test0", student.getEnemyNames().get(0));
		assertEquals("Enemy error", "test1", student.getEnemyNames().get(1));
	}

	@Test
	public void testRemoveEnemyIDs()
	{
		student.addEnemyNames("test0");
		student.addEnemyNames("test1");
		student.removeEnemyIDs("test0");
		assertEquals("Enemy Size error", 1, student.getEnemyNames().size());
		assertEquals("Enemy error", "test1", student.getEnemyNames().get(0));
	}

	@Test
	public void testGetPreferredProjects()
	{
		student.addPreferredProjects("test0");
		student.addPreferredProjects("test1");
		assertEquals("Enemy Size error", 2, student.getPreferredProjects().size());
		assertEquals("Enemy error", "test0", student.getPreferredProjects().get(0));
		assertEquals("Enemy error", "test1", student.getPreferredProjects().get(1));
	}

	@Test
	public void testAddPreferredProjects()
	{
		student.addPreferredProjects("test0");
		student.addPreferredProjects("test1");
		assertEquals("Enemy Size error", 2, student.getPreferredProjects().size());
		assertEquals("Enemy error", "test0", student.getPreferredProjects().get(0));
		assertEquals("Enemy error", "test1", student.getPreferredProjects().get(1));
	}

	@Test
	public void testRemovePreferredProjects()
	{
		student.addPreferredProjects("test0");
		student.addPreferredProjects("test1");
		student.removePreferredProjects("test0");
		assertEquals("Enemy Size error", 1, student.getPreferredProjects().size());
		assertEquals("Enemy error", "test1", student.getPreferredProjects().get(0));
	}

	@Test
	public void testToString()
	{
		student.setName("test");
		assertEquals("To String error", "test", student.toString());
	}

}
