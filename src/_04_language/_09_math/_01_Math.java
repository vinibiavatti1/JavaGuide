/*
 * Math
 * - This section explains the "Math" class in Java, which provides a collection of static methods and constants
 *   for performing basic numeric operations such as exponentiation, logarithms, roots, rounding, trigonometry,
 *   and random number generation.
 *
 * Overview
 * - The "Math" class is part of the java.lang package.
 * - It provides static methods for common mathematical operations on primitive types (double and int).
 * - Introduced in early Java versions as a standard utility for mathematical computations.
 * - Widely used in applications ranging from graphics, physics simulations, scientific computing, and general
 *   numeric processing.
 *
 * Key Characteristics
 * - Contains constants such as PI, E, and TAU for common mathematical values.
 * - Supports basic arithmetic, rounding, comparison, exponential, logarithms, and root calculations.
 * - Includes trigonometric functions (sin, cos, tan, asin, acos, atan, atan2) and hyperbolic functions (sinh, cosh,
 *   tanh).
 * - Provides angular conversion methods (toRadians, toDegrees) and utilities like hypot, signum, copySign, nextUp, and
 *   nextDown.
 * - Includes Math.random() for generating pseudo-random numbers.
 * - All methods are static; Math cannot be instantiated.
 *
 * Usage
 * - Use Math for reliable, high-performance mathematical computations on primitive types.
 * - Prefer Math methods over manual calculations for accuracy, readability, and maintainability.
 * - Use constants PI, E, and TAU for common mathematical calculations involving circles, exponential growth, or radian
 *   measures.
 * - Apply trigonometric and hyperbolic functions for geometry, physics, and scientific algorithms.
 * - Use rounding and magnitude functions (abs, ceil, floor, round, rint) for numeric formatting and precise
 *   calculations.
 * - Ideal for applications requiring consistent, platform-independent numerical behavior.
 */
