package baolt.example;

import java.util.logging.Logger;

public class HardcodedCredentialsExample {
    private static final Logger logger = Logger.getLogger(HardcodedCredentialsExample.class.getName());

    public static void main(String[] args) {
        // Credentials should come from environment variables or config (simulated here)
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (username == null || password == null) {
            logger.severe("Credentials not found in environment variables.");
            return;
        }

        if (authenticate(username, password)) {
            logger.info("Access granted");
        } else {
            logger.warning("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        // In real apps, replace this with hashed credential checks from a secure store
        String expectedUser = System.getenv("APP_USERNAME");
        String expectedPass = System.getenv("APP_PASSWORD");
        return user.equals(expectedUser) && pass.equals(expectedPass);
    }
}
