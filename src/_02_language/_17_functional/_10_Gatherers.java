/*
Gatherers
- This section explains the "Gatherers" utility class in Java 25, which provides static methods to create common
  Gatherer instances for use with the Stream API, enabling advanced intermediate operations such as sliding windows,
  fixed windows, scans, folds, and concurrent mapping with virtual threads.

Overview
- The "Gatherers" class is part of the java.util.stream package.
- It contains static factory methods that return Gatherer instances, which can be passed to the Stream.gather()
  intermediate operation to produce a transformed stream.
- Introduced in Java 24/25 to extend stream processing beyond traditional intermediate operations like map, filter,
  and flatMap, allowing more expressive many-to-many transformations.

Key Characteristics
- All methods are static; no need to create a Gatherers instance.
- Provides gatherers for producing fixed-size windows (windowFixed), sliding windows (windowSliding), and prefix
  scans (scan) over stream elements.
- Supports folds (fold) that accumulate results into a single value while keeping the stream structure intact.
- Includes concurrent mapping (mapConcurrent) for applying functions in parallel using virtual threads.
- Gatherers are intermediate operations, not terminal; the resulting stream can be further processed before a
  terminal operation.
- Each gatherer can maintain internal state, produce zero or more elements per input, and optionally finalize
  operations at the end of the stream.

Usage
- Use Gatherers to perform advanced stream transformations that require windowing, prefix scans, folds, or concurrent
  mapping with virtual threads.
- Ideal for grouping elements, producing rolling computations, or performing stateful intermediate operations.
- Apply Gatherers when traditional intermediate operations (map, flatMap, filter) are insufficient for the desired
  stream behavior.
- Combine with terminal operations like toList(), forEach(), or collect() to extract results from the transformed stream.
*/
void main() {
    /*
    Window Fixed
    - "Gatherers.windowFixed(n)" creates a gatherer that groups elements from the stream into fixed-size windows
      containing exactly n elements each.
    - Each emitted element of the resulting stream is a List containing n consecutive input elements.
    - If the total number of elements is not divisible by the window size, the last window may contain fewer elements.
    - Useful for batch processing, chunking data, or performing computations over fixed-size groups.
    - Works with both sequential and parallel streams.
    - Output: [[1, 2], [3, 4]]
    */
    List<List<Integer>> listResult = Stream.of(1, 2, 3, 4).gather(Gatherers.windowFixed(2)).toList();
    IO.println(listResult);

    /*
    Window Sliding
    - "Gatherers.windowSliding(n)" creates a gatherer that emits overlapping windows of size n from the stream.
    - Each emitted element is a List containing n consecutive elements, sliding one element at a time.
    - Useful for moving-average computations, rolling calculations, or analyzing overlapping sequences.
    - Works with both sequential and parallel streams.
    - Output: [[1, 2], [2, 3]]
    */
    listResult = Stream.of(1, 2, 3).gather(Gatherers.windowSliding(2)).toList();
    IO.println(listResult);

    /*
    Scan (Prefix Sum)
    - "Gatherers.scan(initialSupplier, accumulator)" creates a gatherer that emits a running accumulation of stream
      elements.
    - The initial value is provided by "initialSupplier", and each element is combined with the accumulator function
      to produce the next running total.
    - Useful for prefix sums, cumulative computations, or tracking progressive aggregation over a stream.
    - Each emitted element represents the accumulation up to that point in the stream.
    - Works with both sequential and parallel streams.
    - Example Iterations: 1 -> 1+2 -> 1+2+3
    - Output: [1, 3, 6]
    */
    List<Integer> intListResult = Stream.of(1, 2 ,3).gather(Gatherers.scan(
            () -> 0,     // Initial Value (Supplier)
            Integer::sum // Accumulator (BiFunction)
    )).toList();
    IO.println(intListResult);

    /*
    Fold (Single Accumulation)
    - "Gatherers.fold(initialSupplier, accumulator)" creates a gatherer that reduces all stream elements into a single
      accumulated value.
    - The initial value is provided by "initialSupplier", and each element is combined with the accumulator function
      to update the accumulated state.
    - Unlike "scan", fold emits only one element representing the final accumulation after processing the entire stream.
    - Useful for computing totals, products, or other aggregate results while preserving the functional style.
    - Works with both sequential and parallel streams.
    - Output: [6]
    */
    List<Integer> listWithSum = Stream.of(1, 2, 3).gather(Gatherers.fold(
            () -> 0,     // Initial Value (Supplier)
            Integer::sum // Accumulator (BiFunction)
    )).toList();
    IO.println(listWithSum);

    /*
    Concurrent Map
    - "Gatherers.mapConcurrent(nThreads, function)" creates a gatherer that applies the provided function to each
      element in parallel using the specified number of virtual threads.
    - Each input element is processed independently, and the results are emitted in the order they are completed.
    - Useful for performing CPU-bound or IO-bound transformations concurrently while leveraging Java's virtual threads.
    - Works only with Java 25+ where virtual threads are fully supported.
    - Example: mapping strings to lowercase concurrently.
    - Output: [a, b, c]
    */
    List<String> strList = Stream.of("A", "B", "C").gather(Gatherers.mapConcurrent(
            3,                  // Number of Virtual Threads
            String::toLowerCase // Applier (Function)
    )).toList();
    IO.println(strList);
}