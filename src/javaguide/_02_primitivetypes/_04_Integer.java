/*
The int type is a primitive data type in Java.
It is a 32-bit signed integer, meaning it can store values from
-2,147,483,648 to 2,147,483,647.

The int type is the default integer type in Java and the most commonly
used numeric type in the standard library and application code.

Notes:
- int is the preferred choice for integer arithmetic.
- Most Java APIs expect int values (indexes, sizes, loops, math operations).
- Arithmetic operations on smaller types (byte, short) are promoted to int.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaring an int variable
    Syntax: int <name> = <value>;
    Output: 42
    */
    int x1 = 42;
    IO.println(x1);

    /*
    Using underscores for readability
    Underscores do not affect the numeric value.
    Output: 9223000
    */
    int x2 = 9_223_000;
    IO.println(x2);

    /*
    Int arithmetic
    All standard arithmetic operations are supported.
    */
    int a = 10, b = 3;
    int sum = a + b;  // Sum
    int diff = a - b; // Subtraction
    int prod = a * b; // Multiplication
    int div = a / b;  // Integer division (fractional part is discarded)
    int mod = a % b;  // Module (remainder of the division)
    IO.println(sum);  // 13
    IO.println(diff); // 7
    IO.println(prod); // 30
    IO.println(div);  // 3
    IO.println(mod);  // 1

    /*
    Int limits
    Use MIN_VALUE and MAX_VALUE to check the boundaries.
    Output: min: -2147483648 max: 2147483647
    */
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    IO.println("min: " + min + " max: " + max);

    /*
    Integer overflow
    When exceeding the limits, int values wrap around silently.
    Output: -2147483648
    */
    int overflow = max + 1;
    IO.println(overflow);
}