package p1;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MyRootPane {
	
	private TextField nameField;
	private TextField scoreField;
	private TextArea textArea;
	private Button insert;
	private LinkList list;
	private GridPane pane;
	
	public MyRootPane(LinkList list) {
		this.list = list;
		this.nameField = new TextField();
		this.scoreField = new TextField();
		nameField.setPromptText("Name");
		scoreField.setPromptText("Score");
		this.insert = new Button("Insert");
		this.textArea = new TextArea();
		textArea.setMinSize(200, 300);
		this.pane = new GridPane();
		this.pane.setPadding(new Insets(20));
		this.pane.setHgap(20);
		this.pane.setVgap(20);
		pane.add(nameField, 0, 1);
		pane.add(scoreField, 0, 2);
		pane.add(insert, 0, 3);
		pane.add(textArea, 0, 4, 5, 5);
	
		insert.setOnAction(e -> {
			list.insert(nameField.getText(), Integer.parseInt(scoreField.getText()));
			textArea.setText(list.display());
		});
		
	}
	
	

	public TextField getNameField() {
		return nameField;
	}

	public void setNameField(TextField nameField) {
		this.nameField = nameField;
	}

	public TextField getScoreField() {
		return scoreField;
	}

	public void setScoreField(TextField scoreField) {
		this.scoreField = scoreField;
	}

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}

	public Button getInsert() {
		return insert;
	}

	public void setInsert(Button insert) {
		this.insert = insert;
	}

	public LinkList getList() {
		return list;
	}

	public void setList(LinkList list) {
		this.list = list;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	

}
