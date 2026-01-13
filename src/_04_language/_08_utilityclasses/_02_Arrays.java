/*
 * Arrays
 * - This section explains the "Arrays" utility class in Java, which provides static methods to operate on arrays,
 *   including searching, sorting, copying, and transforming array data efficiently.
 *
 * Overview
 * - The "Arrays" class is part of the java.util package.
 * - It contains static utility methods for array manipulation, comparison, hashing, string representation, and
 *   stream creation.
 * - Introduced in early Java versions and continuously expanded, including enhancements for parallel operations in
 *   Java 8.
 *
 * Key Characteristics
 * - All methods are static; no need to create an Arrays instance.
 * - Supports sorting, searching, and copying arrays (including ranges and parallel operations).
 * - Provides equality and hash code methods for arrays, including deep operations.
 * - Allows filling and computing array elements with fill, setAll, and parallelSetAll.
 * - Includes utilities for string representation, conversion to streams, and spliterator access.
 *
 * Usage
 * - Use Arrays to perform common operations on arrays in a clean and consistent way.
 * - Ideal for sorting, searching, copying, and filling arrays without writing boilerplate loops.
 * - Apply when you need hash codes, equality checks, or string representations for arrays.
 * - Useful in combination with streams, parallel operations, and functional-style processing.
 */
