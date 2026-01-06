/*
Enums with Abstract Methods
- This section explains how Java enums can define abstract methods, allowing each constant to provide its own
  implementation.

Overview
- Enums can contain abstract methods just like abstract classes.
- Each enum constant must implement the abstract methods.
- Provides a way to give each constant specialized behavior while sharing the same type.
- Useful for strategy-like behavior or constant-specific logic.

Key Characteristics
- Abstract methods in enums are implicitly public.
- Each enum constant must override and implement the abstract methods.
- Enum can also have fields, constructors, and regular methods alongside abstract methods.
- Promotes polymorphism and organized, type-safe design.

Usage
- Use abstract methods when each enum constant requires a unique implementation.
- Ideal for situations where behavior differs per constant but type safety is required.
- Can combine with fields to provide both data and behavior for each constant.

Example:
- The example shows an enum "Operation" with an abstract method "apply".
- Each constant ("ADD", "SUB") implements "apply" differently.
*/
public enum Operation {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUB {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    };

    // Abstract method each constant must implement
    public abstract int apply(int a, int b);
}

void main() {
    IO.println(Operation.ADD.apply(5, 3)); // 8
    IO.println(Operation.SUB.apply(5, 3)); // 2
}