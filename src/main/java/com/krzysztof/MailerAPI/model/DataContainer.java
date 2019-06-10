package com.krzysztof.MailerAPI.model;

public class DataContainer {

    private String senderEmail;
    private String emailPassword;
    private String consumerEmail;
    private int smtpPort;  /// 465 for gmail
    private int portForSocket;  ///  587 for gmail
    private String host;  //// smtp.gmail.com for gmail
    private String messageText;

    public DataContainer(String consumerEmail, int smtpPort,
                         int portForSocket, String host, String messageText) {
        this.consumerEmail = consumerEmail;
        this.smtpPort = smtpPort;
        this.portForSocket = portForSocket;
        this.host = host;
        this.messageText = messageText;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getConsumerEmail() {
        return consumerEmail;
    }

    public void setConsumerEmail(String consumerEmail) {
        this.consumerEmail = consumerEmail;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public int getPortForSocket() {
        return portForSocket;
    }

    public void setPortForSocket(int portForSocket) {
        this.portForSocket = portForSocket;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
