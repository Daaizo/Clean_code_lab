package org.example.lab3.dependency.inversion.notification;

public interface NotificationSender {
    void sendNotification(String recipient, String message);
    boolean isDelivered();
}
