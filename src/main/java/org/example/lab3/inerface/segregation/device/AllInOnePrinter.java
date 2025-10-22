package org.example.lab3.inerface.segregation.device;

public class AllInOnePrinter implements Printer, FaxMachine, Photocopier, Scanner {

    @Override
    public void print(String document) {
        System.out.println("All-in-One: Printing " + document);
    }

    @Override
    public void fax(String document) {
        System.out.println("All-in-One: Faxing " + document);
    }

    @Override
    public void photocopy(String document) {
        System.out.println("All-in-One: Photocopying " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("All-in-One: Scanning " + document);
    }
}