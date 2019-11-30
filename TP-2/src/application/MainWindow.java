package application;

import java.io.File;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainWindow
{
	LinkedList<Student> studentList;
	LinkedList<Project> projectList;
	
	private void makeTestData_projects()
	{
		Project project;
		projectList = new LinkedList<>();
		
		//Project(String project, LinkedList<String> requiredMembers, LinkedList<Student> actualMembers, int numInterestedProj, int projectID)
		project = new Project("project 0", new LinkedList<String>(), new LinkedList<Student>(), 0, 0000);
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Mechanical Engineer");
		project.requiredMembers.add("Mechanical Engineer");
		project.requiredMembers.add("Civil Engineer");
		projectList.add(project);
		
		project = new Project("project 1", new LinkedList<String>(), new LinkedList<Student>(), 0, 1111);
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Mechanical Engineer");
		project.requiredMembers.add("Mechanical Engineer");
		project.requiredMembers.add("Mechanical Engineer");
		projectList.add(project);
		
		project = new Project("project 2", new LinkedList<String>(), new LinkedList<Student>(), 0, 2222);
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Civil Engineer");
		project.requiredMembers.add("Civil Engineer");
		projectList.add(project);
		
		project = new Project("project 3", new LinkedList<String>(), new LinkedList<Student>(), 0, 3333);
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Electrical Engineer");
		project.requiredMembers.add("Electrical Engineer");
		projectList.add(project);
		
	}
	
	private void makeTestData_students()
	{
		studentList = new LinkedList<>();
		
		//studentList.add(new Student(name, id, gpa, major, enemyIDs, favProject, preferredProjects));
		studentList.add(new Student("ee0", 1111, 4.0, "Electrical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ee1", 1111, 4.0, "Electrical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ee2", 1111, 4.0, "Electrical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ee3", 1111, 4.0, "Electrical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ee4", 1111, 4.0, "Electrical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ee5", 1111, 4.0, "Electrical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		
		studentList.add(new Student("me0", 2222, 4.0, "Mechanical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("me1", 2222, 4.0, "Mechanical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("me2", 2222, 4.0, "Mechanical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("me3", 2222, 4.0, "Mechanical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("me4", 2222, 4.0, "Mechanical Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		
		studentList.add(new Student("ce0", 3333, 4.0, "Civil Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ce1", 3333, 4.0, "Civil Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		studentList.add(new Student("ce2", 3333, 4.0, "Civil Engineer", new LinkedList<Integer>(), "Robot", new LinkedList<String>()));
		
	}
	
	
	int studentsRead;
	double averageGPA;
	double GPArange;
	int projectsRead;
	int electricalEngineersRead;
	int electricalEngineersRequired;
	int mechanicalEngineersRead;
	int mechanicalEngineersRequired;
	int civilEngineersRead;
	int civilEngineersRequired;
	String successFailMessage;
	
	Button readStudentsButton;
	Button readPreferencesButton;
	Button readProjectsButton;
	Label studentsReadLabel;
	TextField studentsReadTextField;
	Label averageGPALabel;
	TextField averageGPATextField;
	Label rangeGPALabel;
	TextField rangeGPATextField;
	Label projectsReadLabel;
	TextField projectsReadTextField;
	Label electricalEngineersReadLabel;
	TextField electricalEngineersReadTextField;
	Label electricalEngineersRequiredLabel;
	TextField electricalEngineersRequiredTextField;
	Label mechanicalEngineersReadLabel;
	TextField mechanicalEngineersReadTextField;
	Label mechanicalEngineersRequiredLabel;
	TextField mechanicalEngineersRequiredTextField;
	Label civilEngineersReadLabel;
	TextField civilEngineersReadTextField;
	Label civilEngineersRequiredLabel;
	TextField civilEngineersRequiredTextField;
	Button makeTeamsButton;
	Label resultMessageLabel;
	TextField resultMessageTextField;
	
	int testVal = 0;
	
	public MainWindow()
	{		
		studentsRead = 0;
		averageGPA = 0.0;
		GPArange = 0.0;
		projectsRead = 0;
		electricalEngineersRead = 0;
		electricalEngineersRequired = 0;
		mechanicalEngineersRead = 0;
		mechanicalEngineersRequired = 0;
		civilEngineersRead = 0;
		civilEngineersRequired = 0;
		successFailMessage = "test";
		
		buildScreen();
		updateTextFields();
	}
	
	public void buildScreen()
	{
		//create window
		Stage stage = new Stage();
		GridPane mainLayout = buildLayout();
		stage.setScene(new Scene(mainLayout));
		mainLayout.requestFocus();	//this line prevents any field from automatically grabbing focus
//		stage.sizeToScene();
		
		//paint window
		stage.show();
	}
	
	private EventHandler<ActionEvent> readStudents()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
//				updateTextFields(1);
				
//				FileChooser fileChooser = new FileChooser();
//				fileChooser.setTitle("Open Students List");
//				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
//				fileChooser.getExtensionFilters().add(extFilter);
//				File file = fileChooser.showOpenDialog(new Stage());
//				if (file != null)
//				{
//					System.out.println(file.getName());
//				}
				
				makeTestData_students();
				
				studentsRead = 0;
				averageGPA = 0.0;
				//GPArange = 0.0;
				//projectsRead = 0;
				electricalEngineersRead = 0;
				//electricalEngineersRequired = 0;
				mechanicalEngineersRead = 0;
				//mechanicalEngineersRequired = 0;
				civilEngineersRead = 0;
				//civilEngineersRequired = 0;
				
				for (Student student : studentList)
				{
					if (student.major.equals("Electrical Engineer"))
					{
						electricalEngineersRead++;
					}
					else if (student.major.equals("Mechanical Engineer"))
					{
						mechanicalEngineersRead++;
					}
					else if (student.major.equals("Civil Engineer"))
					{
						civilEngineersRead++;
					}
					studentsRead++;
					averageGPA += student.gpa;
				}
				
				averageGPA /= studentsRead;
				
				updateTextFields();
			}
		};
	}
	
	private EventHandler<ActionEvent> readProjects()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
//				updateTextFields(1);
				
//				FileChooser fileChooser = new FileChooser();
//				fileChooser.setTitle("Open Students List");
//				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
//				fileChooser.getExtensionFilters().add(extFilter);
//				File file = fileChooser.showOpenDialog(new Stage());
//				if (file != null)
//				{
//					System.out.println(file.getName());
//				}
				
				makeTestData_projects();
				
				//studentsRead = 0;
				//averageGPA = 0.0;
				//GPArange = 0.0;
				projectsRead = 0;
				//electricalEngineersRead = 0;
				electricalEngineersRequired = 0;
				//mechanicalEngineersRead = 0;
				mechanicalEngineersRequired = 0;
				//civilEngineersRead = 0;
				civilEngineersRequired = 0;
				
				for (Project project : projectList)
				{
					for (String requiredMember : project.requiredMembers)
					{
						if (requiredMember.equals("Electrical Engineer"))
						{
							electricalEngineersRequired++;
						}
						else if (requiredMember.equals("Mechanical Engineer"))
						{
							mechanicalEngineersRequired++;
						}
						if (requiredMember.equals("Civil Engineer"))
						{
							civilEngineersRequired++;
						}
					}
					projectsRead++;
				}
				
				updateTextFields();
			}
		};
	}
	
	private EventHandler<ActionEvent> readStudentPreferences()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				updateTextFields();
				
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Students Preferences");
				File file = fileChooser.showOpenDialog(new Stage());
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
				fileChooser.getExtensionFilters().add(extFilter);
				if (file != null)
				{
					System.out.println(file.getName());
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> buildTeams()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				studentsRead = 0;
				averageGPA = 0.0;
				GPArange = 0.0;
				projectsRead = 0;
				electricalEngineersRead = 0;
				electricalEngineersRequired = 0;
				mechanicalEngineersRead = 0;
				mechanicalEngineersRequired = 0;
				civilEngineersRead = 0;
				civilEngineersRequired = 0;
				successFailMessage = "test";
				
				updateTextFields();
				
//				FileChooser fileChooser = new FileChooser();
//				fileChooser.setTitle("Save Project Teams");
//				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
//				fileChooser.getExtensionFilters().add(extFilter);
//				File file = fileChooser.showSaveDialog(new Stage());
//				if (file != null)
//				{
//					System.out.println(file.getName());
//				}
			}
		};
	}
	
	public void updateTextFields()
	{		
		studentsReadTextField.setText(Integer.toString(studentsRead));
		averageGPATextField.setText(Double.toString(averageGPA));
		rangeGPATextField.setText(Double.toString(GPArange));
		projectsReadTextField.setText(Integer.toString(projectsRead));
		electricalEngineersReadTextField.setText(Integer.toString(electricalEngineersRead));
		electricalEngineersRequiredTextField.setText(Integer.toString(electricalEngineersRequired));
		mechanicalEngineersReadTextField.setText(Integer.toString(mechanicalEngineersRead));
		mechanicalEngineersRequiredTextField.setText(Integer.toString(mechanicalEngineersRequired));
		civilEngineersReadTextField.setText(Integer.toString(civilEngineersRead));
		civilEngineersRequiredTextField.setText(Integer.toString(civilEngineersRequired));
		resultMessageTextField.setText(Integer.toString(0));
	}
	
	public GridPane buildLayout()
	{
		GridPane myGridPane = new GridPane();
		/*
		 button, load excel file
		textbox, students read
		textbox, projects read
		textbox, electrical engineers required
		textbox, electrical engineers available
		.
		.
		.
		textbox, average gpa
		slider/textbox, team gpa range
		button, create teams
		textbox, result - success/fail
		textbox, fail message (cause for) 
		 
		 */
		
		int verticalIndex = 0;
		
		EventHandler<ActionEvent> action;
		
		readStudentsButton = new Button("Read Students");
		action = readStudents();
		readStudentsButton.setOnAction(action);
		GridPane.setConstraints(readStudentsButton, 0, verticalIndex++);
		GridPane.setMargin(readStudentsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readStudentsButton);
		
		readPreferencesButton = new Button("Read Preferences");
		action = readStudentPreferences();
		readPreferencesButton.setOnAction(action);
		GridPane.setConstraints(readPreferencesButton, 0, verticalIndex++);
		GridPane.setMargin(readPreferencesButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readPreferencesButton);
		
		readProjectsButton = new Button("Read Projects");
		action = readProjects();
		readProjectsButton.setOnAction(action);
		GridPane.setConstraints(readProjectsButton, 0, verticalIndex++);
		GridPane.setMargin(readProjectsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readProjectsButton);
		
		studentsReadLabel = new Label("Students Read");
		GridPane.setConstraints(studentsReadLabel, 0, verticalIndex);
		GridPane.setMargin(studentsReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(studentsReadLabel);
		
		studentsReadTextField = new TextField();
		GridPane.setConstraints(studentsReadTextField, 1, verticalIndex++);
		GridPane.setMargin(studentsReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(studentsReadTextField);
		
		averageGPALabel = new Label("Average GPA");
		GridPane.setConstraints(averageGPALabel, 0, verticalIndex);
		GridPane.setMargin(averageGPALabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(averageGPALabel);
		
		averageGPATextField = new TextField();
		GridPane.setConstraints(averageGPATextField, 1, verticalIndex++);
		GridPane.setMargin(averageGPATextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(averageGPATextField);
				
		rangeGPALabel = new Label("GPA range");
		GridPane.setConstraints(rangeGPALabel, 0, verticalIndex);
		GridPane.setMargin(rangeGPALabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(rangeGPALabel);
		
		rangeGPATextField = new TextField();
		GridPane.setConstraints(rangeGPATextField, 1, verticalIndex++);
		GridPane.setMargin(rangeGPATextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(rangeGPATextField);
		
		projectsReadLabel = new Label("Projects Read");
		GridPane.setConstraints(projectsReadLabel, 0, verticalIndex);
		GridPane.setMargin(projectsReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(projectsReadLabel);
		
		projectsReadTextField = new TextField();
		GridPane.setConstraints(projectsReadTextField, 1, verticalIndex++);
		GridPane.setMargin(projectsReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(projectsReadTextField);
		
		electricalEngineersReadLabel = new Label("Electrical Engineers Read");
		GridPane.setConstraints(electricalEngineersReadLabel, 0, verticalIndex);
		GridPane.setMargin(electricalEngineersReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersReadLabel);
				
		electricalEngineersReadTextField = new TextField();
		GridPane.setConstraints(electricalEngineersReadTextField, 1, verticalIndex);
		GridPane.setMargin(electricalEngineersReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersReadTextField);
		
		electricalEngineersRequiredLabel = new Label("Electrical Engineers Required");
		GridPane.setConstraints(electricalEngineersRequiredLabel, 3, verticalIndex);
		GridPane.setMargin(electricalEngineersRequiredLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersRequiredLabel);
		
		electricalEngineersRequiredTextField = new TextField();
		GridPane.setConstraints(electricalEngineersRequiredTextField, 2, verticalIndex++);
		GridPane.setMargin(electricalEngineersRequiredTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersRequiredTextField);
		
		mechanicalEngineersReadLabel = new Label("Mechanical Engineers Read");
		GridPane.setConstraints(mechanicalEngineersReadLabel, 0, verticalIndex);
		GridPane.setMargin(mechanicalEngineersReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersReadLabel);
		
		mechanicalEngineersReadTextField = new TextField();
		GridPane.setConstraints(mechanicalEngineersReadTextField, 1, verticalIndex);
		GridPane.setMargin(mechanicalEngineersReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersReadTextField);
		
		mechanicalEngineersRequiredLabel = new Label("Mechanical Engineers Required");
		GridPane.setConstraints(mechanicalEngineersRequiredLabel, 3, verticalIndex);
		GridPane.setMargin(mechanicalEngineersRequiredLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersRequiredLabel);
				
		mechanicalEngineersRequiredTextField = new TextField();
		GridPane.setConstraints(mechanicalEngineersRequiredTextField, 2, verticalIndex++);
		GridPane.setMargin(mechanicalEngineersRequiredTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersRequiredTextField);
		
		civilEngineersReadLabel = new Label("Civil Engineers Read");
		GridPane.setConstraints(civilEngineersReadLabel, 0, verticalIndex);
		GridPane.setMargin(civilEngineersReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersReadLabel);
		
		civilEngineersReadTextField = new TextField();
		GridPane.setConstraints(civilEngineersReadTextField, 1, verticalIndex);
		GridPane.setMargin(civilEngineersReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersReadTextField);
		
		civilEngineersRequiredLabel = new Label("Civil Engineers Required");
		GridPane.setConstraints(civilEngineersRequiredLabel, 3, verticalIndex);
		GridPane.setMargin(civilEngineersRequiredLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersRequiredLabel);
		
		civilEngineersRequiredTextField = new TextField();
		GridPane.setConstraints(civilEngineersRequiredTextField, 2, verticalIndex++);
		GridPane.setMargin(civilEngineersRequiredTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersRequiredTextField);
		
		makeTeamsButton = new Button("Make Teams");
		action = buildTeams();
		makeTeamsButton.setOnAction(action);
		GridPane.setConstraints(makeTeamsButton, 0, verticalIndex++);
		GridPane.setMargin(makeTeamsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(makeTeamsButton);
		
		resultMessageLabel = new Label("Success/Fail Message");
		GridPane.setConstraints(resultMessageLabel, 0, verticalIndex);
		GridPane.setMargin(resultMessageLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(resultMessageLabel);
		
		resultMessageTextField = new TextField();
		GridPane.setConstraints(resultMessageTextField, 1, verticalIndex++);
		GridPane.setMargin(resultMessageTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(resultMessageTextField);
		
		return myGridPane;
	}
}
