/*
Strings
A string represents an ordered sequence of characters used to model textual data.

In Java, strings are instances of the String class and are implemented as immutable objects. Variables of type String
hold references to these objects, not the characters themselves.

String literals are managed by the JVM through the string pool, allowing reuse of identical values and efficient memory
usage.

Key characteristics:
- Strings represent textual data as sequences of UTF-16 code units (char).
- String is a reference type, but its instances are immutable.
- Any operation that appears to modify a string returns a new instance.
- Equality should be checked using equals(), not ==.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaration
    We can assign text (String) literals to a variable of String type.
    It is managed by the JVM string pool.
    Output: Hello World
    */
    String x = "Hello World";
    IO.println(x);

    /*
    Nullable
    Since the String data type is a reference type, it can represent the absence of a value.
    Output: null
    */
    x = null;
    IO.println(x);

    /*
    Immutability
    String are immutable.
    Any operation that appears to modify a String actually returns a new instance.
    The original string remains unchanged.
    Output: Hello World | HELLO WORLD
    */
    x = "Hello World";
    String y = x.toUpperCase();
    IO.println(x + " | " + y);

    /*
    Equality
    To compare String types, we must use the "equals" method rather than the '==' operator.
    The '==' operator checks if both references point to the same object, while equals() checks if the actual value is
    identical.
    Output: true
    */
    String s1 = "Hello World";
    String s2 = "Hello World";
    boolean eq = s1.equals(s2);
    IO.println(eq);

    /*
    Comparison
    To compare String types for ordering, we can use the "compareTo" method.
    It compares the current object with another object of the same type and returns a negative value, zero, or a
    positive value.
    Output: 0 (equal)
    */
    s1 = "Hello World";
    s2 = "Hello World";
    int cmp = s1.compareTo(s2);
    IO.println(cmp);

    /*
    Casting
    We can use the "valueOf" method to cast any other object to a String.
    Output: 3.14
    */
    x = String.valueOf(3.14);
    IO.println(x);

    /*
    Concatenation
    Strings can be concatenated using the '+' operator.
    At compile time, constant expressions may be optimized by the compiler.
    Output: Hello World
    */
    x = "Hello" + " " + "World";
    IO.println(x);
}