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
@SuppressWarnings("ConstantConditions")
void main() {
    /*
    Declaring boolean variables
    Syntax: boolean <name> = <value>;
    */
    boolean flag1 = true;
    boolean flag2 = false;
    IO.println("flag1 = " + flag1);
    IO.println("flag2 = " + flag2);
    /* Output:
    flag1 = true
    flag2 = false
    */

    /*
    Boolean expressions
    Booleans are often the result of comparisons or logical operations.
    */
    int a = 5, b = 10;
    boolean isGreater = a > b;
    boolean isEqual = a == b;
    boolean isSmaller = a < b;
    IO.println("a > b: " + isGreater);
    IO.println("a == b: " + isEqual);
    IO.println("a < b: " + isSmaller);
    /* Output:
    a > b: false
    a == b: false
    a < b: true
    */

    /*
    Logical operations
    AND (&&), OR (||), NOT (!)
    */
    boolean r1 = (a < b) && (b > 0);
    boolean r2 = !(a > b);
    IO.println("r1 = " + r1 + " r2 = " + r2);
    /* Output: r1 = true r2 = true */
}