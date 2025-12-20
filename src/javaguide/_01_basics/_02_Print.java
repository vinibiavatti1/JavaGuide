/*
Printing to the console allows your program to communicate with the user.
This example demonstrates different ways to output text in Java.
*/
void main() {
    /*
    Printing to the console using the conventional method.
    This prints the message and moves the cursor to the next line.
    Output: Hello World
    */
    System.out.println("Hello World");

    /*
    Printing using the new IO class (Java 25+).
    Simplifies console output; behaves like println.
    Output: Hello World
    */
    IO.println("Hello World");

    /*
    Printing to the console without automatically moving to the next line.
    We add "\n" at the end of the string to force the cursor to jump to the next line.
    Output: Hello World
    */
    IO.print("Hello World\n");

    /*
    Printing using formatted output.
    System.out.printf allows you to define a template string with placeholders:
    %d -> integer
    %f -> floating-point number
    %s -> string
    %n -> \n
    Output: Count: 1, Price: 1.23
    */
    int count = 1;
    double price = 1.234;
    System.out.printf("Count: %d, Price: %.2f %n", count, price);
}