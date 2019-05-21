package view;

import controller.Q3Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Q3View {
	public BorderPane pane;
	public GridPane grid;
	
	public Q3View() {
		grid = new GridPane();
		pane = new BorderPane();
		
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(10,10,10,10));
		
		TextField flightNumber = new TextField();
		
		Label flightNumLabel = new Label("Flight Number");
		flightNumLabel.setFont(new Font(20));
		flightNumLabel.setPadding(new Insets(10, 20, 0, 10));
		
		TextField airlineName = new TextField();
		
		Label airlineLabel = new Label("Airline");
		airlineLabel.setFont(new Font(20));
		airlineLabel.setPadding(new Insets(0,20,0, 10));
		
		TextField priorityLevel = new TextField();
		
		Label priorityLabel = new Label("Priority Level");
		priorityLabel.setFont(new Font(20));
		priorityLabel.setPadding(new Insets(0,20,0, 10));
		
		
		TextArea flightOrderOutput = new TextArea();
		flightOrderOutput.setPrefColumnCount(20);
		
		Button createFlight = new Button("Create Flight");
		createFlight.setOnAction(e->{
			Q3Controller.processCreate(flightNumber.getText(), airlineName.getText(), priorityLevel.getText());
			flightOrderOutput.appendText(Q3Controller.updateTextArea());
		});
		Button displayOrder = new Button("Display Order");
		displayOrder.setOnAction(e->{
			flightOrderOutput.appendText(Q3Controller.processDisplay());
		});
		Button landPlanes = new Button("Land Planes");
		landPlanes.setOnAction(e ->{
			flightOrderOutput.appendText(Q3Controller.processLand());
		});
		grid.add(flightNumber, 0, 0);
		grid.add(flightNumLabel, 1, 0);
		grid.add(airlineName, 0, 1);
		grid.add(airlineLabel, 1, 1);
		grid.add(createFlight, 3, 1);
		grid.add(displayOrder, 4, 1);
		grid.add(landPlanes, 5, 1);
		grid.add(priorityLevel, 0, 2);
		grid.add(priorityLabel, 1, 2);
		
		pane.setTop(grid);
		pane.setCenter(flightOrderOutput);
	}
	public BorderPane getBorderPane() {
		return pane;
	}
}
