package baolt.example;

import java.io.*;
import java.util.logging.Logger;

public class PathTraversalExample {
    private static final Logger logger = Logger.getLogger(PathTraversalExample.class.getName());

    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt"; // Simulated user input

        File baseDir = new File("safe_directory").getCanonicalFile(); // Base directory
        File file = new File(baseDir, userInput).getCanonicalFile();

        // Prevent path traversal
        if (!file.getPath().startsWith(baseDir.getPath())) {
            logger.warning("Path traversal attempt detected: " + file.getPath());
            return;
        }

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            logger.info("Reading file: " + file.getPath());
            reader.close();
        }
    }
}
