package p1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MyStudentPane mainPane = new MyStudentPane
				(new StudentStack(20), new StudentQueue(20));
		
		Scene scene = new Scene(mainPane.getPane(), 700, 400);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
