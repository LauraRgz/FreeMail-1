package freemail.model;

import javax.mail.*;

public class MessageContent {
	
	private Message content;
	
	public MessageContent(Message message) {
		content = message;
	}
	
	public String getSubject() throws MessagingException {
		return content.getSubject();
	}
	
	public String getFrom() throws MessagingException {
		Address[] address = content.getFrom();
		return address[0].toString();
	}
	
	@Override
	public String toString() {
		try {
			return getSubject() + " - " + getFrom();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getContent() throws Exception {
		return writePart(content);
	}
	
	private String writePart(Part p) throws Exception {
		//check if the content is plain text
		if (p.isMimeType("text/plain")) {
		   return (String) p.getContent();
		} 
		//check if the content has attachment
		else if (p.isMimeType("multipart/*")) {
		   Multipart mp = (Multipart) p.getContent();
		   int count = mp.getCount();
		   for (int i = 0; i < count; i++)
		      writePart(mp.getBodyPart(i));
		}
		return "Multimedia not available."; 
	}
}
