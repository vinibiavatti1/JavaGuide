/*
 * Iterator Design Pattern
 * - This section explains the "Iterator" design pattern, which provides a way to access the elements of a collection
 *   sequentially without exposing its underlying representation.
 *
 * Overview
 * - The Iterator pattern is a behavioral design pattern.
 * - It decouples collection traversal logic from the collection itself.
 * - It allows multiple traversal strategies over the same collection.
 * - Iteration is standardized through a common interface.
 *
 * Key Elements
 * - Iterator: defines the interface for accessing and traversing elements (e.g., hasNext, next).
 * - ConcreteIterator: implements the Iterator interface and keeps track of the current traversal position.
 * - Aggregate (Iterable): defines an interface for creating an Iterator.
 * - ConcreteAggregate: implements the Aggregate interface and returns a ConcreteIterator.
 *
 * Key Characteristics
 * - Encapsulates traversal logic in a separate object.
 * - Supports multiple simultaneous iterations over the same collection.
 * - Provides a uniform way to traverse different collection types.
 * - Simplifies collection interfaces by removing traversal responsibilities.
 *
 * Usage
 * - Use Iterator to provide a standard way to traverse a collection without exposing its internal structure.
 * - Ideal when collections have complex internal representations.
 * - Commonly used to support enhanced for-loops (foreach).
 * - Widely used in Java through the Iterator and Iterable interfaces in java.util.
 */

/*
 * Iterator
 * - Defines the interface for accessing and traversing elements (e.g., hasNext, next).
 */
public interface Iterator<E> {
    E getNext();
    boolean hasMore();
}

/*
 * ConcreteIterator
 * - Implements the Iterator interface and keeps track of the current traversal position.
 */
public class RangeIterator implements Iterator<Integer> {
    private Range range;
    private Integer current;

    public RangeIterator(Range range) {
        this.range = range;
        this.current = range.getFrom();
    }

    @Override
    public Integer getNext() {
        if (current >= range.getTo()) {
            throw new NoSuchElementException();
        }
        Integer value = current;
        current++;
        return value;
    }

    @Override
    public boolean hasMore() {
        return current < range.getTo();
    }
}

/*
 * Aggregate
 * - Defines an interface for creating an Iterator.
 */
public interface Iterable<E> {
    Iterator<E> iterator();
}

/*
 * ConcreteAggregate
 * - Implements the Aggregate interface and returns a ConcreteIterator.
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
        return new RangeIterator(this);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}

/*
 * Example
 * - The example below shows the usage of the Iterator design pattern.
 */
void main() {
    Range range = new Range(3, 8);
    Iterator<Integer> iterator = range.iterator();
    while(iterator.hasMore()) {
        IO.println(iterator.getNext()); // 3 | 4 | 5 | 6 | 7
    }
}