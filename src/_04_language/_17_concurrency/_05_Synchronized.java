/*
 * Synchronized
 * - This section explains the "synchronized" keyword in Java, which provides built-in support for mutual exclusion and
 *   thread-safe access to shared resources.
 *
 * Overview
 * - "synchronized" controls concurrent access to code sections, ensuring only one thread at a time executes a
 *   synchronized method or block associated with the same monitor.
 * - Synchronization relies on intrinsic locks (monitors) tied to every Java object.
 * - Present since the earliest Java versions as a core concurrency mechanism.
 *
 * Key Characteristics
 * - Provides mutual exclusion (mutex) to protect shared mutable state.
 * - Guarantees visibility: changes made by one thread inside a synchronized section are visible to others that acquire
 *   the same lock.
 * - Ensures atomicity for the synchronized section.
 * - Automatically releases the lock when execution exits the method or block (even in case of exceptions).
 *
 * What Can Be Synchronized
 * - Instance methods:
 *   - synchronized void method()
 *   - Locks on the current object instance ("this").
 * - Static methods:
 *   - synchronized static void method()
 *   - Locks on the Class object (e.g., MyClass.class).
 * - Code blocks:
 *   - synchronized(object) { ... }
 *   - Locks explicitly on the specified object.
 *
 * Mutex and Monitors
 * - Every Java object has an implicit monitor that acts as a mutex.
 * - Threads acquire the monitor when entering a synchronized method or block and release it upon exit.
 * - Other threads attempting to acquire the same monitor are blocked until the lock is released.
 *
 * Usage
 * - Protect shared mutable state accessed by multiple threads.
 * - Synchronize only the minimum necessary code.
 * - Prefer synchronized blocks over methods for finer-grained locking.
 * - Common scenarios:
 *   - Incrementing shared counters.
 *   - Updating shared collections safely.
 *   - Coordinating access to critical sections.
 *
 * Example
 * - Instance Synchronized Method: locks on the current object instance ("this").
 * - Static Synchronized Method: locks on the Class object.
 * - Synchronized Block: locks on a specific object to reduce contention.
 *
 * Output:
 * - Instance Method accessed by: Thread-0
 * - Instance Method accessed by: Thread-1      // After Thread-0 released
 * - Static Method accessed by: Thread-0
 * - Static Method accessed by: Thread-1        // After Thread-0 released
 * - Synchronized Block accessed by: Thread-0
 * - Synchronized Block accessed by: Thread-1   // After Thread-0 released
 */
public synchronized void criticalMethod() throws InterruptedException {
    IO.println("Instance Method accessed by: " + Thread.currentThread().getName());
    Thread.sleep(1000); // Simulate work in critical section
}

public static synchronized void criticalStaticMethod() throws InterruptedException {
    IO.println("Static Method accessed by: " + Thread.currentThread().getName());
    Thread.sleep(1000); // Simulate work in critical section
}

void main() {
    Object mutex = new Object();

    Runnable task = () -> {
        try {
            // Synchronized Instance Method
            criticalMethod();

            // Synchronized Static Method
            criticalStaticMethod();

            // Synchronized Block
            synchronized (mutex) {
                IO.println("Synchronized Block accessed by: " + Thread.currentThread().getName());
                Thread.sleep(1000); // Simulate work in critical section
            }
        } catch (InterruptedException e) {
            IO.println("Interrupted");
        }
    };

    for (int i = 0; i < 2; i++) {
        new Thread(task).start();
    }
}