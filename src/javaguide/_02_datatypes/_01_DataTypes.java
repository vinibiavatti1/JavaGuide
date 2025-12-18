/*
Java provides a set of built-in data types used to store values in memory.
They can be divided into two main groups: primitive types and reference types.

In practice, a small subset of these types is used most of the time.
Types like int and double are the defaults in the Java standard library,
while smaller or less precise types are mainly used in strict performance
or memory-sensitive scenarios.
*/
void main() {
    /*
    Conventional and most commonly used data types
    These are the defaults you will see in the majority of Java codebases.
    */
    boolean x1 = true;          // Represents true or false values
    int x2 = 0;                 // 32-bit signed integer (default for integers)
    double x3 = 3.14;           // 64-bit floating-point (default for decimals)
    char x4 = 'A';              // Single UTF-16 character
    String x5 = "Hello World";  // Text (reference type, not primitive)

    /*
    Less commonly used primitive types
    These types exist mainly for specific use cases such as:
    - Strict memory optimization
    - Low-level or binary data processing
    - Performance-critical systems (e.g. games, embedded systems)
    In most applications, these values are quickly promoted to int or double
    when interacting with the Java standard library.
    */
    byte y1 = 127;              // 8-bit signed integer
    short y2 = 32767;           // 16-bit signed integer
    long y3 = 999_999L;         // 64-bit signed integer
    float y4 = 3.14f;           // 32-bit floating-point (less precision than double)
}