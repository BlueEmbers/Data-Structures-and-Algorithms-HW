package view;

import java.io.FileInputStream;

import controller.Controller4;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import objects.CoordObject4;

public class BoardView4 {
	GridPane pane;
	ImageView iv;
	Scene scene;

	public BoardView4() {
		pane = new GridPane();
		Image image = null;
		pane.setPadding(new Insets(20, 20, 20, 20));
		try {
			image = new Image(new FileInputStream("images/bug.gif"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		iv = new ImageView(image);
		Rectangle[] rectangles = createRectangles();
		Button[] buttons = createButtons();
		addRectanglesAndButtons(rectangles, buttons);
		armButtons(buttons);
		Button undo = new Button("Undo");
		undo.setOnAction(e -> {
			pane.getChildren().remove(iv);
			Controller4.handlePop();
			pane.add(iv, Controller4.getX(), Controller4.getY());
		});
		pane.add(undo, 0, 10);
		pane.add(iv, Controller4.getRandomStart().getX(), Controller4.getRandomStart().getY());
		pane.setAlignment(Pos.CENTER);
		scene = new Scene(pane, 700, 710);
	}

	private void armButtons(Button[] buttons) {
		for (int i = 0; i < 100; i++) {
			Button button = buttons[i];
			button.setOnAction(e -> {
				pane.getChildren().remove(iv);
				int x = GridPane.getColumnIndex(button);
				int y = GridPane.getRowIndex(button);
				CoordObject4 coords = Controller4.push(x, y);
				pane.add(iv, coords.getX(), coords.getY());
			});
		}
	}

	private void addRectanglesAndButtons(Rectangle[] rectangles, Button[] buttons) {
		int nElems = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				pane.add(rectangles[nElems], i, j);
				pane.add(buttons[nElems++], i, j);
			}
		}
	}

	public Rectangle[] createRectangles() {
		Rectangle[] rectangles = new Rectangle[100];
		for (int i = 0; i < 100; i++) {
			rectangles[i] = new Rectangle(65, 65, Paint.valueOf("#8FBC8F"));
			rectangles[i].setStroke(Paint.valueOf("#000000"));
		}
		return rectangles;
	}

	public Button[] createButtons() {
		Button[] buttons = new Button[100];
		for (int i = 0; i < 100; i++) {
			buttons[i] = new Button();
			buttons[i].setPrefHeight(10);
			buttons[i].setPrefWidth(25);
			GridPane.setHalignment(buttons[i], HPos.CENTER);
		}
		return buttons;
	}

	public Scene getScene() {
		return scene;
	}

}
