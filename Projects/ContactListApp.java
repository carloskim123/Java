package Projects;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


final class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}


public class ContactListApp {

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    private static final String CONTACTS_FILE = "contacts.txt";


    public static void main(String[] args) {
        loadContacts();
        runContactList();
    }


    private static void addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter contact email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email);

        contacts.add(newContact);
        saveContacts();

        System.out.println("Contact added successfully");
    }

    private static void viewContacts() {
        System.out.println("Contact List: ");

        if (!(contacts.isEmpty())) {

            for (Contact contact : contacts) {

                System.out.printf("----Name: %s\n", contact.name);
                System.out.printf("----phoneNumber: %s\n", contact.phoneNumber);
                System.out.printf("----Email: %s\n", contact.email);
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("---There are no contacts---");
        }

    }

    private static void displayMenu() {
        System.out.println("Contact List Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Exit");
        System.out.println("4. Delete contact.");
        System.out.println("5. Edit contact.");
        System.out.println("6. Search contacts.");
        System.out.print("Enter your choice: ");
    }

    private static void runContactList() {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    System.out.println("Exiting Contact List. ");
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    editContact();
                    break;
                case 6:
                    searchContacts();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTACTS_FILE))) {

            for (Contact contact : contacts) {
                writer.write(contact.name + "," + contact.phoneNumber + "," + contact.email);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving contacts: ");
        }
    }

    private static void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACTS_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    String email = parts[2];
                    Contact contact = new Contact(name, phoneNumber, email);
                    contacts.add(contact);
                }
            }


        } catch (IOException e) {
            System.out.println("Error loading contacts: ");

        }
    }

    private static void deleteContact() {

        if (!contacts.isEmpty()) {

            // display all contacts for user reference
            viewContacts();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the contact to delete: ");
            String nameToDelete = scanner.nextLine();

            boolean contactDeleted = false;

            Iterator<Contact> iterator = contacts.iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (contact.name.equalsIgnoreCase(nameToDelete)) {
                    iterator.remove();
                    contactDeleted = true;
                    break;
                }
            }

            if (contactDeleted) {
                System.out.printf("Contact: %s deleted!\n", nameToDelete);
                saveContacts();
            } else {
                System.out.println("Contact Not found.");
            }

        } else {
            System.out.println("You must have at least one contact to access this option.");
        }

    }

    private static void editContact() {

        // check if contacts exist
        if (!contacts.isEmpty()) {


            // display all contacts for user reference
            viewContacts();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the contact to edit: ");
            String nameToEdit = scanner.nextLine();


            for (Contact contact : contacts) {
                if (contact.name.equalsIgnoreCase(nameToEdit)) {
                    System.out.printf("Editing Contact :%s \n", nameToEdit);

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new phoneNumber: ");
                    String newPhoneNumber = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();


                    contact.name = newName;
                    contact.phoneNumber = newPhoneNumber;
                    contact.email = newEmail;

                    saveContacts();

                    System.out.println("Contact edited successfully.");

                    break;
                }
            }
        } else {
            System.out.println("You must have at least one contact to access this option.");
        }

    }

    private static void searchContacts() {
        if (!contacts.isEmpty()) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter search query: ");
            String query = scanner.nextLine();

            boolean isFound = false;

            for (Contact contact : contacts)
                if (contact.name.toLowerCase().contains(query)
                        || contact.phoneNumber.toLowerCase().contains(query)
                        || contact.email.toLowerCase().contains(query)) {
                    System.out.printf("Results for: [%s]\n", query);
                    System.out.printf("----Name: %s\n", contact.name);
                    System.out.printf("----Phone Number: %s\n", contact.phoneNumber);
                    System.out.printf("----Email: %s\n", contact.email);
                    System.out.println("--------------------------");
                    isFound = true;
                }

            if (!isFound) System.out.println("No matching contacts found.");

        } else {
            System.out.println("--You don't have any contacts---");
        }

    }

}