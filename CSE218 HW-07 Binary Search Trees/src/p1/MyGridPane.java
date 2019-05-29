package p1;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MyGridPane {

	private MenuBar menuBar;
	private Menu loadMenu;
	private Menu searchMenu;
	private Menu compareMenu;
	private MenuItem orderedMenuItem;
	private MenuItem randomizedMenuItem;
	private MenuItem resetMenuItem;
	private MenuItem simpleSearchMenuItem;
	private MenuItem simpleCompareMenuItem;
	private ComboBox yearComboBox;
	private ComboBox monthComboBox;
	private ComboBox dayComboBox;
	private ComboBox yearComboBox1;
	private ComboBox monthComboBox1;
	private ComboBox dayComboBox1;
	private ComboBox yearComboBox2;
	private ComboBox monthComboBox2;
	private ComboBox dayComboBox2;
	private DatePicker datePicker;
	private DatePicker datePicker1;
	private DatePicker datePicker2;
	private Text simpleSearch;
	private Text simpleComparison;
	private TextField dateTextArea;
	private TextField amountTextArea;
	private TextField timeTextArea;
	private TextField dateTextArea1;
	private TextField amountTextArea1;
	private TextField timeTextArea1;
	private TextField dateTextArea2;
	private TextField amountTextArea2;
	private TextField percentChangeArea;
	private Label inputDateLabel;
	private Label dateLabel;
	private Label amountLabel;
	private Label timeLabel;
	private Label inputDateLabel1;
	private Label inputDateLabel2;
	private Label dateLabel1;
	private Label amountLabel1;
	private Label timeLabel1;
	private Label startLabel;
	private Label endLabel;
	private Label percentChangeLabel;
	private GridPane pane;
	private GridPane searchPane;
	private GridPane comparePane;
	private VBox vBox;
	private Button searchButton;
	private Button compareButton;
	private Tree tree;
	
	DecimalFormat df = new DecimalFormat("#.00");

	public MyGridPane() {
		this.tree = new Tree();
		tree.newSaveFiles();

//		MENUS************************************
		this.menuBar = new MenuBar();
		this.loadMenu = new Menu("Load");
		this.searchMenu = new Menu("Search");
		searchMenu.setDisable(true);
		this.compareMenu = new Menu("Compare");
		compareMenu.setDisable(true);
		this.orderedMenuItem = new MenuItem("Ordered");
		this.randomizedMenuItem = new MenuItem("Randomized");
		this.resetMenuItem = new MenuItem("Reset");
		this.simpleSearchMenuItem = new MenuItem("Simple");
		this.simpleCompareMenuItem = new MenuItem("Simple");

		loadMenu.getItems().addAll(orderedMenuItem, randomizedMenuItem, resetMenuItem);
		searchMenu.getItems().add(simpleSearchMenuItem);
		compareMenu.getItems().add(simpleCompareMenuItem);
		menuBar.getMenus().addAll(loadMenu, searchMenu, compareMenu);

		this.pane = new GridPane();
		this.pane.setHgap(1);
		this.pane.setVgap(4);
		this.pane.setPadding(new Insets(4));

		this.vBox = new VBox(menuBar, pane);

//		ComboBoxes*******************************

		this.monthComboBox = new ComboBox();
		fillMonthComboBox(monthComboBox);
		this.monthComboBox1 = new ComboBox();
		fillMonthComboBox(monthComboBox1);
		this.monthComboBox2 = new ComboBox();
		fillMonthComboBox(monthComboBox2);

		this.dayComboBox = new ComboBox();
		fillDayComboBox(dayComboBox);
		this.dayComboBox1 = new ComboBox();
		fillDayComboBox(dayComboBox1);
		this.dayComboBox2 = new ComboBox();
		fillDayComboBox(dayComboBox2);

		this.yearComboBox = new ComboBox();
		fillYearComboBox(yearComboBox);
		this.yearComboBox1 = new ComboBox();
		fillYearComboBox(yearComboBox1);
		this.yearComboBox2 = new ComboBox();
		fillYearComboBox(yearComboBox2);

		this.datePicker = new DatePicker();
		this.datePicker1 = new DatePicker();
		this.datePicker2 = new DatePicker();

//		GridPane*********************************

		this.simpleSearch = new Text("Simple Search");
		simpleSearch.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		this.simpleComparison = new Text("Simple Comparison");
		simpleComparison.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));

		this.inputDateLabel = new Label("Input date: ");
		this.dateLabel = new Label("Date: ");
		this.amountLabel = new Label("DJIA Price ($): ");
		this.timeLabel = new Label("Search Time (ns): ");
		this.inputDateLabel1 = new Label("Input start date: ");
		this.inputDateLabel2 = new Label("Input end date: ");
		this.dateLabel1 = new Label("Date: ");
		this.amountLabel1 = new Label("DJIA Price ($): ");
		this.timeLabel1 = new Label("Search Time (ns): ");
		this.dateTextArea = new TextField();
		dateTextArea.setEditable(false);

		this.amountTextArea = new TextField();
		amountTextArea.setEditable(false);
		this.timeTextArea = new TextField();
		timeTextArea.setEditable(false);
		this.dateTextArea1 = new TextField();
		dateTextArea1.setEditable(false);
		this.dateTextArea2 = new TextField();
		dateTextArea2.setEditable(false);

		this.amountTextArea1 = new TextField();
		amountTextArea1.setEditable(false);
		this.amountTextArea2 = new TextField();
		amountTextArea2.setEditable(false);

		this.timeTextArea1 = new TextField();
		timeTextArea1.setEditable(false);

		this.percentChangeLabel = new Label("Change (%): ");
		this.percentChangeArea = new TextField();
		percentChangeArea.setEditable(false);

		this.searchButton = new Button("Search");
		this.compareButton = new Button("Compare");

		// On Actions**********************************

		orderedMenuItem.setOnAction(e -> {
			this.tree = new Tree();
			try {
				tree.loadOrderedTree();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			searchMenu.setDisable(false);
			compareMenu.setDisable(false);

		});

		randomizedMenuItem.setOnAction(e -> {
			this.tree = new Tree();
			try {
				tree.loadRandomizedTree();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			searchMenu.setDisable(false);
			compareMenu.setDisable(false);

		});

		simpleSearchMenuItem.setOnAction(e -> {
			buildSearchGridPane();
		});
		;

		simpleCompareMenuItem.setOnAction(e -> {

			buildCompareGridPane();

		});
		;

		resetMenuItem.setOnAction(e -> {
			pane.getChildren().removeAll();
			searchMenu.setDisable(true);
			compareMenu.setDisable(true);
			this.tree.newSaveFiles();
			this.vBox.getChildren().removeAll(pane, searchPane, comparePane);
			this.pane = new GridPane();
			this.pane.setHgap(1);
			this.pane.setVgap(4);
			this.pane.setPadding(new Insets(4));

		});

		searchButton.setOnAction(e -> {
//			int comboDate = parseComboBoxData((String) dayComboBox.getValue(), (String) monthComboBox.getValue(),
//					(String) yearComboBox.getValue());

			LocalDate date = datePicker.getValue();
			int comboDate = convertLocalDate(date);

			long timer = System.nanoTime();
			Node node = tree.simpleSearch(comboDate);
			timer = System.nanoTime() - timer;
			if (node == null) {
				invalidDateAlert(comboDateFormat(comboDate));
				return;
			}

			this.dateTextArea.setText(comboDateFormat(node.getDate()));
			double amount = node.getValue();
			this.amountTextArea.setText((Double.toString(node.getValue())));
			this.timeTextArea.setText(Long.toString(timer));

			try {
				tree.saveSearchData(Long.toString(timer));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		});

		compareButton.setOnAction(e -> {

//			int comboDate = parseComboBoxData((String) dayComboBox1.getValue(), (String) monthComboBox1.getValue(),
//					(String) yearComboBox1.getValue());
//			int comboDate1 = parseComboBoxData((String) dayComboBox2.getValue(), (String) monthComboBox2.getValue(),
//					(String) yearComboBox2.getValue());

			LocalDate date = datePicker1.getValue();
			int comboDate = convertLocalDate(date);

			LocalDate date1 = datePicker2.getValue();
			int comboDate1 = convertLocalDate(date1);

			long timer = System.nanoTime();
			Node node = tree.simpleSearch(comboDate);
			Node node1 = tree.simpleSearch(comboDate1);
			timer = System.nanoTime() - timer;

			if ((comboDate1 - comboDate) < 0) {
				invalidSpanAlert();
				return;
			}

			if (node == null) {
				invalidDateAlert(comboDateFormat(comboDate));
				return;
			}
			if (node1 == null) {
				invalidDateAlert(comboDateFormat(comboDate1));
				return;
			}

			this.dateTextArea1.setText(comboDateFormat(node.getDate()));
			double amount = node.getValue();
			this.amountTextArea1.setText((Double.toString(node.getValue())));
			this.timeTextArea1.setText(Long.toString(timer));
			this.dateTextArea2.setText(comboDateFormat(node1.getDate()));
			double amount1 = node1.getValue();
			this.amountTextArea2.setText((Double.toString(node1.getValue())));
			try {
				tree.saveCompareData(Long.toString(timer));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			double change = amount1 - amount;

			double percent = (change / amount) * 100;

			String stringPercent = df.format(Math.abs(percent));

			percentChangeArea.setText(stringPercent);

			if (percent < 0) {
				percentChangeArea.setStyle("-fx-text-fill: red;");
			}

		});

	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public int parseComboBoxData(String day, String stringMonth, String year) {
		int month = 0;

		switch (stringMonth) {
		case "January":
			month = 01;
			break;
		case "February":
			month = 2;
			break;
		case "March":
			month = 3;
			break;
		case "April":
			month = 4;
			break;
		case "May":
			month = 5;
			break;
		case "June":
			month = 6;
			break;
		case "July":
			month = 7;
			break;
		case "August":
			month = 8;
			break;
		case "September":
			month = 9;
			break;
		case "October":
			month = 10;
			break;
		case "November":
			month = 11;
			break;
		case "December":
			month = 12;
			break;
		}

		int intYear = ((Integer.parseInt(year) - 2000) * 10000);
		int intMonth = ((month) * 100);
		int intDay = (Integer.parseInt(day));
		int result = intYear + intMonth + intDay;
		return result;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public void buildSearchGridPane() {
		this.searchPane = new GridPane();
		searchPane.setHgap(4);
		searchPane.setVgap(4);
		searchPane.setPadding(new Insets(30));
		searchPane.add(simpleSearch, 1, 1, 3, 3);
		searchPane.add(inputDateLabel, 1, 4, 2, 1);
//		searchPane.add(monthComboBox, 3, 4, 3, 1);
//		searchPane.add(dayComboBox, 6, 4, 1, 1);
//		searchPane.add(yearComboBox, 8, 4, 2, 1);
		searchPane.add(datePicker, 3, 4, 3, 1);
		searchPane.add(searchButton, 1, 6, 2, 1);
		searchPane.add(dateLabel, 1, 8, 2, 1);
		searchPane.add(dateTextArea, 3, 8, 2, 1);
		searchPane.add(amountLabel, 1, 10, 2, 1);
		searchPane.add(amountTextArea, 3, 10, 3, 1);
		searchPane.add(timeLabel, 1, 12, 3, 1);
		searchPane.add(timeTextArea, 4, 12, 1, 1);

		this.vBox.getChildren().removeAll(pane, comparePane, searchPane);
		this.vBox.getChildren().add(searchPane);

	}

	public void buildCompareGridPane() {
		this.comparePane = new GridPane();
		comparePane.setHgap(4);
		comparePane.setVgap(4);
		comparePane.setPadding(new Insets(30));

		comparePane.add(simpleComparison, 1, 1, 3, 2);
		comparePane.add(inputDateLabel1, 1, 4, 2, 1);
//		comparePane.add(monthComboBox1, 3, 4, 3, 1);
//		comparePane.add(dayComboBox1, 6, 4, 1, 1);
//		comparePane.add(yearComboBox1, 8, 4, 2, 1);
		comparePane.add(datePicker1, 3, 4, 3, 1);
		comparePane.add(inputDateLabel2, 1, 6, 2, 1);
//		comparePane.add(monthComboBox2, 3, 6, 3, 1);
//		comparePane.add(dayComboBox2, 6, 6, 1, 1);
//		comparePane.add(yearComboBox2, 8, 6, 2, 1);
		comparePane.add(datePicker2, 3, 6, 3, 1);
		comparePane.add(compareButton, 1, 8, 2, 1);
		comparePane.add(dateLabel1, 1, 10, 2, 1);
		comparePane.add(dateTextArea1, 3, 10, 1, 1);
		comparePane.add(dateTextArea2, 6, 10, 1, 1);
		comparePane.add(amountLabel1, 1, 12, 2, 1);
		comparePane.add(amountTextArea1, 3, 12, 1, 1);
		comparePane.add(amountTextArea2, 6, 12, 1, 1);
		comparePane.add(percentChangeLabel, 1, 14, 2, 1);
		comparePane.add(percentChangeArea, 6, 14, 1, 1);
		comparePane.add(timeLabel1, 1, 16, 3, 1);
		comparePane.add(timeTextArea1, 3, 16, 1, 1);

		this.vBox.getChildren().removeAll(pane, searchPane, comparePane);
		this.vBox.getChildren().add(comparePane);
	}

	public void fillDayComboBox(ComboBox box) {
		box.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");

	}

	public void fillMonthComboBox(ComboBox box) {
		box.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December");
	}

	public void fillYearComboBox(ComboBox box) {
		box.getItems().addAll("2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008");
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public void invalidDateAlert(String date) {
		Alert alert = new Alert(AlertType.ERROR, "There is no data for the date: " + date);
		alert.setHeaderText("Invalid Date");
		alert.show();
	}

	public String comboDateFormat(int date) {
		int day = date % 100;
		int month = (date / 100) % 100;
		int year = (date / 10000) % 100;
		String result = month + "/" + day + "/" + year;
		return result;
	}

	public void invalidSpanAlert() {
		Alert alert = new Alert(AlertType.ERROR, "The end date most be after the start date");
		alert.setHeaderText("Invalid Time Span");
		alert.show();
	}

	public int convertLocalDate(LocalDate date) {
		int year = ((date.getYear() - 2000) * 10000);
		int month = (date.getMonthValue() * 100);
		int day = date.getDayOfMonth();

		return year + month + day;

	}
}
