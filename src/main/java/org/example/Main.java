package org.example;

import org.example.lab1.builder.Email;
import org.example.lab1.decorator.Coffee;
import org.example.lab1.decorator.MilkDecorator;
import org.example.lab1.decorator.SimpleCoffee;
import org.example.lab1.decorator.SugarDecorator;
import org.example.lab1.factory.CarFactory;
import org.example.lab1.factory.MotorcycleFactory;
import org.example.lab1.factory.VehicleFactory;
import org.example.lab1.singleton.DatabaseConnection;
import org.example.lab2.command.Command;
import org.example.lab2.command.Light;
import org.example.lab2.command.LightOnCommand;
import org.example.lab2.command.RemoteControl;

public class Main {
    public static void main(String[] args) {
        // lab1
        demonstrateFactoryMethod();
        demonstrateSingleton();
        demonstrateDecorator();
        demonstrateBuilder();

        // lab2
        demonstrateCommand();
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

    private static void demonstrateDecorator() {
        System.out.println("--- Decorator Pattern ---");

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " PLN");

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " PLN");

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " PLN");

        System.out.println();
    }

    private static void demonstrateBuilder() {
        System.out.println("--- Builder Pattern ---");

        Email email = new Email.EmailBuilder("jan@example.com", "adam@example.com")
                .subject("Ważna wiadomość")
                .body("Treść emaila")
                .priority(1)
                .build();
        System.out.println(email);

        System.out.println();
    }

    private static void demonstrateCommand() {
        System.out.println("--- Command Pattern ---");

        Light light = new Light("Living Room");
        Command lightOn = new LightOnCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);

        remote.pressButton();
        remote.pressUndo();
        remote.pressButton();

        System.out.println();
    }

}