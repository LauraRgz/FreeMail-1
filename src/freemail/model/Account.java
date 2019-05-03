package freemail.model;

import java.io.*;

import javax.mail.*;

public class Account {

	private Credential credential;
	private MailProvider provider;
	private Store store;
	private Folder folder;
	
	public Account(Credential credential, MailProvider provider) {
		this.credential = credential;
		this.provider = provider;
		if(credential.getMailAddress().contains("@gmail.com")) {
			this.provider.setHost("imap.gmail.com");
		}else if(credential.getMailAddress().contains("@outlook")) {
			this.provider.setHost("imap-mail.outlook.com");
		}
	}
	
	public boolean isConnected() {
		return store.isConnected();
	}
	
	public void connect() {
		try {
			setStore();
			store.connect(getHost(), getMailAddress(), getPassword());
			setFolder();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public Message[] fetchMessages() throws MessagingException {
		return folder.getMessages();
	}

	public String getMailAddress() {
		return credential.getMailAddress();
	}
	
	public String getHost() {
		return provider.getHost();
	}
	
	public String getPassword() {
		return credential.getPassword();
	}
	
	private void setStore() throws MessagingException {
		store = provider.getStore();
	}
	
	private void setFolder() throws MessagingException {
		if(isConnected()) {
			folder = getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
		}
	}
	
	private Folder getFolder(String folder) throws MessagingException {
		return store.getFolder(folder);
	}
}
