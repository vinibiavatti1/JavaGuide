/*
Strings
A string represents an ordered sequence of characters used to model textual data.

In Java, strings are instances of the String class and are implemented as
immutable objects. Variables of type String hold references to these objects,
not the characters themselves.

String literals are managed by the JVM through the string pool, allowing
reuse of identical values and efficient memory usage.

Key characteristics:
- Strings represent textual data as sequences of UTF-16 code units (char).
- String is a reference type, but its instances are immutable.
- Any operation that appears to modify a string returns a new instance.
- Equality should be checked using equals(), not ==.
*/
@SuppressWarnings("ConstantConditions")
void main() {
    /*
    Declaring
    Text (String) literals create instances managed by the JVM string pool.
    Output: Hello World
    */
    String x = "Hello World";
    IO.println(x);

    /*
    Concatenation
    Strings can be concatenated using the '+' operator.
    At compile time, constant expressions may be optimized by the compiler.
    Output: Hello World
    */
    x = "Hello" + " " + "World";
    IO.println(x);

    /*
    Immutability
    Any operation that appears to modify a String actually returns a new instance.
    The original string remains unchanged.
    Output: Hello World | HELLO WORLD
    */
    x = "Hello World";
    String y = x.toUpperCase();
    IO.println(x + " | " + y);

    /*
    Equality
    Strings should be compared using the equals() method rather than the '==' operator.
    The '==' operator checks if both references point to the same object,
    while equals() checks if the actual character sequences are identical.
    Output: true
    */
    x = "Hello World";
    y = "Hello World";
    boolean eq = x.equals(y);
    IO.println(eq);
}