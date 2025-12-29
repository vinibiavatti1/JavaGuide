/*
Wrapper Types
Java provides a set of wrapper classes for each primitive data type.

These classes are reference types that encapsulate primitive values inside objects.

Wrapper types exist mainly to support:
- Object-oriented APIs (Collections, Generics)
- Nullable values
- Utility methods (parsing, comparison, conversion)
- Integration with frameworks and libraries

Each wrapper type corresponds directly to a primitive type and is part of the java.lang package.
*/
@SuppressWarnings("all")
void main() {
    /*
    Wrapper Types
    The wrapper types below are available in Java and can be used as reference data types in place of their
    corresponding primitive types.
    Common types: Integer, Double, Boolean and Character
    Less common types: Byte, Short, Long, Float
    */
    Byte x1 = 127;      // Wrapper for byte
    Short x2 = 32767;   // Wrapper for short
    Integer x3 = 0;     // Wrapper for int (default for integers)
    Long x4 = 999_999L; // Wrapper for long
    Float x5 = 3.14f;   // Wrapper for float
    Double x6 = 3.14;   // Wrapper for double (default for decimals)
    Boolean x7 = true;  // Wrapper for boolean
    Character x8 = 'A'; // Wrapper for char

    /*
    Declaration
    We can use the "valueOf" function to declare an instance of this datatype.
    Output: 5
    */
    Integer w = Integer.valueOf(5);
    IO.println(w);

    /*
    Nullable
    Unlike primitive data types, wrapper types can be null, meaning they are able to represent the absence of a value.
    Output: null
    */
    w = null;
    IO.println(w);

    /*
    Equality
    To compare wrapper types, we must use the "equals" method rather than the '==' operator.
    The '==' operator checks if both references point to the same object, while equals() checks if the actual value is
    identical.
    Output: true
    */
    Integer w1 = Integer.valueOf(5);
    Integer w2 = Integer.valueOf(5);
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Comparison
    To compare wrapper types for ordering, we can use the "compareTo" method.
    It compares the current object with another object of the same type and returns a negative value, zero, or a
    positive value.
    Output: 0 (equal)
    */
    w1 = Integer.valueOf(5);
    w2 = Integer.valueOf(5);
    int cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Casting
    We can cast the wrapper data type to any other data type using the "typeValue" methods.
    Output: 5.0
    */
    w = Integer.valueOf(5);
    double d = w.doubleValue();
    IO.println(d);

    /*
    Boolean Consants
    Boolean wrapper class provide predefined boolean instances.
    */
    IO.println(Boolean.TRUE);  // new Boolean(true);
    IO.println(Boolean.FALSE); // new Boolean(false);
}