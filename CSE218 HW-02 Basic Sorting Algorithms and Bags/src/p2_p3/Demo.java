package p2_p3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage stage) {

		StudentBag bag = new StudentBag(1100);
		for (int i = 0; i < 1000; i++) {
			Student student = new Student();
			bag.add(student);
		}

		MyFXChart chart = new MyFXChart(bag.bubbleSort(), bag.selectionSort(), bag.insertionSort());

		stage.setTitle("Sorting Methods");
		Scene scene = new Scene(chart.getChart(), 800, 600);
		stage.setScene(scene);
		stage.show();

	}

}
