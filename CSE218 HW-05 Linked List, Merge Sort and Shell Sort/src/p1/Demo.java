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
		MyRootPane pane = new MyRootPane(new LinkList());
		Scene scene = new Scene(pane.getPane(), 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
