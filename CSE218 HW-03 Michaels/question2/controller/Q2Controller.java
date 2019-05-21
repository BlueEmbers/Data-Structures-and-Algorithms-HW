package controller;

import models.LinkListQueueModel;
import models.LinkListStackModel;
import people.Student;

public class Q2Controller {
	private Q2Controller() {
	}
	private static Student student;
	private static String name;
	private static String gpa;
	private static LinkListStackModel stackModel = new LinkListStackModel();
	private static LinkListQueueModel queModel = new LinkListQueueModel();
	
	
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
		stackModel.push(student);
		} catch(Exception e) {
			student = null;
		}
	}
	private static void updateQueueModel() {
		try {
		student = new Student(name, Double.parseDouble(gpa));
		queModel.insert(student);
		} catch(Exception e) {
			System.out.println("Insert is throwing Null Pointer");
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

