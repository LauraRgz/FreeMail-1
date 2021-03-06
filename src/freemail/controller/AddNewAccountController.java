package freemail.controller;

import freemail.model.Account;
import freemail.model.Credential;
import freemail.model.Data;
import freemail.model.MailProvider;
import freemail.model.MailProvider.Protocol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddNewAccountController {

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private TextField accountNameText;

    @FXML
    private TextField mailText;

    @FXML
    private PasswordField repeatPasswordText;

    @FXML
    private PasswordField passwordText;
    
    @FXML
    private TextArea statusText;

    @FXML
    void pushAddButton(ActionEvent event) {
    	String accountName = accountNameText.getText();
    	String mail = mailText.getText();
    	String password = passwordText.getText();
    	String repeatPassword = repeatPasswordText.getText();
    	
    	if (password.equals(repeatPassword)) {
    		Credential credential = new Credential(mail, password, accountName);
    		MailProvider provider = new MailProvider(null, Protocol.IMAP);
    		
    		Account account = new Account(credential, provider);
    		
    		account.connect();
    		
    		if(account.isConnected()) {
    			Data.addAccount(credential);
        		
        		accountNameText.clear();
        		mailText.clear();
        		passwordText.clear();
        		repeatPasswordText.clear();
        		
        		statusText.setText("User created successfully");
    		}
    		else {
    			statusText.setText("Wrong Mail or Password");
    		}
    	}
    	else {
    		accountNameText.clear();
    		mailText.clear();
    		passwordText.clear();
    		repeatPasswordText.clear();
    		
    		statusText.setText("Password do not match");
    	}
    }

    @FXML
    void pushBackButton(ActionEvent event) {
    	General.addNewAccount.close();
    	General.menu.show();
    	accountNameText.clear();
    	mailText.clear();
    	passwordText.clear();
    	repeatPasswordText.clear();
    	statusText.clear();
    }

}
