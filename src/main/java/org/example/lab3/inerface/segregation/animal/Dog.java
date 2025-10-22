package org.example.lab3.inerface.segregation.animal;

public class Dog implements Eatable, Sleepable, Walkable, Soundable {
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
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}