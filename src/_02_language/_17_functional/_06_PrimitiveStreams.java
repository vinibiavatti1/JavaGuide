/*
Primitive Streams
- This section explains the primitive streams in Java, which provide specialized Stream implementations for primitive
  types: IntStream, LongStream, and DoubleStream. These streams avoid boxing overhead, improving performance for numeric
  processing.

Overview
- IntStream, LongStream, and DoubleStream are part of the java.util.stream package.
- They support both intermediate and terminal operations, similar to regular object streams, but operate on
  primitive values directly.
- Introduced in Java 8 to optimize numeric computations and reduce memory overhead caused by wrapper objects.

Key Characteristics
- Provides specialized numeric operations like sum(), average(), min(), max(), summaryStatistics(), and more.
- Can be created from arrays (IntStream.of(...)), ranges (IntStream.range(...)), or collections converted via mapTo
  methods.
- Supports sequential and parallel processing.
- Allows flatMapToInt, flatMapToLong, flatMapToDouble, and mapMultiToInt/Long/Double for advanced numeric
  transformations.

Conversion (Wrapper Stream <-> Primitive Stream)
- The wrapper stream (Stream) can be converted to a primitive stream, and vice versa:
  - Stream to Primitive Stream: mapToInt(), flatMapToInt(), mapMultiToInt(), ...
  - Primitive Stream to Stream: boxed()

Notes
- This document only covers the methods specific to primitive streams. All other generic Stream API methods are
  described in the main Stream API documentation.

Usage
- Use primitive streams when processing numeric data for better performance and lower memory overhead.
- Ideal for aggregation, summarization, mathematical operations, or analytics on int, long, or double values.
- Convert between object streams and primitive streams when needed using mapTo and boxed methods.
- Works seamlessly with other Stream API operations like filter, map, reduce, and collect.
*/
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declaration with Fixed Set of Values
    - Creates an IntStream containing the specified int values using the "IntStream.of" factory method.
    - This is a primitive stream, which avoids boxing overhead compared to "Stream<Integer>".
    - Useful for numeric processing such as sum, average, min, max, and other mathematical operations.
    - Similar factory methods exist for other primitive streams: "LongStream.of" and "DoubleStream.of".
    - Commonly used for small, fixed datasets or examples and tests.
    - Output: Primitive stream containing [1, 2, 3]
    */
    IntStream stream = IntStream.of(1, 2, 3);

    /*
    Declaration with Range
    - Creates an IntStream that produces a sequence of int values within the specified range.
    - The start value is inclusive, and the end value is exclusive.
    - Useful for iteration, indexing, and numeric loops without explicit counters.
    - For an inclusive end value, use "IntStream.rangeClosed".
    - Similar range methods exist only for IntStream and LongStream.
    - Output: Primitive stream containing [1, 2, 3]
    */
    stream = IntStream.range(1, 4);

    /*
    Empty Declaration
    - Creates an empty IntStream with no elements using the "IntStream.empty" factory method.
    - Useful as a safe default for numeric streams when no values are available.
    - Avoids returning null and allows stream pipelines to be composed consistently.
    - Terminal operations on this stream complete immediately (e.g., sum returns 0, count returns 0).
    - Commonly used in APIs that conditionally produce numeric streams.
    - Output: empty stream
    */
    stream = IntStream.empty();

    //==================================================================================================================
    // Conversion (Wrapper Stream <-> Primitive Stream)
    //==================================================================================================================

    /*
    Stream to Primitive Stream
    - The "mapToInt" method converts a Stream of objects (e.g., Stream<Integer>) into an IntStream by applying
      a function that produces a primitive int for each element.
    - Useful for performing numeric operations like sum, average, min, max, or other reductions without boxing overhead.
    - Other conversion methods are: "flatMapToInt", "mapMultiToInt".
    - Allows interoperability between object streams and primitive streams, enabling efficient numeric processing.
    - Output: IntStream containing [1, 2, 3]
    */
    IntStream primitiveStream = Stream.of(1, 2, 3).mapToInt(x -> x);

    /*
    Primitive Stream to Wrapper Stream (Boxed)
    - The "boxed" method converts a primitive stream (IntStream, LongStream, DoubleStream) into a Stream of the
      corresponding wrapper type (Integer, Long, Double).
    - Useful for interoperability with APIs that require object streams, Collections, or generic types.
    - Allows further operations like collect, map, or filter that expect object streams.
    - Works with both sequential and parallel streams.
    - Output: Stream<Integer>
    */
    Stream<Integer> wrapperStream = IntStream.of(1, 2, 3).boxed();

    //==================================================================================================================
    // Terminal Operations
    //==================================================================================================================

    /*
    Sum
    - The "sum" method is a terminal operation on an IntStream that calculates the sum of all elements.
    - Useful for quickly aggregating numeric data without writing explicit loops.
    - Similar methods exist for LongStream ("sum()") and DoubleStream ("sum()").
    - Works with both sequential and parallel streams.
    - Output: 6
    */
    int sum = IntStream.of(1, 2, 3).sum();
    IO.println(sum);

    /*
    Average
    - The "average" method is a terminal operation on an IntStream that computes the arithmetic mean of all elements.
    - Returns an OptionalDouble to handle the case where the stream is empty.
    - Useful for quickly calculating averages without manual summing and counting.
    - Similar methods exist for LongStream ("average()") and DoubleStream ("average()").
    - Works with both sequential and parallel streams.
    - Output: 2.5
    */
    OptionalDouble optionalAvg = IntStream.of(1, 2, 3, 4).average();
    optionalAvg.ifPresent(IO::println);

    /*
    Summary Statistics
    - The "summaryStatistics" method is a terminal operation on an IntStream that collects count, sum, min, max,
      and average into an IntSummaryStatistics object.
    - Provides a convenient way to compute multiple summary metrics in a single pass over the data.
    - Similar methods exist for LongStream ("summaryStatistics()") and DoubleStream ("summaryStatistics()").
    - Useful for reporting, analytics, or aggregation without multiple terminal operations.
    - Works with both sequential and parallel streams.
    */
    IntSummaryStatistics statistics = IntStream.of(1, 2, 3, 4).summaryStatistics();
    IO.println(statistics.getSum());     // 10
    IO.println(statistics.getMin());     // 1
    IO.println(statistics.getMax());     // 4
    IO.println(statistics.getAverage()); // 2.5
    IO.println(statistics.getCount());   // 4

    //==================================================================================================================
    // Conversion To Other Primitive Streams
    //==================================================================================================================

    /*
    Long Stream
    - The "asLongStream" method converts an IntStream into a LongStream, widening each int element to a long.
    - Output: LongStream
    */
    LongStream longStream = IntStream.of(1, 2, 3).asLongStream();

    /*
    Double Stream
    - The "asDoubleStream" method converts an IntStream into a DoubleStream, widening each int element to a double.
    - Output: DoubleStream
    */
    DoubleStream doubleStream = IntStream.of(1, 2, 3).asDoubleStream();
}