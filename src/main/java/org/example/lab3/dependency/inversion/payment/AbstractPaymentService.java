package org.example.lab3.dependency.inversion.payment;

public abstract class AbstractPaymentService implements PaymentProcessor {
    protected String serviceName;
    protected boolean isActive;

    public AbstractPaymentService(String serviceName) {
        this.serviceName = serviceName;
        this.isActive = true;
    }

    @Override
    public String getProcessorName() {
        return serviceName;
    }

    protected abstract void validatePayment(double amount);
    protected abstract void executeTransaction(double amount);
}