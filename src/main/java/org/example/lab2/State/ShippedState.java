package org.example.lab2.State;

public class ShippedState implements OrderState {

    @Override
    public void process(Order order) {
        System.out.println("Order already shipped");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel shipped order");
    }

    @Override
    public String getStateName() {
        return "Shipped";
    }
}
