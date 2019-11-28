
package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
//		UiListener uiListener = new UiListener();
		MainWindow mainWindow = new MainWindow();
//		TBController tbController = new TBController();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
