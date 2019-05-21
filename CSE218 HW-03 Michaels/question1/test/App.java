package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.View;

public class App extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception 
	{
		View theView = new View();
		Scene scene = new Scene(theView.getGrid(), 500, 300);
		stage.setTitle("Question 1 Implimented With Arrays");
		stage.setScene(scene);
		stage.show();
		
	}

}
