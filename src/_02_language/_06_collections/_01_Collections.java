/*
Collections
The Collections framework in Java represents a unified architecture for storing and manipulating groups of objects.
It provides interfaces like Collection, List, Set, Map, and Queue, along with concrete implementations that vary in
performance, ordering, and thread-safety.

Key points:
- The Collection interface is the root of the hierarchy and defines basic operations like add(), remove(), contains(),
  size(), and iterator().
- List represents an ordered collection with positional access, allowing duplicates. Key implementations include
  ArrayList and LinkedList.
- Set represents a collection with unique elements. Key implementations include HashSet, LinkedHashSet, TreeSet, and
  EnumSet.
- Map represents key-value associations. Key implementations include HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap,
  and EnumMap.
- Deque represents a double-ended queue allowing insertion and removal at both ends. Key implementations include
  ArrayDeque and LinkedList.
- Collections provides utility methods for sorting, searching, synchronization, and thread-safe wrappers (e.g.,
  Collections.synchronizedList()).

Important points:
- Concrete implementations differ in memory usage, access speed, ordering guarantees, and thread-safety.
- Choosing the right collection depends on the specific requirements: order, uniqueness, concurrency, and performance.
- For the most cases, the default collections are enough.
- Iteration can be performed using for-loops, for-each, iterators, spliterators, or streams.
*/
@SuppressWarnings("all")
void main() {
    // Default Collections
    new ArrayList<>();             // Resizable List, allows duplicates, maintains insertion order
    new HashSet<>();               // Unordered Set, unique elements only
    new HashMap<>();               // Unordered Map, key-value pairs, unique keys
    new ArrayDeque<>();            // Double-ended Queue, can be used as Stack or Queue

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
    new EnumMap(Type.class);     // Specialized Map for Enum keys, very efficient (array based)

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