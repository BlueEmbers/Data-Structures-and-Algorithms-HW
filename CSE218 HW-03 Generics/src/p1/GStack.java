package p1;

public class GStack<G> {

	private int maxSize;
	private int top;
	private G[] stackArray;

	public GStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		stackArray = (G[]) new Object[this.maxSize];
		top = -1;
	}

	public void push(G value) {
		stackArray[++top] = value;
	}

	public void pushAll(G[] array) {
		for (int i = 0; i < array.length; i++) {
			stackArray[++top] = array[i];
		}
	}

	public G[] popAll() {
		int j = 0;
		G[] poppedArray = (G[]) new Object[top + 1];
		for (int i = top ; i >= 0; i--) {
			poppedArray[j] = pop();
			j++;

		}
		return poppedArray;
	}

	public G pop() {
		return stackArray[top--];
	}

	public G peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}
}
