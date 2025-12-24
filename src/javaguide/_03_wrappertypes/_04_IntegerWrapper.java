/*
The Integer type is a wrapper (reference) type in Java.
It represents a 32-bit signed integer object, with values ranging from -2,147,483,648 to 2,147,483,647.

Unlike the primitive int, Integer is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Integer when an object representation is required (e.g. List<Integer>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseInt(), and compare().
- Autoboxing allows transparent conversion between int and Integer.
- Be aware of additional memory and performance overhead compared to primitive int.
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
    IO.println(Integer.MIN_VALUE); // -2147483648
    IO.println(Integer.MAX_VALUE); // 2147483647
    IO.println(Integer.BYTES);     // 4
    IO.println(Integer.SIZE);      // 32
    IO.println(Integer.TYPE);      // int

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /*
    Value Of
    Returns a Integer object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    Integer w1 = Integer.valueOf(2);
    Integer w2 = Integer.valueOf("10");
    Integer w3 = Integer.valueOf("f", 16);
    IO.println(w1); // 2
    IO.println(w2); // 10
    IO.println(w3); // 15

    /*
    Parse Int
    Parses the string argument as a signed decimal int.
    We can determine the base of the number using the radix parameter.
    */
    int i1 = Integer.parseInt("10");
    int i2 = Integer.parseInt("f", 16);
    IO.println(i1); // 10
    IO.println(i2); // 15

    /*
    Parse Unsigned Int
    Parses the string argument as an unsigned integer.
    */
    i1 = Integer.parseUnsignedInt("10");
    i2 = Integer.parseUnsignedInt("f", 16);
    IO.println(i1); // 10
    IO.println(i2); // 15

    /*
    Decode
    Decodes a String into a Integer. Accepts decimal, hexadecimal, and octal.
    Output: 15
    */
    w1 = Integer.decode("0xf");
    IO.println(w1);

    /*
    Reverse
    Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the
    specified int value.
    Output: -2147483648
    */
    i1 = Integer.reverse(1);
    IO.println(i1);

    /*
    Reverse Bytes
    Returns the value obtained by reversing the order of the bytes in the two's complement representation of the
    specified int value.
    Output: 256
    */
    i1 = Integer.reverseBytes(1);
    IO.println(i1);

    /*
    Compare
    Compares two int values numerically.
    Output: 0 (equal)
    */
    i1 = 5;
    i2 = 5;
    int cmp = Integer.compare(i1, i2);
    IO.println(cmp);

    /*
    Compare Unsigned
    Compares two int values numerically treating the values as unsigned.
    Output: 254 (x1 > x2)
    */
    i1 = -1; // 255 (unsigned)
    i2 = 1;  // 1   (unsigned)
    cmp = Integer.compareUnsigned(i1, i2);
    IO.println(cmp);

    /*
    To Unsigned String
    Returns a string representation of the argument as an unsigned decimal value.
    Output: 4294967295
    */
    String str = Integer.toUnsignedString(-1);
    IO.println(str);

    /*
    To Unsigned Long
    Converts the argument to an int by an unsigned conversion.
    Output: 4294967295
    */
    long l = Integer.toUnsignedLong(-1);
    IO.println(l);

    /*
    Bit Count
    Returns the number of one-bits in the two's complement binary representation of the specified int value.
    Output: 8 (255 = 11111111)
    */
    int i = Integer.bitCount(255);
    IO.println(i);

    /*
    Compress
    Returns the value obtained by compressing the bits of the specified int value, i, in accordance with the specified
    bit mask.
    It can be used to extract selected bits from a binary value and pack them into a compact form in low-level
    programming.
    I.e: Extract all bits set by the mask.
      1010 (10)
    & 0110 (6 - mask)
    = _01_ (1)
    Output: 1
    */
    i = Integer.compress(10, 6);
    IO.println(i);

    /*
    Divide Unsigned
    */
    // Integer.divideUnsigned();

    /*
    Expand
    */

    /*
    Get Integer
    */

    /*
    Highest One Bit
    */

    /*
    Lowest One Bit
    */

    /*
    Max
    */

    /*
    Min
    */

    /*
    Number Of Leading Zeros
    */

    /*
    Number of Trailing Zeros
    */

    /*
    Remainder Unsigned
    */

    /*
    Rotate Left
    */

    /*
    Rotate Right
    */

    /*
    Signum
    */

    /*
    To Binary String
    */

    /*
    To Hex String
    */

    /*
    To Octal String
    */

    /*
    Compress
    */

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 5
    */
    i = Integer.hashCode(5);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified int.
    Output: 5
    */
    str = Integer.toString(5);
    IO.println(str);

    //==================================================================================================================
    // Instance Methods
    //==================================================================================================================

    /*
    Value
    Returns the value of this Integer as a int.
    Output: 5
    */
    Integer x = Integer.valueOf("5");
    byte y1 = x.byteValue();
    int y2 = x.intValue();
    int y3 = x.intValue();
    long y4 = x.longValue();
    float y5 = x.floatValue();
    double y6 = x.doubleValue();
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
    w1 = Integer.valueOf("5");
    w2 = Integer.valueOf("5");
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Compare To
    Compares two Integer objects numerically.
    Output: 0 (equal)
    */
    w1 = Integer.valueOf("5");
    w2 = Integer.valueOf("5");
    cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 5
    */
    x = Integer.valueOf("5");
    i = x.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified int.
    Output: 5
    */
    x = Integer.valueOf("5");
    str = x.toString();
    IO.println(str);
}