void main() {
    //==================================================================================================================
    // Constants
    //==================================================================================================================

    /*
     * PI
     * - Represents the mathematical constant π (pi), approximately 3.141592653589793.
     * - Commonly used in calculations involving circles, angles in radians, and trigonometry.
     * - Output: 3.141592653589793
     */
    IO.println(Math.PI);

    /*
     * E
     * - Represents the mathematical constant e, the base of natural logarithms, approximately 2.718281828459045.
     * - Commonly used in exponential growth, natural logarithms, and scientific calculations.
     * - Output: 2.718281828459045
     */
    IO.println(Math.E);

    /*
     * TAU
     * - Represents the mathematical constant τ (tau), equal to 2 * π, approximately 6.283185307179586.
     * - Commonly used to simplify formulas involving full rotations in radians or circular calculations.
     * - Output: 6.283185307179586
     */
    IO.println(Math.TAU);

    //==================================================================================================================
    // Round Functions
    //==================================================================================================================

    /*
     * Absolute Value
     * - Returns the absolute value of a number, removing its sign.
     * - Formula: |x| = x if x >= 0, or -x if x < 0.
     * - Output: 10
     */
    IO.println(Math.abs(-10));

    /*
     * Ceil
     * - Returns the smallest integer greater than or equal to the given number.
     * - Formula: ceil(x) = the least integer >= x.
     * - Output: 5.0
     */
    IO.println(Math.ceil(4.2));

    /*
     * Floor
     * - Returns the largest integer less than or equal to the given number.
     * - Formula: floor(x) = the greatest integer <= x.
     * - Output: 4.0
     */
    IO.println(Math.floor(4.8));

    /*
     * Round
     * - Returns the closest long (for double) or int (for float) to the given number.
     * - Formula: round(x) = floor(x + 0.5) for positive numbers, ceil(x - 0.5) for negative numbers.
     * - Output: 5
     */
    IO.println(Math.round(4.5));

    /*
     * Rint
     * - Returns the double value that is closest to the given number and is equal to a mathematical integer.
     * - Formula: rint(x) = the integer n where |x - n| is minimal; if two integers are equally close, returns the even
     *   one.
     * - Output: 4.0
     */
    IO.println(Math.rint(4.5));

    /*
     * Signum
     * - Returns the sign of a number as a double: 1.0 if positive, -1.0 if negative, 0.0 if zero.
     * - Formula: signum(x) = 1.0 if x > 0, -1.0 if x < 0, 0.0 if x == 0
     * - Output: -1.0
     */
    IO.println(Math.signum(-42));

    //==================================================================================================================
    // Exponential and Logarithmic Functions
    //==================================================================================================================

    /*
     * Exponential
     * - Returns Euler's number e raised to the power of the given number.
     * - Formula: exp(x) = e^x
     * - Output: 2.718281828459045
     */
    IO.println(Math.exp(1));

    /*
     * Logarithm
     * - Returns the natural logarithm (base e) of the given number.
     * - Formula: log(x) = ln(x), where e^ln(x) = x
     * - Output: 1.0
     */
    IO.println(Math.log(Math.E));

    /*
     * Logarithm (Base 10)
     * - Returns the base-10 logarithm of the given number.
     * - Formula: log10(x) = y, where 10^y = x
     * - Output: 2.0
     */
    IO.println(Math.log10(100));

    /*
     * Power
     * - Returns the value of the first argument raised to the power of the second argument.
     * - Formula: pow(a, b) = a^b
     * - Output: 8.0
     */
    IO.println(Math.pow(2, 3));

    /*
     * Square Root
     * - Returns the positive square root of the given number.
     * - Formula: sqrt(x) = y, where y^2 = x and y >= 0
     * - Output: 4.0
     */
    IO.println(Math.sqrt(16));

    /*
     * Cube Root
     * - Returns the cube root of the given number.
     * - Formula: cbrt(x) = y, where y^3 = x
     * - Output: 3.0
     */
    IO.println(Math.cbrt(27));

    /*
     * Hypotenuse
     * - Returns sqrt(x^2 + y^2), the length of the hypotenuse of a right-angled triangle with sides x and y.
     * - Formula: hypot(x, y) = sqrt(x^2 + y^2)
     * - Output: 5.0
     */
    IO.println(Math.hypot(3, 4));

    //==================================================================================================================
    // Trigonometric Functions
    //==================================================================================================================

    /*
     * Sin
     * - Returns the sine of an angle given in radians.
     * - Formula: sin(x) = opposite / hypotenuse in a right triangle
     * - Output: 1.0
     */
    IO.println(Math.sin(Math.PI / 2));

    /*
     * Cosine
     * - Returns the cosine of an angle given in radians.
     * - Formula: cos(x) = adjacent / hypotenuse in a right triangle
     * - Output: 1.0
     */
    IO.println(Math.cos(0));

    /*
     * Tangent
     * - Returns the tangent of an angle given in radians.
     * - Formula: tan(x) = sin(x) / cos(x) = opposite / adjacent
     * - Output: 1.0
     */
    IO.println(Math.tan(Math.PI / 4));

    /*
     * Arc Sin
     * - Returns the arc sine (inverse sine) of a value; the result is in radians.
     * - Formula: asin(x) = angle θ, where sin(θ) = x and -π/2 <= θ <= π/2
     * - Output: 1.5707963267948966
     */
    IO.println(Math.asin(1));

    /*
     * Arc Cosine
     * - Returns the arc cosine (inverse cosine) of a value; the result is in radians.
     * - Formula: acos(x) = angle θ, where cos(θ) = x and 0 <= θ <= π
     * - Output: 1.5707963267948966
     */
    IO.println(Math.acos(0));

    /*
     * Arc Tangent
     * - Returns the arc tangent (inverse tangent) of a value; the result is in radians.
     * - Formula: atan(x) = angle θ, where tan(θ) = x and -π/2 < θ < π/2
     * - Output: 0.7853981633974483
     */
    IO.println(Math.atan(1));

    /*
     * Arc Tangent 2
     * - Returns the angle theta (in radians) from the conversion of rectangular coordinates (x, y) to polar coordinates
     *   (r, theta).
     * - Formula: atan2(y, x) = angle θ, where tan(θ) = y / x and -π < θ <= π
     * - Output: 0.7853981633974483
     */
    IO.println(Math.atan2(1, 1));

    //==================================================================================================================
    // Angular Conversion Functions
    //==================================================================================================================

    /*
     * To Radians
     * - Converts an angle measured in degrees to an approximately equivalent angle measured in radians.
     * - Formula: radians = degrees * (π / 180)
     * - Output: 3.141592653589793
     */
    IO.println(Math.toRadians(180));

    /*
     * To Degrees
     * - Converts an angle measured in radians to an approximately equivalent angle measured in degrees.
     * - Formula: degrees = radians * (180 / π)
     * - Output: 180.0
     */
    IO.println(Math.toDegrees(Math.PI));

    //==================================================================================================================
    // Min/Max Functions
    //==================================================================================================================

    /*
     * Min
     * - Returns the smaller of two values.
     * - Formula: min(a, b) = a if a <= b, otherwise b
     * - Output: 3
     */
    IO.println(Math.min(3, 7));

    /*
     * Max
     * - Returns the larger of two values.
     * - Formula: max(a, b) = a if a >= b, otherwise b
     * - Output: 7
     */
    IO.println(Math.max(3, 7));

    //==================================================================================================================
    // Random Functions
    //==================================================================================================================

    /*
     * Random
     * - Returns a pseudorandom double value greater than or equal to 0.0 and less than 1.0.
     * - Formula: 0.0 <= random < 1.0
     * - Output: 0.374829 (example, actual output varies)
     */
    IO.println(Math.random());
}