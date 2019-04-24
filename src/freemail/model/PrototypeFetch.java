package freemail.model;

import javax.mail.*;

import freemail.controller.General;
import freemail.model.MailProvider.Protocol;

public class PrototypeFetch {
	
	public static void main(String... args) throws MessagingException {
		
		General.Inicio();
		
		//String pop3Host = "imap.gmail.com";
		//String pop3Host = "imap-mail.outlook.com";
		String pop3Host = null;

		Credential credential = new Credential("mailexample@mail.com","password", "name");
		MailProvider provider = new MailProvider(pop3Host, Protocol.IMAP);
		Account account = new Account(credential, provider);
		account.connect();
		
		Message[] a = account.fetchMessages();
		for(Message msg: a) {
			System.out.println(msg.getSubject());
		}
	}
	
}
