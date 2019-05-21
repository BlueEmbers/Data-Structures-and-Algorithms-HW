package flight;

import java.util.Date;

public class Flight implements Comparable<Flight> {
	private long flightNumber;
	private String airlineName;
	private int priorityLevel;
	private Date timeStamp;
	
	public Flight(long flightNumber, String airlineName, int priorityLevel, Date timeStamp) {
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.priorityLevel = priorityLevel;
		this.timeStamp = timeStamp;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
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

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Flight [Number: " + flightNumber + ", Airline: " + airlineName + ", Priority: "
				+ priorityLevel + ", Arrival: " + timeStamp + "]";
	}

	@Override
	public int compareTo(Flight flight) {
		if(this.priorityLevel == flight.getPriorityLevel()) {
			if(this.timeStamp.before(flight.getTimeStamp())) {
				return -1;
			}
			if(this.timeStamp.after(flight.getTimeStamp())) {
				return 1;
			}
		}
		if(this.priorityLevel > flight.priorityLevel) {
			return -1;
		} else if(this.priorityLevel < flight.priorityLevel){
			return 1;
		}
		return 0;
	}

	
	
}
