package org.example.lab3.inerface.segregation;

public class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Robot works.");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void attendMeeting() {
        System.out.println("Robot at meeting.");
    }

    @Override
    public void takeBreak() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void receivePayment() {
        throw new UnsupportedOperationException();
    }
}