package idv.java.ccr.threads.example14;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carl Lu
 */
public class BankAccountWithLock {

    private Lock lock;
    private double balance;
    private String accountNumber;

    public BankAccountWithLock(double balance, String accountNumber) {
        this.lock = new ReentrantLock();
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException ignored) {

        }
    }

    public void withdraw(double amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException ignored) {

        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void showAccountNumber() {
        System.out.println("Account number: " + this.accountNumber);
    }
}
