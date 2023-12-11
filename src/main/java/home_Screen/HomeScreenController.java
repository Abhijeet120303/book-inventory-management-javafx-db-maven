package home_Screen;

import book_store.BookScreen;
import home_page.HomePageScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import user_management.UserManagementScreen;

public class HomeScreenController {
	
	@FXML
	private Button usermanagement;
	
	@FXML
	private Button bookManagement;
	
	@FXML
	private Button quit;
	
	public void  userManagement(ActionEvent event) {
		new UserManagementScreen().show();
	}
	
    public void  bookManagement(ActionEvent event) {
		new BookScreen().show();
	}

    public void  Quit(ActionEvent event) {
	    new HomePageScreen().show();
    }
}
