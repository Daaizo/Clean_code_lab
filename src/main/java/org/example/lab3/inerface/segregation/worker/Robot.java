package org.example.lab3.inerface.segregation.worker;

public class Robot implements Workable, Meetable {
    public void work() {
        System.out.println("Robot works 24/7.");
    }

    public void attendMeeting() {
        System.out.println("Robot at virtual meeting.");
    }
}