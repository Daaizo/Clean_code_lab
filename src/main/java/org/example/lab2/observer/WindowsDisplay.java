package org.example.lab2.observer;

public class WindowsDisplay implements Observer {
    private float temperature;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Windows Display: Temperature = " + temperature
                + "°C, Pressure = " + pressure + " hPa");
    }
}