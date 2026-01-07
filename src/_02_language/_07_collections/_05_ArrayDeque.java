/*
ArrayDeque
- This section explains the ArrayDeque class, a resizable array–backed implementation of the Deque interface in Java.

Overview
- ArrayDeque allows elements to be added, removed, and inspected from both ends efficiently.
- Supports both FIFO (First-In, First-Out) and LIFO (Last-In, First-Out) semantics.
- Backed by a circular array for fast O(1) amortized insertions and removals.

FIFO (queue) and LIFO (stack):
- FIFO: When used as a queue, elements are processed in the same order they were inserted (offer() + poll()).
- LIFO: When used as a stack, the most recently added element is processed first (push() + pop()).

Key Characteristics
- Implements the Deque interface (and indirectly Queue).
- Null elements are not allowed.
- Common operations: addFirst(), addLast(), offer(), poll(), peek(), push(), pop(), and iterator().
- Not thread-safe; external synchronization or concurrent alternatives are needed for multithreaded use.
- Safer and faster alternative to legacy Stack and LinkedList for stack/queue operations.

Usage
- Use ArrayDeque for double-ended queues where fast insertion/removal at both ends is required.
- Use as FIFO queue (offer() + poll()) or LIFO stack (push() + pop()) depending on the use case.
- Iteration follows deque order from first to last.
- This documentation focuses on ArrayDeque examples.
*/
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declaration
    - Declares a Deque variable and initializes it with a concrete implementation (ArrayDeque).
    - ArrayDeque is a resizable, array-backed double-ended queue that allows elements to be
      added and removed from both ends efficiently.
    - It can be used as a FIFO queue or as a LIFO stack, depending on the operations used.
    - Output: []
    */
    Deque<String> deque = new ArrayDeque<>();
    IO.println(deque);

    /*
    Initialization (Mutable)
    - This declares and initializes a Deque with a predefined set of elements while allowing modifications afterward.
    - By creating an ArrayDeque from another collection (such as List.of), you obtain a mutable double-ended queue that
      supports adding and removing elements from both the front and the back.
    - Use this approach when you need an initial set of elements but want to modify the deque dynamically during program
      execution, using FIFO or LIFO semantics as required.
    - Unlike List.of(...) which returns an immutable list, there is no built-in immutable variant of ArrayDeque in Java.
    - All ArrayDeque instances are mutable, so immutability must be enforced by convention or by encapsulation.
    - Output: [A, B, C]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(deque);

    /*
    Nullable
    - Since the Deque data type is a reference type, it can represent the absence of a value.
    - This means the variable can be assigned null when no deque instance is available.
    - Output: null
    */
    Deque<String> otherDeque = null;
    IO.println(deque);

    //==================================================================================================================
    // FIFO (First In, First Out) - Queue Semantics
    //==================================================================================================================

    /*
    Offer
    - The "offer(E e)" method inserts the specified element at the end (back) of the Deque.
    - It is used when treating the deque as a FIFO queue. Unlike add(), it does not throw an exception if the deque is
      full (not relevant for ArrayDeque, which resizes dynamically), instead returning false if insertion fails.
    - Output: [A, B, C]
    */
    deque = new ArrayDeque<>(List.of("A", "B"));
    deque.offer("C");
    IO.println(deque);

    /*
    Poll
    - The "poll()" method retrieve and remove the first element of the Deque.
    - Unlike removeFirst(), this method return null if the deque is empty instead of throwing an exception.
    - Use this method to safely remove elements from the front without risking NoSuchElementException.
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(deque.poll()); // A
    IO.println(deque);        // [B, C]

    //==================================================================================================================
    // LIFO (Last In, First Out) - Stack Semantics
    //==================================================================================================================

    /*
    Push
    - The "push(E e)" method inserts the specified element at the front of the Deque.
    - It is used when treating the deque as a LIFO stack, making the new element the first to be removed on the next
      pop().
    - Output after insertion: [A, B, C]
    */
    deque = new ArrayDeque<>(List.of("B", "C"));
    deque.push("A");
    IO.println(deque);

    /*
    Pop
    - The "pop()" method removes and returns the first element of the Deque.
    - It is equivalent to removeFirst() and is commonly used when treating the Deque as a stack (LIFO behavior).
    - Throws NoSuchElementException if the deque is empty.
    */
    deque = new ArrayDeque<>(List.of("A", "B", "B"));
    IO.println(deque.pop()); // A
    IO.println(deque);       // [B, C]

    //==================================================================================================================
    // Size
    //==================================================================================================================

    /*
    Size (length)
    - The "size()" method returns the number of elements currently stored in the Deque.
    - Unlike arrays, deques do not have a fixed length, and the size can change as elements are added or removed from
      either end.
    - Output: 3
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(deque.size());

    /*
    Empty
    - The isEmpty() method returns true if the deque contains no elements, and false otherwise.
    - It is a convenient way to check whether a deque has any content before performing operations.
    - Output: true
    */
    deque = new ArrayDeque<>();
    IO.println(deque.isEmpty());

    //==================================================================================================================
    // Inspecting Elements
    //==================================================================================================================

    /*
    Peek / Peek First / Peek Last
    - The "peek()" and "peekFirst()" methods retrieve, but do not remove, the first element of the Deque.
    - They return null if the deque is empty.
    - The "peekLast()" method retrieves the last element without removing it, also returning null if the deque is empty.
    - These methods are safe ways to inspect elements at either end of the deque without modifying it.
    - Output: First = A | Last = C
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(deque.peek());      // A
    IO.println(deque.peekFirst()); // A
    IO.println(deque.peekLast());  // C

    //==================================================================================================================
    // Removing Elements
    //==================================================================================================================

    /*
    Removing Elements
    - The "remove(Object o)" method removes the first occurrence of the specified element from the Deque, if it exists.
    - Elements are shifted internally to maintain order.
    - Unlike removal by index, you do not need to know the position of the element.
    - Output: [A, C]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.remove("B");
    IO.println(deque);

    /*
    Removing Elements (from another collection)
    - The "removeAll(Collection<?> c)" method removes all elements from the Deque that are also contained in the
      specified collection.
    - Remaining elements maintain their order, and the size of the deque is reduced accordingly.
    - Output: [C]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.removeAll(List.of("A", "B"));
    IO.println(deque);

    /*
    Remove First
    - The "removeFirst()" method removes and returns the first element of the Deque.
    - Throws NoSuchElementException if the deque is empty.
    - Use this method when you want to remove elements from the front, following FIFO or stack LIFO semantics depending
      on how elements were added.
    - Output: [B, C]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.removeFirst();
    IO.println(deque);

    /*
    Remove Last
    - The "removeLast()" method removes and returns the last element of the Deque.
    - Throws NoSuchElementException if the deque is empty.
    - Use this method when you want to remove elements from the back, following FIFO or stack LIFO semantics depending
      on how elements were added.
    - Output: [A, B]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.removeLast();
    IO.println(deque);

    /*
    Remove First Occurrence
    - The "removeFirstOccurrence(Object o)" method removes the first occurrence of the specified element from the Deque,
      searching from the front to the back.
    - Returns true if the element was found and removed, false otherwise.
    - Output: [B, A]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "A"));
    deque.removeFirstOccurrence("A");
    IO.println(deque);

    /*
    Remove Last Occurrence
    - The "removeLastOccurrence(Object o)" method removes the last occurrence of the specified element from the Deque,
      searching from the back to the front.
    - Returns true if the element was found and removed, false otherwise.
    - Output: [A, B]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "A"));
    deque.removeLastOccurrence("A");
    IO.println(deque);

    /*
    Retaining Elements
    - The "retainAll(Collection<?> c)" method keeps only the elements in the Deque that are also present in the
      specified collection.
    - All elements not contained in the provided collection are removed from the deque.
    - This operation effectively performs an intersection between the two collections and modifies the original deque.
    - Output: [A, B]
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.retainAll(List.of("A", "B"));
    IO.println(deque);

    /*
    Clear
    - The "clear()" method removes all elements from the Deque, leaving it empty.
    - After calling "clear()", the deque size becomes 0.
    - Output: []
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.clear();
    IO.println(deque);

    //==================================================================================================================
    // Checking Elements
    //==================================================================================================================

    /*
    Contains Element
    - The "contains()" method checks whether a specific element exists in the Deque.
    - It returns true if the element is present and false otherwise.
    - Output: true
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(deque.contains("A"));

    /*
    Contains Elements (from another collection)
    - The "containsAll(Collection<?> c)" method checks whether the Deque contains all elements from another collection.
    - It returns true only if every element in the provided collection is present in the deque.
    - Output: true
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(deque.containsAll(List.of("A", "B")));

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
    Equality
    - Two deque are considered equal if they contain the same elements in the same order.
    - The "equals()" method compares the contents of the deque, not their references.
    - Output: true
    */
    Deque<String> a = new ArrayDeque<>(List.of("A", "B", "C"));
    Deque<String> b = new ArrayDeque<>(List.of("A", "B", "C"));
    IO.println(a.equals(b));

    //==================================================================================================================
    // Iteration
    //==================================================================================================================

    /*
    Iterating (for-each)
    - The for-each loop provides a simple and readable way to iterate over all elements in a Deque without using
      indices.
    - It is preferred when only element access is needed and the order of iteration follows the deque's front-to-back
      sequence.
    - Output: A | B | C
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    for (String el : deque) {
        IO.println(el);
    }

    /*
    Iterator (ascending)
    - An Iterator provides a standard way to traverse elements of a Deque sequentially.
    - It allows safe iteration and supports element removal during traversal.
    - It does not expose element indices or support bidirectional navigation.
    - Output: A | B | C
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    Iterator<String> iterator = deque.iterator();
    while (iterator.hasNext()) {
        IO.println(iterator.next());
    }

    /*
    Iterator (descending)
    - The "descendingIterator()" method returns an iterator that traverses the Deque from the tail (back) to the head
      (front), allowing reverse-order iteration.
    - It is useful when you need to process elements in LIFO order or just reverse the deque's sequence.
    - Output: C | B | A
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    Iterator<String> descIterator = deque.descendingIterator();
    while (descIterator.hasNext()) {
        IO.println(descIterator.next());
    }

    //==================================================================================================================
    // Functional Methods
    //==================================================================================================================

    /*
    Functional Iteration
    - The functional forEach uses a lambda expression or method reference to process each element of the Deque.
    - It provides a concise and expressive way to iterate over elements without explicit loop control.
    - This approach is well suited for simple operations on each element and integrates naturally with functional
      programming features in Java.
    - Output: A | B | C
    */
    deque = new ArrayDeque<>(List.of("A", "B", "C"));
    deque.forEach(IO::println);

    /*
    Function Removal
    - The "removeIf()" method removes all elements from the Deque that match a given condition.
    - The predicate is evaluated for each element, and elements for which the condition returns true are removed.
    - This provides a concise and expressive way to filter a deque using functional programming constructs.
    - Output: [B]
    */
    deque = new ArrayDeque<>(List.of("A", "B"));
    deque.removeIf(el -> el.equals("A"));
    IO.println(deque);

    //==================================================================================================================
    // Stream API
    //==================================================================================================================

    /*
    Call Stream API
    - The "stream" method converts a Collection (e.g., List, Set) into a Stream.
    - Useful for performing functional-style operations like map, filter, reduce, and forEach on collections.
    */
    Stream<String> stream = new ArrayDeque<>(List.of("A", "B", "C")).stream();
}