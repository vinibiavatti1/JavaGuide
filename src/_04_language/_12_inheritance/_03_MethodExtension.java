/*
 * Method Extension
 * - This section explains how to extend the behavior of an inherited method in Java by overriding it and calling the
 *   superclass implementation using "super".
 *
 * Overview
 * - Method overriding allows a subclass to provide its own implementation of a method defined in its superclass.
 * - By calling "super.method()", the subclass can preserve the original behavior while adding additional functionality.
 * - This pattern is commonly used to augment or extend inherited behavior without duplicating code.
 *
 * Key Characteristics
 * - The overriding method in the subclass must have the same signature as the superclass method.
 * - Using the "@Override" annotation is recommended to ensure correctness and readability.
 * - Calling "super.method()" combines the inherited behavior with new behavior defined in the subclass.
 * - Supports code reuse, maintainability, and adherence to the original superclass contract.
 *
 * Usage
 * - Use this approach when you want to enhance rather than completely replace the behavior of a superclass method.
 * - Commonly applied in frameworks, lifecycle hooks, template methods, or any scenario where base logic must be
 *   preserved.
 * - Ensures that critical superclass logic is executed while allowing extensions in subclasses.
 */

/*
 * Superclass Declaration
 * - Demonstrates a superclass "Processor" with a method "process" that will be extended by the subclasses.
 */
public class Processor {
    public void process() {
        IO.println("Processing...");
    }
}

/*
 * Method Extension
 * - Demonstrates a subclass "ExtendedProcessor" that overrides the "process" method.
 * - Calls super.process() to preserve the original behavior from Animal.
 * - Adds behavior both before and after calling the superclass method.
 */
public class ExtendedProcessor extends Processor {
    @Override
    public void process() {
        IO.println("Before Processing..."); // Additional behavior BEFORE superclass method
        super.process();                    // Preserve superclass behavior
        IO.println("After Processing...");  // Additional behavior AFTER superclass method
    }
}

/*
 * Usage Example
 * - Demonstrates calling the extended method.
 * - Output:
 *   | Before Processing...
 *   | Processing...
 *   | After Processing...
 */
void main() {
    ExtendedProcessor processor = new ExtendedProcessor();
    processor.process();
}