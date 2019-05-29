package view;

import controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BagView {
	private Scene scene;

	public BagView(String bagType) {
		BorderPane pane = new BorderPane();
		
		TextArea text = new TextArea();
		text.setEditable(false);
		pane.setCenter(text);
		
		VBox box = new VBox();
		Label label = new Label("Enter Some " + bagType);
		label.setFont(new Font(15));
		TextField input = new TextField();
		Button inputButton = new Button("Add");
		inputButton.setOnAction(e ->{
			text.appendText(Controller.handleInput(input.getText()) + "\n") ;
			input.setText("");
		});
		box.setSpacing(10);
		box.setPadding(new Insets(10));
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(label);
		box.getChildren().add(input);
		box.getChildren().add(inputButton);
		pane.setLeft(box);
		
		HBox Hbox = new HBox();
		Button display = new Button("Display");
		display.setOnAction(e ->{
			text.appendText(Controller.handleDisplay());
		});
		Button findMax = new Button("Find Max");
		findMax.setOnAction(e ->{
			text.appendText(Controller.handleFindMax());
		});
		Button findMin = new Button("Find Min");
		findMin.setOnAction(e ->{
			text.appendText(Controller.handleFindMin());
		});
		Button deleteMax = new Button("Delete Max");
		deleteMax.setOnAction(e ->{
			text.appendText(Controller.handleDeleteMax());
		});
		Button deleteMin = new Button("Delete Min");
		deleteMin.setOnAction(e ->{
			text.appendText(Controller.handleDeleteMin());
		});
		Button insertionSort = new Button("Insertion Sort");
		insertionSort.setOnAction(e ->{
			text.appendText(Controller.handleInsertionSort());
		});
		
		Hbox.getChildren().addAll(display, findMax, findMin, deleteMax, deleteMin, insertionSort);
		Hbox.setSpacing(10);
		Hbox.setPadding(new Insets(10));
		Hbox.setAlignment(Pos.CENTER);
		pane.setBottom(Hbox);
	
		
		scene = new Scene(pane, 500, 300);
	}

	public Scene getScene() {
		return scene;
	}

}
