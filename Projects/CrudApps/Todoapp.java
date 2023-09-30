package Projects.CrudApps;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Todo {
    String content;
    String isCompleted;

    String title;

    public Todo(String content, String isCompleted, String title) {
        this.content = content;
        this.isCompleted = isCompleted;
        this.title = title;
    }

}

public class Todoapp {

    private static final String TODOS_FILE = "todos.txt";
    private static final ArrayList<Todo> todos = new ArrayList<>();

    public static void main(String[] args) {
        loadTodos();
        runTodoApp();
    }

    private static void loadTodos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TODOS_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // [clean up, false] -> parts[0] = content -> parts[1] = isCompleted;
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String content = parts[2];
                    String isCompleted = parts[1];
                    String title = parts[0];
                    Todo newTodo = new Todo(title, content, isCompleted);
                    todos.add(newTodo);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading todos !");
        }
    }

    private static void addTodo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter title content: ");
        String title = scanner.nextLine();


        System.out.print("Enter todo content: ");
        String content = scanner.nextLine();

        System.out.print("Enter todo isCompleted status [true / false]: ");
        String isCompleted = scanner.nextLine();

        Todo newTodo = new Todo(content, isCompleted, title);
        todos.add(newTodo);

        saveTodos();

    }

    private static void saveTodos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TODOS_FILE))) {

            for (Todo todo : todos) {
                writer.write(todo.title + "," + todo.content + "," + todo.isCompleted);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving todos !");
        }
    }

    private static void displayOptions() {
        System.out.println("Todos List Menu:");
        System.out.println("1. Add Todo");
        System.out.println("2. View Todos");
        System.out.println("3. Exit");
        System.out.println("4. Edit todo");
        System.out.print("Enter your choice: ");
    }

    private static void runTodoApp() {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            displayOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTodo();
                    break;
                case 2:
                    viewTodos();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                case 4:
                    editTodo();
                    break;
                default:
                    System.out.println("Executing defaults.... You entered a non-existing command");

            }

        } while (choice != 3);
    }

    private static void viewTodos() {
        System.out.println("Todos List: ");

        if (!todos.isEmpty()) {
            for (Todo todo : todos) {
                System.out.printf("----Title: %s\n", todo.title);
                System.out.printf("----Content: %s\n", todo.content);
                System.out.printf("----isComplete: %s\n", todo.isCompleted);
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("An error occurred while processing the todos.");

        }
    }

    private static void editTodo() {

        if (!todos.isEmpty()) {

            viewTodos();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the title of the todo to edit: ");
            String statusToEdit = scanner.nextLine();

            for (Todo todo : todos) {
                if (todo.title.equalsIgnoreCase(statusToEdit)) {
                    System.out.printf("The status for the todo [%s] is %s\n Enter the new status ?", todo.title, todo.isCompleted);

                    todo.isCompleted = scanner.nextLine();

                    saveTodos();

                    System.out.println("Todo updated successfully.");

                    break;
                }
            }
        } else {
            System.out.println("You must have at least one todo to access this option.");

        }

    }
}

