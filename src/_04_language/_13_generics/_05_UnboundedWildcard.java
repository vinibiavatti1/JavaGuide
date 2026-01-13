/*
 * Unbounded Wildcard (<?>)
 * - This section explains how to use unbounded wildcards in Java generics to accept any type.
 *
 * Overview
 * - The wildcard "?" represents an unknown type.
 * - Useful when a method or variable should accept any generic type.
 * - Provides flexibility, but writing to the container is restricted (except for null).
 *
 * Key Characteristics
 * - "?" can be used in class references, method parameters, or collections.
 * - Reading is safe as Object, writing is restricted.
 * - Often used for APIs that operate on collections of unknown types.
 *
 * Notes
 * - List<?> can hold a list of any type, but you cannot add elements (except null).
 * - Useful for general-purpose methods or containers when you don't need to know the exact type.
 *
 * Usage
 * - Use unbounded wildcards when the type is irrelevant for the operation.
 * - Enables flexible and type-safe code when only reading or iterating.
 * - Writing is limited because the compiler cannot guarantee type safety.
 *
 * Example:
 * - The example shows a generic class "Container<T>" and a reference using the wildcard "?".
 * - Demonstrates reading a value safely as Object, and writing is restricted.
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
    Container<String> stringContainer = new Container<>();
    Container<Integer> intContainer = new Container<>();

    stringContainer.set("Hello World");
    intContainer.set(42);

    // Wildcard example
    Container<?> unknownContainer;

    unknownContainer = stringContainer;
    IO.println(unknownContainer.get()); // Safe to read as Object
    // unknownContainer.set("Test");    // Not allowed: type unknown

    unknownContainer = intContainer;
    IO.println(unknownContainer.get()); // Safe to read as Object
    // unknownContainer.set(100);       // Not allowed: type unknown
}