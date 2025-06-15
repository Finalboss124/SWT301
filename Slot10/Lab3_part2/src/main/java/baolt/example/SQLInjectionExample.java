package baolt.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLInjectionExample {
    private static final Logger LOGGER = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR '1'='1"; // Simulated malicious input

        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        String query = "SELECT username FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userInput);

            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Executing safe, parameterized query.");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String username = rs.getString("username");

                    if (LOGGER.isLoggable(Level.INFO)) {
                        LOGGER.info(String.format("User found: %s", username));
                    }
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database operation failed", e);
        }
    }
}
