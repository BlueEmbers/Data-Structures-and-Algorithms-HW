package objects;

public class CoordObject4 {
	int x;
	int y;

	public CoordObject4(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public CoordObject4() {
		this.x = (int) (Math.random() * 10);
		this.y = (int) (Math.random() * 10);
	}

	public CoordObject4(CoordObject4 coordObject) {
		this.x = coordObject.getX();
		this.y = coordObject.getY();
	}
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "CoordObject [x=" + x + ", y=" + y + "]";
	}

}
