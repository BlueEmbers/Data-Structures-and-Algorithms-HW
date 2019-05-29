package test;

import javafx.application.Application;
import javafx.stage.Stage;
import view.BoardView;

public class Demo3 extends Application {
	public static void main(String[] args) {
		 Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		BoardView view = new BoardView();
		stage.setScene(view.getScene());
		stage.setTitle("Question 3");
		stage.show();
	}

}
