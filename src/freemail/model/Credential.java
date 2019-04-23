package freemail.model;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Credential {
	
	private InternetAddress mailAddress;
	private String password;
	
	public Credential(String mailAdress, String password) {
		try {
			this.mailAddress = new InternetAddress(mailAdress);
			this.password = password;
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
	
	public String getMailAddress() {
		return mailAddress.getAddress();
	}
	
	public String getPassword() {
		return password;
	}
}
