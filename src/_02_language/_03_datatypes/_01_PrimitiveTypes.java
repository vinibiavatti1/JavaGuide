/*
Primitive Types
- This section explains the built-in primitive data types in Java, which are used to store simple values directly in
  memory.

Overview
- Java provides eight primitive types: byte, short, int, long, float, double, char, and boolean.
- Primitive types store raw values and are not objects.
- They offer efficient memory usage and fast performance compared to reference types.

Key Characteristics
- Each type has a fixed size and range (e.g., int: 32-bit signed, double: 64-bit floating point).
- Used for numbers, characters, and boolean logic.
- Not nullable; they always hold a value.
- Default types in the standard library are "int" for integers and "double" for floating-point numbers.

Usage
- Use primitive types for performance-critical or memory-sensitive operations.
- Combine with wrapper classes (Integer, Double, etc.) when object behavior or generics are needed.
- Commonly used in arithmetic, logical operations, and control flow conditions.
*/
void main() {
    /*
    Data Types
    - The primitive types below are available in Java and can be used to store values in memory.
    - Common types: int, double, boolean and char
    - Less common types: byte, short, long, float
    */
    byte y1 = 127;      // 8-bit signed integer
    short y2 = 32767;   // 16-bit signed integer
    int x2 = 0;         // 32-bit signed integer (default for integers)
    long y3 = 999_999L; // 64-bit signed integer
    float y4 = 3.14f;   // 32-bit floating-point
    double x3 = 3.14;   // 64-bit floating-point (default for decimals)
    boolean x1 = true;  // Represents true or false values
    char x4 = 'A';      // Single UTF-16 character

    /*
    Declaration
    - We can use the "<type> <name> = <value>;" syntax to declare a variable of a data type.
    - Output: 5
    */
    int x = 5;
    IO.println(x);

    /*
    Equality
    - To compare data types, we can use the '==' operator.
    - Output: true
    */
    int i1 = 5;
    int i2 = 5;
    boolean eq = i1 == i2;
    IO.println(eq);

    /*
    Parsing
    - To parse a String to the data type, we can use the "parseType" method.
    - Output: 10
    */
    int i = Integer.parseInt("10");
    IO.println(i);

    /*
    Comparison
    - To compare data types for ordering, we can use the "compare" method from the wrapper type class.
    - It compares the current object with another object of the same type and returns a negative value, zero, or a
      positive value.
    - Output: 0 (equal)
    */
    i1 = 5;
    i2 = 5;
    int cmp = Integer.compare(i1, i2);
    IO.println(cmp);

    /*
    Casting
    - We can cast the data type to any other data type using the "(type)" syntax.
    - Output: 5.0
    */
    i = 5;
    double d = (double)i;
    IO.println(d);

    /*
    Min and Max Values
    - To retrieve the min and max values of numeric wrapper types, we can use the fields available in the wrapper class.
    */
    IO.println(Integer.MIN_VALUE); // -2147483648
    IO.println(Integer.MAX_VALUE); // 2147483647

    /*
    Floating-point Constants
    - Floating-point wrapper classes provide useful predefined constants, such as NaN (Not a Number), positive infinity,
      and negative infinity.
    */
    IO.println(Double.NaN);               // NaN (0.0d / 0.0)
    IO.println(Double.NEGATIVE_INFINITY); // -Infinity (-1.0 / 0.0)
    IO.println(Double.POSITIVE_INFINITY); // Infinity (1.0 / 0.0)
}