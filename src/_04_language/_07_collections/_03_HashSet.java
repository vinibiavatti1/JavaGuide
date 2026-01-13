/*
 * HashSet
 * - This section explains the HashSet class, a hash table–backed implementation of the Set interface in Java.
 *
 * Overview
 * - HashSet stores a collection of unique elements without duplicates.
 * - Does not provide positional access or ordering guarantees.
 * - Uses a hash table internally for fast operations.
 *
 * Key Characteristics
 * - Constant-time performance (O(1)) for add(), remove(), and contains(), assuming a good hash function.
 * - Allows one null element.
 * - Element equality is determined using equals() and hashCode().
 * - Other Set implementations:
 *   - LinkedHashSet: maintains insertion order.
 *   - TreeSet: stores elements in sorted order with O(log n) performance.
 * - Not synchronized; use Collections.synchronizedSet() or CopyOnWriteArraySet for thread safety.
 *
 * Usage
 * - Preferred when uniqueness is required and iteration order does not matter.
 * - Use LinkedHashSet to preserve insertion order, or TreeSet for sorted elements.
 * - Iterate using for-each loops, iterators, or streams.
 * - This documentation focuses on HashSet examples.
 */
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
     * Declaration
     * - Declares a Set variable and initializes it with a concrete implementation (HashSet).
     * - A HashSet does not maintain insertion order and does not allow duplicate elements.
     * - It provides fast lookups, additions, and removals based on hashing.
     * - Output: []
     */
    Set<String> set = new HashSet<>();
    IO.println(set);

    /*
     * Initialization (Immutable)
     * - This declares and initializes a Set with specific elements in a single step.
     * - The resulting set is immutable, meaning that elements cannot be added or removed after creation.
     * - Duplicate elements are not allowed and will cause an IllegalArgumentException at runtime.
     * - Use this approach when you need a fixed set of unique elements that should not change during program execution.
     * - Output: [A, B, C] (order not guaranteed)
     */
    set = Set.of("A", "B", "C");
    IO.println(set);

    /*
     * Initialization (Mutable)
     * - This declares and initializes a Set with specific elements while allowing modifications afterward.
     * - By creating a HashSet from another collection (such as Set.of), you obtain a mutable set that supports adding
     *   or removing elements.
     * - Duplicate elements are automatically ignored.
     * - Use this approach when you need an initial set of unique elements but want to modify the set dynamically during
     *   program execution.
     * - Output: [A, B, C] (order not guaranteed)
     */
    set = new HashSet<>(Set.of("A", "B", "C"));
    IO.println(set);

    /*
     * Nullable
     * - Since the Set data type is a reference type, it can represent the absence of a value.
     * - Output: null
     */
    Set<String> otherSet = null;
    IO.println(set);

    //==================================================================================================================
    // Size
    //==================================================================================================================

    /*
     * Size (length)
     * - The "size()" method returns the number of elements currently stored in the Set.
     * - Since sets do not allow duplicate elements, the size reflects the count of unique values.
     * - The size can change dynamically as elements are added or removed.
     * - Output: 3
     */
    set = Set.of("A", "B", "C");
    IO.println(set.size());

    /*
     * Empty
     * - The isEmpty() method returns true if the set contains no elements, and false otherwise.
     * - It is a convenient way to check whether a set has any content before performing operations.
     * - Output: true
     */
    set = Set.of();
    IO.println(set.isEmpty());

    //==================================================================================================================
    // Adding Elements
    //==================================================================================================================

    /*
     * Adding Elements
     * - Elements can be added to a Set dynamically using the "add()" method.
     * - Since sets do not allow duplicate elements, adding an element that already exists has no effect.
     * - HashSet does not maintain any order, so you cannot specify a position for insertion.
     * - This approach is suitable for mutable sets where elements are not known in advance or may change during program
     *   execution.
     * - Output: [A]
     */
    set = new HashSet<>();
    set.add("A");
    set.add("A"); // Duplicated (no effect)
    IO.println(set);

    /*
     * Adding Elements (from another collection)
     * - The "addAll(Collection<? extends E> c)" method adds all elements from another collection to the set.
     * - Since sets do not allow duplicate elements, any duplicates in the added collection are ignored.
     * - HashSet does not maintain order, so there is no concept of inserting at a specific position.
     * - Output: [A, B] (order not guaranteed)
     */
    set = new HashSet<>();
    set.addAll(Set.of("A", "B"));
    IO.println(set);

    //==================================================================================================================
    // Removing Elements
    //==================================================================================================================

    /*
     * Removing Elements (by element)
     * - A Set does not support index-based removal because it does not maintain order.
     * - Elements can be removed by specifying the value using the "remove(Object o)" method.
     * - If the element exists in the set, it is removed; otherwise, the set remains unchanged.
     * - Output: [A, C] (order not guaranteed)
     */
    new HashSet<>(Set.of("A", "B", "C"));
    set.remove("B");
    IO.println(set);

    /*
     * Removing Elements (from another collection)
     * - The "removeAll(Collection<?> c)" method removes all elements from the set that are also contained in the
     *   specified collection.
     * - Since sets do not maintain order, there is no shifting of elements; only the specified elements are removed.
     * - Output: [C]
     */
    new HashSet<>(Set.of("A", "B", "C"));
    set.removeAll(Set.of("A", "B"));
    IO.println(set);

    /*
     * Retaining Elements
     * - The retainAll(Collection<?> c) method keeps only the elements in the set that are also present in another
     *   collection.
     * - All elements not contained in the provided collection are removed from the set.
     * - This operation effectively performs an intersection between the two collections and modifies the original set.
     * - Output: [A, B] (order not guaranteed)
     */
    set = new HashSet<>(Set.of("A", "B", "C"));
    set.retainAll(Set.of("A", "B"));
    IO.println(set);

    /*
     * Clear
     * - The "clear()" method removes all elements from the set, leaving it empty.
     * - After calling "clear()", the set size becomes 0.
     * - Output: []
     */
    set = new HashSet<>(Set.of("A", "B", "C"));
    set.clear();
    IO.println(set);

    //==================================================================================================================
    // Checking Elements
    //==================================================================================================================

    /*
     * Contains Element
     * - The "contains()" method checks whether a specific element exists in the set.
     * - It returns true if the element is present and false otherwise.
     * - Output: true
     */
    set = Set.of("A", "B", "C");
    IO.println(set.contains("A"));

    /*
     * Contains Elements (from another collection)
     * - The containsAll(Collection<?> c) method checks whether the set contains all elements from another collection.
     * - It returns true only if every element in the provided collection is present in the set.
     * - Output: true
     */
    set = Set.of("A", "B", "C");
    IO.println(set.containsAll(Set.of("A", "B")));

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
     * Equality
     * - Two sets are considered equal if they contain the same elements, regardless of order.
     * - The "equals()" method compares the contents of the sets, not their references.
     * - Output: true
     */
    Set<String> a = Set.of("A", "B", "C");
    Set<String> b = Set.of("C", "B", "A");
    IO.println(a.equals(b));

    //==================================================================================================================
    // Iteration
    //==================================================================================================================

    /*
     * Iterating (for each)
     * - Since a Set does not have indices, a traditional for loop cannot be used.
     * - Instead, a for-each loop is used to iterate over all elements in the set.
     * - Output: A | B | C (order not guaranteed)
     */
    set = Set.of("A", "B", "C");
    for (String element : set) {
        IO.println(element);
    }

    /*
     * Iterator (unidirectional)
     * - An Iterator provides a standard way to traverse elements of a Set sequentially.
     * - It allows safe iteration and supports element removal during traversal.
     * - Since sets do not have indices, element positions are not exposed, and bidirectional navigation is not
     *   supported.
     * - Output: A | B | C (order not guaranteed)
     */
    set = Set.of("A", "B", "C");
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
        IO.println(iterator.next());
    }

    //==================================================================================================================
    // Functional Methods
    //==================================================================================================================

    /*
     * Functional Iteration
     * - The functional for-each uses a lambda expression or method reference to process each element of the set.
     * - It provides a concise and expressive way to iterate over elements without explicit loop control.
     * - This approach is well suited for simple operations on each element and integrates naturally with functional
     *   programming features in Java.
     * - Output: A | B | C (order not guaranteed)
     */
    set = Set.of("A", "B", "C");
    set.forEach(IO::println);

    /*
     * Function Removal
     * - The "removeIf()" method removes all elements from the set that match a given condition.
     * - The predicate is evaluated for each element, and elements for which the condition returns true are removed.
     * - This provides a concise and expressive way to filter a set based on custom rules using functional programming
     *   constructs.
     * - Output: [B]
     */
    set = new HashSet<>(Set.of("A", "B"));
    set.removeIf(el -> el.equals("A"));
    IO.println(set);

    //==================================================================================================================
    // Stream API
    //==================================================================================================================

    /*
     * Call Stream API
     * - The "stream" method converts a Collection (e.g., List, Set) into a Stream.
     * - Useful for performing functional-style operations like map, filter, reduce, and forEach on collections.
     */
    Stream<String> stream = Set.of("A", "B", "C").stream();
}