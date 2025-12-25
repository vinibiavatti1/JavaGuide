/*
The Long type is a wrapper (reference) type in Java.
It represents a 64-bit signed integer object, with values ranging from
-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.

Unlike the primitive long, Long is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Long when an object representation is required (e.g. List<Long>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseLong(), and compare().
- Autoboxing allows transparent conversion between long and Long.
- Be aware of additional memory and performance overhead compared to primitive long.
*/
@SuppressWarnings("all")
void main() {
    //==================================================================================================================
    // Long Instance
    //==================================================================================================================

    /*
    Declaring
    To declare an instance of this wrapper data type, we can use the "valueOf" function.
    Output: 5
    */
    Long w = Long.valueOf(5L);
    IO.println(w);

    /*
    Value
    Returns the value of this Long as the specified data type.
    Output: 5
    */
    w = Long.valueOf(5L);
    byte y1 = w.byteValue();
    int y2 = w.intValue();
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
    Long w1 = Long.valueOf(5L);
    Long w2 = Long.valueOf(5L);
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Compare To
    Compares two Long objects numerically.
    Output: 0 (equal)
    */
    w1 = Long.valueOf(5L);
    w2 = Long.valueOf(5L);
    int cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a long value;
    Output: 5
    */
    w = Long.valueOf(5L);
    int i = w.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified long.
    Output: 5
    */
    w = Long.valueOf(5L);
    String str = w.toString();
    IO.println(str);

    //==================================================================================================================
    // Long Class
    //==================================================================================================================

    /*
    Fields
    The fields below are available in the wrapper class.
    */
    IO.println(Long.MIN_VALUE); // -9223372036854775808L
    IO.println(Long.MAX_VALUE); // 9223372036854775807L
    IO.println(Long.BYTES);     // 8
    IO.println(Long.SIZE);      // 64
    IO.println(Long.TYPE);      // long

    /*
    Value Of
    Returns a Long object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    w1 = Long.valueOf("10");
    w2 = Long.valueOf("f", 16);
    IO.println(w1); // 10
    IO.println(w2); // 15

    /*
    Parse Long
    Parses the string argument as a signed decimal long.
    We can determine the base of the number using the radix parameter.
    */
    long l1 = Long.parseLong("10");
    long l2 = Long.parseLong("f", 16);
    IO.println(l1); // 10
    IO.println(l2); // 15

    /*
    Compare
    Compares two long values numerically.
    Output: 0 (equal)
    */
    l1 = 5;
    l2 = 5;
    cmp = Long.compare(l1, l2);
    IO.println(cmp);

    /*
    Max
    Returns the greater of two long values as if by calling Math.max.
    Output: 2
    */
    long l = Long.max(1, 2);
    IO.println(l);

    /*
    Min
    Returns the smaller of two long values as if by calling Math.min.
    Output: 1
    */
    l = Long.min(1, 2);
    IO.println(i);

    /*
    Signum
    Returns the signum function of the specified long value.
    I.e. Returns:
     -1: if number is negative
      0: if number is zero
      1: if number is positive
    Output:
    */
    i = Long.signum(0);
    l1 = Long.signum(-40);
    l2 = Long.signum(40);
    IO.println(i);  //  0
    IO.println(l1); // -1
    IO.println(l2); //  1

    /*
    Hash Code
    Returns a hash code for a long value;
    Output: 5
    */
    i = Long.hashCode(5);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified long.
    Output: 5
    */
    str = Long.toString(5);
    IO.println(str);

    //==================================================================================================================
    // Long Class (Advanced Operations)
    //==================================================================================================================

    /*
    Parse Unsigned Long
    Parses the string argument as an unsigned long.
    */
    l1 = Long.parseUnsignedLong("10");
    l2 = Long.parseUnsignedLong("f", 16);
    IO.println(l1); // 10
    IO.println(l2); // 15

    /*
    Decode
    Decodes a String into a Long. Accepts decimal, hexadecimal, and octal.
    Output: 15
    */
    w1 = Long.decode("0xf");
    IO.println(w1);

    /*
    Reverse
    Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the
    specified long value.
    Output: -2147483648
    */
    l1 = Long.reverse(1L);
    IO.println(l1);

    /*
    Compare Unsigned
    Compares two long values numerically treating the values as unsigned.
    Output: 254 (x1 > x2)
    */
    l1 = -1L; // 255 (unsigned)
    l2 = 1L;  // 1   (unsigned)
    cmp = Long.compareUnsigned(l1, l2);
    IO.println(cmp);

    /*
    To Unsigned String
    Returns a string representation of the argument as an unsigned decimal value.
    Output: 4294967295
    */
    str = Long.toUnsignedString(-1L);
    IO.println(str);

    /*
    Divide Unsigned
    Returns the unsigned quotient of dividing the first argument by the second where each argument and the result is
    interpreted as an unsigned value.
    Output: 2147483647
    */
    l = Long.divideUnsigned(-1L, 2L); // 4294967295 / 2
    IO.println(l);

    /*
    Remainder Unsigned
    Returns the unsigned remainder from dividing the first argument by the second where each argument and the result is
    interpreted as an unsigned value.
    Output: 1
    */
    l = Long.remainderUnsigned(-1, 2); // 4294967295 / 2
    IO.println(l);

    /*
    Get Long
    Determines the long value of the system property with the specified name.
    Shortcut for: System.getProperty(...) + Long parsing
    Output: 30
    */
    System.setProperty("app.timeout", "30");
    l = Long.getLong("app.timeout");
    IO.println(l);

    //==================================================================================================================
    // Long Class (Binary Operations)
    //==================================================================================================================

    /*
    Bit Count
    Returns the number of one-bits in the two's complement binary representation of the specified long value.
    Output: 8 (255 = 11111111)
    */
    i = Long.bitCount(255);
    IO.println(i);

    /*
    Reverse Bytes
    Returns the value obtained by reversing the order of the bytes in the two's complement representation of the
    specified int value.
    Output: 256
    */
    l1 = Long.reverseBytes(1);
    IO.println(l1);

    /*
    Compress
    Returns the value obtained by compressing the bits of the specified long value, i, in accordance with the specified
    bit mask.
    It can be used to extract selected bits from a binary value and pack them into a compact form in low-level
    programming.
      1010 (10)
    & 0110 (6 - mask)
    = _01_ (1)
    Output: 1
    */
    l = Long.compress(10, 6);
    IO.println(l);

    /*
    Expand
    Returns the value obtained by expanding the bits of the specified long value, i, in accordance with the specified bit
    mask.
    I.e. Replicates the value bits to the mask positions set as 1.
      0010 (2)
    & 1100 (12 - mask)
    = 1000 (8)
    Output: 8
    */
    l = Long.expand(2, 12);
    IO.println(l);

    /*
    Highest One Bit
    Returns an long value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in
    the specified long value.
    Value: 01010 (10)
    Selec:  ^
    Output: 8
    */
    l = Long.highestOneBit(10);
    IO.println(i);

    /*
    Lowest One Bit
    Returns an long value with at most a single one-bit, in the position of the lowest-order ("rightmost") one-bit in
    the specified long value.
    Value: 01010 (10)
    Selec:    ^
    Output: 2
    */
    l = Long.lowestOneBit(10);
    IO.println(i);

    /*
    Number Of Leading Zeros
    Returns the number of zero bits preceding the highest-order ("leftmost") one-bit in the two's complement binary
    representation of the specified long value.
    Value: 00000000-00000000...00000000-00010100 (20)
    Selec: ^^^^^^^^ ^^^^^^^^   ^^^^^^^^ ^^^
    Output: 59
    */
    i = Long.numberOfLeadingZeros(20L);
    IO.println(i);

    /*
    Number of Trailing Zeros
    Returns the number of zero bits following the lowest-order ("rightmost") one-bit in the two's complement binary
    representation of the specified long value.
    Value: 00000000-00000000...00000000-00010100 (20)
    Selec:                                    ^^
    Output: 2
    */
    i = Long.numberOfTrailingZeros(20L);
    IO.println(i);

    /*
    Rotate Left
    Returns the value obtained by rotating the two's complement binary representation of the specified long value left
    by the specified number of bits.
    Unlike a left shift (<<), which discards the bits shifted out of range, rotateLeft performs a circular shift,
    reinserting the overflowed bits back into the lower positions.
      001100 (12)
    < 110000 (48)
    Output: 48
    */
    l = Long.rotateLeft(12L, 2);
    IO.println(i);

    /*
    Rotate Right
    Returns the value obtained by rotating the two's complement binary representation of the specified long value right
    by the specified number of bits.
    Unlike a right shift (>>), which discards the bits shifted out of range, rotateLeft performs a circular shift,
    reinserting the overflowed bits back into the lower positions.
      001100 (12)
    > 000011 (3)
    Output: 3
    */
    l = Long.rotateRight(12L, 2);
    IO.println(i);

    /*
    To Binary String
    Returns a string representation of the long argument as an unsigned long in base 2.
    Output: 10101
    */
    String s = Long.toBinaryString(21L);
    IO.println(s);

    /*
    To Octal String
    Returns a string representation of the long argument as an unsigned long in base 8.
    Output: 10
    */
    s = Long.toOctalString(8L);
    IO.println(s);

    /*
    To Hex String
    Returns a string representation of the long argument as an unsigned long in base 16.
    Output: ff
    */
    s = Long.toHexString(255L);
    IO.println(s);
}