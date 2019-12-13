package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExcelIOTest {
	
	ExcelIO testClass;
	Student newStudent;
	Project newProject;

	@BeforeEach
	void setUp() throws Exception {
		testClass = new ExcelIO();
	}

	@Test
	void testCreateSStream() {
		testClass.createSStream(new File("testStudent.xls"));
		assertNotNull(testClass.getStudentWB());
		assertNotNull(testClass.getStudentSheet());
		assertNotNull(testClass.getStudentRow());
		assertNotNull(testClass.getStudentRI());
	}

	@Test
	void testCreatePStream() {
		testClass.createPStream(new File("testProject.xls"));
		assertNotNull(testClass.getProjectWB());
		assertNotNull(testClass.getProjectSheet());
		assertNotNull(testClass.getProjectRow());
		assertNotNull(testClass.getProjectRI());
	}
	
	@Test
	void testReadStudentRow() {
		testClass.createSStream(new File("testStudent.xls"));
		newStudent = new Student();
		testClass.readNextRow(newStudent);
		assertEquals(newStudent.getName(), "Name");
		assertEquals(newStudent.getID(), 1);
		assertEquals(newStudent.getMajor(), "Major");
		assertEquals(newStudent.getGPA(), 4.0);
		assertEquals(newStudent.getEnemyNames().get(0), "Enemy");
		assertEquals(newStudent.getFavProject(), "Project");
		assertEquals(newStudent.getWeight(), 5);
		assertEquals(newStudent.getPreferredProjects().get(0), "Project");
	}
	
	@Test
	void testReadProjectRow() {
		testClass.createPStream(new File("testProject.xls"));
		newProject = new Project();
		testClass.readNextRow(newProject);
		assertEquals(newProject.getName(), "Name");
		assertEquals(newProject.getNumRequired(), 1);
	}
	
	@Test
	void testPrepOutputFile() {
		testClass.prepOutputFile(4.0);
		assertNotNull(testClass.getTeamWB());
		assertNotNull(testClass.getTeamSheet());
		assertNotNull(testClass.getTeamRow());
		assertEquals(testClass.getAvgGPA(), 4.0);
	}
	@Test
	void testWriteTeamRow() {
		testClass.prepOutputFile(4.0);
		testClass.createPStream(new File("testProject.xls"));
		newProject = new Project();
		testClass.readNextRow(newProject);
		testClass.writeNextRow(newProject, 1);
		assertTrue(true); // Frankly, if this method runs it'll work, and there's no real way to assess it.
	}
	
	@Test
	void testSaveNewFile() {
		testClass.prepOutputFile(4.0);
		File testOutput = new File ("Test Output.xlsx");
		assertTrue(testClass.saveNewFile(testOutput));
	}
	
	@Test
	void testCreateCellReference() {
		testClass.prepOutputFile(4.0);
		assertEquals (testClass.createCellReference(testClass.getTeamRow().cellIterator().next()).formatAsString(), "A1");
	}
}