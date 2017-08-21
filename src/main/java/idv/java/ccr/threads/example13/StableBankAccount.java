package idv.java.ccr.threads.example13;

/**
 * @author Carl Lu
 */
public class StableBankAccount {

    private double balance;
    private String accountNumber;

    public StableBankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    /*
    * The smaller block size of synchronized, the better the performance.
    * */
    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
