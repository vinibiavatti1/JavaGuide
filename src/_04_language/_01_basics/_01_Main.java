/*
 * Main Method (Entry Point)
 * - The main method in Java is the entry point of the application where execution begins.
 * - It is required for any standalone Java program that is executed by the JVM.
 *
 * Rules:
 * - Must be named "main" to be recognized by the JVM.
 * - Must be "public" so the JVM can access it from outside the class.
 * - Must be "static" because the JVM calls it without creating an instance of the class.
 * - Must accept a "String[] args" parameter to receive command-line arguments.
 *
 * Parameter: String[] args
 * - This parameter allows the program to accept input from the command line.
 * - Example: If the program is executed with
 *     java -jar program.jar a b c
 *   then args[0] = "a", args[1] = "b", args[2] = "c".
 * - This enables flexible program behavior based on user input or configuration at runtime.
 *
 * Notes:
 * - You can ignore the args parameter if your program does not require command-line input.
 * - For more advanced argument parsing, consider using libraries like Apache Commons CLI or picocli.
 * - The main method is always the starting point for JVM execution, but applications may spawn
 *   additional threads or call other entry methods after initialization.
 */
package _04_language._01_basics;

public class _01_Main {
    public static void main(String[] args) {
        IO.println("Hello World"); // Output: Hello World
    }
}