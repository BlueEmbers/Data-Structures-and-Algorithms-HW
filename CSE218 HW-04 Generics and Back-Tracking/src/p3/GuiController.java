package p3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiController implements Initializable
{
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button[][] buttons;
	
	private BugGame bg;
	
	@FXML
	public void showValue(ActionEvent e) 
	{
		System.out.println(b1.hashCode() + " " + b2.hashCode());
		GridPane root = bg.getGrid();
		root.setPadding(new Insets(10,10,10,10));
		BorderPane bp = new BorderPane();
		bp.setCenter(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(bp, 500, 400);
		window.setScene(scene);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		bg = new BugGame();
		buttons = bg.getGameTable();
		buttons[bg.getStack().getFirst().getX()][bg.getStack().getFirst().getY()].setGraphic(bg.getImage());
	}
}
