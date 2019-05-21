package controller;

import flight.Flight;
import models.PriorityQModel;
public class Q3Controller {
	private Q3Controller() {
	}

	private static Flight flight;
	private static long flightNumber;
	private static String airlineName;
	private static int priorityLevel;
	private static PriorityQModel queModel = new PriorityQModel(10);

	public static void processCreate(String flightText, String airlineText, String priorityLvlText) {
		if (queModel.isCorrectFormat(priorityLvlText)) {
			flightNumber = Long.valueOf(flightText);
			airlineName = airlineText;
			priorityLevel = Integer.valueOf(priorityLvlText);
			updateQueueModel();
		} else {
		flight = null;
		}
	}
	public static String processLand() {
		if(queModel.isEmpty()) {
			return "\nThere are no planes to land \n";
		}
		return queModel.landPlanes();
	}
	private static void updateQueueModel() {
		try {
			flight = new Flight(flightNumber, airlineName, priorityLevel, queModel.generateTimeStamp());
			queModel.insert(flight);
		} catch (Exception e) {
			flight = null;
		}
	}
	public static String updateTextArea() {
		if (flight != null) {
			return flight.toString() + "created \n";
		}
		return "\nFlight failed to create \n";
	}

	public static String processDisplay() {		
		if(queModel.display().equals("")){
			return "\nThere are no Flights \n";
		}
		return queModel.display();
	}
}
