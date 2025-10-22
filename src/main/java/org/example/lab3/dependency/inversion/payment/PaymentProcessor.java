package org.example.lab3.dependency.inversion.payment;

public interface PaymentProcessor {
    boolean processPayment(double amount);
    String getProcessorName();
}