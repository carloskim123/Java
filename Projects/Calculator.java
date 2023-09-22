package Projects;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double a = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        double b = scanner.nextDouble();

        System.out.println("Enter the operation: ( * / % + -): ");
        char operator = scanner.next().charAt(0);

        double result = 0;

        switch(operator){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '/':
                result = a / b;
                break;
            case '*':
                result = a * b;
                break;
            case '%':
                result = a % b;
                break;
            default:
                System.out.println("Invalid data!");
                return;
        }

        System.out.println("Result: " + result);
    }

}
