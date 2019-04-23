package freemail.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
	
	static Data data = new Data();
		
	public static void sendMail(String mailTo, String mailFrom, String subject, String text) {
		final String username = mailFrom;
		final String password = data.returnPassword(mailFrom);
		String host = null; 
		
		if(mailFrom.contains("@gmail.com")) {
			host = "smtp.gmail.com";
		}else if(mailFrom.contains("@outlook")) {
			host = "outlook.office365.com";
		}		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
		        	protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
			   }
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("freeMailPro1@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
		               InternetAddress.parse("jbravom1@alumnos.nebrija.es"));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}