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
