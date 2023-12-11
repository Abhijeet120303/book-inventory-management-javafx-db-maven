package book_store;

import add_book.AddBookScreen;
import home_Screen.HomeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_book.SearchBookScreen;

public class BookScreenController {
	
	@FXML
	private Button addbook;
	
	@FXML
	private Button searchproduct;
	
	@FXML
	private Button editbook;
	
	@FXML
	private Button deletebook;
	
	@FXML
	private Button searchbook;
	
	public void addBook(ActionEvent event) {
		new AddBookScreen().show();
	}
	
	public void searchBook(ActionEvent event) {
		new SearchBookScreen().show();
	}
	
	public void editBook(ActionEvent event) {
		new SearchBookScreen().show();
	}
	
	public void deleteBook(ActionEvent event) {
		new SearchBookScreen().show();
	}
	
	public void quiteBook(ActionEvent event) {
		new HomeScreen().show();
	}

}
