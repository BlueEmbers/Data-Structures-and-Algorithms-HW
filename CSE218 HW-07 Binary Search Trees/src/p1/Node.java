package p1;

public class Node {
	private int date;
	private double value;
	private Node leftChild;
	private Node rightChild;

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node(int date, double value) {
		this.date = date;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [date=" + date + ", value=" + value + "]";
	}


}
