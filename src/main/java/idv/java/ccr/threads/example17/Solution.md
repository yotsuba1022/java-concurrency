# Solution for Tutor Deadlock Example

In the previous example, we've produced a scenario that the tutor thread
and student thread will result in dead lock.

The fix will depend on the code, Perhaps over-synchronization is occurring.
Do we really need to synchronize all the methods, or can we isolate critical
sections of code within the methods and use synchronized blocks instead?
In a real world application, we'd have to study the code.

We might also consider rewriting some of the code. Do the tutor and student objects
really need to call each other in this circular fashion?
Can we make use of parameters in any way?

Another potential solution would be to use ReentrantLock objects and the tryLock()
method with a timeout value. If the tryLock() method times out, the thread wouldn't
be able to execute the critical section of code, but at least the application
wouldn't be deadlocked. Also, a thread could release any locks it's holding when
the tryLock() times out, allowing any threads waiting for those locks to run successfully.

There may be other solutions. When dealing with a deadlock situation, look for the following:

1. Is a set of locks being obtained in a different order by multiple threads (that's the case here).
If so, can we force all threads to obtain the locks in the same order?
2. Are we over-synchronizing the code?
3. Can we rewrite the code to break any circular call patterns?
4. Would using ReentrantLock objects help?

In this example, I use the ReentrantLock as the solution, for each thread, it will try to
obtain the lock then finish the task, if it couldn't obtain the lock, keep acquiring it until the task is done.
