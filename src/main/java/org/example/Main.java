package org.example;

import org.example.lab1.builder.Email;
import org.example.lab1.decorator.Coffee;
import org.example.lab1.decorator.MilkDecorator;
import org.example.lab1.decorator.SimpleCoffee;
import org.example.lab1.decorator.SugarDecorator;
import org.example.lab1.factory.*;
import org.example.lab1.singleton.DatabaseConnection;
import org.example.lab2.State.Order;
import org.example.lab2.State.PendingState;
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
import org.example.lab3.dependency.inversion.OrderService;
import org.example.lab3.dependency.inversion.notification.EmailNotificationChannel;
import org.example.lab3.dependency.inversion.notification.NotificationSender;
import org.example.lab3.dependency.inversion.notification.SMSNotificationChannel;
import org.example.lab3.dependency.inversion.payment.CreditCardPaymentService;
import org.example.lab3.dependency.inversion.payment.PayPalPaymentService;
import org.example.lab3.dependency.inversion.payment.PaymentProcessor;
import org.example.lab3.dependency.inversion.repository.DataRepository;
import org.example.lab3.dependency.inversion.repository.MongoDBRepository;
import org.example.lab3.dependency.inversion.repository.PostgreSQLRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Lab1 ---");
        demonstrateFactoryMethod();
        demonstrateSingleton();
        demonstrateDecorator();
        demonstrateBuilder();
        demonstrateAdapter();

        System.out.println("--- Lab2 ---");
        demonstrateCommand();
        demonstrateObserver();
        demonstrateStrategy();
        demonstrateState();


        System.out.println("--- Lab3 ---");
        demonstrateLiskov();
        demonstrateDependencyInversionPrinciple();
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
    private static void demonstrateState() {
        System.out.println("--- State Pattern ---");

        Order order = new Order("orderId");
        order.setState(new PendingState());

        order.getCurrentState();
        order.process();

        order.getCurrentState();
        order.process();

        order.getCurrentState();
        order.process();

        order.cancel();
        order.getCurrentState();

        System.out.println();
    }

    private static void demonstrateLiskov() {
        System.out.println("--- Liskov Substitution Principle ---");

        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        if (car instanceof Vehicle && motorcycle instanceof Vehicle) {
            System.out.println("Liskov Substitution Principle is working.");
        }

        processVehicle(car);
        processVehicle(motorcycle);

        System.out.println();
    }

    private static void processVehicle(Vehicle vehicle) {
        vehicle.deliver();
        vehicle.manufacture();
    }

    private static void demonstrateDependencyInversionPrinciple() {
        System.out.println("=== DEPENDENCY INVERSION PRINCIPLE DEMO ===\n");

        // Implementacja 1
        PaymentProcessor payment1 = new CreditCardPaymentService();
        NotificationSender notification1 = new EmailNotificationChannel();
        DataRepository repository1 = new PostgreSQLRepository();

        OrderService orderService1 = new OrderService(payment1, notification1, repository1);
        orderService1.processOrder("ORD-001", 299.99, "customer@example.com");

        System.out.println("=== ZMIANA IMPLEMENTACJI ===\n");

        // Implementacja 2 (inny processor, notyfikacja i repozytorium)
        PaymentProcessor payment2 = new PayPalPaymentService();
        NotificationSender notification2 = new SMSNotificationChannel();
        DataRepository repository2 = new MongoDBRepository();

        OrderService orderService2 = new OrderService(payment2, notification2, repository2);
        orderService2.processOrder("ORD-002", 199.49, "client@example.com");
    }
}