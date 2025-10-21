package org.example.lab1.adapter;

public class Bicycle implements Bike {
    private final String model;

    public Bicycle(String model) {
        this.model = model;
    }

    @Override
    public void accelerate() {
        System.out.println(model + " pedals faster and speeds up!");
    }

    @Override
    public void brake() {
        System.out.println(model + " uses hand brakes to slow down.");
    }

    @Override
    public void ringBell() {
        System.out.println(model + " rings the bell: *tring tring*");
    }
}
