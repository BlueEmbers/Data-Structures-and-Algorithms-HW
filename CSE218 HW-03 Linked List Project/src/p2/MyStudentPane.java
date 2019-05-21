package p2;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class MyStudentPane {

	private StackLinkList stack;
	private QueueLinkList queue;
	private Button push;
	private Button pop;
	private Button insert;
	private Button remove;
	private TextField studentName;
	private TextField studentGpa;
	private Label studentNameLabel = new Label("Student's Name:");
	private Label gpaLabel = new Label("GPA:");
	private HBox box;
	private GridPane pane;
	
	public MyStudentPane(StackLinkList stack, QueueLinkList queue) {
		this.stack = stack;
		this.queue = queue;
		this.studentName = new TextField();
		this.studentName.setPromptText("Student's Name");
		this.studentGpa = new TextField();
		this.studentGpa.setPromptText("Student's GPA");
		this.pane = new GridPane();
		this.pane.setHgap(30);
		this.pane.setVgap(20);
		this.pane.setPadding(new Insets(40));
		this.pane.setMaxSize(10, 10);
		this.push = new Button("Push");
		this.pop = new Button("Pop");
		this.insert = new Button("Insert");
		this.remove = new Button("Remove");
		this.pane.add(studentName, 1, 1);
		this.pane.add(studentGpa, 3, 1);
		this.pane.add(push, 1, 3);
		this.pane.add(pop, 1, 5);
		this.pane.add(insert, 3, 3);
		this.pane.add(remove, 3, 5);
		
		this.push.setOnAction(e -> {
			this.stack.insertFirst(new Student(studentName.getText(), Double.parseDouble(studentGpa.getText())));
			this.studentName.clear();
			this.studentGpa.clear();
		});
		
		this.pop.setOnAction(e -> {
			if(this.stack.isEmpty()) {
				System.out.println("No Student Data in Stack");
			}else {
				System.out.println(this.stack.deleteFirst());
			}
		});
		
		this.insert.setOnAction(e -> {
			this.queue.insertLast(new Student(studentName.getText(), Double.parseDouble(studentGpa.getText())));
			this.studentName.clear();
			this.studentGpa.clear();
		});
		
		this.remove.setOnAction(e -> {
			if(this.queue.isEmpty()) {
				System.out.println("No Student Data in Queue");
			}else {
				System.out.println(this.queue.deleteFirst());
			}
		});
		
	}

	public StackLinkList getStack() {
		return stack;
	}

	public void setStack(StackLinkList stack) {
		this.stack = stack;
	}

	public QueueLinkList getQueue() {
		return queue;
	}

	public void setQueue(QueueLinkList queue) {
		this.queue = queue;
	}

	public Button getPush() {
		return push;
	}

	public void setPush(Button push) {
		this.push = push;
	}

	public Button getPop() {
		return pop;
	}

	public void setPop(Button pop) {
		this.pop = pop;
	}

	public Button getInsert() {
		return insert;
	}

	public void setInsert(Button insert) {
		this.insert = insert;
	}

	public Button getRemove() {
		return remove;
	}

	public void setRemove(Button remove) {
		this.remove = remove;
	}

	public TextField getStudentName() {
		return studentName;
	}

	public void setStudentName(TextField studentName) {
		this.studentName = studentName;
	}

	public TextField getStudentGpa() {
		return studentGpa;
	}

	public void setStudentGpa(TextField studentGpa) {
		this.studentGpa = studentGpa;
	}

	public Label getStudentNameLabel() {
		return studentNameLabel;
	}

	public void setStudentNameLabel(Label studentNameLabel) {
		this.studentNameLabel = studentNameLabel;
	}

	public Label getGpaLabel() {
		return gpaLabel;
	}

	public void setGpaLabel(Label gpaLabel) {
		this.gpaLabel = gpaLabel;
	}

	public HBox getBox() {
		return box;
	}

	public void setBox(HBox box) {
		this.box = box;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	
}
