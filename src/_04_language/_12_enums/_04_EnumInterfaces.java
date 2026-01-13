/*
 * Enums Interfaces
 * - This section explains how Java enums can implement interfaces to provide polymorphic behavior and consistent
 *   contracts across constants.
 *
 * Overview
 * - Enums can implement one or more interfaces just like regular classes.
 * - Each constant can provide its own implementation of the interface methods.
 * - Enables type-safe, reusable behavior while combining constant data with behavior.
 *
 * Key Characteristics
 * - Allows enums to be used polymorphically via the interface type.
 * - Each enum constant can override interface methods individually if needed.
 * - Enums can still have fields, constructors, and additional methods.
 * - Supports organized and flexible design patterns, such as strategy or command.
 *
 * Usage
 * - Use interfaces to define a common contract for enums with behavior.
 * - Ideal for operations or actions that vary per constant but share a common type.
 * - Helps decouple code from specific enum implementations while maintaining type safety.
 *
 * Example:
 * - The example demonstrates an interface "OperationInterface" and an enum "OperationEnum" implementing it.
 * - Each constant ("ADD" and "SUB") defines its own "apply" behavior.
 */
interface OperationApplier {
    int apply(int a, int b);
}

public enum Operation implements OperationApplier {
    ADD,
    SUB {
        @Override // Override Implementation (enum instance level)
        public int apply(int a, int b) {
            return a - b;
        }
    };

    // Default Implementation (enum level)
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}

void main() {
    IO.println(Operation.ADD.apply(5, 3)); // 8 (uses default implementation)
    IO.println(Operation.SUB.apply(5, 3)); // 2 (uses override implementation)
}