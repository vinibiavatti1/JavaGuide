/*
 * Reading Input (Console Input)
 * - This section explains how to read data from the console in Java, enabling programs to interact with the user and
 *   capture runtime input.
 *
 * Overview
 * - Reading input allows programs to capture user-provided data for processing.
 * - Java provides several mechanisms for console input:
 *   - Modern (Java 25+): IO.readln(), a simple line-based input utility.
 *   - Traditional: java.util.Scanner, which supports parsing multiple types of input.
 * - Input can be line-based, token-based, or type-specific (e.g., integers, doubles).
 *
 * Key Characteristics
 * - IO.readln(): Reads a full line of input as a String, optionally displaying a prompt.
 *   - Simple and convenient for modern Java versions.
 * - Scanner: Provides methods like nextLine(), nextInt(), nextDouble(), and others for structured input.
 *   - Can parse different data types directly from console input.
 *   - Requires explicit closure (scanner.close()) to release the underlying System.in resource.
 * - Both approaches block the calling thread until input is provided.
 *
 * Usage
 * - Use input reading to capture user responses or program parameters at runtime.
 * - Prefer IO.readln() for quick, line-based input in modern Java code.
 * - Use Scanner when input parsing of multiple types or structured data is needed.
 * - Always handle exceptions or invalid input when reading numbers or tokens with Scanner.
 */
void main() {
    /*
     * Modern Input with IO.readln() (Java 25+)
     * - Prompts the user and waits for input.
     * - Output: You entered: <user input>
     */
    String input = IO.readln("Enter something: ");
    IO.println("You entered: " + input);

    /*
     * Conventional Input Using Scanner
     * - Demonstrates reading input using java.util.Scanner.
     * - Useful for parsing multiple types or token-based input.
     * - Output: <user input>
     */
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter something else: ");
    input = scanner.nextLine();
    System.out.println("You entered: " + input);
    scanner.close();
}