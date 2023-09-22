package Projects;

import java.util.Scanner;

public class UnitConverter {
    public static final double METER_TO_FOOT = 3.28084;
    public static final double FOOT_TO_METER = 0.3048;
    public static final double KILOGRAM_TO_POUND = 2.20462;
    public static final double POUND_TO_KILOGRAM = 0.453592;
    public static final double CELSIUS_TO_FAHRENHEIT = 1.8 * 32;
    public static final double FAHRENHEIT_TO_CELSIUS = 5.0 / 9.0 * 32;

    public static double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "m":
                switch (toUnit) {
                    case "ft":
                        return value * METER_TO_FOOT;
                    default:
                        return value;
                }
            case "ft":
                switch (toUnit) {
                    case "m":
                        return value * FOOT_TO_METER;
                    default:
                        return value;
                }
            case "lb":
                switch (toUnit) {
                    case "kg":
                        return value * KILOGRAM_TO_POUND;
                    default:
                        return value;
                }
            case "kg":
                switch (toUnit) {
                    case "lb":
                        return value * POUND_TO_KILOGRAM;
                    default:
                        return value;
                }
            case "C":
                switch (toUnit) {
                    case "F":
                        return value * FAHRENHEIT_TO_CELSIUS;
                    default:
                        return value;
                }
            case "F":
                switch (toUnit) {
                    case "C":
                        return value * CELSIUS_TO_FAHRENHEIT;
                    default:
                        return value;
                }
            default:
                return value;

        }
    }

    public static double validateValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be greater than zero and non negative!");
        }
        return value;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the value from the user.
        System.out.print("Enter the value to convert: ");
        double rawValue = scanner.nextDouble();

        // Read the from unit from the user.
        System.out.print("Enter the unit to convert from: ");
        String rawFromUnit = scanner.next();

        // Read the to unit from the user.
        System.out.print("Enter the unit to convert to: ");
        String rawToUnit = scanner.next();

        // Validate the data.
        double validatedValue = validateValue(rawValue);


        // Convert the value.
        double convertedValue = convert(validatedValue, rawFromUnit, rawToUnit);

        // Print the result.
        System.out.println("\nResults: " + convertedValue + rawToUnit);
    }

}
