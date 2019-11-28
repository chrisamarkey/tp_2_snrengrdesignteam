package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow
{
	int studentsRead;
	double averageGPA;
	double GPArange;
	int projectsRead;
	int electricalEngineersRead;
	int electricalEngineersRquired;
	int mechanicalEngineersRead;
	int mechanicalEngineersRquired;
	int civilEngineersRead;
	int civilEngineersRquired;
	String successFailMessage;
	
	Button readStudentsButton;
	Button readPreferencesButton;
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
		electricalEngineersRquired = 0;
		mechanicalEngineersRead = 0;
		mechanicalEngineersRquired = 0;
		civilEngineersRead = 0;
		civilEngineersRquired = 0;
		successFailMessage = "test";
		
		buildScreen();
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
				updateTextFields();
			}
		};
	}
	
	public void updateTextFields()
	{
		
		testVal++;
		
		studentsReadTextField.setText(Integer.toString(testVal));
		
		averageGPATextField.setText(Integer.toString(testVal));
		
		rangeGPATextField.setText(Integer.toString(testVal));
		projectsReadTextField.setText(Integer.toString(testVal));
		electricalEngineersReadTextField.setText(Integer.toString(testVal));
		electricalEngineersRequiredTextField.setText(Integer.toString(testVal));
		mechanicalEngineersReadTextField.setText(Integer.toString(testVal));
		mechanicalEngineersRequiredTextField.setText(Integer.toString(testVal));
		civilEngineersReadTextField.setText(Integer.toString(testVal));
		civilEngineersRequiredTextField.setText(Integer.toString(testVal));
		resultMessageTextField.setText(Integer.toString(testVal));
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
		
		EventHandler<ActionEvent> action = readStudents();
		
		readStudentsButton = new Button("Read Students");
		readStudentsButton.setOnAction(action);
		GridPane.setConstraints(readStudentsButton, 0, verticalIndex++);
		GridPane.setMargin(readStudentsButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readStudentsButton);
		
		readPreferencesButton = new Button("Read Preferences");
		GridPane.setConstraints(readPreferencesButton, 0, verticalIndex++);
		GridPane.setMargin(readPreferencesButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(readPreferencesButton);
		
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
