package gui;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import user_account_module.User;
import user_account_module.UserBag;

public class MainPane {
	public GridPane grid;
	private TextField userField;
	private TextField passField;
	private Button logonBtn;
	private UserBag userBag;
	
	public MainPane() {
		userBag = new UserBag(5000);
		try {
			userBag.importUsers();
			userBag.display();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		userField = new TextField();
		userField.setPromptText("Username");
		userField.setPrefWidth(300);
		
		passField = new TextField();
		passField.setPromptText("Password");
		passField.setPrefWidth(300);
		
		logonBtn = new Button("Log in");
		logonBtn.setOnAction(e -> {
			User user = userBag.search(userField.getText(), passField.getText());
			if(user !=null) {
				System.out.println(user.firstName + " has logged in");
			} else {
				System.out.println("Password not found");
			}
		});
		
		grid = new GridPane();
		grid.add(userField, 0, 0);
		grid.add(passField, 0, 1);
		grid.add(logonBtn, 0, 2);
		
	}
}
