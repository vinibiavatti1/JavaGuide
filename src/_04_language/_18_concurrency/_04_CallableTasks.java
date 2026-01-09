/*
Callable Tasks
- This section explains the "Callable" interface in Java, which represents a task that can be executed by a thread and
  return a result, potentially throwing checked exceptions.

Overview
- "Callable" is part of java.util.concurrent and is similar to Runnable, but with three key differences:
  1. Returns a result of type V.
  2. Can throw checked exceptions.
  3. Usually executed via ExecutorService rather than raw threads.
- Introduced in Java 5 as part of the concurrency utilities to allow tasks to produce results asynchronously.

Key Characteristics
- Defines a single method: V call() throws Exception.
- Execution returns a Future<V> object, which represents the pending result.
- Supports exception handling: exceptions thrown inside call() can be retrieved via Future.get().
- Works naturally with thread pools (ExecutorService) to manage concurrent execution efficiently.

Usage
- Use Callable when you need:
  - A task to return a result.
  - Exception handling in concurrent tasks.
  - Coordination of multiple asynchronous tasks.
- Submit Callable tasks to an ExecutorService using submit().
- Retrieve results using Future.get(), which blocks until the computation is complete.
- Always shut down the ExecutorService after submitting tasks to avoid resource leaks.

Example
- The code below demonstrates two Callable tasks executed concurrently via a fixed thread pool.
- Each task sleeps for 1 second to simulate work and then returns a string indicating the executing thread.
- The results are obtained via Future.get(), which blocks until the task completes.
- Useful for performing asynchronous computations while collecting results safely from multiple threads.

Output (example):
- Result from Thread-0
- Result from Thread-1
- Note: Order may vary depending on thread scheduling.
*/
void main() throws InterruptedException, ExecutionException {
    Callable<String> task = () -> {
        Thread.sleep(1000); // Simulate work
        return "Result from " + Thread.currentThread().getName();
    };

    try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
        Future<String> future1 = executor.submit(task);
        Future<String> future2 = executor.submit(task);

        // Retrieve results from futures (blocks until available)
        IO.println(future1.get());
        IO.println(future2.get());
    }
}
