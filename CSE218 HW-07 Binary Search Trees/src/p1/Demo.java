package p1;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args){
		launch(args);
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MyGridPane pane = new MyGridPane();
		
		Scene scene = new Scene(pane.getvBox(), 600, 400);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
