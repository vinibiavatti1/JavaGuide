/*
Atomics
- This section explains the "Atomic" classes in Java, which provide a set of classes for performing lock-free,
  thread-safe operations on single variables and arrays, avoiding explicit synchronization.

Etymology
- The term "atomic" comes from the Greek word "atomos", meaning "indivisible".
- In computing, an atomic operation is one that is executed completely or not at all, without interruption, ensuring
  consistency in multithreaded environments.

Overview
- The Atomic classes are part of the java.util.concurrent.atomic package.
- They include AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference, and array variants.
- Introduced to support high-performance concurrent programming by leveraging low-level Compare-And-Swap (CAS)
  operations provided by the CPU.

Compare-And-Swap (CAS)
- CAS is a CPU-level instruction used to implement atomic operations.
- It works in three steps:
  1. Read the current value from memory.
  2. Compare it with an expected value.
  3. If the current value equals the expected value, write a new value; otherwise, retry.
- CAS ensures that updates are applied atomically, without using locks, and forms the basis for all Atomic classes.

Key Characteristics
- Support atomic operations like get, set, increment, decrement, compareAndSet, and update functions.
- Allow safe manipulation of shared variables in multithreaded environments without locks.
- Based on CAS primitives to ensure changes are applied atomically.
- Include array variants for thread-safe updates on multiple elements.

Atomic Objects
- AtomicInteger (int): Counters, IDs, numeric shared variables
- AtomicLong (long): High-frequency counters, timestamps
- AtomicBoolean (boolean): Flags, status indicators between threads
- AtomicReference<V> (Object): Updating shared object references safely
- AtomicIntegerArray (int[]): Thread-safe updates on integer arrays
- AtomicLongArray (long[]): Thread-safe updates on long arrays
- AtomicReferenceArray<V> (Object[]): Thread-safe updates on arrays of objects

Usage
- Use Atomic classes to implement counters, flags, references, and simple concurrent data structures.
- Ideal for scenarios where multiple threads need to read and update a shared variable safely and efficiently.
- Avoids overhead and complexity of synchronized blocks for simple atomic operations.
- Can be combined with other concurrent utilities to build high-performance, thread-safe applications.
*/
void main() {
    /*
    Declaration
    - Creates an AtomicInteger with initial value 5.
    - Supports thread-safe operations like get, set, and increment.
    - Output: 5 (the current value of the AtomicInteger)
    */
    AtomicInteger atomicInteger = new AtomicInteger(5);
    IO.println(atomicInteger);

    /*
    Get Value
    - The "get()" method retrieves the current value of the AtomicInteger in a thread-safe way.
    - The "getAndSet(newValue)" method can be used to atomically replace the current value with a new one and return the
      old value.
    - Output: 5
    */
    atomicInteger = new AtomicInteger(5);
    IO.println(atomicInteger.get());

    /*
    Set Value
    - The "set()" method updates the value of the AtomicInteger in a thread-safe way.
    - The "getAndSet(newValue)" method can be used to atomically set a new value and return the previous value.
    - Output: 10
    */
    atomicInteger = new AtomicInteger(5);
    atomicInteger.set(10);
    IO.println(atomicInteger);

    /*
    Compare And Set
    - The "compareAndSet()" method updates the value only if it currently equals the expected value.
    - Performs the check and update atomically, ensuring thread-safe conditional updates.
    - Returns true if the update was successful, false otherwise.
    - Output: 10
    */
    atomicInteger = new AtomicInteger(5);
    atomicInteger.compareAndSet(5, 10);
    IO.println(atomicInteger);

    /*
    Increment/Decrement
    - The "incrementAndGet()" method increases the value by 1 and returns the updated value atomically.
    - The "getAndIncrement()" method also increases the value by 1 but returns the previous value before incrementing.
    - Output: 6
    */
    atomicInteger = new AtomicInteger(5);
    IO.println(atomicInteger.incrementAndGet());

    /*
    Add
    - The "addAndGet()" method adds the specified value to the current value and returns the updated result atomically.
    - The "getAndAdd()" method adds the value but returns the previous value before addition.
    - Output: 10
    */
    atomicInteger = new AtomicInteger(5);
    IO.println(atomicInteger.addAndGet(5));

    /*
    Update
    - The "updateAndGet()" method applies the given function to the current value and returns the updated value
      atomically.
    - The "getAndUpdate()" method also applies the function but returns the previous value before updating.
    - Works safely in concurrent programs without explicit locks.
    - Output: 6
    */
    atomicInteger = new AtomicInteger(5);
    IO.println(atomicInteger.updateAndGet(x -> x + 1));
}