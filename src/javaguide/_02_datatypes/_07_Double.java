/*
The double type is a primitive data type in Java.
It is a 64-bit floating-point number that follows the IEEE 754 standard.

Double is the default type for decimal numbers in Java and the most commonly
used floating-point type in the standard library and application code.

Notes:
- double provides more precision than float.
- Decimal literals are double by default.
- double should not be used for precise decimal calculations (e.g. money).
*/
void main() {
    /*
    Declaring a double variable
    Syntax: double <name> = <value>;
    Output: 3.14
    */
    double x1 = 3.14;
    IO.println("x1 = " + x1);

    /*
    Double precision
    Double values are approximate and may suffer from precision loss.
    Output: 0.30000000000000004 (approximate)
    */
    double x2 = 0.1 + 0.2;
    IO.println("0.1 + 0.2 = " + x2);

    /*
    Double arithmetic
    All standard arithmetic operations are supported.
    */
    double a = 10.0, b = 3.0;
    double sum = a + b;  // Sum
    double diff = a - b; // Subtraction
    double prod = a * b; // Multiplication
    double div = a / b;  // Floating-point division
    double mod = a % b;  // Remainder of the division
    IO.println(sum);     // 13.0
    IO.println(diff);    // 7.0
    IO.println(prod);    // 30.0
    IO.println(div);     // 3.3333333
    IO.println(mod);     // 1.0

    /*
    Mixing int and double
    When one operand is double, the result is promoted to double.
    Output: 8.14
    */
    int i = 5;
    double mixed = i + x1;
    IO.println(mixed);

    /*
    Double limits
    Use MIN_VALUE and MAX_VALUE to check the boundaries.
    Output: min: 4.9E-324 max: 1.7976931348623157E308
    */
    double min = Double.MIN_VALUE;
    double max = Double.MAX_VALUE;
    IO.println("min: " + min + " max: " + max);

    /*
    Special double values
    In Java, double (and float) follow the IEEE 754 standard.
    This defines special values to handle unusual arithmetic without throwing exceptions.
    */
    double positiveInfinity = Double.POSITIVE_INFINITY;
    double negativeInfinity = Double.NEGATIVE_INFINITY;
    double notANumber = Double.NaN;
    IO.println(positiveInfinity); // Infinity
    IO.println(negativeInfinity); // -Infinity
    IO.println(notANumber);       // NaN
}