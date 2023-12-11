package user_management;


import add_user.AddUserScreen;
import home_Screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserManagementScreenController {

	@FXML
	private Button addUser;

	@FXML
	private Button searchUser;

	@FXML
	private Button editUser;

	@FXML
	private Button quitUser;

	@FXML
	private Button deleteUser;

	public void AddUser(ActionEvent event) {
		new AddUserScreen().show();
	}

	public void SearchUser(ActionEvent event) {
		new search_user.SearchUser().show();
	}

	public void EditUser(ActionEvent event) {
		new search_user.SearchUser().show();
	}

	public void QuitUser(ActionEvent event) {
		new HomeScreen().show();
	}

	public void DeleteUser(ActionEvent event) {
		new search_user.SearchUser().show();
	}

}
