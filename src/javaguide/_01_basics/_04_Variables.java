/*
Variables are used to store data in memory.
The name of a variable or constant cannot be a Java keyword.
*/
void main() {
    /*
    Declaring a variable.
    Syntax: <datatype> <name> = <value>;
    */
    int x1 = 1;
    IO.println(x1);
    /* Output: 1 */

    /*
    Declaring multiple variables in a single statement.
    Multiple variables of the same type can be declared in one line,
    separated by commas.
    */
    int a = 1, b = 2, c = 3;
    IO.println("a = " + a + " b = " + b + " c = " + c);
    /* Output: a = 1 b = 2 c = 3 */

    /*
    Changing the value of a variable.
    Variables are mutable, meaning their value can be updated.
    */
    x1 = 5;
    IO.println(x1);
    /* Output: 5 */

    /*
    Declaring a variable of String type.
    Other datatypes can be used to declare variables.
    */
    String x2 = "Hello World";
    IO.println(x2);
    /* Output: Hello World */

    /*
    Declaring a variable using "var".
    The compiler infers the datatype automatically.
    Useful for simpler or more readable code.
    */
    var x3 = 2;
    IO.println(x3);
    /* Output: 2 */
}