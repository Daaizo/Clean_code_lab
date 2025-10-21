package org.example;

import org.example.lab1.factory.CarFactory;
import org.example.lab1.factory.MotorcycleFactory;
import org.example.lab1.factory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        demonstrateFactoryMethod();
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("--- Factory Method Pattern ---");
        VehicleFactory carFactory = new CarFactory();
        carFactory.processOrder();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.processOrder();

        System.out.println();
    }
}