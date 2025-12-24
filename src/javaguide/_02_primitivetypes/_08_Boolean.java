/*
The boolean type is a primitive data type in Java.
It can store only two values: true or false.

Booleans are primarily used for conditional statements, logic operations,
and flags.

Notes:
- boolean occupies one bit conceptually, but in Java it may use more memory
  depending on the JVM implementation.
- Only true and false are valid values; there is no numeric equivalence.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaring boolean variables
    Syntax: boolean <name> = <value>;
    Output: true false
    */
    boolean x1 = true;
    boolean x2 = false;
    IO.println(x1 + " " + x2);

    /*
    Boolean expressions
    Booleans are often the result of comparisons or logical operations.
    */
    int a = 5, b = 10;
    boolean isGreater = a > b;
    boolean isEqual = a == b;
    boolean isSmaller = a < b;
    IO.println(isGreater); // false
    IO.println(isEqual);   // false
    IO.println(isSmaller); // true

    /*
    Logical operations
    AND (&&), OR (||), NOT (!)
    Output: true true
    */
    boolean x3 = (a < b) && (b > 0);
    boolean x4 = !(a > b);
    IO.println(x3 + " " + x4);
}