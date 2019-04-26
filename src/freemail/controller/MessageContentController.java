package freemail.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MessageContentController {

    @FXML
    private Button backButton;

    @FXML
    private TextArea mailFrom;

    @FXML
    private TextArea mailSubject;

    @FXML
    private TextArea MessageContentText;

    @FXML
    void pushBackButton(ActionEvent event) {
    	General.messageContent.close();
    	General.messagesList.show();
    }

}
