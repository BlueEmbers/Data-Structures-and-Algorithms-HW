package p3;

public class Flight {
	
	private String flightNumber;
	private String airlineName;
	private int priorityLevel;
	private int timeStamp;
	
	
	public Flight(String flightNumber, String airlineName, int priorityLevel, int timeStamp) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.priorityLevel = priorityLevel;
		this.timeStamp = timeStamp;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public int getPriorityLevel() {
		return priorityLevel;
	}


	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}


	public int getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public String toString() {
		return airlineName + " " + flightNumber + ", Priority Level: " + priorityLevel + ", Time Stamp: " + timeStamp;
	}
	
	

}
