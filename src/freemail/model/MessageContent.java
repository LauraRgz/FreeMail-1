package freemail.model;

import java.io.IOException;

import javax.mail.*;

public class MessageContent {
	
	private Part content;
	
	public MessageContent(Message message) {
		content = message;
	}
	
	public Object getContent() {
		return getMimeContent();
	}
	
	private Object getMimeContent() {
		try {
			if(isTextPlain()) {
				return getTextContent();
			}else if(isHTML()) {
				return getHTMLContent();
			}else if(isInlineImage()) {
				return "INLINE IMAGE";
			}else if(isNestedContent()) {
				return "NESTED CONTENT";
			}else if(isMultipartContent()) {
				return "Multipart content";
			}
		} catch (MessagingException | IOException e) {
			System.out.println("Some crazy error!");
		}
		return null;
	}
	
	private boolean isMultipartContent() throws MessagingException {
		return content.isMimeType("multipart/*");
	}

	private boolean isHTML() throws MessagingException {
		return content.isMimeType("text/html");
	}

	private String getHTMLContent() throws IOException, MessagingException {
		return "HTML CONTENT";
	}

	private boolean isTextPlain() throws MessagingException {
		return content.isMimeType("text/plain");
	}

	private String getTextContent() throws IOException, MessagingException{
		return (String)content.getContent();
	}
	
	private boolean isNestedContent() throws MessagingException {
		return content.isMimeType("message/rfc822");
	}
	
	private boolean isInlineImage() throws MessagingException {
		return content.isMimeType("image/jpeg");
	}
	
	
}
