/*
Generic Constructors
This section explains how generic constructors work in Java and how they differ from generic classes and methods.

Overview
- A generic constructor declares its own type parameter.
- The generic type belongs only to the constructor, not to the class.
- The class itself may be generic or non-generic.

Key Characteristics
- The generic type is declared before the constructor name: <T> ClassName(...)
- The type parameter is scoped only to the constructor.
- Constructors never return a generic type; they always return the class instance.
- Can coexist with generic or non-generic classes.

Usage
- Use generic constructors when the class should accept different input types during construction.
- Useful for validation, conversion, or flexible initialization logic.
- Helps avoid excessive constructor overloading while keeping type safety.

Example:
- The example shows a non-generic class with a generic constructor.
- The constructor accepts values of different types safely.
- The stored value is handled internally by the class.
*/
public class Container {
    private Object value;

    public <T> Container(T value) {
        this.value = value;
    }

    public Object get() {
        return value;
    }
}

void main() {
    Container c1 = new Container("Hello World");
    Container c2 = new Container(42);
    Container c3 = new Container(3.14);

    IO.println(c1.get()); // Hello World
    IO.println(c2.get()); // 42
    IO.println(c3.get()); // 3.14
}
