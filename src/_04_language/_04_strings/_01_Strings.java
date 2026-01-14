/*
 * Strings
 * - This section explains how strings represent textual data in Java and how they are implemented as immutable objects.
 *
 * Overview
 * - Strings are instances of the "String" class, representing an ordered sequence of characters.
 * - Variables of type "String" hold references to immutable string objects.
 * - String literals are managed in the JVM string pool for memory efficiency and reuse.
 *
 * Key Characteristics
 * - Strings are sequences of UTF-16 code units ("char" values).
 * - "String" is a reference type but immutable; operations that modify a string return a new instance.
 * - Equality between strings should be checked using "equals()", not "==".
 * - Supports concatenation, substring, and various utility methods for manipulation.
 *
 * Usage
 * - Use strings to store and manipulate textual data.
 * - Prefer "StringBuilder" or "StringBuffer" for intensive modifications to avoid creating many temporary objects.
 * - Use the string pool to optimize memory when reusing literal values.
 */
void main() {
    /*
     * Declaration
     * - We can assign text (String) literals to a variable of String type.
     * - It is managed by the JVM string pool.
     * - Output: Hello World
     */
    String x = "Hello World";
    IO.println(x);

    /*
     * Multi-line String (Text Block)
     * - Text blocks provide a concise and readable way to declare multi-line strings.
     * - They preserve line breaks and formatting exactly as written, reducing the need for escape characters and string
     *   concatenation.
     * - This feature is available in Java 15+ and is ideal for large text, templates, JSON, SQL, or documentation
     *   strings.
     * - Output: Hello | World
     */
    x = """
        Hello
        World
    """;
    IO.println(x);
    System.exit(0);

    /*
     * Nullable
     * - Since the String data type is a reference type, it can represent the absence of a value.
     * - Output: null
     */
    x = null;
    IO.println(x);

    /*
     * Immutability
     * - String are immutable.
     * - Any operation that appears to modify a String actually returns a new instance.
     * - The original string remains unchanged.
     * - Output: Hello World | HELLO WORLD
     */
    x = "Hello World";
    String y = x.toUpperCase();
    IO.println(x + " | " + y);

    /*
     * Equality
     * - To compare String types, we must use the "equals" method rather than the '==' operator.
     * - The '==' operator checks if both references point to the same object, while equals() checks if the actual value
     *   is identical.
     * - Output: true
     */
    String a = "Hello World";
    String b = "Hello World";
    IO.println(a.equals(b));

    /*
     * Comparison
     * - To compare String types for ordering, we can use the "compareTo" method.
     * - It compares the current object with another object of the same type and returns a negative value, zero, or a
     *   positive value.
     * - Output: 0 (equal)
     */
    a = "Hello World";
    b = "Hello World";
    IO.println(a.compareTo(b));

    /*
     * Casting
     * - We can use the "valueOf" method to cast any other object to a String.
     * - Output: 3.14
     */
    x = String.valueOf(3.14);
    IO.println(x);

    /*
     * Concatenation
     * - Strings can be concatenated using the '+' operator.
     * - At compile time, constant expressions may be optimized by the compiler.
     * - Output: Hello World
     */
    x = "Hello" + " " + "World";
    IO.println(x);
}