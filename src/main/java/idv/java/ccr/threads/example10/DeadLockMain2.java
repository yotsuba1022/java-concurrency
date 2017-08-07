package idv.java.ccr.threads.example10;

/**
 * @author Carl Lu
 */
public class DeadLockMain2 {

    /*
    *
    * 1. Thread1 acquires the lock on the jane object and enters the sayHello() method. It prints to the console, then suspends.
    * 2. Thread2 acquires the lock on the john object and enters the sayHello() method. It prints to the console, then suspends.
    * 3. Thread1 runs again and wants to say hello back to the john object. It tries to call the sayHelloBack() method
    *    using the john object that was passed into the sayHello() method, but Thread2 is holding the john lock, so Thread1 suspends.
    * 4. Thread2 runs again and wants to say hello back to the jane object. It tries to call the sayHelloBack() method
    *    using the jane object that was passed into the sayHello() method, but Thread1 is holding the jane lock, so Thread2 suspends.
    *
    */

    public static void main(String[] args) {

        final Person carl = new Person("Carl");
        final Person ruru = new Person("Ruru");

        new Thread(() -> carl.greeting(ruru)).start();
        new Thread(() -> ruru.greeting(carl)).start();

    }

    static class Person {
        private final String name;

        Person(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        synchronized void greeting(Person person) {
            System.out.format("%s: %s has greeting to me. %n", this.name, person.getName());
            person.greetingBack(this);
        }

        synchronized void greetingBack(Person person) {
            System.out.format("%s: %s has greeting back to me. %n", this.name, person.getName());
        }
    }

}
