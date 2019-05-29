package p2;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MyGridPane {
	
	private Button getAncestorsButton;
	private Button getDescendantsButton;
	private Button insertLeftChildButton;
	private Button insertRightChildButton;
	private Button insertRootButton;
	private TextField childNameField;
	private TextField parentNameField;
	private TextField rootNameField;
	private TextField ancestorsField;
	private TextField descendantsField;
	private TextArea ancestorsArea;
	private TextArea descendantsArea;
	private Text rootText;
	private Text insertLeftChildText;
	private Text insertRightChildText;
	private Text ancestorsText;
	private Text descendantsText;
	private MenuBar menuBar;
	private Menu newMenu;
	private Menu insertMenu;
	private Menu getMenu;
	private MenuItem newTreeMenuItem;
	private MenuItem leftChildMenuItem;
	private MenuItem rightChildMenuItem;
	private MenuItem insertRootMenuItem;
	private MenuItem descendantsMenuItem;
	private MenuItem ancestorsMenuItem;
	private Tree tree;
	private GridPane pane;
	private VBox vBox;
	
	public MyGridPane() {
		this.tree = new Tree();
		this.menuBar = new MenuBar();
		this.newMenu = new Menu("New");
		this.insertMenu = new Menu("Insert");
		this.getMenu = new Menu("Get");
		this.newTreeMenuItem = new MenuItem("Tree");
		this.insertRootMenuItem = new MenuItem("Root");
		this.leftChildMenuItem = new MenuItem("Left Child");
		this.rightChildMenuItem = new MenuItem("Right Child");
		this.descendantsMenuItem = new MenuItem("Descendants");
		this.ancestorsMenuItem = new MenuItem("Ancestors");
		newMenu.getItems().add(newTreeMenuItem);
		insertMenu.getItems().addAll(insertRootMenuItem, leftChildMenuItem, rightChildMenuItem);
		getMenu.getItems().addAll(descendantsMenuItem, ancestorsMenuItem);
		menuBar.getMenus().addAll(newMenu, insertMenu, getMenu);
		
		this.rootNameField = new TextField();
		rootNameField.setPromptText("Enter Root");
		this.insertRootButton = new Button("Insert Root");
		this.childNameField = new TextField();
		childNameField.setPromptText("Enter Child");
		this.parentNameField = new TextField();
		parentNameField.setPromptText("Enter Parent");
		this.ancestorsField = new TextField();
		ancestorsField.setPromptText("Enter Name");
		this.descendantsField = new TextField();
		descendantsField.setPromptText("Enter Name");
		this.insertLeftChildButton = new Button("Insert Child");
		this.insertRightChildButton = new Button("Insert Child");
		this.getAncestorsButton = new Button("Get Ancestors");
		this.getDescendantsButton = new Button("Get Descendants");
		this.descendantsArea = new TextArea();
		this.ancestorsArea = new TextArea();
		
		
		this.pane = new GridPane();
		this.pane.setHgap(10);
		this.pane.setVgap(10);
		this.pane.setPadding(new Insets(40));

		this.vBox = new VBox(menuBar, pane);
		
		this.rootText = new Text("Insert Root");
		this.insertLeftChildText = new Text("Insert Left Child");
		this.insertRightChildText = new Text("Insert Right Child");
		this.ancestorsText = new Text("Get Ancestors");
		this.descendantsText = new Text("Get Descendants");
		rootText.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		insertLeftChildText.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		insertRightChildText.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		ancestorsText.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		descendantsText.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		
		
		
		// Actions####################################
		
		newTreeMenuItem.setOnAction(e -> {
			this.tree = new Tree();
			getNewTreeAlert();
			vBox.getChildren().remove(pane);
			this.pane = new GridPane();
			this.pane.setHgap(4);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(40));
			vBox.getChildren().add(pane);
		
		});
		
		insertRootMenuItem.setOnAction(e ->{
			vBox.getChildren().remove(pane);
			GridPane insertRootPane = new GridPane();
			insertRootPane.add(rootText, 2, 1, 3, 1);
			insertRootPane.add(rootNameField, 2, 2);
			insertRootPane.add(insertRootButton, 2, 4);
			this.pane = insertRootPane;
			this.pane.setHgap(4);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(40));
			vBox.getChildren().add(pane);
		
		});
		
		rightChildMenuItem.setOnAction(e ->{
			vBox.getChildren().remove(pane);
			GridPane rightChildPane = new GridPane();
			rightChildPane.add(insertRightChildText, 2, 1, 3, 1);
			rightChildPane.add(parentNameField, 2, 2);
			rightChildPane.add(childNameField, 2, 4);
			rightChildPane.add(insertRightChildButton, 2, 6);
			this.pane = rightChildPane;
			this.pane.setHgap(4);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(40));
			vBox.getChildren().add(pane);
		
		});
		
		leftChildMenuItem.setOnAction(e ->{
			vBox.getChildren().remove(pane);
			GridPane leftChildPane = new GridPane();
			leftChildPane.add(insertLeftChildText, 2, 1, 3, 1);
			leftChildPane.add(parentNameField, 2, 2);
			leftChildPane.add(childNameField, 2, 4);
			leftChildPane.add(insertLeftChildButton, 2, 6);
			this.pane = leftChildPane;
			this.pane.setHgap(4);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(40));
			vBox.getChildren().add(pane);
		
		});
		
		ancestorsMenuItem.setOnAction(e ->{
			vBox.getChildren().remove(pane);
			GridPane ancestorsPane = new GridPane();
			ancestorsPane.add(ancestorsText, 2, 1, 3, 1);
			ancestorsPane.add(ancestorsField, 2, 2, 1, 1);
			ancestorsPane.add(getAncestorsButton, 2, 4);
			ancestorsPane.add(ancestorsArea, 2, 6, 3, 1);
			this.pane = ancestorsPane;
			this.pane.setHgap(4);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(40));
			vBox.getChildren().add(pane);
		
		});
		
		descendantsMenuItem.setOnAction(e ->{
			vBox.getChildren().remove(pane);
			GridPane descendantsPane = new GridPane();
			descendantsPane.add(descendantsText, 2, 1, 3, 1);
			descendantsPane.add(descendantsField, 2, 2, 1, 1);
			descendantsPane.add(getDescendantsButton, 2, 4);
			descendantsPane.add(descendantsArea, 2, 6, 3, 1);
			this.pane = descendantsPane;
			this.pane.setHgap(4);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(40));
			vBox.getChildren().add(pane);
		
		});
		
		insertRootButton.setOnAction(e->{
			String s = this.rootNameField.getText();
			
			if(this.tree.getRoot() != null) {
				getRootExistsAlert();
				return;
			}
			this.tree.insertRoot(s);
			insertRootSuccess(s);
			rootNameField.clear();
			
		});
		
		insertLeftChildButton.setOnAction(e ->{
			String parent  = parentNameField.getText();
			String child = childNameField.getText();
			
			if(tree.find(parent) == null) {
				noSuchPersonAlert(parent);
				return;
			}
			
			if(tree.find(parent).getLeftChild() != null) {
				leftChildExistsAlert();
				return;
			}
			tree.insertLeftChild(parent, child);
			insertChildSuccess(parent, child);
			parentNameField.clear();
			childNameField.clear();
			
		});
		
		insertRightChildButton.setOnAction(e ->{
			String parent  = parentNameField.getText();
			String child = childNameField.getText();
			
			if(tree.find(parent) == null) {
				noSuchPersonAlert(parent);
				return;
			}
			if(tree.find(parent).getRightChild() != null) {
				rightChildExistsAlert();
				return;
			}
			
			tree.insertRightChild(parent, child);
			insertChildSuccess(parent, child);
			parentNameField.clear();
			childNameField.clear();
			
		});
		
		getAncestorsButton.setOnAction(e -> {
			String child = ancestorsField.getText();
			if(tree.find(child) == null) {
				noSuchPersonAlert(child);
				return;
			}
			ancestorsArea.clear();
			ancestorsArea.setText(Arrays.toString(tree.getAncestors(child)));
		});
		
		getDescendantsButton.setOnAction(e -> {
			String parent = descendantsField.getText();
			if(tree.find(parent) == null) {
				noSuchPersonAlert(parent);
				return;
			}
			descendantsArea.clear();
			descendantsArea.setText(Arrays.toString(tree.getDescendants(parent)));
		});
		
	}
	
	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public void getNewTreeAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "A New Family Tree Has Been Created!");
		alert.setHeaderText("New Tree");
		alert.show();
	
	}
	public void getRootExistsAlert() {
		Alert alert = new Alert(AlertType.ERROR, "Root Already Exists!");
		alert.setHeaderText("Create Root Error");
		alert.show();
	}
	
	public void leftChildExistsAlert() {
		Alert alert = new Alert(AlertType.ERROR, "Left Child Already Exists!");
		alert.setHeaderText("Insert Child Error");
		alert.show();
	}
	
	public void rightChildExistsAlert() {
		Alert alert = new Alert(AlertType.ERROR, "Right Child Already Exists!");
		alert.setHeaderText("Insert Child Error");
		alert.show();
	}
	
	public void noSuchPersonAlert(String name) {
		Alert alert = new Alert(AlertType.ERROR, name + " is not in this Family Tree");
		alert.setHeaderText("No Such Person");
		alert.show();
	}
	
	public void insertRootSuccess(String name) {
		Alert alert = new Alert(AlertType.INFORMATION, name + " has been inserted as root");
		alert.setHeaderText("Success");
		alert.show();
	}
	
	public void insertChildSuccess(String parent, String child) {
		Alert alert = new Alert(AlertType.INFORMATION, child + " has been inserted as the child of " + parent);
		alert.setHeaderText("Success");
		alert.show();
	}

}
