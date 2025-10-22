package org.example.lab3.dependency.inversion.notification;

public class EmailNotificationChannel extends AbstractNotificationChannel {

    public EmailNotificationChannel() {
        super("Email Channel");
    }

    @Override
    public void sendNotification(String recipient, String message) {
        prepareMessage(message);
        transmit(recipient, message);
        delivered = true;
        System.out.println("Email sent to " + recipient);
    }

    @Override
    protected void prepareMessage(String message) {
        System.out.println("Formatting email with HTML template");
    }

    @Override
    protected void transmit(String recipient, String message) {
        System.out.println("Sending via SMTP to " + recipient);
    }
}