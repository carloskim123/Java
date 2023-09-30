package Projects.CrudApps;


import org.jetbrains.annotations.NotNull;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

final class InventoryStore {
    String title;
    String description;
    int quantity;

    public InventoryStore(String title, String description, int quantity) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

}

public class InventorySystem {

    private static final ArrayList<InventoryStore> inventoryStore = new ArrayList<>();
    private static final String INVENTORY_FILE = "inventory.txt";

    private static final String defaultDesc = "A new inventory inside the inventory store";

    public static void main(String[] args) throws InterruptedException {
        loadInventoryStore();
        runInventoryStore();
    }

    private static void displayOptions() {

        System.out.println("InventoryStore Options:");
        System.out.println("1. Add Inventory");
        System.out.println("2. Edit Inventory");
        System.out.println("3. View Inventories");
        System.out.println("4. Reload Inventories");
        System.out.println("5. Delete Inventory");
        System.out.println("6. Search Inventories");
        System.out.println("7: Exit");
        System.out.print("Enter your choice: ");
    }

    private static void runInventoryStore() throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToInventoryStore();
                    break;
                case 2:
                    editInventoryStore();
                    break;
                case 3:
                    viewInventoryStore();
                    break;
                case 4:
                    loadInventoryStore();
                    break;
                case 5:
                    deleteInventory();
                    break;
                case 6:
                    searchInventoryStore();
                    break;
                case 7:
                    System.out.println("Waiting for " + INVENTORY_FILE);
                    System.out.println("Saving inventory items......");
                    System.out.println("Executing exiting command......");
                    break;
                default:
                    System.out.print("Unknown Command: " + choice);
            }

        } while (choice != 7);
    }

    private static void editInventoryStore() {
        if (inventoryStore.isEmpty()) {
            System.out.println("The inventory store is currently empty.");
        } else {
            Scanner editorAi = new Scanner(System.in);

            System.out.print("Enter inventory title for editing: ");
            String titleToEdit = editorAi.nextLine();
            boolean found = false;  // Add a flag to track if the item was found

            for (InventoryStore inventory : inventoryStore) {

                System.out.println("Checking disk for modifications...");
                System.out.println("Searching for " + titleToEdit + "...");
                System.out.println("Inventory Found ✅");

                if (inventory.title.toLowerCase().contains(titleToEdit)) {


                    System.out.printf("Inventory item details: \nTitle: %s\nDescription: %s\nQuantity: %d\n",
                            inventory.title, inventory.description, inventory.quantity);

                    System.out.println("What do you want to modify? [title - t, desc - d, quantity - q]");
                    String modifyOption = editorAi.nextLine();

                    switch (modifyOption) {
                        case "t":
                            System.out.println("The current title is : " + inventory.title);
                            System.out.print("Enter updated value ->: ");
                            inventory.title = editorAi.nextLine();
                            saveInventory();
                            System.out.println("InventoryStore item title updated successfully. ✅");
                            break;
                        case "d":
                            System.out.print("Enter updated description ->: ");
                            inventory.description = editorAi.nextLine();
                            saveInventory();
                            System.out.println("InventoryStore item description updated successfully. ✅");
                            break;
                        case "q":
                            System.out.println("The current quantity is : " + inventory.quantity);
                            System.out.print("Enter updated value ->: ");
                            inventory.quantity = editorAi.nextInt();
                            saveInventory();
                            System.out.println("InventoryStore item quantity updated successfully. ✅");
                            break;
                        default:
                            System.out.println("Unknown Command. Known commands: t -> title, d -> description, q -> quantity");
                    }
                    found = true;  // Mark that the item was found
                    break;  // Exit the loop after editing
                }
            }

            if (!found) {
                System.out.println("Inventory item with title '" + titleToEdit + "' not found.");
            }
        }
    }

    private static void addToInventoryStore() {
        Scanner inventoryAi = new Scanner(System.in);
        System.out.println("Initializing inventoryAi...");
        System.out.println("Done ✅");

        System.out.print("Enter inventory item title ->: ");
        String inventoryItemTitle = inventoryAi.nextLine();

        System.out.print("Enter inventory item title or leave blank for default description ->: ");
        String inventoryItemDescription;

        if (inventoryAi.nextLine().isEmpty()) {
            inventoryItemDescription = defaultDesc;
        } else {
            inventoryItemDescription = inventoryAi.nextLine();
        }

        System.out.print("Enter inventory item quantity ->:  ");
        int inventoryItemQuantity = inventoryAi.nextInt();

        InventoryStore newInventoryItem = new InventoryStore(inventoryItemTitle, inventoryItemDescription, inventoryItemQuantity);
        inventoryStore.add(newInventoryItem);

        saveInventory();

        System.out.printf("Inventory with title: %s Created Successfully ✅\n", inventoryItemTitle);

    }

    private static void saveInventory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INVENTORY_FILE))) {

            for (InventoryStore inventory : inventoryStore) {
                writer.write(inventory.title + "," + inventory.description + "," + inventory.quantity);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while saving inventory items");

        }
    }

    private static void loadInventoryStore() {
        // Clear the existing inventory items before loading
        inventoryStore.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {


                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String inventoryTitle = parts[0];
                    String inventoryDescription = parts[1];
                    int inventoryQuantity = Integer.parseInt(parts[2]);

                    InventoryStore newInventory = new InventoryStore(inventoryTitle, inventoryDescription, inventoryQuantity);
                    inventoryStore.add(newInventory);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading InventoryStore !");
        }
    }

    private static void viewInventoryStore() {
        if (!inventoryStore.isEmpty()) {
            System.out.println("Fetching from " + INVENTORY_FILE + "....");
            System.out.println("Loading the inventory items....");
            System.out.println("Done....");


            for (InventoryStore inventory : inventoryStore) {
                System.out.printf("Title: %s\n", inventory.title);
                System.out.printf("Desc: %s\n", inventory.description);
                System.out.printf("Quantity: %d\n", inventory.quantity);
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("An error occurred while loading the inventory viewer.");
        }
    }

    private static void deleteInventory() {
        if (!inventoryStore.isEmpty()) {
            Scanner deleteAi = new Scanner(System.in);


            System.out.println("Fetching delete operations....");
            System.out.println("Done ✅");

            System.out.print("Enter the title of the inventory: ");
            String titleToDelete = deleteAi.nextLine();

            boolean isDeleted = false;

            Iterator<InventoryStore> iterator = inventoryStore.iterator();

            while (iterator.hasNext()) {
                InventoryStore inventory = iterator.next();

                if (inventory.title.equalsIgnoreCase(titleToDelete)) {
                    iterator.remove();
                    saveInventory();
                    isDeleted = true;
                    break;
                }
            }

            if (isDeleted) {
                System.out.println("Inventory with title: [" + titleToDelete + "]  has been deleted successfully");
            } else {
                System.out.println("No modifications occurred.");
            }


        } else {
            System.out.println("Inventory Store is empty");
        }
    }

    private static void searchInventoryStore() {
        if (!inventoryStore.isEmpty()) {

            Scanner searchAi = new Scanner(System.in);

            System.out.println("Fetching search modules...");

            System.out.println("Done ✅");

            System.out.print("Enter the query: ");
            String query = searchAi.nextLine().toLowerCase();

            boolean isFound = false;

            for (InventoryStore inventory : inventoryStore) {
                String title = inventory.title.toLowerCase();

                if (inventory.title.contains(query)) {
                    String underlinedTitle = underlineAllOccurrences(title, query);

                    System.out.printf("Results for: [%s]\n", query);
                    System.out.printf("----Title: %s\n", underlinedTitle);
                    System.out.printf("----Description: %s\n", inventory.description);
                    System.out.printf("----Quantity: %d\n", inventory.quantity);
                    System.out.println("--------------------------");
                    isFound = true;

                }
            }



            if (!isFound) System.out.println("No results for : " + query);

        } else {
            System.out.println("Inventory Store is empty");
        }

    }

    // Function to underline all occurrences of the query in a string
    private static @NotNull String underlineAllOccurrences(@NotNull String input, String query) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < input.length()) {
            int start = input.indexOf(query, index);
            if (start == -1) {
                result.append(input.substring(index));
                break;
            } else {
                result.append(input, index, start); // Append text before query
                result.append("\033[4m"); // Start underlining
                result.append(input, start, start + query.length()); // Underline query
                result.append("\033[0m"); // Stop underlining
                index = start + query.length();
            }
        }

        return result.toString();
    }
}