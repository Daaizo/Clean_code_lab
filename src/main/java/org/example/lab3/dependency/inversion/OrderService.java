package org.example.lab3.dependency.inversion;

import org.example.lab3.dependency.inversion.notification.NotificationSender;
import org.example.lab3.dependency.inversion.payment.PaymentProcessor;
import org.example.lab3.dependency.inversion.repository.DataRepository;

public class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final NotificationSender notificationSender;
    private final DataRepository dataRepository;

    public OrderService(PaymentProcessor paymentProcessor, NotificationSender notificationSender, DataRepository dataRepository) {
        this.paymentProcessor = paymentProcessor;
        this.notificationSender = notificationSender;
        this.dataRepository = dataRepository;
    }

    public void processOrder(String orderId, double amount, String customerEmail) {
        System.out.println("\n=== Processing Order " + orderId + " ===");

        dataRepository.save("Order: " + orderId);

        boolean paymentSuccess = paymentProcessor.processPayment(amount);

        if (paymentSuccess) {
            notificationSender.sendNotification(customerEmail,
                    "Your order " + orderId + " has been confirmed!");
        }

        System.out.println("=== Order Processing Complete ===\n");
    }
}