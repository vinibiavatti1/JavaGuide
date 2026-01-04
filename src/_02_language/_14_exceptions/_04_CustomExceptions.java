/*
Custom Exceptions
- This section explains how to create and use custom (checked and unchecked) exceptions in Java.

Overview
- Checked exceptions extend "Exception" and must be either caught or declared in the method signature with "throws".
- Unchecked exceptions extend "RuntimeException" and do not need to be declared or explicitly caught.
- Use checked exceptions for recoverable conditions and operations the caller should handle.
- Use unchecked exceptions for programming errors that usually indicate bugs, such as invalid arguments or illegal 
  states.

Key Characteristics
- Custom exceptions can add constructors, fields, and methods.
- Custom exceptions can carry additional information and improve error handling clarity.
- Provide meaningful messages to clarify the cause of the exception.
- Both checked and unchecked exceptions can be caught and handled using try-catch blocks.

Usage
- Use checked exceptions to force the caller to handle recoverable errors.
- Use unchecked exceptions for programming errors or situations where handling is optional.
- Catch exceptions only if you can meaningfully recover; otherwise, let them propagate.

Example:
- The example below demonstrates defining and throwing a checked exception ("MyCheckedException") and an unchecked
  exception ("MyUncheckedException").
- Both exceptions are caught in separate try-catch blocks and handled by printing their messages.
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

void main() {
    /*
    Throwing and catching a checked exception
    - Demonstrates that a checked exception must be caught or declared in the method signature.
    - Output: My Checked Exception
    */
    try {
        throw new MyCheckedException("My Checked Exception");
    } catch (Exception e) {
        IO.println(e.getMessage());
    }

    /*
    Throwing and catching an unchecked exception
    - Demonstrates that an unchecked exception does not need to be declared but can still be caught.
    - Output: My Unchecked Exception
    */
    try {
        throw new MyUncheckedException("My Unchecked Exception");
    } catch (Exception e) {
        IO.println(e.getMessage());
    }
}