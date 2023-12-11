package search_user;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management.UserManagementScreen;

public class SearchUserController {

	

	@FXML
	private TextField username;

	@FXML
	private TextField mobile;

	@FXML
	private TextField email;

	@FXML
	private TextField role;

	@FXML
	private TextField password;

	@FXML
	private TextField confirm;

	@FXML
	private Button search;

	@FXML
	private Button edit;

	@FXML
	private Button delete;

	@FXML
	private Button close;
	
//	@FXML
//	private Button userMessage;

	public void searchButton(ActionEvent event) throws SQLException {
		boolean status = Search_User(username.getText());

		if (status) {
			System.out.println("User Search Successfully");

		} else {
			System.out.println("User Not Found !!");
		}
	}

	public boolean Search_User(String username) throws SQLException {
		String query = "SELECT * FROM users WHERE username = '" + username + "'";

		ResultSet rs = DBUtils.executeQueryGetResult(query);

		try {
			if (rs.next()) {
				//username.setText(rs.getString("username"));
				email.setText(rs.getString("email"));
				mobile.setText(rs.getString("number"));
				role.setText(rs.getString("role"));
				password.setText(rs.getString("password"));
				confirm.setText(rs.getString("confirm"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void editButton(ActionEvent event) {
		boolean status = Edit_User(username.getText());
		if (status) {
			System.out.println("User Edited successfully.");
		} else {
			System.out.println("User not found.");
		}
	}

	public boolean Edit_User(String usernames) {
		String Query = "select * from users where username = '" + usernames + "'";

		ResultSet rs = DBUtils.executeQueryGetResult(Query);
		try {
			if (rs.next()) {
				String query = "UPDATE users SET username = '" + username.getText() + "', " + "email = '"
						+ email.getText() + "', " + "number = '" + mobile.getText() + "', " + "role = '"
						+ role.getText() + "'," + "password = '" + password.getText() + "'," + "confirm = '"
						+ confirm.getText() + "'" + "WHERE username = '" + usernames + "'";

				DBUtils.executeQuery(query);

				System.out.println("User updated successfully.");

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteButton(ActionEvent event) {
		boolean status = SearchUserController.Delete_User(username.getText());

		if (status) {
			System.out.println("USER DELETED SUCCESSFULLY");
		} else {
			System.out.println("!!!!USER NOT FOUND!!!!!");
		}
	}

	public static boolean Delete_User(String Username) {

		String query = "DELETE FROM users WHERE username = '" + Username + "'";

		DBUtils.executeQuery(query);
		return true;
	}

	public void closeButton(ActionEvent event) {
		new UserManagementScreen().show();
	}

}
