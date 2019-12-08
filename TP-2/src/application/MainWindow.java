package application;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainWindow
{
	LinkedList<Student> studentList;
	LinkedList<Project> projectList;

	String readStudentsFilename;
	String readProjectsFilename;
	int studentsRead;
	double averageGPA;
	double GPArangeLow;
	double GPArangeHigh;
	int projectsRead;
	int electricalEngineersRead;
	int electricalEngineersRequired;
	int mechanicalEngineersRead;
	int mechanicalEngineersRequired;
	int civilEngineersRead;
	int civilEngineersRequired;
	String successFailMessage;
	
	Button readStudentsButton;
	TextField readStudentsFilenameTextField;
	Button readProjectsButton;
	TextField readProjectsFilenameTextField;
	Label studentsReadLabel;
	TextField studentsReadTextField;
	Label averageGPALabel;
	TextField averageGPATextField;
	Label rangeGPALabel;
	TextField rangeGPAlowTextField;
	TextField rangeGPAhighTextField;
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
	Label helpLabel0;
	Label helpLabel1;
	Label helpLabel2;
	
	int testVal = 0;
	
	public MainWindow()
	{		
		readStudentsFilename = "";		
		readProjectsFilename = "";
		studentsRead = 0;
		averageGPA = 0.0;
		GPArangeLow = 0.0;
		GPArangeHigh = 0.0;
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
		stage.setTitle("Engineering Team Builder");
		stage.setScene(new Scene(mainLayout));
		mainLayout.requestFocus();	//this line prevents any field from automatically grabbing focus
		
		//paint window
		stage.show();
	}
	
	private EventHandler<ActionEvent> readStudents()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
//				FileChooser fileChooser = new FileChooser();
//				fileChooser.setTitle("Open Students List");
//				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
//				fileChooser.getExtensionFilters().add(extFilter);
//				File file = fileChooser.showOpenDialog(new Stage());
//				if (file != null)
//				{
//					System.out.println(file.getName());
//					readStudentsFilename = file.getName();
//				}
				
//				makeTestData_students();
				studentList = SampleData.getStudents();
				
				studentsRead = 0;
				averageGPA = 0.0;
				GPArangeLow = 0.0;
				GPArangeHigh = 0.0;
				//projectsRead = 0;
				electricalEngineersRead = 0;
				//electricalEngineersRequired = 0;
				mechanicalEngineersRead = 0;
				//mechanicalEngineersRequired = 0;
				civilEngineersRead = 0;
				//civilEngineersRequired = 0;
				
				for (Student student : studentList)
				{
					if (student.getMajor().equals("Electrical Engineer"))
					{
						electricalEngineersRead++;
					}
					else if (student.getMajor().equals("Mechanical Engineer"))
					{
						mechanicalEngineersRead++;
					}
					else if (student.getMajor().equals("Civil Engineer"))
					{
						civilEngineersRead++;
					}
					studentsRead++;
					averageGPA += student.getGPA();
				}
				
				averageGPA /= studentsRead;
				GPArangeLow = averageGPA - 0.2;
				GPArangeHigh = averageGPA + 0.2;
				
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
//				FileChooser fileChooser = new FileChooser();
//				fileChooser.setTitle("Open Students List");
//				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
//				fileChooser.getExtensionFilters().add(extFilter);
//				File file = fileChooser.showOpenDialog(new Stage());
//				if (file != null)
//				{
////					System.out.println(file.getName());
//					readProjectsFilename = file.getName();
//				}
				
//				makeTestData_projects();
				projectList = SampleData.getProjects();
				
				//studentsRead = 0;
				//averageGPA = 0.0;
				//GPArangeLow = 0.0;
				//GPArangeHigh = 0.0;
				projectsRead = 0;
				//electricalEngineersRead = 0;
				electricalEngineersRequired = 0;
				//mechanicalEngineersRead = 0;
				mechanicalEngineersRequired = 0;
				//civilEngineersRead = 0;
				civilEngineersRequired = 0;
				
				for (Project project : projectList)
				{
					for (Entry<String, Integer> entry : project.getRequiredMembers().entrySet()) {
//					    System.out.println(entry.getKey() + " = " + entry.getValue());
					    if (entry.getKey().equals("Electrical Engineer"))
						{
							electricalEngineersRequired += entry.getValue();
						}
						else if (entry.getKey().equals("Mechanical Engineer"))
						{
							mechanicalEngineersRequired += entry.getValue();
						}
						if (entry.getKey().equals("Civil Engineer"))
						{
							civilEngineersRequired += entry.getValue();
						}
					}
					projectsRead++;
				}
				
				updateTextFields();
			}
		};
	}
	
	private EventHandler<ActionEvent> buildTeams()
	{
		return new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				successFailMessage = "test";
				
//				FileChooser fileChooser = new FileChooser();
//				fileChooser.setTitle("Save Project Teams");
//				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx, *.csv, *.xls)", "*.csv", "*.xls", "*.xlsx");
//				fileChooser.getExtensionFilters().add(extFilter);
//				File file = fileChooser.showSaveDialog(new Stage());
//				if (file != null)
//				{
////					System.out.println(file.getName());
//				}
				
				TeamBuilder teamBuilder = new TeamBuilder(projectList, studentList, GPArangeLow, GPArangeHigh);
				
				teamBuilder.buildTeams();

				updateTextFields();
			}
		};
	}
	
	public void updateTextFields()
	{
		readStudentsFilenameTextField.setText(readStudentsFilename);
		readProjectsFilenameTextField.setText(readProjectsFilename);
		studentsReadTextField.setText(Integer.toString(studentsRead));
		averageGPATextField.setText(String.format("%.2f", averageGPA));
		rangeGPAlowTextField.setText(String.format("%.2f", GPArangeLow));
		rangeGPAhighTextField.setText(String.format("%.2f", GPArangeHigh));
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
		
		int verticalIndex = 0;
		int textfieldWidth = 100;
		
		helpLabel0 = new Label("Select files to read student and project data");
		helpLabel0.setTextFill(Color.web("#ff0000"));
		GridPane.setColumnSpan(helpLabel0, 2);
		GridPane.setConstraints(helpLabel0, 0, verticalIndex++);
		GridPane.setMargin(helpLabel0, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(helpLabel0);

		
		EventHandler<ActionEvent> action;
		
		readStudentsButton = new Button("Read Students");
		action = readStudents();
		readStudentsButton.setOnAction(action);
		GridPane.setConstraints(readStudentsButton, 0, verticalIndex);
		GridPane.setMargin(readStudentsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readStudentsButton);
		
		readStudentsFilenameTextField = new TextField();
		readStudentsFilenameTextField.setEditable(false);
		readStudentsFilenameTextField.setPrefWidth(textfieldWidth*2);
		readStudentsFilenameTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setColumnSpan(readStudentsFilenameTextField, 2);
		GridPane.setConstraints(readStudentsFilenameTextField, 1, verticalIndex++);
		GridPane.setMargin(readStudentsFilenameTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readStudentsFilenameTextField);
				
		readProjectsButton = new Button("Read Projects");
		action = readProjects();
		readProjectsButton.setOnAction(action);
		GridPane.setConstraints(readProjectsButton, 0, verticalIndex);
		GridPane.setMargin(readProjectsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readProjectsButton);
		
		readProjectsFilenameTextField = new TextField();
		readProjectsFilenameTextField.setEditable(false);
		readProjectsFilenameTextField.setPrefWidth(textfieldWidth*2);
		readProjectsFilenameTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setColumnSpan(readProjectsFilenameTextField, 2);
		GridPane.setConstraints(readProjectsFilenameTextField, 1, verticalIndex++);
		GridPane.setMargin(readProjectsFilenameTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readProjectsFilenameTextField);
		
		studentsReadLabel = new Label("Students Read");
		GridPane.setConstraints(studentsReadLabel, 0, verticalIndex);
		GridPane.setMargin(studentsReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(studentsReadLabel);
		
		studentsReadTextField = new TextField();
		studentsReadTextField.setEditable(false);
		studentsReadTextField.setPrefWidth(textfieldWidth);
		studentsReadTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(studentsReadTextField, 1, verticalIndex);
		GridPane.setMargin(studentsReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(studentsReadTextField);
				
		projectsReadLabel = new Label("Projects Read");
		GridPane.setConstraints(projectsReadLabel, 3, verticalIndex);
		GridPane.setMargin(projectsReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(projectsReadLabel);
		
		projectsReadTextField = new TextField();
		projectsReadTextField.setEditable(false);
		projectsReadTextField.setPrefWidth(textfieldWidth);
		projectsReadTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(projectsReadTextField, 2, verticalIndex++);
		GridPane.setMargin(projectsReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(projectsReadTextField);
		
		electricalEngineersReadLabel = new Label("Electrical Engineers Read");
		GridPane.setConstraints(electricalEngineersReadLabel, 0, verticalIndex);
		GridPane.setMargin(electricalEngineersReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersReadLabel);
				
		electricalEngineersReadTextField = new TextField();
		electricalEngineersReadTextField.setEditable(false);
		electricalEngineersReadTextField.setPrefWidth(textfieldWidth);
		electricalEngineersReadTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(electricalEngineersReadTextField, 1, verticalIndex);
		GridPane.setMargin(electricalEngineersReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersReadTextField);
		
		electricalEngineersRequiredLabel = new Label("Electrical Engineers Required");
		GridPane.setConstraints(electricalEngineersRequiredLabel, 3, verticalIndex);
		GridPane.setMargin(electricalEngineersRequiredLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersRequiredLabel);
		
		electricalEngineersRequiredTextField = new TextField();
		electricalEngineersRequiredTextField.setEditable(false);
		electricalEngineersRequiredTextField.setPrefWidth(textfieldWidth);
		GridPane.setConstraints(electricalEngineersRequiredTextField, 2, verticalIndex++);
		electricalEngineersRequiredTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setMargin(electricalEngineersRequiredTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(electricalEngineersRequiredTextField);
		
		mechanicalEngineersReadLabel = new Label("Mechanical Engineers Read");
		GridPane.setConstraints(mechanicalEngineersReadLabel, 0, verticalIndex);
		GridPane.setMargin(mechanicalEngineersReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersReadLabel);
		
		mechanicalEngineersReadTextField = new TextField();
		mechanicalEngineersReadTextField.setEditable(false);
		mechanicalEngineersReadTextField.setPrefWidth(textfieldWidth);
		mechanicalEngineersReadTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(mechanicalEngineersReadTextField, 1, verticalIndex);
		GridPane.setMargin(mechanicalEngineersReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersReadTextField);
		
		mechanicalEngineersRequiredLabel = new Label("Mechanical Engineers Required");
		GridPane.setConstraints(mechanicalEngineersRequiredLabel, 3, verticalIndex);
		GridPane.setMargin(mechanicalEngineersRequiredLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersRequiredLabel);
				
		mechanicalEngineersRequiredTextField = new TextField();
		mechanicalEngineersRequiredTextField.setEditable(false);
		mechanicalEngineersRequiredTextField.setPrefWidth(textfieldWidth);
		mechanicalEngineersRequiredTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(mechanicalEngineersRequiredTextField, 2, verticalIndex++);
		GridPane.setMargin(mechanicalEngineersRequiredTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(mechanicalEngineersRequiredTextField);
		
		civilEngineersReadLabel = new Label("Civil Engineers Read");
		GridPane.setConstraints(civilEngineersReadLabel, 0, verticalIndex);
		GridPane.setMargin(civilEngineersReadLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersReadLabel);
		
		civilEngineersReadTextField = new TextField();
		civilEngineersReadTextField.setEditable(false);
		civilEngineersReadTextField.setPrefWidth(textfieldWidth);
		civilEngineersReadTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(civilEngineersReadTextField, 1, verticalIndex);
		GridPane.setMargin(civilEngineersReadTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersReadTextField);
		
		civilEngineersRequiredLabel = new Label("Civil Engineers Required");
		GridPane.setConstraints(civilEngineersRequiredLabel, 3, verticalIndex);
		GridPane.setMargin(civilEngineersRequiredLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersRequiredLabel);
		
		civilEngineersRequiredTextField = new TextField();
		civilEngineersRequiredTextField.setEditable(false);
		civilEngineersRequiredTextField.setPrefWidth(textfieldWidth);
		civilEngineersRequiredTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(civilEngineersRequiredTextField, 2, verticalIndex++);
		GridPane.setMargin(civilEngineersRequiredTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(civilEngineersRequiredTextField);
		
		averageGPALabel = new Label("Average GPA");
		GridPane.setConstraints(averageGPALabel, 0, verticalIndex);
		GridPane.setMargin(averageGPALabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(averageGPALabel);
		
		averageGPATextField = new TextField();
		averageGPATextField.setEditable(false);
		averageGPATextField.setPrefWidth(textfieldWidth);
		averageGPATextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(averageGPATextField, 1, verticalIndex++);
		GridPane.setMargin(averageGPATextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(averageGPATextField);
				
		rangeGPALabel = new Label("GPA range");
		GridPane.setConstraints(rangeGPALabel, 0, verticalIndex);
		GridPane.setMargin(rangeGPALabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(rangeGPALabel);
		
		rangeGPAlowTextField = new TextField();
		rangeGPAlowTextField.focusedProperty().addListener((ov, oldV, newV) -> {
	           if (!newV) { // focus lost
	        	   GPArangeLow = Double.parseDouble(rangeGPAlowTextField.getText()); 
	           }
	        });
		rangeGPAlowTextField.setPrefWidth(textfieldWidth/2);
		
		rangeGPAhighTextField = new TextField();
		rangeGPAhighTextField.setPrefWidth(textfieldWidth/2);
		rangeGPAhighTextField.focusedProperty().addListener((ov, oldV, newV) -> {
	           if (!newV) { // focus lost
	        	   GPArangeHigh = Double.parseDouble(rangeGPAhighTextField.getText()); 
	           }
	        });
		
		HBox gpaRangeHBox = new HBox();
		gpaRangeHBox.getChildren().addAll(rangeGPAlowTextField, rangeGPAhighTextField);
		gpaRangeHBox.setSpacing(10);
		GridPane.setConstraints(gpaRangeHBox, 1, verticalIndex);
		GridPane.setMargin(gpaRangeHBox, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(gpaRangeHBox);
		
		helpLabel1 = new Label("<-- these are the only values you can modify");
		helpLabel1.setTextFill(Color.web("#ff0000"));
		GridPane.setColumnSpan(helpLabel1, 2);
		GridPane.setConstraints(helpLabel1, 2, verticalIndex++);
		GridPane.setMargin(helpLabel1, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(helpLabel1);
		
		makeTeamsButton = new Button("Make Teams");
		action = buildTeams();
		makeTeamsButton.setOnAction(action);
		GridPane.setConstraints(makeTeamsButton, 0, verticalIndex);
		GridPane.setMargin(makeTeamsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(makeTeamsButton);
		
		helpLabel2 = new Label("<-- when ready, press to make teams");
		helpLabel2.setTextFill(Color.web("#ff0000"));
		GridPane.setColumnSpan(helpLabel2, 2);
		GridPane.setConstraints(helpLabel2, 1, verticalIndex++);
		GridPane.setMargin(helpLabel2, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(helpLabel2);
		
		resultMessageLabel = new Label("Success/Fail Message");
		GridPane.setConstraints(resultMessageLabel, 0, verticalIndex);
		GridPane.setMargin(resultMessageLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(resultMessageLabel);
		
		resultMessageTextField = new TextField();
		resultMessageTextField.setEditable(false);
		resultMessageTextField.setPrefWidth(textfieldWidth);
		resultMessageTextField.setStyle("-fx-text-inner-color: grey;");
		GridPane.setConstraints(resultMessageTextField, 1, verticalIndex++);
		GridPane.setMargin(resultMessageTextField, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(resultMessageTextField);
		
		return myGridPane;
	}
}
