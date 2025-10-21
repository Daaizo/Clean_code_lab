package org.example.lab1.factory;

public class Car implements Vehicle {
    private static final int PRODUCTION_TIME_DAYS = 30;

    @Override
    public void manufacture() {
        System.out.println("Manufacturing a car - production time: "
                + PRODUCTION_TIME_DAYS + " days");
    }

    @Override
    public void deliver() {
        System.out.println("Delivering car to dealership");
    }

    @Override
    public String getType() {
        return "Car";
    }
}