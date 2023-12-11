
package boo_store_management_main;

import common.StageFactory;
import home_page.HomePageScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main_Application extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override

	public void start(Stage stage) throws Exception {
		StageFactory.stage = stage;
		new HomePageScreen().show();
	}

}
