/*
Threads
- This section explains the "Thread" class in Java, which represents an independent sequence of execution within a
  program, enabling concurrent task execution.

Overview
- The "Thread" class is part of the java.lang package and provides methods to create, control, and manage threads.
- Threads can be user threads, which prevent the JVM from exiting until they finish, or daemon threads, which run
  in the background and do not block JVM shutdown.
- Thread behavior can be defined by extending the Thread class or by implementing the Runnable interface.
- Direct use of Thread offers fine-grained control, but for better management, resource reuse, and scalability,
  using the Executors factory with thread pools is recommended.

Key Characteristics
- Can be created by implementing the Runnable interface and passing its instance to a Thread object. Extending the
  Thread class is another option, but it is generally discouraged because it reduces flexibility.
- Provides methods for starting ("start()"), waiting ("join()"), pausing ("sleep()"), and signaling ("interrupt()")
  threads.
- User threads keep the JVM alive until completion, while daemon threads terminate automatically when all user threads
  finish.
- Runnable interface defines a single "run()" method, allowing task logic to be decoupled from thread management.
- Allows precise control over thread lifecycle, priority, and behavior, but requires manual resource management.

Usage
- Always prefer creating threads using the Executors factory, as it handles thread creation, reuse, scheduling, and
  lifecycle management efficiently, reducing boilerplate code and avoiding common concurrency pitfalls.
- Use Thread to execute tasks concurrently when fine-grained control or simplicity is required.
- Implement Runnable to separate task logic from thread management.
- Use daemon threads for background maintenance tasks that should not block JVM shutdown.
*/
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            IO.println("Hello World");
        } catch (InterruptedException e) {
            IO.println("Thread Interrupted!");
        }
    }
}

void main() throws InterruptedException {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declare a User Thread
    - Creates a new user thread by passing a Runnable task (Task) to the Thread constructor.
    - The thread runs concurrently with other threads when "start()" is called.
    - User threads keep the JVM alive until they complete.
    - Preferred for simple concurrent tasks, but consider using Executors for better thread management in production.
    - Output: No immediate output; the thread executes asynchronously when started.
    */
    Thread thread = new Thread(new Task());

    /*
    Declare a Thread with Lambda Expression
    - Creates a new thread using a lambda expression to define the Runnable task.
    - Lambdas provide a concise way to implement the "Runnable" interface without creating a separate class.
    - Useful for short, simple tasks that can be defined inline.
    - Output: No immediate output; the thread executes asynchronously when started.
    */
    thread = new Thread(() -> IO.println("Hello World"));

    /*
    Declare a Daemon Thread
    - Creates a daemon thread by passing a Runnable task (Task) to the Thread constructor and calling "setDaemon(true)".
    - Daemon threads run in the background and do not prevent the JVM from exiting once all user threads have finished.
    - Useful for background maintenance tasks, monitoring, logging, or cleanup operations that should not block JVM
      shutdown.
    - Avoid using daemon threads for critical tasks that must complete before the application exits.
    - Output: No immediate output; the thread executes asynchronously when started.
    */
    thread = new Thread(new Task());
    thread.setDaemon(true);

    //==================================================================================================================
    // Operations
    //==================================================================================================================

    /*
    Start
    - Starts the execution of the thread. The Runnable task (Task) passed to the Thread constructor will run
      concurrently with other threads.
    - Calling "start()" schedules the thread for execution; it does not block the current thread.
    - Each call to "start()" must be on a new Thread instance; reusing the same thread object will throw
      IllegalThreadStateException.
    - Output: Hello World (After 100ms)
    */
    thread = new Thread(new Task());
    thread.start();

    /*
    Sleep
    - Pauses the execution of the current thread for a specified duration (100 milliseconds in this example).
    - Note: "Thread.sleep()" affects the thread that calls it, not the thread instance on which it appears.
    - Useful for delaying execution, simulating long-running tasks, or coordinating timing between threads.
    - Output: Hello World (After 200ms)
    */
    thread = new Thread(new Task());
    thread.start();
    thread.sleep(200); // Pause

    /*
    Join
    - Waits for the thread to complete its execution before continuing with the current thread.
    - Calling "join()" on a thread ensures that the calling thread pauses until the target thread finishes.
    - Useful for coordinating tasks, ensuring results are ready before proceeding, or avoiding premature termination
      of the main thread.
    - Note: Unlike "sleep()", "join()" does not pause for a fixed time; it waits until the thread naturally
      completes its "run()" method.
    - Note: Overloaded versions of "join(long millis)" and "join(long millis, int nanos)" allow specifying a maximum
      time to wait for the thread to finish. If the timeout expires before the thread completes, the method returns
      normally without throwing an exception.
    - Output: Hello World (Waited)
    */
    thread = new Thread(new Task());
    thread.start();
    thread.join(); // Wait Completion

    /*
    Interrupt
    - Requests that the thread stop its current activity by setting its interrupted status.
    - The thread itself must handle the interruption, typically by checking "Thread.interrupted()" or catching
      "InterruptedException" if it is blocked in a method like "sleep()" or "wait()".
    - Useful for gracefully stopping long-running or blocking tasks without forcibly killing the thread.
    - Note: Calling "interrupt()" does not immediately terminate the thread; it only signals that an interruption
      has been requested.
    - Output: Thread Interrupted!
    */
    thread = new Thread(new Task());
    thread.start();
    thread.interrupt(); // Interrupt

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /*
    Sleep Current Thread
    - Pauses the execution of the current thread for the specified duration (100 milliseconds in this example).
    - Useful for delaying execution, simulating long-running tasks, or coordinating timing between threads.
    - Note: "Thread.sleep()" only affects the thread that calls it; other threads continue running independently.
    - Unlike "join()", it pauses for a fixed time rather than waiting for another thread to complete.
    - Output: Hello World (After 100ms)
    */
    Thread.sleep(100);
    IO.println("Hello World");
}