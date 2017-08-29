# Threads and Runnable

* Each Java application has a default main thread executes the main() method.
* The Java virtual machine (JVM) gives each thread its own JVM stack to prevent
  threads from interfering with each other. Separate stacks let threads keep track of their next
  instructions to execute, which can differ from thread to thread. The stack also provides a
  thread with its own copy of method parameters, local variables, and return value.
* Java supports threads primarily through its java.lang.Thread class and java.lang.Runnable interface.
* The Runnable interface supplies the code to be executed by the thread that’s
  associated with a Thread object. This code is located in Runnable’s void run()
  method.
* Most of the constructors of Thread class require a Runnable object as an argument.
* Thread’s long getId() method returns a unique long integer-based name for a thread. This number remains unchanged during the thread’s lifetime.
* A thread has an execution state that is identified by one of the Thread.State enum’s
  constants:
    * NEW: A thread that has not yet started is in this state.
    * RUNNABLE: A thread executing in the JVM is in this state.
    * BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
    * WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
    * TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
    * TERMINATED: A thread that has exited is in this state.
