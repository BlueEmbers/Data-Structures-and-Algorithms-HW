package objects;

public class CoordObject {
	int x;
	int y;

	public CoordObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public CoordObject() {
		this.x = (int) (Math.random() * 10);
		this.y = (int) (Math.random() * 10);
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
