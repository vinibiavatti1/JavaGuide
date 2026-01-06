/*
ArrayList
- This section explains the ArrayList class, a resizable array implementation of the List interface in Java.

Overview
- ArrayList stores an ordered collection of elements (sequence), allowing duplicates.
- Provides positional access and insertion.
- Backed by a dynamically resizing array for efficient random access.

Key Characteristics
- Fast random access: O(1) for get(index) operations.
- Insertions/removals in the middle or beginning require shifting elements: O(n).
- Implements the List interface, sharing methods like add(), get(), remove(), size(), and iterator().
- Not synchronized; for thread-safe use, wrap with Collections.synchronizedList() or use CopyOnWriteArrayList.

Usage
- Preferred when fast indexed access is required and insertions/removals are infrequent.
- Use LinkedList instead when frequent insertions/deletions at arbitrary positions are needed.
- Iterate using for-loops, for-each, iterators, or streams.
- This documentation will focus on ArrayList examples.
*/
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declaration
    - Declares a List variable and initializes it with a concrete implementation (ArrayList).
    - Unlike arrays, lists do not have a fixed size and can dynamically grow as elements are added.
    - Output: []
    */
    List<String> list = new ArrayList<>();
    IO.println(list);

    /*
    Initialization (Immutable)
    - This declares and initializes a List with specific elements in a single step.
    - The resulting list is immutable, meaning that elements cannot be added, removed, or modified after creation.
    - Use this approach when you need a fixed set of elements that should not change during the program execution.
    - Output: [A, B, C]
    */
    list = List.of("A", "B", "C");
    IO.println(list);

    /*
    Initialization (Mutable)
    - This declares and initializes a List with specific elements while allowing modifications afterward.
    - By creating an ArrayList from another collection (such as List.of), you obtain a mutable list that supports
      adding, removing, or updating elements.
    - Use this approach when you need an initial set of elements but want to modify the list dynamically during program
      execution.
    - Output: [A, B, C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    IO.println(list);

    /*
    Nullable
    - Since the List data type is a reference type, it can represent the absence of a value.
    - Output: null
    */
    List<String> otherList = null;
    IO.println(list);

    //==================================================================================================================
    // Size
    //==================================================================================================================

    /*
    Size (length)
    - The "size()" method returns the number of elements currently stored in the List.
    - Unlike arrays, lists do not have a fixed length, and the size can change as elements are added or removed.
    - Output: 3
    */
    list = List.of("A", "B", "C");
    IO.println(list.size());

    /*
    Empty
    - The isEmpty() method returns true if the list contains no elements, and false otherwise.
    - It is a convenient way to check whether a list has any content before performing operations.
    - Output: true
    */
    list = List.of();
    IO.println(list.isEmpty());

    //==================================================================================================================
    // Accessing Elements
    //==================================================================================================================

    /*
    Getting Elements
    - Elements in a List can be accessed by their index using the "get()" method.
    - The index is zero-based, meaning the first element is at index 0.
    - If an invalid index is provided (less than 0 or greater than or equal to the list size), the method throws an
      IndexOutOfBoundsException.
    */
    list = List.of("A", "B", "C");
    IO.println(list.get(0)); // A
    IO.println(list.get(1)); // B
    IO.println(list.get(2)); // C

    /*
    Getting Index
    - The "indexOf(Object o)" method returns the index of the first occurrence of the specified element in the list.
    - If the element is not found, it returns -1.
    - Output: 0
    */
    list = List.of("A", "B", "A");
    IO.println(list.indexOf("A"));

    /*
    Getting Last Index
    - The "lastIndexOf(Object o)" method returns the index of the last occurrence of the specified element in the list.
    - If the element is not found, it returns -1.
    - Output: 2
    */
    list = List.of("A", "B", "A");
    IO.println(list.lastIndexOf("A"));

    //==================================================================================================================
    // Adding Elements
    //==================================================================================================================

    /*
    Adding Elements
    - Elements can be added to a List dynamically using the "add()" method. The list automatically resizes as needed to
      accommodate new elements.
    - This approach is suitable for mutable lists where elements are not known in advance or may change during program
      execution.
    - We can specify an index to add an element in a specific position.
    - Output: [A]
    */
    list = new ArrayList<>();
    list.add("A");
    IO.println(list);

    /*
    Adding Elements (from another collection)
    - The "addAll(Collection<? extends E> c)" method appends all elements from another collection to the end of the
      list.
    - This allows combining lists or adding multiple elements at once.
    - We can specify an index to add the elements from a specific position.
    - Output: [A, B]
    */
    list = new ArrayList<>();
    list.addAll(List.of("A", "B"));
    IO.println(list);

    //==================================================================================================================
    // Setting Elements
    //==================================================================================================================

    /*
    Setting Elements
    - Elements in a mutable List can be updated using the "set(index, element)" method.
    - The element at the specified index is replaced with the new value.
    - If an invalid index is provided (less than 0 or greater than or equal to the list size), the method throws an
      IndexOutOfBoundsException.
    - Output: [Z]
    */
    list = new ArrayList<>(List.of("A"));
    list.set(0, "Z");
    IO.println(list);

    //==================================================================================================================
    // Removing Elements
    //==================================================================================================================

    /*
    Removing Elements (by index)
    - Elements in a List can be removed using the "remove(index)" method, which deletes the element at the specified
      position.
    - Subsequent elements are shifted to fill the gap, reducing the size of the list by one.
    - If an invalid index is provided (less than 0 or greater than or equal to the list size), the method throws an
      IndexOutOfBoundsException.
    - Output: [A, C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    list.remove(1);
    IO.println(list);

    /*
    Removing Elements (by element)
    - The "remove(Object o)" method removes the first occurrence of the specified element from the list, if it exists.
    - Subsequent elements are shifted to fill the gap, reducing the list size by one.
    - Output: [A, C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    list.remove("B");
    IO.println(list);

    /*
    Removing Elements (from another collection)
    - The "removeAll(Collection<?> c)" method removes all elements from the list that are also contained in the
      specified collection.
    - Remaining elements are shifted accordingly, and the list size is reduced.
    - Output: [C]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    list.removeAll(List.of("A", "B"));
    IO.println(list);

    /*
    Retaining Elements
    - The retainAll(Collection<?> c) method keeps only the elements that are also present in another collection.
    - All elements that are not contained in the provided collection are removed from the list.
    - This operation effectively performs an intersection between the two collections and modifies the original list.
    - Output: [A, B]
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    list.retainAll(List.of("A", "B"));
    IO.println(list);

    /*
    Clear
    - The "clear()" method removes all elements from the list, leaving it empty.
    - After calling "clear()", the list size becomes 0.
    - Output: []
    */
    list = new ArrayList<>(List.of("A", "B", "C"));
    list.clear();
    IO.println(list);

    //==================================================================================================================
    // Checking Elements
    //==================================================================================================================

    /*
    Contains Element
    - The "contains()" method checks whether a specific element exists in the list.
    - It returns true if the element is present and false otherwise.
    - Output: true
    */
    list = List.of("A", "B", "C");
    IO.println(list.contains("A"));

    /*
    Contains Elements (from another collection)
    - The containsAll(Collection<?> c) method checks whether the list contains all elements from another collection.
    - It returns true only if every element in the provided collection is present in the list.
    - Output: true
    */
    list = List.of("A", "B", "C");
    IO.println(list.containsAll(List.of("A", "B")));

    //==================================================================================================================
    // Sorting Elements
    //==================================================================================================================

    /*
    Sorting Elements
    - Lists can be sorted using utility methods provided by the Java standard library.
    - Sorting can be done in natural order or using a custom Comparator to define specific ordering rules.
    - Output: [A, B]
    */
    list = new ArrayList<>(List.of("B", "A"));
    list.sort(Comparator.naturalOrder());
    IO.println(list);

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
    Equality
    - Two lists are considered equal if they contain the same elements in the same order.
    - The "equals()" method compares the contents of the lists, not their references.
    - Output: true
    */
    List<String> a = List.of("A", "B", "C");
    List<String> b = List.of("A", "B", "C");
    IO.println(a.equals(b));

    //==================================================================================================================
    // Iteration
    //==================================================================================================================

    /*
    Iterating (for)
    - A traditional for loop can be used to iterate over a List by accessing elements through their index.
    - This approach is useful when the index is required or when custom iteration logic is needed.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    for (int i = 0; i < list.size(); i++) {
        IO.println(list.get(i));
    }

    /*
    Iterating (for each)
    - The for-each loop (enhanced for loop) provides a simple and readable way to iterate over all elements in a List
      without using indices.
    - It is preferred when only element access is needed and the index is not required.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    for (String el : list) {
        IO.println(el);
    }

    /*
    Iterator (unidirectional)
    - An Iterator provides a standard way to traverse elements of a collection sequentially.
    - It allows safe iteration and supports element removal during traversal.
    - It does not expose element indices or support bidirectional navigation.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    Iterator<String> iter = list.iterator();
    while (iter.hasNext()) {
        String el = iter.next();
        IO.println(el);
    }

    /*
    List Iterator (bidirectional / index support / write support)
    - A ListIterator is a specialized iterator designed for List implementations.
    - It allows bidirectional traversal, enabling iteration both forward and backward through the list.
    - In addition to navigation, it supports modifying the list during iteration, such as adding, removing, or replacing
      elements, and provides access to the current element index.
    - Output: 0:A | 1:B | 2:C
    */
    list = List.of("A", "B", "C");
    ListIterator<String> listIter = list.listIterator();
    while (listIter.hasNext()) {
        int index = listIter.nextIndex();
        String el = listIter.next();
        IO.println(index + ":" + el);
    }

    //==================================================================================================================
    // Functional Methods
    //==================================================================================================================

    /*
    Functional Iteration
    - The functional for-each uses a lambda expression or method reference to process each element of the list.
    - It provides a concise and expressive way to iterate over elements without explicit loop control.
    - This approach is well suited for simple operations on each element and integrates naturally with functional
      programming features in Java.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    list.forEach(IO::println);

    /*
    Functional Replace
    - The "replaceAll()" method applies a transformation function to each element of the list and replaces the original
      elements with the results.
    - This approach is useful for bulk updates or data transformations using functional programming constructs.
    - Output: [a, b]
    */
    list = new ArrayList<>(List.of("A", "B"));
    list.replaceAll(String::toLowerCase);
    IO.println(list);

    /*
    Function Removal
    - The "removeIf()" method removes all elements from the list that match a given condition.
    - The predicate is evaluated for each element, and elements for which the condition returns true are removed.
    - This provides a concise and expressive way to filter a list based on custom rules using functional programming
      constructs.
    - Output: [B]
    */
    list = new ArrayList<>(List.of("A", "B"));
    list.removeIf(el -> el.equals("A"));
    IO.println(list);
}