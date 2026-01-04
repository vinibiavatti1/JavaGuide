/*
Generics Classes
- This section explains how to make Java classes generic, allowing them to operate on objects of different types while
  providing compile-time type safety.

Overview
- Generic classes define one or more type parameters (e.g., <E>, <T>, <K, V>).
- They enable the same class to work with different types without casting.
- Improves code reusability, readability, and safety.

Key Characteristics
- Type parameters are placeholders for actual types provided when creating instances.
- Fields, methods, and constructors can use the generic type.
- Can be combined with bounded types to restrict allowed types.
- Multiple types are allowed <T1, T2, ...>

Notes
- List<Number> is not the same as List<Integer>. To allow a variable to accept a list of multiple types, you can use
  wildcards: List<? extends Number> or List<? super Integer> (Check Upper Bound and Lower Bound guide files!)

Usage
- Use generic classes for containers, collections, or utilities that should work with multiple types.
- Common examples: "List<T>", "Map<K, V>", or custom generic data structures.
- Follow standard conventions for generics (E = element, K = key, V = value, T = type)

Example
- The example shows a simple generic class "Container<T>" that stores and retrieves a value of any specified type.
- No casting is required, and type safety is enforced at compile time.
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

void main() {
    Container<String> stringContainer = new Container<>();   // Same class can be used for String type
    Container<Integer> integerContainer = new Container<>(); // Same class can be used for Integer type

    stringContainer.set("Hello World");
    integerContainer.set(1);

    IO.println(stringContainer.get());  // Hello World
    IO.println(integerContainer.get()); // 1
}