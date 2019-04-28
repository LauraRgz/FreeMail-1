package freemail.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

	public static void addAccount(Credential credential) {
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
	public void removeName(String nameMail) {

		try {

		    File name = new File("./NameMail.txt");

		    if (!name.isFile()) {
		        System.out.println("El fichero no existe");
		        return;
		    }

		    //Constructor del nuevo fichero
		    File tempFile = new File(name.getAbsolutePath() + ".tmp");

		    BufferedReader br = new BufferedReader(new FileReader("./NameMail.txt"));
		    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		    String line = null;

		    //Lee del fichero original y escribe en el nuevo fichero
	        //A menos que el contenido actual sea igual
		    while ((line = br.readLine()) != null) {

		        if (!line.trim().equals(nameMail)) {

		            pw.println(line);
		            pw.flush();
		        }
		    }
		    pw.close();
		    br.close();

		    //Borra el fichero orginal
		    if (!name.delete()) {
		        System.out.println("Could not delete file");
		        return;
		    }

		    //Renombra el nuevo fichero
		    if (!tempFile.renameTo(name)){
		        System.out.println("Could not rename file");

		    }
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	
	public void removeMail(String nameMail) {

		try {

		    File mail = new File("./Mail.txt");

		    if (!mail.isFile()) {
		        System.out.println("El fichero no existe");
		        return;
		    }

		    //Constructor del nuevo fichero
		    File tempFile = new File(mail.getAbsolutePath() + ".tmp");

		    BufferedReader br = new BufferedReader(new FileReader("./Mail.txt"));
		    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		    String line = null;

		    //Lee del fichero original y escribe en el nuevo fichero
	        //A menos que el contenido actual sea igual
		    while ((line = br.readLine()) != null) {

		        if (!line.trim().equals(mail)) {

		            pw.println(line);
		            pw.flush();
		        }
		    }
		    pw.close();
		    br.close();

		    //Borra el fichero orginal
		    if (!mail.delete()) {
		        System.out.println("Could not delete file");
		        return;
		    }

		    //Renombra el nuevo fichero
		    if (!tempFile.renameTo(mail)){
		        System.out.println("Could not rename file");

		    }
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
	public void removePassword(String password) {
		try {
			File pass = new File("./Password.txt");
			if(!pass.isFile()) {
				System.out.println("El fichero no existe");
				return;
			}
			//Constructor del nuevo fichero
			File tempFile = new File(pass.getAbsoluteFile() + ".tmp");
			BufferedReader br = new BufferedReader (new FileReader("./Password.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				if(!line.trim().equals(password)) {
					pw.print(password);
					pw.flush();
				}
			}
			pw.close();
			br.close();
			
			//Borra el fichero original
			if(!pass.delete()) {
				System.out.println("No se ha podido eliminar el fichero");
				return;
			}
			
			//Renombra el nuevo fichero
			if(!tempFile.renameTo(pass)) {
				System.out.println("No se ha podido renombrar el fichero");
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}


