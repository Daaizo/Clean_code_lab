package org.example.lab3.inerface.segregation;

public class ModernPrinter implements MultiFunctionDevice {

    @Override
    public void print(String document) {
        System.out.println("Modern Printer: Printing " + document);
    }

    @Override
    public void scan(String document) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fax(String document) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void photocopy(String document) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cloudUpload(String document) {
        System.out.println("Modern Printer: Uploading " + document + " to cloud");
    }

    @Override
    public void email(String document) {
        System.out.println("Modern Printer: Emailing " + document);
    }
}