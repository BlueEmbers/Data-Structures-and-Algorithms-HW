package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Q2View;

public class Demo extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception 
	{
		Q2View theView = new Q2View();
		Scene scene = new Scene(theView.getGrid(), 500, 300);
		stage.setTitle("Question 2 Implimented with Links");
		stage.setScene(scene);
		stage.show();
	}

}