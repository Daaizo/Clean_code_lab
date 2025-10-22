package org.example.lab3.inerface.segregation.animal;

public class Fish implements Eatable, Sleepable, Swimmable {
    private String species;

    public Fish(String species) {
        this.species = species;
    }

    @Override
    public void eat() {
        System.out.println(species + " is eating plankton");
    }

    @Override
    public void sleep() {
        System.out.println(species + " is resting underwater");
    }

    @Override
    public void swim() {
        System.out.println(species + " is swimming in water");
    }
}