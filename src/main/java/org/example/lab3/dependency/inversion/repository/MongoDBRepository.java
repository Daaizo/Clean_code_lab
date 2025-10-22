package org.example.lab3.dependency.inversion.repository;

public class MongoDBRepository extends AbstractDatabaseRepository {

    public MongoDBRepository() {
        super("mongodb://localhost:27017/mydb");
    }

    @Override
    public void save(String data) {
        connect();
        logOperation("INSERT");
        System.out.println("Saving to MongoDB: " + data);
        disconnect();
    }

    @Override
    public String load(String id) {
        connect();
        logOperation("FIND");
        System.out.println("Loading from MongoDB: " + id);
        disconnect();
        return "Data from MongoDB";
    }

    @Override
    public void delete(String id) {
        connect();
        logOperation("DELETE");
        System.out.println("Deleting from MongoDB: " + id);
        disconnect();
    }

    @Override
    protected void connect() {
        System.out.println("Connecting to MongoDB at " + connectionString);
        isConnected = true;
    }

    @Override
    protected void disconnect() {
        System.out.println("Disconnecting from MongoDB");
        isConnected = false;
    }
}