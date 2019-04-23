package freemail.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	String returnPassword(String nombreUsuario) {
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
	
}