package freemail.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Data {
	static String mailFrom;
	static String passwordFrom;
	

	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getPasswordFrom() {
		return passwordFrom;
	}
	public void setPasswordFrom(String passwordFrom) {
		this.passwordFrom = passwordFrom;
	}
	
	public String returnPassword(String nombreUsuario) {
		BufferedReader br =null;
		int count = 0;

		try {
			
			String currentLine;
		
			br = new BufferedReader(new FileReader("./Mail.txt"));
			
			while((currentLine = br.readLine()) != null) {
				
				if(currentLine.equals(nombreUsuario)) {
					
					break;	
				}
				count ++;
			}
			br = new BufferedReader(new FileReader("./Password.txt"));
			for(int i = 0; i <= count; i++) {
				
				currentLine = br.readLine();
			}
			
			passwordFrom= currentLine;
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}
		return passwordFrom;
	}

	public void addAccount(Credential credential) {
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
	
}