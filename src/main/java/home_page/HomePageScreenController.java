package home_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import login.LoginScreen;
import sign_in.SignInPageScreen;

public class HomePageScreenController {
	
	@FXML
	private Button login;
	
	@FXML
	private Button signin;
	
	public void Login(ActionEvent evemnt) {
		new LoginScreen().show();
	}
	
    public void Signin(ActionEvent evemnt) {
		new SignInPageScreen().show();
	}



}
