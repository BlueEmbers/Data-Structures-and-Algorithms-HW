package test;

import bags.UserAccountBag;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import users.UserAccount;
import utilities.SearchUsersUtil;
import utilities.SortArraysNew;
import view.AlertBox;
import view.LoginWindow;

public class demo extends Application {
	static UserAccountBag sortedUserBag;

	public static void main(String[] args) {
		UserAccountBag userBag = new UserAccountBag();
		userBag.displayBag();
		sortedUserBag = SortArraysNew.sortArrays(userBag.getUsers());
		SearchUsersUtil.createArrayNoNulls(sortedUserBag.getUsers());
		int trial = sortedUserBag.getnElems();
		System.out.println(sortedUserBag.getUsers()[trial - trial].toString());
		System.out.println(sortedUserBag.getUsers()[trial / 2].toString());
		System.out.println(sortedUserBag.getUsers()[trial - 1].toString());
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		LoginWindow login = new LoginWindow();
		Scene scene = new Scene(login.getContentPane(), 400, 125);
		stage.setScene(scene);
		stage.setTitle("User Login");
		stage.show();
		login.getLoginBtn().setOnAction(e -> {
			String userName = login.getTxtUsername().getText();
			String password = login.getTextPassword().getText();
			try {
				UserAccount compare = SearchUsersUtil.getUserFromUserName(userName);
				if (compare.getUserName().equals(userName) && compare.getPassword().equals(password)) {
					AlertBox.display("Success");
				} else {
					AlertBox.display("Failure");
				}
			} catch (Exception ex) {
				AlertBox.display("Failure");
			}
		});
	}
}
