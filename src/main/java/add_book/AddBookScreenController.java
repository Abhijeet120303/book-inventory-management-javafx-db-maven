package add_book;

import book_store.BookScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AddBookScreenController {

	@FXML
	private TextArea BookName;

	@FXML
	private TextArea Author;

	@FXML
	private TextArea Price;

	@FXML
	private TextArea Quantity;

	@FXML
	private TextArea Category;

	@FXML
	private Button save;

	@FXML
	private Button cancel;

	public void saveProductINFO(ActionEvent event) {

		String query = "INSERT INTO books(bookname,author,price,quantity,category) Values ('" + BookName.getText()
				+ "','" + Author.getText() + "','" + Price.getText() + "','" + Quantity.getText() + "','"
				+ Category.getText() + "')";
		dbUtils.DBUtils.executeQuery(query);
	}

	public void cancelProduct(ActionEvent event) {
		new BookScreen().show();
	}

}
