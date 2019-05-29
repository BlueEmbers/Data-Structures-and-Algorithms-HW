package view;

import controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BagTypeView {
	StackPane pane;

	public BagTypeView() {
		pane = new StackPane();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);

		Label label = new Label();
		label.setText("Choose A Bag Type");
		label.setFont(new Font(40));
		label.setPadding(new Insets(25));

		Button stringButton = new Button("String");
		stringButton.setPrefWidth(100);
		stringButton.setOnAction(e ->{
			Controller.setBagString(stringButton.getScene().getWindow());
		});
		Button integerButton = new Button("Integer");
		integerButton.setPrefWidth(100);
		integerButton.setOnAction(e ->{
			Controller.setBagInteger(integerButton.getScene().getWindow());
		});
		Button doubleButton = new Button("Double");
		doubleButton.setPrefWidth(100);
		doubleButton.setOnAction(e ->{
			Controller.setBagDouble(doubleButton.getScene().getWindow());
		});

		vbox.getChildren().add(label);
		vbox.getChildren().add(stringButton);
		vbox.getChildren().add(integerButton);
		vbox.getChildren().add(doubleButton);
		
		pane.getChildren().add(vbox);

	}

	public StackPane getPane() {
		return pane;
	}


	
}
