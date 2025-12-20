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
    Output: 1000000
    */
    long x1 = 1000000L;
    IO.println(x1);

    /*
    Using underscores for readability
    Underscores do not affect the numeric value.
    Output: 9223372036854775000
    */
    long x2 = 9_223_372_036_854_775_000L;
    IO.println(x2);

    /*
    Long arithmetic
    All standard arithmetic operations are supported.
    */
    long a = 10L, b = 3L;
    long sum = a + b;  // Sum
    long diff = a - b; // Subtraction
    long prod = a * b; // Multiplication
    long div = a / b;  // Integer division (fractional part is discarded)
    long mod = a % b;  // Module (remainder of the division)
    IO.println(sum);   // 13
    IO.println(diff);  // 7
    IO.println(prod);  // 30
    IO.println(div);   // 3
    IO.println(mod);   // 1

    /*
    Mixing int and long
    When one operand is long, the result is promoted to long.
    Output: 1000005
    */
    int i = 5;
    long mixed = i + x1;
    IO.println(mixed);

    /*
    Long limits
    Use MIN_VALUE and MAX_VALUE to check the boundaries.
    Output: min: -9223372036854775808 max: 9223372036854775807
    */
    long max = Long.MAX_VALUE;
    long min = Long.MIN_VALUE;
    IO.println("min: " + min + " max: " + max);

    /*
    Long overflow
    Like int, long overflows wrap around silently.
    Output: -9223372036854775808
    */
    long overflow = max + 1;
    IO.println(overflow);
}