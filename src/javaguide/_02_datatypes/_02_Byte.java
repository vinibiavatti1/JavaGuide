/*
The byte type is a primitive data type in Java.
It is an 8-bit signed integer, meaning it can store values from -128 to 127.
Bytes are useful for saving memory in large arrays or when working with raw binary data.

Notes:
- Use byte for memory optimization when possible.
- Be careful with arithmetic overflow, as bytes wrap around silently.
*/
void main() {
    /*
    Declaring a byte variable
    Syntax: byte <name> = <value>;
    */
    byte b1 = 10;
    IO.println("b1 = " + b1);
    /* Output: b1 = 10 */

    /*
    Declaring another byte variable using a negative value
    */
    byte b2 = -50;
    IO.println("b2 = " + b2);
    /* Output: b2 = -50 */

    /*
    Byte arithmetic.
    Operations like addition, subtraction, multiplication are possible,
    but arithmetic on byte values is promoted to int by default.
    We can cast back to byte using (byte).
    */
    int sumInt = b1 + b2;
    byte sumByte = (byte) sumInt;
    IO.println("sumInt: " + sumInt + ", sumByte: " + sumByte);
    /* Output: sumInt: -40, sumByte: -40 */

    /*
    Byte limits
    Using constants MIN_VALUE and MAX_VALUE to get the byte limits.
    */
    byte min = Byte.MIN_VALUE;
    byte max = Byte.MAX_VALUE;
    IO.println("Byte min: " + min + ", Byte max: " + max);
    /* Output: Byte min: -128, Byte max: 127 */
}