package org.example;

import org.example.lab1.decorator.Coffee;
import org.example.lab1.decorator.MilkDecorator;
import org.example.lab1.decorator.SimpleCoffee;
import org.example.lab1.decorator.SugarDecorator;
import org.example.lab1.factory.CarFactory;
import org.example.lab1.factory.MotorcycleFactory;
import org.example.lab1.factory.VehicleFactory;
import org.example.lab1.singleton.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        demonstrateFactoryMethod();
        demonstrateSingleton();
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("--- Factory Method Pattern ---");

        VehicleFactory carFactory = new CarFactory();
        carFactory.processOrder();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.processOrder();

        System.out.println();
    }

    private static void demonstrateSingleton() {
        System.out.println("--- Singleton Pattern ---");

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("db1 = " + db1);
        System.out.println("db2 = " + db2);

        System.out.println();
    }
}