/*
The long type is a primitive data type in Java.
It is a 64-bit signed integer, meaning it can store values from
-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.

The long type is used when int is not large enough to represent a value.
It is commonly used for large counters, timestamps, file sizes,
and identifiers.

Notes:
- long literals must use the suffix 'L' or 'l' (uppercase 'L' is recommended).
- Most arithmetic rules are the same as for int.
- Java standard libraries often use long for time-related values.
*/
void main() {
    /*
    Declaring a long variable
    Syntax: long <name> = <value>;
    */
    long x1 = 1000000L;
    IO.println("x1 = " + x1);
    /* Output: x1 = 1000000 */

    /*
    Using underscores for readability
    Underscores do not affect the numeric value.
    */
    long x2 = 9_223_372_036_854_775_000L;
    IO.println("x2 = " + x2);
    /* Output: x2 = 9223372036854775000 */

    /*
    Long arithmetic
    All standard arithmetic operations are supported.
    */
    long a = 10L, b = 3L;
    long sum = a + b;    // Sum
    long diff = a - b;   // Subtraction
    long prod = a * b;   // Multiplication
    long div = a / b;    // Integer division (fractional part is discarded)
    long mod = a % b;    // Module (remainder of the division)
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
    Mixing int and long
    When one operand is long, the result is promoted to long.
    */
    int i = 5;
    long mixed = i + x1;
    IO.println("mixed = " + mixed);
    /* Output: mixed = 1000005 */

    /*
    Long limits
    Use MIN_VALUE and MAX_VALUE to check the boundaries.
    */
    long max = Long.MAX_VALUE;
    long min = Long.MIN_VALUE;
    IO.println("min: " + min + " max: " + max);
    /* Output: min: -9223372036854775808 max: 9223372036854775807 */

    /*
    Long overflow
    Like int, long overflows wrap around silently.
    */
    long overflow = max + 1;
    IO.println("overflow: " + overflow);
    /* Output: overflow: -9223372036854775808 */
}