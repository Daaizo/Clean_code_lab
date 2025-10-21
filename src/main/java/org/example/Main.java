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
import org.example.lab1.adapter.Bicycle;
import org.example.lab1.adapter.Bike;
import org.example.lab1.adapter.Skateboard;
import org.example.lab1.adapter.SkateboardAdapter;
import org.example.lab2.observer.PhoneDisplay;
import org.example.lab2.observer.WeatherStation;
import org.example.lab2.observer.WindowsDisplay;
import org.example.lab2.strategy.BubbleSort;
import org.example.lab2.strategy.QuickSort;
import org.example.lab2.strategy.SortContext;

public class Main {
    public static void main(String[] args) {
        // lab1
        demonstrateFactoryMethod();
        demonstrateSingleton();
        demonstrateDecorator();
        demonstrateBuilder();
        demonstrateAdapter();

        // lab2
        demonstrateCommand();
        demonstrateObserver();
        demonstrateStrategy();
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

    private static void demonstrateAdapter() {
        System.out.println("--- Adapter Pattern (Skateboard & Bicycle) ---");

        Bike bike = new Bicycle("City Bike");
        bike.accelerate();
        bike.ringBell();
        bike.brake();

        System.out.println();

        Skateboard board = new Skateboard("Street Deck");
        Bike boardAsBike = new SkateboardAdapter(board);

        boardAsBike.accelerate();
        boardAsBike.ringBell();
        boardAsBike.brake();

        if (boardAsBike instanceof SkateboardAdapter s) {
            s.doOllie();
        }
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

    private static void demonstrateObserver() {
        System.out.println("--- Observer Pattern ---");

        WeatherStation station = new WeatherStation();
        PhoneDisplay phone = new PhoneDisplay();
        WindowsDisplay windowsDisplay = new WindowsDisplay();

        station.registerObserver(phone);
        station.registerObserver(windowsDisplay);

        station.setMeasurements(25.0f, 60.0f, 1013.0f);

        station.removeObserver(phone);
        station.setMeasurements(27.0f, 61.0f, 1015.0f);

        System.out.println();
    }


    private static void demonstrateStrategy() {
        System.out.println("--- Strategy Pattern ---");
        int[] array = {5, 2, 8, 1, 9};
        SortContext context = new SortContext();

        context.setStrategy(new BubbleSort());
        context.executeStrategy(array.clone());

        context.setStrategy(new QuickSort());
        context.executeStrategy(array.clone());

        System.out.println();
    }
}