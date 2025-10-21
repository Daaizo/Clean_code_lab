package org.example.lab1.factory;

public class MotorcycleFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}