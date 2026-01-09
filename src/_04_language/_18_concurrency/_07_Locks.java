/*
Locks
- This section explains locks in Java, which are objects that provide explicit mechanisms for mutual exclusion and
  thread-safe access to shared resources, offering more flexibility than the built-in "synchronized" keyword.

Overview
- Locks are part of the java.util.concurrent.locks package.
- They allow threads to acquire and release locks explicitly, giving fine-grained control over synchronization.
- Locks support reentrancy, meaning the same thread can acquire the same lock multiple times without deadlocking.
- Introduced in Java 5 as part of the concurrency utilities to enhance thread-safety and control over critical sections.

Key Characteristics
- Explicit acquisition and release using lock() and unlock().
- Reentrant behavior for many implementations, allowing a thread to re-acquire a lock it already holds.
- Types of locks provided in the Java standard library:
  - ReentrantLock: a general-purpose reentrant lock.
  - ReadWriteLock: an interface separating read and write locks; commonly used via ReentrantReadWriteLock.
  - StampedLock: a more advanced lock supporting optimistic reads, read locks, and write locks.
- Some implementations can provide fairness policies to control the order in which threads acquire the lock.

Usage
- Use locks to protect shared mutable state accessed by multiple threads.
- Prefer locks when:
  - You need more control than synchronized allows.
  - You want finer-grained synchronization scopes.
  - You plan to implement more advanced coordination patterns in the future.
- Always acquire locks in a try/finally block to guarantee they are released.
- Useful in concurrent applications, high-performance code, and situations where synchronized blocks may be too rigid.

Example
- The code below demonstrates basic usage of a ReentrantLock to achieve thread-safe execution of a critical section.
- "lock.lock()" acquires the lock, blocking the current thread if necessary until it becomes available.
- The critical section is executed while the lock is held.
- "lock.unlock()" releases the lock in the finally block, ensuring it is always freed even if an exception occurs.
- Useful for protecting shared mutable state and coordinating access among multiple threads.
- Output: Synchronized Code

Output:
- Critical Operation accessed by: Thread-0
- Critical Operation accessed by: Thread-1   // After Thread-0 released
- Critical Operation accessed by: Thread-2   // After Thread-1 released
*/
void main() throws InterruptedException {
    ReentrantLock lock = new ReentrantLock();

    Runnable task = () -> {
        try {
            lock.lock(); // Acquire lock
            IO.println("Critical Operation accessed by: " + Thread.currentThread().getName());
            Thread.sleep(1000); // Simulate work in critical section
        } catch (InterruptedException e) {
            IO.println("Interrupted");
        } finally {
            lock.unlock(); // Release lock
        }
    };

    for (int i = 0; i < 3; i++) {
        new Thread(task).start();
    }
}