package org.example.lab3.dependency.inversion.notification;

public class SMSNotificationChannel extends AbstractNotificationChannel {

    public SMSNotificationChannel() {
        super("SMS Channel");
    }

    @Override
    public void sendNotification(String recipient, String message) {
        prepareMessage(message);
        transmit(recipient, message);
        delivered = true;
        System.out.println("SMS sent to " + recipient);
    }

    @Override
    protected void prepareMessage(String message) {
        System.out.println("Formatting SMS text");
    }

    @Override
    protected void transmit(String recipient, String message) {
        System.out.println("Sending via SMS gateway to " + recipient);
    }
}