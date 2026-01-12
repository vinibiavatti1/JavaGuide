/*
Semaphore
- This section explains the "Semaphore" class in Java, which provides a mechanism to control access to shared resources
  by multiple threads through a limited number of permits.

Overview
- The "Semaphore" class is part of the java.util.concurrent package.
- It allows threads to acquire and release permits explicitly, controlling the number of threads that can access a
  resource simultaneously.
- Introduced in Java 5 as part of the concurrency utilities to support coordination and rate-limiting scenarios.

Key Characteristics
- Maintains a set number of permits that threads must acquire before proceeding.
- Provides blocking acquisition with acquire() and non-blocking attempts with tryAcquire().
- Permits are released using release(), allowing waiting threads to proceed.
- Can be used as a counting semaphore (multiple permits) or a binary semaphore (single permit).
- Supports fairness policies to grant permits in FIFO order if needed.

Usage
- Use Semaphore to limit the number of threads accessing a shared resource simultaneously.
- Ideal for controlling resource pools, limiting concurrent operations, or coordinating threads in producer-consumer
  scenarios.
- Always pair acquire() and release() to avoid deadlocks.
- Useful in concurrent applications where fine-grained access control is required beyond simple synchronized blocks or
  locks.

Example
- The example below demonstrates a basic Semaphore with 2 permits.
- Six threads attempt to enter a critical section, but only 2 can execute it simultaneously.
- Threads that cannot acquire a permit immediately wait until one becomes available.
- Each thread holds the permit for 1 second (simulated with sleep) and then releases it, allowing waiting threads to
  proceed.
- This shows how Semaphore can control concurrency and limit simultaneous access to a shared resource.

Output
- Permit acquired by thread: Thread-0
- Permit acquired by thread: Thread-1
- (other threads wait for permits)
- Permit acquired by thread: Thread-2
- Permit acquired by thread: Thread-3
- (other threads wait for permits)
- Permit acquired by thread: Thread-4
- Permit acquired by thread: Thread-5
*/
void main() throws InterruptedException {
    Semaphore semaphore = new Semaphore(2); // 2 Thread Permits

    Runnable task = () -> {
        try {
            semaphore.acquire(); // Acquires a permit
            IO.println("Permit acquired by thread: " + Thread.currentThread().getName());
            Thread.sleep(1000); // Simulate work in critical section
        } catch (InterruptedException e) {
            IO.println("Interrupted");
        } finally {
            semaphore.release(); // Releases a permit
        }
    };

    for (int i = 0; i < 6; i++) {
        new Thread(task).start();
    }
}
