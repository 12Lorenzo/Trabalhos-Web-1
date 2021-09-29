package br.ufscar.dsw1.katchau.entidade;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

//É a classe responsavel por enviar o email

public class EmailService {

	public int send(InternetAddress from, InternetAddress to, String subject, String body, File file) {

		try {

			Properties prop = new Properties();
			InputStream is = EmailService.class.getClassLoader().getResourceAsStream("config.properties");

			if (is != null) {
				prop.load(is);
			} else {
				throw new FileNotFoundException("config.properties not found in the classpath");
			}

			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			Session session = Session.getInstance(prop, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(from);
			message.setRecipient(Message.RecipientType.TO, to);
			message.setSubject(subject);

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(body, "text/plain");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			
			if (file != null) {
				MimeBodyPart attachmentBodyPart = new MimeBodyPart();
				attachmentBodyPart.attachFile(file);
				multipart.addBodyPart(attachmentBodyPart);	
			}
			
			message.setContent(multipart);
			Transport.send(message);
			
			System.out.println("Mensagem enviada com sucesso!");
			return 0;
		} catch (Exception e) {
			System.out.println("Mensagem não enviada!");
			return 10;
		}
	}
	
	public int send(InternetAddress from, InternetAddress to, String subject, String body) {
		return send(from, to, subject, body, null);
	}
}
