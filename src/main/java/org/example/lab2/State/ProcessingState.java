package org.example.lab2.State;

public class ProcessingState implements OrderState {

    @Override
    public void process(Order order) {
        System.out.println("Order is being processed, moving to shipped");
        order.setState(new ShippedState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel order in processing state");
    }

    @Override
    public String getStateName() {
        return "Processing";
    }
}