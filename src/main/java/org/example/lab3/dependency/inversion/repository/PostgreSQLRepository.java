package org.example.lab3.dependency.inversion.repository;

public class PostgreSQLRepository extends AbstractDatabaseRepository {

    public PostgreSQLRepository() {
        super("jdbc:postgresql://localhost:5432/mydb");
    }

    @Override
    public void save(String data) {
        connect();
        logOperation("INSERT");
        System.out.println("Saving to PostgreSQL: " + data);
        disconnect();
    }

    @Override
    public String load(String id) {
        connect();
        logOperation("SELECT");
        System.out.println("Loading from PostgreSQL: " + id);
        disconnect();
        return "Data from PostgreSQL";
    }

    @Override
    public void delete(String id) {
        connect();
        logOperation("DELETE");
        System.out.println("Deleting from PostgreSQL: " + id);
        disconnect();
    }

    @Override
    protected void connect() {
        System.out.println("Connecting to PostgreSQL at " + connectionString);
        isConnected = true;
    }

    @Override
    protected void disconnect() {
        System.out.println("Disconnecting from PostgreSQL");
        isConnected = false;
    }
}
