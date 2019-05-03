package freemail.controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class General extends Application {
	
	public static Stage menu;
	static Stage sendMail;
	static Stage addNewAccount;
	public static Stage showMessage;
	static Stage deleteAccount;
	static Stage changeAccountInformation;

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
			
			showMessage = new Stage();
			URL messageFile = getClass().getClassLoader().getResource("MessageView.fxml");
			Parent message = FXMLLoader.load(messageFile);
			Scene messageView = new Scene(message);
			showMessage.setTitle("FreeMail");
			showMessage.setScene(messageView);
			
			addNewAccount = new Stage();
			URL third = getClass().getClassLoader().getResource("AddNewAccount.fxml");
			Parent rootThird = FXMLLoader.load(third);
			Scene thirdScene = new Scene(rootThird);
			addNewAccount.setTitle("FreeMail");
			addNewAccount.setScene(thirdScene);
			
			deleteAccount = new Stage();
			URL seventh = getClass().getClassLoader().getResource("DeleteAccount.fxml");
			Parent rootSeventh = FXMLLoader.load(seventh);
			Scene seventhScene = new Scene(rootSeventh);
			deleteAccount.setTitle("FreeMail");
			deleteAccount.setScene(seventhScene);
			
			changeAccountInformation = new Stage();
			URL eigth = getClass().getClassLoader().getResource("ChangeAccountInformation.fxml");
			Parent rootEigth = FXMLLoader.load(eigth);
			Scene eigthScene = new Scene(rootEigth);
			changeAccountInformation.setTitle("FreeMail");
			changeAccountInformation.setScene(eigthScene);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void start() {
		launch(null);
	}
}
