package org.example.lab3.dependency.inversion.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostgreSQLRepositoryTest {

    static class TestablePostgreSQLRepository extends PostgreSQLRepository {
        final List<String> ops = new ArrayList<>();

        @Override
        protected void logOperation(String op) {
            ops.add(op);
        }
    }

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void save_shouldConnectLogInsertAndDisconnectTest() {
        // given
        final String data = "Test Data";
        TestablePostgreSQLRepository repo = new TestablePostgreSQLRepository();

        // when
        repo.save(data);

        // then
        String output = out.toString();
        assertTrue(output.contains("Connecting to PostgreSQL at jdbc:postgresql://localhost:5432/mydb"));
        assertTrue(output.contains("Saving to PostgreSQL: " + data));
        assertTrue(output.contains("Disconnecting from PostgreSQL"));
        assertEquals(List.of("INSERT"), repo.ops);
    }

    @Test
    void load_shouldReturnExpectedStringAndLogSelectTest() {
        // given
        final String id = "123";
        TestablePostgreSQLRepository repo = new TestablePostgreSQLRepository();

        // when
        String result = repo.load(id);

        // then
        String output = out.toString();
        assertTrue(output.contains("Loading from PostgreSQL: " + id));
        assertEquals("Data from PostgreSQL", result);
        assertEquals(List.of("SELECT"), repo.ops);
    }

    @Test
    void delete_shouldConnectLogDeleteAndDisconnectTest() {
        // given
        final String id = "42";
        TestablePostgreSQLRepository repo = new TestablePostgreSQLRepository();

        // when
        repo.delete(id);

        // then
        String output = out.toString();
        assertTrue(output.contains("Connecting to PostgreSQL at jdbc:postgresql://localhost:5432/mydb"));
        assertTrue(output.contains("Deleting from PostgreSQL: " + id));
        assertTrue(output.contains("Disconnecting from PostgreSQL"));
        assertEquals(List.of("DELETE"), repo.ops);
    }

    @Test
    void connectAndDisconnect_shouldToggleIsConnectedFlagTest() {
        // given
        TestablePostgreSQLRepository repo = new TestablePostgreSQLRepository();

        // when
        repo.connect();
        boolean afterConnect = repo.isConnected;
        repo.disconnect();
        boolean afterDisconnect = repo.isConnected;

        // then
        assertTrue(afterConnect, "isConnected should be true after connect()");
        assertFalse(afterDisconnect, "isConnected should be false after disconnect()");
    }

    @Test
    void multipleOperations_shouldLogInCorrectOrderTest() {
        // given
        TestablePostgreSQLRepository repo = new TestablePostgreSQLRepository();

        // when
        repo.save("alpha");
        repo.load("beta");
        repo.delete("gamma");

        // then
        assertEquals(List.of("INSERT", "SELECT", "DELETE"), repo.ops);

        String output = out.toString();
        assertTrue(output.contains("Saving to PostgreSQL: alpha"));
        assertTrue(output.contains("Loading from PostgreSQL: beta"));
        assertTrue(output.contains("Deleting from PostgreSQL: gamma"));
    }
}