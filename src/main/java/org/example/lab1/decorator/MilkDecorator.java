package org.example.lab1.decorator;

public class MilkDecorator extends CoffeeDecorator {
    private static final double MILK_COST = 1.5;

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + MILK_COST;
    }
}