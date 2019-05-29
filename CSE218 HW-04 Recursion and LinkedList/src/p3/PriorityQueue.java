package p3;

public class PriorityQueue {

	private int maxSize;
	private Flight[] flights;
	private int nElems;
	
	public PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		flights = new Flight[maxSize];
		nElems = 0;
	}
	
	public void insert(Flight flight) {
		int j;
		if(nElems == 0) {
			flights[nElems++] = flight;
		}else {
			for(j = nElems -1; j >= 0; j--) {
				if((flight.getPriorityLevel() == flights[j].getPriorityLevel()) && (flight.getTimeStamp() > flights[j].getTimeStamp())) {
					flights[j+1] = flights[j];
					}else if(flight.getPriorityLevel() < flights[j].getPriorityLevel()){
						flights[j+1] = flights[j];
						
				}else {
					break;
				}
			}
			flights[j+1] = flight;
			nElems++;
		}
		
	}
	
	public String displayQueue() {
		String s = "";
		for(int i = 0; i < nElems; i++) {
			if(flights[i] != null) {
				s = s + "\n" + flights[i];
			}
		}
		return s;
	}
	
	public Flight remove() {
		return flights[--nElems];
	}
	
	public Flight peekMin() {
		return flights[nElems-1];
	}
	
	public boolean isEmpty() {
		return nElems == 0;
	}
	
	public boolean isFull() {
		return nElems == maxSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public Flight[] getFlights() {
		return flights;
	}

	public void setFlights(Flight[] flights) {
		this.flights = flights;
	}

	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
	
}
