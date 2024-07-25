public class BankAccount {
    private double balance;

    BankAccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Money deposited successfully.\nCurrent Balance: "+balance);
        }else{
            System.out.println("Invalid input.");
        }
    }

    public boolean withdraw(double amount){
        if (amount>0 && amount<balance){
            balance-=amount;
            return true;
        } else if (amount>balance) {
            System.out.println("Insufficient balance.");
            return false;
        }else {
            System.out.println("Invalid input.");
            return false;
        }
    }

}
