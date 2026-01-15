/*
 * Method Overloading
 * - This section explains method overloading in Java, which allows multiple methods in the same class to share the same
 *   name but differ in their parameter lists.
 *
 * Overview
 * - Overloaded methods have identical names but differ in at least one of the following:
 *   - Number of parameters
 *   - Types of parameters
 *   - Order of parameters
 * - The return type alone is not enough to distinguish overloaded methods.
 * - Overloading improves code readability and flexibility by allowing the same method name for conceptually similar
 *   actions with different inputs.
 * - Overloaded methods are resolved at compile time, based on the arguments provided in a method call.
 *
 * Usage
 * - Use method overloading to offer multiple ways to perform an operation depending on input types or counts.
 * - Ensure that overloaded methods perform similar or related actions to maintain clarity.
 * - Avoid overloading with completely unrelated functionality, as it can confuse readers and maintainers.
 */

/*
 * Class Declaration With Method Overloading
 * - This example demonstrates a class "Printer" that uses method overloading.
 * - Overloaded methods provide flexibility while keeping method names meaningful.
 */
public class Printer {
    // Base method
    public void print(String a, int b) {
        IO.println(a + b);
    }

    // Overload by number of parameters
    public void print(String a, int b, int c) {
        IO.println(a + b + c);
    }

    // Overload by type of parameters
    public void print(String a, String b) {
        IO.println(a + b);
    }

    // Overload by order of parameters
    public void print(int b, String a) {
        IO.println(a + b);
    }
}

/*
 * Usage Example
 * - Demonstrates calling different overloaded versions of the "print" method.
 * - Shows how Java resolves which method to call based on argument types, number, and order.
 */
void main() {
    Printer printer = new Printer();

    printer.print("x=", 10);   // Output: x=10
    printer.print("x=", 1, 0); // Output: x=10
    printer.print("x=", "1");  // Output: x=10
    printer.print(10, "x=");   // Output: x=10
}