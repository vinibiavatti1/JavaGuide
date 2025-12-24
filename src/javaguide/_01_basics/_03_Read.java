import java.util.Scanner;

/*
Java allows reading input from the console.
This example demonstrates the new IO.readln method (Java 25+)
and the conventional way using Scanner.
*/
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