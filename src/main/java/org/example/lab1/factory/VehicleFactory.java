package org.example.lab1.factory;

public abstract class VehicleFactory {

    public abstract Vehicle createVehicle();

    public void processOrder() {
        Vehicle vehicle = createVehicle();
        vehicle.manufacture();
        vehicle.deliver();
    }
}