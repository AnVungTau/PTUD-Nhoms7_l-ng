package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author Nguyễn Hồng Quân
 */
public class GuiEmail {
	
	public static boolean send(String to, String contend) {
		final String from = "viefilm1@gmail.com";
		final String password = "xfjwrzfyaxwvepbk";

		final String toEmail = to;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
			
		};
		
		Session session = Session.getInstance(props, auth);
		
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.addHeader("Contend-type", "text/HTML; charset=UTF-8");
			msg.setFrom();
			msg.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(toEmail, false));
			msg.setSubject("Mã xác thực của bạn là: ");
			msg.setContent("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<h1>"+ contend +"</h1>\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>", "text/html");
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
