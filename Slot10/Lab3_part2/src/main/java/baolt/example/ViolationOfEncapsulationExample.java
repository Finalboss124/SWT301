package baolt.example;

import java.util.logging.Logger;

class User {
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());

    private String name;
    private int age;

    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        LOGGER.info("Name: " + name + ", Age: " + age);
    }
}

