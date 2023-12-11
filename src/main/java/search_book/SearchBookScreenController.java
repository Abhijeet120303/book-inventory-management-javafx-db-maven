
package search_book;

import java.sql.ResultSet;
import java.sql.SQLException;

import book_store.BookScreen;
import dbUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SearchBookScreenController {
	
	
	
	@FXML
	private TextArea bookName;
	
	@FXML
	private TextArea author;
	
	@FXML
	private TextArea price;
	
	@FXML
	private TextArea quantity;
	
	@FXML
	private TextArea category;
	
	@FXML
	private Button search;
	
	@FXML
	private Button close;
	
	@FXML
	private Button delete;
	
	@FXML
	private Button edit;
	
	public void searchBook(ActionEvent event) throws SQLException {
		boolean status =Search_Book(bookName.getText());

		if(status) {
			
		}else {
			System.out.println("Book Not Found !!");
	}
	}
	public boolean Search_Book(String bookNames) throws SQLException {
			String query = "SELECT * FROM books WHERE bookname = '"+bookNames+"'";

			ResultSet rs = DBUtils.executeQueryGetResult(query);

			try {
				if(rs.next()) {
					bookName.setText(rs.getString("bookname"));
					author.setText(rs.getString("author"));
					price.setText(rs.getString("price"));
					quantity.setText(rs.getString("quantity"));
					category.setText(rs.getString("category"));

					return true;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	
    
    public void editBook(ActionEvent event) {
    	boolean status = Edit_Book(bookName.getText());
		if(status) {
			System.out.println("Book Edited successfully.");
		}
		else {
			System.out.println("Book not found.");
		}
	} 
    public boolean Edit_Book(String bookNames) {
		String Query = "select * from books where bookname = '"+bookNames+"'";

		ResultSet rs = DBUtils.executeQueryGetResult(Query);
		try {
			if(rs.next()) {
				String query = "UPDATE books SET bookname = '"+bookName.getText()+"', "
						+ "author = '" +author.getText()  + "', " 
						+ "price = '"+price.getText()+"', "
						+ "quantity = '"+quantity.getText()+"',"
						+ "category = '"+category.getText()+"'"
						+ "WHERE bookname = '"+bookNames+"'";

				DBUtils.executeQuery(query);

				System.out.println("Book updated successfully.");

				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    
    public void deleteBook(ActionEvent event) {
    	boolean status = Delete_Book(bookName.getText());

		if(status) {
			System.out.println("Book DELETED SUCCESSFULLY");
		}
		else {
			System.out.println("!!!!Book NOT FOUND!!!!!");
		}
	}
	public static boolean Delete_Book(String name) {

		String query = "DELETE FROM books WHERE bookname = '"+name+"'";

		DBUtils.executeQuery(query);
		return true;
	}
	
	public void closeBook(ActionEvent event) {
    	new BookScreen().show();
	} 
    
		

	

}
