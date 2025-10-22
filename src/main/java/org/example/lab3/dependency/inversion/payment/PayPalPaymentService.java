package org.example.lab3.dependency.inversion.payment;

import org.example.lab3.dependency.inversion.payment.AbstractPaymentService;

public class PayPalPaymentService extends AbstractPaymentService {

    public PayPalPaymentService() {
        super("PayPal Payment");
    }

    @Override
    public boolean processPayment(double amount) {
        validatePayment(amount);
        executeTransaction(amount);
        System.out.println("PayPal payment of " + amount + " PLN processed");
        return true;
    }

    @Override
    protected void validatePayment(double amount) {
        System.out.println("Validating PayPal account...");
    }

    @Override
    protected void executeTransaction(double amount) {
        System.out.println("Processing PayPal transaction...");
    }
}