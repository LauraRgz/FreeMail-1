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
    	Main.menu.close();
    	Main.addNewAccount.show();
    }

    @FXML
    void pushChangeAccountInformationButton(ActionEvent event) {
    	Main.menu.close();
    	Main.changeAccountInformation.show();
    }

    @FXML
    void pushDeleteAccountButton(ActionEvent event) {
    	Main.menu.close();
    	Main.deleteAccount.show();
    }

    @FXML
    void pressedRecievedMessages(ActionEvent event) {
    	Main.menu.close();
    	Main.showMessage.show();
    }

    @FXML
    void pushSendMailButton(ActionEvent event) {
    	Main.menu.close();
    	Main.sendMail.show();
    }

}
