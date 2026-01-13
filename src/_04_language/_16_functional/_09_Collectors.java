/*
Collectors
- This section explains the "Collectors" utility class in Java, which provides static methods to create common Collector
  instances for use with the Stream API, including collection, reduction, summarization, grouping, and string joining
  operations.

Overview
- The "Collectors" class is part of the java.util.stream package.
- It contains static factory methods that return Collector instances, which can be passed to the Stream.collect()
  terminal operation to produce a desired result.
- Introduced in Java 8 alongside the Stream API to simplify common aggregation and collection tasks.

Key Characteristics
- All methods are static; no need to create a Collectors instance.
- Provides collectors for converting streams to Lists, Sets, Maps, and other Collections.
- Includes reduction collectors such as counting(), summingInt(), averagingDouble(), summarizingInt(), minBy(), and
  maxBy().
- Supports advanced grouping and partitioning operations with groupingBy(), groupingByConcurrent() and partitioningBy().
- Offers collectors for joining elements into Strings with delimiters, prefixes, and suffixes.
- Some operations that exist as terminal functions in the Stream API (like reduce, min, max) are also available as
  collectors to integrate naturally with collect().

Usage
- Use Collectors to perform common stream aggregation, grouping, partitioning, or summarization tasks in a
  concise and readable way.
- Ideal for converting streams to collections, computing sums, averages, or statistics, and joining elements
  into strings.
- Apply when you need to combine multiple stream operations into a single collect() call, often avoiding intermediate
  loops or manual accumulation.
- Most common collection and aggregation cases in Java streams can be solved using the utilities in Collectors.
*/
void main() {
    //==================================================================================================================
    // List Collectors
    //==================================================================================================================

    /*
    Collect To List
    - "Collectors.toList()" collects the elements of a stream into a new, modifiable List instance.
    - The resulting List allows adding, removing, or updating elements.
    - If an unmodifiable list is desired, "Collectors.toUnmodifiableList()" can be used instead, which returns a
      List that throws UnsupportedOperationException on modification attempts.
    - Note: Since Java 16, streams also provide a "toList()" method directly (Stream.toList()) that returns an
      unmodifiable List, which is a simpler alternative when a modifiable list is not required.
    - Useful for converting a stream into a standard Java List for further processing or API interoperability.
    - Works with both sequential and parallel streams.
    - Output: [A, B, C]
    */
    List<String> resultList = Stream.of("A", "B", "C").collect(Collectors.toList());
    IO.println(resultList);

    //==================================================================================================================
    // Set Collectors
    //==================================================================================================================

    /*
    Collect To Set
    - "Collectors.toSet()" collects the elements of a stream into a new Set instance.
    - Duplicate elements in the stream are automatically removed, as Sets do not allow duplicates.
    - The resulting Set is modifiable by default; elements can be added or removed.
    - If an unmodifiable set is desired, "Collectors.toUnmodifiableSet()" can be used instead, which returns a
      Set that throws UnsupportedOperationException on modification attempts.
    - Note: Streams also provide "toSet()" in some contexts, but "Collectors.toSet()" remains the standard way
      to collect into a modifiable Set.
    - Useful for obtaining a collection of unique elements from a stream.
    - Works with both sequential and parallel streams.
    - Output: [A, B, C]
    */
    Set<String> resultSet = Stream.of("A", "A", "B", "B", "C", "C").collect(Collectors.toSet());
    IO.println(resultSet);

    //==================================================================================================================
    // Map Collectors
    //==================================================================================================================

    /*
    Collect To Map
    - "Collectors.toMap()" collects the elements of a stream into a Map by specifying key and value mapping functions.
    - The first argument is the key mapper, and the second argument is the value mapper.
    - By default, the resulting Map is a HashMap and is modifiable.
    - If an unmodifiable map is desired, "Collectors.toUnmodifiableMap()" can be used, which returns a Map that throws
      UnsupportedOperationException on modification attempts.
    - For parallel streams or concurrent scenarios, "Collectors.toConcurrentMap()" can be used to produce a thread-safe
      Map.
    - Note: If duplicate keys are generated by the key mapper, a runtime exception (IllegalStateException) will occur
      unless a merge function is provided as a third argument to handle collisions.
    - Useful for converting streams into key-value mappings, aggregating data, or preparing data for fast lookups.
    - Works with both sequential and parallel streams.
    - Output: {pc=2, ssd=1}
    */
    record Item(String name, int quantity) {}
    Map<String, Integer> resultMap = Stream.of(
            new Item("pc", 2),
            new Item("ssd", 1)
    ).collect(Collectors.toMap(
            Item::name,    // Key Mapper (Function)
            Item::quantity // Value Mapper (Function)
    ));
    IO.println(resultMap);

    /*
    Collect To Map with Merge Function and Map Factory
    - "Collectors.toMap()" can also accept a merge function and a map supplier (Map factory) as additional arguments.
    - The first argument is the key mapper, and the second is the value mapper.
    - The third argument, the merge function, defines how to handle duplicate keys. In this example, "Integer::sum"
      adds the values of duplicate keys.
    - The fourth argument, the map factory, specifies which Map implementation to use. Here, "HashMap::new" is used.
    - Useful for aggregating values for duplicate keys, creating custom Map types, or controlling concurrency.
    - Note: Without a merge function, duplicate keys would cause an IllegalStateException at runtime.
    - Works with both sequential and parallel streams.
    - Output: {pc=5, ssd=1}
    */
    resultMap = Stream.of(
            new Item("pc", 2),
            new Item("ssd", 1),
            new Item("pc", 3)
    ).collect(Collectors.toMap(
            Item::name,     // Key Mapper (Function)
            Item::quantity, // Value Mapper (Function)
            Integer::sum,   // Merge Function (BinaryOperator)
            HashMap::new    // Map Factory (Supplier)
    ));
    IO.println(resultMap);

    //==================================================================================================================
    // Custom Collection Factory
    //==================================================================================================================

    /*
    Collect with Custom Collection Factory
    - "Collectors.toCollection()" collects the elements of a stream into a Collection provided by a custom collection
      factory.
    - The factory is a Supplier that creates a new instance of the desired Collection type. In this example,
      "LinkedList::new" produces a LinkedList.
    - Useful when a specific Collection implementation is required, such as LinkedList, ArrayDeque, or any custom
      Collection.
    - Unlike "toList()" or "toSet()", this method allows full control over the collection type and its behavior.
    - Works with both sequential and parallel streams.
    - Output: [A, B, C]
    */
    LinkedList<String> resultLinkedList = Stream.of("A", "B", "C").collect(Collectors.toCollection(LinkedList::new));
    IO.println(resultLinkedList);

    //==================================================================================================================
    // String Concatenation
    //==================================================================================================================

    /*
    Collect to a Single String with Delimiter
    - "Collectors.joining()" concatenates the elements of a stream into a single String.
    - A delimiter can be provided to separate each element. In this example, "," is used.
    - Optional prefix and suffix can also be provided to enclose the resulting string.
    - Useful for creating CSV-like outputs, formatting lists, or generating custom string representations from stream
      elements.
    - Works with both sequential and parallel streams.
    - Output: {A, B, C}
    */
    String resultStr = Stream.of("A", "B", "C").collect(Collectors.joining(", ", "{", "}"));
    IO.println(resultStr);

    //==================================================================================================================
    // Reduction
    //==================================================================================================================

    /*
    Reduce to Sum Value
    - "Collectors.summingInt()" performs a summing reduction on the elements of a stream using an int-valued function.
    - The collector applies the function to each element and returns the total sum as an int.
    - Related collectors include "Collectors.summingLong()" for long values and "Collectors.summingDouble()" for double
      values.
    - Useful for calculating totals, aggregating numeric data, or combining values from objects.
    - Works with both sequential and parallel streams.
    - Output: 6
    */
    int sum = Stream.of(1, 2, 3).collect(Collectors.summingInt(Integer::intValue));
    IO.println(sum);

    /*
    Reduce to Average Value
    - "Collectors.averagingDouble()" performs an averaging reduction on the elements of a stream using a double-valued
      function.
    - The collector applies the function to each element and returns the average as a double.
    - Related collectors include "Collectors.averagingInt()" for int values and "Collectors.averagingLong()" for long
      values.
    - Useful for calculating averages, metrics, or summarizing numeric data in a stream.
    - Works with both sequential and parallel streams.
    - Output: 2.5
    */
    double avg = Stream.of(1, 2, 3, 4).collect(Collectors.averagingDouble(Integer::intValue));
    IO.println(avg);

    /*
    Reduce to Summary Statistics
    - "Collectors.summarizingInt()" performs a reduction that collects statistics, producing an IntSummaryStatistics
      object.
    - This collector computes count, sum, min, average, and max in a single pass over the stream.
    - Related collectors include "summarizingLong()" and "summarizingDouble()" for long and double streams.
    - This is equivalent to the "summaryStatistics()" method available on Primitive Streams.
    - Useful for obtaining a quick summary of numeric data in streams without multiple passes.
    */
    IntSummaryStatistics statistics = Stream.of(1, 2, 3, 4).collect(Collectors.summarizingInt(Integer::intValue));
    IO.println(statistics.getSum());     // 10
    IO.println(statistics.getMin());     // 1
    IO.println(statistics.getMax());     // 4
    IO.println(statistics.getAverage()); // 2.5
    IO.println(statistics.getCount());   // 4

    /*
    Reduce to Min Value
    - "Collectors.minBy()" performs a reduction that returns an Optional describing the minimum element of the stream
      according to the provided Comparator.
    - Useful for finding the smallest element based on natural ordering or custom comparison logic.
    - Returns an Optional, so methods like "ifPresent", "orElse", or "orElseThrow" can be used to safely handle the
      result.
    - Related collector: "maxBy()" returns the maximum element according to the Comparator.
    - Works with both sequential and parallel streams.
    - Output: A
    */
    Optional<String> optionalMin = Stream.of("A", "B", "C").collect(Collectors.minBy(Comparator.naturalOrder()));
    optionalMin.ifPresent(IO::println);

    /*
    Reduce to Max Value
    - "Collectors.maxBy()" performs a reduction that returns an Optional describing the maximum element of the stream
      according to the provided Comparator.
    - Useful for finding the largest element based on natural ordering or custom comparison logic.
    - Returns an Optional, so methods like "ifPresent", "orElse", or "orElseThrow" can be used to safely handle the
      result.
    - Related collector: "minBy()" returns the minimum element according to the Comparator.
    - Works with both sequential and parallel streams.
    - Output: C
    */
    Optional<String> optionalMax = Stream.of("A", "B", "C").collect(Collectors.maxBy(Comparator.naturalOrder()));
    optionalMax.ifPresent(IO::println);

    /*
    Reduce to Count Value
    - "Collectors.counting()" performs a reduction that returns the count of elements in the stream.
    - Useful for determining the total number of elements, including after filtering or mapping operations.
    - Returns a long representing the number of elements in the stream.
    - Works with both sequential and parallel streams.
    - Output: 3
    */
    long count = Stream.of("A", "B", "C").collect(Collectors.counting());
    IO.println(count);

    /*
    Reduce with Custom Operation
    - "Collectors.reducing()" performs a reduction of the stream elements using a custom accumulator function.
    - The first argument is the identity (initial value) for the reduction, and the second is the accumulator function
      that combines the current result with each element.
    - Useful for custom aggregation logic that is not covered by built-in collectors like summingInt or joining.
    - Returns a value of the same type as the identity.
    - Works with both sequential and parallel streams.
    - Note: This works the same as "reduce()" method of the Stream API.
    - Output: 6
    */
    sum = Stream.of(1, 2, 3).collect(Collectors.reducing(
            0,           // Initial Value
            Integer::sum // Accumulator Function (BinaryOperator)
    ));
    IO.println(sum);

    //==================================================================================================================
    // Downstream Transformations (Same as intermediate operations)
    //==================================================================================================================

    /*
    Apply Filter and Collect
    - "Collectors.filtering()" applies a predicate to each element of the stream and collects only the elements that
      match the predicate using a downstream collector.
    - The first argument is a Predicate that determines which elements are included.
    - The second argument is a downstream Collector that defines how the filtered elements are collected.
    - Useful for combining filtering and collection in a single terminal operation, avoiding intermediate streams.
    - Works with both sequential and parallel streams.
    - Note: This works the same as "filter()" method of the Stream API.
    - Output: [B]
    */
    resultList = Stream.of("A", "B", "C").collect(Collectors.filtering(
            x -> x.equals("B"), // Filter (Predicate)
            Collectors.toList() // Collector
    ));
    IO.println(resultList);

    /*
    Apply Mapping and Collect
    - "Collectors.mapping()" applies a mapping function to each element of the stream and collects the results using a
      downstream collector.
    - The first argument is a Function that transforms each element.
    - The second argument is a downstream Collector that defines how the mapped elements are collected.
    - Useful for combining transformation and collection in a single terminal operation, avoiding intermediate streams.
    - Works with both sequential and parallel streams.
    - Note: This works the same as "map()" method of the Stream API.
    - Output: [a, b, c]
    */
    resultList = Stream.of("A", "B", "C").collect(Collectors.mapping(
            String::toLowerCase, // Mapper (Function)
            Collectors.toList()  // Collector
    ));
    IO.println(resultList);

    /*
    Apply Flat Mapping and Collect
    - "Collectors.flatMapping()" applies a function to each element of the stream that produces a stream, then flattens
      all resulting streams into a single stream before collecting with a downstream collector.
    - The first argument is a Function that maps each element to a Stream.
    - The second argument is a downstream Collector that defines how the flattened elements are collected.
    - Useful for flattening nested structures while simultaneously collecting the results in one step.
    - Works with both sequential and parallel streams.
    - Note: This works the same as "flatMap()" method of the Stream API.
    - Output: [A, B, C, D]
    */
    resultList = Stream.of(List.of("A", "B"), List.of("C", "D")).collect(Collectors.flatMapping(
            List::stream,       // Function
            Collectors.toList() // Collector
    ));
    IO.println(resultList);

    //==================================================================================================================
    // Group By (Map<K, List<V>>)
    //==================================================================================================================

    /*
    Group By
    - "Collectors.groupingBy()" groups elements of a stream by a classifier function into a Map.
    - The resulting Map has keys of type K (from the classifier) and value of type List<V> by default (Map<K, List<V>>).
    - A downstream collector can be provided to customize how the grouped values are collected instead of the default
      List.
    - For concurrent or parallel processing, "Collectors.groupingByConcurrent()" can be used to produce a thread-safe
      ConcurrentMap.
    - Useful for categorizing data, performing aggregations per group, or organizing elements by a common key.
    - Works with both sequential and parallel streams.
    - Output: {
        pc=[Item[name=pc, quantity=2]],
        ssd=[Item[name=ssd, quantity=1]]
      }
    */
    Map<String, List<Item>> groupedResult = Stream.of(
            new Item("pc", 2),
            new Item("ssd", 1)
    ).collect(Collectors.groupingBy(
            Item::name // Key Mapper (Function)
    ));
    IO.println(groupedResult);

    //==================================================================================================================
    // Partition By (Map<Boolean, List<V>>)
    //==================================================================================================================

    /*
    Partition By
    - "Collectors.partitioningBy()" partitions the elements of a stream into a Map<Boolean, List<V>> according
      to a given predicate.
    - The resulting Map has keys of type Boolean and value of type List<V> by default (Map<Boolean, List<V>>).
    - Elements that match the predicate are collected under the key true, and those that do not match are collected
      under the key false.
    - A downstream collector can be provided to customize how the partitioned values are collected instead of the
      default List.
    - Useful for dividing data into two groups based on a condition, such as filtering admins vs non-admins.
    - Works with both sequential and parallel streams.
    - Output: {
        false=[User[name=John, isAdmin=false], User[name=Robert, isAdmin=false]],
        true=[User[name=Anna, isAdmin=true]]
      }
    */
    record User(String name, boolean isAdmin) {}
    Map<Boolean, List<User>> partitionedResult = Stream.of(
            new User("Anna", true),
            new User("John", false),
            new User("Robert", false)
    ).collect(Collectors.partitioningBy(
            User::isAdmin // Filter (Predicate)
    ));
    IO.println(partitionedResult);

    //==================================================================================================================
    // Composite Collections
    //==================================================================================================================

    /*
    Collect and Apply Function
    - "Collectors.collectingAndThen()" performs a collection using a downstream collector and then applies a finishing
      function to the result.
    - The first argument is a Collector that defines how the elements are initially collected.
    - The second argument is a Function that transforms the collected result, e.g., making a List unmodifiable.
    - Useful for performing post-processing on the collected result in a single, fluent operation.
    - Works with both sequential and parallel streams.
    - Output: [A, B, C] (unmodifiable)
    */
    resultList = Stream.of("A", "B", "C").collect(Collectors.collectingAndThen(
            Collectors.toList(),          // Collect
            Collections::unmodifiableList // And then apply function
    ));
    IO.println(resultList);

    /*
    Collect with Two Collectors (In Parallel)
    - "Collectors.teeing()" performs a collection using two downstream collectors in parallel and then combines their
      results using a merger function.
    - The first and second arguments are the downstream collectors whose results will be computed simultaneously.
    - The third argument is a BiFunction that merges the results of the two collectors into a single result.
    - Useful for computing multiple aggregations in a single pass over the stream, e.g., sum and average.
    - Works with both sequential and parallel streams.
    - Output: 6 / 2.0
    */
    resultStr = Stream.of(1, 2, 3).collect(Collectors.teeing(
            Collectors.summingInt(Integer::intValue),
            Collectors.averagingDouble(Integer::intValue),
            (sumResult, avgResult) -> sumResult + " / " + avgResult
    ));
    IO.println(resultStr);

    //==================================================================================================================
    // Custom Collector
    //==================================================================================================================

    /*
    Custom Collector Example
    - "Collector.of()" allows creating a fully custom collector by specifying the supplier, accumulator, combiner, and
      finisher functions.
    - Supplier: provides a new mutable container (here, ArrayList<String>).
    - Accumulator: defines how each element is added to the container (here, ArrayList::add). The first argument of the
      BiConsumer becomes the container, and the second is the element from the stream.
    - Combiner: defines how two containers are merged in parallel streams (here, adding all elements from one list into
      another and returning the first list).
    - Finisher: transforms the container into the final result; Function.identity() returns the container as-is.
    - Useful for building custom reductions when standard collectors do not provide the desired behavior.
    - Works with both sequential and parallel streams.
    - Output: A,B,C
    */
    resultList = Stream.of("A", "B", "C").collect(Collector.of(
            ArrayList<String>::new,
            ArrayList::add,
            (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            },
            Function.identity() // Same as: x -> x
    ));
    IO.println(resultList);
}