/*
The short type is a primitive data type in Java.
It is a 16-bit signed integer, meaning it can store values from -32,768 to 32,767.
Short is useful to save memory in large arrays or when you know values are within this range.

Notes:
- Use short when memory optimization is needed.
- Be careful with arithmetic overflow, as shorts wrap around silently.
*/
void main() {
    /*
    Declaring a short variable
    Syntax: short <name> = <value>;
    */
    short s1 = 1000;
    IO.println("s1 = " + s1);
    /* Output: s1 = 1000 */

    /*
    Declaring another short variable with a negative value
    */
    short s2 = -5000;
    IO.println("s2 = " + s2);
    /* Output: s2 = -5000 */

    /*
    Short arithmetic.
    Operations like addition, subtraction, multiplication are possible,
    but arithmetic on short values is promoted to int by default.
    We can cast back to short using (short).
    */
    int sumInt = s1 + s2;
    short sumShort = (short) sumInt;
    IO.println("sumInt: " + sumInt + ", sumShort: " + sumShort);
    /* Output: sumInt: -4000, sumShort: -4000 */

    /*
    Short limits
    Using constants MIN_VALUE and MAX_VALUE to get the short limits.
    */
    short min = Short.MIN_VALUE;
    short max = Short.MAX_VALUE;
    IO.println("Short min: " + min + ", Short max: " + max);
    /* Output: Short min: -32768, Short max: 32767 */
}