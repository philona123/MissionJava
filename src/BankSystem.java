import java.util.Scanner;

interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

abstract class BankAccount implements Transaction {
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void accountType();

    public void checkBalance() {
        System.out.println("Balance is "+balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void accountType() {
        System.out.println("Account Type: Savings");
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount "+amount+ " Deposited");
    }

    @Override
    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Amount " + amount + " Withdrawn");
        }
    }
}

class CurrentAccount extends BankAccount {
    private final double overDraftLimit = 10000;
    public CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void accountType() {
        System.out.println("Account Type: Current");
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println("Amount "+amount+ " Deposited");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + overDraftLimit) {
            System.out.println("Withdrawal exceeds overdraft limit.");
        } else {
            balance -= amount;
            System.out.println("Amount" + amount + " withdrawn.");
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount bankAccount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.println("Enter inital deposit amount: ");
        double deposit = Double.parseDouble(scanner.nextLine());

        System.out.println("Choose Account type 1. Savings 2.Current");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            bankAccount = new SavingsAccount(name, deposit);
        } else {
            bankAccount = new CurrentAccount(name, deposit);
        }
        bankAccount.accountType();
        boolean running = true;
        while(running) {
            System.out.println("Choose action \n1. Deposit \n2. Withdraw \n3. Check Balance \n4. Exit");
            int action = Integer.parseInt(scanner.nextLine());

            switch(action) {
                case 1:
                    System.out.println("Enter amount to Deposit");
                    int depositAmount = Integer.parseInt(scanner.nextLine());
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to Withdraw");
                    int withdrawAmount = Integer.parseInt(scanner.nextLine());
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    bankAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for banking with us");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}
