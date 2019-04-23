package freemail.model;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Credential {
	
	private InternetAddress mailAddress;
	private String password;
	private String name;
	
	public Credential(String mailAdress, String password, String name) {
		try {
			this.mailAddress = new InternetAddress(mailAdress);
			this.password = password;
			this.name = name;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
