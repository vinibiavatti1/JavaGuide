/*
The Double type is a wrapper (reference) type in Java.
It represents a 64-bit floating-point object, capable of storing decimal values
with double-precision, following the IEEE 754 standard. Its range is approximately
from -1.7976931348623157e308 to 1.7976931348623157e308.

Unlike the primitive double, Double is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Double when an object representation is required (e.g. List<Double>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseDouble(), and compare().
- Autoboxing allows transparent conversion between double and Double.
- Be aware of precision limitations, as not all decimal values can be exactly represented.
- Additional memory and performance overhead exists compared to primitive double.
*/
@SuppressWarnings("all")
void main() {
    //==================================================================================================================
    // Double Instance
    //==================================================================================================================

    /*
    Declaring
    To declare an instance of this wrapper data type, we can use the "valueOf" function.
    Output: 3.14
    */
    Double w = Double.valueOf(3.14);
    IO.println(w);

    /*
    Value
    Returns the value of this Double as the specified data type.
    */
    w = Double.valueOf(3.14);
    byte y1 = w.byteValue();
    int y2 = w.intValue();
    int y3 = w.intValue();
    long y4 = w.longValue();
    float y5 = w.floatValue();
    double y6 = w.doubleValue();
    IO.println(y1); // 3
    IO.println(y2); // 3
    IO.println(y3); // 3
    IO.println(y4); // 3
    IO.println(y5); // 3.14
    IO.println(y6); // 3.14

    /*
    Equals
    Compares this object to the specified object.
    NOTE: Wrapper types should be compared using the equals() method rather than the '==' operator.
    Output: true
    */
    Double w1 = Double.valueOf(3.14);
    Double w2 = Double.valueOf(3.14);
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Is Infinite
    Returns true if this Double value is infinitely large in magnitude, false otherwise.
    Output: true
    */
    w = Double.valueOf(Double.POSITIVE_INFINITY);
    boolean is = w.isInfinite();
    IO.println(is);

    /*
    Is NaN
    Returns true if this Double value is a Not-a-Number (NaN), false otherwise.
    Output: true
    */
    w = Double.valueOf(Double.NaN);
    is = w.isNaN();
    IO.println(is);

    /*
    Compare To
    Compares two Double objects numerically.
    Output: 0 (equal)
    */
    w1 = Double.valueOf(3.14);
    w2 = Double.valueOf(3.14);
    int cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 1078523331
    */
    w = Double.valueOf(3.14);
    int i = w.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified double.
    Output: 3.14
    */
    w = Double.valueOf(3.14);
    String str = w.toString();
    IO.println(str);

    //==================================================================================================================
    // Double Class
    //==================================================================================================================

    /*
    Fields
    The fields below are available in the wrapper class.
    */
    IO.println(Double.MIN_VALUE);         // 4.9E-324
    IO.println(Double.MIN_EXPONENT);      // -1022
    IO.println(Double.MIN_NORMAL);        // 2.2250738585072014E-308
    IO.println(Double.MAX_VALUE);         // 1.7976931348623157E308
    IO.println(Double.MAX_EXPONENT);      // 1023
    IO.println(Double.NaN);               // NaN (0.0d / 0.0)
    IO.println(Double.NEGATIVE_INFINITY); // -Infinity (-1.0 / 0.0)
    IO.println(Double.POSITIVE_INFINITY); // Infinity (1.0 / 0.0)
    IO.println(Double.PRECISION);         // 53
    IO.println(Double.BYTES);             // 8
    IO.println(Double.SIZE);              // 64
    IO.println(Double.TYPE);              // double

    /*
    Value Of
    Returns a Double object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    w = Double.valueOf("3.14");
    IO.println(w); // 3.14

    /*
    Parse Int
    Parses the string argument as a signed decimal double.
    We can determine the base of the number using the radix parameter.
    */
    double d = Double.parseDouble("3.14");
    IO.println(d); // 3.14

    /*
    Compare
    Compares two double values numerically.
    Output: 0 (equal)
    */
    double d1 = 3.14;
    double d2 = 3.14;
    cmp = Double.compare(d1, d2);
    IO.println(cmp);

    /*
    Min
    Returns the smaller of two double values as if by calling Math.min.
    Output: 1.0
    */
    d = Double.min(1.0, 2.0);
    IO.println(d);

    /*
    Max
    Returns the greater of two double values as if by calling Math.max.
    Output: 2.0
    */
    d = Double.max(1.0, 2.0);
    IO.println(d);

    /*
    Sum
    Adds two Doubles together as per the + operator.
    Output: 3.0
    */
    d = Double.sum(1.0, 2.0);
    IO.println(d);

    /*
    Is Finite
    Returns true if the argument is a finite floating-point value; returns false otherwise (for NaN and infinity
    arguments).
    Output: true
    */
    is = Double.isFinite(3.14);
    IO.println(is);

    /*
    Is Infinite
    Returns true if the specified number is infinitely large in magnitude, false otherwise.
    Output: true
    */
    is = Double.isInfinite(Double.POSITIVE_INFINITY);
    IO.println(is);

    /*
    Is NaN
    Returns true if the specified number is a Not-a-Number (NaN) value, false otherwise.
    Output: true
    */
    is = Double.isNaN(Double.NaN);
    IO.println(is);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 300063655
    */
    i = Double.hashCode(3.14);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified int.
    Output: 3.14
    */
    str = Double.toString(3.14);
    IO.println(str);

    //==================================================================================================================
    // Double Class (Advanced Operations)
    //==================================================================================================================

    /*
    Double to Int Bits
    Returns a representation of the specified floating-point value according to the IEEE 754 floating-point
    "single format" bit layout.
    Output: 4614253070214989087
    */
    long l = Double.doubleToLongBits(3.14);
    IO.println(l);

    /*
    Double to Raw Int Bits
    Returns a representation of the specified floating-point value according to the IEEE 754 floating-point
    "single format" bit layout, preserving Not-a-Number (NaN) values.
    Output: 4614253070214989087
    */
    l = Double.doubleToRawLongBits(3.14);
    IO.println(l);

    /*
    Int Bits to Double
    Returns the double value corresponding to a given bit representation.
    Output: 3.14
    */
    d = Double.longBitsToDouble(4614253070214989087L);
    IO.println(d);

    //==================================================================================================================
    // Double Class (String Representations)
    //==================================================================================================================

    /*
    To Hex String
    Returns a string representation of the Double argument as an unsigned Double in base 16.
    Output: 0x1.6p2
    */
    String s = Double.toHexString(5.5F);
    IO.println(s);
}