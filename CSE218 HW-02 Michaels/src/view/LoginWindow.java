package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class LoginWindow {

	private TextField txtUsername;
	private Label lblLogin;
	private TextField textPassword;
	private Label lblUsername;
	private Label lblPassword;
	private String userName;
	private String password;
	private Button loginBtn;
	private GridPane contentPane;
	private Button newUserBtn;

	public LoginWindow() {

		contentPane = new GridPane();
		lblLogin = new Label("UserAccount Login");
		lblLogin.setFont(new Font("Sitka Subheading", 30));
		contentPane.add(lblLogin, 0, 0, 2, 1);

		lblUsername = new Label("User Name");
		lblUsername.setFont(new Font("Sitka Subheading", 25));
		txtUsername = new TextField();
		txtUsername.setFont(new Font("Tahoma", 15));
		contentPane.add(lblUsername, 0, 1);
		contentPane.add(txtUsername, 1, 1);

		lblPassword = new Label("Password");
		lblPassword.setFont(new Font("Sitka Subheading", 25));
		textPassword = new TextField();
		textPassword.setFont(new Font("Tahoma", 15));
		contentPane.add(lblPassword, 0, 2);
		contentPane.add(textPassword, 1, 2);

		loginBtn = new Button();
		loginBtn.setText("Login");
		contentPane.add(loginBtn, 0, 3);
		
		newUserBtn = new Button();
		newUserBtn.setText("New User");
		//contentPane.add(newUserBtn, 1,3);

	}

	public TextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(TextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public TextField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(TextField textPassword) {
		this.textPassword = textPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Button getLoginBtn() {
		return loginBtn;
	}
	

	public Button getNewUserBtn() {
		return newUserBtn;
	}

	public Pane getContentPane() {
		return contentPane;
	}

}
