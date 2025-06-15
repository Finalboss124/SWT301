package baolt.example;

import java.util.logging.Logger;

public class UnreachableCodeExample {

    private static final Logger LOGGER = Logger.getLogger(UnreachableCodeExample.class.getName());

    public static int getNumber() {
        return 42;

    }

    public static void main(String[] args) {
        LOGGER.info(String.valueOf(getNumber()));
    }
}
