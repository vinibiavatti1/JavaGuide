/*
 * Maps and Streams
 * - This section explains how to work with the "Map" interface in Java using the Stream API.
 *
 * Overview
 * - Maps do not directly implement the Collection interface, so they do not have a stream() method.
 * - To perform stream operations, you must use the map collections:
 *   - keySet(): to stream the keys.
 *   - values(): to stream the values.
 *   - entrySet(): to stream Map.Entry objects for both keys and values.
 *
 * Key Characteristics
 * - Enables functional-style operations such as map, filter, reduce, and forEach on map data.
 * - Supports processing keys, values, or entries independently or together.
 * - Useful for transforming, aggregating, or filtering map contents in a concise and readable way.
 *
 * Usage
 * - Use "keySet().stream()" when operations concern only keys.
 * - Use "values().stream()" when operations concern only values.
 * - Use "entrySet().stream()" when both key and value are needed.
 * - Apply stream operations to maps for functional-style processing without explicit iteration.
 * - Useful in combination with map transformations, filters, and collectors for flexible data manipulation.
 */
void main() {
    /*
     * Key Set Stream
     * - The "keySet().stream()" method creates a Stream of the keys from a Map.
     * - Useful for performing functional-style operations on just the keys of a map.
     * - Output: A | B | C
     */
    Map<String, Integer> map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
    map.keySet().stream().forEach(IO::println);

    /*
     * Value Stream
     * - The "values().stream()" method creates a Stream of the values from a Map.
     * - Useful for performing functional-style operations on just the values of a map.
     * - Output: 1 | 2 | 3
     */
    map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
    map.values().stream().forEach(IO::println);

    /*
     * Entry Set Stream
     * - The "entrySet().stream()" method creates a Stream of Map.Entry objects from a Map.
     * - Useful for performing functional-style operations on both keys and values together.
     * - Output: A=1 | B=2 | C=3
     */
    map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
    map.entrySet().stream().forEach(IO::println);
}