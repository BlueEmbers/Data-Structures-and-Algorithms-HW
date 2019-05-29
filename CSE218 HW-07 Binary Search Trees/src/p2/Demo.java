package p2;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MyGridPane pane = new MyGridPane();
		
		Scene scene = new Scene(pane.getvBox(), 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
