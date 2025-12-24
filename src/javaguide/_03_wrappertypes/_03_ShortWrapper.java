/*
The Short type is a wrapper (reference) type in Java.
It represents an 16-bit signed integer object, with values ranging from -32,768 to 32,767.

Unlike the primitive short, Short is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Short when an object representation is required (e.g. List<Short>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseShort(), and compare().
- Autoboxing allows transparent conversion between short and Short.
- Be aware of additional memory and performance overhead compared to primitive short.
*/
@SuppressWarnings("all")
void main() {
    //==================================================================================================================
    // Fields
    //==================================================================================================================

    /*
    Fields
    The fields below are available in the wrapper class.
    */
    IO.println(Short.MIN_VALUE); // -32768
    IO.println(Short.MAX_VALUE); // 32767
    IO.println(Short.BYTES);     // 2
    IO.println(Short.SIZE);      // 16
    IO.println(Short.TYPE);      // short

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /*
    Value Of
    Returns a Short object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    Short w1 = Short.valueOf((short)2);
    Short w2 = Short.valueOf("10");
    Short w3 = Short.valueOf("f", 16);
    IO.println(w1); // 2
    IO.println(w2); // 10
    IO.println(w3); // 15

    /*
    Parse Short
    Parses the string argument as a signed decimal short.
    We can determine the base of the number using the radix parameter.
    */
    short s1 = Short.parseShort("10");
    short s2 = Short.parseShort("f", 16);
    IO.println(s1); // 10
    IO.println(s2); // 15

    /*
    Decode
    Decodes a String into a Short. Accepts decimal, hexadecimal, and octal.
    Output: 15
    */
    w1 = Short.decode("0xf");
    IO.println(w1);

    /*
    Reverse Bytes
    Returns the value obtained by reversing the order of the bytes in the two's complement representation of the
    specified short value.
    Output: 256
    */
    s1 = Short.reverseBytes((short)1);
    IO.println(s1);

    /*
    Compare
    Compares two short values numerically.
    Output: 0 (equal)
    */
    s1 = 5;
    s2 = 5;
    int cmp = Short.compare(s1, s2);
    IO.println(cmp);

    /*
    Compare Unsigned
    Compares two short values numerically treating the values as unsigned.
    Output: 65534 (x1 > x2)
    */
    s1 = -1; // 65535 (unsigned)
    s2 = 1;  // 1     (unsigned)
    cmp = Short.compareUnsigned(s1, s2);
    IO.println(cmp);

    /*
    To Unsigned Int
    Converts the argument to an int by an unsigned conversion.
    Output: 65535
    */
    int i = Short.toUnsignedInt((short)-1);
    IO.println(i);

    /*
    To Unsigned Long
    Converts the argument to an int by an unsigned conversion.
    Output: 65535
    */
    long l = Short.toUnsignedLong((short)-1);
    IO.println(l);

    /*
    Hash Code
    Returns a hash code for a short value;
    Output: 5
    */
    i = Short.hashCode((short)5);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified short.
    Output: 5
    */
    String str = Short.toString((short)5);
    IO.println(str);

    //==================================================================================================================
    // Instance Methods
    //==================================================================================================================

    /*
    Value
    Returns the value of this Short as a short.
    Output: 5
    */
    Short s = Short.valueOf("5");
    byte y1 = s.byteValue();
    short y2 = s.shortValue();
    int y3 = s.intValue();
    long y4 = s.longValue();
    float y5 = s.floatValue();
    double y6 = s.doubleValue();
    IO.println(y1); // 5
    IO.println(y2); // 5
    IO.println(y3); // 5
    IO.println(y4); // 5
    IO.println(y5); // 5.0
    IO.println(y6); // 5.0

    /*
    Equals
    Compares this object to the specified object.
    NOTE: Wrapper types should be compared using the equals() method rather than the '==' operator.
    Output: true
    */
    w1 = Short.valueOf("5");
    w2 = Short.valueOf("5");
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Compare To
    Compares two Short objects numerically.
    Output: 0 (equal)
    */
    w1 = Short.valueOf("5");
    w2 = Short.valueOf("5");
    cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a short value;
    Output: 5
    */
    s = Short.valueOf("5");
    i = s.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified short.
    Output: 5
    */
    s = Short.valueOf("5");
    str = s.toString();
    IO.println(str);
}