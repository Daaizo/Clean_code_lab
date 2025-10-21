package org.example.lab2.adapter;

public class Skateboard {
    private final String model;

    public Skateboard(String model) {
        this.model = model;
    }

    public void pushKick() {
        System.out.println(model + " gains speed with a kick-push.");
    }

    public void footBrake() {
        System.out.println(model + " slows down using a foot drag.");
    }

    public void ollie() {
        System.out.println(model + " does an ollie!");
    }
}