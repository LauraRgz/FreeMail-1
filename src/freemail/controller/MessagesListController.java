package freemail.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MessagesListController {

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private ListView<?> messageList;

    @FXML
    void editCancel(ActionEvent event) {

    }

    @FXML
    void editCommit(ActionEvent event) {

    }

    @FXML
    void editStart(ActionEvent event) {

    }

    @FXML
    void pushBackButton(ActionEvent event) {
    	General.messagesList.close();
    	General.receivedMessagesMail.show();
    }

    @FXML
    void pushNextButton(ActionEvent event) {
    	General.messagesList.close();
    	General.messageContent.show();
    }

}
