package GUI2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class UserAccountGUIDemo {


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame mainPane;
				try {
					mainPane = new Main("User Account Management System");
					mainPane.setSize(700, 200);
					mainPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mainPane.setVisible(true);
				//	mainPane.setStyle("-fx-background-color: #500000;");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});

   }

}
