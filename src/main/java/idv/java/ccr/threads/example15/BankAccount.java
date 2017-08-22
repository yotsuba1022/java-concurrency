package idv.java.ccr.threads.example15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class BankAccount {

    private double balance;
    private String accountNumber;
    private String threadColor;
    private Lock lock = new ReentrantLock();

    public BankAccount(double balance, String accountNumber, String threadColor) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.threadColor = threadColor;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                balance -= amount;
                System.out.printf(threadColor + "%s: withdraw %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }

        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                balance += amount;
                System.out.printf(threadColor + "%s: deposit %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }

        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            } else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf(threadColor + "%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }
}
