package sendEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	

    public static void main(String[] args) {
    	

        // Recipient's email ID needs to be mentioned.
        String to = args[2];

        // Sender's email ID needs to be mentioned
        String from = "userrepositorysystem2020@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("userrepositorysystem2020@gmail.com", "OnePlace");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Welcome to URS");

            // Now set the actual message
            
//            message.setText("This is  first name:"+args[0]+"\n and lastname: "+args[1]);
            String link = "http://localhost:8085/UniqueIdExample/UserEdit?firstname= "+ args[0]+"&lastname="+args[1]+"&uniqueid="+args[3];
            System.out.print(link);
            String html = "<h1>This is actual message embedded in HTML tags</h1> user id is:" + args[3] + "<a href= '"+link+"'>Edit User</a></h5>";
            message.setContent(html, "text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}