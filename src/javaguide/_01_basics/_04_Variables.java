/*
Variables are used to store data in memory.
The name of a variable or constant cannot be a Java keyword.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaring a variable.
    Syntax: <datatype> <name> = <value>;
    Output: 1
    */
    int x = 1;
    IO.println(x);

    /*
    Declaring multiple variables in a single statement.
    Multiple variables of the same type can be declared in one line,
    separated by commas.
    Output: a = 1 b = 2 c = 3
    */
    int a = 1, b = 2, c = 3;
    IO.println("a = " + a + " b = " + b + " c = " + c);

    /*
    Changing the value of a variable.
    Variables are mutable, meaning their value can be updated.
    Output: 5
    */
    int y = 2;
    y = 5;
    IO.println(y);

    /*
    Declaring a variable of String type.
    Other datatypes can be used to declare variables.
    Output: Hello World
    */
    String text = "Hello World";
    IO.println(text);

    /*
    Declaring a variable using "var".
    The compiler infers the datatype automatically.
    Useful for simpler or more readable code.
    Output: 2
    */
    var z = 2;
    IO.println(z);
}