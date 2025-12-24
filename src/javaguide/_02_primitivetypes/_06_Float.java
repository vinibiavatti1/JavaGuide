/*
The float type is a primitive data type in Java.
It is a 32-bit floating-point number that follows the IEEE 754 standard.

Float is mainly used when memory usage is a concern or when working with
large collections of decimal numbers where double precision is not required.

Notes:
- float has less precision than double.
- float literals must use the suffix 'f' or 'F'.
- Most Java APIs use double by default for decimal values.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaring a float variable
    Syntax: float <name> = <value>;
    Output: 3.14
    */
    float x1 = 3.14f;
    IO.println(x1);

    /*
    Float precision
    Float values are approximate and may suffer from precision loss.
    Output: 0.30000001 (approximate)
    */
    float x2 = 0.1f + 0.2f;
    IO.println(x2);

    /*
    Float arithmetic
    All standard arithmetic operations are supported.
    */
    float a = 10.0f, b = 3.0f;
    float sum = a + b;  // Sum
    float diff = a - b; // Subtraction
    float prod = a * b; // Multiplication
    float div = a / b;  // Floating-point division
    float mod = a % b;  // Remainder of the division
    IO.println(sum);    // 13.0
    IO.println(diff);   // 7.0
    IO.println(prod);   // 30.0
    IO.println(div);    // 3.3333333
    IO.println(mod);    // 1.0

    /*
    Mixing float and double
    When a float interacts with a double, the result is promoted to double.
    Output: 4.14
    */
    double mixed = x1 + 1.0;
    IO.println(mixed);

    /*
    Float limits
    Use MIN_VALUE and MAX_VALUE to check the boundaries.
    Output: min: 1.4E-45 max: 3.4028235E38
    */
    float min = Float.MIN_VALUE;
    float max = Float.MAX_VALUE;
    IO.println("min: " + min + " max: " + max);

    /*
    Special float values
    In Java, float (and double) follow the IEEE 754 standard.
    This defines special values to handle unusual arithmetic without throwing exceptions.
    */
    float positiveInfinity = Float.POSITIVE_INFINITY;
    float negativeInfinity = Float.NEGATIVE_INFINITY;
    float notANumber = Float.NaN;
    IO.println(positiveInfinity); // Infinity
    IO.println(negativeInfinity); // -Infinity
    IO.println(notANumber);       // NaN
}