package baolt.example;

import java.util.logging.Logger;

class Animal {
    void speak() {
        LOGGER.info("Animal speaks");
    }

    protected static final Logger LOGGER = Logger.getLogger(Animal.class.getName());
}

class Dog extends Animal {

    @Override
    void speak() {
        LOGGER.info("Dog barks");
    }
}
