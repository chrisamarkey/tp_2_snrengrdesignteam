package application;

import java.io.File;
import java.util.*;

public class StudentReader { // Creates Student Objects by implementing Excel IO methods
	
	// This needs to exist somewhere. Maybe it shouldn't be here. Maybe in the TeamBuilder itself? But it's here for now.
	private LinkedList<Student> studentList = new LinkedList<>(); 
	
	StudentReader() {
		
	}
	// This method should create a list full of complete students and return that list to whatever calls for it. 
	public LinkedList<Student> createStudents(ExcelIO reader, File studentFile) { //Take the File, create the stream
		reader.createSStream(studentFile);
		boolean moreData = true;
		while (moreData) {
			Student newStudent = new Student();
			moreData = reader.readNextRow(newStudent);
			studentList.add(newStudent);
		}
		return studentList;
	}

}
