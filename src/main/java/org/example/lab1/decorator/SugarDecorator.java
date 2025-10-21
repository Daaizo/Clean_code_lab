package org.example.lab1.decorator;

public class SugarDecorator extends CoffeeDecorator {
    private static final double SUGAR_COST = 0.5;

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + SUGAR_COST;
    }
}
