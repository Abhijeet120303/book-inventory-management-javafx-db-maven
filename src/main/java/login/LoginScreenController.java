package login;

import java.sql.ResultSet;
import java.sql.SQLException;

import home_Screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginScreenController {
	
	@FXML
	private TextField userName;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button loginButton;
	
	public void logIn(ActionEvent event) {
		boolean start = LoginScreenController.isValidateUsernameAndPassword(userName.getText(), password.getText());
		if (start) {
			System.out.println("Login Sucsses");
			new HomeScreen().show();
		} else {
			System.out.println("Login Failed");
		}

	}

	public static boolean isValidateUsernameAndPassword(String userName, String password) {

		String query = " Select * from users where username='" + userName + "' and password = '" + password + "' ";

		ResultSet rs = dbUtils.DBUtils.executeQueryGetResult(query);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



}
