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
@SuppressWarnings("ConstantConditions")
void main() {
    /*
    Declaring char variables
    Syntax: char <name> = '<character>';
    Output: A
    */
    char x1 = 'A';
    IO.println(x1);

    /*
    Char arithmetic
    Chars can be used in arithmetic operations because they have numeric
    Unicode values.
    We can cast back to char using "(char)".
    The 'A' letter has the Unicode: 65.
    Output: 66
    */
    char letter = 'A';
    int nextLetter = letter + 1;
    IO.println(nextLetter);       // 66
    IO.println((char)nextLetter); // B

    /*
    Comparison operations
    Output: true false
    */
    char x = 'A', y = 'B';
    IO.println((x < y) + " " + (x == y));
}