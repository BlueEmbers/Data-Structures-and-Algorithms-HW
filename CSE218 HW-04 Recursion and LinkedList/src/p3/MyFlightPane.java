package p3;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MyFlightPane {
	
	private PriorityQueue queue;
	private Button insertFlight;
	private Button removeFlight;
	private TextField airlineField;
	private TextField flightNumberField;
	private TextField timeStampField;
	private TextField flightPriorityField;
	private GridPane pane;
	private Label flightPriorityLabel;
	private Label flightTimeLabel;
	private Label flightNumberLabel;
	private Label flightAirlineLabel;
	private TextArea flightsListing;
	
	public MyFlightPane(PriorityQueue queue) {
		super();
		this.queue = queue;
		this.airlineField = new TextField();
		this.airlineField.setPromptText("Airline");
		this.flightNumberField = new TextField();
		this.flightNumberField.setPromptText("Flight Number");
		this.pane = new GridPane();
		this.pane.setHgap(30);
		this.pane.setVgap(20);
		this.pane.setPadding(new Insets(40));
		this.pane.setMaxSize(30, 30);
		this.insertFlight = new Button("Insert Flight");
		this.removeFlight = new Button("Land Flight");
		this.flightPriorityLabel = new Label("Flight Priority:");
		this.flightTimeLabel = new Label("Flight Time Stamp:");
		this.flightAirlineLabel = new Label("Airline:");
		this.pane.add(flightAirlineLabel, 1, 1);
		this.pane.add(airlineField, 2, 1);
		this.flightNumberLabel = new Label("Flight Number:");
		this.pane.add(flightNumberLabel, 1, 2);
		this.pane.add(flightNumberField, 2, 2);
		this.pane.add(flightPriorityLabel, 1, 3);
		this.flightPriorityField = new TextField();
		this.flightPriorityField.setPromptText("Priority 1-9:");
		this.pane.add(flightPriorityField, 2, 3);
		this.pane.add(flightTimeLabel, 1, 4);
		this.timeStampField = new TextField();
		this.timeStampField.setPromptText("Time Stamp:");
		this.pane.add(timeStampField, 2, 4);
		this.pane.add(insertFlight, 1, 5);
		this.pane.add(removeFlight, 2, 5);
		this.flightsListing = new TextArea();
		this.flightsListing.autosize();
		this.pane.add(flightsListing, 1, 6, 3, 3);
		
		this.insertFlight.setOnAction(e -> {
			this.queue.insert(new Flight(this.airlineField.getText(), this.flightNumberField.getText(), Integer.parseInt(this.flightPriorityField.getText()), Integer.parseInt(this.timeStampField.getText())));
			this.flightsListing.setText(this.queue.displayQueue());
			this.airlineField.clear();
			this.flightNumberField.clear();
			this.flightPriorityField.clear();
			this.timeStampField.clear();
		});
		
		this.removeFlight.setOnAction(e-> {
			if(this.queue.isEmpty()) {
				System.out.println("No flights currently in queue.");

			}else {
			System.out.println(this.queue.remove());
			}
			this.flightsListing.setText(this.queue.displayQueue());

		});
		
	}

	public PriorityQueue getQueue() {
		return queue;
	}

	public void setQueue(PriorityQueue queue) {
		this.queue = queue;
	}

	public Button getInsertFlight() {
		return insertFlight;
	}

	public void setInsertFlight(Button insertFlight) {
		this.insertFlight = insertFlight;
	}

	public Button getRemoveFlight() {
		return removeFlight;
	}

	public void setRemoveFlight(Button removeFlight) {
		this.removeFlight = removeFlight;
	}

	public TextField getAirlineField() {
		return airlineField;
	}

	public void setAirlineField(TextField airlineField) {
		this.airlineField = airlineField;
	}

	public TextField getFlightNumberField() {
		return flightNumberField;
	}

	public void setFlightNumberField(TextField flightNumberField) {
		this.flightNumberField = flightNumberField;
	}


	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Label getFlightPriorityLabel() {
		return flightPriorityLabel;
	}

	public void setFlightPriorityLabel(Label flightPriorityLabel) {
		this.flightPriorityLabel = flightPriorityLabel;
	}

	public Label getFlightTimeLabel() {
		return flightTimeLabel;
	}

	public void setFlightTimeLabel(Label flightTimeLabel) {
		this.flightTimeLabel = flightTimeLabel;
	}

}
