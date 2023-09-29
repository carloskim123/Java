package Projects;

import java.util.Scanner;

public class FizzBuzz {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {

            System.out.print("Enter number: ");
            int number = scanner.nextInt();

            checkFizzBuzz(number);
        }

    }

    private static void checkFizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");

        } else if (number % 3 == 0) {
            System.out.println("Fizz");

        } else System.out.println(number);

    }
}
