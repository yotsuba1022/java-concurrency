# Live lock:

Anytime threads have to wait for other threads to complete something they don't block while they wait,
there's a potential for live lock. The next potential problem that can arise in a multi-thread application
is called a slipped condition. This is a specific type of race condition (a.k.a thread interference).
It can occur when a thread can be suspended between reading a condition and acting on it.

Let's say we have two threads reading from a buffer. Each thread does the following:

    1. Checks the status

    2. If it's OK, reads data from the buffer

    3. If the data is EOF, it sets the status to EOF and terminates. If the data isn't EOF, it sets the status to OK

If we haven't synchronized the code properly, the following can happen:

    1. Thread1 check the status and gets OK, it suspends.

    2. Thread2 check the status and gets OK, it reads EOF from the buffer and sets the status to EOF, then terminates.

    3. Thread1 runs again. It tries to read data from the buffer, but there's no data. It throws an exception or crashes.

Because the threads can interfere with each other when checking and setting the condition,
Thread1 tried to do something based on obsolete information. When it checked the status, it was OK.
But by the time it acted on the condition it checked, the status had been updated by Thread2.
Unfortunately, Thread1 doesn't see the updated information, and because of that, it does something erroneous.

