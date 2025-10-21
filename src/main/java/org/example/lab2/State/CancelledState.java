package org.example.lab2.State;

public class CancelledState implements OrderState {

    @Override
    public void process(Order order) {
        System.out.println("Cannot process cancelled order");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is already cancelled");
    }

    @Override
    public String getStateName() {
        return "Cancelled";
    }

}
