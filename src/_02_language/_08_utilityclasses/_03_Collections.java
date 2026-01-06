/*
Collections
- This section explains the "Collections" utility class in Java, which provides static methods to operate on Collection
  instances, including creating special-purpose collections, searching, sorting, synchronizing, etc.

Overview
- The "Collections" class is part of the java.util package.
- It contains static utility methods for collection manipulation, including immutability wrappers, synchronized
  wrappers, singleton factories, frequency counting, binary search, rotation, shuffling, and more.
- Introduced in early Java versions and continuously expanded to support generics and concurrency utilities.

Key Characteristics
- All methods are static; no need to create a Collections instance.
- Provides factories for immutable or singleton collections.
- Supports search and retrieval operations.
- Offers mutation and rearrangement utilities.
- Provides wrappers for thread-safety, i.e. synchronized versions for collections.

Usage
- Use Collections to simplify and standardize operations on collections without writing repetitive code.
- Ideal for creating immutable or thread-safe collections, performing searches, reordering elements, or computing
  statistics.
- Apply when you need consistent behavior across different Collection types or want to leverage built-in utility methods
  for efficiency.
- Works seamlessly with Lists, Sets, Maps, and other Collection implementations in both single-threaded and
  multithreaded contexts.
*/
void main() {
    //==================================================================================================================
    // Wrappers
    //==================================================================================================================

    /*
    Empty Collection
    - The "Collections.emptyList" method returns an immutable, shared empty List instance.
    - Always returns the same singleton reference to avoid unnecessary memory allocation.
    - Useful as a safe default return value to avoid null checks and unnecessary object creation.
    - The returned list cannot be modified and throws UnsupportedOperationException on write operations.
    - Similar methods exist for other collection types, such as emptySet() and emptyMap().
    - Output: []
    */
    List<String> list = Collections.emptyList();
    IO.println(list);

    /*
    Unmodifiable Collection
    - The "Collections.unmodifiableList" method returns an unmodifiable view of the specified List.
    - Prevents external code from modifying the list through the returned reference.
    - Structural modification attempts (add, remove, set) throw UnsupportedOperationException.
    - The underlying list may still be modified through its original reference.
    - Similar unmodifiable wrappers exist for other collection types, such as unmodifiableSet() and unmodifiableMap().
    - Output: [A, B, C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    IO.println(Collections.unmodifiableList(list));

    /*
    Synchronized Collection
    - The "Collections.synchronizedList" method returns a thread-safe view of the specified List.
    - All access and modification operations are synchronized on the returned list instance.
    - Useful for safely sharing a list between multiple threads without using concurrent collections.
    - Iteration still requires external synchronization to avoid ConcurrentModificationException.
    - Similar synchronized wrappers exist for other collection types, such as synchronizedSet() and synchronizedMap().
    - Output: [A, B, C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    IO.println(Collections.synchronizedList(list));

    /*
    Singleton Collection
    - The "Collections.singletonList" method returns an immutable List containing exactly one element.
    - The returned list has a fixed size and does not allow structural modifications.
    - Useful for representing a single-value collection without creating a full mutable List.
    - Similar singleton factory methods exist for other collection types, such as singleton() and singletonMap().
    - Output: [A]
    */
    list = Collections.singletonList("A");
    IO.println(list);

    //==================================================================================================================
    // Common Operations
    //==================================================================================================================

    /*
    Binary Search
    - The "Collections.binarySearch" method searches for a specified element in a sorted List.
    - Uses the binary search algorithm, dividing the list into halves to locate the element efficiently.
    - Returns the index of the element if found; otherwise, returns (-(insertion point) - 1).
    - Supports an optional Comparator for custom ordering behavior.
    - Note: The array MUST BE SORTED for correct results; otherwise, the outcome is undefined.
    - Output: 1
    */
    list = List.of("A", "B", "C");
    IO.println(Collections.binarySearch(list, "B"));

    /*
    Copy
    - The "Collections.copy" method copies all elements from a source List into a destination List.
    - Elements are copied by index, replacing existing elements in the destination list.
    - The destination list MUST be at least as large as the source list; otherwise, an IndexOutOfBoundsException is
      thrown.
    - Useful for overwriting the contents of an existing list without changing its size or reference.
    - Note: This method does not resize the destination list.
    - Output: [A, B, C]
    */
    list = new ArrayList<>();
    Collections.copy(List.of("A", "B", "C"), list);
    IO.println(list);

    /*
    Copy Elements
    - The "Collections.nCopies" method returns an immutable List containing multiple copies of the same element.
    - The list has a fixed size and all positions reference the same object instance.
    - Useful for initializing lists with default values or placeholder elements.
    - Attempts to modify the returned list will throw UnsupportedOperationException.
    - Similar to creating a repeated view rather than duplicating elements in memory.
    - Output: [A, A, A]
    */
    IO.println(Collections.nCopies(3, "A"));

    /*
    Min
    - The "Collections.min" method returns the minimum element in a collection.
    - All elements must be mutually comparable; otherwise, a ClassCastException may be thrown.
    - Useful for quickly retrieving the smallest element from a collection.
    - Supports optional custom comparator for flexible behavior.
    - Output: 1
    */
    List<Integer> intList = List.of(1, 2, 3);
    IO.println(Collections.min(intList));

    /*
    Max
    - The "Collections.max" method returns the maximum element in a collection.
    - All elements must be mutually comparable; otherwise, a ClassCastException may be thrown.
    - Useful for quickly retrieving the largest element from a collection.
    - Supports optional custom comparator for flexible behavior.
    - Output: 3
    */
    intList = List.of(1, 2, 3);
    IO.println(Collections.max(intList));

    /*
    Disjoint
    - The "Collections.disjoint" method checks whether two collections have no elements in common.
    - Returns true if the collections are disjoint (no shared elements), false otherwise.
    - Useful for quickly testing overlap between two collections without manually iterating.
    - Output: true
    */
    list = List.of("A", "B", "C");
    IO.println(Collections.disjoint(list, List.of("D", "E", "F")));

    /*
    Frequency
    - The "Collections.frequency" method counts the number of occurrences of a specified element in a collection.
    - Performs equality checks using the equals() method.
    - Useful for quickly determining how many times an element appears without manually iterating.
    - Output: 3
    */
    list = List.of("A", "A", "A");
    IO.println(Collections.frequency(list, "A"));

    /*
    Index of Sub List
    - The "Collections.indexOfSubList" method searches for the first occurrence of a specified sublist within a list.
    - Returns the starting index of the sublist if found; otherwise, returns -1.
    - Useful for finding sequences of elements within a list without manual iteration.
    - A complementary method "Collections.lastIndexOfSubList" exists to find the last occurrence of a sublist.
    - Output: 1
    */
    list = List.of("A", "B", "C");
    IO.println(Collections.indexOfSubList(list, List.of("B", "C")));

    /*
    Add All
    - The "Collections.addAll" method adds all specified elements to the provided collection.
    - Returns true if the collection was modified as a result of the operation.
    - Useful for quickly adding multiple elements without manually calling add() repeatedly.
    - Output: true
    */
    list = new ArrayList<>();
    IO.println(Collections.addAll(list, "A", "B", "C"));

    /*
    Fill
    - The "Collections.fill" method replaces every element in a list with the specified element.
    - Useful for initializing or resetting a list to a uniform value without creating a new list.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Output: [X, X, X]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    Collections.fill(list, "X");
    IO.println(list);

    /*
    Replace All
    - The "Collections.replaceAll" method replaces all occurrences of a specified element in a list with a new element.
    - Useful for updating specific values in a mutable list without manually iterating.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Output: [A, X, C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    Collections.replaceAll(list, "B", "X");
    IO.println(list);

    /*
    Reverse
    - The "Collections.reverse" method reverses the order of elements in a list in-place.
    - Useful for quickly inverting the sequence of a mutable list without creating a new list.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Output: [C, B, A]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    Collections.reverse(list);
    IO.println(list);

    /*
    Rotate
    - The "Collections.rotate" method rotates the elements in a list by a specified distance.
    - Positive distance moves elements to the right; negative distance moves elements to the left.
    - Useful for cyclically shifting elements without manually rearranging them.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Output: [C, A, B]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    Collections.rotate(list, 1);
    IO.println(list);

    /*
    Shuffle
    - The "Collections.shuffle" method randomly permutes the elements of a list in-place.
    - Useful for randomizing the order of elements, such as for games, testing, or sampling.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Uses a default source of randomness, or a custom Random instance can be provided for reproducibility.
    - Output: (Randomized order, e.g., B, C, A)
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    Collections.shuffle(list);
    IO.println(list);

    /*
    Sort
    - The "Collections.sort" method sorts the elements of a list into ascending order according to their natural
      ordering.
    - A custom Comparator can also be provided for alternative ordering.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Output: [A, B, C]
    */
    list = new ArrayList<>(List.of("C", "B", "A"));
    Collections.sort(list);
    IO.println(list);

    /*
    Swap
    - The "Collections.swap" method exchanges the elements at the specified positions in a list.
    - The list must be mutable; otherwise, an UnsupportedOperationException will be thrown.
    - Works efficiently for any List implementation.
    - Output: [A, B, C]
    */
    list = new ArrayList<>(List.of("C", "B", "A"));
    Collections.swap(list, 0, 2);
    IO.println(list);

    /*
    Reverse Order
    - The "Collections.reverseOrder" method returns a Comparator that imposes the reverse of the natural ordering.
    - Useful for sorting lists or arrays in descending order without manually implementing a Comparator.
    - Can be combined with Collections.sort or other sorting methods that accept a Comparator.
    - Does not modify any collection by itself; it only provides the Comparator.
    - Output: [C, B, A]
    */
    list = new ArrayList<>(List.of("C", "B", "A"));
    Collections.sort(list, Collections.reverseOrder());
    IO.println(list);
}