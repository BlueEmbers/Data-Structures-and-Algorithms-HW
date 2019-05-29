package p2;

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
				(new StackLinkList(), new QueueLinkList());
		
		Scene scene = new Scene(mainPane.getPane(), 700, 400);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
		

}
