/*
The char type is a primitive data type in Java.
It is a single 16-bit Unicode character, capable of storing any character
from the Unicode character set.

Chars are used to represent individual letters, digits, symbols, or any
UTF-16 encoded character.

Notes:
- Char literals are enclosed in single quotes: 'A', '1', '#'.
- Chars can be used in arithmetic operations because they are internally
  represented as numeric Unicode values.
*/
void main() {
    /*
    Declaring char variables
    Syntax: char <name> = '<character>';
    */
    char c1 = 'A';
    char c2 = '9';
    char c3 = '#';
    IO.println("c1 = " + c1);
    IO.println("c2 = " + c2);
    IO.println("c3 = " + c3);
    /* Output:
    c1 = A
    c2 = 9
    c3 = #
    */

    /*
    Char arithmetic
    Chars can be used in arithmetic operations because they have numeric
    Unicode values.
    */
    char letter = 'A';
    int nextLetter = letter + 1; // 'A' + 1 => 66
    IO.println("nextLetter Unicode: " + nextLetter);
    /* Output: nextLetter Unicode: 66 */

    /*
    Cast integer to char
    */
    char nextChar = (char) nextLetter; // Cast back to char
    IO.println("nextChar = " + nextChar);
    /* Output: nextChar = B */

    /*
    Comparison operations
    */
    char x = 'a', y = 'b';
    IO.println("x < y: " + (x < y));
    IO.println("x == y: " + (x == y));
    /* Output:
    x < y: true
    x == y: false
    */
}