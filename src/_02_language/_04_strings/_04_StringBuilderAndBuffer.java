/*
StringBuilder and StringBuffer

StringBuilder and StringBuffer are mutable classes used to create and manipulate sequences of characters efficiently.
Unlike String, which is immutable, these classes allow in-place modification of their internal character storage.

Internally, both StringBuilder and StringBuffer manage a resizable array of characters, which avoids creating a new
String instance for every transformation.

This document focuses only on the core and distinctive methods of StringBuilder and StringBuffer, emphasizing their
mutable behavior, buffer management, and in-place text modification capabilities.

Key differences:
- StringBuilder is not synchronized and is therefore not thread-safe.
  It offers better performance and should be preferred in single-threaded or method-local contexts.
- StringBuffer is synchronized (thread-safe) and can be safely used in multithreaded environments, at the cost of
  additional synchronization overhead.

Common characteristics:
- Both classes are mutable and operate directly on an internal character array.
- Both implement the CharSequence interface.
- Most modification methods return the same instance, allowing method chaining.
- Both can be converted to String using toString() when an immutable result is needed.

Usage guidelines:
- Prefer StringBuilder for performance in non-concurrent code.
- Use StringBuffer only when thread safety is required and synchronization cannot be managed externally.
*/
@SuppressWarnings("all")
void main() {
    //==================================================================================================================
    // Transformation
    //==================================================================================================================

    /*
    Append
    Appends the specified object to this character sequence.
    It supports: all native datatypes, Object, char[], etc.
    Output: Hello World
    */
    StringBuilder x = new StringBuilder("Hello");
    x.append(" World");
    IO.println(x);

    /*
    Insert
    Inserts the object into this character sequence.
    Output: Hello World
    */
    x = new StringBuilder("World");
    x.insert(0, "Hello ");
    IO.println(x);

    /*
    Set Char At
    The character at the specified index is set to ch.
    Output: Hello-World
    */
    x = new StringBuilder("Hello World");
    x.setCharAt(5, '-');
    IO.println(x);

    /*
    Delete
    Removes the characters in a substring of this sequence.
    Output: World
    */
    x = new StringBuilder("Hello World");
    x.delete(0, 6);
    IO.println(x);

    /*
    Delete Char At
    Removes the char at the specified position in this sequence.
    Output: HelloWorld
    */
    x = new StringBuilder("Hello-World");
    x.deleteCharAt(5);
    IO.println(x);

    /*
    Repeat
    Appends count copies of the specified CharSequence to this sequence.
    Output: Hello World World
    */
    x = new StringBuilder("Hello");
    x.repeat(" World", 2);
    IO.println(x);

    /*
    Replace
    Replaces the characters in a substring of this sequence with characters in the specified String.
    Output: Hi World
    */
    x = new StringBuilder("Hello World");
    x.replace(0, 5, "Hi");
    IO.println(x);

    /*
    Reverse
    Causes this character sequence to be replaced by the reverse of the sequence.
    Output: dlroW olleH
    */
    x = new StringBuilder("Hello World");
    x.reverse();
    IO.println(x);

    //==================================================================================================================
    // Internal Buffer Management
    //==================================================================================================================

    /*
    Capacity
    Returns the current capacity.
    StringBuilder maintains an internal character array with a certain capacity.
    This capacity defines how many characters can be stored without reallocating
    the internal buffer.
    Output: 27
    */
    x = new StringBuilder("Hello World");
    int cap = x.capacity();
    IO.println(cap);

    /*
    Ensure Capacity
    Ensures that the capacity is at least equal to the specified minimum.
    Output: 56
    */
    x = new StringBuilder("Hello World");
    x.ensureCapacity(56);
    cap = x.capacity();
    IO.println(cap);

    /*
    Trim to Size
    Attempts to reduce storage used for the character sequence.
    Output: 11
    */
    x = new StringBuilder("Hello World");
    x.trimToSize();
    cap = x.capacity();
    IO.println(cap);

    //==================================================================================================================
    // String Buffer
    //==================================================================================================================

    /*
    String Buffer
    StringBuffer behaves like StringBuilder and provides the same set of methods,
    but all its operations are synchronized, making it thread-safe at the cost of
    lower performance.
    Output: Hello World
    */
    StringBuffer y = new StringBuffer("Hello");
    y.append(" World");
    IO.println(y);
}