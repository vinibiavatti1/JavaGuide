/*
StringBuilder and StringBuffer
This section explains the mutable character sequence classes "StringBuilder" and "StringBuffer", which allow
efficient in-place modification of text without creating new string instances.

Overview
- Both classes manage a resizable internal character array to store text.
- Unlike "String", they are mutable and support direct modification of content.
- "StringBuilder" is un-synchronized and faster, suitable for single-threaded contexts.
- "StringBuffer" is synchronized and thread-safe, suitable for multithreaded environments.

Key Characteristics
- Both implement the "CharSequence" interface.
- Most modification methods return the same instance, enabling method chaining.
- Can be converted to immutable "String" using "toString()".
- Allow operations such as "append", "insert", "delete", "replace", and "reverse" directly on the internal buffer.

Usage
- Use "StringBuilder" for efficient string manipulation in single-threaded code.
- Use "StringBuffer" when multiple threads need safe access to the same mutable text.
- Favor method chaining for concise and readable modifications.
- Convert to "String" only when an immutable result is required.
*/

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
    IO.println(x.capacity());

    /*
    Ensure Capacity
    Ensures that the capacity is at least equal to the specified minimum.
    Output: 56
    */
    x = new StringBuilder("Hello World");
    x.ensureCapacity(56);
    IO.println(x.capacity());

    /*
    Trim to Size
    Attempts to reduce storage used for the character sequence.
    Output: 11
    */
    x = new StringBuilder("Hello World");
    x.trimToSize();
    IO.println(x.capacity());

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