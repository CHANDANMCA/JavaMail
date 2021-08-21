package com.java.mail;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class Sender {
	public static void send(final String from, final String password, String to, String sub, String msg) {

		// Get propertis object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		//get session
		Session session=Session.getDefaultInstance(props,new Authenticator() {
			 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				 return new javax.mail.PasswordAuthentication(from, password);
				 
			 }
		});
		
		try {
			MimeMessage mm=new 	MimeMessage(session);
			mm.addRecipient(Message.RecipientType.TO, new InternetAddress());
			mm.setSubject(sub);
			mm.setText(msg);
			Transport.send(mm);
			System.out.println("mail success fully");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}

public class Mailer {
	public static void main(String[] args) {
		
Sender.send("cks25ab@gamil.com", "86584021", "chandanswainmca@gmail.com", "hello chandan", "how are you");
	}

}
