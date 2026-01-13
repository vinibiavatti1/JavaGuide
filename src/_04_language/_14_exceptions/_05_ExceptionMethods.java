/*
Exception Methods
- This section explains the methods provided by the "Throwable" class (and inherited by Exception and RuntimeException)
  to inspect, manipulate, and handle exceptions in Java.

Overview
- Throwable provides methods to get information about the exception, its cause, stack trace, and suppressed exceptions.
- Most methods help with logging, debugging, or chaining exceptions.
- Supports both checked and unchecked exceptions in a consistent manner.

Key Characteristics
- Includes methods such as "getMessage()", "getLocalizedMessage()", "getCause()", "initCause()", "printStackTrace()",
  "addSuppressed()", "getSuppressed()", and "toString()".
- Exceptions can be chained using initCause() and getCause().
- Suppressed exceptions are supported for resource management (try-with-resources).
- Useful for both runtime handling and detailed debugging of errors.

Usage
- Use exception methods to log meaningful messages or inspect root causes.
- Print stack traces when debugging or collecting error reports.
- Retrieve suppressed exceptions when handling multiple resources.
- Avoid altering exceptions arbitrarily; mainly use for inspection and reporting.
*/
void main() {
    try {
        throw new Exception("Something Happened!");
    } catch (Exception e) {
        /*
        Exception Message
        - Returns the message describing the exception.
        - "getLocalizedMessage()" returns a locale-specific version of the exception message, allowing programs to
          provide error messages in the user's language; by default, it returns the same string as getMessage().
        - Output: Something Happened!
        */
        IO.println(e.getMessage());
        IO.println(e.getLocalizedMessage());

        /*
        Cause
        - Initializes and retrieves the cause of this exception.
        - Output: Cause: java.lang.Exception: Cause Exception
        */
        e.initCause(new Exception("Cause Exception"));
        IO.println("Cause: " + e.getCause());

        /*
        Stack Trace
        - Prints the stack trace to standard error.
        - Output: java.lang.Exception: Something Happened! at _05_ExceptionMethods.main(_05_ExceptionMethods.java:26)...
        */
        e.printStackTrace();

        /*
        Suppressed Exceptions
        - Adds a suppressed exception (commonly used with try-with-resources).
        - Retrieves the array of suppressed exceptions.
        - Output: Suppressed: Suppressed Exception
        */
        e.addSuppressed(new Exception("Suppressed Exception"));
        for (Throwable suppressed : e.getSuppressed()) {
            IO.println("Suppressed: " + suppressed.getMessage());
        }

        /*
        To String
        - Returns a string including the exception class and message.
        - Output: java.lang.Exception: Something Happened!
        */
        IO.println(e.toString());
    }
}