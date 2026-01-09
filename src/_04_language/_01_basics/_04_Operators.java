/*
Operators
- This section explains the built-in operators in Java, which are used to manipulate values, perform calculations,
  compare data, and control program flow.

Overview
- Operators are symbols that represent computations, comparisons, logical operations, or assignments.
- They are applied to variables, literals, or expressions to produce a result.
- Java provides operators for arithmetic, comparison, logical, bitwise, shift, and assignment operations.

Operators
- Arithmetic Operators: +, -, *, /, %
- Unary Operators: +, -
- Increment/Decrement Operators: ++, --
- Comparison Operators: ==, !=, <, >, <=, >=
- Logical Operators: &&, ||, !
- Bitwise Operators: &, |, ^, ~
- Shift Operators: <<, >>, >>>
- Assignment Operators: =, +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>=

Usage
- Arithmetic, comparison, logical, and assignment operators are used most frequently.
- Bitwise, shift, and certain unary operators are used mainly in low-level, performance-critical, or specialized
  scenarios.
- Operators are fundamental for calculations, decision-making, and controlling program logic.
*/

void main() {
    /*
    Arithmetic Operators
    - The arithmetic operators are used to perform mathematical calculations and build expressions.
    - The standard arithmetic operators in Java are:
      - "+": addition
      - "-": subtraction
      - "*": multiplication
      - "/": division
      - "%": remainder/modulus
    */
    int x = 6, y = 2;
    IO.println(x + y); // 8
    IO.println(x - y); // 4
    IO.println(x * y); // 12
    IO.println(x / y); // 3
    IO.println(x % y); // 0

    /*
    Unary Operators
    - Unary operators operate on a single operand and can modify its value or return a derived result.
    - The standard unary operators in Java are:
      - "+": unary plus, indicates a positive value (has no effect on the operand)
      - "-": unary minus, negates the operand
    */
    x = 1;
    IO.println(-x); // -1
    IO.println(+y); // 1 (has no effect on the operand)

    /*
    Increment/Decrement Operators
    - These operators modify a numeric variable by 1 and can be used in two forms:
      - Prefix  (++x / --x): the variable is incremented or decremented before its value is used in the expression.
      - Postfix (x++ / x--): the variable is incremented or decremented after its value is used in the expression.
    */
    x = 1;
    IO.println(x++); // 1 - Postfix: prints 1, then x becomes 2
    IO.println(++x); // 3 - Prefix:  x becomes 3, then prints 3
    IO.println(x--); // 3 - Postfix: prints 3, then x becomes 2
    IO.println(--x); // 1 - Prefix:  x becomes 1, then prints 1

    /*
    Comparison Operators
    - Comparison operators are used to compare two values and return a boolean result (true or false).
    - These operators are commonly used in conditional statements and loops to control program flow.
    - The main comparison operators in Java are:
      - "==": equal to
      - "!=": not equal to
      - "<":  less than
      - ">":  greater than
      - "<=": less than or equal to
      - ">=": greater than or equal to
    */
    x = 6; y = 2;
    IO.println(x == y); // false
    IO.println(x != y); // true
    IO.println(x < y);  // false
    IO.println(x > y);  // true
    IO.println(x <= y); // false
    IO.println(x >= y); // true

    /*
    Logical Operators
    - Logical operators are used to combine or invert boolean values and return a boolean result (true or false).
    - These operators are commonly used in conditional statements, loops, and complex boolean expressions.
    - The main logical operators in Java are:
      - "&&": logical AND (true if both operands are true)
      - "||": logical OR (true if at least one operand is true)
      - "!":  logical NOT (inverts the boolean value)
    */
    x = 6; y = 2;
    IO.println(x > 0 && y > 0); // true
    IO.println(x > 0 || y < 0); // true
    IO.println(!(x > y));       // false

    /*
    Bitwise Operators
    - Bitwise operators are used to manipulate individual bits of integer values.
    - These operators are commonly used in low-level programming, flags, and performance-critical code.
    - The main bitwise operators in Java are:
      - "&": bitwise AND (1 if both bits are 1)
      - "|": bitwise OR  (1 if at least one bit is 1)
      - "^": bitwise XOR (1 if bits are different)
      - "~": bitwise NOT (inverts all bits)
    */
    x = 0b010101; // 21 in decimal
    y = 0b001111; // 15 in decimal
    IO.println(x & y); // 0b000101 = 5
    IO.println(x | y); // 0b011111 = 31
    IO.println(x ^ y); // 0b011010 = 26
    IO.println(~x);    // 0b101010 = -22

    /*
    Shift Operators
    - Shift operators move the bits of an integer value to the left or right.
    - They are commonly used for low-level programming, bit manipulation, and performance-critical code.
    - The main shift operators in Java are:
      - "<<": left shift (shifts bits to the left, filling with 0s)
      - ">>": signed right shift (shifts bits to the right, preserving the sign)
      - ">>>": unsigned right shift (shifts bits to the right, filling with 0s)
    */
    x = 0b001100;        // 12 in decimal
    y = -0b001100;       // -12 in decimal
    IO.println(x << 2);  // 0b110000 = 48
    IO.println(y >> 2);  // 0b000011 = -3 (sign preserved)
    IO.println(y >>> 2); // 0b000011 = 1073741821 (sign nor preserved)

    /*
    Assignment Operators
    - Assignment operators are used to assign values to variables, optionally performing an operation at the same time.
    - They are commonly used to update variables concisely in expressions.
    - The main assignment operators in Java are:
      - "="   : simple assignment, assigns the value on the right to the variable on the left
      - "+="  : addition assignment, adds the right-hand value to the variable and assigns the result
      - "-="  : subtraction assignment, subtracts the right-hand value and assigns the result
      - "*="  : multiplication assignment, multiplies and assigns
      - "/="  : division assignment, divides and assigns
      - "%="  : modulus assignment, computes remainder and assigns
      - "&="  : bitwise AND assignment
      - "|="  : bitwise OR assignment
      - "^="  : bitwise XOR assignment
      - "<<=" : left shift assignment
      - ">>=" : signed right shift assignment
      - ">>>=": unsigned right shift assignment
    - Output: 5
    */
    x = 2;
    x += 3; // equivalent to x = x + 3, now x = 5
    IO.println(x);
}