package test;

import javafx.application.Application;
import javafx.stage.Stage;
import view.BoardView4;

public class Demo4 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		BoardView4 view = new BoardView4();
		stage.setScene(view.getScene());
		stage.setTitle("Question 4");
		stage.show();
	}

}
