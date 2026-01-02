/*
Generics Classes
This section explains how to make Java classes generic, allowing them to operate on objects of different types while
providing compile-time type safety.

Overview
- Generic classes define one or more type parameters (e.g., <E>, <T>, <K, V>).
- They enable the same class to work with different types without casting.
- Improves code reusability, readability, and safety.

Key Characteristics
- Type parameters are placeholders for actual types provided when creating instances.
- Fields, methods, and constructors can use the generic type.
- Can be combined with bounded types to restrict allowed types.

Usage
- Use generic classes for collections, containers, and utilities that should work with multiple types.
- Common examples: "List<E>", "Map<K, V>", or custom generic data structures.
- Follow standard conventions for collections (E = element, K = key, V = value, T = type)

Example:
- The example shows a simple generic class "MyList<E>" that stores and retrieves elements of any specified type.
- No casting is required, and type safety is enforced at compile time.
*/
public class MyList<E> {
    private List<E> list = new ArrayList<>();

    public void add(E element) {
        list.add(element);
    }

    public E get(int index) {
        return list.get(index);
    }
}

void main() {
    MyList<String> l1 = new MyList<>();  // Same class can be used for String type
    MyList<Integer> l2 = new MyList<>(); // Same class can be used for Integer type
    l1.add("Hello World");
    l2.add(1);
    IO.println(l1.get(0)); // Hello World
    IO.println(l2.get(0)); // 1
}