/*
 * BigDecimal
 * - This section explains the "BigDecimal" class in Java, which provides arbitrary-precision decimal arithmetic,
 *   allowing exact representation and computation of decimal numbers without the rounding errors common with
 *   floating-point types.
 *
 * Overview
 * - The "BigDecimal" class is part of the java.math package.
 * - It represents immutable, signed decimal numbers of arbitrary precision.
 * - Introduced in Java 1.1 to support high-precision financial, scientific, and engineering calculations.
 * - Useful when precise decimal representation is required, such as monetary calculations, interest computations,
 *   or measurements where rounding errors cannot be tolerated.
 *
 * Key Characteristics
 * - Immutable: all operations return new BigDecimal instances.
 * - Supports arithmetic operations (add, subtract, multiply, divide), scale manipulation, rounding, and comparison.
 * - Avoids precision issues inherent in floating-point arithmetic, e.g., 0.1 + 0.2 results in exactly 0.3.
 * - Operations that cannot be represented exactly, such as division with non-terminating decimals, throw an
 *   ArithmeticException unless an explicit rounding mode or scale is specified.
 * - Provides conversion to and from primitive types, strings, and BigInteger.
 * - Supports various rounding modes, specified via RoundingMode or MathContext.
 *
 * Usage
 * - Use BigDecimal when calculations require exact decimal representation or high precision.
 * - Prefer BigDecimal.valueOf(double) when converting from primitive double values to avoid binary floating-point
 *   errors.
 * - Use string-based constructors for precise numeric literals.
 * - Always specify a scale and rounding mode for operations that may be non-terminating to avoid exceptions.
 * - Ideal for financial calculations, scientific measurements, or any domain where floating-point imprecision is
 *   unacceptable.
 * - Combine with scale and rounding settings to control precision and rounding behavior consistently.
 */
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
     * BigDecimal Declaration Using String
     * - The "BigDecimal(String)" constructor creates a BigDecimal from its decimal string representation.
     * - Useful for precise decimal numbers, including fractional parts; the string can include a dot to indicate the
     *   decimal point.
     * - Preserves the exact numeric value without introducing floating-point imprecision.
     * - Output: 12345.67891011121314151617181920
     */
    BigDecimal bigDecimal = new BigDecimal("12345.67891011121314151617181920");
    IO.println(bigDecimal);

    /*
     * BigDecimal Declaration Using BigInteger
     * - The "BigDecimal(BigInteger)" constructor creates a BigDecimal representing the exact integer value of the given
     *   BigInteger.
     * - Useful for converting very large integer values into decimal form without loss of precision.
     * - The resulting BigDecimal has a scale of zero, representing a whole number.
     * - Output: 1234567891011121314151617181920
     */
    bigDecimal = new BigDecimal(new BigInteger("1234567891011121314151617181920"));
    IO.println(bigDecimal);

    /*
     * BigDecimal Declaration Using long
     * - The "valueOf(long)" factory method creates a BigDecimal from a primitive long value.
     * - This is the recommended and most efficient way to convert long integers into BigDecimal.
     * - The resulting BigDecimal represents the exact integer value with a scale of zero.
     * - Output: 123456789
     */
    bigDecimal = BigDecimal.valueOf(123456789L);
    IO.println(bigDecimal);

    /*
     * BigDecimal Declaration Using double
     * - The "valueOf(double)" factory method creates a BigDecimal from a primitive double value.
     * - Recommended over the "BigDecimal(double)" constructor, which can introduce precision errors due to the binary
     *   floating-point representation (e.g., new BigDecimal(0.1) is not exactly 0.1).
     * - Preserves the intended decimal value accurately.
     * - Output: 3.14
     */
    bigDecimal = BigDecimal.valueOf(3.14);
    IO.println(bigDecimal);

    //==================================================================================================================
    // Operations
    //==================================================================================================================

    /*
     * Scale
     * - The "setScale" method adjusts the number of digits to the right of the decimal point.
     * - Useful for controlling precision and rounding in calculations, especially for financial or measurement data.
     * - Requires a RoundingMode when reducing the scale to avoid ArithmeticException for non-terminating decimals.
     * - Returns a new BigDecimal with the specified scale; the original BigDecimal remains unchanged (immutable).
     * - Output: 3.33
     */
    bigDecimal = new BigDecimal("3.3333333333");
    bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
    IO.println(bigDecimal);

    /*
     * Strip Trailing Zeros
     * - The "stripTrailingZeros" method removes insignificant zeros from the fractional part of a BigDecimal.
     * - Useful for normalizing the representation of a number without changing its numeric value.
     * - Returns a new BigDecimal with the trailing zeros removed; the original BigDecimal remains unchanged
     *   (immutable).
     * - Output: 3.33
     */
    bigDecimal = new BigDecimal("3.3300000000");
    bigDecimal = bigDecimal.stripTrailingZeros();
    IO.println(bigDecimal);

    //==================================================================================================================
    // Arithmetic Operations
    //==================================================================================================================

    /*
     * Addition
     * - The "add" method performs exact decimal addition between two BigDecimal values.
     * - Returns a new BigDecimal representing the sum; BigDecimal instances are immutable.
     * - Unlike floating-point arithmetic, this operation preserves precise decimal values (e.g., 0.1 + 0.2 = 0.3
     *   exactly).
     * - Output: 0.3
     */
    BigDecimal a = new BigDecimal("0.1");
    BigDecimal b = new BigDecimal("0.2");
    bigDecimal = a.add(b);
    IO.println(bigDecimal);

    /*
     * Floating-Point Precision Loss in Addition
     * - Demonstrates the inherent imprecision of binary floating-point arithmetic.
     * - Adding 0.1 and 0.2 using double does not result in exactly 0.3 due to representation errors in binary format.
     * - Useful for highlighting why BigDecimal should be used for exact decimal calculations.
     * - Output: 0.30000000000000004
     */
    double x = 0.1;
    double y = 0.2;
    IO.println(x + y);

    /*
     * Subtraction
     * - The "subtract" method performs exact decimal subtraction between two BigDecimal values.
     * - Returns a new BigDecimal representing the difference; BigDecimal instances are immutable.
     * - Useful for precise calculations where floating-point subtraction may introduce rounding errors.
     * - Output: 0.1
     */
    a = new BigDecimal("100.0");
    b = new BigDecimal("99.9");
    bigDecimal = a.subtract(b);
    IO.println(bigDecimal);

    /*
     * Multiplication
     * - The "multiply" method performs exact decimal multiplication between two BigDecimal values.
     * - Returns a new BigDecimal representing the product; BigDecimal instances are immutable.
     * - Preserves scale and precision according to the operands.
     * - Output: 10.00
     */
    a = new BigDecimal("2.5");
    b = new BigDecimal("4.0");
    bigDecimal = a.multiply(b);
    IO.println(bigDecimal);

    /*
     * Division
     * - The "divide" method performs exact decimal division between two BigDecimal values.
     * - Returns a new BigDecimal representing the quotient; BigDecimal instances are immutable.
     * - If the division does not result in a terminating decimal, an ArithmeticException is thrown unless a scale and
     *   RoundingMode are specified.
     * - Output: 2.5
     */
    a = new BigDecimal("5.0");
    b = new BigDecimal("2.0");
    bigDecimal = a.divide(b);
    IO.println(bigDecimal);

    /*
     * Remainder
     * - The "remainder" method calculates the remainder of dividing one BigDecimal by another.
     * - Returns a new BigDecimal representing the remainder; BigDecimal instances are immutable.
     * - If the remainder cannot be represented exactly, an ArithmeticException may be thrown unless a scale and
     *   RoundingMode are specified.
     * - Useful for modular arithmetic or when the fractional remainder of a division is needed.
     * - Output: 1.0
     */
    a = new BigDecimal("10.0");
    b = new BigDecimal("3.0");
    bigDecimal = a.remainder(b);
    IO.println(bigDecimal);

    /*
     * Divide And Remainder
     * - The "divideAndRemainder" method performs division and remainder calculation in a single operation.
     * - Returns an array where index 0 is the quotient and index 1 is the remainder; both are BigDecimal instances.
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - If the division or remainder cannot be represented exactly, an ArithmeticException may be thrown unless a scale
     *   and RoundingMode are specified.
     * - Useful for performing both operations efficiently without separate method calls.
     * - Output: 3 / 1.0
     */
    a = new BigDecimal("10.0");
    b = new BigDecimal("3.0");
    BigDecimal[] result = a.divideAndRemainder(b);
    IO.println(result[0] + " / " + result[1]);

    //==================================================================================================================
    // Unexact Division/Remainder
    //==================================================================================================================

    /*
     * Unexact Division
     * - The "divide" method can throw an ArithmeticException if the division does not result in a terminating decimal.
     * - This also applies to the "remainder" and "divideAndRemainder" methods when the result cannot be represented
     *   exactly.
     * - To avoid this, specify a scale and RoundingMode to round the result explicitly.
     * - Demonstrates the need for explicit rounding in non-terminating decimal operations.
     * - Output: Non-terminating decimal expansion; no exact representable decimal result.
     */
    try {
        a = new BigDecimal("1.0");
        b = new BigDecimal("3.0");
        bigDecimal = a.divide(b);
        IO.println(bigDecimal);
    } catch (ArithmeticException e) {
        IO.println(e.getMessage());
    }

    /*
     * Unexact Division With Rounding
     * - The "divide" method with a specified scale and RoundingMode performs division even when the result is
     *   non-terminating.
     * - The scale parameter determines the number of digits to the right of the decimal point.
     * - RoundingMode specifies how the result is rounded to fit the scale.
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - Output: 0.33
     */
    a = new BigDecimal("1.0");
    b = new BigDecimal("3.0");
    bigDecimal = a.divide(b, 2, RoundingMode.HALF_UP);
    IO.println(bigDecimal);

    /*
     * Unexact Division With MathContext
     * - The "divide" method with a specified MathContext allows division of non-terminating decimals with controlled
     *   precision and rounding.
     * - MathContext defines the precision (total number of significant digits) and the RoundingMode to apply.
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - Useful for scientific calculations where a fixed precision is required.
     * - Output: 0.3333333333333333
     */
    a = new BigDecimal("1.0");
    b = new BigDecimal("3.0");
    bigDecimal = a.divide(b, MathContext.DECIMAL64);
    IO.println(bigDecimal);

    //==================================================================================================================
    // Comparison
    //==================================================================================================================

    /*
     * Min
     * - The "min" method returns the smaller of two BigDecimal values.
     * - Comparison is based on numeric value, ignoring scale differences.
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - Useful for selecting the lowest value without explicit comparison logic.
     * - Output: 3.0
     */
    a = new BigDecimal("10.0");
    b = new BigDecimal("3.0");
    bigDecimal = a.min(b);
    IO.println(bigDecimal);

    /*
     * Max
     * - The "max" method returns the larger of two BigDecimal values.
     * - Comparison is based on numeric value, ignoring scale differences.
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - Useful for selecting the highest value without explicit comparison logic.
     * - Output: 10.0
     */
    a = new BigDecimal("10.0");
    b = new BigDecimal("3.0");
    bigDecimal = a.max(b);
    IO.println(bigDecimal);

    /*
     * Equals
     * - The "equals" method checks if two BigDecimal instances represent the exact same numeric value and scale.
     * - Returns true only if both value and scale match exactly (e.g., 5.0 equals 5.0 but not 5).
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - Useful for strict equality comparisons where scale matters.
     * - Output: true
     */
    a = new BigDecimal("5.0");
    b = new BigDecimal("5.0");
    boolean eq = a.equals(b);
    IO.println(eq);

    /*
     * Compare To
     * - The "compareTo" method compares two BigDecimal values numerically, ignoring scale differences.
     * - Returns -1 if the first is less, 0 if equal, and 1 if greater than the second.
     * - BigDecimal instances are immutable; the original operands remain unchanged.
     * - Useful for sorting, ordering, or conditional logic based on numeric value without considering scale.
     * - Output: 0 (equal)
     */
    a = new BigDecimal("5.0");
    b = new BigDecimal("5.0");
    int cmp = a.compareTo(b);
    IO.println(cmp);

    /*
     * HashCode
     * - The "hashCode" method returns an integer hash code for the BigDecimal value.
     * - The hash code depends on both the numeric value and the scale, so 5 and 5.0 produce different hash codes.
     * - Useful when using BigDecimal as a key in hash-based collections like HashMap or HashSet.
     * - BigDecimal instances are immutable; the original operand remains unchanged.
     * - Output: 155
     */
    bigDecimal = new BigDecimal("5");
    IO.println(bigDecimal.hashCode());

    //==================================================================================================================
    // Conversion
    //==================================================================================================================

    /*
     * To BigInteger
     * - The "toBigInteger" method converts a BigDecimal to a BigInteger by discarding the fractional part.
     * - Only the integer portion of the BigDecimal is retained; the value is truncated toward zero.
     * - BigDecimal instances are immutable; the original operand remains unchanged.
     * - Useful for converting precise decimal values to exact integers when fractional parts are not needed.
     * - Output: 12345
     */
    bigDecimal = new BigDecimal("12345.67891011121314151617181920");
    BigInteger bigInteger = bigDecimal.toBigInteger();
    IO.println(bigInteger);
}