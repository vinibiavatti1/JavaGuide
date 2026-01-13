/* TODO
Essential Interfaces
- This section explains the core standard interfaces in Java that provide essential capabilities to classes,
  enabling consistent behavior, interoperability, and resource management across the language and standard library.

Overview
- These interfaces define general behaviors or capabilities that classes can adopt without enforcing a specific
  role or type.
- They focus on enabling fundamental operations such as comparison, iteration, serialization, and automatic
  resource management.
- Found mainly in java.lang, java.util, and java.io packages, they are key for writing flexible, reusable, and
  type-safe code.

Core Generic Interfaces
1. AutoCloseable
   - Provides the capability for a class to manage resources automatically.
   - Enables usage with try-with-resources, ensuring proper cleanup of resources like streams, files, or sockets.
2. Iterable<T> / Iterator<T>
   - Provides iteration capabilities over a sequence of elements.
   - Supports for-each loops and enables standardized traversal of collections or custom container types.
3. Comparable<T>
   - Enables natural ordering of objects.
   - Provides a contract for classes to define how their instances are compared, supporting sorting and ordering
     operations.
4. Serializable
   - Marker interface that indicates an object can be serialized for persistence or transmission.
   - Allows objects to be converted to a byte stream and restored without modifying the object's primary behavior.

Usage
- Implement these interfaces to provide essential capabilities to your classes without forcing them into a specific role.
- Use AutoCloseable to manage resources safely.
- Use Iterable/Iterator to allow iteration over custom data structures.
- Use Comparable to define natural ordering for objects, enabling sorting and comparison.
- Use Serializable to enable persistence or transmission of objects.
- These interfaces form the foundation for flexible, maintainable, and idiomatic Java applications.

Example
- Demonstrates how implementing "Iterable" allows the "Range" class to be used directly in a for-each loop, providing a
  clean and idiomatic API.
- Output: 0 | 1 | 2 | 3 | 4
*/
public class Range implements Iterable<Integer> {
    private int from;
    private int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.range(from, to).iterator();
    }
}

void main() {
    Range range = new Range(0, 5);
    for (Integer i : range) {
        IO.println(i);
    }
}