void main() {
    //==================================================================================================================
    // Representation
    //==================================================================================================================

    /*
     * Array String Representation
     * - The "Arrays.toString" method returns a readable string representation of a one-dimensional array.
     * - Elements are listed in order and enclosed in square brackets.
     * - Suitable for logging and debugging simple arrays.
     * - Output: [1, 2, 3]
     */
    int[] intArray = new int[] {1, 2, 3};
    IO.println(Arrays.toString(intArray));

    /*
     * Multidimensional Array String Representation
     * - The "Arrays.deepToString" method returns a readable string representation of nested arrays.
     * - Recursively processes inner arrays to display their contents.
     * - Required for multidimensional arrays to avoid printing memory references.
     * - Output: [[1, 2], [3, 4]]
     */
    int[][] matrix = new int[][] {{1, 2}, {3, 4}};
    IO.println(Arrays.deepToString(matrix));

    //==================================================================================================================
    // Conversion
    //==================================================================================================================

    /*
     * Convert Object Array to List
     * - Arrays.asList converts an intArray of objects into a fixed-size List.
     * - Works directly for object arrays (e.g., String[], Integer[]).
     * - Modifications to the list reflect in the underlying intArray.
     * - Note: if a primitive intArray (e.g., int[]) is passed, it is treated as a single element, resulting in a list
     *   containing the entire intArray instead of individual elements.
     * - Output: [A, B, C]
     */
    String[] strArray = new String[] {"A", "B", "C"};
    IO.println(Arrays.asList(strArray));

    /*
     * Convert Primitive Array to List
     * - Primitive arrays (e.g., int[], double[]) cannot be passed directly to Arrays.asList.
     * - They are treated as a single object, resulting in a list of one element (the intArray itself).
     * - Use Arrays.stream(intArray).boxed().toList() to create a proper List of wrapper objects.
     * - Output: [1, 2, 3]
     */
    intArray = new int[] {1, 2, 3};
    IO.println(Arrays.stream(intArray).boxed().toList());

    //==================================================================================================================
    // Common Operations
    //==================================================================================================================

    /*
     * Binary Search
     * - The "Arrays.binarySearch" method searches for a specified element in a sorted array.
     * - Uses the binary search algorithm, dividing the array into halves to locate the element efficiently.
     * - Returns the index of the element if found; otherwise, returns (-(insertion point) - 1).
     * - Supports optional range parameters and a custom comparator for flexible behavior.
     * - Note: The array MUST BE SORTED for correct results; otherwise, the outcome is undefined.
     * - Output: 1
     */
    char[] charArray = new char[] {'A', 'B', 'C'};
    IO.println(Arrays.binarySearch(charArray, 'B'));

    /*
     * Mismatch Index
     * - The "Arrays.mismatch" method returns the index of the first differing element between two arrays.
     * - Arrays are compared element by element from the beginning.
     * - Returns -1 if the arrays are equal.
     * - Supports optional range parameters and a custom comparator for flexible behavior.
     * - Output: 2
     */
    int[] a = new int[] {1, 2, 3, 4, 5};
    int[] b = new int[] {1, 2, 9, 4, 5};
    IO.println(Arrays.mismatch(a, b));

    /*
     * Sort Array
     * - The "Arrays.sort" method sorts the entire array in ascending order.
     * - For primitive arrays, it uses a highly optimized Dual-Pivot Quicksort.
     * - The sorting is done in-place, modifying the original array.
     * - Supports optional range parameters and a custom comparator for flexible behavior.
     * - The "Arrays.parallelSort()" method can be used to improve performance dividing the work across multiple
     *   threads.
     * - Output: [1, 2, 3]
     */
    intArray = new int[] {3, 2, 1};
    Arrays.sort(intArray);
    IO.println(Arrays.toString(intArray));

    /*
     * Fill Array
     * - The "Arrays.fill" method assigns the specified value to every element of the array.
     * - Useful for initialization or resetting array contents.
     * - Supports optional range parameters for flexible behavior.
     * - Output: [9, 9, 9]
     */
    intArray = new int[3];
    Arrays.fill(intArray, 9);
    IO.println(Arrays.toString(strArray));

    /*
     * Copy an Entire Array
     * - The "Arrays.copyOf" method creates a new array of the specified length and copies elements from the original
     *   array.
     * - The "Arrays.copyOfRange" can be used to copy only a specific range.
     * - If the new length is greater than the original array, extra elements are initialized with default values.
     * - Output: [1, 2, 3]
     */
    intArray = new int[] {1, 2, 3};
    int[] copy = Arrays.copyOf(intArray, 3);
    IO.println(Arrays.toString(copy));

    /*
     * Compute and Set All Elements
     * - The "Arrays.setAll" method assigns each element of the array using a computation.
     * - The provided function receives the element index, not the element value.
     * - Computation is performed sequentially.
     * - The "Arrays.parallelSetAll()" method can be used to improve performance dividing the work across multiple
     *   threads.
     * - Output: [0, 2, 4]
     */
    intArray = new int[3];
    Arrays.setAll(intArray, index -> index * 2);
    IO.println(Arrays.toString(intArray));

    /*
     * Parallel Prefix (Cumulative Operation)
     * - The "Arrays.parallelPrefix" method performs a cumulative operation on the array elements.
     * - Each element is replaced by the result of applying the given binary operator to all previous elements.
     * - The computation is executed in parallel using the Fork/Join framework.
     * - Useful for prefix sums, cumulative products, and similar operations.
     * - Supports optional range parameters for flexible behavior.
     * - Output: [0, 1, 3, 6]
     */
    intArray = new int[] {0, 1, 2, 3};
    Arrays.parallelPrefix(intArray, Integer::sum);
    IO.println(Arrays.toString(intArray));

    //==================================================================================================================
    // Iterators
    //==================================================================================================================

    /*
     * Spliterator
     * - The "Arrays.spliterator" method creates a Spliterator over the array elements.
     * - Spliterator supports sequential and parallel traversal, bulk operations, and splitting for parallel processing.
     * - Useful for advanced iteration patterns, streams, and parallel computations.
     * - Output: 1 | 2 | 3
     */
    intArray = new int[] {1, 2, 3};
    Spliterator.OfInt spliterator = Arrays.spliterator(intArray);
    spliterator.forEachRemaining((int el) -> IO.println(el));

    /*
     * Stream from Array
     * - The "Arrays.stream" method creates a sequential IntStream from a primitive int array.
     * - Streams allow functional-style operations like map, filter, and forEach.
     * - Output: 1 | 2 | 3
     */
    intArray = new int[] {1, 2, 3};
    Arrays.stream(intArray).forEach(IO::println);

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
     * Equals
     * - The "Arrays.equals" method compares two arrays for equality.
     * - Arrays are considered equal if they have the same length and all corresponding elements are equal.
     * - For primitive arrays, values are compared directly.
     * - For object arrays, equals() is used on each element (shallow comparison).
     * - Output: true
     */
    a = new int[] {1, 2, 3};
    b = new int[] {1, 2, 3};
    IO.println(Arrays.equals(a, b));

    /*
     * Deep Equals
     * - The "Arrays.deepEquals" method performs a deep comparison of two object arrays.
     * - Recursively compares nested arrays, making it suitable for multidimensional arrays.
     * - For non-array elements, equals() is used.
     * - Output: true
     */
    int[][] x = new int[][] {{1, 2}, {3, 4}};
    int[][] y = new int[][] {{1, 2}, {3, 4}};
    IO.println(Arrays.deepEquals(x, y));

    /*
     * Compare Two Arrays
     * - The "Arrays.compare" method compares two arrays lexicographically.
     * - Returns a negative integer, zero, or a positive integer if the first array is less than, equal to, or greater
     *   than the second array.
     * - Works element by element, stopping at the first difference.
     * - Supports optional range parameters and a custom comparator for flexible behavior.
     * - Output: 0 (equal)
     */
    a = new int[] {1, 2, 3};
    b = new int[] {1, 2, 3};
    IO.println(Arrays.compare(a, b));

    /*
     * Hash Code
     * - The "Arrays.hashCode" method computes a hash code based on the contents of the array.
     * - For primitive arrays, the hash is calculated from the values of the elements.
     * - Two arrays with the same contents will produce the same hash code.
     * - Output: 30817
     */
    intArray = new int[] {1, 2, 3};
    IO.println(Arrays.hashCode(intArray));

    /*
     * Deep Hash Code
     * - The "Arrays.deepHashCode" method computes a hash code for nested (multidimensional) arrays.
     * - Recursively incorporates the hash codes of inner arrays.
     * - Ensures consistent hashing for complex array structures.
     * - Output: 32833
     */
    matrix = new int[][] {{1, 2}, {3, 4}};
    IO.println(Arrays.deepHashCode(matrix));
}