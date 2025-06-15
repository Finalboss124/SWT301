package baolt.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OvercatchingExceptionExample {
    private static final Logger LOGGER = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];

            int value = arr[10];
            LOGGER.info("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.log(Level.SEVERE, "Index out of bounds: ", e);
        }
    }
}
