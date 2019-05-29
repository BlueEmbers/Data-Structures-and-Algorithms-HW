package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.BagTypeView;

public class Demo2 extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		BagTypeView view = new BagTypeView();
		Scene scene = new Scene(view.getPane(), 500, 300);
		stage.setTitle("Bag Chooser");
		stage.setScene(scene);
		stage.show();
	}

}
