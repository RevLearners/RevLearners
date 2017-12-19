import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EmailServiceTest {
    private static final long timeout = 1000;
    private static final Properties smtpProperties = new Properties();
    private static final String revlearnersEmail, revlearnersPassword, smtpHost;
    private static final String smtpPort = "465";

    static {
        revlearnersEmail = System.getenv("REVLEARNERS_EMAIL");
        revlearnersPassword = System.getenv("REVLEARNERS_EMAIL_PASSWORD");
        smtpHost = System.getenv("SMTP_HOST");
        smtpProperties.put("mail.smtp.host", smtpHost);
        smtpProperties.put("mail.smtp.socketFactory.port", smtpPort);
        smtpProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        smtpProperties.put("mail.smtp.auth", true);
        smtpProperties.put("mail.smtp.port", smtpPort);
        smtpProperties.put("mail.smtp.connectiontimeout", timeout);
        smtpProperties.put("mail.smtp.timeout", timeout);
    }

    /**
     * @param senderEmail
     * @param senderPassword
     * @param recipientEmail
     * @param subject
     * @param text
     * @return
     */
    public static boolean sendTextMailWithAttachment(String senderEmail, String senderPassword, String recipientEmail, String subject, String text, String filePath) throws FileNotFoundException {
        File attachment = new File(filePath);
        if (!(attachment.exists()))
            throw new FileNotFoundException(filePath);

        Session mailSession = Session.getDefaultInstance(smtpProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        Transport transport = null;
        try {
            transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);

            message.setFrom(senderEmail);   // needs to match session's authentication username
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            // Create text part
            BodyPart textPart = new MimeBodyPart();
            textPart.setText(text);
            // Create file part
            BodyPart filePart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment);
            filePart.setDataHandler(new DataHandler(source));
            filePart.setFileName(attachment.getName());
            // combine text and file into multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(filePart);

            // Send the complete message parts
            message.setContent(multipart);
            // Send message
            mailSession.setDebug(true);
            mailSession.setDebugOut(System.out);
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Sent message successfully....");
            return true;
        }
        catch(SendFailedException e) {
            for (Address a: e.getInvalidAddresses()) {
                System.out.println(a);
            }
            //e.printStackTrace();
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
        finally {
             if (transport != null)
                 try { transport.close();} catch (Exception ignored) {}
        }
        return false;
    }

    public static boolean sendTextMail(String senderEmail, String fromPassword, String recipientEmail, String subject, String text) {
        Session mailSession = Session.getDefaultInstance(smtpProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, fromPassword);
            }
        });
        Transport transport = null;

        try {
            transport = mailSession.getTransport("smtp");
            MimeMessage mailMessage = new MimeMessage(mailSession);
            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            mailMessage.setFrom(senderEmail);   // needs to match session's authentication username
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            mailSession.setDebug(true);
            mailSession.setDebugOut(System.out);
            transport.connect();
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            System.out.println("Success!");
        }
        catch(SendFailedException e) {
            for (Address a: e.getInvalidAddresses()) {
                System.out.println(a);
            }
            e.printStackTrace();
        }
        catch (MessagingException e){
                e.printStackTrace();
                return false;
        }
        finally {
             if (transport != null)
                 try { transport.close();} catch (Exception ignored) {}
        }
        return true;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String recipientEmail = "email@email.com";  // replace with actual destination email, and uncomment the files below
        // sendTextMail(revlearnersEmail, revlearnersPassword, recipientEmail, "this is a test", "this is STILL a test");
        // sendTextMailWithAttachment(senderEmail, senderPassword, recipientEmail, "this is a test", "this is a test with an attachment; Enjoy the erd attached", "img/example.png");
    }
}
