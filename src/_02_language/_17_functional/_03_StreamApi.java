/*
Stream API
- This section explains the Java Stream API, which provides a functional-style approach to processing sequences
  of elements, enabling declarative, expressive, and efficient data transformations.

Overview
- The Stream API is part of the java.util.stream package.
- Introduced in Java 8 to support functional programming concepts such as lambdas, method references, and pipelines.
- A stream represents a sequence of elements supporting aggregate operations, not a data structure.
- Streams can be sequential or parallel and are consumed once.

Key Characteristics
- Streams are immutable: operations do not modify the original data source.
- Processing is lazy: intermediate operations are not executed until a terminal operation is invoked.
- Supports both internal iteration (managed by the Stream API) and parallel execution.
- Streams cannot be reused after a terminal operation.
- Works on top of data sources such as collections, arrays, I/O channels, or generated values.
- The Stream API is provided by the Collection framework; streams are available for collections, and once created, the
  same Stream API applies regardless of the collection type, differing only by element type and source characteristics.

Intermediate vs Terminal Operations
- Terminal Operations:
  - Consume the stream and produce a result or side effect.
  - Trigger the execution of the entire stream pipeline.
  - End the stream lifecycle.
  - Examples: forEach(...), collect(...), reduce(...), count(), findFirst(), anyMatch(...)
- Intermediate Operations:
  - Transform a stream into another stream.
  - Are lazy and only executed when a terminal operation is called.
  - Can be chained to form a processing pipeline.
  - Examples: map(...), filter(...), flatMap(...), distinct(), sorted(), peek(...)

Operation Categories
- Stateless Intermediate Operations:
  - Do not depend on previously seen elements.
  - Examples: map(...), filter(...)
- Stateful Intermediate Operations:
  - Maintain state across elements.
  - May require processing the entire stream.
  - Examples: distinct(), sorted()
- Short-Circuiting Intermediate Operations:
  - May stop processing early when a condition is met.
  - Examples: limit(...), takeWhile(...), dropWhile(...)
- Short-Circuiting Terminal Operations:
  - May terminate the stream before processing all elements.
  - Examples: findFirst(), findAny(), anyMatch(...), allMatch(...), noneMatch(...)

Functional Interfaces
- Function<T, R>: transforms a value of type T into a value of type R, commonly used in map and collect operations.
- Consumer<T>: consumes a value of type T without returning a result, typically used for side effects such as forEach.
- Supplier<T>: supplies a value of type T without taking arguments, often used for lazy value creation or factories.
- Predicate<T>: tests a condition on a value of type T and returns a boolean, mainly used in filter operations.
- BiFunction<T, U, R>: transforms two input values (T and U) into a result of type R, used in reducers and collectors.
- BiConsumer<T, U>: consumes two input values without returning a result, often used in map or collector.
- BinaryOperator<T>: combines two values of the same type into one result of the same type, frequently used in reduce.
- UnaryOperator<T>: transforms a value into another value of the same type, used in mapping and element transformation.
- IntFunction<R>: takes an int and produces a result of type R, commonly used with primitive streams.
- ToIntFunction<T>: converts a value of type T into an int, used in mapToInt operations.
- IntConsumer: consumes an int value without returning a result, used with IntStream forEach operations.

Primitive Streams
- Java provides specialized stream types to avoid boxing overhead: IntStream, LongStream and DoubleStream.
- These streams offer additional numeric operations such as: sum(), average(), min(), max(), summaryStatistics(), etc.
- Conversion methods exist between object streams and primitive streams: mapToInt(...), mapToLong(...), mapToDouble(...)
  boxed().

Notes:
- The "collect()" method accepts different type of Collectors, so there is a dedicated file to explain the most used
  Collectors.
- The "gather()" method is more advanced and was documented in a separated file.

Usage
- Use streams for readable, declarative data processing instead of explicit loops.
- Ideal for filtering, mapping, aggregating, and transforming collections.
- Prefer primitive streams for numerical computations to improve performance.
- Combine with collectors for complex reductions and grouping operations.
- Use parallel streams cautiously, considering data size and side effects.
*/
void main() {
    //==================================================================================================================
    // Initialization
    //==================================================================================================================

    /*
    Initialization from Collection
    - Creates a Stream from a Collection using the "stream()" method.
    - Available for all Collection types (e.g., List, Set), providing a unified way to process elements.
    - The resulting stream reflects the iteration order of the underlying collection, when it is defined.
    - Streams created from collections are lazy and only execute when a terminal operation is invoked.
    - Useful for applying functional-style operations (filter, map, reduce) on collection data.
    - Output: Stream containing [A, B, C]
    */
    Stream<String> stream = List.of("A", "B", "C").stream();

    /*
    Initialization with Fixed Set of Values
    - Creates a Stream directly from a fixed set of values using the "Stream.of" factory method.
    - Does not require an existing collection; elements are provided explicitly.
    - Preserves the order of the values as they are passed to the method.
    - Commonly used for quick stream creation, testing, or small, known datasets.
    - The resulting stream is lazy and processed only when a terminal operation is executed.
    - Output: Stream containing [A, B, C]
    */
    stream = Stream.of("A", "B", "C");

    /*
    Empty Initialization
    - Creates an empty Stream with no elements using the "Stream.empty" factory method.
    - Useful as a safe default to avoid returning null when no elements are available.
    - Allows stream pipelines to be composed without additional null checks.
    - Commonly used in APIs and methods that conditionally return a Stream.
    - The resulting stream immediately completes when a terminal operation is invoked.
    - Output: empty stream
    */
    stream = Stream.empty();

    //==================================================================================================================
    // Terminal Operations
    //==================================================================================================================

    /*
    Collect
    - The "collect" method is a terminal operation that performs a mutable reduction on the elements of the stream.
    - It is commonly used to: Convert a stream into a Collection (e.g., List, Set); Aggregate elements (e.g., sum, 
      average); Group elements (e.g., groupingBy) and Join elements into a string or custom container.
    - The "toList()" method is a simplified shortcut for collecting the elements into a List, introduced in Java 16.
    - Other overloads of "collect" include "Collectors.toSet()", "Collectors.toMap()", "Collectors.groupingBy()",
      "Collectors.joining()", and custom collectors.
    - Useful for transforming streams into collections, maps, or aggregated results, making stream processing
      interoperable with standard Java APIs.
    - Output: [A, B, C]
    */
    List<String> list = List.of("A", "B", "C");
    List<String> result = list.stream()
            .collect(Collectors.toList());
    IO.println(result);

    /*
    Collect as List
    - The "toList()" method is a terminal operation that collects the elements of the stream into an immutable List.
    - It is a simplified shortcut added in Java 16 as an alternative to "collect(Collectors.toList())".
    - Useful for quickly converting a stream into a List without needing an explicit collector.
    - Unlike "collect(Collectors.toList())", the List returned by "toList()" is unmodifiable (attempting to add/remove
      elements will throw an exception).
    - Output: [A, B, C]
    */
    list = List.of("A", "B", "C");
    result = list.stream()
            .toList();
    IO.println(result);

    /*
    Collect as Object Array
    - The "toArray()" method is a terminal operation that collects the elements of the stream into a new Object array.
    - It is useful when you need to convert a stream into an array for interoperation with APIs that require arrays.
    - There is also an overloaded version "toArray(IntFunction<A[]> generator)" that allows you to create a typed array
      (e.g., String[], Integer[]).
    - Useful for converting streams into arrays when working with legacy APIs, array-based processing, or for simple
      snapshots of stream data.
    - Output: [A, B, C]
    */
    list = List.of("A", "B", "C");
    Object[] array = list.stream()
            .toArray();
    IO.println(Arrays.toString(array));

    /*
    Iterate with For Each
    - The "forEach" method is a terminal operation that performs the specified action on each element of the stream.
    - Elements are processed in encounter order for sequential streams, but in parallel streams the order is not
      guaranteed.
    - Useful for performing side effects such as printing, logging, or updating external state.
    - Note: If you need to preserve order in parallel streams, consider using "forEachOrdered".
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    list.stream()
            .forEach(IO::println);

    /*
    Iterate with For Each Ordered
    - The "forEachOrdered" method is a terminal operation that performs the specified action on each element of the
      stream while preserving the encounter order.
    - Useful when processing parallel streams where order matters, such as logging, printing, or ordered updates.
    - Unlike "forEach", which may process elements in any order in parallel streams, "forEachOrdered" guarantees that
      elements are handled in the order defined by the stream source.
    - In sequential streams, "forEach" and "forEachOrdered" behave the same.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    list.stream()
            .parallel()
            .forEachOrdered(IO::println);

    /*
    Check if All Match
    - The "allMatch" method is a terminal operation that returns true if all elements of the stream match the given 
      predicate.
    - Useful for validating conditions across a stream, such as ensuring all values meet a requirement.
    - Short-circuiting: evaluation stops as soon as a non-matching element is found, which can improve performance.
    - Works with both sequential and parallel streams.
    - Related methods: "anyMatch" (checks if any element matches) and "noneMatch" (checks if no element matches).
    - Output: true
    */
    list = List.of("A", "A", "A");
    boolean match = list.stream()
            .allMatch(x -> x.equals("A"));
    IO.println(match);

    /*
    Check if Any Match
    - The "anyMatch" method is a terminal operation that returns true if at least one element of the stream matches the
      given predicate.
    - Useful for quickly verifying if a condition is met by any element in a stream.
    - Short-circuiting: evaluation stops as soon as a matching element is found, improving performance.
    - Works with both sequential and parallel streams.
    - Related methods: "allMatch" (checks if all elements match) and "noneMatch" (checks if no elements match).
    - Output: true
    */
    list = List.of("A", "B", "C");
    match = list.stream()
            .anyMatch(x -> x.equals("A"));
    IO.println(match);

    /*
    Check if None Match
    - The "noneMatch" method is a terminal operation that returns true if no elements of the stream match the given
      predicate.
    - Useful for verifying that a condition is not met by any element in the stream.
    - Short-circuiting: evaluation stops as soon as a matching element is found, improving performance.
    - Works with both sequential and parallel streams.
    - Related methods: "allMatch" (checks if all elements match) and "anyMatch" (checks if at least one element
      matches).
    - Output: true
    */
    list = List.of("B", "B", "B");
    match = list.stream()
            .noneMatch(x -> x.equals("A"));
    IO.println(match);

    /*
    Find First
    - The "findFirst" method is a terminal operation that returns an Optional describing the first element of the
      stream.
    - Useful when you need the first element according to the encounter order of the stream, especially in sequential
      streams.
    - Works with both sequential and parallel streams, but always respects the encounter order.
    - Returns an Optional, so methods like "ifPresent", "orElse", or "orElseThrow" can be used to safely handle the
      result.
    - Related method: "findAny" (may return any element in parallel streams, without guaranteeing order).
    - Output: A
    */
    list = List.of("A", "B", "C");
    Optional<String> optionalStr = list.stream()
            .findFirst();
    optionalStr.ifPresent(IO::println);

    /*
    Find Any
    - The "findAny" method is a terminal operation that returns an Optional describing some element of the stream.
    - Useful when you only need any element from the stream and do not care about the encounter order.
    - In sequential streams, it typically returns the first element, but in parallel streams it may return any element
      for better performance.
    - Returns an Optional, so methods like "ifPresent", "orElse", or "orElseThrow" can be used to safely handle the
      result.
    - Related method: "findFirst" (guarantees the first element according to encounter order).
    - Output: A
    */
    list = List.of("A", "B", "C");
    optionalStr = list.stream()
            .findAny();
    optionalStr.ifPresent(IO::println);

    /*
    Get Min
    - The "min" method is a terminal operation that returns an Optional describing the minimum element of the stream
      according to the provided Comparator.
    - Useful for finding the smallest element in a stream based on natural ordering or custom comparison logic.
    - Returns an Optional, so methods like "ifPresent", "orElse", or "orElseThrow" can be used to safely handle the
      result.
    - Related method: "max" (returns the maximum element according to the Comparator).
    - Output: A
    */
    list = List.of("A", "B", "C");
    optionalStr = list.stream()
            .min(Comparator.naturalOrder());
    optionalStr.ifPresent(IO::println);

    /*
    Get Max
    - The "max" method is a terminal operation that returns an Optional describing the maximum element of the stream
      according to the provided Comparator.
    - Useful for finding the largest element in a stream based on natural ordering or custom comparison logic.
    - Returns an Optional, so methods like "ifPresent", "orElse", or "orElseThrow" can be used to safely handle the
      result.
    - Related method: "min" (returns the minimum element according to the Comparator).
    - Output: C
    */
    list = List.of("A", "B", "C");
    optionalStr = list.stream()
            .max(Comparator.naturalOrder());
    optionalStr.ifPresent(IO::println);

    /*
    Get Count
    - The "count" method is a terminal operation that returns the total number of elements in the stream.
    - Useful for quickly determining the size of a stream, especially after filtering or other intermediate operations.
    - Works with both sequential and parallel streams.
    - Output: 3
    */
    list = List.of("A", "B", "C");
    long count = list.stream()
            .count();
    IO.println(count);

    /*
    Reduction
    - The "reduce" method is a terminal operation that performs a reduction on the elements of the stream, combining
      them into a single result.
    - Useful for computing sums, products, concatenations, or other cumulative operations.
    - Can be used with an identity value and an accumulator function, or with just a binary operator returning an
      Optional.
    - Works with both sequential and parallel streams.
    - Example shorthand: .reduce(0, Integer::sum) for summing integers.
    - Output: 6
    */
    List<Integer> intList = List.of(1, 2, 3);
    int sum = intList.stream()
            .reduce(0, (x, acc) -> acc + x); // or .reduce(0, Integer::sum);
    IO.println(sum);

    /*
    Return Iterator
    - The "iterator" method returns an Iterator over the elements of the stream.
    - Useful for manual iteration or integrating with APIs that require an Iterator.
    - The iterator supports the "forEachRemaining" method for processing remaining elements.
    - Works with both sequential and parallel streams, but parallel streams may not preserve encounter order when
      iterating.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    Iterator<String> iterator = list.stream().iterator();
    while (iterator.hasNext()) {
        IO.println(iterator.next());
    }

    /*
    Return Spliterator
    - The "spliterator" method returns a Spliterator over the elements of the stream.
    - Useful for traversing elements individually, splitting for parallel processing, or integrating with APIs that
      require a Spliterator.
    - The "forEachRemaining" method can be used to process all remaining elements in the Spliterator.
    - Related methods: "tryAdvance" (processes one element at a time) and "trySplit" (splits the Spliterator for
      parallelism).
    - Works with both sequential and parallel streams, preserving encounter order when applicable.
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    Spliterator<String> spliterator = list.stream()
            .spliterator();
    spliterator.forEachRemaining(IO::println);

    //==================================================================================================================
    // Intermediate Operations
    //==================================================================================================================

    /*
    Filter
    - The "filter" method is an intermediate operation that returns a new stream consisting of elements that match the
      given predicate.
    - Useful for selecting or narrowing down elements based on a condition.
    - Works with both sequential and parallel streams.
    - Can be chained with other intermediate operations for complex pipelines.
    - Output: [B]
    */
    list = List.of("A", "B", "C");
    result = list.stream()
            .filter(x -> x == "B")
            .toList();
    IO.println(result);

    /*
    Map
    - The "map" method is an intermediate operation that returns a new stream consisting of the results of applying the
      given function to each element of the original stream.
    - Useful for transforming elements from one type to another, such as extracting a property, converting types, or
      computing derived values.
    - Works with both sequential and parallel streams.
    - Can be chained with other intermediate operations like "filter", "distinct", and "sorted" to build complex
      pipelines.
    - Output: [A, B, C]
    */
    list = List.of("A", "B", "C");
    List<Character> charList = list.stream()
            .map(x -> x.charAt(0))
            .toList();
    IO.println(charList);

    /*
    Map Multi
    - The "mapMulti" method is an intermediate operation that allows each element of the stream to produce zero, one, or
      multiple elements in the resulting stream.
    - Useful for expanding, flattening, or duplicating elements without creating nested streams.
    - The method accepts a BiConsumer where the first parameter is the input element and the second is a consumer to
      emit results.
    - Works with both sequential and parallel streams.
    - Related methods: "map" (produces exactly one output per input) and "flatMap" (produces streams that are
      flattened).
    - Output: [1, 10, 2, 20, 3, 30]
    */
    intList = List.of(1, 2, 3);
    List<Integer> intResultList = intList.stream()
            .<Integer>mapMulti((x, consumer) -> {
                consumer.accept(x);
                consumer.accept(x * 10);
            })
            .toList();
    IO.println(intResultList);

    /*
    Flat Map
    - The "flatMap" method is an intermediate operation that replaces each element of the stream with a stream produced
      by a provided mapping function, then flattens the resulting streams into a single stream.
    - Useful for flattening nested structures, such as lists of lists, or for expanding elements into multiple outputs.
    - Works with both sequential and parallel streams.
    - Related methods: "map" (produces exactly one output per input) and "mapMulti" (can produce zero, one, or multiple
      outputs per input without creating nested streams).
    - Output: [A, B, C, D]
    */
    List<List<String>> deepList = List.of(List.of("A", "B"), List.of("C", "D"));
    result = deepList.stream()
            .flatMap(x -> x.stream())
            .toList();
    IO.println(result);

    /*
    Distinct
    - The "distinct" method is an intermediate operation that returns a stream consisting of the unique elements of the
      original stream, removing duplicates.
    - Useful for filtering out repeated values and ensuring each element appears only once.
    - Works with both sequential and parallel streams.
    - Relies on the "equals" and "hashCode" methods of elements to determine uniqueness.
    - Can be chained with other intermediate operations like "filter", "map", or "sorted" for more complex pipelines.
    - Output: [A, B, C]
    */
    list = List.of("A", "A", "B", "B", "C", "C");
    result = list.stream()
            .distinct()
            .toList();
    IO.println(result);

    /*
    Sort
    - The "sorted" method is an intermediate operation that returns a stream with elements sorted according to their
      natural order or a provided Comparator.
    - Useful for ordering elements in ascending or custom-defined order before performing further processing or
      collection.
    - Works with both sequential and parallel streams.
    - Can accept an overload: "sorted(Comparator<? super T> comparator)" for custom sorting logic.
    - Can be chained with other intermediate operations like "filter", "map", or "distinct".
    - Output: [A, B, C]
    */
    list = List.of("C", "B", "A");
    result = list.stream()
            .sorted()
            .toList();
    IO.println(result);

    /*
    Limit
    - The "limit" method is an intermediate operation that returns a stream consisting of no more than the given number
      of elements from the original stream.
    - Useful for restricting the size of the stream, such as taking the first N elements or implementing pagination.
    - Works with both sequential and parallel streams.
    - Short-circuiting: stops processing once the limit is reached, which can improve performance in large streams.
    - Can be chained with other intermediate operations like "filter", "distinct", or "sorted".
    - Output: [A, B, C]
    */
    list = List.of("A", "B", "C", "Y", "Z");
    result = list.stream()
            .limit(3)
            .toList();
    IO.println(result);

    /*
    Skip
    - The "skip" method is an intermediate operation that returns a stream consisting of the remaining elements of the
      original stream after discarding the first n elements.
    - Useful for skipping over elements, such as implementing pagination or ignoring a prefix of a stream.
    - Works with both sequential and parallel streams.
    - Short-circuiting: discards elements efficiently without processing them further.
    - Can be chained with other intermediate operations like "filter", "limit", or "sorted".
    - Output: [A, B, C]
    */
    list = List.of("Y", "Z", "A", "B", "C");
    result = list.stream()
            .skip(2)
            .toList();
    IO.println(result);

    /*
    Take While
    - The "takeWhile" method is an intermediate operation that returns a stream consisting of elements from the start of the original stream while the given predicate remains true.
    - Useful for processing a prefix of elements that meet a condition and stopping as soon as an element does not match.
    - Works only with sequential streams (in parallel streams the behavior is not well-defined for encounter order).
    - Short-circuiting: stops processing once the predicate returns false.
    - Output: [A, B, C]
    */
    list = List.of("A", "B", "C", "Y", "Z");
    result = list.stream()
            .takeWhile(x -> x.equals("Y"))
            .toList();
    IO.println(result);

    /*
    Drop While
    - The "dropWhile" method is an intermediate operation that returns a stream consisting of the remaining elements
      after discarding elements from the start of the original stream while the given predicate is true.
    - Useful for skipping a prefix of elements that meet a condition.
    - Stops discarding as soon as an element does not satisfy the predicate.
    - Works with sequential streams; in parallel streams, encounter order may not be preserved.
    - Output: [A, B, C]
    */
    list = List.of("Z", "Z", "A", "B", "C");
    result = list.stream()
            .dropWhile(x -> x.equals("Z"))
            .toList();
    IO.println(result);

    /*
    Parallel
    - The "parallel" method converts a sequential stream into a parallel stream, allowing elements to be processed
      concurrently using multiple threads.
    - Useful for improving performance on large datasets or computationally intensive operations.
    - Works with all intermediate and terminal operations, but encounter order is not guaranteed unless using
      "forEachOrdered" or other order-preserving operations.
    - Be cautious with side effects, as operations may execute in any order across threads.
    - Related methods: "sequential()" (converts back to sequential stream).
    - Output: C | A | B (order may vary due to parallel execution)
    */
    list = List.of("A", "B", "C");
    list.stream()
            .parallel()
            .forEach(IO::println);

    /*
    Sequential
    - The "sequential" method converts a parallel stream back into a sequential stream, ensuring that elements are
      processed in encounter order.
    - Useful for guaranteeing order-sensitive operations after a parallel stream or for consistent single-threaded
      processing.
    - Works with all intermediate and terminal operations.
    - Related method: "parallel()" (converts a sequential stream into parallel).
    - Output: A | B | C
    */
    list = List.of("A", "B", "C");
    list.stream()
            .parallel()
            .sequential()
            .forEach(IO::println);

    /*
    Unordered
    - The "unordered" method is an intermediate operation that signals that the stream's encounter order can be ignored.
    - Useful for performance optimization in parallel streams when the order of elements does not matter.
    - Works with both sequential and parallel streams, but benefits are more noticeable in parallel streams.
    - Does not modify the elements; it only relaxes ordering constraints for certain operations like "forEach",
      "collect", or "reduce".
    - Related methods: "forEachOrdered" (preserves encounter order even in parallel streams).
    - Output: C | A | B (order may vary due to parallel execution and unordered hint)
    */
    list = List.of("A", "B", "C");
    list.stream()
            .parallel()
            .unordered()
            .forEach(IO::println);

    /*
    Peek
    - The "peek" method is an intermediate operation that allows performing an action on each element of the stream as
      it passes through, mainly for debugging or logging purposes.
    - Does not consume the elements or produce a new collection; it returns a stream consisting of the same elements.
    - Useful for observing the elements in a pipeline without modifying them.
    - Works with both sequential and parallel streams.
    - Should not be used for modifying the elements; side effects can lead to unexpected behavior.
    - Output: (nothing is printed because the stream is not consumed)
    */
    list = List.of("A", "B", "C");
    list.stream()
            .peek(IO::println);

    //==================================================================================================================
    // Convert to Primitive Streams
    //==================================================================================================================

    /*
    Map to Int
    - The "mapToInt" method is an intermediate operation that converts a Stream of objects into an IntStream by applying
      a function that produces an int for each element.
    - Useful for performing numeric operations such as sum, average, min, max, or other reductions.
    - Related methods: "mapToLong" and "mapToDouble" for other primitive streams.
    - The "boxed" method converts the primitive IntStream back into a Stream<Integer>, which allows collection into
      Lists or use with APIs requiring objects.
    - Works with both sequential and parallel streams.
    - In this example, the IntStream is consumed by the terminal operation "sum()" to produce the total of all elements.
    - Output: 6
    */
    intList = List.of(1, 2, 3);
    sum = intList.stream()
            .mapToInt(x -> x)
            .sum();
    IO.println(sum);

    /*
    Map to Long
    - The "mapToLong" method is an intermediate operation that converts a Stream of objects into a LongStream by
      applying a function that produces a long for each element.
    - Useful for performing numeric operations such as sum, average, min, max, or other reductions on long values.
    - Related methods: "mapToInt" and "mapToDouble" for other primitive streams.
    - The "boxed" method converts the primitive LongStream back into a Stream<Long>, which allows collection into Lists
      or use with APIs requiring objects.
    - Works with both sequential and parallel streams.
    - In this example, the LongStream is consumed by the terminal operation "sum()" to produce the total of all
      elements.
    - Output: 6
    */
    intList = List.of(1, 2, 3);
    long longSum = intList.stream()
            .mapToLong(x -> x)
            .sum();
    IO.println(longSum);

    /*
    Map to Double
    - The "mapToDouble" method is an intermediate operation that converts a Stream of objects into a DoubleStream by
      applying a function that produces a double for each element.
    - Useful for performing numeric operations such as sum, average, min, max, or other reductions on double values.
    - Related methods: "mapToInt" and "mapToLong" for other primitive streams.
    - The "boxed" method converts the primitive DoubleStream back into a Stream<Double>, which allows collection into
      Lists or use with APIs requiring objects.
    - Works with both sequential and parallel streams.
    - In this example, the DoubleStream is consumed by the terminal operation "sum()" to produce the total of all
      elements.
    - Output: 6.0
    */
    intList = List.of(1, 2, 3);
    double doubleSum = intList.stream()
            .mapToDouble(x -> x)
            .sum();
    IO.println(doubleSum);

    /*
    Flat Map To Int
    - The "flatMapToInt" method is an intermediate operation that replaces each element of a Stream with an IntStream
      produced by a provided mapping function, then flattens the resulting IntStreams into a single IntStream.
    - Useful for flattening nested structures while directly performing numeric operations on int values.
    - Related methods: "flatMap", "flatMapToLong", and "flatMapToDouble".
    - The "boxed" method can be used to convert the resulting IntStream into a Stream<Integer> for collection into Lists
      or use with APIs requiring objects.
    - Works with both sequential and parallel streams.
    - In this example, the IntStream is consumed by the terminal operation "sum()" to produce the total of all elements.
    - Output: 10
    */
    List<List<Integer>> intDeepList = List.of(List.of(1, 2), List.of(3, 4));
    sum = intDeepList.stream()
            .flatMapToInt(x -> x.stream().mapToInt(y -> y))
            .sum();
    IO.println(sum);

    /*
    Flat Map To Long
    - The "flatMapToLong" method is an intermediate operation that replaces each element of a Stream with a LongStream
      produced by a provided mapping function, then flattens the resulting LongStreams into a single LongStream.
    - Useful for flattening nested structures while directly performing numeric operations on long values.
    - Related methods: "flatMap", "flatMapToInt", and "flatMapToDouble".
    - The "boxed" method can be used to convert the resulting LongStream into a Stream<Long> for collection into Lists
      or use with APIs requiring objects.
    - Works with both sequential and parallel streams.
    - In this example, the LongStream is consumed by the terminal operation "sum()" to produce the total of all
      elements.
    - Output: 10
    */
    intDeepList = List.of(List.of(1, 2), List.of(3, 4));
    longSum = intDeepList.stream()
            .flatMapToLong(x -> x.stream().mapToLong(y -> y))
            .sum();
    IO.println(sum);

    /*
    Flat Map To Double
    - The "flatMapToDouble" method is an intermediate operation that replaces each element of a Stream with a
      DoubleStream produced by a provided mapping function, then flattens the resulting DoubleStreams into a single
      DoubleStream.
    - Useful for flattening nested structures while directly performing numeric operations on double values.
    - Related methods: "flatMap", "flatMapToInt", and "flatMapToLong".
    - The "boxed" method can be used to convert the resulting DoubleStream into a Stream<Double> for collection into
      Lists or use with APIs requiring objects.
    - Works with both sequential and parallel streams.
    - In this example, the DoubleStream is consumed by the terminal operation "sum()" to produce the total of all
      elements.
    - Output: 10.0
    */
    intDeepList = List.of(List.of(1, 2), List.of(3, 4));
    doubleSum = intDeepList.stream()
            .flatMapToDouble(x -> x.stream().mapToDouble(y -> y))
            .sum();
    IO.println(sum);

    /*
    Map Multi to Int
    - The "mapMultiToInt" method is an intermediate operation that allows mapping each element of a Stream to zero or
      more int values using a BiConsumer, then flattens them into a single IntStream.
    - Useful for generating multiple numeric values from a single element, performing numeric transformations, or
      expanding elements for aggregation.
    - Related methods: "mapMulti" (produces a Stream of objects), "mapMultiToLong", and "mapMultiToDouble".
    - In this example, each element is emitted three times using "consumer.accept", and the resulting IntStream is
      consumed by the terminal operation "sum()" to produce the total of all emitted values.
    - Works with both sequential and parallel streams.
    - Output: 3
    */
    intList = List.of(1);
    sum = intList.stream()
            .mapMultiToInt((x, consumer) -> {
                consumer.accept(x); // each element emitted three times
                consumer.accept(x);
                consumer.accept(x);
            })
            .sum();
    IO.println(sum);

    /*
    Map Multi to Long
    - The "mapMultiToLong" method is an intermediate operation that allows mapping each element of a Stream to zero or
      more long values using a BiConsumer, then flattens them into a single LongStream.
    - Useful for expanding elements into multiple long values, performing numeric transformations, or preparing data for
      aggregation operations such as sum, average, min, or max.
    - Related methods: "mapMulti" (object stream), "mapMultiToInt", and "mapMultiToDouble".
    - In this example, the single element is emitted three times via "consumer.accept", and the resulting LongStream is
      reduced using the terminal operation "sum()".
    - Works with both sequential and parallel streams.
    - Output: 3
    */
    intList = List.of(1);
    longSum = intList.stream()
            .mapMultiToLong((x, consumer) -> {
                consumer.accept(x); // each element emitted three times
                consumer.accept(x);
                consumer.accept(x);
            })
            .sum();
    IO.println(sum);

    /*
    Map Multi to Double
    - The "mapMultiToDouble" method is an intermediate operation that maps each element of a Stream to zero or more
      double values using a BiConsumer, flattening them into a single DoubleStream.
    - It is useful when one input element may correspond to multiple numeric outputs, enabling flexible expansion
      and transformation without creating intermediate collections.
    - Commonly combined with terminal operations such as sum, average, min, or max for numeric aggregation.
    - Related methods: "mapMulti" (object stream), "mapMultiToInt", and "mapMultiToLong".
    - In this example, the single element is emitted three times, and the resulting DoubleStream is reduced using
      "sum()".
    - Works with both sequential and parallel streams.
    - Output: 3.0
    */
    intList = List.of(1);
    doubleSum = intList.stream()
            .mapMultiToDouble((x, consumer) -> {
                consumer.accept(x); // each element emitted three times
                consumer.accept(x);
                consumer.accept(x);
            })
            .sum();
    IO.println(sum);
}
