package freemail.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class MenuController {

    @FXML
    private Button sendMailButton;

    @FXML
    private Button recievedMessages;

    @FXML
    private MenuItem addAccountButton;

    @FXML
    private MenuItem changeAccountInformationButton;

    @FXML
    private MenuItem deleteAccountButton;

    @FXML
    void pushAddAccountButton(ActionEvent event) {
    	General.menu.close();
    	General.addNewAccount.show();
    }

    @FXML
    void pushChangeAccountInformationButton(ActionEvent event) {
    	General.menu.close();
    	General.changeAccountInformation.show();
    }

    @FXML
    void pushDeleteAccountButton(ActionEvent event) {
    	General.menu.close();
    	General.deleteAccount.show();
    }

    @FXML
    void pressedRecievedMessages(ActionEvent event) {
    	General.menu.close();
    	General.showMessage.show();
    }

    @FXML
    void pushSendMailButton(ActionEvent event) {
    	General.menu.close();
    	General.sendMail.show();
    }

}
