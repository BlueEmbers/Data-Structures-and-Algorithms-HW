package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new MainPane().grid,650,450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
