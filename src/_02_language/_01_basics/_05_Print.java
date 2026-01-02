/*
Printing
This section explains how to output information to the console in Java, allowing programs to communicate with the user.

Overview
- Printing is used to display variables, literals, or formatted messages.
- Java provides several mechanisms for console output, such as the modern "IO.println()" (Java 25+) and the common
  "System.out.println()".

Key Characteristics
- "print": prints a message without adding a newline.
- "println": prints a message followed by a newline.

Usage
- Use printing for debugging, logging, or providing user feedback.
- Combine literals, variables, and expressions to display meaningful information.
- Prefer formatted output when clarity or alignment is important.
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