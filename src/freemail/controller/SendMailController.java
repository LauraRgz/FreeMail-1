package freemail.controller;

import freemail.model.SendMail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendMailController {

    @FXML
    private Button backButton;

    @FXML
    private Button sendButton;

    @FXML
    private TextField fromText;

    @FXML
    private TextField toText;

    @FXML
    private TextField subjectText;

    @FXML
    private TextField mailText;
    
    @FXML
    private static TextArea statusText;

    @FXML
    void pushBackButton(ActionEvent event) {
    	General.sendMail.close();
    	General.menu.show();
    	fromText.clear();
    	toText.clear();
    	subjectText.clear();
    	mailText.clear();
    	statusText.clear();
    }
    
    @FXML
    void pushSendButton(ActionEvent event) {
    	String to = toText.getText();
    	String from = fromText.getText();
    	String subject = subjectText.getText();
    	String text = mailText.getText();
    	
    	SendMail.sendMail(to, from, subject, text);
    }
    
    public static void messageSent(Boolean messageSent) {
    	if (messageSent) {
    		statusText.setText("Message sent successfully");
    	}
    	else {
    		statusText.setText("Error sending mail");
    	}
    }
}
