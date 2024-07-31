package Projects.CrudApps;

import Projects.CrudApps.utils.BigIntegerUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class BankSystem {
    private static final ArrayList<Account> BANK = new ArrayList<>();


    static class Account {
        private BigInteger accountNumber;
        private Double balance;
        private String accountName;

        public Account(BigInteger accountNumber, Double balance, String accountName) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.accountName = accountName;
        }

    }

    public static void main(String[] args) {

        runBankSystem();
    }

    private static void displayMenu() {
        System.out.println("Welcome to CarlMonte Banking Agency");
        System.out.println("1. Create a New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Account Balance");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void runBankSystem() {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkAccountBalance();
                    break;
                case 5:
                    System.out.println("Thanks for visiting CarlMonte Banking Agency");
                    exitBank();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's create a new account");

        System.out.println("Enter Account Name: ");
        String accountName = scanner.nextLine();

        System.out.println("Your account will be created with a starting balance of: $0.00");
        System.out.println("You can begin depositing once you have completed the account creation process!!");

        BigInteger accountNumber;
        boolean isUnique;

        do {
            // Generate a random BigInteger with sufficient bit length (e.g., 64 bits)
            accountNumber = BigIntegerUtils.generateRandomBigInteger(64);

            // Check if the generated account number is unique
            isUnique = true;
            for (Account account : BANK) {
                if (account.accountNumber.equals(accountNumber)) {
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);  // Repeat until a unique account number is found

        Account newAccount = new Account(accountNumber, 0.00, accountName);
        BANK.add(newAccount);

        System.out.println("Your account number is: " + accountNumber);
        System.out.println("Account created!!!");
    }

    public static void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Depositing Portal");
        System.out.print("Enter account number: ");

        BigInteger providedAccountNumber = scanner.nextBigInteger();

        boolean accountLocated = false;

        for (Account account : BANK) {
            if (account.accountNumber.equals(providedAccountNumber)) {
                System.out.println("Account Found!!");
                System.out.println("Confirming account number");
                System.out.println("The account's account number is: " + account.accountNumber);
                System.out.println("Account Name: " + account.accountName);
                System.out.println("Current Balance: $" + account.balance);

                // Prompt user for deposit amount
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();

                // Check if deposit amount is positive
                if (depositAmount > 0) {
                    account.balance += depositAmount;
                    System.out.println("Deposit successful!");
                    System.out.println("New Balance: $" + account.balance);
                } else {
                    System.out.println("Invalid deposit amount. Please enter a positive value.");
                }

                accountLocated = true;
                break;
            }
        }

        if (!accountLocated) {
            System.out.println("Invalid account number");
        }
    }

    public static void withdrawMoney() {
        // TODO: Handle withdraw functionality
    }
    public static void checkAccountBalance() {}
    public static void exitBank() {}



}