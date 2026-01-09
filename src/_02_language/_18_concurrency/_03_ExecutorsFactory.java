/*
Executors Factory
- This section explains the Executors factory class in Java, which provides factory methods to create various types of
  ExecutorService implementations for managing and executing concurrent tasks efficiently.

Overview
- The "Executors" class is part of the java.util.concurrent package.
- It contains static factory methods for creating thread pools, scheduled executors, work-stealing pools, and
  virtual-thread executors (Project Loom).
- Introduced in Java 5 and continuously enhanced, including scheduled tasks and virtual threads in recent versions.

Key Characteristics
- Provides pre-configured ExecutorService implementations for common concurrency scenarios.
- Supports both CPU-bound and I/O-bound workloads with appropriate thread pool configurations.
- Includes single-thread, fixed-thread, cached, scheduled, work-stealing, and virtual/thread-per-task executors.
- Simplifies thread lifecycle management, task submission, and parallel task execution.
- Allows tasks to be submitted as Runnable or Callable, returning Futures for result tracking.
- Recommended over manually creating Thread instances, as it handles thread reuse, scheduling, and lifecycle
  automatically.

I/O Bound
- Tasks whose performance is primarily limited by input/output operations, such as reading from a database, making
  network requests, or accessing files. In these cases, the CPU often remains idle while waiting for I/O to complete.
- These scenarios are best handled with Virtual Threads, which are lightweight and allow massive concurrency without
  consuming many system resources.

CPU Bound
- Tasks whose performance is primarily limited by the processor's speed, such as complex calculations, data processing,
  or algorithmic operations. The CPU is continuously active, and the bottleneck is computation rather than I/O.
- These scenarios are best handled with Fixed Thread Pools, which leverage multiple OS threads to perform computations
  in parallel, but are more resource-intensive than virtual threads.

Usage
- Use Executors to manage threads efficiently without manually creating and controlling Thread instances.
- Ideal for executing tasks concurrently, scheduling delayed or periodic jobs, and balancing parallel workloads.
- Apply the appropriate executor type depending on the workload: I/O-bound, CPU-bound, or special requirements.
- Useful in combination with Futures, asynchronous programming, and Project Loom virtual threads.
*/
void main() {
    //==================================================================================================================
    // I/O Bound Executors
    //==================================================================================================================

    /*
    Virtual Thread Per Task Executor
    - Creates an executor that starts a new virtual thread for each submitted task.
    - Virtual threads are lightweight and designed to efficiently handle a large number of concurrent, blocking
      (I/O-bound) operations.
    - The executor automatically manages the lifecycle of virtual threads.
    - Recommended for high-concurrency applications that perform blocking calls such as I/O, database access, or network
      requests.
    - Output: Hello World (printed by a virtual thread)
    */
    try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
        executor.submit(() -> IO.println("Hello World"));
    }

    /*
    Cached Thread Pool
    - Creates a thread pool that creates new threads as needed and reuses previously created idle threads.
    - Threads that remain idle for a certain period may be terminated and removed from the pool.
    - Suitable for applications with many short-lived or asynchronous tasks, especially I/O-bound operations.
    - Does not impose an upper bound on the number of threads, so it should be used with care.
    - Output: Hello World (printed by a pooled thread)
    */
    try(ExecutorService executor = Executors.newCachedThreadPool()) {
        executor.submit(() -> IO.println("Hello World"));
    }

    //==================================================================================================================
    // CPU Bound Executors
    //==================================================================================================================

    /*
    Fixed Thread Pool
    - Creates a thread pool with a fixed number of threads (3 in this example).
    - Limits the level of concurrency by allowing only a fixed number of tasks to execute in parallel.
    - Additional submitted tasks are queued until a thread becomes available.
    - Suitable for CPU-bound workloads or scenarios where resource usage must be controlled.
    - Output: Hello World (printed by one of the pool threads)
    */
    try(ExecutorService executor = Executors.newFixedThreadPool(3)) {
        executor.submit(() -> IO.println("Hello World"));
    }

    /*
    Single Thread Executor
    - Creates an executor that uses a single worker thread to execute tasks sequentially.
    - Guarantees task execution order, as tasks are processed one at a time.
    - Useful when tasks must not run concurrently or when shared state must be accessed safely without synchronization.
    - Suitable for simple CPU-bound or lightweight tasks that require strict ordering.
    - Output: Hello World (printed by the single executor thread)
    */
    try(ExecutorService executor = Executors.newSingleThreadExecutor()) {
        executor.submit(() -> IO.println("Hello World"));
    }

    //==================================================================================================================
    // Scheduled Executors
    //==================================================================================================================

    /*
    Scheduled Thread Pool
    - Creates a scheduled executor with a pool of 3 threads that can execute tasks after a delay or periodically.
    - Multiple tasks can run concurrently, up to the number of threads in the pool.
    - Suitable for CPU-bound or I/O-bound scheduled tasks where parallel execution is needed.
    - Useful for repeating jobs, maintenance tasks, or delayed processing that should not block other tasks.
    - Output: Hello World (printed after the specified delay)
    */
    try(ScheduledExecutorService executor = Executors.newScheduledThreadPool(3)) {
        executor.schedule(() -> IO.println("Hello World"), 100, TimeUnit.MILLISECONDS);
    }

    /*
    Single Thread Scheduled Executor
    - Creates a scheduled executor that uses a single thread to execute tasks after a delay or periodically.
    - Ensures scheduled tasks are executed sequentially and never run concurrently.
    - Useful for simple scheduling scenarios such as delayed execution, periodic maintenance, or lightweight cron-like
      jobs.
    - Guarantees execution order when multiple tasks are scheduled.
    - Output: Hello World (printed after the specified delay)
    */
    try(ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor()) {
        executor.schedule(() -> IO.println("Hello World"), 100, TimeUnit.MILLISECONDS);
    }

    //==================================================================================================================
    // Special Executors
    //==================================================================================================================

    /*
    Work Stealing Pool
    - Creates a ForkJoinPool-based executor that dynamically balances tasks across multiple worker threads.
    - Each thread maintains its own queue and can "steal" tasks from other queues to maximize CPU utilization.
    - Optimized for CPU-bound, parallelizable tasks where work can be split into smaller subtasks.
    - Suitable for large-scale parallel computations, batch processing, or workloads that benefit from fine-grained task
      decomposition.
    - Output: Hello World (printed by one of the pool threads)
    */
    try(ExecutorService executor = Executors.newWorkStealingPool()) {
        executor.submit(() -> IO.println("Hello World"));
    }

    /*
    Thread Per Task Executor
    - Creates an executor that starts a new platform thread for each submitted task.
    - Each task runs on its own dedicated thread, without reusing threads.
    - Suitable for experiments, benchmarks, or very specific scenarios where task isolation is required.
    - Not recommended for production workloads, as creating many platform threads can consume significant system
      resources.
    - Output: Hello World (printed by a newly created thread)
    */
    try(ExecutorService executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
        executor.submit(() -> IO.println("Hello World"));
    }
}