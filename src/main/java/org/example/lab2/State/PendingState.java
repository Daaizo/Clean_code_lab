package org.example.lab2.State;

public class PendingState implements OrderState {

    @Override
    public void process(Order order) {
        System.out.println("Processing order from Pending state");
        order.setState(new ProcessingState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelling order from Pending state");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Pending";
    }
}