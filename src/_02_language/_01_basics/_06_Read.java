/*
Reading Input
This section explains how to read data from the console in Java, enabling programs to interact with the user.

Overview
- Reading input allows programs to capture user-provided data.
- Java provides several mechanisms for console input, such as the modern "IO.readln()" (Java 25+) and the common
  "Scanner" class.

Key Characteristics
- "IO.readln()": reads a line of input as a String; simple and convenient for modern Java versions.
- "Scanner": provides methods like "nextLine()", "nextInt()", and "nextDouble()" for parsing different types of input.

Usage
- Use reading input to capture user responses or data during program execution.
- Prefer "IO.readln()" for simple line-based input in modern Java.
- Use "Scanner" when parsing multiple types or structured input is required.
*/
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
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.print("Enter something else: ");
    input = scanner.nextLine();
    System.out.println("You entered: " + input);
    scanner.close();
}