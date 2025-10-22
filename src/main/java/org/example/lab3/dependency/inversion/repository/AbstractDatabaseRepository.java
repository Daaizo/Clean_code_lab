package org.example.lab3.dependency.inversion.repository;

public abstract class AbstractDatabaseRepository implements DataRepository {
    protected String connectionString;
    protected boolean isConnected;

    public AbstractDatabaseRepository(String connectionString) {
        this.connectionString = connectionString;
        this.isConnected = false;
    }

    protected abstract void connect();
    protected abstract void disconnect();

    protected void logOperation(String operation) {
        System.out.println("Database operation: " + operation);
    }
}