/*
Reading Input
Java allows programs to read data from the console, enabling interaction with the user.

This example demonstrates two approaches:
- The modern IO.readln() method (available in Java 25+), which simplifies reading a line of input.
- The conventional approach using the Scanner class, which provides more flexibility for parsing different types.
*/
import java.util.Scanner;

@SuppressWarnings("all")
void main() {
    /*
    Reading input using the new IO class (Java 25+).
    The readln method prints the prompt and waits for user input.
    Output: You entered: <user input>
    */
    String input = IO.readln("Enter something: ");
    IO.println("You entered: " + input);

    /*
    Conventional way using Scanner (works in all Java versions).
    Scanner reads input from System.in.
    It is always good practice to close Scanner when done.
    Output: <user input>
    */
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter something else: ");
    String conventionalInput = scanner.nextLine();
    System.out.println("You entered: " + conventionalInput);
    scanner.close();
}