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

public class ChangeAccountInformationController {

    @FXML
    private Button backButton;

    @FXML
    private Button changeInformationButton;

    @FXML
    private TextField accountNameText;

    @FXML
    private TextField mailText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private PasswordField repeatPasswordText;

    @FXML
    private TextArea statusText;

    @FXML
    private TextField newAccountNameText;

    @FXML
    private TextField newMailText;

    @FXML
    private PasswordField newPasswordText;

    @FXML
    private PasswordField newRepeatPasswordText;

    @FXML
    void pushBackButton(ActionEvent event) {
    	Main.changeAccountInformation.close();
    	Main.menu.show();
    	accountNameText.clear();
    	mailText.clear();
    	passwordText.clear();
    	repeatPasswordText.clear();
    	statusText.clear();
    	newAccountNameText.clear();
    	newMailText.clear();
    	newPasswordText.clear();
    	newRepeatPasswordText.clear();
    }

    @FXML
    void pushChangeInformation(ActionEvent event) {
    	String accountName = accountNameText.getText();
    	String mail = mailText.getText();
    	String password = passwordText.getText();
    	String repeatPassword = repeatPasswordText.getText();
    	
    	String newAccountName = newAccountNameText.getText();
    	String newMail = newMailText.getText();
    	String newPassword = newPasswordText.getText();
    	String newRepeatPassword = newRepeatPasswordText.getText();
    	
    	
    	if (password.equals(repeatPassword) && newPassword.equals(newRepeatPassword)) {
    		Credential credential = new Credential(mail, password, accountName);
    		MailProvider provider = new MailProvider(null, Protocol.IMAP);
    		Account account = new Account(credential, provider);

    		account.connect();
    		
    		Credential newCredential = new Credential(newMail, newPassword, newAccountName);
    		MailProvider newProvider = new MailProvider(null, Protocol.IMAP);
    		Account newAccount = new Account(newCredential, newProvider);
    		
    		newAccount.connect();
    		
    		if(account.isConnected() && newAccount.isConnected()) {
    			Data.editName(accountName, newAccountName);
    			Data.editMail(mail, newMail);
    			Data.editPassword(repeatPassword, newRepeatPassword);
        		
        		accountNameText.clear();
            	mailText.clear();
            	passwordText.clear();
            	repeatPasswordText.clear();
            	statusText.clear();
            	newAccountNameText.clear();
            	newMailText.clear();
            	newPasswordText.clear();
            	newRepeatPasswordText.clear();
            	
            	statusText.setText("Account Information changed");
    		}
    		else {
    			statusText.setText("Wrong Name Mail, Mail or Password");
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

}
