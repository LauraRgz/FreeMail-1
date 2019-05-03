package freemail.controller;

import javax.mail.Message;
import javax.mail.MessagingException;

import freemail.controller.General;
import freemail.model.Account;
import freemail.model.Credential;
import freemail.model.Data;
import freemail.model.MailProvider;
import freemail.model.MailProvider.Protocol;
import freemail.model.MessageContent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class MessageController{
		
	private ObservableList<MessageContent> messageObservableList;
	
	private Account account;

    @FXML
    private ListView<MessageContent> messageList;
    
    @FXML
    private TextField emailTextField;

    @FXML
    private Label fromLabel;

    @FXML
    private Label subjectLabel;

    @FXML
    private Label contentLabel;

    @FXML
    void checkMessages(ActionEvent event) {
		try {
			Data data = new Data();
			String mail = emailTextField.getText();
			String password = data.returnPassword(mail);
			account = new Account(new Credential(mail, password, "fetch"), new MailProvider(null, Protocol.IMAP));
			account.connect();
			if(account.isConnected()) {
				setNewMessages();
			}else {
				emailTextField.clear();
				emailTextField.setText("Set a correct mail please");
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void goBack(ActionEvent event) {
    	General.showMessage.close();
    	General.menu.show();
    }

	private void setNewMessages() throws MessagingException {
		messageList.setItems(null);
		getMessages();
		setMessages();
	}
	
	private void setMessages() {
    	try {
			getMessages();
			messageList.setItems(messageObservableList);
			messageList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MessageContent>() {

				@Override
				public void changed(ObservableValue<? extends MessageContent> observable, MessageContent oldValue,
						MessageContent newValue) {
					try {
						fromLabel.setText(newValue.getFrom());
						subjectLabel.setText(newValue.getSubject());
						contentLabel.setText(newValue.getContent());
					} catch (MessagingException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
    
    private void getMessages() throws MessagingException {
    	account.connect();
    	messageObservableList = FXCollections.observableArrayList();
    	Message[] msg = account.fetchMessages();
    	int lenght = account.fetchMessages().length;
    	for(int i = 0; i < lenght; i++) {
    		messageObservableList.add(new MessageContent(msg[lenght - i - 1]));
    	}
    }

}