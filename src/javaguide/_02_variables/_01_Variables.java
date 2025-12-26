/*
Variables are used to store data in memory.
The name of a variable or constant cannot be a Java keyword.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaration
    We can use the "<type> = <value>;" syntax to declare a variable of a data type.
    Output: 1
    */
    int x = 1;
    IO.println(x);

    /*
    Final Declaration
    We can declare the variable as "final" to define a constant.
    Constants cannot have their value modified.
    By convention, constant names are written in uppercase letters with underscores.
    Output: 3.14
    */
    final double PI = 3.14;
    IO.println(PI);

    /*
    Underscores
    Underscores can be used in numeric literals to improve readability.
    They are ignored by the compiler and do not affect the actual value.
    Output: 9223000
    */
    x = 9_223_000;
    IO.println(x);

    /*
    Multiple Declaration
    Multiple variables of the same type can be declared inline, separated by commas.
    Output: a:1 b:2 c:3
    */
    int a = 1, b = 2, c = 3;
    IO.println("a:" + a + " b:" + b + " c:" + c);

    /*
    Mutability
    Variables are mutable, meaning their value can be updated.
    Output: 5
    */
    int y = 2;
    y = 5;
    IO.println(y);

    /*
    Var Keyword
    We can use the "var" keyword to infers the datatype automatically.
    Output: 2
    */
    var z = 2;
    IO.println(z);
}