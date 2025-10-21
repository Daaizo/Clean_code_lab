package org.example.lab1.factory;

public class CarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
