import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor: Creates an account with a name and initial balance
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = "BA" + (int) (Math.random() * 10000); // Random account number
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid input. Please enter a positive amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: $" + balance);
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Invalid input. Please withdraw a positive amount.");
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Show account details
    public void displayAccount() {
        System.out.println("\nAccount created successfully!");
    }
}

public class SimpleBankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;
        boolean exit = false;

        System.out.println("Welcome to Simple Bank System");

        while (!exit) {
            if (account == null) {
                // Menu before account creation
                System.out.println("\n1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (choice == 1) {
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();

                    double initialDeposit;
                    do {
                        System.out.print("Enter initial deposit: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input! Please enter a valid number.");
                            scanner.next(); // Clear invalid input
                        }
                        initialDeposit = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        if (initialDeposit < 0) {
                            System.out.println("Initial deposit cannot be negative.");
                        }
                    } while (initialDeposit < 0);

                    account = new BankAccount(name, initialDeposit);
                    account.displayAccount();
                } else if (choice == 5) {
                    System.out.println("Thank you for using Simple Bank System!");
                    exit = true;
                } else {
                    System.out.println("Invalid choice. Please create an account first.");
                }
            } else {
                // Menu after account creation
                System.out.println("\n1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        double depositAmount;
                        do {
                            System.out.print("Enter amount to deposit: ");
                            while (!scanner.hasNextDouble()) {
                                System.out.println("Invalid input! Please enter a valid number.");
                                scanner.next(); // Clear invalid input
                            }
                            depositAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            if (depositAmount <= 0) {
                                System.out.println("Deposit amount must be positive.");
                            }
                        } while (depositAmount <= 0);
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        double withdrawAmount;
                        do {
                            System.out.print("Enter amount to withdraw: ");
                            while (!scanner.hasNextDouble()) {
                                System.out.println("Invalid input! Please enter a valid number.");
                                scanner.next(); // Clear invalid input
                            }
                            withdrawAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            if (withdrawAmount <= 0) {
                                System.out.println("Withdrawal amount must be positive.");
                            }
                        } while (withdrawAmount <= 0);
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        System.out.println("Current balance: $" + account.getBalance());
                        break;

                    case 4:
                        System.out.println("Thank you for using Simple Bank System!");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        }
        scanner.close();
    }
}
