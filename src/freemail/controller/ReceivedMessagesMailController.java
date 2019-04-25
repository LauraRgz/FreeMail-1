package freemail.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ReceivedMessagesMailController {

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private TextField mailText;

    @FXML
    void pushBackButton(ActionEvent event) {
    	General.receivedMessagesMail.close();
    	General.menu.show();
    }

    @FXML
    void pushNextButton(ActionEvent event) {
    	General.receivedMessagesMail.close();
    	General.messagesList.show();
    }

    @FXML
    void writeMail(ActionEvent event) {

    }

}