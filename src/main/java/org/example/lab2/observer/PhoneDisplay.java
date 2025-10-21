package org.example.lab2.observer;

public class PhoneDisplay implements Observer {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Phone Display: Temperature = " + temperature
                + "°C, Humidity = " + humidity + "%");
    }
}