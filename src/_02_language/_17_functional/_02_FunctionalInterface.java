/*
Functional Interfaces
- This section explains what a Functional Interface is in Java and how it enables functional programming features.

Overview
- A Functional Interface is an interface that declares exactly one abstract method.
- It serves as the target type for lambda expressions and method references.
- Java provides many built-in functional interfaces in the java.util.function package, such as Function, Predicate,
  Consumer, Supplier, and BiFunction.

Key Characteristics
- Must have exactly one abstract method (default methods do not count).
- Can contain default and static methods in addition to the single abstract method.
- Commonly annotated with @FunctionalInterface to make the intent explicit.

@FunctionalInterface Annotation
- The annotation is optional but strongly recommended.
- It tells the compiler to enforce the single-abstract-method rule.
- If another abstract method is added by mistake, compilation will fail.
- Improves readability and clearly communicates that the interface is intended to be used with lambdas.

Usage
- Functional interfaces can be implemented using:
  - Lambda expressions
  - Method references
  - Anonymous classes (legacy style)
- They are widely used with the Stream API and other functional-style APIs.

Example:
- The example defines a custom functional interface and uses it as a lambda inside the main method.
- Demonstrates how behavior can be passed as data.
*/
@FunctionalInterface
interface Runner {
    void run();
}

/*
Functional Interface Example
- Demonstrates how a functional interface can be implemented using a lambda expression and an anonymous class.
- Highlights the difference between modern functional style and legacy object-oriented style.
*/
void main() {
    /*
    Using Lambda Expression (Functional Style)
    - The lambda provides a concise implementation of the single abstract method.
    - No concrete class or boilerplate code is required.
    - This is the preferred approach when working with functional interfaces.
    - Output: Hello World
    */
    Runner runner = () -> IO.println("Hello World"); // Implicit implementation of run();
    runner.run();

    /*
    Using Anonymous Class (Legacy Style)
    - Implements the functional interface using an anonymous inner class.
    - More verbose and commonly used before Java 8.
    - Still valid, but generally replaced by lambdas for simplicity and readability.
    - Output: Hello World
    */
    runner = new Runner() {
        @Override
        public void run() {
            IO.println("Hello World");
        }
    };
    runner.run();
}