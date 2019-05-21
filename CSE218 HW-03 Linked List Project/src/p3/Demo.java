package p3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MyFlightPane pane = new MyFlightPane(new PriorityQueue(20));
		
		Scene scene = new Scene(pane.getPane(), 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
