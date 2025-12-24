/*
Java provides a set of wrapper classes for each primitive data type.
These classes are reference types that encapsulate primitive values
inside objects.

Wrapper types exist mainly to support:
- Object-oriented APIs (Collections, Generics)
- Nullable values
- Utility methods (parsing, comparison, conversion)
- Integration with frameworks and libraries

Each wrapper type corresponds directly to a primitive type and is part
of the java.lang package.
*/
@SuppressWarnings("all")
void main() {
    /*
    Most commonly used wrapper types
    These are frequently encountered when working with:
    - Collections (List, Set, Map)
    - Generics
    - APIs that require objects instead of primitives
    */
    Boolean w1 = true;  // Wrapper for boolean
    Integer w2 = 0;     // Wrapper for int
    Double w3 = 3.14;   // Wrapper for double
    Character w4 = 'A'; // Wrapper for char

    /*
    Less commonly used wrapper types
    These are typically used when:
    - Interacting with low-level APIs
    - Working with binary or network protocols
    - Explicitly controlling numeric ranges
    In most high-level code, these values are promoted to Integer or Double.
    */
    Byte w5 = 127;      // Wrapper for byte
    Short w6 = 32767;   // Wrapper for short
    Long w7 = 999_999L; // Wrapper for long
    Float w8 = 3.14f;   // Wrapper for float
}