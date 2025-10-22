package org.example.lab3.dependency.inversion.payment;

public class CreditCardPaymentService extends AbstractPaymentService {

    public CreditCardPaymentService() {
        super("Credit Card Payment");
    }

    @Override
    public boolean processPayment(double amount) {
        validatePayment(amount);
        executeTransaction(amount);
        System.out.println("Credit card payment of " + amount + " PLN processed");
        return true;
    }

    @Override
    protected void validatePayment(double amount) {
        System.out.println("Validating credit card...");
    }

    @Override
    protected void executeTransaction(double amount) {
        System.out.println("Charging credit card...");
    }
}