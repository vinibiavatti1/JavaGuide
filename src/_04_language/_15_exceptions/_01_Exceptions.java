/*
Exceptions in Java
- This section explains how exceptions work in Java, the difference between checked and unchecked exceptions, and the
  basic exception hierarchy.

Overview
- Exceptions are objects that represent errors or unexpected conditions during program execution.
- They are used to signal problems and allow programs to handle errors gracefully.
- Java distinguishes between checked exceptions (must be declared or handled) and unchecked exceptions (do not need to
  be declared).

Key Characteristics
- All exceptions inherit from java.lang.Throwable.
- Java has three main exception types:
  - Exception: Checked exceptions. Must be caught or declared in method signatures using "throws".
  - Runtime Exception: Unchecked exceptions (RuntimeException and its subclasses) do not need to be declared or caught.
  - Error: Serious system problems, typically unrecoverable, and are rarely created by developers.

Usage
- Use Checked Exceptions for recoverable conditions that the caller is expected to handle, such as file or database
  operations.
- Use Unchecked Exceptions for programming errors or unexpected situations, like NullPointerException or
  IndexOutOfBoundsException.
- Use Errors for serious system problems, like OutOfMemoryError, which usually should not be caught.

Main Checked Exceptions                      Use Case
- java.io.IOException                        File, stream, or network I/O errors
- java.io.FileNotFoundException              Expected file is missing
- java.io.EOFException                       Unexpected end of input stream
- java.sql.SQLException                      Database access or query errors
- java.lang.ClassNotFoundException           Class not found during reflection
- java.lang.CloneNotSupportedException       Attempting to clone an object that is not clonable
- java.lang.InterruptedException             Thread was interrupted during sleep, wait, or join
- java.util.concurrent.TimeoutException      Timeout errors

Main Unchecked Exceptions                    Use Case
- java.lang.NullPointerException             Object is null when it shouldn't be
- java.lang.IllegalArgumentException         Invalid method argument
- java.lang.IllegalStateException            Object is in an invalid state for operation (ex: close a closed connection)
- java.lang.IndexOutOfBoundsException        Invalid index in array, list, or string
- java.lang.ArrayIndexOutOfBoundsException   Invalid array index
- java.lang.StringIndexOutOfBoundsException  Invalid string index
- java.lang.NumberFormatException            String cannot be parsed into a number
- java.lang.ClassCastException               Invalid type cast
- java.lang.UnsupportedOperationException    Operation not supported (e.g., immutable collection)
- java.lang.ArithmeticException              Arithmetic errors (e.g., divide by zero)
- java.util.ConcurrentModificationException  Collection modified while iterating
- java.util.NoSuchElementException           Attempt to access an element that doesn’t exist
- java.lang.SecurityException                Any issue regarding security
- java.time.format.DateTimeParseException    Failure to parse a date/time string

Exception Hierarchy
Throwable
|- Error
   |- ...
|- Exception (Checked)
   |- ...
   |- RuntimeException (Unchecked)
      |- ...

Usage
- Use exceptions to handle error conditions instead of returning error codes.
- Catch only exceptions you can meaningfully handle; let others propagate.
- Declare checked exceptions with `throws` in method signatures if not handled.
*/
void main() {}

/*
Method (that throws a checked exception)
- Checked exceptions must be declared in the "throws" statement.
*/
public void methodWithCheckedException() throws IOException {
    throw new IOException();
}

/*
Method (that throws an unchecked exception)
- Unchecked exceptions do not need to be declared.
*/
public double methodWithUncheckedException() {
    throw new ArithmeticException();
}