//Write a program in Java program using constructor to create a simple
//banking application. The program should allow users to create multiple
//bank accounts, each with a unique account number, name of the account
//holder, and initial balance. Users should be able to perform operations
//such as deposit, withdrawal, and balance inquiry on their accounts.
//Provide a menu-driven interface for users to interact with the banking application.
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[10];
        int accountCount = 0;

        while (true) {
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (accountCount < accounts.length) {
                        System.out.print("Enter Account Number: ");
                        String accountNumber = scanner.next();
                        System.out.print("Enter Account Holder Name: ");
                        String accountHolder = scanner.next();
                        System.out.print("Enter Initial Balance: ");
                        double initialBalance = scanner.nextDouble();
                        accounts[accountCount++] = new BankAccount(accountNumber, accountHolder, initialBalance);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Maximum account limit reached.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAccount = scanner.next();
                    boolean found = false;
                    for (BankAccount account : accounts) {
                        if (account != null && account.getAccountNumber().equals(depositAccount)) {
                            System.out.print("Enter Deposit Amount: ");
                            double amount = scanner.nextDouble();
                            account.deposit(amount);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawAccount = scanner.next();
                    found = false;
                    for (BankAccount account : accounts) {
                        if (account != null && account.getAccountNumber().equals(withdrawAccount)) {
                            System.out.print("Enter Withdrawal Amount: ");
                            double amount = scanner.nextDouble();
                            account.withdraw(amount);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String inquiryAccount = scanner.next();
                    found = false;
                    for (BankAccount account : accounts) {
                        if (account != null && account.getAccountNumber().equals(inquiryAccount)) {
                            account.displayBalance();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


