/*
 * Printing (Console Output)
 * - This section explains how to output information to the console in Java, enabling programs to communicate with
 *   users, provide feedback, or support debugging and logging.
 *
 * Overview
 * - Printing is used to display literals, variables, or formatted messages.
 * - Java provides several mechanisms for console output:
 *   - Traditional: System.out.print(), System.out.println(), System.out.printf()
 *   - Modern (Java 25+): IO.print(), IO.println()
 * - Output can be unformatted (simple text) or formatted (aligned, structured, with placeholders).
 *
 * Key Characteristics
 * - print(): Prints the given message without adding a newline at the end.
 * - println(): Prints the message and appends a newline.
 * - printf(): Prints formatted text using placeholders (e.g., %d, %f, %s) with optional newline (%n).
 * - Modern IO class methods mirror System.out methods but may provide additional convenience or abstraction.
 *
 * Usage
 * - Use console printing for:
 *   - Debugging and inspecting variables.
 *   - Providing real-time feedback to the user.
 *   - Displaying results or summaries of program operations.
 * - Prefer formatted printing (printf or String.format) when alignment, precision, or structured output is required.
 * - Avoid overusing console output for production logging; prefer logging frameworks for maintainable logs.
 */
void main() {
    /*
     * Basic Print
     * - Demonstrates printing with and without a newline.
     * - Output: Hello World | Hello World
     */
    System.out.print("Hello World");   // Without newline
    System.out.println("Hello World"); // With newline

    /*
     * Formatted Print
     * - Demonstrates formatted printing using printf.
     * - Not available in IO class.
     * - Output: Count: 1, Price: 3,14
     */
    System.out.printf("Count: %d, Price: %.2f %n", 1, 3.14);

    /*
     * Modern IO Print (Java 25+)
     * - Demonstrates printing using the IO utility class.
     * - Output: Hello World | Hello World\n
     */
    IO.print("Hello World");   // Without newline
    IO.println("Hello World"); // With newline
}