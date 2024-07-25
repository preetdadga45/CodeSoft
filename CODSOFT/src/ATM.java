import java.util.Scanner;

public class ATM {
    private Scanner sc;
    private BankAccount bk;
    ATM(BankAccount bk){
        this.bk = bk;
        this.sc = new Scanner(System.in);
    }
    public void start(){
        boolean running = true;
        display();
        int choice = getUserChoice();
        while(running){
            switch (choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thankyou for using ATM.");
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
    private void checkBalance(){
        System.out.println("Your current balance is "+bk.getBalance());
    }

    private void deposit(){
        System.out.println("Enter the amount you want to deposit: ");
        double amount = sc.nextDouble();
        bk.deposit(amount);
    }

    private void withdraw(){
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = sc.nextDouble();
        bk.withdraw(amount);
    }

    private void display(){
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice(){
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static void main(String[] args) {
        BankAccount bk = new BankAccount(1000.0);
        ATM a = new ATM(bk);
        a.start();
    }
}
