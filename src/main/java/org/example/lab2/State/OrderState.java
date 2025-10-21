package org.example.lab2.State;

public interface OrderState {
    void process(Order order);
    void cancel(Order order);
    String getStateName();
}