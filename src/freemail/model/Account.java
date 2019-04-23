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
		}else if(credential.getMailAddress().contains("@outlook.com")) {
			this.provider.setHost("imap-mail.outlook.com");
		}
	}
	
	public boolean isConnected() {
		return store.isConnected();
	}
	
	private void addAccount() {
		FileWriter fw1 = null;
		FileWriter fw2 = null;
		FileWriter fw3 = null;
		
		try {
			File filePassword = new File("./Password.txt");
			File fileMail = new File("./Mail.txt");
			File fileNameMail = new File("./NameMail.txt");
			
			fw1 = new FileWriter(filePassword.getAbsoluteFile(), true);
			fw1.write(credential.getPassword() + "\r\n");
			fw1.close();
			
			fw2 = new FileWriter(fileMail.getAbsoluteFile(),true);
			fw2.write(credential.getMailAddress() + "\r\n");
			fw2.close();
			
			fw3 = new FileWriter(fileNameMail.getAbsoluteFile(),true);
			fw3.write(credential.getName() + "\r\n");
			fw3.close();
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw1 != null) 
					fw1.close();
				else if(fw2 != null )
					fw2.close();
				else if(fw3 != null)
					fw3.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	
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
	
	private String getPassword() {
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
