package org.example.lab3.dependency.inversion.notification;

public abstract class AbstractNotificationChannel implements NotificationSender {
    protected String channelName;
    protected boolean delivered;

    public AbstractNotificationChannel(String channelName) {
        this.channelName = channelName;
        this.delivered = false;
    }

    @Override
    public boolean isDelivered() {
        return delivered;
    }

    protected abstract void prepareMessage(String message);
    protected abstract void transmit(String recipient, String message);
}
