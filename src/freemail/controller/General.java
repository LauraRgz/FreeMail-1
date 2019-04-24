package freemail.controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class General extends Application {
	static Stage menu;
	static Stage sendMail;
	static Stage addNewAccount;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			menu = new Stage();
			URL first = getClass().getClassLoader().getResource("Menu.fxml");
			Parent rootFirst = FXMLLoader.load(first);
			Scene firstScene = new Scene(rootFirst);
			menu.setTitle("FreeMail");
			menu.setScene(firstScene);
			menu.show();
			
			sendMail = new Stage();
			URL second = getClass().getClassLoader().getResource("SendMail.fxml");
			Parent rootSecond = FXMLLoader.load(second);
			Scene secondScene = new Scene(rootSecond);
			sendMail.setTitle("FreeMail");
			sendMail.setScene(secondScene);
			
			addNewAccount = new Stage();
			URL third = getClass().getClassLoader().getResource("AddNewAccount.fxml");
			Parent rootThird = FXMLLoader.load(third);
			Scene thirdScene = new Scene(rootThird);
			addNewAccount.setTitle("FreeMail");
			addNewAccount.setScene(thirdScene);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Inicio() {
		launch(null);
	}
}
