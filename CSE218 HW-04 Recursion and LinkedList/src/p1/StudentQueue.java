package p1;

public class StudentQueue {
	private int maxSize;
	private Student[] students;
	private int front;
	private int rear;
	private int nElems;
	
	public StudentQueue(int maxSize) {
		this.maxSize = maxSize;
		students = new Student[this.maxSize];
		front = 0;
		rear = -1;
		nElems = 0;
	}
	
	public void insert(Student student) {
		Student[] studentsExpanded = new Student[maxSize*2];
		if(rear == maxSize) {
			for(int i = 0; i < students.length; i++) {
				studentsExpanded[i] = students[i];
			}
			this.students = studentsExpanded;
		}
	
		students[++rear] = student;
		nElems++;
	}
	
	public Student remove() {
		Student removeCopy = new Student(students[front++]);
		nElems--;
		return removeCopy;
	}
	
	public Student peekFront() {
		return students[front];
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}
	
}
