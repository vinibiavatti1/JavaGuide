/*
Variables
- This section explains how to declare, initialize, and use variables in Java, which store data in memory and act as
  named references to values.

Overview
- Variables are named storage locations for data.
- Each variable has a type that determines the kind of data it can hold (primitive or reference).
- Variables must be declared before use, optionally with initialization.
- Constants can be defined with the "final" keyword, making their value immutable after assignment.

Key Characteristics
- Scope: defines where a variable can be accessed (local, instance, static).
- Naming rules: cannot use Java keywords and must follow identifier conventions.
- Types: primitive types (int, boolean, etc.) or reference types (objects, arrays).
- Mutability: variables can be reassigned unless declared as "final".

Usage
- Use variables to store temporary or persistent data in methods, objects, or classes.
- Use constants ("final") for values that should not change.
- Variables are essential for controlling program state and passing data between methods.
*/
void main() {
    /*
    Declaration
    - We can use the "<type> = <value>;" syntax to declare a variable of a data type.
    - Output: 1
    */
    int x = 1;
    IO.println(x);

    /*
    Final Declaration
    - We can declare the variable as "final" to define a constant.
    - Constants cannot have their value modified.
    - By convention, constant names are written in uppercase letters with underscores.
    - Output: 3.14
    */
    final double PI = 3.14;
    IO.println(PI);

    /*
    Underscores
    - Underscores can be used in numeric literals to improve readability.
    - They are ignored by the compiler and do not affect the actual value.
    - Output: 9223000
    */
    x = 9_223_000;
    IO.println(x);

    /*
    Multiple Declaration
    - Multiple variables of the same type can be declared inline, separated by commas.
    - Output: a:1 b:2 c:3
    */
    int a = 1, b = 2, c = 3;
    IO.println("a:" + a + " b:" + b + " c:" + c);

    /*
    Mutability
    - Variables are mutable, meaning their value can be updated.
    - Output: 5
    */
    int y = 2;
    y = 5;
    IO.println(y);

    /*
    Var Keyword
    - We can use the "var" keyword to infers the datatype automatically.
    - Output: 2
    */
    var z = 2;
    IO.println(z);

    /*
    Number Representations
    - Java allows integer values to be represented in the formats below:
      - Binary: prefix 0b or 0B, e.g., 0b010101 = 21 in decimal
      - Octal: prefix 0, e.g., 025 = 21 in decimal
      - Decimal: standard base-10, e.g., 21
      - Hexadecimal: prefix 0x or 0X, e.g., 0xFF = 255 in decimal
    - Output: a:21 b:21 c:255
    */
    a = 0b010101; // 21 in decimal
    b = 025;      // 21 in decimal
    c = 0xFF;     // 255 in decimal
    IO.println("a:" + a + " b:" + b + " c:" + c);
}