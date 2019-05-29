package p1;

public class Coin {

	private double value;
	private String name;

	public Coin(int type) {
		switch (type) {
		case 0:
			this.value = 0.01;
			this.name = "Penny";
			break;
		case 1:
			this.value = 0.05;
			this.name = "Nickel";
			break;
		case 2:
			this.value = 0.10;
			this.name = "Dime";
			break;
		case 3:
			this.value = 0.25;
			this.name = "Quarter";
			break;
		case 4:
			this.value = 0.50;
			this.name = "Half Dollar";
			break;
		case 5:
			this.value = 1.00;
			this.name = "Dollar";
			break;
		}
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
