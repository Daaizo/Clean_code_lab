package org.example.lab3.inerface.segregation.device;

public class SimplePrinter implements Printer {

    @Override
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }
}