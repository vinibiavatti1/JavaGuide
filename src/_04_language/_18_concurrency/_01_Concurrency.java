/*
 * Concurrency
 * - This section explains concurrency in Java, which allows multiple tasks to be executed simultaneously or overlapped,
 *   improving performance, responsiveness, and resource utilization.
 *
 * Overview
 * - Concurrency is essential for applications that handle multiple users, perform I/O operations, or execute
 *   CPU-intensive tasks in parallel.
 * - Java provides a range of tools to manage threads, synchronize access to shared resources, and compose asynchronous
 *   tasks.
 * - Understanding the difference between I/O bound and CPU bound tasks is critical to choosing the right concurrency
 *   mechanisms.
 *
 * Key Characteristics
 * - Concurrency enables overlapping execution of tasks, improving efficiency and responsiveness.
 * - Parallelism is a form of concurrency focused on executing CPU-bound computations simultaneously to reduce
 *   processing time.
 * - Threads are the basic unit of execution in Java, representing independent flows of control.
 * - Tasks (Runnable or Callable) encapsulate work that can be executed concurrently.
 * - Synchronization and coordination mechanisms prevent race conditions and ensure data consistency when multiple
 *   threads access shared resources.
 * - Resource management is important to avoid contention, deadlocks, and excessive context switching.
 *
 * Features
 * - Threads: represents an independent sequence of execution; can be user or daemon threads.
 * - Executors: factory methods for creating and managing thread pools, including fixed, cached, single-threaded, and
 *   virtual thread pools; simplifies task submission without manually creating threads.
 * - CompletableFuture: API for composing and executing asynchronous tasks in a functional style, enabling chaining,
 *   combination, and result handling.
 * - Synchronized: keyword for defining critical sections, ensuring that only one thread accesses a resource at a time.
 * - Lock: explicit locking mechanism (e.g., ReentrantLock) that provides finer control over synchronization, including
 *   tryLock, timed lock, and reentrant behavior.
 * - Semaphore: concurrency control mechanism that limits the number of threads that can access a resource
 *   simultaneously, useful for throttling, connection pools, and shared resources.
 *
 * Usage
 * - Use concurrency to improve application performance, responsiveness, and scalability.
 * - Choose the appropriate mechanism based on task type: I/O bound tasks benefit from virtual threads or asynchronous
 *   approaches, while CPU bound tasks may leverage executors, thread pools, or parallel streams.
 * - Apply synchronization and locks when multiple threads share mutable resources.
 * - Use semaphores for controlling access to limited resources or implementing throttling.
 * - Compose asynchronous workflows with CompletableFuture to simplify complex concurrent logic.
 */
void main() {}