package Projects;

import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text to be counted: ");
        String text = scanner.nextLine();

        String[] words = text.split(" ");

        int wordsCounted = words.length;

        System.out.println("Words counted: " + wordsCounted);
    }
}
