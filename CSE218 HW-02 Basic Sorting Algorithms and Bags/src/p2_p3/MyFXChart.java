package p2_p3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MyFXChart extends BarChart{

	private long bubbleSort;
	private long selectionSort;
	private long insertionSort;
	private static String bubbleLabel = "Bubble Sort";
	private static String selectionLabel = "Selection Sort";
	private static String insertionLabel = "Insertion Sort";
	private static CategoryAxis xAxis = new CategoryAxis();
	private static NumberAxis yAxis = new NumberAxis();
	private BarChart<String,Number> chart =  new BarChart<String,Number>(xAxis,yAxis);
	
	
	public MyFXChart(long bubbleSort, long selectionSort, long insertionSort) {
		super(xAxis, yAxis);
		this.bubbleSort = bubbleSort;
		this.selectionSort = selectionSort;
		this.insertionSort = insertionSort;
		this.chart = chart;
		this.chart.setTitle("Sorting Method Speeds");
		this.xAxis.setLabel("Method");
		this.yAxis.setLabel("Time (milliseconds)");
		XYChart.Series series = new XYChart.Series();
		series.getData().add(new XYChart.Data(bubbleLabel, bubbleSort));
		series.getData().add(new XYChart.Data(selectionLabel, selectionSort));
		series.getData().add(new XYChart.Data(insertionLabel, insertionSort));
		chart.getData().add(series);
        
       
    }


	public long getBubbleSort() {
		return bubbleSort;
	}


	public void setBubbleSort(long bubbleSort) {
		this.bubbleSort = bubbleSort;
	}


	public long getSelectionSort() {
		return selectionSort;
	}


	public void setSelectionSort(long selectionSort) {
		this.selectionSort = selectionSort;
	}


	public long getInsertionSort() {
		return insertionSort;
	}


	public void setInsertionSort(long insertionSort) {
		this.insertionSort = insertionSort;
	}


	public static String getBubbleLabel() {
		return bubbleLabel;
	}


	public static void setBubbleLabel(String bubbleLabel) {
		MyFXChart.bubbleLabel = bubbleLabel;
	}


	public static String getSelectionLabel() {
		return selectionLabel;
	}


	public static void setSelectionLabel(String selectionLabel) {
		MyFXChart.selectionLabel = selectionLabel;
	}


	public static String getInsertionLabel() {
		return insertionLabel;
	}


	public static void setInsertionLabel(String insertionLabel) {
		MyFXChart.insertionLabel = insertionLabel;
	}


	public static CategoryAxis getxAxis() {
		return xAxis;
	}


	public static void setxAxis(CategoryAxis xAxis) {
		MyFXChart.xAxis = xAxis;
	}


	public static NumberAxis getyAxis() {
		return yAxis;
	}


	public static void setyAxis(NumberAxis yAxis) {
		MyFXChart.yAxis = yAxis;
	}


	public BarChart<String, Number> getChart() {
		return chart;
	}


	public void setChart(BarChart<String, Number> chart) {
		this.chart = chart;
	}
	

}
