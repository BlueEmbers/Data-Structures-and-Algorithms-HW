package models;

import java.util.Date;

import flight.Flight;

public class PriorityQModel {
	private Flight[] flightArray;
	private int nElems;
	private long timeStamp;

	public PriorityQModel(int maxSize) {
		nElems = 0;
		flightArray = new Flight[maxSize];
		timeStamp = System.currentTimeMillis();
	}
	public Date generateTimeStamp() {
		Date newDate = new Date(timeStamp);
		timeStamp += 1000000;
		return newDate;
	}
	public void insert(Flight flight) {
		int j;
		if (isEmpty()) {
			flightArray[nElems++] = flight;
		} else {
			for (j = nElems - 1; j >= 0; j--) {
				if (flight.compareTo(flightArray[j]) > 0) {
					flightArray[j + 1] = flightArray[j];
				} else {
					break;
				}
			}
			flightArray[j + 1] = flight;
			nElems++;
		}
	}
	public Flight remove() {
		return flightArray[--nElems];
	}
	
	public String landPlanes() {
		String landString = "\nLanding Planes \n";
		while(!isEmpty()) {
			Flight flight = remove();
			landString += (flight.toString() + " landed\n");
		}
		landString += "\n";
		return landString;
	}

	public boolean isCorrectFormat(String priorityLvlText) {
		if (priorityLvlText.equals("")) {
			return false;
		}
		int compare = Integer.parseInt(priorityLvlText);
		if (compare >= 1 && compare <= 10) {
			return true;
		}
		return false;
	}

	public String display() {
		String display = "\nFlight Order \n";
		if (!isEmpty()) {
			for (int i = nElems - 1; i >= 0; i--) {
				display += flightArray[i].toString() + "\n";
			}
			return display += "\n";
		}
		return "";
	}

	public boolean isEmpty() {
		return nElems == 0;
	}

}
