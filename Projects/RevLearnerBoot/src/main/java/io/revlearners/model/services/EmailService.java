package io.revlearners.model.services;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

@Component
public class EmailService {
	private static final long EMAIL_TIMEOUT = 100;
	private static final Properties SMTP_PROPERTIES = new Properties();
	private static final String REVLEARNERS_EMAIL, REVLEARNERS_PASSWORD, SMTP_HOST, SMTP_PORT;

	// TODO: this may change in EC2 deployment
	private static final String  VERIFICATION_ENDPOINT_TEMPLATE = "http://localhost:4200/verify?token=%s";  // to be filled in with token

	private static final String VERIFICATION_EMAIL_TEMPLATE = "<h3>RevLearners</h3>" + "<p>Welcome young RevLearner</p>"
			+ "<p>Please click the link below to activate you account</p>" + "<div>"
			+ "<a href='"+ VERIFICATION_ENDPOINT_TEMPLATE + "'>Verify</a>" + "</div>";
	private static final String VERIFICATION_EMAIL_SUBJECT_TEMPLATE = "Welcome Young RevLearner";

	static {
		REVLEARNERS_EMAIL = System.getenv("REVLEARNERS_EMAIL");
		REVLEARNERS_PASSWORD = System.getenv("REVLEARNERS_PASSWORD");
		SMTP_PORT = System.getenv("SMTP_PORT");
		SMTP_HOST = System.getenv("SMTP_HOST");
		SMTP_PROPERTIES.put("mail.smtp.host", SMTP_HOST);
		SMTP_PROPERTIES.put("mail.smtp.socketFactory.port", SMTP_PORT);
		SMTP_PROPERTIES.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		SMTP_PROPERTIES.put("mail.smtp.auth", true);
		SMTP_PROPERTIES.put("mail.smtp.port", SMTP_PORT);
		SMTP_PROPERTIES.put("mail.smtp.connectiontimeout", EMAIL_TIMEOUT);
		SMTP_PROPERTIES.put("mail.smtp.EMAIL_TIMEOUT", EMAIL_TIMEOUT);
	}

	/**
     * send verification email to a newly registering user; email contains a link to which will
     * set their user status to ok (from pending status)
     * @param recipientEmail
     * @param token
     * @return
     */
    public boolean sendVerificationEmail(String recipientEmail, String token) {
        try {
            return sendHtmlEmail(
                    REVLEARNERS_EMAIL, REVLEARNERS_PASSWORD, recipientEmail,
                    VERIFICATION_EMAIL_SUBJECT_TEMPLATE, String.format(VERIFICATION_EMAIL_TEMPLATE, URLEncoder.encode(token, "UTF-8")));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

	public static void main(String[] args) {
		EmailService service = new EmailService();
		service.sendVerificationEmail("ibe.princewill@yahoo.com", "token");
	}

	/**
	 * @param senderEmail
	 * @param senderPassword
	 * @param recipientEmail
	 * @param subject
	 * @param htmlString
	 * @return
	 */
	private static boolean sendHtmlEmail(String senderEmail, String senderPassword, String recipientEmail,
			String subject, String htmlString) throws FileNotFoundException {
		Session mailSession = Session.getDefaultInstance(SMTP_PROPERTIES, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		Transport transport = null;
		try {
			transport = mailSession.getTransport("smtp");
			MimeMessage message = new MimeMessage(mailSession);

			message.setFrom(senderEmail); // needs to match session's authentication username
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			message.setSubject(subject);
			// Create text part
			BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlString, "text/html; charset=utf-8");

			// this is the message composite
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(htmlPart);

			message.setContent(multipart, "text/html; charset=utf-8");

			// Send message
			mailSession.setDebug(true);
			mailSession.setDebugOut(System.out);
			transport.connect();
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Sent message successfully....");
			return true;
		} catch (SendFailedException e) {
			for (Address a : e.getInvalidAddresses()) {
				System.out.println(a);
			}
			// e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			if (transport != null)
				try {
					transport.close();
				} catch (Exception ignored) {
				}
		}
		return false;
	}

}
