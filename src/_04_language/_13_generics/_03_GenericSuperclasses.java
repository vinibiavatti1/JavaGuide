/*
Generics Superclasses
- This section explains how to create generic superclasses in Java, allowing subclasses to specify or inherit type
  parameters while maintaining type safety and code reuse.

Overview
- Generic superclasses declare type parameters (e.g., <T>, <E>) that can be used in fields, methods, and constructors.
- Subclasses can specify concrete types or remain generic by passing the type parameter.
- Supports polymorphism, code reuse, and flexibility across different types.

Key Characteristics
- Type parameters of the superclass can be inherited or specialized by subclasses.
- Fields, methods, and constructors can use the generic type safely.
- Can be combined with bounded types (extends/super) for additional constraints.

Usage
- Use generic superclasses when multiple subclasses share common logic or storage for a type.
- Useful for reusable data structures, containers, and frameworks.

Example:
- The example shows a generic superclass "Container<T>" and two subclasses:
  - String-specific subclass
  - Generic subclass
- Type safety is enforced at compile time, no casting needed.
*/
public class Container<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class StringContainer extends Container<String> {
    // Inherits all functionality from Container<String>
}

public class GenericContainer<E> extends Container<E> {
    // Still generic; type specified by usage
}

void main() {
    Container<String> stringContainer = new StringContainer();             // String-specific container
    Container<Integer> integerContainer = new GenericContainer<Integer>(); // Generic container with Integer

    stringContainer.set("Hello Generics");
    integerContainer.set(42);

    IO.println(stringContainer.get());  // Hello Generics
    IO.println(integerContainer.get()); // 42
}