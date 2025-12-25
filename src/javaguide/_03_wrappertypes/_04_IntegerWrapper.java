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
    // Integer Instance
    //==================================================================================================================

    /*
    Declaring
    To declare an instance of this wrapper data type, we can use the "valueOf" function.
    Output: 5
    */
    Integer w = Integer.valueOf(5);
    IO.println(w);

    /*
    Value
    Returns the value of this Integer as the specified data type.
    */
    w = Integer.valueOf(5);
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
    Integer w1 = Integer.valueOf(5);
    Integer w2 = Integer.valueOf(5);
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Compare To
    Compares two Integer objects numerically.
    Output: 0 (equal)
    */
    w1 = Integer.valueOf(5);
    w2 = Integer.valueOf(5);
    int cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 5
    */
    w = Integer.valueOf(5);
    int i = w.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified int.
    Output: 5
    */
    w = Integer.valueOf(5);
    String str = w.toString();
    IO.println(str);

    //==================================================================================================================
    // Integer Class
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

    /*
    Value Of
    Returns a Integer object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    w1 = Integer.valueOf("10");
    w2 = Integer.valueOf("f", 16);
    IO.println(w1); // 10
    IO.println(w2); // 15

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
    Compare
    Compares two int values numerically.
    Output: 0 (equal)
    */
    i1 = 5;
    i2 = 5;
    cmp = Integer.compare(i1, i2);
    IO.println(cmp);

    /*
    Min
    Returns the smaller of two int values as if by calling Math.min.
    Output: 1
    */
    i = Integer.min(1, 2);
    IO.println(i);

    /*
    Max
    Returns the greater of two int values as if by calling Math.max.
    Output: 2
    */
    i = Integer.max(1, 2);
    IO.println(i);

    /*
    Sum
    Adds two integers together as per the + operator.
    Output: 3
    */
    i = Integer.sum(1, 2);
    IO.println(i);

    /*
    Signum
    Returns the signum function of the specified int value.
    I.e. Returns:
     -1: if number is negative
      0: if number is zero
      1: if number is positive
    Output:
    */
    i = Integer.signum(0);
    i1 = Integer.signum(-40);
    i2 = Integer.signum(40);
    IO.println(i);  //  0
    IO.println(i1); // -1
    IO.println(i2); //  1

    /*
    Get Integer
    Determines the integer value of the system property with the specified name.
    Shortcut for: System.getProperty(...) + Integer parsing
    Output: 30
    */
    System.setProperty("property", "30");
    i = Integer.getInteger("property");
    IO.println(i);

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
    // Integer Class (Advanced Operations)
    //==================================================================================================================

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
    str = Integer.toUnsignedString(-1);
    IO.println(str);

    /*
    To Unsigned Long
    Converts the argument to an int by an unsigned conversion.
    Output: 4294967295
    */
    long l = Integer.toUnsignedLong(-1);
    IO.println(l);

    /*
    Divide Unsigned
    Returns the unsigned quotient of dividing the first argument by the second where each argument and the result is
    interpreted as an unsigned value.
    Output: 2147483647
    */
    i = Integer.divideUnsigned(-1, 2); // 4294967295 / 2
    IO.println(i);

    /*
    Remainder Unsigned
    Returns the unsigned remainder from dividing the first argument by the second where each argument and the result is
    interpreted as an unsigned value.
    Output: 1
    */
    i = Integer.remainderUnsigned(-1, 2); // 4294967295 / 2
    IO.println(i);

    //==================================================================================================================
    // Integer Class (Binary Operations)
    //==================================================================================================================

    /*
    Bit Count
    Returns the number of one-bits in the two's complement binary representation of the specified int value.
    Output: 8 (255 = 11111111)
    */
    i = Integer.bitCount(255);
    IO.println(i);

    /*
    Reverse Bytes
    Returns the value obtained by reversing the order of the bytes in the two's complement representation of the
    specified int value.
    Output: 256
    */
    i1 = Integer.reverseBytes(1);
    IO.println(i1);

    /*
    Compress
    Returns the value obtained by compressing the bits of the specified int value, i, in accordance with the specified
    bit mask.
    It can be used to extract selected bits from a binary value and pack them into a compact form in low-level
    programming.
      1010 (10)
    & 0110 (6 - mask)
    = _01_ (1)
    Output: 1
    */
    i = Integer.compress(10, 6);
    IO.println(i);

    /*
    Expand
    Returns the value obtained by expanding the bits of the specified int value, i, in accordance with the specified bit
    mask.
    I.e. Replicates the value bits to the mask positions set as 1.
      0010 (2)
    & 1100 (12 - mask)
    = 1000 (8)
    Output: 8
    */
    i = Integer.expand(2, 12);
    IO.println(i);

    /*
    Highest One Bit
    Returns an int value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in the
    specified int value.
    Value: 01010 (10)
    Selec:  ^
    Output: 8
    */
    i = Integer.highestOneBit(10);
    IO.println(i);

    /*
    Lowest One Bit
    Returns an int value with at most a single one-bit, in the position of the lowest-order ("rightmost") one-bit in the
    specified int value.
    Value: 01010 (10)
    Selec:    ^
    Output: 2
    */
    i = Integer.lowestOneBit(10);
    IO.println(i);

    /*
    Number Of Leading Zeros
    Returns the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's complement binary
    representation of the specified int value.
    Value: 00000000-00000000-00000000-00010100 (20)
    Selec: ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^
    Output: 27
    */
    i = Integer.numberOfLeadingZeros(20);
    IO.println(i);

    /*
    Number of Trailing Zeros
    Returns the number of zero bits following the lowest-order ("rightmost") one-bit in the two's complement binary
    representation of the specified int value.
    Value: 00000000-00000000-00000000-00010100 (20)
    Selec:                                  ^^
    Output: 2
    */
    i = Integer.numberOfTrailingZeros(20);
    IO.println(i);

    /*
    Rotate Left
    Returns the value obtained by rotating the two's complement binary representation of the specified int value left by
    the specified number of bits.
    Unlike a left shift (<<), which discards the bits shifted out of range, rotateLeft performs a circular shift,
    reinserting the overflowed bits back into the lower positions.
      001100 (12)
    < 110000 (48)
    Output: 48
    */
    i = Integer.rotateLeft(12, 2);
    IO.println(i);

    /*
    Rotate Right
    Returns the value obtained by rotating the two's complement binary representation of the specified int value right
    by the specified number of bits.
    Unlike a right shift (>>), which discards the bits shifted out of range, rotateLeft performs a circular shift,
    reinserting the overflowed bits back into the lower positions.
      001100 (12)
    > 000011 (3)
    Output: 3
    */
    i = Integer.rotateRight(12, 2);
    IO.println(i);

    //==================================================================================================================
    // Integer Class (String Representations)
    //==================================================================================================================

    /*
    To Binary String
    Returns a string representation of the integer argument as an unsigned integer in base 2.
    Output: 10101
    */
    String s = Integer.toBinaryString(21);
    IO.println(s);

    /*
    To Octal String
    Returns a string representation of the integer argument as an unsigned integer in base 8.
    Output: 10
    */
    s = Integer.toOctalString(8);
    IO.println(s);

    /*
    To Hex String
    Returns a string representation of the integer argument as an unsigned integer in base 16.
    Output: ff
    */
    s = Integer.toHexString(255);
    IO.println(s);
}