package org.example.lab2.State;

public class Order {
    private OrderState state;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        this.state = new PendingState();
    }

    public void setState(OrderState state) {
        this.state = state;
        System.out.println("Order " + orderId + " state changed to: "
                + state.getStateName());
    }

    public void process() {
        state.process(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public String getCurrentState() {
        return state.getStateName();
    }
}