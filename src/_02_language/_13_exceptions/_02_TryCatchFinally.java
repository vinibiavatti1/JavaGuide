/*
Try-Catch-Finally
This section explains how to use try-catch-finally blocks in Java to handle exceptions, ensuring proper error handling
and resource cleanup.

Overview
- The try block contains code that might throw exceptions.
- The catch block handles specific exceptions thrown in the try block.
- The finally block contains code that always executes, regardless of whether an exception occurred.
- Helps maintain program stability and avoids crashes due to unhandled exceptions.

Key Characteristics
- Multiple catch blocks can be used to handle different exception types.
- A single catch block can handle multiple exception types using the pipe "|" operator.
- The finally block is optional but often used to close resources (files, streams, sockets).
- Try-with-resources is a special form of try that automatically closes resources implementing AutoCloseable.

Usage
- Use try-catch to handle exceptions gracefully and provide meaningful feedback or recovery.
- Use finally (or try-with-resources) to guarantee cleanup of resources.
- Catch only exceptions you can meaningfully handle; let others propagate if necessary.

Example
- A method will be declared below that throws a NullPointerException and a ArithmeticException depending on the value of
  the arguments.
- Catch blocks will be used to catch those exceptions to show how to handle them.
*/
public Double div(Double a, Double b) {
    if (a == null || b == null) {
        throw new NullPointerException("Input cannot be null");
    }
    if (b.equals(0.0)) {
        throw new ArithmeticException("Division by zero");
    }
    return a / b;
}

void main() {
    /*
    Try (with a catch block)
    - A simple try-catch block that handles exceptions thrown in the try block.
    - The example below will throw an ArithmeticException due to division by zero.
    - The catch block captures the exception, allowing the program to handle it gracefully instead of crashing.
    - Output: Exception caught: Division by zero
    */
    try {
        div(5.0, 0.0); // This will throw ArithmeticException due to division by zero
    } catch (Exception e) {
        IO.println("Exception caught: " + e.getMessage());
    }

    /*
    Try (with multiple catch blocks)
    - Demonstrates using multiple catch blocks to handle different exception types separately.
    - The example below will throw a NullPointerException due to null input values.
    - The first catch block handles ArithmeticException, and the second catch block handles any other exceptions, such
      as NullPointerException.
    - This allows different handling strategies depending on the exception type.
    - Output: Exception caught: Input cannot be null
    */
    try {
        div(null, null); // This will throw NullPointerException due to null input
    } catch (ArithmeticException e) {
        IO.println("Arithmetic exception caught: " + e.getMessage());
    } catch (Exception e) {
        IO.println("Exception caught: " + e.getMessage());
    }

    /*
    Try (with multiple exceptions in the same block)
    - Demonstrates using a single catch block to handle multiple exception types.
    - The pipe "|" operator allows combining exception types that share the same handling logic.
    - Additional catch blocks can still handle other exceptions separately.
    - Output: Exception caught: Input cannot be null
    */
    try {
        div(null, null); // Will throw NullPointerException
    } catch (ArithmeticException | NullPointerException e) {
        IO.println("Exception caught: " + e.getMessage());
    }

    /*
    Try (with catch blocks and finally)
    - Demonstrates using multiple catch blocks to handle different exceptions, and a finally block that always executes.
    - The finally block executes regardless of whether an exception occurred.
    - Output: Arithmetic Exception caught: Division by zero | Finally block executed
    */
    try {
        div(5.0, 0.0); // Will throw ArithmeticException due to division by zero
    } catch (ArithmeticException e) {
        IO.println("Arithmetic exception caught: " + e.getMessage());
    } catch (Exception e) {
        IO.println("Exception caught: " + e.getMessage());
    } finally {
        IO.println("Finally block executed");
    }

    /*
    Try (with finally block only)
    - Demonstrates a try block with only a finally block and no catch.
    - If an exception is thrown, it will always propagate to the caller.
    - The finally block always executes, even if no exception is thrown.
    - Useful for actions that must always run, such as cleanup or logging.
    - Output: Finally block executed
    */
    try {
        div(5.0, 2.5); // Normal execution, no exception thrown
    } finally {
        IO.println("Finally block executed");
    }
}