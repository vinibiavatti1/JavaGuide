/*
 * Functional Interfaces
 * - This section explains functional interfaces in Java and how they work together with lambda expressions and
 *   method references to enable functional-style programming.
 *
 * Overview
 * - Functional interfaces are part of Java 8's functional programming enhancements.
 * - A functional interface is an interface that contains exactly one abstract method, which makes it compatible
 *   with lambda expressions and method references.
 * - They provide the target type for lambdas and method references, enabling concise and expressive behavior passing.
 * - Functional interfaces can contain default and static methods in addition to the single abstract method.
 * - The @FunctionalInterface annotation is optional but recommended to document intent and prevent accidental
 *   addition of extra abstract methods.
 *
 * Key Characteristics
 * - Must define exactly one abstract method.
 * - Can include any number of default or static methods without losing functional interface semantics.
 * - Used extensively across the Java standard library, especially in the Stream API and java.util.function package.
 * - Enable higher-order functions, functional composition, and declarative programming patterns.
 *
 * Common Functional Interfaces
 * - Function<T, R>: transforms a value of type T into a value of type R, commonly used in map and collect operations.
 * - Consumer<T>: consumes a value of type T without returning a result, typically used for side effects such as forEach.
 * - Supplier<T>: supplies a value of type T without taking arguments, often used for lazy value creation or factories.
 * - Predicate<T>: tests a condition on a value of type T and returns a boolean, mainly used in filter operations.
 * - BiFunction<T, U, R>: transforms two input values (T and U) into a result of type R, used in reducers and collectors.
 * - BiConsumer<T, U>: consumes two input values without returning a result, often used in map or collector.
 * - BinaryOperator<T>: combines two values of the same type into one result of the same type, frequently used in reduce.
 * - UnaryOperator<T>: transforms a value into another value of the same type, used in mapping and element transform.
 *
 * Primitive-Specialized Functional Interfaces
 * - Java provides specialized functional interfaces for primitive types such as int, long, and double.
 * - These interfaces operate directly on primitive values, avoiding boxing and unboxing overhead present with generic
 *   functional interfaces.
 * - They are commonly used with primitive streams (IntStream, LongStream, DoubleStream) and in performance-sensitive
 *   code where numerical operations are frequent.
 * - Some examples are: IntFunction<R>, ToIntFunction<T>, IntConsumer, etc.
 *
 * Usage
 * - Declare functional interfaces using the interface keyword with a single abstract method.
 * - Use lambdas or method references to implement functional interfaces concisely.
 * - Prefer method references when a lambda only delegates to an existing method.
 * - Widely applied in streams, collectors, sorting, asynchronous callbacks, and functional-style APIs.
 *
 * Example
 * - The example below demonstrates how to declare a functional interface and implement it using a lambda expression.
 * - It also illustrates the traditional approach of using an anonymous class, highlighting the difference in
 *   conciseness and readability.
 */
@FunctionalInterface
interface Printer {
    void print(String message);
}

void main() {
    /*
     * Delegate with Lambda Expression
     * - The example below shows a delegate using a lambda expression.
     * - Concise and preferred when the behavior is simple.
     * - Output: Hello World
     */
    Printer printerRef = (x) -> IO.println(x);
    printerRef.print("Hello World");

    /*
     * Delegate with Method Reference
     * - The example below shows a delegate using a method reference.
     * - Improves readability when no additional logic is required.
     * - Output: Hello World
     */
    printerRef = IO::println;
    printerRef.print("Hello World");

    /*
     * Delegate with Anonymous Implementation
     * - The example below shows explicit class-like implementation created at runtime.
     * - More verbose, but allows additional state or complex logic.
     * - Output: Hello World
     */
    printerRef = new Printer() {
        @Override
        public void print(String message) {
            IO.println(message);
        }
    };
    printerRef.print("Hello World");
}
