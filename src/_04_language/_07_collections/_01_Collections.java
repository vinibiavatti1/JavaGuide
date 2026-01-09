/*
Collections
- This section explains the Java Collections framework, which provides a unified architecture for storing and
  manipulating groups of objects.

Overview
- The framework includes core interfaces like Collection, List, Set, Map, and Queue.
- Concrete implementations vary in performance, ordering, and thread-safety.
- Collections provide utility methods for sorting, searching, synchronization, and creating thread-safe wrappers.

Key Characteristics
- Collection interface defines basic operations: add(), remove(), contains(), size(), and iterator().
- Iteration supported via for-loops, for-each, iterators, spliterators, or streams.

Abstractions
- List: ordered collection with positional access; allows duplicates (ArrayList, LinkedList).
- Set: collection of unique elements (HashSet, LinkedHashSet, TreeSet, EnumSet).
- Map: key-value associations (HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap, EnumMap).
- Deque: double-ended queue with insertion/removal at both ends (ArrayDeque, LinkedList).

Usage
- Choose the appropriate collection based on requirements: order, uniqueness, concurrency, and performance.
- Use List for ordered data, Set for uniqueness, Map for key-value pairs, and Deque for double-ended operations.
- Utilize Collections utility methods for common tasks like sorting, searching, and synchronization.
- For most standard cases, default implementations (ArrayList, HashSet, HashMap) are sufficient.
*/
void main() {
    // Default Collections
    new ArrayList<>();             // Resizable List, allows duplicates, maintains insertion order
    new HashSet<>();               // Unordered Set, unique elements only
    new HashMap<>();               // Unordered Map, key-value pairs, unique keys
    new ArrayDeque<>();            // Double-ended Queue, can be used as Queue (FIFO) or Stack (LIFO)

    // Linked / Insertion-Order Collections
    new LinkedList<>();            // List and Deque, allows fast insertions/removals anywhere
    new LinkedHashSet<>();         // Set with insertion order preserved
    new LinkedHashMap<>();         // Map with insertion order preserved

    // Thread-Safe Collections
    new CopyOnWriteArrayList<>();  // Thread-safe List, fast reads, costly writes
    new CopyOnWriteArraySet<>();   // Thread-safe Set, fast reads, costly writes
    new ConcurrentHashMap<>();     // Thread-safe Map, high concurrency support
    new ConcurrentLinkedQueue<>(); // Thread-safe Queue, high concurrency support (non-blocking)
    new ConcurrentLinkedDeque<>(); // Thread-safe Deque, high concurrency support (non-blocking)

    // Ordered / Sorted Collections
    new TreeMap<>();               // Map sorted by keys (natural order or comparator)
    new TreeSet<>();               // Set sorted by elements (natural order or comparator)

    // Priority
    new PriorityQueue<>();         // Unbounded queue based on a priority heap (natural order or comparator)

    // Blocking Collections (Mainly for Producer-Consumer patterns)
    new LinkedBlockingQueue<>();   // Thread-safe FIFO, optionally-bounded, used in ExecutorServices
    new ArrayBlockingQueue<>(10);  // Bounded FIFO queue backed by an array, fixed capacity
    new PriorityBlockingQueue<>(); // Thread-safe version of PriorityQueue, unbounded
    new SynchronousQueue<>();      // Rendezvous channel; each insert must wait for a corresponding take

    // Enum Optimized Collections
    EnumSet.of(DayOfWeek.FRIDAY);  // Specialized Set for Enums, extremely fast (bit-vector based)
    new EnumMap(Type.class);       // Specialized Map for Enum keys, very efficient (array based)

    // Rare & Specialized Collections (Use only in very specific architectural needs)
    new WeakHashMap<>();           // Entries are removed when keys are no longer in use (ideal for caches)
    new IdentityHashMap<>();       // Compares keys using == (reference) instead of .equals()
    new DelayQueue<>();            // Elements can only be taken after their delay time has expired
    new LinkedTransferQueue<>();   // Advanced BlockingQueue where producers can wait for consumers
    new BitSet();                  // A compact and efficient array of bits/booleans (not a formal Collection)

    // Legacy Collections (Avoid using in new code)
    new Vector<>();                // Old thread-safe List, slow due to total synchronization; use ArrayList
    new Stack<>();                 // Extends Vector, LIFO; use ArrayDeque instead for stacks
    new Hashtable<>();             // Old thread-safe Map, nulls not allowed; use HashMap or ConcurrentHashMap
}