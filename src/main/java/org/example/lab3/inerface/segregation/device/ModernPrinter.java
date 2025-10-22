package org.example.lab3.inerface.segregation.device;

public class ModernPrinter implements Printer, CloudUploader, EmailSender {

    @Override
    public void print(String document) {
        System.out.println("Modern Printer: Printing " + document);
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