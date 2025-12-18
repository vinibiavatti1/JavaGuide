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
void main() {
    /*
    Declaring an int variable
    Syntax: int <name> = <value>;
    */
    int x1 = 42;
    IO.println("x1 = " + x1);
    /* Output: x1 = 42 */

    /*
    Using underscores for readability
    Underscores do not affect the numeric value.
    */
    int x2 = 9_223_000;
    IO.println("x2 = " + x2);
    /* Output: x2 = 9223000 */

    /*
    Int arithmetic
    All standard arithmetic operations are supported.
    */
    int a = 10, b = 3;
    int sum = a + b;   // Sum
    int diff = a - b;  // Subtraction
    int prod = a * b;  // Multiplication
    int div = a / b;   // Integer division (fractional part is discarded)
    int mod = a % b;   // Module (remainder of the division)
    IO.println("sum: " + sum);
    IO.println("diff: " + diff);
    IO.println("prod: " + prod);
    IO.println("div: " + div);
    IO.println("mod: " + mod);
    /*
    Output:
    sum: 13
    diff: 7
    prod: 30
    div: 3
    mod: 1
    */

    /*
    Int limits
    Use MIN_VALUE and MAX_VALUE to check the boundaries.
    */
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    IO.println("min: " + min + " max: " + max);
    /* Output: min: -2147483648 max: 2147483647 */

    /*
    Integer overflow
    When exceeding the limits, int values wrap around silently.
    */
    int overflow = max + 1;
    IO.println("overflow: " + overflow);
    /* Output: overflow: -2147483648 */
}