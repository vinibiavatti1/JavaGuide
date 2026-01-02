/*
Generics Interfaces
This section explains how to make Java interfaces generic, allowing different implementations to operate on various
types while maintaining type safety.

Overview
- Generic interfaces declare type parameters (e.g., <T>, <E>) for their methods or return types.
- Implementing classes can specify concrete types or remain generic by passing the type parameter.
- Supports polymorphism and code reuse while keeping type safety.

Key Characteristics
- Type parameters can be used in method arguments, return types, and fields of implementing classes.
- Interfaces can have multiple type parameters.
- Can be combined with bounded types (extends/super) for flexible API design.

Usage
- Use generic interfaces for reusable contracts across multiple types.
- Common in functional interfaces, collections, and custom APIs.

Example:
- The example shows a generic interface "Container<T>" and three implementations:
  - String type
  - Generic type
- Type safety is enforced at compile time, no casting needed.
*/
public interface Container<T> {
    void set(T value);
    T get();
}

public class StringContainer implements Container<String> {
    // Implementation for Container<String>
    private String value;

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}

public class GenericContainer<E> implements Container<E> {
    // Still generic; type specified by usage
    private E value;

    @Override
    public void set(E value) {
        this.value = value;
    }

    @Override
    public E get() {
        return value;
    }
}

void main() {
    Container<String> stringContainer = new StringContainer();             // String Container
    Container<Integer> integerContainer = new GenericContainer<Integer>(); // Generic Container (type specified)

    stringContainer.set("Hello Generics");
    integerContainer.set(1);

    IO.println(stringContainer.get());  // Hello Generics
    IO.println(integerContainer.get()); // 1
}