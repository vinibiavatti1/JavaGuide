/*
The Byte type is a wrapper (reference) type in Java.
It represents an 8-bit signed integer object, with values ranging from -128 to 127.

Unlike the primitive byte, Byte is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Byte when an object representation is required (e.g. List<Byte>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseByte(), and compare().
- Autoboxing allows transparent conversion between byte and Byte.
- Be aware of additional memory and performance overhead compared to primitive byte.
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
    IO.println(Byte.MIN_VALUE); // -128
    IO.println(Byte.MAX_VALUE); // 127
    IO.println(Byte.BYTES);     // 1
    IO.println(Byte.SIZE);      // 8
    IO.println(Byte.TYPE);      // byte

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /*
    Value Of
    Returns a Byte object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    Byte w1 = Byte.valueOf((byte)2);
    Byte w2 = Byte.valueOf("10");
    Byte w3 = Byte.valueOf("f", 16);
    IO.println(w1); // 2
    IO.println(w2); // 10
    IO.println(w3); // 15

    /*
    Parse Byte
    Parses the string argument as a signed decimal byte.
    We can determine the base of the number using the radix parameter.
    */
    byte b1 = Byte.parseByte("10");
    byte b2 = Byte.parseByte("f", 16);
    IO.println(b1); // 10
    IO.println(b2); // 15

    /*
    Decode
    Decodes a String into a Byte. Accepts decimal, hexadecimal, and octal.
    Output: 15
    */
    w1 = Byte.decode("0xf");
    IO.println(w1);

    /*
    Compare
    Compares two byte values numerically.
    Output: 0 (equal)
    */
    b1 = 5;
    b2 = 5;
    int cmp = Byte.compare(b1, b2);
    IO.println(cmp);

    /*
    Compare Unsigned
    Compares two byte values numerically treating the values as unsigned.
    Output: 254 (x1 > x2)
    */
    b1 = -1; // 255 (unsigned)
    b2 = 1;  // 1   (unsigned)
    cmp = Byte.compareUnsigned(b1, b2);
    IO.println(cmp);

    /*
    To Unsigned Int
    Converts the argument to an int by an unsigned conversion.
    Output: 255
    */
    int i = Byte.toUnsignedInt((byte)-1);
    IO.println(i);

    /*
    To Unsigned Long
    Converts the argument to an int by an unsigned conversion.
    Output: 255
    */
    long l = Byte.toUnsignedLong((byte)-1);
    IO.println(l);

    /*
    Hash Code
    Returns a hash code for a byte value;
    Output: 5
    */
    i = Byte.hashCode((byte)5);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified byte.
    Output: 5
    */
    String str = Byte.toString((byte)5);
    IO.println(str);

    //==================================================================================================================
    // Instance Methods
    //==================================================================================================================

    /*
    Value
    Returns the value of this Byte as a byte.
    Output: 5
    */
    Byte w = Byte.valueOf("5");
    byte y1 = w.byteValue();
    short y2 = w.shortValue();
    int y3 = w.intValue();
    long y4 = w.longValue();
    float y5 = w.floatValue();
    double y6 = w.doubleValue();
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
    w1 = Byte.valueOf("5");
    w2 = Byte.valueOf("5");
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Compare To
    Compares two Byte objects numerically.
    Output: 0 (equal)
    */
    w1 = Byte.valueOf("5");
    w2 = Byte.valueOf("5");
    cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a byte value;
    Output: 5
    */
    w = Byte.valueOf("5");
    i = w.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified byte.
    Output: 5
    */
    w = Byte.valueOf("5");
    str = w.toString();
    IO.println(str);
}