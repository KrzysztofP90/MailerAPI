package com.krzysztof.MailerAPI.service;

import com.krzysztof.MailerAPI.model.DataContainer;
import org.springframework.stereotype.Component;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


@Component("mailerService")
public class MailerService {

    private Properties getProperties(DataContainer dataContainer) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", dataContainer.getHost());
        prop.put("mail.smtp.port", dataContainer.getSmtpPort());
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", dataContainer.getPortForSocket());
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return prop;
    }


    public boolean sendEmail(DataContainer dataContainer) {

        Properties prop = this.getProperties(dataContainer);
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(dataContainer.getSenderEmail(), dataContainer.getEmailPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(dataContainer.getSenderEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dataContainer.getConsumerEmail()));
            message.setSubject("Mail Subject");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(dataContainer.getMessageText(), "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            Transport.send(message);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
