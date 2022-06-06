package utils.main;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * servidor smtp: smtp.gmail.com
 * puerto smtp: 587 o 465
 * usuario: pruebacore122a@gmail.com
 * password: pepitoperez
 */

public class UEmail {

	public static boolean send(String to, String subject, String text, String fileAttachment) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("pruebacore122a@gmail.com",
						"pepitoperez");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("account"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Asunto
			message.setSubject("");
			if (subject != null) {
				message.setSubject(subject);
			}

			// Mensaje
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("");
			if (text != null) {
				messageBodyPart.setText(text);
			}
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			
			message.setContent(multipart);
			Transport.send(message);

			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
