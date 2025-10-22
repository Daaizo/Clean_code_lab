package org.example.lab3.dependency.inversion.repository;

public interface DataRepository {
    void save(String data);
    String load(String id);
    void delete(String id);
}