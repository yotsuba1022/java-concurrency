package idv.java.ccr.threads.example13;

/**
 * @author Carl Lu
 */
public class StableMain {

    public static void main(String[] args) {
        final StableBankAccount bankAccount = new StableBankAccount(1000.00, "9487-9487");

        Thread thread1 = new Thread(() -> {
            bankAccount.deposit(300.00);
            bankAccount.withdraw(50.00);
        });

        Thread thread2 = new Thread(() -> {
            bankAccount.deposit(203.75);
            bankAccount.withdraw(100.00);
        });

        thread1.start();
        thread2.start();

        System.out.println("Balance after operations: " + bankAccount.getBalance());
    }

}
