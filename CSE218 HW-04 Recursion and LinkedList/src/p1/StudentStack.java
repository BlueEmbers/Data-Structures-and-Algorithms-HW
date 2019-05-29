package p1;

public class StudentStack {
	private Student[] students;
	private int maxSize;
	private int top;
	
	public StudentStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.students = new Student[this.maxSize];
		top = -1;
		
	}
	
	public void push(Student student) {
		Student[] studentsExpanded = new Student[maxSize*2];
		if(top== maxSize) {
			for(int i = 0; i < students.length; i++) {
				studentsExpanded[i] = students[i];
			}
			this.students = studentsExpanded;
		}
		students[++top] = student;
	}
	public Student pop() {
		Student popCopy = new Student(students[top]);
		top--;
		return popCopy;
	}
	
	public Student peek(Student student) {
		return students[top];
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}


}
