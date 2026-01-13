/*
 * Arrays
 * - This section explains arrays in Java, which are fixed-size, ordered collections of elements of the same type.
 *
 * Overview
 * - Arrays store multiple values under a single variable name.
 * - Variables of array type hold references to array objects, not the elements themselves.
 * - Arrays can hold primitives or object references and support multidimensional structures.
 *
 * Key Characteristics
 * - Fixed length defined at creation; cannot be resized.
 * - Elements accessed and modified via zero-based indices.
 * - Use the "length" property to get the size of the array.
 * - Multidimensional arrays are arrays of arrays, enabling nested data structures.
 * - Use "Arrays.toString()" to get a String representation of an array.
 *
 * Usage
 * - Use arrays to store multiple related values of the same type efficiently.
 * - Ideal for performance-critical operations where a fixed-size collection is sufficient.
 * - Combine with loops or enhanced for-each statements for iteration and manipulation.
 * - Use arrays when the number of elements is known in advance or when indexed access is needed.
 */
void main() {
    /*
     * Declaration
     * - Declares an array variable and allocates memory to hold a fixed number of elements.
     * - The size of the array is specified inside the square brackets, which determines its length.
     * - Once declared, the array can store elements of the specified type, accessible by index.
     * - Output: [0, 0, 0]
     */
    int[] array = new int[3];

    /*
     * Representation
     * - In Java, arrays cannot be printed directly like collections or lists.
     * - Printing an array directly will output its type and hash code instead of its contents.
     * - To display array contents in a readable form, use "Arrays.toString(array)".
     * - Output: [0, 0, 0]
     */
    array = new int[3];
    IO.println(Arrays.toString(array));

    /*
     * Initialization
     * - Declares and initializes an array in a single step with specific values.
     * - The length of the array is inferred from the number of elements provided.
     * - Output: [1, 2, 3]
     */
    array = new int[] {1, 2, 3};
    IO.println(Arrays.toString(array));

    /*
     * Element Assignment
     * - Assigns or updates values for individual elements in the array using their index.
     * - Each element can be accessed and modified by specifying its position, starting from 0.
     * - Output: [1, 2, 3]
     */
    array = new int[3];
    array[0] = 1;
    array[1] = 2;
    array[2] = 3;
    IO.println(Arrays.toString(array));

    /*
     * Indexing
     * - Array elements are accessed using their index, starting from 0.
     * - Attempting to access an index outside the valid range will throw an ArrayIndexOutOfBoundsException.
     */
    array = new int[] {1, 2, 3};
    IO.println(array[0]); // 1
    IO.println(array[1]); // 2
    IO.println(array[2]); // 3

    /*
     * Length
     * - The length property of an array indicates the number of elements it can hold.
     * - It is accessed using "arrayName.length" and is useful for iteration and bounds checking.
     * - Output: 3
     */
    array = new int[] {1, 2, 3};
    IO.println(array.length);

    /*
     * Iterating (for)
     * - We can iterate over arrays using a standard for loop, accessing each element by its index.
     * - This approach gives full control over the index, which can be useful for formatting or performing operations
     *   that depend on the position of elements.
     * - Output: 0:A | 1:B | 2:C
     */
    char[] charArray = new char[] {'A', 'B', 'C'};
    for (int i = 0; i < charArray.length; i++) {
        IO.println(i + ":" + charArray[i]);
    }

    /*
     * Iterating (for each)
     * - We can iterate over arrays using a for-each loop, which automatically accesses each element in sequence without
     *   requiring an index.
     * - This approach is simpler and more readable when the index is not needed.
     * - Output: A | B | C
     */
    charArray = new char[] {'A', 'B', 'C'};
    for (char ch : charArray) {
        IO.println(ch);
    }
}