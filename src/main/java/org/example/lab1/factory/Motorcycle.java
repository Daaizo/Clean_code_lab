package org.example.lab1.factory;

public class Motorcycle implements Vehicle {
    private static final int PRODUCTION_TIME_DAYS = 15;

    @Override
    public void manufacture() {
        System.out.println("Manufacturing a motorcycle - production time: "
                + PRODUCTION_TIME_DAYS + " days");
    }

    @Override
    public void deliver() {
        System.out.println("Delivering motorcycle to customer");
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}