package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class View {
	public GridPane grid;
	
	public View() {
		grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(10,10,10,10));
		
		TextField name = new TextField();
		
		Label nameLabel = new Label("Name");
		nameLabel.setFont(new Font(20));
		nameLabel.setPadding(new Insets(10, 20, 0, 10));
		
		TextField gpa = new TextField();
		
		Label gpaLabel = new Label("GPA");
		gpaLabel.setFont(new Font(20));
		gpaLabel.setPadding(new Insets(0,20,0, 10));
		
		TextArea studentOutput = new TextArea();
		studentOutput.setPrefColumnCount(20);
		
		Button push = new Button("Stack Push");
		push.setOnAction(e->{
			String newName = name.getText();
			String newGpa = gpa.getText();
			Controller.processPush(newName, newGpa);
			studentOutput.appendText(Controller.updateTextAreaPush());
		});
		Button pop = new Button("Stack Pop");
		pop.setOnAction(e->{
			Controller.processPop();
			studentOutput.appendText(Controller.updateTextAreaPop());
		});
		Button insert = new Button("Queue Insert");
		insert.setOnAction(e->{
			String newName = name.getText();
			String newGpa = gpa.getText();
			Controller.processInsert(newName, newGpa);
			studentOutput.appendText(Controller.updateTextAreaInsert());
		});
		Button remove = new Button("Queue Remove");
		remove.setOnAction(e->{
			Controller.processRemove();
			studentOutput.appendText(Controller.updateTextAreaRemove());
		});
		grid.add(name, 0, 0);
		grid.add(nameLabel, 1, 0);
		grid.add(gpa, 0, 1);
		grid.add(gpaLabel, 1, 1);
		grid.add(studentOutput, 1, 3, 4, 2);
		grid.add(push, 3, 0);
		grid.add(pop, 4, 0);
		grid.add(insert, 3, 1);
		grid.add(remove, 4, 1);
	}
	public GridPane getGrid() {
		return grid;
	}	
}
