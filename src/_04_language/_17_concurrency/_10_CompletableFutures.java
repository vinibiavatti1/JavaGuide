/*
CompletableFutures
- This section explains the "CompletableFuture" class in Java, which represents a Future that can be completed
  explicitly and supports non-blocking, asynchronous computation with functional-style callbacks and chaining.

Overview
- CompletableFuture is part of the java.util.concurrent package.
- It extends the Future interface and adds powerful capabilities for asynchronous programming.
- Supports functional-style composition of multiple asynchronous tasks without blocking the main thread.
- Introduced in Java 8 as a more flexible and composable alternative to Future and FutureTask.

Key Characteristics
- Non-blocking retrieval of results using callbacks such as thenApply, thenAccept, and thenRun.
- Supports chaining and combining multiple asynchronous computations using: thenCombine, thenCompose, etc.
- Provides exception handling via exceptionally and handle for safe error recovery.
- Enables asynchronous execution on custom ExecutorServices or the common ForkJoinPool.

Initializers
- Tasks can be started asynchronously using:
  - supplyAsync() -> executes a task that produces a result.
  - runAsync() -> executes a task that produces no result (void).
- Both methods have variants that accept an Executor, allowing custom thread pool management.

Notes
- Use the "Async" variants ("thenApplyAsync", "thenAcceptAsync", etc.) to execute the operation in a separate thread,
  instead of the thread that completed the previous stage.
- CompletableFuture allows full asynchronous pipelines, minimizing thread blocking and improving responsiveness in
  applications.

Usage
- Start tasks with "supplyAsync()" or "runAsync()".  
- Chain transformations and consumption using intermediate operations.  
- Combine or merge multiple futures for complex pipelines.  
- Handle errors safely with "exceptionally()" or "handle()".  
- Use "join()" or "get()" to retrieve results at the end of the pipeline.  
- Ideal for building asynchronous APIs, services, or utilities requiring non-blocking and composable computation.
*/
void main() {
    //==================================================================================================================
    // Task Initialization
    //==================================================================================================================

    /*
    Supply
    - The "supplyAsync" method starts an asynchronous computation that produces a result.
    - Useful for running tasks in the background without blocking the main thread.
    - The returned CompletableFuture can be chained with transformations or combined with other futures.
    - Use "join()" to wait for the computation to finish and retrieve the result synchronously.
    - Output: Hello World
    */
    String result = CompletableFuture
            .supplyAsync(() -> "Hello World")
            .join();
    IO.println(result);

    /*
    Run
    - The "runAsync" method starts an asynchronous computation that does not return a result (void).
    - Use "thenRun" to execute an action after the previous task completes; it also does not receive any result.
    - Useful for running side effect tasks asynchronously, such as logging, notifications, or state updates.
    - Use "join()" to wait for the tasks to finish before proceeding.
    - Output: Hello | World
    */
    CompletableFuture
            .runAsync(() -> IO.println("Hello"))
            .thenRun(() -> IO.println("World"))
            .join();

    /*
    Custom Executor
    - Both "supplyAsync" and "runAsync" accept a custom Executor, allowing you to control which threads execute
      the asynchronous tasks.
    - Extremely recommended to use virtual threads from Project Loom for lightweight and scalable asynchronous
      execution, avoiding thread exhaustion in high-concurrency scenarios.
    - Use "join()" to wait for the action to complete.
    - Output: Hello World
    */
    ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
    result = CompletableFuture
            .supplyAsync(() -> "Hello World", executor)
            .join();
    IO.println(result);

    //==================================================================================================================
    // Result Transformation (Apply)
    //==================================================================================================================

    /*
    Then Apply
    - The "thenApply" method transforms the result of a CompletableFuture when it completes.
    - Use "thenApplyAsync" to perform the transformation asynchronously on a separate thread or executor.
    - Useful for applying computations or conversions to the result without blocking the previous stage.
    - Use "join()" to wait for the computation to finish and retrieve the transformed result.
    - Output: HELLO WORLD
    */
    result = CompletableFuture
            .supplyAsync(() -> "Hello World")
            .thenApply(String::toUpperCase)
            .join();
    IO.println(result);

    /*
    Apply To Either
    - The "applyToEither" method allows you to process the result of whichever CompletableFuture completes first.
    - Useful when you have multiple asynchronous tasks and only care about the first one that finishes.
    - The provided function transforms the result of the first completed future.
    - Use "join()" to wait for the computation to finish and retrieve the transformed result.
    - Output: HELLO or WORLD (depends on which task completes first)
    */
    result = CompletableFuture
            .supplyAsync(() -> "Hello")
            .applyToEither(CompletableFuture.supplyAsync(() -> "World"), String::toUpperCase)
            .join();
    IO.println(result);

    //==================================================================================================================
    // Result Computation (Accept)
    //==================================================================================================================

    /*
    Then Accept
    - The "thenAccept" method consumes the result of a CompletableFuture when it completes, without returning a new
      value.
    - Use "thenAcceptAsync" to consume the result asynchronously on a separate thread or executor.
    - Useful for performing side effect operations such as printing, logging, or updating state based on the result.
    - Use "join()" to wait for the action to complete.
    - Output: Hello World
    */
    CompletableFuture
            .supplyAsync(() -> "Hello World")
            .thenAccept(IO::println)
            .join();

    /*
    Then Accept Both
    - The "thenAcceptBoth" method allows you to perform an action using the results of two CompletableFutures once both
      have completed.
    - Useful for combining results when you need to perform a side effect operation without returning a new value.
    - The provided BiConsumer receives both results to execute the desired action.
    - Use "join()" to wait for both tasks and the combined action to finish.
    - Output: Hello World
    */
    CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenAcceptBoth(
                    CompletableFuture.supplyAsync(() -> "World"),
                    (result1, result2) -> IO.println(result1 + " " + result2)
            )
            .join();

    /*
    Accept Either
    - The "acceptEither" method executes an action using the result of whichever CompletableFuture completes first.
    - Useful when you have multiple asynchronous tasks and only need to act on the first completed result.
    - The provided Consumer receives the first completed value to perform a side effect operation.
    - Use "join()" to wait for the action to complete.
    - Output: Hello or World (depending on which task completes first)
    */
    CompletableFuture
            .supplyAsync(() -> "Hello")
            .acceptEither(
                CompletableFuture.supplyAsync(() -> "World"),
                IO::println
            )
            .join();

    //==================================================================================================================
    // Future Composition
    //==================================================================================================================

    /*
    Then Compose (Dependent Futures)
    - The "thenCompose" method is used to chain dependent asynchronous tasks, where the second task depends on the
      result of the first.
    - Useful for flattening nested CompletableFutures and creating sequential asynchronous pipelines.
    - The provided function receives the first result and returns a new CompletableFuture for the next computation.
    - Use "join()" to wait for the full chain to complete and retrieve the final result.
    - Output: HELLO WORLD
    */
    result = CompletableFuture
            .supplyAsync(() -> "Hello World")
            .thenCompose(x -> CompletableFuture.supplyAsync(() -> x.toUpperCase()))
            .join();
    IO.println(result);

    /*
    Then Combine (Independent Futures)
    - The "thenCombine" method is used to combine the results of two independent CompletableFutures once both have
      completed.
    - Useful for merging results from parallel asynchronous tasks into a single value.
    - The provided BiFunction receives both results and returns the combined value.
    - Use "join()" to wait for both tasks to finish and retrieve the final combined result.
    - Output: Hello World
    */
    result = CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenCombine(
                    CompletableFuture.supplyAsync(() -> "World"),
                    (result1, result2) -> result1 + " " + result2
            ).join();
    IO.println(result);

    //==================================================================================================================
    // Exception Handling
    //==================================================================================================================

    /*
    Exceptionally
    - The "exceptionally" method allows you to handle exceptions that occur in a CompletableFuture pipeline.
    - Useful for providing fallback values or recovering from errors without breaking the asynchronous chain.
    - The provided function receives the exception and returns an alternative value.
    - Use "join()" to wait for the computation to finish and retrieve either the normal result or the fallback value.
    - Output: Error: java.lang.ArithmeticException: / by zero
    */
    result = CompletableFuture
            .supplyAsync(() -> 1 / 0)
            .thenApply(x -> "Result is: " + x)
            .exceptionally(e -> "Error: " + e.getMessage())
            .join();
    IO.println(result);

    /*
    Exceptionally Compose
    - The "exceptionallyCompose" method allows you to handle exceptions by returning a new CompletableFuture, enabling
      asynchronous recovery from errors.
    - Useful when you want to continue the computation asynchronously after an exception occurs, instead of providing a
      simple fallback value.
    - The provided function receives the exception and returns a CompletableFuture with an alternative result.
    - Use "join()" to wait for the recovery computation to finish and retrieve the final result.
    - Output: Error: java.lang.ArithmeticException: / by zero
    */
    result = CompletableFuture
            .supplyAsync(() -> 1 / 0)
            .thenApply(x -> "Result is: " + x)
            .exceptionallyCompose(x -> CompletableFuture.supplyAsync(() -> "Error: " + x.getMessage()))
            .join();
    IO.println(result);

    /*
    Handle
    - The "handle" method allows you to process both the result and the exception in a single step.
    - Useful for performing recovery, logging, or transforming the result regardless of whether an error occurred.
    - The provided BiFunction receives two parameters: the result (if available) and the exception (if any).
    - Return a new value based on the result or exception to continue the computation safely.
    - Use "join()" to wait for the computation to finish and retrieve the final processed value.
    - Output: Error: java.lang.ArithmeticException: / by zero
    */
    result = CompletableFuture
            .supplyAsync(() -> 1 / 0)
            .thenApply(x -> "Result is: " + x)
            .handle((x, e) -> {
                if (e != null) {
                    return "Error: " + e.getMessage();
                }
                return "Result is:" + x;
            })
            .join();
    IO.println(result);
}