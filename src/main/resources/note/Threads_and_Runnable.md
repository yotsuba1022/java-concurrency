# Threads and Runnable

* Each Java application has a default main thread executes the main() method.
* The Java virtual machine (JVM) gives each thread its own JVM stack to prevent
  threads from interfering with each other. Separate stacks let threads keep track of
  their next instructions to execute, which can differ from thread to thread. The stack
  also provides a thread with its own copy of method parameters, local variables, and return value.
* Java supports threads primarily through its java.lang.Thread class and java.lang.Runnable interface.
* The Runnable interface supplies the code to be executed by the thread that’s
  associated with a Thread object. This code is located in Runnable’s void run()
  method.
* Most of the constructors of Thread class require a Runnable object as an argument.
* Thread’s long getId() method returns a unique long integer-based name for a thread.
This number remains unchanged during the thread’s lifetime.
* A thread has an execution state that is identified by one of the Thread.State enum’s
  constants:
    * NEW: A thread that has not yet started is in this state.
    * RUNNABLE: A thread executing in the JVM is in this state.
    * BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
    * WAITING: A thread that is waiting indefinitely for another thread to perform
    a particular action is in this state.
    * TIMED_WAITING: A thread that is waiting for another thread to perform an action
    for up to a specified waiting time is in this state.
    * TERMINATED: A thread that has exited is in this state.
* Two terms that are commonly encountered when exploring threads are parallelism and concurrency.
    * Parallelism: A condition that arises when at least two threads are executing simultaneously.
    * Concurrency: A condition that exists when at least two threads are making progress.
    It is a more generalized form of parallelism that can include time-slicing as a form of virtual parallelism.
* Thread priority: From Thread.MIN_PRIORITY(1) to Thread.MAX_PRIORITY(10).
* Using setPriority() can impact an application’s portability across operating systems because
different schedulers can handle a priority change in different ways. This might cause starvation.
* A daemon thread is a thread that acts as a helper to a non-daemon thread and dies automatically
when the application’s last non-daemon thread dies so that the application can terminate.
* An application will not terminate when the non-daemon default main thread terminates until all
background non-daemon threads terminate. If the background threads are daemon threads, the application
will terminate as soon as the default main thread terminates.
* The Thread class provides an interruption mechanism in which one thread can interrupt
another thread. When a thread is interrupted, it throws java.lang.InterruptedException.
* A thread (such as the default main thread) will occasionally start another thread to
  perform a lengthy calculation, download a large file, or perform some other time-consuming
  activity. After finishing its other tasks, the thread that started the worker
  thread is ready to process the results of the worker thread and waits for the worker thread
  to finish and die.
