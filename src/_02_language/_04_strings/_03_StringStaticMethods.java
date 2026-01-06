/*
String Static Methods
- This section explains the static methods provided by the "String" class to create, convert, or join textual data.

Overview
- Static methods operate on arguments rather than instances of String.
- Useful for converting primitives or objects to strings, joining multiple strings, or formatting text.

Key Characteristics
- Return new string instances; do not modify existing strings.
- Provide overloads for different argument types, such as arrays, collections, primitives, or objects.
- Operate independently of any particular String instance.

Usage
- Use static methods to convert values to strings, combine multiple strings with delimiters, or format text dynamically.
- Many methods have overloads to handle arrays, Iterable collections, or Locale-specific formatting.
- For repeated string manipulations beyond conversion/join/format, consider instance methods or StringBuilder for
  efficiency.
*/
void main() {
    /*
    Value Of
    - Returns the string representation of the given argument.
    - Has overloads for all primitive types, objects, and even char arrays.
    */
    String str = String.valueOf(3.14);
    IO.println(str); // "3.14"

    /*
    Join
    - Returns a new String composed of copies of the CharSequence elements joined together with the specified delimiter.
    - Can accept either a varargs of CharSequence or an Iterable (e.g., List<String>).
    */
    str = String.join(", ", "A", "B", "C");
    IO.println(str); // A, B, C

    /*
    Format
    - Returns a formatted string using the specified format string and arguments.
    - Supports multiple overloads, including optional Locale specification.
    - Useful for creating strings with dynamic values in a controlled format.
    */
    String template = "Hello, %s! You have %d messages.";
    str = String.format(template, "John", 3);
    IO.println(str); // Hello, John! You have 3 messages.
}
