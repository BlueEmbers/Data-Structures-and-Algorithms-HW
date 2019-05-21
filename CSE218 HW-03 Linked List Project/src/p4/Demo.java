package p4;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {

			launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MasterLinkList masterList = new MasterLinkList();
		
		MyRootPane pane = new MyRootPane();
		
		Scene scene = new Scene(pane.getvBox(), 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
