package p2;

public class Node {
	
	private String name;
	private Node leftChild;
	private Node rightChild;
	private Node parent;
	
	public Node(String name) {
		this.name = name;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}
	
	public Node(Node node) {
		super();
		this.name = node.getName();
		this.leftChild = node.getLeftChild();
		this.rightChild = node.getRightChild();
		this.parent = node.getParent();
	}
	
	
	public Node getParent() {
		return parent;
	}


	public void setParent(Node parent) {
		this.parent = parent;
	}


	public void displayNode() {
		System.out.println(name + "\n");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	@Override
	public String toString() {
		return name;
	}

}
