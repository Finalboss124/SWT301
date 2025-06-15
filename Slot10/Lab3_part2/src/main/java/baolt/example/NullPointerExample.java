package baolt.example;

import java.util.logging.Logger;

public class NullPointerExample {
    private static final Logger LOGGER = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = null;

        if (text != null && !text.isEmpty()) {
            LOGGER.info("Text is not empty");
        }
    }
}
