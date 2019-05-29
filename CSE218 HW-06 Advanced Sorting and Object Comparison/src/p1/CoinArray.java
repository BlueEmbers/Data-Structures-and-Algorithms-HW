package p1;

public class CoinArray {
	private Coin[] array;
	private int nElems;

	public CoinArray(int maxSize) {
		array = new Coin[maxSize];
		nElems = 0;
	}
	
	public void insert(Coin coin) {
		array[nElems++] = coin;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(array[i].getName() + " ");
		}
	}
	
	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}
	
	public void recQuickSort(int left, int right) {
		if(right - left <= 0) {
			return;
		}else {
			Coin pivot = array[right];
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition -1);
			recQuickSort(partition + 1, right);
		}
	}
	
	public int partitionIt(int left, int right, Coin pivot) {
		int leftPointer = left -1;
		int rightPointer = right;
		while(true) {
			while(leftPointer < right && array[++leftPointer].getValue() < pivot.getValue()) {
				;
			}
			while(rightPointer > left && array[--rightPointer].getValue() > pivot.getValue()) {
				;
			}
			if(leftPointer >= rightPointer) {
				break;
			}else {
				swap(leftPointer, rightPointer);
			}
		}
		swap(leftPointer, right);
		return leftPointer;
	}
	
	private void swap(int a, int b) {
		Coin temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public Coin[] getArray() {
		return array;
	}

	public void setArray(Coin[] array) {
		this.array = array;
	}

	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
}
