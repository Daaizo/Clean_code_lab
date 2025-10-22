package org.example.lab3.inerface.segregation;

public class Dog implements Animal {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    @Override
    public void eat() {
        System.out.println(name + " the dog is eating");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " the dog is sleeping");
    }
    
    @Override
    public void walk() {
        System.out.println(name + " the dog is walking");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}