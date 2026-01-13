/*
 * Custom Exceptions
 * - This section explains how to create and use custom (checked and unchecked) exceptions in Java.
 *
 * Overview
 * - Checked exceptions extend "Exception" and must be either caught or declared in the method signature with "throws".
 * - Unchecked exceptions extend "RuntimeException" and do not need to be declared or explicitly caught.
 * - Use checked exceptions for recoverable conditions and operations the caller should handle.
 * - Use unchecked exceptions for programming errors that usually indicate bugs, such as invalid arguments or illegal
 *   states.
 *
 * Key Characteristics
 * - Custom exceptions can add constructors, fields, and methods.
 * - Custom exceptions can carry additional information and improve error handling clarity.
 * - Provide meaningful messages to clarify the cause of the exception.
 * - Both checked and unchecked exceptions can be caught and handled using try-catch blocks.
 *
 * Usage
 * - Use checked exceptions to force the caller to handle recoverable errors.
 * - Use unchecked exceptions for programming errors or situations where handling is optional.
 * - Catch exceptions only if you can meaningfully recover; otherwise, let them propagate.
 *
 * Example:
 * - The example below demonstrates defining a checked exception "MyCheckedException" and an unchecked exception
 *   "MyUncheckedException".
 * - Checked exceptions must be declared in the method signature using "throws", forcing callers to handle or propagate.
 * - Unchecked exceptions do not need to be declared, and can propagate freely without being caught.
 */
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}

/*
 * Methods
 * - The methods below will be defined and used in main, to demonstrate how to handle custom exceptions.
 */
public void throwCheckedException() throws MyCheckedException {
    throw new MyCheckedException("My Checked Exception");
}
public void throwUncheckedException() {
    throw new MyUncheckedException("My Unchecked Exception");
}

void main() {
    /*
     * Throwing and Catching a Checked Exception
     * - The try-catch block or a throws declaration is mandatory.
     * - Output: My Checked Exception
     */
    try {
        throwCheckedException();
    } catch (Exception e) {
        IO.println(e.getMessage());
    }

    /*
     * Throwing and Catching an Unchecked Exception
     * - The try-catch block or the throws declaration is optional.
     * - Output: My Unchecked Exception
     */
    try {
        throwUncheckedException();
    } catch (Exception e) {
        IO.println(e.getMessage());
    }
}