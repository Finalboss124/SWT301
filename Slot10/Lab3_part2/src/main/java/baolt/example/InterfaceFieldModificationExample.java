package baolt.example;

import java.util.logging.Level;
import java.util.logging.Logger;

final class Constants {
    public static final int MAX_USERS = 100;

    private Constants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

public class InterfaceFieldModificationExample {
    private static final Logger LOGGER = Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Starting application...");

        try {
            LOGGER.info("Max users allowed: " + Constants.MAX_USERS);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
        }
    }
}


