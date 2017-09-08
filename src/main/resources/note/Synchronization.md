# Synchronization

* A race condition occurs when the correctness of a computation depends on the
  relative timing or interleaving of multiple threads by the scheduler.
* There are some types of race conditions:
    * Check-then-act: A potentially stale observation is used to decide on what to do next.
    For example, when matching the condition within if statement, do something.
    * Read-modify-write: New state is derived from previous state. A common example
    of read-modify-write involves a variable that’s incremented to generate a unique numeric identifier.

* Data races
    * A race condition is often confused with a data race in which two or more threads (in a
      single application) access the same memory location concurrently, at least one of the
      accesses is for writing, and these threads don’t coordinate their accesses to that memory.
    * When these conditions hold, access order is non-deterministic. Different results may be
      generated from run to run, depending on that order.

* Cached variables
    * To boost performance, the compiler, the Java virtual machine (JVM), and the operating
      system can collaborate to cache a variable in a register or a processor-local cache, rather
      than rely on main memory. Each thread has its own copy of the variable. When one
      thread writes to this variable, it’s writing to its copy; other threads are unlikely to see the
      update in their copies.

* Synchronizing access to critical sections
    * Synchronization is a JVM feature that ensures that two or more concurrent threads don’t simultaneously
      execute a critical section, which is a code section that must be accessed in a serial (one thread at a time) manner.
    * This property of synchronization is known as mutual exclusion (a.k.a mutex lock) because each thread
      is mutually excluded from executing in a critical section when another thread is inside
      the critical section.
    * Synchronization also exhibits the property of visibility in which it ensures that a
      thread executing in a critical section always sees the most recent changes to shared
      variables. It reads these variables from main memory on entry to the critical section and
      writes their values to main memory on exit.
    * Synchronization is implemented in terms of monitors, which are concurrency
      constructs for controlling access to critical sections, which must execute indivisibly. Each
      Java object is associated with a monitor, which a thread can lock or unlock by acquiring
      and releasing the monitor’s lock (a token).
    * A thread that has acquired a lock doesn't release this lock when it calls one of
      Thread’s sleep() methods.
    * A synchronized method includes the synchronized keyword in its header.
      For example, you can use this keyword to synchronize the method you want.
    * When synchronizing on an instance method, the lock is associated with the object
      on which the method is called.
    * When synchronizing on a class method, the lock is associated with the java.lang.
      Class object corresponding to the class whose class method is called.
    * A synchronized block of statements is prefixed by a header that identifies the object whose
      lock is to be acquired.
    * Two or more threads that access the same code sequence must acquire the same lock or there will be no synchronization.

* Liveness problem
    * The term liveness refers to something beneficial happening eventually. A liveness failure
      occurs when an application reaches a state in which it can make no further progress. In a
      single-threaded application, an infinite loop would be an example. Multithreaded
      applications face the additional liveness challenges of deadlock, livelock, and starvation.
    * Deadlock: Thread 1 waits for a resource that thread 2 is holding exclusively and thread 2
      is waiting for a resource that thread 1 is holding exclusively. Neither thread can make progress.
    * Livelock: Thread x keeps retrying an operation that will always fail. It cannot make progress for this reason.
    * Starvation: Thread x is continually denied (by the scheduler) access to a needed resource
      in order to make progress. Perhaps the scheduler executes higher-priority threads before
      lower-priority threads and there is always a higher-priority thread available for execution.
      Starvation is also commonly referred to as indefinite postponement.
    * Sometimes it's not so easy to detect the deadlock, think about the following circular relationship:
        * Class A's synchronized method calls class B's synchronized method.
        * Class B's synchronized method calls class C's synchronized method.
        * Class C's synchronized method calls class A's synchronized method.

* Volatile and final variables
    * In previous section, we know that synchronization exhibits two properties: mutual exclusion and visibility.
      The synchronized keyword is associated with both properties. Java also provides a weaker form of synchronization
      involving visibility only, and associates only this property with the volatile keyword.
    * Use volatile only where visibility is an issue. Also, you can only use this
      reserved word in the context of field declarations (you’ll receive an error if you try to make a
      local variable volatile). Finally, you can declare double and long fields volatile, but
      should avoid doing so on 32-bit JVMs because it takes two operations to access a double or
      long variable’s value, and mutual exclusion (via synchronized) is required to access their
      values safely.
    * Java provides a special thread-safety guarantee concerning immutable objects. These
      objects can be safely accessed from multiple threads, even when synchronization isn’t
      used to publish (expose) their references provided that the following rules are observed:
      * Immutable objects must not allow state to be modified.
      * All fields must be declared final.
      * Objects must be properly constructed so that "this" references don't escape from constructors.
        * References:
            * [Ref 1](https://www.ibm.com/developerworks/library/j-jtp0618/)
            * [Ref 2](https://stackoverflow.com/questions/1588420/how-does-this-escape-the-constructor-in-java)
