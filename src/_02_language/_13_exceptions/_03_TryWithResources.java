/*
Try-With-Resources
- This section explains how to use try-with-resources in Java to automatically manage resources that implement
  AutoCloseable, such as files, streams, and sockets.

Overview
- The try-with-resources statement declares one or more resources in parentheses after the try keyword.
- Resources are automatically closed at the end of the try block, whether an exception occurs or not.
- Helps prevent resource leaks and eliminates the need for explicit finally blocks for closing resources.

Key Characteristics
- Resources must implement the AutoCloseable interface (or Closeable, which extends AutoCloseable).
- Multiple resources can be declared, separated by semicolons.
- Exceptions thrown during resource closure are suppressed but can be accessed via getSuppressed().
- Can be combined with catch and finally blocks for additional exception handling.

Usage
- Use try-with-resources whenever you work with resources that require closing, such as files, streams, readers,
  writers, or database connections.
- Eliminates boilerplate code for manually closing resources in a finally block.
- Ensures resources are properly closed even if an exception occurs in the try block.

Example:
- The example below demonstrates how to implement AutoCloseable in a custom resource class.
- It also shows how to use try-with-resources statements to automatically manage and close the resource.
*/
public class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
    }

    @Override
    public void close() {
        IO.println("Resource " + name + " closed");
    }
}

void main() {
    /*
    Try-With-Resources
    - Demonstrates using try-with-resources to automatically manage a resource that implements AutoCloseable.
    - The resource is opened when declared in the try statement and automatically closed at the end of the block.
    - Useful to ensure proper cleanup without needing a finally block.
    - Output: Doing stuff... | Resource A closed
    */
    try (MyResource a = new MyResource("A")) {
        IO.println("Doing stuff...");
    }

    /*
    Try-With-Resources (with multiple resources)
    - Demonstrates using multiple resources in a single try-with-resources statement.
    - Resources are opened in the order declared and automatically closed in reverse order when the block finishes.
    - Useful to ensure proper cleanup of multiple resources without a finally block.
    - Output example: Doing stuff... | Resource B closed | Resource A closed
    */
    try (MyResource a = new MyResource("A");
         MyResource b = new MyResource("B")) {
        IO.println("Doing stuff...");
    }

    /*
    Try-With-Resources (with catch and finally blocks)
    - Demonstrates a try-with-resources statement combined with catch and finally blocks.
    - The resource is automatically closed at the end of the try block, even if an exception occurs.
    - The finally block executes regardless of whether an exception occurred, allowing for additional cleanup or
      logging.
    - Output example: Doing stuff... | Resource A closed | Finally block executed
    */
    try (MyResource a = new MyResource("A")) {
        IO.println("Doing stuff...");
    } catch (Exception e) {
        IO.println("Exception caught: " + e.getMessage());
    } finally {
        IO.println("Finally block executed");
    }
}