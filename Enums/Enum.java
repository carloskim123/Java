package Enums;

import java.util.logging.Level;

public class Enum {
    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }
    public static void main(String[] args) {
        Level myVar = Level.MEDIUM;
        System.out.println(myVar);
    }
}
