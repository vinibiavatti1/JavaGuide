/*
Upper Bounded Wildcards (<? extends T>)
This section explains how to use upper bounds in Java generics to restrict types to a specific class or its subclasses.

Overview
- Upper bounds use "extends" to restrict a generic type: <T extends Number>.
- Ensures the type can only be a specific class or its subclasses (e.g., Integer, Double).
- Provides type safety and allows calling methods defined in the bounded class.

Key Characteristics
- T can be the specified class or any subclass.
- Methods can safely use the bounded type's methods (e.g., doubleValue() in Number).
- Can combine with wildcards in method parameters (e.g., Container<? extends Number>).
- Useful when operations are only valid for a certain hierarchy of types.

Idea
- Upper Bounded Wildcards (<? extends T>)
  - List<? extends Number> accepts (List<Number>, List<Integer>, List<Double>)
  - Number x = list.get(i) : OK - Can read integer/double as Number
  - list.add(3.14)         : FAIL - Cannot add Double to List<Integer>
- Lower Bounded Wildcards (<? super T>)
  - List<? super Double> accepts (List<Double>, List<Number>, List<Object>)
  - Double x = list.get(i) : FAIL - Cannot read Object as Double
  - list.add(3.14)         : OK - Can add Double to (List<Double>, List<Number>, List<Object>)

Usage
- Use upper bounds for generic classes or methods that should accept a limited set of types.
- Enables flexible and type-safe code.
- Reading values with "? extends" is safe; writing is restricted.

Example:
- The example shows a generic class "Container<T>" restricted to Number or its subclasses.
- Demonstrates storing a single value, retrieving it, and using "? extends Number" safely.
*/
public class Container<T extends Number> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

void main() {
    Container<Integer> intContainer = new Container<>();
    Container<Double> doubleContainer = new Container<>();

    intContainer.set(100);
    doubleContainer.set(25.5);

    IO.println(intContainer.get());    // 100
    IO.println(doubleContainer.get()); // 25.5

    // Upper bound wildcard example
    Container<? extends Number> numberContainer = intContainer;
    IO.println(numberContainer.get()); // Safe to read
    // numberContainer.set(200);       // Not allowed: can't write to "? extends Number"
}