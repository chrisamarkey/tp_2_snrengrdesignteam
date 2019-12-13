package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectReaderTest {

	@Test
		void testCreateProjects() {
			ExcelIO testIO = new ExcelIO();
			ProjectReader testReader = new ProjectReader();
			LinkedList<Project> testList; 
			testList = testReader.createProjects(testIO, new File("testStudent.xls"));
			assertNotNull(testList);
		}
}