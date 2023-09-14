import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double numberOne = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double numberTwo = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("What operation do you want to perform:");
        String operation = scanner.nextLine();

        switch (operation) {
            case "sum":
                System.out.printf("%f + %f = %f", numberOne, numberTwo, numberOne + numberTwo);
                break;
            case "sub":
                System.out.printf("%f - %f = %f", numberOne, numberTwo, numberOne - numberTwo);
                break;
            case "mul":
                System.out.printf("%f * %f = %f", numberOne, numberTwo, numberOne * numberTwo);
                break;
            case "div":
                if (numberTwo == 0) {
                    System.out.println("cannot divide by zero");
                    break;
                }
                System.out.printf("%f / %f = %f", numberOne, numberTwo, numberOne / numberTwo);
                break;
            default:
                System.out.printf("%s is not a supported operation.", operation);

        }

        scanner.close();
    }
}