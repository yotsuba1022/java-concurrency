package idv.java.ccr.threads.example14;

/**
 * @author Carl Lu
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        final BankAccountWithLock bankAccount = new BankAccountWithLock(1000.00, "9487-9487");

        Thread thread1 = new Thread(() -> {
            bankAccount.deposit(300.00);
            bankAccount.withdraw(50.00);
            System.out.println("Transaction completed for account: " + bankAccount.getAccountNumber());
        });

        Thread thread2 = new Thread(() -> {
            bankAccount.deposit(203.75);
            bankAccount.withdraw(100.00);
            System.out.println("Transaction completed for account: " + bankAccount.getAccountNumber());
        });

        thread1.start();
        thread2.start();
        /*
        * You might not get the final result here since the threads might still running.
        * */
        System.out.println("Balance just after invoke operations: " + bankAccount.getBalance());

        Thread.sleep(2000);

        System.out.println("Balance after all operations: " + bankAccount.getBalance());
    }

}
