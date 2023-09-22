package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Todoapp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the todo app. Please enter your name: ");
        String username = scanner.nextLine();

        List<TodoItem> todos = new ArrayList<>();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a new todo");
            System.out.println("2. View your todos");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the todo: ");
                    String todoTitle = scanner.nextLine();
                    System.out.print("Is the todo done (true or false): ");
                    boolean todoStatus = scanner.nextBoolean();
                    TodoItem todoItem = new TodoItem(todoTitle, todoStatus);
                    todos.add(todoItem);
                    System.out.printf("Successfully added %s to the todos list\n", todoItem.getTitle());
                    break;
                case 2:
                    System.out.println("Your todos:");
                    for (int i = 0; i < todos.size(); i++) {
                        TodoItem item = todos.get(i);
                        System.out.printf("%d. %s (Status: %s)%n", i + 1, item.getTitle(), item.isDone() ? "Done" : "Not Done");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    static class TodoItem {
        private String title;
        private boolean done;

        public TodoItem(String title, boolean done) {
            this.title = title;
            this.done = done;
        }

        public String getTitle() {
            return title;
        }

        public boolean isDone() {
            return done;
        }
    }
}
