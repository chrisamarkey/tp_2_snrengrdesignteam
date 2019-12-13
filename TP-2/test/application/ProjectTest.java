package application;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectTest
{
	Project project;

	@Before
	public void setUp() throws Exception
	{
		project = new Project();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test2ndConstructor()
	{
		Project tempProject = new Project("test0", 1, 2, 3, new HashMap<>(), new LinkedList<Student>());

		assertEquals("Constructor error", "test0", tempProject.getName());
		assertEquals("Constructor error", 1, tempProject.getID());
		assertEquals("Constructor error", 2, tempProject.getNumInterested());
		assertEquals("Constructor error", 3, tempProject.getNumRequired());
		assertEquals("Constructor error", true, tempProject.getRequiredMembers().isEmpty());
		assertEquals("Constructor error", true, tempProject.getActualMembers().isEmpty());
	}

	@Test
	public void testGetName()
	{
		project.setName("test");
		assertEquals("name error", "test", project.getName());
	}

	@Test
	public void testSetName()
	{
		project.setName("test");
		assertEquals("name error", "test", project.getName());
	}

	@Test
	public void testGetID()
	{
		project.setID(1234);
		assertEquals("ID error", 1234, project.getID());
	}

	@Test
	public void testSetID()
	{
		project.setID(1234);
		assertEquals("ID error", 1234, project.getID());
	}

	@Test
	public void testGetNumInterested()
	{
		project.setNumInterested(55);
		assertEquals("num interested error", 55, project.getNumInterested());
	}

	@Test
	public void testSetNumInterested()
	{
		project.setNumInterested(55);
		assertEquals("num interested error", 55, project.getNumInterested());
	}

	@Test
	public void testSetNumRequired()
	{
		project.setNumRequired(99);
		assertEquals("num interested error", 99, project.getNumRequired());
	}

	@Test
	public void testGetNumRequired()
	{
		project.setNumRequired(99);
		assertEquals("num interested error", 99, project.getNumRequired());
	}

	@Test
	public void testGetRequiredMembers()
	{
		project.addRequiredMembers("thisType", 1);
		project.addRequiredMembers("thisType", 1);
		project.addRequiredMembers("thatType", 3);
		assertEquals("required members error", 2, project.getRequiredMembers().size());
		assertEquals("required members error", 2, (int)project.getRequiredMembers().get("thisType"));
		assertEquals("required members error", 3, (int)project.getRequiredMembers().get("thatType"));
	}

	@Test
	public void testAddRequiredMembers()
	{
		project.addRequiredMembers("thisType", 1);
		project.addRequiredMembers("thisType", 1);
		project.addRequiredMembers("thatType", 3);
		assertEquals("required members error", 2, project.getRequiredMembers().size());
		assertEquals("required members error", 2, (int)project.getRequiredMembers().get("thisType"));
		assertEquals("required members error", 3, (int)project.getRequiredMembers().get("thatType"));
	}

	@Test
	public void testRemoveRequiredMembers()
	{
		project.addRequiredMembers("thisType", 1);
		project.addRequiredMembers("thisType", 1);
		project.addRequiredMembers("thatType", 3);
		project.removeRequiredMembers("thatType");
		assertEquals("required members error", 1, project.getRequiredMembers().size());
		assertEquals("required members error", 2, (int)project.getRequiredMembers().get("thisType"));
	}

	@Test
	public void testGetActualMembers()
	{
		project.addActualMembers(new Student("test0", 0, 1.0, "test1", "test2", 2, "test3", new LinkedList<String>(), new LinkedList<String>()));
		project.addActualMembers(new Student("test9", 9, 8.0, "test8", "test7", 7, "test6", new LinkedList<String>(), new LinkedList<String>()));
		assertEquals("actual members error", 2, project.getActualMembers().size());
		assertEquals("actual members error", "test0", project.getActualMembers().get(0).getName());
		assertEquals("actual members error", "test9", project.getActualMembers().get(1).getName());
	}

	@Test
	public void testAddActualMembers()
	{
		project.addActualMembers(new Student("test0", 0, 1.0, "test1", "test2", 2, "test3", new LinkedList<String>(), new LinkedList<String>()));
		project.addActualMembers(new Student("test9", 9, 8.0, "test8", "test7", 7, "test6", new LinkedList<String>(), new LinkedList<String>()));
		assertEquals("actual members error", 2, project.getActualMembers().size());
		assertEquals("actual members error", "test0", project.getActualMembers().get(0).getName());
		assertEquals("actual members error", "test9", project.getActualMembers().get(1).getName());
	}

	@Test
	public void testRemoveActualMembers()
	{
		project.addActualMembers(new Student("test0", 0, 1.0, "test1", "test2", 2, "test3", new LinkedList<String>(), new LinkedList<String>()));
		project.addActualMembers(new Student("test9", 9, 8.0, "test8", "test7", 7, "test6", new LinkedList<String>(), new LinkedList<String>()));
		project.removeActualMembers(project.getActualMembers().get(1));
		assertEquals("actual members error", 1, project.getActualMembers().size());
		assertEquals("actual members error", "test0", project.getActualMembers().get(0).getName());
	}

	@Test
	public void testGetTeamGPA()
	{
		assertEquals("team gpa error", (Double)0.0, (Double)project.getTeamGPA());
		project.addActualMembers(new Student("test0", 0, 1.0, "test1", "test2", 2, "test3", new LinkedList<String>(), new LinkedList<String>()));
		project.addActualMembers(new Student("test9", 9, 8.0, "test8", "test7", 7, "test6", new LinkedList<String>(), new LinkedList<String>()));
		assertEquals("team gpa error", (Double)4.5, (Double)project.getTeamGPA());
	}
}
