/*
Standard Interfaces
- This section explains the core standard interfaces in Java, which define common behaviors and contracts for objects
  across the language and the standard library, enabling polymorphism, flexible APIs, and consistent design patterns.

Overview
- Standard interfaces are primarily found in java.lang, java.util, and java.io packages.
- They define behavior rather than implementation, allowing classes to provide consistent functionality while keeping
  implementation details hidden.
- These interfaces are essential for the design of generic APIs, collections, concurrency utilities, and I/O operations.

Marker Interfaces
- Marker interfaces are a special type of interface in Java that do not declare any methods or constants.
- Their primary purpose is to signal metadata or a capability about a class to the JVM or frameworks.

Popular Interfaces & Abstractions
- Comparison
  - Comparable<T>: Defines natural ordering for objects (this vs that).
  - Comparator<T>: Defines an external strategy for comparing two objects.
- Collections & Iteration
  - Iterable<T>: Base for collections; enables for-each loop.
  - List<E>: Ordered collection (index-based).
  - Set<E>: Collection of unique elements.
  - Map<K, V>: Key-value associations (not a Collection, but part of the framework).
- Stream API
  - Stream<T>: Sequence of elements for functional-style aggregate operations.
  - Spliterator<T>: Specialized iterator for parallel/sequential stream traversal.
  - Collector<T, A, R>: Defines how to reduce stream elements into a result (e.g., toList()).
- Lifecycle & Markers
  - AutoCloseable: Resources that must be closed (enables try-with-resources).
  - Serializable: Marker interface for object serialization/persistence.
  - Cloneable: Marker interface, indicates that Object.clone() is allowed. (Legacy - copy constructors are preferred).
- Text & IO
  - CharSequence: Flexible text abstraction (String, StringBuilder, etc.).
  - Path: Modern interface for hierarchical paths (NIO.2), replacing the legacy File class.
- Events
  - EventListener: A tagging interface that all event listener interfaces must extend.
- Concurrency & Async
  - Runnable: Task that runs and returns nothing.
  - Callable<V>: Task that returns a value and can throw exceptions.
  - CompletableFuture<T>: Orchestrates async tasks and their dependencies.

Usage
- Use standard interfaces to design flexible and reusable code, allowing objects to interact through common contracts.
- Leverage marker interfaces to indicate capabilities recognized by the JVM or library code.
- Standard interfaces are foundational for writing idiomatic, type-safe, and maintainable Java applications.
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

/*
Example: Custom Iterable implementation
- Demonstrates how implementing "Iterable" allows the "Range" class to be used directly in a for-each loop, providing a
  clean and idiomatic API.
- Output: 0 | 1 | 2 | 3 | 4
*/
void main() {
    Range range = new Range(0, 5);
    for (Integer i : range) {
        IO.println(i);
    }
}