package test;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Q3View;

public class Q3Demo extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception 
	{
		Q3View theView = new Q3View();
		Scene scene = new Scene(theView.getBorderPane(), 700, 500);
		stage.setTitle("Question 3 Flight Simulator");
		stage.setScene(scene);
		stage.show();
	}

}