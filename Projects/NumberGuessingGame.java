package Projects;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(3); // Generate a random number between 1 and 100
        int userGuess;
        int guessCount = 0;
        int exceedLimit = 3;

        System.out.println("Welcome to the Number Guessing Game! \n You have 3 chances to try and guess the number");
        System.out.printf("Your current guess count is: %s\n", guessCount);

        while (guessCount < exceedLimit) {
            guessCount += 1;

            System.out.print("Enter your guess: ");

            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    System.out.printf("Your current guess count is: %s\n", guessCount);

                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                    System.out.printf("Your current guess count is: %s\n", guessCount);

                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                    System.out.printf("Your current guess count is: %s\n", guessCount);

                } else if(guessCount >= exceedLimit) {
                    System.out.printf("Guess limit exceeded.\nThe secret number was %s. You last guess was %s", secretNumber,
                            guessCount);
                    break;
                }
                else {
                    System.out.printf("Congratulations! You guessed it with a guess count of %s", guessCount);
                    break; // Exit the loop when the guess is correct
                }
            } else {


                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }

        }





        scanner.close();
    }
}
