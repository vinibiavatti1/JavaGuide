/*
The Float type is a wrapper (reference) type in Java.
It represents a 32-bit floating-point object, capable of storing decimal values
with single-precision, following the IEEE 754 standard.

Unlike the primitive float, Float is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Float when an object representation is required (e.g. List<Float>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseFloat(), and compare().
- Autoboxing allows transparent conversion between float and Float.
- Be aware of precision limitations, as not all decimal values can be exactly represented.
- Additional memory and performance overhead exists compared to primitive float.
*/
@SuppressWarnings("all")
void main() {
    //==================================================================================================================
    // Float Instance
    //==================================================================================================================

    /*
    Declaring
    To declare an instance of this wrapper data type, we can use the "valueOf" function.
    Output: 3.14
    */
    Float w = Float.valueOf(3.14F);
    IO.println(w);

    /*
    Value
    Returns the value of this Float as the specified data type.
    */
    w = Float.valueOf(3.14F);
    byte y1 = w.byteValue();
    short y2 = w.shortValue();
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
    Float w1 = Float.valueOf(3.14F);
    Float w2 = Float.valueOf(3.14F);
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Is Infinite
    Returns true if this Float value is infinitely large in magnitude, false otherwise.
    Output: true
    */
    w = Float.valueOf(Float.POSITIVE_INFINITY);
    boolean is = w.isInfinite();
    IO.println(is);

    /*
    Is NaN
    Returns true if this Float value is a Not-a-Number (NaN), false otherwise.
    Output: true
    */
    w = Float.valueOf(Float.NaN);
    is = w.isNaN();
    IO.println(is);

    /*
    Compare To
    Compares two Float objects numerically.
    Output: 0 (equal)
    */
    w1 = Float.valueOf(3.14F);
    w2 = Float.valueOf(3.14F);
    int cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 1078523331
    */
    w = Float.valueOf(3.14F);
    int i = w.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified float.
    Output: 3.14
    */
    w = Float.valueOf(3.14F);
    String str = w.toString();
    IO.println(str);

    //==================================================================================================================
    // Float Class
    //==================================================================================================================

    /*
    Fields
    The fields below are available in the wrapper class.
    */
    IO.println(Float.MIN_VALUE);         // 1.4E-45f
    IO.println(Float.MIN_EXPONENT);      // -126
    IO.println(Float.MIN_NORMAL);        // 1.1754944E-38f
    IO.println(Float.MAX_VALUE);         // 3.4028235E38f
    IO.println(Float.MAX_EXPONENT);      // 127
    IO.println(Float.NaN);               // NaN (0.0f / 0.0)
    IO.println(Float.NEGATIVE_INFINITY); // -Infinity (-1.0f / 0.0)
    IO.println(Float.POSITIVE_INFINITY); // Infinity (1.0f / 0.0)
    IO.println(Float.PRECISION);         // 24
    IO.println(Float.BYTES);             // 4
    IO.println(Float.SIZE);              // 32
    IO.println(Float.TYPE);              // float

    /*
    Value Of
    Returns a Float object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    w = Float.valueOf("3.14");
    IO.println(w); // 3.14

    /*
    Parse Int
    Parses the string argument as a signed decimal float.
    We can determine the base of the number using the radix parameter.
    */
    float f = Float.parseFloat("3.14");
    IO.println(f); // 3.14

    /*
    Compare
    Compares two float values numerically.
    Output: 0 (equal)
    */
    float f1 = 3.14F;
    float f2 = 3.14F;
    cmp = Float.compare(f1, f2);
    IO.println(cmp);

    /*
    Min
    Returns the smaller of two float values as if by calling Math.min.
    Output: 1.0
    */
    f = Float.min(1.0F, 2.0F);
    IO.println(f);

    /*
    Max
    Returns the greater of two float values as if by calling Math.max.
    Output: 2.0
    */
    f = Float.max(1.0F, 2.0F);
    IO.println(f);

    /*
    Sum
    Adds two floats together as per the + operator.
    Output: 3.0
    */
    f = Float.sum(1.0F, 2.0F);
    IO.println(f);

    /*
    Is Finite
    Returns true if the argument is a finite floating-point value; returns false otherwise (for NaN and infinity
    arguments).
    Output: true
    */
    is = Float.isFinite(3.14F);
    IO.println(is);

    /*
    Is Infinite
    Returns true if the specified number is infinitely large in magnitude, false otherwise.
    Output: true
    */
    is = Float.isInfinite(Float.POSITIVE_INFINITY);
    IO.println(is);

    /*
    Is NaN
    Returns true if the specified number is a Not-a-Number (NaN) value, false otherwise.
    Output: true
    */
    is = Float.isNaN(Float.NaN);
    IO.println(is);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 1078523331
    */
    i = Float.hashCode(3.14F);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified int.
    Output: 3.14
    */
    str = Float.toString(3.14F);
    IO.println(str);

    //==================================================================================================================
    // Float Class (Advanced Operations)
    //==================================================================================================================

    /*
    Float to Int Bits
    Returns a representation of the specified floating-point value according to the IEEE 754 floating-point
    "single format" bit layout.
    Output: 1078523331
    */
    i = Float.floatToIntBits(3.14F);
    IO.println(i);

    /*
    Float to Raw Int Bits
    Returns a representation of the specified floating-point value according to the IEEE 754 floating-point
    "single format" bit layout, preserving Not-a-Number (NaN) values.
    Output: 1078523331
    */
    i = Float.floatToRawIntBits(3.14F);
    IO.println(i);

    /*
    Int Bits to Float
    Returns the float value corresponding to a given bit representation.
    Output: 3.14
    */
    f = Float.intBitsToFloat(1078523331);
    IO.println(f);

    /*
    Float to Float16
    Returns the floating-point binary16 value, encoded in a short, closest in value to the argument.
    Output: 16968
    */
    short f16 = Float.floatToFloat16(3.14F);
    IO.println(f16);

    /*
    Float16 to Float
    Returns the float value closest to the numerical value of the argument, a floating-point binary16 value encoded in
    a short.
    Output: 3.140625
    */
    f = Float.float16ToFloat((short)16968);
    IO.println(f);

    //==================================================================================================================
    // Float Class (String Representations)
    //==================================================================================================================

    /*
    To Hex String
    Returns a string representation of the Float argument as an unsigned Float in base 16.
    Output: 0x1.6p2
    */
    String s = Float.toHexString(5.5F);
    IO.println(s);
}