/*
Futures
- This section explains the "Future" interface in Java, which represents the result of an asynchronous computation
  that may not yet be complete, allowing you to retrieve the result once it becomes available.

Overview
- The "Future" interface is part of the java.util.concurrent package.
- Futures are primarily used for tasks that produce a return value.
- The Callable interface represents a task similar to Runnable but capable of returning a result and throwing
  exceptions.
- The main abstraction of Future is the FutureTask, which wraps a Callable and implements both Runnable and Future.
- Introduced in Java 5 as part of the concurrency utilities to manage asynchronous tasks.

Key Characteristics
- Allows checking if a task is complete (isDone) or canceled (isCancelled).
- Provides methods to cancel tasks (cancel) and retrieve results (get) with optional timeouts.
- Supports asynchronous execution of Callable or Runnable tasks.
- Often used with ExecutorService or higher-level constructs like CompletableFuture for non-blocking workflows.
- Calling get() blocks until the computation is complete, which can lead to potential deadlocks if not used carefully.

Usage
- Submit a Callable or Runnable wrapped in a FutureTask to an ExecutorService to obtain a Future representing the
  pending result.
- Use get() to retrieve the result once the computation is complete, optionally with a timeout.
- Check isDone() or isCancelled() to handle task status before retrieving results.
- Ideal for managing background tasks, parallel computations, and handling asynchronous results safely.

Example
- Demonstrates using FutureTask manually and submitting a Callable to an ExecutorService.
- Output: Hello World (after 1000ms and 2000ms delay)
*/
void main() throws InterruptedException, ExecutionException {
    // Declare a Callable task
    Callable<String> task = () -> {
        Thread.sleep(1000);
        return "Hello World";
    };

    // Execute manually using FutureTask
    FutureTask future = new FutureTask(task);
    future.run();
    IO.println(future.get()); // Blocks until available

    // Execute using an ExecutorService
    try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
        Future<String> result = executor.submit(task);
        IO.println(result.get()); // Blocks until available
    }
}