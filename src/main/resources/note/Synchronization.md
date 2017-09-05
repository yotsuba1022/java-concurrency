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
