package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class StudentReaderTest {

	@Test
	void testCreateStudents() {
		ExcelIO testIO = new ExcelIO();
		StudentReader testReader = new StudentReader();
		LinkedList<Student> testList; 
		testList = testReader.createStudents(testIO, new File("testStudent.xls"));
		assertNotNull(testList);
	}

}
