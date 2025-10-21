package org.example.lab2.adapter;

public class SkateboardAdapter implements Bike {
    private final Skateboard skateboard;

    public SkateboardAdapter(Skateboard skateboard) {
        this.skateboard = skateboard;
    }

    @Override
    public void accelerate() {
        skateboard.pushKick();
    }

    @Override
    public void brake() {
        skateboard.footBrake();
    }

    @Override
    public void ringBell() {
        System.out.println("No bell on a skateboard — signaling with hand instead.");
    }

    public void doOllie() {
        skateboard.ollie();
    }
}