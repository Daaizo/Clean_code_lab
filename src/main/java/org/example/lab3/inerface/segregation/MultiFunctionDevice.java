package org.example.lab3.inerface.segregation;

public interface MultiFunctionDevice {
    void print(String document);

    void scan(String document);

    void fax(String document);

    void photocopy(String document);

    void email(String document);

    void cloudUpload(String document);
}