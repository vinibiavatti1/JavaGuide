/*
 * Wrapper Types
 * - This section explains the wrapper classes in Java, which encapsulate primitive values as objects.
 *
 * Overview
 * - Each primitive type has a corresponding wrapper class: Byte, Short, Integer, Long, Float, Double, Character,
 *   Boolean.
 * - Wrapper types allow primitive values to be used in object-oriented contexts.
 * - They provide utility methods for parsing, conversion, and comparison.
 * - Wrapper types are sometimes referred to as "boxed" or "container" types because they wrap a primitive value inside
 *   an object.
 *
 * Key Characteristics
 * - Wrapper types are reference types and can be null.
 * - Useful for Collections, Generics, and APIs that require objects.
 * - Provide constants (MIN_VALUE, MAX_VALUE) and methods (parseInt, valueOf, etc.).
 * - Part of the "java.lang" package and automatically supported by autoboxing/unboxing.
 *
 * Usage
 * - Use wrapper types when objects are required instead of primitives (e.g., in Lists, Maps, or Generics).
 * - Enable nullability for primitive values when needed.
 * - Utilize utility methods for conversions and comparisons.
 */
void main() {
    /*
     * Wrapper Types
     * - The wrapper types below are available in Java and can be used as reference data types in place of their
     *   corresponding primitive types.
     * - Common types: Integer, Double, Boolean and Character
     * - Less common types: Byte, Short, Long, Float
     */
    Byte _ = 127;      // Wrapper for byte
    Short _ = 32767;   // Wrapper for short
    Integer _ = 0;     // Wrapper for int (default for integers)
    Long _ = 999_999L; // Wrapper for long
    Float _ = 3.14f;   // Wrapper for float
    Double _ = 3.14;   // Wrapper for double (default for decimals)
    Boolean _ = true;  // Wrapper for boolean
    Character _ = 'A'; // Wrapper for char

    /*
     * Declaration
     * - We can use the "valueOf" function to declare an instance of this datatype.
     * - Output: 5
     */
    Integer x = Integer.valueOf(5);
    IO.println(x);

    /*
     * Nullable
     * - Unlike primitive data types, wrapper types can be null, meaning they are able to represent the absence of a value.
     * - Output: null
     */
    x = null;
    IO.println(x);

    /*
     * Equality
     * - To compare wrapper types, we must use the "equals" method rather than the '==' operator.
     * - The '==' operator checks if both references point to the same object, while equals() checks if the actual value is
     *   identical.
     * - Output: true
     */
    Integer a = Integer.valueOf(5);
    Integer b = Integer.valueOf(5);
    boolean eq = a.equals(b);
    IO.println(eq);

    /*
     * Comparison
     * - To compare wrapper types for ordering, we can use the "compareTo" method.
     * - It compares the current object with another object of the same type and returns a negative value, zero, or a
     *   positive value.
     * - Output: 0 (equal)
     */
    a = Integer.valueOf(5);
    b = Integer.valueOf(5);
    int cmp = a.compareTo(b);
    IO.println(cmp);

    /*
     * Casting
     * - We can cast the wrapper data type to any other data type using the "typeValue" methods.
     * - Output: 5.0
     */
    x = Integer.valueOf(5);
    double d = x.doubleValue();
    IO.println(d);

    /*
     * Boolean Constants
     * - Boolean wrapper class provide predefined boolean instances.
     */
    IO.println(Boolean.TRUE);  // new Boolean(true);
    IO.println(Boolean.FALSE); // new Boolean(false);
}