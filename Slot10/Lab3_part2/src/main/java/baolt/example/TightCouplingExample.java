package baolt.example;

import java.util.logging.Logger;

interface Printer {
    void print(String message);
}

class ConsolePrinter implements Printer {
    private static final Logger LOGGER = Logger.getLogger(ConsolePrinter.class.getName());

    @Override
    public void print(String message) {
        LOGGER.info(message);
    }
}

class Report {
    private final Printer printer;

    // Constructor Injection – giải quyết tight coupling
    public Report(Printer printer) {
        this.printer = printer;
    }

    void generate() {
        printer.print("Generating report...");
    }
}

