/*
Generics Lower Bound (<? super T>)
This section explains how to use lower bounds in Java generics to restrict types to a specific class or its
superclasses.

Overview
- Lower bounds use "super" in wildcards to restrict a generic type: <? super Integer>
- Ensures the type can only be a specific class or its superclasses (e.g., Number, Object)
- Provides type safety when writing values into a generic container

Key Characteristics
- "? super T" allows you to safely add objects of type T or its subclasses
- Reading values returns a general type (usually Object), so casting may be needed
- Useful when a method or container should accept a range of types upwards in the hierarchy

Notes
- List<Number> is not the same as List<Integer>. To allow a variable to accept a list of multiple types, you can use
  wildcards: List<? extends Number> or List<? super Integer>.

Usage
- Use lower bounds when you want to write values safely into a container
- Enables flexible and type-safe code for producers of data
- Reading is less specific (general type), writing is safe

Example:
- The example shows a generic class "Container<T>" and using "? super Integer" to allow writing integers safely
- Demonstrates storing a value and reading it from a lower-bounded reference
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
    Container<Number> numberContainer = new Container<>();
    Container<Object> objectContainer = new Container<>();

    // Lower bound wildcard example
    Container<? super Integer> intContainer = numberContainer;

    intContainer.set(100);                 // Safe: Integer fits Number
    // Integer value = intContainer.get(); // Not allowed: get() returns Object
    Object value = intContainer.get();     // Safe to read as Object
    IO.println(value);                     // 100

    // Another example
    Container<? super Integer> objContainer = objectContainer;
    objContainer.set(200);                 // Safe
    IO.println(objContainer.get());        // 200 (as Object)
}