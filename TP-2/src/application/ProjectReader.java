package application;

import java.util.*;

public class ProjectReader { //Creates Project objects by implementing ExcelIO methods

	private LinkedList<Project> projectList= new LinkedList<>();
	
	ProjectReader() {
		
	}
	// This method should create a list full of complete projects and return that list to whatever calls for it. 
	public LinkedList<Project> createProjects(ExcelIO reader) {
		boolean moreData = true;
		while (moreData) {
			Project newProject = new Project();
			moreData = reader.readNextRow(newProject);
			projectList.add(newProject);
		}
		return projectList;
	}
}
