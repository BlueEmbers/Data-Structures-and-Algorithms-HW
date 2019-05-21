package controller;

import models.QueueModel;
import models.StackModel;
import people.Student;

public class Controller {
	private Controller() {
		
	}
	private static Student student;
	private static String name;
	private static String gpa;
	private static StackModel stackModel = new StackModel();
	private static QueueModel queModel = new QueueModel();
	
	
	public static void processPush(String nameText, String gpaText) {
		name = nameText;
		gpa =  gpaText;
		updateStackModel();
	}
	public static void processPop() {
		student = stackModel.pop();
	}
	public static void processInsert(String nameText, String gpaText) {
		name = nameText;
		gpa =  gpaText;
		updateQueueModel();
	}
	public static void processRemove() {
		student = queModel.remove();
	}
	private static void updateStackModel() {
		try {
		student = new Student(name, Double.parseDouble(gpa));
		student = stackModel.push(student);
		} catch(Exception e) {
			student = null;
		}
	}
	private static void updateQueueModel() {
		try {
		student = new Student(name, Double.parseDouble(gpa));
		student = queModel.insert(student);
		} catch(Exception e) {
			student = null;
		}
	}
	public static String updateTextAreaPush() {
		if(student == null) {
			return "Failed to push to stack \n";
		}
		return student.toString() + " pushed \n";
	}
	public static String updateTextAreaPop() {
		if(student == null) {
			return "Failed to pop from stack \n";
		}
		return student.toString() + " popped \n";
	}
	public static String updateTextAreaInsert() {
		if(student == null) {
			return "Failed to insert to queue \n";
		}
		return student.toString() + " inserted \n";
	}
	public static String updateTextAreaRemove() {
		if(student == null) {
			return "Failed to remove from queue \n";
		}
		return student.toString() + " removed \n";
	}
}

