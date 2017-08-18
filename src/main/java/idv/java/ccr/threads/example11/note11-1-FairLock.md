# Fair Lock:

Fair locks try to be first come first served, the Reentrant lock implementation allow us
to create fair locks, not all lock implementation can do that, the interface doesn't dictate
that locks have to be fair. So always make sure to read the document for any lock
implementation you want to use to see what type of lock it is.

For using a fair reentrant lock, only fairness in acquiring the lock is guaranteed, not
fairness in scheduling. So it's possible that the thread that gets the lock will execute
a task takes a long time. Therefore, when using fair locks, it's possible for threads to
still have to wait a long time to run. The only thing a fair lock guarantee is the first come
first serve ordering for getting the lock. Secondly, the tryLock() method doesn't honor the
fairness settings so it will not be first come first serve and lastly when using fair locks
with a lot of threads, keep in mind that performance will be impacted to ensure fairness,
there has to be an extra layer of processing that manages which thread gets the lock so that can
ultimately slow things down when there's a lot of threads completing for that lock.
