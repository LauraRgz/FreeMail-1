package freemail.model;

import java.util.Properties;

import javax.mail.*;

public class MailProvider{
	
	public enum Protocol{
		POP3,
		IMAP
	}
	
	private String host;
	private Protocol protocol;
	private Session session;
	
	public MailProvider(String host, Protocol protocol) {
		this.host = host;
		this.protocol = protocol;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public Store getStore() throws NoSuchProviderException {
		openSession();
		return session.getStore(protocol.equals(Protocol.POP3) ? "pop3s" : "imaps");
	}
	
	private void openSession() {
		session = Session.getDefaultInstance(generateProperties());
	}
	
	private Properties generateProperties() {
		Properties generated = null;
		if(protocol.equals(Protocol.POP3)) {
			generated = generatePop3();
		}else if(protocol.equals(Protocol.IMAP)){
			generated = generateImap();
		}
		return generated;
	}
	
	private Properties generatePop3() {
		Properties pop3 = new Properties();
		pop3.put("mail.store.protocol", "pop3s");
        pop3.put("mail.pop3.host", host);
        pop3.put("mail.pop3.port", "995");
        pop3.put("mail.pop3.starttls.enable", "true");
		return pop3;
	}
	
	private Properties generateImap() {
		Properties imap = new Properties();
		imap.put("mail.store.protocol", "imaps");
        imap.put("mail.imaps.host", host);
        imap.put("mail.imaps.port", "993");
        imap.put("mail.imaps.starttls.enable", "true");
		return imap;
	}
	
}


