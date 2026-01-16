/*
 * Strategy Design Pattern
 * - This section explains the "Strategy" design pattern, which defines a family of algorithms, encapsulates each one,
 *   and makes them interchangeable at runtime.
 *
 * Overview
 * - The Strategy pattern is a behavioral design pattern.
 * - It allows selecting an algorithm’s behavior at runtime.
 * - Algorithms are defined independently of the clients that use them.
 * - It promotes composition over inheritance.
 *
 * Key Elements
 * - Strategy: defines a common interface for all supported algorithms.
 * - ConcreteStrategy: implements a specific algorithm.
 * - Context: maintains a reference to a Strategy and delegates algorithm execution to it.
 *
 * Key Characteristics
 * - Eliminates conditional logic by replacing it with polymorphism.
 * - Supports runtime algorithm switching.
 * - Encourages separation of concerns.
 * - Clients depend on abstractions, not concrete implementations.
 *
 * Usage
 * - Use Strategy when multiple algorithms exist for the same task.
 * - Ideal for sorting, pricing rules, compression, or validation logic.
 * - Useful when behavior must be selected dynamically.
 * - Commonly used in frameworks and APIs to allow extensibility.
 */

/*
 * Strategy
 * - Defines a common interface for all supported algorithms.
 */
public interface EvenCheckerStrategy {
    boolean isEven(int number);
}

/*
 * ConcreteStrategy
 * - Implements a specific algorithm.
 */
public class ArithmeticEvenCheckerStrategy implements EvenCheckerStrategy {
    @Override
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
public class BitwiseEvenCheckerStrategy implements EvenCheckerStrategy {
    @Override
    public boolean isEven(int number) {
        return (number & 1) == 0;
    }
}

/*
 * Context
 * - Maintains a reference to a Strategy and delegates algorithm execution to it.
 */
public class EvenChecker {
    private EvenCheckerStrategy evenCheckerStrategy;

    public EvenChecker(EvenCheckerStrategy evenCheckerStrategy) {
        this.evenCheckerStrategy = evenCheckerStrategy;
    }

    public boolean isEven(int number) {
        return evenCheckerStrategy.isEven(number);
    }
}

/*
 * Strategy
 * - The example below shows the usage of the Strategy design pattern.
 */
void main() {
    // Arithmetic Strategy
    EvenChecker arithmeticEvenChecker = new EvenChecker(new ArithmeticEvenCheckerStrategy());
    IO.println(arithmeticEvenChecker.isEven(10)); // Output: true
    IO.println(arithmeticEvenChecker.isEven(11)); // Output: false

    // Bitwise Strategy
    EvenChecker bitwiseEvenChecker = new EvenChecker(new BitwiseEvenCheckerStrategy());
    IO.println(bitwiseEvenChecker.isEven(10)); // Output: true
    IO.println(bitwiseEvenChecker.isEven(11)); // Output: false
}