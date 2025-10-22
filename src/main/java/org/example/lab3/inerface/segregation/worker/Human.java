package org.example.lab3.inerface.segregation.worker;

public class Human implements Workable, Eatable, Sleepable, Meetable {
    public void work() {
        System.out.println("Human works.");
    }

    public void eat() {
        System.out.println("Human eats.");
    }

    public void sleep() {
        System.out.println("Human sleeps.");
    }

    public void attendMeeting() {
        System.out.println("Human at meeting.");
    }
}