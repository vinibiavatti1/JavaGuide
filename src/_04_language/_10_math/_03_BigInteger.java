/*
 * BigInteger
 * - This section explains the "BigInteger" class in Java, which provides arbitrary-precision integer arithmetic,
 *   allowing computations beyond the limits of primitive integral types such as int and long.
 *
 * Overview
 * - The "BigInteger" class is part of the java.math package.
 * - It represents immutable integers of arbitrary size, limited only by available memory.
 * - Introduced in Java 1.1 to support high-precision mathematical and cryptographic operations.
 * - Commonly used in financial systems, cryptography, scientific computing, and any domain requiring exact integers.
 *
 * Key Characteristics
 * - Immutable: all arithmetic operations return new BigInteger instances.
 * - Supports standard arithmetic operations (add, subtract, multiply, divide, remainder).
 * - Provides comparison, sign, bit-level, and number-theoretic operations.
 * - Supports conversion to and from primitive types, strings, and byte arrays.
 * - Internally uses two’s-complement representation and optimized algorithms for large numbers.
 *
 * Usage
 * - Use BigInteger when integer values may exceed the range of long.
 * - Prefer BigInteger.valueOf(long) when converting from primitive types.
 * - Use string-based constructors for precise, explicit numeric values.
 * - Ideal for exact integer arithmetic where overflow or precision loss is unacceptable.
 * - Frequently used in cryptographic algorithms, hashing, and large-scale numeric computations.
 */
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
     * BigInteger Declaration Using String
     * - The "BigInteger(String)" constructor creates a BigInteger from its decimal string representation.
     * - Useful when working with very large integer values that exceed the range of primitive types.
     * - The string must represent a valid integer value in base 10, with optional leading sign.
     * - This approach preserves the exact numeric value without precision loss.
     * - Output: 1234567891011121314151617181920
     */
    BigInteger bigInteger = new BigInteger("1234567891011121314151617181920");
    IO.println(bigInteger);

    /*
     * BigInteger Declaration Using long
     * - The "valueOf(long)" factory method creates a BigInteger from a primitive long value.
     * - This is the recommended and most efficient way to convert a long into a BigInteger.
     * - Internally, this method may reuse cached instances for commonly used values.
     * - Avoids unnecessary string parsing and improves performance.
     * - Output: 123456789
     */
    bigInteger = BigInteger.valueOf(123456789L);
    IO.println(bigInteger);

    //==================================================================================================================
    // Arithmetic Operations
    //==================================================================================================================

    /*
     * Addition
     * - The "add" method performs arbitrary-precision integer addition.
     * - Returns a new BigInteger containing the sum of the two values.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Suitable for exact integer arithmetic without overflow.
     * - Output: 15
     */
    BigInteger a = new BigInteger("10");
    BigInteger b = new BigInteger("5");
    IO.println(a.add(b));

    /*
     * Subtraction
     * - The "subtract" method performs arbitrary-precision integer subtraction.
     * - Returns a new BigInteger containing the difference between the two values.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Suitable for exact integer arithmetic without underflow.
     * - Output: 5
     */
    a = new BigInteger("10");
    b = new BigInteger("5");
    IO.println(a.subtract(b));

    /*
     * Multiplication
     * - The "multiply" method performs arbitrary-precision integer multiplication.
     * - Returns a new BigInteger containing the product of the two values.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Suitable for exact integer arithmetic without overflow.
     * - Output: 50
     */
    a = new BigInteger("10");
    b = new BigInteger("5");
    IO.println(a.multiply(b));

    /*
     * Division
     * - The "divide" method performs integer division with arbitrary precision.
     * - The result is truncated toward zero; any fractional part is discarded.
     * - Returns a new BigInteger containing the quotient of the division.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: 3
     */
    a = new BigInteger("10");
    b = new BigInteger("3");
    IO.println(a.divide(b));

    /*
     * Remainder
     * - The "remainder" method returns the remainder of an integer division.
     * - The result has the same sign as the dividend and satisfies: a = (a / b) * b + remainder.
     * - Returns a new BigInteger containing the remainder value.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: 1
     */
    a = new BigInteger("10");
    b = new BigInteger("3");
    IO.println(a.remainder(b));

    /*
     * Divide And Remainder
     * - The "divideAndRemainder" method performs integer division and remainder calculation in a single operation.
     * - Returns an array where index 0 is the quotient and index 1 is the remainder.
     * - More efficient than calling "divide" and "remainder" separately.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: 3 / 1
     */
    a = new BigInteger("10");
    b = new BigInteger("3");
    BigInteger[] result = a.divideAndRemainder(b);
    IO.println(result[0] + " / " + result[1]);

    //==================================================================================================================
    // Comparison
    //==================================================================================================================

    /*
     * Min
     * - The "min" method returns the smaller of two BigInteger values.
     * - Comparison is based on numeric value, not scale or representation.
     * - Useful for selecting the lowest value without explicit comparison logic.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: 3
     */
    a = new BigInteger("10");
    b = new BigInteger("3");
    IO.println(a.min(b));

    /*
     * Max
     * - The "max" method returns the larger of two BigInteger values.
     * - Comparison is based on numeric value, not scale or representation.
     * - Useful for selecting the highest value without explicit comparison logic.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: 10
     */
    a = new BigInteger("10");
    b = new BigInteger("3");
    IO.println(a.max(b));

    /*
     * Equals
     * - The "equals" method checks if two BigInteger instances represent the exact same numeric value.
     * - Returns true only if both value and scale match exactly.
     * - Useful for strict equality comparisons between BigInteger objects.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: true
     */
    a = new BigInteger("5");
    b = new BigInteger("5");
    IO.println(a.equals(b));

    /*
     * Compare To
     * - The "compareTo" method compares two BigInteger values numerically.
     * - Returns -1 if the first is less, 0 if equal, and 1 if greater than the second.
     * - Useful for sorting, ordering, or conditional logic based on numeric value.
     * - BigInteger instances are immutable; the original operands remain unchanged.
     * - Output: 0 (equal)
     */
    a = new BigInteger("5");
    b = new BigInteger("5");
    IO.println(a.compareTo(b));

    /*
     * HashCode
     * - The "hashCode" method returns an integer hash code for the BigInteger value.
     * - Useful when using BigInteger as a key in hash-based collections like HashMap or HashSet.
     * - The hash code is derived from the numeric value of the BigInteger, not its object reference.
     * - BigInteger instances are immutable; the original operand remains unchanged.
     * - Output: 5
     */
    bigInteger = new BigInteger("5");
    IO.println(bigInteger.hashCode());
}