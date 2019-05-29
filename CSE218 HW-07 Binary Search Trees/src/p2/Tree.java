package p2;

public class Tree {

	private Node root;
	private int nElems;

	public Tree() {
		this.root = null;
		nElems = 0;
	}

	public void newTree() {
		Tree newTree = new Tree();
		this.root = newTree.root;
	}

	public void insertRoot(String rootName) {
		this.root = new Node(rootName);
		this.nElems++;
	}

	private Node searchTree(Node node, String name) {
		if (node != null) {
			if (node.getName().equals(name)) {
				return node;
			} else {
				Node temp = searchTree(node.getLeftChild(), name);
				if (temp == null) {
					temp = searchTree(node.getRightChild(), name);
				}
				return temp;
			}
		} else {
			return null;
		}
	}

	public Node find(String name) {
		Node newNode = this.root;
		if (root.getName().equals(name)) {
			return newNode;
		} else {
			newNode = searchTree(root, name);
			return newNode;
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public boolean insertLeftChild(String parentName, String childName) {
		Node parent = null;
		if (this.root.getName().equals(parentName)) {
			parent = this.root;
		} else {
			parent = searchTree(this.root, parentName);
		}

		if (hasLeftChild(parent)) {
			return false;
		} else {
			parent.setLeftChild(new Node(childName));
			find(childName).setParent(parent);
			this.nElems++;
			return true;
		}

	}

	public boolean insertRightChild(String parentName, String childName) {
		Node parent = null;
		if (root.getName().equals(parentName)) {
			parent = root;
		} else {
			parent = searchTree(root, parentName);
		}

		if (hasRightChild(parent)) {
			return false;
		} else {
			parent.setRightChild(new Node(childName));
			find(childName).setParent(parent);
			this.nElems++;
			return true;
		}

	}

	public boolean hasLeftChild(Node node) {
		if (node.getLeftChild() == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasRightChild(Node node) {
		if (node.getRightChild() == null) {
			return false;
		} else {
			return true;
		}
	}

	public String[] getAncestors(String name) {
		Node current = find(name).getParent();
		String[] ancestors = new String[nElems];
		int i = 0;
		int count = 0;
		while (current != null) {
			ancestors[i++] = current.getName();
			current = current.getParent();
			count++;
		}
		int k = 0;
		String result[] = new String[count];
		for (int j = 0; j < ancestors.length; j++) {
			if (ancestors[j] != null) {
				result[k] = ancestors[j];
				k++;
			}
		}
		return result;

	}

	public String[] getDescendants(String name) {
		Node current = find(name);
		Node[] descendants = new Node[nElems];
		int i = 0;
		gatherDescendants(current, descendants, i);
		int counter = 0;
		for (int j = 0; j < descendants.length; j++) {
			if ((descendants[j] != null)) {
				if ((!descendants[j].toString().equals(name))) {
					counter++;
				}
			}
		}
		String[] result = new String[counter];
		int k = 0;
		for (int j = 0; j < descendants.length; j++) {
			if ((descendants[j] != null)) {
				if ((!descendants[j].toString().equals(name))) {
					result[k] = descendants[j].getName();
					k++;
				}
			}
		}

		return result;

	}

	public Node[] gatherDescendants(Node node, Node[] array, int i) {
		if (hasLeftChild(node)) {
			gatherDescendants(node.getLeftChild(), array, i);

		}
		while (array[i] != null) {
			i++;
		}
		array[i] = node;

		if (hasRightChild(node)) {
			gatherDescendants(node.getRightChild(), array, i);

		}

		return array;
	}

}
