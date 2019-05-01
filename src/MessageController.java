
import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;

import freemail.controller.Main;
import freemail.model.Account;
import freemail.model.Credential;
import freemail.model.MailProvider;
import freemail.model.MailProvider.Protocol;
import freemail.model.MessageContent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class MessageController implements Initializable{
		
	private ObservableList<MessageContent> messageObservableList;

    @FXML
    private ListView<MessageContent> messageList;
    
    //TODO: To check this interface you have to put a real mail.
    private Credential credential = new Credential("example@mail.com", "example", "example");
    private MailProvider provider = new MailProvider(null, Protocol.IMAP);
    private Account account = new Account(credential, provider);

    @FXML
    private Label fromLabel;

    @FXML
    private Label subjectLabel;

    @FXML
    private Label contentLabel;

    @FXML
    void checkMessages(ActionEvent event) {
		try {
			setNewMessages();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void goBack(ActionEvent event) {
    	Main.showMessage.close();
    	Main.menu.show();
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setMessages();
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
